package com.example.springdemo.dto;

public class ActivityDTO {

    private Integer id ;
    private String patientUsername;
    private String activity;
    private String startActivity;
    private String endActivity;

    public ActivityDTO(String patientUsername, String activity, String startActivity, String endActivity) {
        this.patientUsername = patientUsername;
        this.activity = activity;
        this.startActivity = startActivity;
        this.endActivity = endActivity;
    }

    public ActivityDTO(Integer id, String patientUsername, String activity, String startActivity, String endActivity) {
        this.id = id;
        this.patientUsername = patientUsername;
        this.activity = activity;
        this.startActivity = startActivity;
        this.endActivity = endActivity;
    }

    public ActivityDTO() {
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
}
