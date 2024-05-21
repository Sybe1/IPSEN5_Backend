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
        List<User> allUsers = userRepository.findAll();

        Post post = new Post();
        post.setUser(allUsers.get(0));
        post.setText("Dit is de eerste post!");
        post.setImage("../../../assets/images/Afbeelding2.png");
        post.setTitle("Verdant Wonders");
        post.setDescription("Explore the timeless allure of the legendary Gardens of Babylon.");
        postRepository.save(post);

        Post post2 = new Post();
        post2.setUser(allUsers.get(1));
        post2.setText("Dit is de tweede post!");
        post2.setImage("../../../assets/images/Afbeelding3.png");
        post2.setTitle("Lost in Time: Ancient Civilizations");
        post2.setDescription("Transport yourself back to the enigmatic realms of ancient civilizations.");
        postRepository.save(post2);

        Post post3 = new Post();
        post3.setUser(allUsers.get(2));
        post3.setText("Dit is de derde post!");
        post3.setImage("../../../assets/images/Afbeelding4.png");
        post3.setTitle("Epic Adventures: Journey Across the World");
        post3.setDescription("Embark on an exhilarating expedition spanning continents and cultures");
        postRepository.save(post3);
    }
}
