package ipsen5.utils;

import ipsen5.dao.PostRepository;
import ipsen5.dao.SubmissionRespository;
import ipsen5.dao.UserRepository;
import ipsen5.models.Post;
import ipsen5.models.Submission;
import ipsen5.models.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubmissionSeeder {
    private SubmissionRespository submissionRespository;
    private UserRepository userRepository;
    private PostRepository postRepository;

    public SubmissionSeeder(SubmissionRespository submissionRespository, UserRepository userRepository, PostRepository postRepository) {
        this.submissionRespository = submissionRespository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public void seedSubmission(){
        List<User> allUsers = userRepository.findAll();
        List<Post> allPosts = postRepository.findAll();

    }
}
