package com.example.springdemo.services;

import com.example.springdemo.SpringDemoApplication;
import com.example.springdemo.dto.ActivityDTO;
import com.example.springdemo.dto.builders.ActivityBuilder;
import com.example.springdemo.entities.Activity;
import com.example.springdemo.repositories.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class ActivityService {

    private static final String SLEEPING = "Sleeping";
    private static final String LEAVING = "Leaving";
    private static final String BATHROOM_TOILETING = "Toileting";
    private static final String BATHROOM_GROOMING = "Grooming";
    private static final String BATHROOM_SHOWERING = "Showering";
    private static final long ONE_HOUR = 1;
    private static final long TWELVE_HOURS = 12;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @RabbitListener(queues = SpringDemoApplication.QUEUE_SPECIFIC_NAME)
    public void receiveMessage(Activity activity) {
//        activityRepository.save(activity);
        System.out.println(activity.toString());
        simpMessagingTemplate.convertAndSend("/topic/activity", activity);

//        if (filterActivity(activity)) {
//            simpMessagingTemplate.convertAndSend("/topic/activity", activity);
//        }

    }

    private boolean filterActivity(Activity activity) {
        if (activity.equals(SLEEPING) || activity.equals(LEAVING)) {
            return activityDuration(activity) < TWELVE_HOURS;
        } else if (activity.equals(BATHROOM_GROOMING) || activity.equals(BATHROOM_SHOWERING) || activity.equals(BATHROOM_TOILETING)) {
            return activityDuration(activity) < ONE_HOUR;
        }
        return true;
    }

    private long activityDuration(Activity activity) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date start = format.parse(activity.getStartActivity());
            Date end = format.parse(activity.getEndActivity());
            long difference = (end.getTime() - start.getTime()) / 3600000;//hours
            System.out.println(difference);
            return difference;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
