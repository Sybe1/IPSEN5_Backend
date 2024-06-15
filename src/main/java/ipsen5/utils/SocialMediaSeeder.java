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
    private final UserRepository userRepository;
    private final SocialMediaRepository socialMediaRepository;

    public SocialMediaSeeder(UserRepository userRepository, SocialMediaRepository socialMediaRepository) {
        this.userRepository = userRepository;
        this.socialMediaRepository = socialMediaRepository;
    }

    public void seedSocialMedia() {
        SocialMedia socialMedia = new SocialMedia();
        List<User> allUsers = userRepository.findAll();
        socialMedia.setUser(allUsers.get(0));
        socialMedia.setSocialMediaCategory(SocialMediaCategories.INSTAGRAM);
        socialMedia.setSocialMediaLink("https://www.instagram.com/babelcompany/");
        socialMediaRepository.save(socialMedia);

        SocialMedia socialMedia2 = new SocialMedia();
        socialMedia2.setUser(allUsers.get(0));
        socialMedia2.setSocialMediaCategory(SocialMediaCategories.YOUTUBE);
        socialMedia2.setSocialMediaLink("https://www.youtube.com/@BabelShops");
        socialMediaRepository.save(socialMedia2);

        SocialMedia socialMedia3 = new SocialMedia();
        socialMedia3.setUser(allUsers.get(0));
        socialMedia3.setSocialMediaCategory(SocialMediaCategories.TWITTER);
        socialMedia3.setSocialMediaLink("https://twitter.com/babelcompany");
        socialMediaRepository.save(socialMedia3);

        SocialMedia socialMedia4 = new SocialMedia();
        socialMedia4.setUser(allUsers.get(0));
        socialMedia4.setSocialMediaCategory(SocialMediaCategories.FACEBOOK);
        socialMedia4.setSocialMediaLink("https://www.facebook.com/p/Babel-Company-100008296754297/?locale=nl_BE");
        socialMediaRepository.save(socialMedia4);
    }
}