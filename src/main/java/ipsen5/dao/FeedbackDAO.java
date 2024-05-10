package ipsen5.dao;

import ipsen5.dto.FeedbackDTO;
import ipsen5.models.Feedback;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class FeedbackDAO {
    private final FeedbackRepository feedbackRepository;

    public FeedbackDAO(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public List<Feedback> getAllFeedbacks() {
        return this.feedbackRepository.findAll();
    }

    public void createFeedback(FeedbackDTO feedbackDTO) {
        this.feedbackRepository.save(new Feedback(feedbackDTO.general_text, feedbackDTO.user, feedbackDTO.rubric));
    }

    public void editFeedback(UUID id, FeedbackDTO feedbackDTO) {
        Feedback feedback = this.feedbackRepository.findById(id).orElseThrow(() -> new RuntimeException("Feedback not found"));
        feedback.setGeneral_text(feedbackDTO.general_text);
        feedback.setUser(feedbackDTO.user);
        feedback.setRubric(feedbackDTO.rubric);
        this.feedbackRepository.save(feedback);
    }

    public void deleteFeedback(UUID id) {
        this.feedbackRepository.findById(id).orElseThrow(() -> new RuntimeException("Feedback not found"));
        this.feedbackRepository.deleteById(id);
    }
}
