package ipsen5.utils;

import ipsen5.dao.*;
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
    private RubricRepository rubricRepository;
    private RoleRepository roleRepository;

    private PostSeeder postSeeder;
    private RoleSeeder roleSeeder;

    public Seeder(UserRepository userRepository, PostRepository postRepository,
                  CategoryRepository categoryRepository, PostCategoryRepository postCategoryRepository,
                  RubricRepository rubricRepository, RoleRepository roleRepository,

                  PostSeeder postSeeder, RoleSeeder roleSeeder
    ) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.categoryRepository = categoryRepository;
        this.postCategoryRepository = postCategoryRepository;
        this.rubricRepository = rubricRepository;
        this.roleRepository = roleRepository;

        this.postSeeder = postSeeder;
        this.roleSeeder = roleSeeder;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event){
        roleSeeder.seedRole();
        this.seedUser();
        postSeeder.seedPost();
        this.seedCategory();
        this.seedPostCategory();
        this.seedRubric();
    }


    private void seedUser(){
        User user = new User();
        user.setFirst_name("Mick");
        user.setLast_name("van Amstel");
        user.setEmail("test@mail.com");
        user.setPassword(new BCryptPasswordEncoder().encode("Test123!"));
        user.setDonation_link("https://www.paypal.com/nl/home");

        List<Role> allRoles = roleRepository.findAll();
        user.setRole(allRoles.get(0));
        userRepository.save(user);
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

    private void seedRubric(){
        Rubric rubric = new Rubric();
        rubric.setTitle("First Rubric");
        rubricRepository.save(rubric);
    }


}
