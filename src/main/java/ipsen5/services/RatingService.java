package ipsen5.services;

import ipsen5.dto.RatingDTO;
import ipsen5.models.*;
import ipsen5.repository.RatingRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class RatingService {
    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }
    public List<Rating> getAllRatings() {
        return this.ratingRepository.findAll();
    }

    public void createRating(RatingDTO ratingDTO) {
        RatingId ratingId = new RatingId(ratingDTO.user_id, ratingDTO.post_id);
        this.ratingRepository.save(new Rating(ratingId, ratingDTO.grade));
    }

    public void editRating(User userId, Post postId, RatingDTO ratingDTO) {
        RatingId ratingId = new RatingId(userId, postId);
        Rating rating = this.ratingRepository.findById(ratingId)
                .orElseThrow(() -> new RuntimeException("Rating not found"));

        rating.setGrade(ratingDTO.grade);
        rating.setId(ratingId);
        this.ratingRepository.save(rating);
    }

    public void deleteRating(User userId, Post postId) {
        RatingId ratingId = new RatingId(userId, postId);
        this.ratingRepository.findById(ratingId).orElseThrow(() -> new RuntimeException("Rating not found"));
        this.ratingRepository.deleteById(ratingId);
    }

    public List<Rating> getAllRatingsByPostId(UUID postId) {
        return this.ratingRepository.findRatingsByPostId(postId);
    }
}
