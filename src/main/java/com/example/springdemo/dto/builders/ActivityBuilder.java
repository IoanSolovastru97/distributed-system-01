package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.ActivityDTO;
import com.example.springdemo.dto.DoctorDTO;
import com.example.springdemo.entities.Activity;
import com.example.springdemo.soap.GetActivities;

import java.math.BigDecimal;

public class ActivityBuilder {

    public static ActivityDTO generateDTOFromEntity(Activity activity) {
        return new ActivityDTO(
                activity.getPatientUsername(),
                activity.getActivity(),
                activity.getStartActivity(),
                activity.getEndActivity());
    }

    public static Activity generateEntityFromDTO(ActivityDTO activityDTO) {
        return new Activity(
                activityDTO.getPatientUsername(),
                activityDTO.getActivity(),
                activityDTO.getStartActivity(),
                activityDTO.getEndActivity());
    }

    public static ActivityDTO generateDTOFromEntityWithId(Activity activity) {
        return new ActivityDTO(
                activity.getId(),
                activity.getPatientUsername(),
                activity.getActivity(),
                activity.getStartActivity(),
                activity.getEndActivity());
    }

    public static Activity generateEntityFromDTOWithId(ActivityDTO activityDTO) {
        return new Activity(
                activityDTO.getId(),
                activityDTO.getPatientUsername(),
                activityDTO.getActivity(),
                activityDTO.getStartActivity(),
                activityDTO.getEndActivity());
    }

    public static com.example.springdemo.soap.Activity generateToSoap(Activity activity) {
        com.example.springdemo.soap.Activity activity1 = new com.example.springdemo.soap.Activity();
        activity1.setId(BigDecimal.valueOf(activity.getId()));
        activity1.setActivity(activity.getActivity());
        activity1.setStartActivity(activity.getStartActivity());
        activity1.setEndActivity(activity.getEndActivity());
        activity1.setPatientUsername(activity.getPatientUsername());
        return activity1;
    }
}
