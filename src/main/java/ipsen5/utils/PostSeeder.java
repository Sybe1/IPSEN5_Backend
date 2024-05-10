package ipsen5.utils;

import ipsen5.dao.PostRepository;
import ipsen5.dao.UserRepository;
import ipsen5.models.Post;
import ipsen5.models.User;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostSeeder {

    private UserRepository userRepository;
    private PostRepository postRepository;

    public PostSeeder(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public void seedPost(){
        Post post = new Post();
        List<User> allUsers = userRepository.findAll();
        post.setUser(allUsers.get(0));
        post.setText("Dit is de eerste post!");
        postRepository.save(post);

        Post post2 = new Post();
        post2.setUser(allUsers.get(0));
        post2.setText("Dit is de tweede post!");
        postRepository.save(post2);

        Post post3 = new Post();
        post3.setUser(allUsers.get(0));
        post2.setText("Dit is de derde post!");
        postRepository.save(post3);
    }
}
