package com.SocialMediaPlatform.SocialMedia.Controller;

import com.SocialMediaPlatform.SocialMedia.Repository.PlatformUserRepo;
import com.SocialMediaPlatform.SocialMedia.Service.PlatformUserService;
import com.SocialMediaPlatform.SocialMedia.models.PlatformUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/platform")
public class PlatformUserController {
    @Autowired
    PlatformUserService platformUserService;
    @PostMapping("/add-user")
    public void addPlatformUser(@RequestBody PlatformUser platformUser){
        platformUserService.addPlatformUser(platformUser);
    }
}
