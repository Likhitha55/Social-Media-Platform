package com.SocialMediaPlatform.SocialMedia.Service;

import com.SocialMediaPlatform.SocialMedia.Repository.PlatformUserRepo;
import com.SocialMediaPlatform.SocialMedia.models.PlatformUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatformUserService {
    @Autowired
    PlatformUserRepo platformUserRepo;
    public void addPlatformUser(PlatformUser platformUser){
        PlatformUser pu = new PlatformUser();
        pu.setPlatformUserId(platformUser.getPlatformUserId());
        pu.setName(platformUser.getName());
        pu.setAge(platformUser.getAge());
        platformUserRepo.save(pu);
    }
}
