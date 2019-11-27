package com.example.springdemo.services;

import com.example.springdemo.entities.*;
import com.example.springdemo.grpc.Medicalplan;
import com.example.springdemo.grpc.medicalPlanGrpc;
import com.example.springdemo.repositories.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class MedicalPlanService extends medicalPlanGrpc.medicalPlanImplBase {

    private static final Logger LOGGER = Logger.getLogger(MedicalPlanService.class.getName());

    @Autowired
    private PatientRepository patientRepository;

    public void startGRPC() throws IOException, InterruptedException {
        //Create GRPC server
        Server server = ServerBuilder.forPort(9090).addService(this).build();
        server.start();
        System.out.println("Server started at port: " + server.getPort());
        server.awaitTermination();
    }

    /**
     * Whenever the client calls these method, the request will be handle here
     */
    @Override
    public void getMedicalPlan(Medicalplan.PatientUsername request, StreamObserver<Medicalplan.MedicalRecord> responseObserver) {
        LOGGER.log(Level.INFO, "Entered getMedicalPlan() GRPC");

        Optional<Patient> patient = patientRepository.findById(request.getPatientUsername());
        List<MedicalRecord> medicalRecords = patient.get().getMedicalRecords();


        if (medicalRecords.size() > 0) {
            MedicalRecord medicalRecord = dummyMedicalRecord();

            //create the response
            Medicalplan.MedicalRecord.Builder response = Medicalplan.MedicalRecord.newBuilder();
            response.setId(medicalRecord.getId());

            for (Drug drug : medicalRecord.getDrugs()) {
                Medicalplan.Drug.Builder drugBuilder = Medicalplan.Drug.newBuilder()
                        .setId(drug.getId())
                        .setName(drug.getName())
                        .setDescription(drug.getDescription())
                        .setDrugSideEffect(Medicalplan.DrugSideEffect.newBuilder()
                                .setId(drug.getDrugSideEffect().getId())
                                .setDescription(drug.getDrugSideEffect().getDescription()));
                response.addDrug(drugBuilder);
            }

            for (IntakeInterval intakeInterval : medicalRecord.getIntakeIntervals()) {
                Medicalplan.IntakeInterval.Builder intake = Medicalplan.IntakeInterval.newBuilder()
                        .setId(intakeInterval.getId())
                        .setStartInterval(intakeInterval.getStartInterval())
                        .setEndInterval(intakeInterval.getEndInterval());
                response.addIntakeInterval(intake);
            }

            //send it back to the client
            responseObserver.onNext(response.build());
            responseObserver.onCompleted(); //close the call
        } else {
            LOGGER.log(Level.WARNING, "Medical Records empty");
        }


    }


    @Override
    public void informServer(Medicalplan.MedicationName request, StreamObserver<Medicalplan.Empty> responseObserver) {
        LOGGER.log(Level.INFO, "Entered informServer() GRPC");

        System.out.println("********** MEDICAITON " + request.getMedicationName() + " NOT TAKEN ********");
        Medicalplan.Empty.Builder response = Medicalplan.Empty.newBuilder();
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    public MedicalRecord dummyMedicalRecord() {
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setId(1);
        medicalRecord.setPeriod("2018-2019");
        medicalRecord.setDoctor(new Doctor());
        medicalRecord.setPatient(new Patient());
        List<Drug> drugs = new ArrayList<>();
        drugs.add(new Drug(0, "Paracetamol", "Helps for headache", new DrugSideEffect(0, "description")));
        drugs.add(new Drug(1, "Algocalmin", "Helps for headache", new DrugSideEffect(1, "description")));
        medicalRecord.setDrugs(drugs);
        List<IntakeInterval> intakeIntervals = new ArrayList<>();
        intakeIntervals.add(new IntakeInterval(1, "08:00", "10:00"));
        intakeIntervals.add(new IntakeInterval(2, "08:00", "09:00"));
        medicalRecord.setIntakeIntervals(intakeIntervals);

        return medicalRecord;
    }
}
