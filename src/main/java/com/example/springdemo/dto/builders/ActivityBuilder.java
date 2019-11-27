package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.ActivityDTO;
import com.example.springdemo.entities.Activity;

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
}
