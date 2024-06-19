package ipsen5.services;

import ipsen5.dto.SubmissionDTO;

import ipsen5.models.Rubric;
import ipsen5.models.Submission;
import ipsen5.repository.RubricRepository;
import ipsen5.repository.SubmissionRespository;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class SubmissionService {
    private final SubmissionRespository submissionRespository;
    private final RubricRepository rubricRepository;

    public SubmissionService(SubmissionRespository submissionRespository,
                             RubricRepository rubricRepository) {
        this.submissionRespository = submissionRespository;
        this.rubricRepository = rubricRepository;
    }
    public List<Submission> getAllSubmissions() {
        return this.submissionRespository.findAll();
    }

    public Optional<Submission> getSubmissionById(UUID id) {
        return this.submissionRespository.findById(id);
    }


    public List<Submission> getSubmissionByUserId(UUID id) {
        List<Submission> submissions = this.submissionRespository.findAll();
        List<Submission> submissionsByUserId = new ArrayList<>();
        for (Submission submission : submissions) {
            if (submission.getUser_id().getId() == id) {
                submissionsByUserId.add(submission);
            }
        }

        System.out.println(submissionsByUserId);
        return submissionsByUserId;
    }


    public Submission createSubmission(SubmissionDTO submissionDTO) {
        Submission submission = new Submission();

        List<Rubric> rubrics = this.rubricRepository.findAll();
        if (submissionDTO.type.equals("Text")){
            submission.setRubric(rubrics.get(0));
        }
        else if(submissionDTO.type.equals("Audio")){
            submission.setRubric(rubrics.get(1));
        }
        else if(submissionDTO.type.equals("Video")){
            submission.setRubric(rubrics.get(2));
        }

        submission = this.makeSubmission(submission, submissionDTO);
        return this.submissionRespository.save(submission);
    }
    public void saveSubmissionPdf(MultipartFile file, UUID submissionId) throws IOException {
      Submission foundSubmission = getSubmissionById(submissionId).orElseThrow(() -> new RuntimeException("Post not found"));
        foundSubmission.setPdf(file.getBytes());
        submissionRespository.save(foundSubmission);
    }

    public void saveSubmissionPicture(MultipartFile file, UUID submissionId) throws IOException {
        Submission foundSubmission = getSubmissionById(submissionId).orElseThrow(() -> new RuntimeException("Post not found"));
        foundSubmission.setPicture(file.getBytes());
        submissionRespository.save(foundSubmission);
    }

    public byte[] getUserPdf(UUID id) {
        Submission submission = submissionRespository.findById(id).orElse(null);
        byte[] submissionPDF = submission.getPdf();
        return submissionPDF;
    }
    public byte[] getUserPicture(UUID id) {
        Submission submission = submissionRespository.findById(id).orElse(null);
        byte[] submissionPicture = submission.getPicture();
        return submissionPicture;
    }

    public void editSubmission(UUID id, SubmissionDTO submissionDTO) {
        Submission submission = this.submissionRespository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));;
        submission = this.makeSubmission(submission, submissionDTO);
        this.submissionRespository.save(submission);
    }

    public void deleteSubmission(UUID id) {
        this.submissionRespository.findById(id).orElseThrow(() -> new RuntimeException("Submission not found"));
        this.submissionRespository.deleteById(id);
    }

    private Submission makeSubmission(Submission submission, SubmissionDTO submissionDTO){
        submission.setName(submissionDTO.name);
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
        return submission;
    }
}
