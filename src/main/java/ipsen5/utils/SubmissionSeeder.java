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

        Submission submission = new Submission();
        submission.setText("Er was eens een monster. Die at mensen op!");
        submission.setPost_id(allPosts.get(0));
        submission.setUser_id(allUsers.get(0));
        submissionRespository.save(submission);

        Submission submission2 = new Submission();
        submission2.setText("Dit is een formeel verhaal over hekserij. Vroeger was dit normaal.");
        submission2.setPost_id(allPosts.get(0));
        submission2.setUser_id(allUsers.get(1));
        submissionRespository.save(submission2);

        Submission submission3 = new Submission();
        submission3.setText("Dit is een fanfiction over The Hobbit.");
        submission3.setPost_id(allPosts.get(1));
        submission3.setUser_id(allUsers.get(1));
        submissionRespository.save(submission3);
    }
}
