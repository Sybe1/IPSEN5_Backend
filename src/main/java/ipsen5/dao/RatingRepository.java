package ipsen5.dao;

import ipsen5.models.Category;
import ipsen5.models.Post;
import ipsen5.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface RatingRepository extends JpaRepository<Rating, UUID>{
    @Transactional
    void deleteRatingById(UUID id);

}
