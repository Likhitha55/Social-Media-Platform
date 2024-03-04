package com.SocialMediaPlatform.SocialMedia.Service;

import com.SocialMediaPlatform.SocialMedia.Repository.NotificationRepo;
import com.SocialMediaPlatform.SocialMedia.Repository.PlatformUserRepo;
import com.SocialMediaPlatform.SocialMedia.Repository.PostByUserRepo;
import com.SocialMediaPlatform.SocialMedia.models.Notification;
import com.SocialMediaPlatform.SocialMedia.models.PlatformUser;
import com.SocialMediaPlatform.SocialMedia.models.PostByUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostByUserService {
    @Autowired
    NotificationService notificationService;
    @Autowired
    NotificationRepo notificationrepo;

    @Autowired
    PostByUserRepo postRepo;
    @Autowired
    PlatformUserRepo platformUserRepo;
    public void addPost(PostByUser postByUser){
        PostByUser pbu = new PostByUser();
        pbu.setPostId(postByUser.getPostId());
        pbu.setTime(new Date());
        pbu.setPlatformUserId(postByUser.getPlatformUserId());
        postRepo.save(pbu);

        List<PostByUser> allposts;
        allposts = new ArrayList<>();
        allposts = platformUserRepo.findById(postByUser.getPlatformUserId()).orElse(null).getPosts();
        allposts.add(pbu);
        platformUserRepo.findById(postByUser.getPlatformUserId()).orElse(null).setPosts(allposts);
    }

    public String likePost(int postId,int platformUserId){
        PostByUser post = postRepo.findById(postId).orElse(null);
        int likes = post.getLike();
        likes+=1;
        post.setLike(likes);

        //Sending notification right after the like
        return notificationService.add(postId,platformUserId);


    }

    public PlatformUser getMostLikedPost(){
        List<PostByUser> allPosts = postRepo.findAll();
        int mostLikedPost = Integer.MIN_VALUE;
        PlatformUser resultUser = new PlatformUser();
        int resultUserId=0;
        for(PostByUser p : allPosts){
            int curr = p.getLike();
            if(curr > mostLikedPost){
                curr=mostLikedPost;
                resultUserId = p.getPlatformUserId();
            }
        }
        resultUser = platformUserRepo.findById(resultUserId).orElse(null);
        return resultUser;
    }
}
