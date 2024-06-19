package ipsen5.services;

import ipsen5.dto.ReactionDTO;
import ipsen5.models.Post;
import ipsen5.models.Reaction;
import ipsen5.repository.PostRepository;
import ipsen5.repository.ReactionRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ReactionService {
    private final ReactionRepository reactionRepository;
    private final PostRepository postRepository;

    public ReactionService(ReactionRepository reactionRepository, PostRepository postRepository) {
        this.reactionRepository = reactionRepository;
        this.postRepository = postRepository;
    }

    public List<Reaction> getAllReactions() {
        return this.reactionRepository.findAll();
    }

    public List<Reaction> getAllReactionsByPostId(UUID post_id) {
        Optional<Post> optionalPost = this.postRepository.findById(post_id);
        Post post = optionalPost.get();
        return this.reactionRepository.findByPostId(post);
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
