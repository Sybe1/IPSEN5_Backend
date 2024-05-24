package ipsen5.utils;

import ipsen5.dao.PostRepository;
import ipsen5.dao.UserRepository;
import ipsen5.models.Post;
import ipsen5.models.User;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
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
        post.setTitle("Rediscovering Babylon: The Truth Behind the Hanging Gardens");
        post.setImageUrl("https://escapewelt.com/image/catalog/products/v.3/QuestTower/Landing/01.jpg");
        post.setLocalDate(LocalDate.now());
        postRepository.save(post);

        Post post2 = new Post();
        post2.setUser(allUsers.get(0));
        post2.setText("Dit is de tweede post!");
        post2.setTitle("Verdant Wonders: Exploring the Enigmatic");
        post2.setImageUrl("https://cdn.openart.ai/stable_diffusion/171ddbee400feccf4e534dc4a85bd4b4c633b9a7_2000x2000.webp");
        post2.setLocalDate(LocalDate.now());
        postRepository.save(post2);

        Post post3 = new Post();
        post3.setUser(allUsers.get(0));
        post3.setText("Dit is de derde post!");
        post3.setTitle("the Ancient World’s Lost Paradise");
        post3.setImageUrl("https://img.freepik.com/premium-photo/mythical-creatures-fairytale-landscapes-magical-symbols-together-generative-ai_830962-3645.jpg");
        post3.setLocalDate(LocalDate.now());
        postRepository.save(post3);

        Post post4 = new Post();
        post4.setUser(allUsers.get(0));
        post4.setText("Dit is de vierde post!");
        post4.setTitle("101 stories");
        post4.setImageUrl("https://i.pinimg.com/736x/42/04/c6/4204c696523e94019d819ae8f6455011.jpg");
        post4.setLocalDate(LocalDate.now());
        postRepository.save(post4);

        Post post5 = new Post();
        post5.setUser(allUsers.get(0));
        post5.setText("Dit is de vijfde post!");
        post5.setTitle("A jump into Wonderland");
        post5.setImageUrl("https://images2.alphacoders.com/249/249810.jpg");
        post5.setLocalDate(LocalDate.now());
        postRepository.save(post5);

        Post post6 = new Post();
        post6.setUser(allUsers.get(0));
        post6.setText("Dit is de zesde post!");
        post6.setTitle("Adventures!!");
        post6.setImageUrl("https://images2.alphacoders.com/249/249810.jpg");
        post6.setLocalDate(LocalDate.now());
        postRepository.save(post6);

        Post post7 = new Post();
        post7.setUser(allUsers.get(0));
        post7.setText("Dit is de zevende post!");
        post7.setTitle("Mythical beast!");
        post7.setImageUrl("https://images2.alphacoders.com/249/249810.jpg");
        post7.setLocalDate(LocalDate.now());
        postRepository.save(post7);

        Post post8 = new Post();
        post8.setUser(allUsers.get(0));
        post8.setText("Dit is de achste post!");
        post8.setTitle("Running animal");
        post8.setImageUrl("https://images2.alphacoders.com/249/249810.jpg");
        post8.setLocalDate(LocalDate.now());
        postRepository.save(post8);

        Post post9 = new Post();
        post9.setUser(allUsers.get(0));
        post9.setText("Dit is de negende post!");
        post9.setTitle("Fast running");
        post9.setImageUrl("https://images2.alphacoders.com/249/249810.jpg");
        post9.setLocalDate(LocalDate.now());
        postRepository.save(post9);

        Post post10 = new Post();
        post10.setUser(allUsers.get(0));
        post10.setText("Dit is de tiende post!");
        post10.setTitle(" The dying human");
        post10.setImageUrl("https://images2.alphacoders.com/249/249810.jpg");
        post10.setLocalDate(LocalDate.now());
        postRepository.save(post10);
    }
}
