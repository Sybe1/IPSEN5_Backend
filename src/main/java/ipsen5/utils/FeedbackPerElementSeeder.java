package ipsen5.utils;

import ipsen5.dao.*;
import ipsen5.models.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeedbackPerElementSeeder {

    private FeedbackRepository feedbackRepository;
    private CriteriaRepository criteriaRepository;
    private FeedbackPerElementRepository feedbackPerElementRepository;

    public FeedbackPerElementSeeder(FeedbackRepository feedbackRepository, CriteriaRepository criteriaRepository, FeedbackPerElementRepository feedbackPerElementRepository) {
        this.feedbackRepository = feedbackRepository;
        this.criteriaRepository = criteriaRepository;
        this.feedbackPerElementRepository = feedbackPerElementRepository;
    }

    public void seedRubricElements() {
        List<Feedback> allFeedback = feedbackRepository.findAll();
        List<Criteria> allCriteria = criteriaRepository.findAll();

        FeedbackPerElement feedbackPerElement = new FeedbackPerElement();
        FeedbackPerElementId feedbackPerElementId = new FeedbackPerElementId(allCriteria.get(0), allFeedback.get(0));
        feedbackPerElement.setId(feedbackPerElementId);
        feedbackPerElement.setFeedback("Erg goed gedaan!");
        feedbackPerElement.setGrade(9);
        feedbackPerElementRepository.save(feedbackPerElement);

        FeedbackPerElement feedbackPerElement2 = new FeedbackPerElement();
        FeedbackPerElementId feedbackPerElementId2 = new FeedbackPerElementId(allCriteria.get(1), allFeedback.get(0));
        feedbackPerElement2.setId(feedbackPerElementId2);
        feedbackPerElement2.setFeedback("Dat kon beter!");
        feedbackPerElement2.setGrade(5);
        feedbackPerElementRepository.save(feedbackPerElement2);

        FeedbackPerElement feedbackPerElement3 = new FeedbackPerElement();
        FeedbackPerElementId feedbackPerElementId3 = new FeedbackPerElementId(allCriteria.get(1), allFeedback.get(1));
        feedbackPerElement3.setId(feedbackPerElementId3);
        feedbackPerElement3.setFeedback("Het verhaal had veel langer gekunt!");
        feedbackPerElement3.setGrade(6);
        feedbackPerElementRepository.save(feedbackPerElement3);
    }
}
