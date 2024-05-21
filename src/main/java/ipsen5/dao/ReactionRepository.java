package ipsen5.dao;

import ipsen5.models.Reaction;
import ipsen5.models.Rubric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction, UUID> {
    List<Reaction> findByPost_id(UUID postId);
}
