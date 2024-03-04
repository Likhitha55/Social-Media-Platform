package com.SocialMediaPlatform.SocialMedia.Repository;

import com.SocialMediaPlatform.SocialMedia.models.PlatformUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformUserRepo extends JpaRepository<PlatformUser, Integer> {
}
