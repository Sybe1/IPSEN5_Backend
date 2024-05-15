package ipsen5.controller;

import ipsen5.dao.FeedbackDAO;
import ipsen5.dto.FeedbackDTO;
import ipsen5.models.Feedback;
import ipsen5.services.FeedbackValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/feedback")
public class FeedbackController {
    private final FeedbackDAO feedbackDAO;
    private FeedbackValidator validator;
    public FeedbackController(FeedbackDAO feedbackDAO, FeedbackValidator validator) {
        this.feedbackDAO = feedbackDAO;
        this.validator = validator;
    }

    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedbacks(){
        return ResponseEntity.ok(this.feedbackDAO.getAllFeedbacks());
    }

    @PostMapping
    public ResponseEntity<String> createFeedback(@RequestBody FeedbackDTO feedbackDTO){
        validator.feedbackValidations(feedbackDTO);
        this.feedbackDAO.createFeedback(feedbackDTO);
        return ResponseEntity.ok("Created a new Feedback");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editFeedback(@PathVariable UUID id, @RequestBody FeedbackDTO feedbackDTO){
        validator.feedbackValidations(feedbackDTO);
        this.feedbackDAO.editFeedback(id, feedbackDTO);
        return ResponseEntity.ok("Edited feedback with id: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFeedback(@PathVariable("id") UUID id){
        this.feedbackDAO.deleteFeedback(id);
        return ResponseEntity.ok("deleted feedback with id: " + id);
    }
}
