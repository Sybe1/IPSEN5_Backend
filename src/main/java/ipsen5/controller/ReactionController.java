package ipsen5.controller;

import ipsen5.services.ReactionService;
import ipsen5.dto.ReactionDTO;
import ipsen5.models.Reaction;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/reaction")
public class ReactionController {
    private final ReactionService reactionService;

    public ReactionController(ReactionService reactionService) {
        this.reactionService = reactionService;
    }

    @GetMapping("/{postId}")
    public ResponseEntity<List<Reaction>> getAllReactionsByPostId(@PathVariable UUID postId) {
        List<Reaction> reactions = reactionService.getAllReactionsByPostId(postId);
        return ResponseEntity.ok(reactions);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('REACTION_POST') || hasAuthority('REACTION') || hasAuthority('ALL') || hasAuthority('POSTEN')")
    public ResponseEntity<String> createReaction(@RequestBody ReactionDTO reactionDTO){
        this.reactionService.createReaction(reactionDTO);
        return ResponseEntity.ok("Created a new Reaction");
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('REACTION_PUT') || hasAuthority('REACTION') || hasAuthority('ALL') || hasAuthority('UPDATEN')")
    public ResponseEntity<String> editReaction(@PathVariable UUID id, @RequestBody ReactionDTO reactionDTO){
        this.reactionService.editReaction(id, reactionDTO);
        return ResponseEntity.ok("Edited reaction with id: " + id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('REACTION_DELETE') || hasAuthority('REACTION') || hasAuthority('ALL') || hasAuthority('DELETEN')")
    public ResponseEntity<?> deleteReaction(@PathVariable("id") UUID id){
        this.reactionService.deleteReaction(id);
        return ResponseEntity.ok("deleted reaction with id: " + id);
    }
}
