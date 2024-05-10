package ipsen5.controller;

import ipsen5.dao.ReactionDAO;
import ipsen5.dto.RatingDTO;
import ipsen5.dto.ReactionDTO;
import ipsen5.services.UserInputValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rating")
public class ReactionController {
    private final ReactionDAO reactionDAO;
    private UserInputValidator validator;

    public ReactionController(ReactionDAO reactionDAO, UserInputValidator validator) {
        this.reactionDAO = reactionDAO;
        this.validator = validator;
    }
    @PostMapping
    public ResponseEntity<String> createReaction(@RequestBody ReactionDTO reactionDTO){
        if (!validator.isNotNull(reactionDTO.text)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid grade provided"
            );
        }
        if (!validator.isNotNull(reactionDTO.post_id)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid post provided"
            );
        }
        if (!validator.isNotNull(reactionDTO.user_id)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid user provided"
            );
        }
        this.reactionDAO.createReaction(reactionDTO);
        return ResponseEntity.ok("Created a new Rating");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> editReaction(@PathVariable UUID id, @RequestBody ReactionDTO reactionDTO){
        if (!validator.isNotNull(reactionDTO.text)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid reaction provided"
            );
        }
        this.reactionDAO.editReaction(id, reactionDTO);
        return ResponseEntity.ok("Edited reaction with id: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReaction(@PathVariable("id") UUID id){
        this.reactionDAO.deleteReaction(id);
        return ResponseEntity.ok("deleted reaction with id: " + id);
    }
}
