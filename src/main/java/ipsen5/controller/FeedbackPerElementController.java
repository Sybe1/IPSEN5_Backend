package ipsen5.controller;

import ipsen5.services.FeedbackPerElementService;
import ipsen5.dto.FeedbackPerElementDTO;
import ipsen5.models.FeedbackPerElement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/feedbackperelement")
public class FeedbackPerElementController {

    private final FeedbackPerElementService feedbackPerElementService;

    public FeedbackPerElementController(FeedbackPerElementService feedbackPerElementService) {
        this.feedbackPerElementService = feedbackPerElementService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('FEEDBACKPERELEMENT_GET') || hasAuthority('FEEDBACKPERELEMENT') || hasAuthority('ALL') || hasAuthority('GETTEN')")
    public ResponseEntity<List<FeedbackPerElement>> getPostCategories() {
        return ResponseEntity.ok(this.feedbackPerElementService.getFeedbackPerElement());
    }

    @GetMapping("/{submissionId}")
    @PreAuthorize("hasAuthority('FEEDBACKPERELEMENT_GET') || hasAuthority('FEEDBACKPERELEMENT') || hasAuthority('ALL') || hasAuthority('GETTEN')")
    public ResponseEntity<List<FeedbackPerElement>> getAllFeedbackPerElementBySubmissionId(@PathVariable UUID submissionId) {
        List<FeedbackPerElement> feedbackPerElements = feedbackPerElementService.getAllFeedbackPerElementBySubmissionId(submissionId);
        return ResponseEntity.ok(feedbackPerElements);
    }

    @GetMapping("/{submissionId}/{criteriaId}")
    @PreAuthorize("hasAuthority('FEEDBACKPERELEMENT_GET') || hasAuthority('FEEDBACKPERELEMENT') || hasAuthority('ALL') || hasAuthority('GETTEN')")
    public ResponseEntity<FeedbackPerElement> getAllFeedbackPerElementBySubmissionIdAndCriteriaId(
            @PathVariable UUID submissionId, @PathVariable UUID criteriaId) {
        FeedbackPerElement feedbackPerElements = feedbackPerElementService
                .getAllFeedbackPerElementBySubmissionIdAndCriteriaId(submissionId, criteriaId);
        return ResponseEntity.ok(feedbackPerElements);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('FEEDBACKPERELEMENT_POST') || hasAuthority('FEEDBACKPERELEMENT') || hasAuthority('ALL') || hasAuthority('POSTEN')")
    public ResponseEntity<String> saveFeedback(@RequestBody FeedbackPerElementDTO feedbackDTO) {
        feedbackPerElementService.saveFeedback(feedbackDTO);
        return ResponseEntity.ok("Created a new FeedbackPerElement with submissionID " + feedbackDTO.submissionId + " and criteriaID " + feedbackDTO.criteriaId);
    }

    @PutMapping("/{submissionId}/{criteriaId}")
    @PreAuthorize("hasAuthority('FEEDBACKPERELEMENT_PUT') || hasAuthority('FEEDBACKPERELEMENT') || hasAuthority('ALL') || hasAuthority('UPDATEN')")
    public ResponseEntity<String> updateFeedbackPerElement(@PathVariable UUID submissionId, @PathVariable UUID criteriaId, @RequestBody FeedbackPerElementDTO feedbackPerElementDTO) {
        this.feedbackPerElementService.updateFeedbackPerElement(submissionId, criteriaId, feedbackPerElementDTO);
        return ResponseEntity.ok("Updated FeedbackPerElement with submissionID " + submissionId + " and criteriaID " + criteriaId);
    }

    @DeleteMapping("/{submissionId}/{criteriaId}")
    @PreAuthorize("hasAuthority('FEEDBACKPERELEMENT_DELETE') || hasAuthority('FEEDBACKPERELEMENT') || hasAuthority('ALL') || hasAuthority('DELETEN')")
    public ResponseEntity<?> deleteFeedbackPerElement(@PathVariable UUID submissionId, @PathVariable UUID criteriaId) {
        this.feedbackPerElementService.deleteFeedbackPerElement(submissionId, criteriaId);
        return ResponseEntity.ok("Deleted FeedbackPerElement with submissionID " + submissionId + " and criteriaID " + criteriaId);
    }
}
