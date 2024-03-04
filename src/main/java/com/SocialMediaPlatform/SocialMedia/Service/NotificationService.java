package com.SocialMediaPlatform.SocialMedia.Service;

import com.SocialMediaPlatform.SocialMedia.Repository.NotificationRepo;
import com.SocialMediaPlatform.SocialMedia.Repository.PlatformUserRepo;
import com.SocialMediaPlatform.SocialMedia.Repository.PostByUserRepo;
import com.SocialMediaPlatform.SocialMedia.models.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NotificationService {
    @Autowired
    PlatformUserRepo platformUserRepo;
    @Autowired
    NotificationRepo notificationRepo;
    @Autowired
    PostByUserRepo postRepo;
    public String add(int postId,int platformUserId){
        Date d = new Date();
        Notification n = new Notification();
        n.setPostId(postId);
        n.setTime(d);
        notificationRepo.save(n);

        //To send a response as a notification
        String s = d.toString();
        String arr[] = s.split(" ");
        String timeStr = arr[3];
        String timeArr[] = timeStr.split(":");
        int hours = Integer.parseInt(timeArr[0]);
        hours = 24-hours;
        int mins = Integer.parseInt(timeArr[1]);
        String resultTime = hours+":"+mins;
        String likedBy = platformUserRepo.findById(platformUserId).orElse(null).getName();
        String resultNotification = "Your Post is liked by "+likedBy+"at "+resultTime;
        return resultNotification;
    }
}
