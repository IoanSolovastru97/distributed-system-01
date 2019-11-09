package com.example.springdemo.controller;

import com.example.springdemo.dto.ActivityDTO;
import com.example.springdemo.services.ActivityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin
@Slf4j
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/activity")
    @SendTo("/topic/activity")
    public ActivityDTO sendActivityNotification(ActivityDTO activityDTO) {
        System.out.println("******");
        return activityDTO;
    }
}
