package ipsen5.controller;

import ipsen5.dao.FeedbackPerElementDAO;
import ipsen5.dto.FeedbackPerElementDTO;
import ipsen5.models.FeedbackPerElement;
import ipsen5.models.Reaction;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/feedbackperelement")
public class FeedbackPerElementController {

    private final FeedbackPerElementDAO feedbackPerElementDAO;

    public FeedbackPerElementController(FeedbackPerElementDAO feedbackPerElementDAO) {
        this.feedbackPerElementDAO = feedbackPerElementDAO;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('FEEDBACKPERELEMENT_GET') || hasAuthority('FEEDBACKPERELEMENT') || hasAuthority('ALL') || hasAuthority('GETTEN')")
    public ResponseEntity<List<FeedbackPerElement>> getPostCategories() {
        return ResponseEntity.ok(this.feedbackPerElementDAO.getFeedbackPerElement());
    }

    @GetMapping("/{submissionId}")
    @PreAuthorize("hasAuthority('FEEDBACKPERELEMENT_GET') || hasAuthority('FEEDBACKPERELEMENT') || hasAuthority('ALL') || hasAuthority('GETTEN')")
    public ResponseEntity<List<FeedbackPerElement>> getAllFeedbackPerElementBySubmissionId(@PathVariable UUID submissionId) {
        List<FeedbackPerElement> feedbackPerElements = feedbackPerElementDAO.getAllFeedbackPerElementBySubmissionId(submissionId);
        return ResponseEntity.ok(feedbackPerElements);
    }

    @GetMapping("/{submissionId}/{criteriaId}")
    @PreAuthorize("hasAuthority('FEEDBACKPERELEMENT_GET') || hasAuthority('FEEDBACKPERELEMENT') || hasAuthority('ALL') || hasAuthority('GETTEN')")
    public ResponseEntity<FeedbackPerElement> getAllFeedbackPerElementBySubmissionIdAndCriteriaId(
            @PathVariable UUID submissionId, @PathVariable UUID criteriaId) {
        FeedbackPerElement feedbackPerElements = feedbackPerElementDAO
                .getAllFeedbackPerElementBySubmissionIdAndCriteriaId(submissionId, criteriaId);
        return ResponseEntity.ok(feedbackPerElements);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('FEEDBACKPERELEMENT_POST') || hasAuthority('FEEDBACKPERELEMENT') || hasAuthority('ALL') || hasAuthority('POSTEN')")
    public ResponseEntity<String> saveFeedback(@RequestBody FeedbackPerElementDTO feedbackDTO) {
        feedbackPerElementDAO.saveFeedback(feedbackDTO);
        return ResponseEntity.ok("Created a new FeedbackPerElement with submissionID " + feedbackDTO.submissionId + " and criteriaID " + feedbackDTO.criteriaId);
    }

    @PutMapping("/{submissionId}/{criteriaId}")
    @PreAuthorize("hasAuthority('FEEDBACKPERELEMENT_PUT') || hasAuthority('FEEDBACKPERELEMENT') || hasAuthority('ALL') || hasAuthority('UPDATEN')")
    public ResponseEntity<String> updateFeedbackPerElement(@PathVariable UUID submissionId, @PathVariable UUID criteriaId, @RequestBody FeedbackPerElementDTO feedbackPerElementDTO) {
        this.feedbackPerElementDAO.updateFeedbackPerElement(submissionId, criteriaId, feedbackPerElementDTO);
        return ResponseEntity.ok("Updated FeedbackPerElement with submissionID " + submissionId + " and criteriaID " + criteriaId);
    }

    @DeleteMapping("/{submissionId}/{criteriaId}")
    @PreAuthorize("hasAuthority('FEEDBACKPERELEMENT_DELETE') || hasAuthority('FEEDBACKPERELEMENT') || hasAuthority('ALL') || hasAuthority('DELETEN')")
    public ResponseEntity<?> deleteFeedbackPerElement(@PathVariable UUID submissionId, @PathVariable UUID criteriaId) {
        this.feedbackPerElementDAO.deleteFeedbackPerElement(submissionId, criteriaId);
        return ResponseEntity.ok("Deleted FeedbackPerElement with submissionID " + submissionId + " and criteriaID " + criteriaId);
    }
}
