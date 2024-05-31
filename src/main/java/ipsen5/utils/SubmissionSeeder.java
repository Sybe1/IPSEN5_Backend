package ipsen5.utils;

import ipsen5.dao.*;
import ipsen5.models.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubmissionSeeder {
    private SubmissionRespository submissionRespository;
    private UserRepository userRepository;
    private FeedbackRepository feedbackRepository;
    private StatusRepository statusRepository;
    private RubricRepository rubricRepository;


    public SubmissionSeeder(SubmissionRespository submissionRespository,
                            UserRepository userRepository,
                            FeedbackRepository feedbackRepository,
                            StatusRepository statusRepository,
                            RubricRepository rubricRepository) {
        this.submissionRespository = submissionRespository;
        this.userRepository = userRepository;
        this.feedbackRepository = feedbackRepository;
        this.statusRepository = statusRepository;
        this.rubricRepository = rubricRepository;
    }

    public void seedSubmission(){
        List<User> allUsers = userRepository.findAll();
        List<Status> allStatus = statusRepository.findAll();
        List<Feedback> allFeedback = feedbackRepository.findAll();
        List<Rubric> allRubrics = rubricRepository.findAll();

        Submission submission = new Submission();
        submission.setUser_id(allUsers.get(0));
        submission.setStatusID(allStatus.get(0));
        submission.setFeedbackID(allFeedback.get(0));
        submission.setText("Eerste ingestuurde tekst!");
        submission.setStory_Details("Dit is mijn eerste ingestuurde verhaal");
        submission.setExtra_feedback(true);
        submission.setRubric(allRubrics.get(0));
        submissionRespository.save(submission);

        Submission submission2 = new Submission();
        submission2.setUser_id(allUsers.get(1));
        submission2.setStatusID(allStatus.get(0));
        submission2.setFeedbackID(allFeedback.get(1));
        submission2.setText("Tweede ingestuurde tekst!");
        submission2.setStory_Details("Het is een mythisch verhaal over draken");
        submission2.setExtra_feedback(true);
        submission2.setRubric(allRubrics.get(0));
        submissionRespository.save(submission2);

        Submission submission3 = new Submission();
        submission3.setUser_id(allUsers.get(1));
        submission3.setStatusID(allStatus.get(1));
        submission3.setFeedbackID(allFeedback.get(2));
        submission3.setText("Er was eens..");
        submission3.setStory_Details("Dit is een sprookje");
        submission3.setExtra_feedback(false);
        submission3.setRubric(allRubrics.get(0));
        submissionRespository.save(submission3);
    }
}
