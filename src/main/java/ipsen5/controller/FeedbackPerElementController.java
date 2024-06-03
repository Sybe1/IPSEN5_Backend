package ipsen5.controller;

import ipsen5.dao.FeedbackPerElementDAO;
import ipsen5.dto.FeedbackPerElementDTO;
import ipsen5.models.FeedbackPerElement;
import ipsen5.models.Reaction;
import ipsen5.services.FeedbackPerElementValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/feedbackperelement")
public class FeedbackPerElementController {

    private final FeedbackPerElementDAO feedbackPerElementDAO;
    private final FeedbackPerElementValidator validator;

    public FeedbackPerElementController(FeedbackPerElementDAO feedbackPerElementDAO, FeedbackPerElementValidator validator) {
        this.feedbackPerElementDAO = feedbackPerElementDAO;
        this.validator = validator;
    }

    @GetMapping
    public ResponseEntity<List<FeedbackPerElement>> getPostCategories() {
        return ResponseEntity.ok(this.feedbackPerElementDAO.getFeedbackPerElement());
    }

    @GetMapping("/{submissionId}")
    public ResponseEntity<List<FeedbackPerElement>> getAllFeedbackPerElementBySubmissionId(@PathVariable UUID submissionId) {
        List<FeedbackPerElement> feedbackPerElements = feedbackPerElementDAO.getAllFeedbackPerElementBySubmissionId(submissionId);
        return ResponseEntity.ok(feedbackPerElements);
    }

    @GetMapping("/{submissionId}/{criteriaId}")
    public ResponseEntity<FeedbackPerElement> getAllFeedbackPerElementBySubmissionIdAndCriteriaId(
            @PathVariable UUID submissionId, @PathVariable UUID criteriaId) {
        FeedbackPerElement feedbackPerElements = feedbackPerElementDAO
                .getAllFeedbackPerElementBySubmissionIdAndCriteriaId(submissionId, criteriaId);
        return ResponseEntity.ok(feedbackPerElements);
    }

    @PostMapping
    public ResponseEntity<String> saveFeedback(@RequestBody FeedbackPerElementDTO feedbackDTO) {
        validator.feedbackPerElementValidations(feedbackDTO);
        feedbackPerElementDAO.saveFeedback(feedbackDTO);
        return ResponseEntity.ok("Created a new FeedbackPerElement with submissionID " + feedbackDTO.submissionId + " and criteriaID " + feedbackDTO.criteriaId);
    }

    @PutMapping("/{submissionId}/{criteriaId}")
    public ResponseEntity<String> updateFeedbackPerElement(@PathVariable UUID submissionId, @PathVariable UUID criteriaId, @RequestBody FeedbackPerElementDTO feedbackPerElementDTO) {
        validator.feedbackPerElementValidations(feedbackPerElementDTO);
        this.feedbackPerElementDAO.updateFeedbackPerElement(submissionId, criteriaId, feedbackPerElementDTO);
        return ResponseEntity.ok("Updated FeedbackPerElement with submissionID " + submissionId + " and criteriaID " + criteriaId);
    }

    @DeleteMapping("/{submissionId}/{criteriaId}")
    public ResponseEntity<?> deleteFeedbackPerElement(@PathVariable UUID submissionId, @PathVariable UUID criteriaId) {
        this.feedbackPerElementDAO.deleteFeedbackPerElement(submissionId, criteriaId);
        return ResponseEntity.ok("Deleted FeedbackPerElement with submissionID " + submissionId + " and criteriaID " + criteriaId);
    }
}
