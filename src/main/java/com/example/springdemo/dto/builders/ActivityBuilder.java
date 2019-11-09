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
}
