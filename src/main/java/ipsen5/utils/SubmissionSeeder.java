package ipsen5.utils;

import ipsen5.dao.*;
import ipsen5.models.*;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;

@Component
public class SubmissionSeeder {
    private final SubmissionRespository submissionRespository;
    private final UserRepository userRepository;
    private final StatusRepository statusRepository;
    private final RubricRepository rubricRepository;


    public SubmissionSeeder(SubmissionRespository submissionRespository,
                            UserRepository userRepository,
                            StatusRepository statusRepository,
                            RubricRepository rubricRepository) {
        this.submissionRespository = submissionRespository;
        this.userRepository = userRepository;
        this.statusRepository = statusRepository;
        this.rubricRepository = rubricRepository;
    }

    public void seedSubmission(){
         List<User> allUsers = userRepository.findAll();
         List<Status> allStatus = statusRepository.findAll();
         List<Rubric> allRubrics = rubricRepository.findAll();

         Submission submission = new Submission();
         submission.setUser_id(allUsers.get(0));
         submission.setStatusID(allStatus.get(0));
         submission.setName("name");
         submission.setEmail("mvamstel@mail.com");
         submission.setOnline_profiles("dont have");
         submission.setType("text");
         submission.setWordCount(100);
         submission.setGenre("romance");
         submission.setAdditional_notes("additional_notes");
         submission.setPrefferd_destination("Babels CHOICE");
        submission.setStory_title("First story");
        submission.setPlatform_presence(true);
         submission.setExtra_feedback(true);
         submission.setExpress_experience(true);
         submission.setRubric(allRubrics.get(0));
         submissionRespository.save(submission);

         Submission submission2 = new Submission();
         submission2.setUser_id(allUsers.get(1));
         submission2.setStatusID(allStatus.get(0));
         submission2.setName("Johan");
         submission2.setStory_title("New story");
         submission2.setEmail("johan@mail.com");
        submission2.setOnline_profiles("dont have");
        submission2.setType("text");
         submission2.setWordCount(200);
        submission2.setGenre("Horror");
        submission2.setAdditional_notes("Thank you!");
        submission2.setPrefferd_destination("Official Selection");
        submission2.setPlatform_presence(true);
        submission2.setExtra_feedback(true);
        submission2.setExpress_experience(true);
        submission2.setRubric(allRubrics.get(0));
         submission2.setExtra_feedback(true);
         submission2.setRubric(allRubrics.get(0));
         submissionRespository.save(submission2);


    }
}
