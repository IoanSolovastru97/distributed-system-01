package com.example.springdemo.endpoint;

import com.example.springdemo.dto.UserDTO;
import com.example.springdemo.dto.builders.ActivityBuilder;
import com.example.springdemo.dto.builders.DoctorBuilder;
import com.example.springdemo.dto.builders.UserBuilder;
import com.example.springdemo.repositories.ActivityRepository;
import com.example.springdemo.services.ActivityService;
import com.example.springdemo.services.DoctorService;
import com.example.springdemo.services.UserService;
import com.example.springdemo.soap.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Endpoint()
public class ActivityEndpoint {

    @Autowired
    private ActivityRepository activityRepository;

    @PayloadRoot(namespace = "http://example.com/springdemo/soap",
            localPart = "getActivitiesRequest")
    @ResponsePayload
    public GetActivitiesResponse getActivitiesRequest(@RequestPayload GetActivitiesRequest request) {
        GetActivitiesResponse response = new GetActivitiesResponse();
        response.getActivity().addAll(getActivitiesFromUser(request));
        return response;
    }

    private List<Activity> getActivitiesFromUser(GetActivitiesRequest request) {
        String username = request.getUsername();
        List<com.example.springdemo.entities.Activity> activities = activityRepository
                .findAll()
                .stream()
                .filter(a -> a.getPatientUsername().equals(username))
                .collect(Collectors.toList());
        return activities
                .stream()
                .map(ActivityBuilder::generateToSoap)
                .collect(Collectors.toList());
    }


}
