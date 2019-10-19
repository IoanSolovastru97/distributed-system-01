package com.example.springdemo.entities;

import javax.persistence.*;

@Entity
@Table(name = "intake_interval")
public class IntakeInterval {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "start_interval")
    private String startInterval;

    @Column(name = "end_interval")
    private String endInterval;

    public IntakeInterval(String startInterval, String endInterval) {
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
