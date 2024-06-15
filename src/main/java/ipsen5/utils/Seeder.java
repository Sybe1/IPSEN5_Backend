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
    private final PostSeeder postSeeder;
    private final RoleSeeder roleSeeder;
    private final UserSeeder userSeeder;
    private final CategorySeeder categorySeeder;
    private final PostCategorySeeder postCategorySeeder;
    private final RubricSeeder rubricSeeder;
    private final ReactionSeeder reactionSeeder;
    private final SubmissionSeeder submissionSeeder;
    private final StatusSeeder statusSeeder;
    private final CriteriaSeeder criteriaSeeder;
    private final FeedbackPerElementSeeder feedbackPerElementSeeder;
    private final RolePriviligesSeeder rolePriviligesSeeder;
    private final RatingSeeder ratingSeeder;
    private final SocialMediaSeeder socialMediaSeeder;


    public Seeder(PostSeeder postSeeder,
                  RoleSeeder roleSeeder,
                  UserSeeder userSeeder,
                  CategorySeeder categorySeeder,
                  PostCategorySeeder postCategorySeeder,
                  RubricSeeder rubricSeeder,
                  ReactionSeeder reactionSeeder,
                  SubmissionSeeder submissionSeeder,
                  StatusSeeder statusSeeder,
                  CriteriaSeeder criteriaSeeder,
                  FeedbackPerElementSeeder feedbackPerElementSeeder,
                  RolePriviligesSeeder rolePriviligesSeeder,
                  RatingSeeder ratingSeeder,
                  SocialMediaSeeder socialMediaSeeder
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
        this.socialMediaSeeder = socialMediaSeeder;
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
        socialMediaSeeder.seedSocialMedia();
    }
}
