package ipsen5.utils;

import ipsen5.repository.CriteriaRepository;
import ipsen5.repository.FeedbackPerElementRepository;
import ipsen5.repository.SubmissionRespository;
import ipsen5.models.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeedbackPerElementSeeder {

    private final SubmissionRespository submissionRespository;
    private final CriteriaRepository criteriaRepository;
    private final FeedbackPerElementRepository feedbackPerElementRepository;

    public FeedbackPerElementSeeder(SubmissionRespository submissionRespository, CriteriaRepository criteriaRepository, FeedbackPerElementRepository feedbackPerElementRepository) {
        this.submissionRespository = submissionRespository;
        this.criteriaRepository = criteriaRepository;
        this.feedbackPerElementRepository = feedbackPerElementRepository;
    }

    public void seedRubricElements() {
        List<Submission> allSubmissions = submissionRespository.findAll();
        List<Criteria> allCriteria = criteriaRepository.findAll();

        FeedbackPerElement feedbackPerElement = new FeedbackPerElement();

        FeedbackPerElementId feedbackPerElementId = new FeedbackPerElementId(allCriteria.get(0), allSubmissions.get(0));
        feedbackPerElement.setId(feedbackPerElementId);
        feedbackPerElement.setFeedback("Erg goed gedaan!");
        feedbackPerElement.setGrade(8);
        feedbackPerElementRepository.save(feedbackPerElement);

        FeedbackPerElement feedbackPerElement2 = new FeedbackPerElement();
        FeedbackPerElementId feedbackPerElementId2 = new FeedbackPerElementId(allCriteria.get(1), allSubmissions.get(0));
        feedbackPerElement2.setId(feedbackPerElementId2);
        feedbackPerElement2.setFeedback("Dat kon beter!");
        feedbackPerElement2.setGrade(4);
        feedbackPerElementRepository.save(feedbackPerElement2);

        FeedbackPerElement feedbackPerElement3 = new FeedbackPerElement();
        FeedbackPerElementId feedbackPerElementId3 = new FeedbackPerElementId(allCriteria.get(1), allSubmissions.get(1));
        feedbackPerElement3.setId(feedbackPerElementId3);
        feedbackPerElement3.setFeedback("Het verhaal had veel langer gekunt!");
        feedbackPerElement3.setGrade(6);
        feedbackPerElementRepository.save(feedbackPerElement3);
    }
}

