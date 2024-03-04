package com.SocialMediaPlatform.SocialMedia.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PlatformUser {
    @Id
    int platformUserId;
    String name;
    int age;

    @OneToMany
    List<PostByUser> posts;

    @OneToMany
    List<Notification> notifications;
}
