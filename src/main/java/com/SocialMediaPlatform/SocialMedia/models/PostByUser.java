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
public class PostByUser {
    @Id
    int postId;
    Date time;
    int platformUserId;
    int like;
}
