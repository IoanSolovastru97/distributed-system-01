package com.example.springdemo.endpoint;

import com.example.springdemo.dto.UserDTO;
import com.example.springdemo.dto.builders.DoctorBuilder;
import com.example.springdemo.dto.builders.MedicalRecordBuilder;
import com.example.springdemo.dto.builders.UserBuilder;
import com.example.springdemo.services.DoctorService;
import com.example.springdemo.services.PatientService;
import com.example.springdemo.services.UserService;
import com.example.springdemo.soap.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.stream.Collectors;


@Endpoint()
public class DoctorEndpoint {

    @Autowired
    private UserService userService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;


    @PayloadRoot(namespace = "http://example.com/springdemo/soap",
            localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        if (checkCredentials(request.getUsername(), request.getPassword())) {
            response.setUser(UserBuilder.generateDTOToSoap(userService.findUserById(request.getUsername())));
        }
        return response;
    }


    @PayloadRoot(namespace = "http://example.com/springdemo/soap",
            localPart = "getDoctorRequest")
    @ResponsePayload
    public GetDoctorResponse getDoctorRequest(@RequestPayload GetDoctorRequest request) {
        GetDoctorResponse response = new GetDoctorResponse();
        if (checkCredentials(request.getUsername(), request.getPassword())) {
            response.setDoctor(DoctorBuilder.generateDTOToSoap(doctorService.findById(request.getUsername())));
        }
        return response;
    }


    /* Helpers */
    private boolean checkCredentials(String username, String password) {
        UserDTO userDTO = userService.findUserById(username);
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return userDTO != null && encoder.matches(password, userDTO.getPassword());
    }

    @PayloadRoot(namespace = "http://example.com/springdemo/soap",
            localPart = "getMedicalrecordRequest")
    @ResponsePayload
    public GetMedicalrecordResponse getMedicalrecordRequest(@RequestPayload GetMedicalrecordRequest request) {
        GetMedicalrecordResponse response = new GetMedicalrecordResponse();
        response.getMedicalrecord().addAll(patientService.findById(request.getUsername())
                .getMedicalRecords()
                .stream()
                .map(MedicalRecordBuilder::generateDTOToSoap)
                .collect(Collectors.toList()));
        return response;
    }

}
