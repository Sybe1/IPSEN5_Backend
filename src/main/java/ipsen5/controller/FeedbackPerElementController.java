package ipsen5.controller;

import ipsen5.dao.FeedbackPerElementDAO;
import ipsen5.dao.FeedbackPerElementRepository;
import ipsen5.dto.FeedbackPerElementDTO;
import ipsen5.models.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedbackperelement")
public class FeedbackPerElementController {

    private final FeedbackPerElementDAO feedbackPerElementDAO;


    public FeedbackPerElementController(FeedbackPerElementDAO feedbackPerElementDAO) {
        this.feedbackPerElementDAO = feedbackPerElementDAO;
    }

    @GetMapping
    public ResponseEntity<List<FeedbackPerElement>> getPostCategories() {
        return ResponseEntity.ok(this.feedbackPerElementDAO.getPostCategories());
    }

    @PostMapping
    public  ResponseEntity<String> createFeedbackPerElement(@RequestBody FeedbackPerElementDTO feedbackPerElementDTO) {
        this.feedbackPerElementDAO.createFeedbackPerElement(feedbackPerElementDTO);
        return ResponseEntity.ok("Created a new FeedbackPerElement with feedbackID " + feedbackPerElementDTO.feedbackId + "and CriteriaID " + feedbackPerElementDTO.criteriaId);
    }

    @PutMapping("/{feedbackId}/{criteriaId}")
    public ResponseEntity<String> updateFeedbackPerElement(@PathVariable Feedback feedbackId, @PathVariable Criteria criteriaId, @RequestBody FeedbackPerElementDTO feedbackPerElementDTO) {
        this.feedbackPerElementDAO.updateFeedbackPerElement(feedbackId, criteriaId, feedbackPerElementDTO);
        return ResponseEntity.ok("Updated FeedbackPerElement with feedbackID " + feedbackId + " and CriteriaID " + criteriaId);
    }


    @DeleteMapping("/{postId}/{categoryId}")
    public ResponseEntity<?> deleteFeedbackPerElement(@PathVariable Feedback feedbackId, @PathVariable Criteria criteriaId) {
        this.feedbackPerElementDAO.deleteFeedbackPerElement(feedbackId, criteriaId);
        return ResponseEntity.ok("Deleted FeedbackPerElement with feedbackID " + feedbackId + "and CriteriaID " + criteriaId);
    }
}


