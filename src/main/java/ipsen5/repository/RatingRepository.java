package ipsen5.repository;

import ipsen5.models.Rating;
import ipsen5.models.RatingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface RatingRepository extends JpaRepository<Rating, RatingId>{
    @Transactional
    void deleteRatingById(RatingId id);

    @Query("SELECT r FROM Rating r WHERE r.id.post_id.id = :postId")
    List<Rating> findRatingsByPostId(@Param("postId") UUID postId);

    void deleteByPostId(UUID id);
}
