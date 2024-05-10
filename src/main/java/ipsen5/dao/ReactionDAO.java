package ipsen5.dao;

import ipsen5.dto.RatingDTO;
import ipsen5.dto.ReactionDTO;
import ipsen5.models.Rating;
import ipsen5.models.Reaction;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ReactionDAO {
    private final ReactionRepository reactionRepository;

    public ReactionDAO(ReactionRepository reactionRepository) {
        this.reactionRepository = reactionRepository;
    }

    public List<Reaction> getAllReactions() {
        return this.reactionRepository.findAll();
    }

    public void createReaction(ReactionDTO reactionDTO) {
        this.reactionRepository.save(new Reaction(reactionDTO.text, reactionDTO.post_id, reactionDTO.user_id));
    }

    public void editReaction(UUID id, ReactionDTO reactionDTO) {
        Reaction reaction = this.reactionRepository.findById(id).orElseThrow(() -> new RuntimeException("Reaction not found"));
        reaction.setText(reactionDTO.text);
        this.reactionRepository.save(reaction);
    }
    public void deleteReaction(UUID id) {
        this.reactionRepository.findById(id).orElseThrow(() -> new RuntimeException("Reaction not found"));
        this.reactionRepository.deleteById(id);
    }

}
