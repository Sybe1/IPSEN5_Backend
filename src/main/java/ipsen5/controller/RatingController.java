package ipsen5.controller;

import ipsen5.dao.RatingDAO;
import ipsen5.dto.FeedbackPerElementDTO;
import ipsen5.dto.RatingDTO;
import ipsen5.models.*;
import ipsen5.services.InputValidator;
import ipsen5.services.RatingValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rating")
public class RatingController {
    private final RatingDAO ratingDAO;
    private RatingValidator validator;

    public RatingController(RatingDAO ratingDAO, RatingValidator validator) {
        this.ratingDAO = ratingDAO;
        this.validator = validator;
    }
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings(){
        return ResponseEntity.ok(this.ratingDAO.getAllRatings());
    }

    @GetMapping("/{postId}")
    public ResponseEntity<List<Rating>> getRatingsByPostId(@PathVariable UUID postId) {
        return ResponseEntity.ok(this.ratingDAO.getRatingsByPostId(postId));
    }

    @PostMapping
    public ResponseEntity<String> createRating(@RequestBody RatingDTO ratingDTO){
        validator.ratingValidations(ratingDTO);
        this.ratingDAO.createRating(ratingDTO);
        return ResponseEntity.ok("Created a new Rating");
    }
    @PutMapping("/{userId}/{postId}")
    public ResponseEntity<String> editRating(@PathVariable User userId, @PathVariable Post postId, @RequestBody RatingDTO ratingDTO){
        validator.ratingValidations(ratingDTO);
        this.ratingDAO.editRating(userId, postId, ratingDTO);
        return ResponseEntity.ok("Edited rating with userId: " + userId + " and postID: " + postId);
    }

    @DeleteMapping("/{userId}/{postId}")
    public ResponseEntity<?> deleteRating(@PathVariable User userId, @PathVariable Post postId){
        this.ratingDAO.deleteRating(userId, postId);
        return ResponseEntity.ok("deleted rating with userId: " + userId + " and postId: " + postId);
    }
}
