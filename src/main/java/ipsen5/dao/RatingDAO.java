package ipsen5.dao;

import ipsen5.dto.PostDTO;
import ipsen5.dto.RatingDTO;
import ipsen5.models.Post;
import ipsen5.models.Rating;
import ipsen5.models.Rubric;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class RatingDAO {
    private final RatingRepository ratingRepository;

    public RatingDAO(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }
    public List<Rating> getAllRatings() {
        return this.ratingRepository.findAll();
    }

    public void createRating(RatingDTO ratingDTO) {
        this.ratingRepository.save(new Rating(ratingDTO.grade, ratingDTO.user_id, ratingDTO.post_id));
    }

    public void editRating(UUID id, RatingDTO ratingDTO) {
        Rating rating = this.ratingRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        rating.setGrade(ratingDTO.grade);
        rating.setUser_id(ratingDTO.user_id);
        rating.setPost_id(ratingDTO.post_id);
        this.ratingRepository.save(rating);
    }

    public void deleteRating(UUID id) {
        this.ratingRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        this.ratingRepository.deleteById(id);
    }

}
