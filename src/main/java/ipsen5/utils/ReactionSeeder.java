package ipsen5.utils;

import ipsen5.repository.PostRepository;
import ipsen5.repository.ReactionRepository;
import ipsen5.repository.UserRepository;
import ipsen5.models.Post;
import ipsen5.models.Reaction;
import ipsen5.models.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReactionSeeder {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final ReactionRepository reactionRepository;

    public ReactionSeeder(PostRepository postRepository, UserRepository userRepository, ReactionRepository reactionRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.reactionRepository = reactionRepository;
    }

    public void seedReaction(){
        List<User> allUsers = userRepository.findAll();
        List<Post> allPosts = postRepository.findAll();

        Reaction reaction = new Reaction();
        reaction.setText("De post is erg mooi");
        reaction.setUser_id(allUsers.get(0));
        reaction.setPostId(allPosts.get(0));
        reactionRepository.save(reaction);

        Reaction reaction2 = new Reaction();
        reaction2.setText("De post is kort");
        reaction2.setUser_id(allUsers.get(0));
        reaction2.setPostId(allPosts.get(1));
        reactionRepository.save(reaction2);

        Reaction reaction3 = new Reaction();
        reaction3.setText("De post had beter gekund!");
        reaction3.setUser_id(allUsers.get(1));
        reaction3.setPostId(allPosts.get(1));
        reactionRepository.save(reaction3);
    }
}
