package com.example.springdemo.dto;

public class IntakeIntervalDTO {

    private Integer id;
    private String startInterval;
    private String endInterval;

    public IntakeIntervalDTO(String startInterval, String endInterval) {
        this.startInterval = startInterval;
        this.endInterval = endInterval;
    }

    public IntakeIntervalDTO(Integer id, String startInterval, String endInterval) {
        this.id = id;
        this.startInterval = startInterval;
        this.endInterval = endInterval;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartInterval() {
        return startInterval;
    }

    public void setStartInterval(String startInterval) {
        this.startInterval = startInterval;
    }

    public String getEndInterval() {
        return endInterval;
    }

    public void setEndInterval(String endInterval) {
        this.endInterval = endInterval;
    }
}
