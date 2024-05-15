package ipsen5.dao;

import ipsen5.models.Post;
import ipsen5.models.Rubric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RubricRepository extends JpaRepository<Rubric, UUID> {
}
