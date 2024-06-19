package ipsen5.utils;

import ipsen5.repository.PostRepository;
import ipsen5.repository.RatingRepository;
import ipsen5.repository.UserRepository;
import ipsen5.models.Post;
import ipsen5.models.Rating;
import ipsen5.models.RatingId;
import ipsen5.models.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class RatingSeeder {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final RatingRepository ratingRepository;

    public RatingSeeder(UserRepository userRepository, PostRepository postRepository, RatingRepository ratingRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.ratingRepository = ratingRepository;
    }

    public void seedRating(){
        List<Post> allPosts = postRepository.findAll();
        List<User> allUsers = userRepository.findAll();
        Random random = new Random();

        for (int i = 0; i < allPosts.size(); i++) {
            for (int j = 0; j < 3; j++) {
                RatingId ratingId = new RatingId(allUsers.get(j), allPosts.get(i));
                Rating rating = new Rating();
                rating.setId(ratingId);
                int grade = random.nextInt(5) + 1;
                rating.setGrade(grade);
                ratingRepository.save(rating);
            }
        }
    }
}
