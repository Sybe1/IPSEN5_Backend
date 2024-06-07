package ipsen5.dao;

import ipsen5.models.Post;
import ipsen5.models.SocialMedia;
import ipsen5.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SocialMediaRepository extends JpaRepository<SocialMedia, UUID> {
    List<SocialMedia> findByUser(User user);
}
