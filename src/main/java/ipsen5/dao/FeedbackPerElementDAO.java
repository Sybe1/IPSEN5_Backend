package ipsen5.dao;

import ipsen5.dto.FeedbackPerElementDTO;
import ipsen5.models.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeedbackPerElementDAO {

    private final FeedbackPerElementRepository feedbackPerElementRepository;

    public FeedbackPerElementDAO(FeedbackPerElementRepository feedbackPerElementRepository) {
        this.feedbackPerElementRepository = feedbackPerElementRepository;
    }

    public List<FeedbackPerElement> getPostCategories() {
        return this.feedbackPerElementRepository.findAll();
    }

    public void createFeedbackPerElement(FeedbackPerElementDTO feedbackPerElementDTO) {
        FeedbackPerElementId feedbackPerElementId = new FeedbackPerElementId(feedbackPerElementDTO.criteriaId, feedbackPerElementDTO.feedbackId);
        this.feedbackPerElementRepository.save(new FeedbackPerElement(feedbackPerElementId, feedbackPerElementDTO.grade, feedbackPerElementDTO.feedback));
    }

    public void updateFeedbackPerElement(Feedback feedbackId, Criteria criteriaId, FeedbackPerElementDTO feedbackPerElementDTO) {
        FeedbackPerElementId feedbackPerElementId = new FeedbackPerElementId(criteriaId, feedbackId);
        FeedbackPerElement feedbackPerElement = this.feedbackPerElementRepository.findById(feedbackPerElementId)
                .orElseThrow(() -> new RuntimeException("FeedbackPerElement not found"));

        feedbackPerElement.setGrade(feedbackPerElementDTO.grade);
        feedbackPerElement.setFeedback(feedbackPerElementDTO.feedback);

        this.feedbackPerElementRepository.save(feedbackPerElement);
    }


    public void deleteFeedbackPerElement(Feedback feedbackId, Criteria criteriaId) {
        FeedbackPerElementId feedbackPerElementId = new FeedbackPerElementId(criteriaId, feedbackId);
        this.feedbackPerElementRepository.findById(feedbackPerElementId).orElseThrow(() -> new RuntimeException("FeedbackPerElement not found"));
        this.feedbackPerElementRepository.deleteById(feedbackPerElementId);
    }
}
