package ipsen5.dao;

import ipsen5.dto.SubmissionDTO;

import ipsen5.models.Status;
import ipsen5.models.Post;
import ipsen5.models.Submission;
import ipsen5.models.User;
import jakarta.persistence.ManyToOne;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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
    public Optional<Submission> getSubmissionById(UUID id) {
        return this.submissionRespository.findById(id);
    }
    public Submission createSubmission(SubmissionDTO submissionDTO) {
        Submission submission = new Submission();
        submission.setName(submissionDTO.name);
        submission.setText(submissionDTO.text);
        submission.setEmail(submissionDTO.email);
        submission.setOnline_profiles(submissionDTO.online_profiles);
        submission.setStory_title(submissionDTO.story_title);
        submission.setType(submissionDTO.type);
        submission.setWordCount(submissionDTO.wordCount);
        submission.setGenre(submissionDTO.genre);
        submission.setAdditional_notes(submissionDTO.additional_notes);
        submission.setPrefferd_destination(submissionDTO.prefferd_destination);
        submission.setPlatform_presence(submissionDTO.platform_presence);
        submission.setExpress_experience(submissionDTO.express_experience);
        submission.setExtra_feedback(submissionDTO.extra_feedback);
        submission.setStatusID(submissionDTO.statusID);
        submission.setUser_id(submissionDTO.user_id);
        return this.submissionRespository.save(submission);
    }
    public void saveSubmissionPdf(MultipartFile file, UUID submissionId) throws IOException {
      Submission foundSubmission = getSubmissionById(submissionId).orElseThrow(() -> new RuntimeException("Post not found"));
        foundSubmission.setPdf(file.getBytes());
        submissionRespository.save(foundSubmission);
    }
    public byte[] getUserPdf(UUID id) {
        Submission submission = submissionRespository.findById(id).orElse(null);
        byte[] submissionPDF = submission.getPdf();
        return submissionPDF;
    }

    public void editSubmission(UUID id, SubmissionDTO submissionDTO) {
        Submission submission = this.submissionRespository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));;
        submission.setName(submissionDTO.name);
        submission.setText(submissionDTO.text);
        submission.setEmail(submissionDTO.email);
        submission.setOnline_profiles(submissionDTO.online_profiles);
        submission.setStory_title(submissionDTO.story_title);
        submission.setType(submissionDTO.type);
        submission.setWordCount(submissionDTO.wordCount);
        submission.setGenre(submissionDTO.genre);
        submission.setAdditional_notes(submissionDTO.additional_notes);
        submission.setPrefferd_destination(submissionDTO.prefferd_destination);
        submission.setPlatform_presence(submissionDTO.platform_presence);
        submission.setExpress_experience(submissionDTO.express_experience);
        submission.setExtra_feedback(submissionDTO.extra_feedback);
        submission.setStatusID(submissionDTO.statusID);
        submission.setUser_id(submissionDTO.user_id);
        this.submissionRespository.save(submission);
    }

    public void deleteSubmission(UUID id) {
        this.submissionRespository.findById(id).orElseThrow(() -> new RuntimeException("Submission not found"));
        this.submissionRespository.deleteById(id);
    }
}
