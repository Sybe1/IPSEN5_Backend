package ipsen5.dao;

import ipsen5.dto.SubmissionDTO;
import ipsen5.models.Submission;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class SubmissionDAO {
    private final SubmissionRespository submissionRespository;

    public SubmissionDAO(SubmissionRespository submissionRespository) {
        this.submissionRespository = submissionRespository;
    }
    public List<Submission> getAllSubmissions() {
        return this.submissionRespository.findAll();
    }
    public void createSubmission(SubmissionDTO submissionDTO) {
        this.submissionRespository.save(new Submission(submissionDTO.text, submissionDTO.user_id, submissionDTO.post_id));
    }
    public void editSubmission(UUID id, SubmissionDTO submissionDTO) {
        Submission submission = this.submissionRespository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        submission.setPost_id(submissionDTO.post_id);
        submission.setText(submissionDTO.text);
        submission.setUser_id(submissionDTO.user_id);
        this.submissionRespository.save(submission);
    }

    public void deleteSubmission(UUID id) {
        this.submissionRespository.findById(id).orElseThrow(() -> new RuntimeException("Submission not found"));
        this.submissionRespository.deleteById(id);
    }
}
