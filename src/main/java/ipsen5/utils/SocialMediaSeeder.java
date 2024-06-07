package ipsen5.utils;

import ipsen5.dao.PostRepository;
import ipsen5.dao.SocialMediaRepository;
import ipsen5.dao.UserRepository;
import ipsen5.models.Post;
import ipsen5.models.SocialMedia;
import ipsen5.models.User;
import ipsen5.models.enums.SocialMediaCategories;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class SocialMediaSeeder {
    private UserRepository userRepository;
    private SocialMediaRepository socialMediaRepository;

    public SocialMediaSeeder(UserRepository userRepository, SocialMediaRepository socialMediaRepository) {
        this.userRepository = userRepository;
        this.socialMediaRepository = socialMediaRepository;
    }

    public void seedSocialMedia() {
        SocialMedia socialMedia = new SocialMedia();
        List<User> allUsers = userRepository.findAll();
        socialMedia.setUser(allUsers.get(0));
        socialMedia.setSocialMediaCategory(SocialMediaCategories.INSTAGRAM);
        socialMedia.setSocialMediaLink("www.instagram.com");
        socialMediaRepository.save(socialMedia);

        SocialMedia socialMedia2 = new SocialMedia();
        socialMedia2.setUser(allUsers.get(0));
        socialMedia2.setSocialMediaCategory(SocialMediaCategories.YOUTUBE);
        socialMedia2.setSocialMediaLink("www.youtube.com");
        socialMediaRepository.save(socialMedia2);

        SocialMedia socialMedia3 = new SocialMedia();
        socialMedia3.setUser(allUsers.get(0));
        socialMedia3.setSocialMediaCategory(SocialMediaCategories.TWITTER);
        socialMedia3.setSocialMediaLink("www.x.com");
        socialMediaRepository.save(socialMedia3);
    }
}