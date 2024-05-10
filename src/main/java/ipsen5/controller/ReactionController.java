package ipsen5.controller;

import ipsen5.dao.ReactionDAO;
import ipsen5.dto.ReactionDTO;
import ipsen5.services.ReactionValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rating")
public class ReactionController {
    private final ReactionDAO reactionDAO;
    private ReactionValidator validator;

    public ReactionController(ReactionDAO reactionDAO, ReactionValidator validator) {
        this.reactionDAO = reactionDAO;
        this.validator = validator;
    }
    @PostMapping
    public ResponseEntity<String> createReaction(@RequestBody ReactionDTO reactionDTO){
        validator.reactionValidations(reactionDTO);
        this.reactionDAO.createReaction(reactionDTO);
        return ResponseEntity.ok("Created a new Rating");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> editReaction(@PathVariable UUID id, @RequestBody ReactionDTO reactionDTO){
        validator.reactionValidations(reactionDTO);
        this.reactionDAO.editReaction(id, reactionDTO);
        return ResponseEntity.ok("Edited reaction with id: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReaction(@PathVariable("id") UUID id){
        this.reactionDAO.deleteReaction(id);
        return ResponseEntity.ok("deleted reaction with id: " + id);
    }
}
