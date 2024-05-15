package ipsen5.utils;

import ipsen5.dao.PostRepository;
import ipsen5.dao.RatingRepository;
import ipsen5.dao.UserRepository;
import ipsen5.models.Post;
import ipsen5.models.Rating;
import ipsen5.models.RatingId;
import ipsen5.models.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RatingSeeder {
    private UserRepository userRepository;
    private PostRepository postRepository;
    private RatingRepository ratingRepository;

    public RatingSeeder(UserRepository userRepository, PostRepository postRepository, RatingRepository ratingRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.ratingRepository = ratingRepository;
    }

    public void seedRating(){
        List<Post> allPosts = postRepository.findAll();
        List<User> allUsers = userRepository.findAll();

        RatingId ratingId = new RatingId(allUsers.get(0), allPosts.get(0));
        Rating rating = new Rating();
        rating.setId(ratingId);
        rating.setGrade(4);
        ratingRepository.save(rating);

        RatingId ratingId2 = new RatingId(allUsers.get(1), allPosts.get(0));
        Rating rating2 = new Rating();
        rating2.setId(ratingId2);
        rating2.setGrade(2);
        ratingRepository.save(rating2);

        RatingId ratingId3 = new RatingId(allUsers.get(2), allPosts.get(0));
        Rating rating3 = new Rating();
        rating3.setId(ratingId3);
        rating3.setGrade(3);
        ratingRepository.save(rating3);
    }
}
