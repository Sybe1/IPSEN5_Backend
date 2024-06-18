package ipsen5.services;

import ipsen5.models.SocialMedia;
import ipsen5.models.User;
import ipsen5.repository.SocialMediaRepository;
import ipsen5.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class SocialMediaService {

    private final SocialMediaRepository repository;
    private final UserRepository userRepository;

    public SocialMediaService(SocialMediaRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

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
