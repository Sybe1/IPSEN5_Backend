package ipsen5.controller;

import ipsen5.dao.RatingDAO;
import ipsen5.dto.RatingDTO;
import ipsen5.models.Rating;
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
    @PostMapping
    public ResponseEntity<String> createRating(@RequestBody RatingDTO ratingDTO){
        validator.ratingValidations(ratingDTO);
        this.ratingDAO.createRating(ratingDTO);
        return ResponseEntity.ok("Created a new Rating");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> editRating(@PathVariable UUID id, @RequestBody RatingDTO ratingDTO){
        validator.ratingValidations(ratingDTO);
        this.ratingDAO.editRating(id, ratingDTO);
        return ResponseEntity.ok("Edited rating with id: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRating(@PathVariable("id") UUID id){
        this.ratingDAO.deleteRating(id);
        return ResponseEntity.ok("deleted rating with id: " + id);
    }
}
