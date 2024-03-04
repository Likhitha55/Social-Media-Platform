package com.SocialMediaPlatform.SocialMedia.Repository;

import com.SocialMediaPlatform.SocialMedia.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepo extends JpaRepository<Notification,Integer> {
}
