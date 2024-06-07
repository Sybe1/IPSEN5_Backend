package ipsen5.dao;

import ipsen5.models.Post;
import ipsen5.models.SocialMedia;
import ipsen5.dao.SocialMediaRepository;
import ipsen5.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class SocialMediaDAO {

    @Autowired
    private SocialMediaRepository repository;
    @Autowired
    private UserRepository userRepository;

    public List<SocialMedia> getAllSocialMedia() {
        return repository.findAll();
    }

    public Optional<SocialMedia> getSocialMediaById(UUID id) {
        return repository.findById(id);
    }

    public List<SocialMedia> getSocialMediaByUsername(String username) {
        User user = this.userRepository.findByUsername(username);
        return this.repository.findByUser(user);
    }

    public SocialMedia saveSocialMedia(SocialMedia socialMedia) {
        return repository.save(socialMedia);
    }

    public void deleteSocialMedia(UUID id) {
        repository.deleteById(id);
    }
}
