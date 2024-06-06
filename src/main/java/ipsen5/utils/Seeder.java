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
    private PostSeeder postSeeder;
    private RoleSeeder roleSeeder;
    private UserSeeder userSeeder;
    private CategorySeeder categorySeeder;
    private PostCategorySeeder postCategorySeeder;
    private RubricSeeder rubricSeeder;
    private ReactionSeeder reactionSeeder;
    private SubmissionSeeder submissionSeeder;
    private StatusSeeder statusSeeder;
    private CriteriaSeeder criteriaSeeder;
    private FeedbackPerElementSeeder feedbackPerElementSeeder;
    private RolePriviligesSeeder rolePriviligesSeeder;
    private RatingSeeder ratingSeeder;

    public Seeder(PostSeeder postSeeder, RoleSeeder roleSeeder, UserSeeder userSeeder, CategorySeeder categorySeeder,
                  PostCategorySeeder postCategorySeeder, RubricSeeder rubricSeeder, ReactionSeeder reactionSeeder,
                  SubmissionSeeder submissionSeeder, StatusSeeder statusSeeder,
                  CriteriaSeeder criteriaSeeder,
                  FeedbackPerElementSeeder feedbackPerElementSeeder, RolePriviligesSeeder rolePriviligesSeeder,
                  RatingSeeder ratingSeeder
    ) {
        this.postSeeder = postSeeder;
        this.roleSeeder = roleSeeder;
        this.userSeeder = userSeeder;
        this.categorySeeder = categorySeeder;
        this.postCategorySeeder = postCategorySeeder;
        this.rubricSeeder = rubricSeeder;
        this.reactionSeeder = reactionSeeder;
        this.submissionSeeder = submissionSeeder;
        this.statusSeeder = statusSeeder;
        this.criteriaSeeder = criteriaSeeder;
        this.feedbackPerElementSeeder = feedbackPerElementSeeder;
        this.rolePriviligesSeeder = rolePriviligesSeeder;
        this.ratingSeeder = ratingSeeder;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event){
        roleSeeder.seedRole();
        userSeeder.seedUser();
        postSeeder.seedPost();
        categorySeeder.seedCategory();
        postCategorySeeder.seedPostCategory();
        rubricSeeder.seedRubric();
        reactionSeeder.seedReaction();
        statusSeeder.seedStatus();
        criteriaSeeder.seedCriteria();
        submissionSeeder.seedSubmission();
        feedbackPerElementSeeder.seedRubricElements();
        rolePriviligesSeeder.seedRolePriviliges();
        ratingSeeder.seedRating();
    }
}
