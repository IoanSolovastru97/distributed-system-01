package com.example.springdemo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "patient_username")
    private String patientUsername;

    @Column(name = "activity")
    private String activity;

    @Column(name = "start_activity")
    private String startActivity;

    @Column(name = "end_activity")
    private String endActivity;

    @Column(name = "recommendation")
    private String recommendation;

    //JsonProperty is needed for deserialization, alternative of using empty Constructor and non final fields
    public Activity(@JsonProperty("patientUsername") String patientUsername,
                    @JsonProperty("activity") String activity,
                    @JsonProperty("startActivity") String startActivity,
                    @JsonProperty("endActivity") String endActivity) {
        this.patientUsername = patientUsername;
        this.activity = activity;
        this.startActivity = startActivity;
        this.endActivity = endActivity;
    }

    public Activity(Integer id, String patientUsername, String activity, String startActivity, String endActivity) {
        this.id = id;
        this.patientUsername = patientUsername;
        this.activity = activity;
        this.startActivity = startActivity;
        this.endActivity = endActivity;
    }

    public Activity(Integer id, String patientUsername, String activity, String startActivity, String endActivity, String recommendation) {
        this.id = id;
        this.patientUsername = patientUsername;
        this.activity = activity;
        this.startActivity = startActivity;
        this.endActivity = endActivity;
        this.recommendation = recommendation;
    }

    public Activity() {
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatientUsername() {
        return patientUsername;
    }

    public void setPatientUsername(String patientUsername) {
        this.patientUsername = patientUsername;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getStartActivity() {
        return startActivity;
    }

    public void setStartActivity(String startActivity) {
        this.startActivity = startActivity;
    }

    public String getEndActivity() {
        return endActivity;
    }

    public void setEndActivity(String endActivity) {
        this.endActivity = endActivity;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "patientUsername='" + patientUsername + '\'' +
                ", activity='" + activity + '\'' +
                ", startActivity='" + startActivity + '\'' +
                ", endActivity='" + endActivity + '\'' +
                '}';
    }
}
