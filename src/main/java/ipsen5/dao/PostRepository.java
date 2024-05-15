package ipsen5.dao;

import ipsen5.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID>{
    @Transactional
    void deletePostById(UUID id);
}


