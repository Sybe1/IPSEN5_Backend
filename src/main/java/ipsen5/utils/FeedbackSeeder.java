package ipsen5.utils;

import ipsen5.dao.FeedbackRepository;
import ipsen5.dao.RubricRepository;
import ipsen5.dao.UserRepository;
import ipsen5.models.Feedback;
import ipsen5.models.Rubric;
import ipsen5.models.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeedbackSeeder {
    private RubricRepository rubricRepository;
    private UserRepository userRepository;
    private FeedbackRepository feedbackRepository;

    public FeedbackSeeder(RubricRepository rubricRepository, UserRepository userRepository, FeedbackRepository feedbackRepository) {
        this.rubricRepository = rubricRepository;
        this.userRepository = userRepository;
        this.feedbackRepository = feedbackRepository;
    }

    public void seedFeedback(){
        List<User> allUsers = userRepository.findAll();
        List<Rubric> allRubrics = rubricRepository.findAll();

        Feedback feedback = new Feedback();
        feedback.setRubric(allRubrics.get(0));
        feedback.setUser(allUsers.get(0));
        feedback.setGeneral_text("The submission is looking good. It has been placed in OFFICIAL SELECTION");
        feedbackRepository.save(feedback);

        Feedback feedback2 = new Feedback();
        feedback2.setRubric(allRubrics.get(1));
        feedback2.setUser(allUsers.get(0));
        feedback2.setGeneral_text("The submission is too short!");
        feedbackRepository.save(feedback2);

        Feedback feedback3 = new Feedback();
        feedback3.setRubric(allRubrics.get(1));
        feedback3.setUser(allUsers.get(1));
        feedback3.setGeneral_text("The submission is not good enough.");
        feedbackRepository.save(feedback3);
    }
}
