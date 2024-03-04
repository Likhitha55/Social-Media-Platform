package com.SocialMediaPlatform.SocialMedia.Controller;

import com.SocialMediaPlatform.SocialMedia.Service.PostByUserService;
import com.SocialMediaPlatform.SocialMedia.models.PlatformUser;
import com.SocialMediaPlatform.SocialMedia.models.PostByUser;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/platform")
public class PostByUserController {
    @Autowired
    PostByUserService postByUserService;
    @PostMapping("/add-post")
    public void addPost(@RequestBody PostByUser post){
        postByUserService.addPost(post);
    }
    @PutMapping("/like-post")
    public String likePost(@RequestParam int postId,@RequestParam int platformUserId){
        return postByUserService.likePost(postId,platformUserId);
    }
    @GetMapping("/get-most-likes-post")
    public PlatformUser getMostLikedPost(){
        return postByUserService.getMostLikedPost();
    }
}
