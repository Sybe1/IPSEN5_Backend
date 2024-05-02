package ipsen5.utils;

import ipsen5.dao.CategoryRepository;
import ipsen5.dao.PostCategoryRepository;
import ipsen5.dao.PostRepository;
import ipsen5.dao.UserRepository;
import ipsen5.models.*;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Seeder {
    private UserRepository userRepository;
    private PostRepository postRepository;
    private CategoryRepository categoryRepository;
    private PostCategoryRepository postCategoryRepository;


    public Seeder(UserRepository userRepository, PostRepository postRepository,
                  CategoryRepository categoryRepository, PostCategoryRepository postCategoryRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.categoryRepository = categoryRepository;
        this.postCategoryRepository = postCategoryRepository;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event){
        this.seedUser();
        this.seedPost();
        this.seedCategory();
        this.seedPostCategory();
    }


    private void seedUser(){
        User user = new User();
        user.setFirst_name("Mick");
        user.setLast_name("van Amstel");
        user.setEmail("test@mail.com");
        user.setPassword(new BCryptPasswordEncoder().encode("Test123!"));
        user.setDonation_link("https://www.paypal.com/nl/home");
        userRepository.save(user);
    }

    private void seedPost(){
        Post post = new Post();
        List<User> allUsers = userRepository.findAll();
        post.setUser(allUsers.get(0));
        post.setText("Dit is de eerste post!");
        postRepository.save(post);

        Post post1 = new Post();
        post1.setUser(allUsers.get(0));
        post1.setText("Dit is de tweede post!");
        postRepository.save(post1);
    }

    private void seedCategory(){
        Category category = new Category();
        category.setName("Official Selection");
        category.setDescription("Hier staan alle posts in die door de keuring zijn gekomen.");
        categoryRepository.save(category);
    }

    private void seedPostCategory(){
        List<Post> allPosts = postRepository.findAll();
        List<Category> allCategories = categoryRepository.findAll();
        PostCategoryId postCategoryId = new PostCategoryId(allPosts.get(0), allCategories.get(0));

        PostCategory postCategory = new PostCategory();
        postCategory.setId(postCategoryId);
        postCategoryRepository.save(postCategory);
    }
}
