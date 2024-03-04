package com.SocialMediaPlatform.SocialMedia.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Notification {
    @Id
    int notificationId;
    int postId;
    Date time;
}
