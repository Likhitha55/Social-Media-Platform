package com.SocialMediaPlatform.SocialMedia.Repository;

import com.SocialMediaPlatform.SocialMedia.models.PostByUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostByUserRepo extends JpaRepository<PostByUser,Integer> {
}
