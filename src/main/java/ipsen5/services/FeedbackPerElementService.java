package ipsen5.services;

import ipsen5.dto.FeedbackPerElementDTO;
import ipsen5.models.*;
import ipsen5.repository.CriteriaRepository;
import ipsen5.repository.FeedbackPerElementRepository;
import ipsen5.repository.SubmissionRespository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class FeedbackPerElementService {

    private final FeedbackPerElementRepository feedbackPerElementRepository;
    private final CriteriaRepository criteriaRepository;
    private final SubmissionRespository submissionRepository;

    public FeedbackPerElementService(FeedbackPerElementRepository feedbackPerElementRepository,
                                     CriteriaRepository criteriaRepository,
                                     SubmissionRespository submissionRepository) {
        this.feedbackPerElementRepository = feedbackPerElementRepository;
        this.criteriaRepository = criteriaRepository;
        this.submissionRepository = submissionRepository;
    }

    public List<FeedbackPerElement> getFeedbackPerElement() {
        return this.feedbackPerElementRepository.findAll();
    }

    public List<FeedbackPerElement> getAllFeedbackPerElementBySubmissionId(UUID submissionId) {
        Optional<Submission> optionalSubmission = this.submissionRepository.findById(submissionId);
        Submission submission = optionalSubmission.get();
        return this.feedbackPerElementRepository.findByIdSubmissionId(submission);
    }

    public FeedbackPerElement getAllFeedbackPerElementBySubmissionIdAndCriteriaId(UUID submissionId, UUID criteriaId) {
        Submission submission = submissionRepository.findById(submissionId)
                .orElseThrow(() -> new RuntimeException("Submission not found"));
        Criteria criteria = criteriaRepository.findById(criteriaId)
                .orElseThrow(() -> new RuntimeException("Criteria not found"));

        return this.feedbackPerElementRepository.findByIdSubmissionIdAndIdCriteriaId(submission, criteria);
    }

    public void saveFeedback(FeedbackPerElementDTO feedbackDTO) {
        Criteria criteria = criteriaRepository.findById(feedbackDTO.criteriaId)
                .orElseThrow(() -> new RuntimeException("Criteria not found"));
        Submission submission = submissionRepository.findById(feedbackDTO.submissionId)
                .orElseThrow(() -> new RuntimeException("Submission not found"));

        FeedbackPerElement feedback = new FeedbackPerElement();
        feedback.setId(new FeedbackPerElementId(criteria, submission));
        feedback.setGrade(feedbackDTO.grade);
        feedback.setFeedback(feedbackDTO.feedback);

        this.feedbackPerElementRepository.save(feedback);
    }

    public void updateFeedbackPerElement(UUID submissionId, UUID criteriaId, FeedbackPerElementDTO feedbackPerElementDTO) {
        Criteria criteria = criteriaRepository.findById(criteriaId)
                .orElseThrow(() -> new RuntimeException("Criteria not found"));
        Submission submission = submissionRepository.findById(submissionId)
                .orElseThrow(() -> new RuntimeException("Submission not found"));

        FeedbackPerElementId feedbackPerElementId = new FeedbackPerElementId(criteria, submission);
        FeedbackPerElement feedbackPerElement = this.feedbackPerElementRepository.findById(feedbackPerElementId)
                .orElseThrow(() -> new RuntimeException("FeedbackPerElement not found"));

        feedbackPerElement.setGrade(feedbackPerElementDTO.grade);
        feedbackPerElement.setFeedback(feedbackPerElementDTO.feedback);

        this.feedbackPerElementRepository.save(feedbackPerElement);
    }

    public void deleteFeedbackPerElement(UUID submissionId, UUID criteriaId) {
        Criteria criteria = criteriaRepository.findById(criteriaId)
                .orElseThrow(() -> new RuntimeException("Criteria not found"));
        Submission submission = submissionRepository.findById(submissionId)
                .orElseThrow(() -> new RuntimeException("Submission not found"));

        FeedbackPerElementId feedbackPerElementId = new FeedbackPerElementId(criteria, submission);
        FeedbackPerElement feedbackPerElement = this.feedbackPerElementRepository.findById(feedbackPerElementId)
                .orElseThrow(() -> new RuntimeException("FeedbackPerElement not found"));

        this.feedbackPerElementRepository.delete(feedbackPerElement);
    }


}
