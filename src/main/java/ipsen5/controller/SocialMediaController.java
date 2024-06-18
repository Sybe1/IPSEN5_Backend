package ipsen5.controller;

import ipsen5.services.SocialMediaService;
import ipsen5.dto.SocialMediaDTO;
import ipsen5.models.SocialMedia;
import ipsen5.models.enums.SocialMediaCategories;
import ipsen5.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/social-media")
@CrossOrigin(origins = "http://localhost:4200")
public class SocialMediaController {

    private final SocialMediaService socialMediaService;

    public SocialMediaController(SocialMediaService socialMediaService) {
        this.socialMediaService = socialMediaService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('SOCIALMEDIA_GET') || hasAuthority('SOCIALMEDIA') || hasAuthority('ALL') || hasAuthority('GETTEN')")
    public List<SocialMedia> getAllSocialMedia() {
        return socialMediaService.getAllSocialMedia();
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<SocialMedia>> getSocialMediaByUsername(@PathVariable String username){
        return ResponseEntity.ok(this.socialMediaService.getSocialMediaByUsername(username));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('SOCIALMEDIA_POST') || hasAuthority('SOCIALMEDIA') || hasAuthority('ALL') || hasAuthority('POSTEN')")
    public ResponseEntity<SocialMedia> createSocialMedia(@RequestBody SocialMediaDTO socialMediaDTO) {
        User user = socialMediaDTO.user;
        SocialMediaCategories socialMediaCategory = socialMediaDTO.socialMediaCategories;

        SocialMedia socialMedia = new SocialMedia(UUID.randomUUID(), user, socialMediaCategory, socialMediaDTO.socialMediaLink);
        SocialMedia savedSocialMedia = socialMediaService.saveSocialMedia(socialMedia);
        return new ResponseEntity<>(savedSocialMedia, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('SOCIALMEDIA_PUT') || hasAuthority('SOCIALMEDIA') || hasAuthority('ALL') || hasAuthority('UPDATEN')")
    public ResponseEntity<SocialMedia> updateSocialMedia(@PathVariable UUID id, @RequestBody SocialMediaDTO socialMediaDTO) {
        Optional<SocialMedia> existingSocialMedia = socialMediaService.getSocialMediaById(id);
        if (existingSocialMedia.isPresent()) {
            SocialMedia socialMedia = existingSocialMedia.get();
            socialMedia.setUser(socialMediaDTO.user);
            socialMedia.setSocialMediaCategory(socialMediaDTO.socialMediaCategories);
            socialMedia.setSocialMediaLink(socialMediaDTO.socialMediaLink);

            SocialMedia updatedSocialMedia = socialMediaService.saveSocialMedia(socialMedia);
            return new ResponseEntity<>(updatedSocialMedia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SOCIALMEDIA_DELETE') || hasAuthority('SOCIALMEDIA') || hasAuthority('ALL') || hasAuthority('DELETEN')")
    public ResponseEntity<Void> deleteSocialMedia(@PathVariable UUID id) {
        Optional<SocialMedia> existingSocialMedia = socialMediaService.getSocialMediaById(id);
        if (existingSocialMedia.isPresent()) {
            socialMediaService.deleteSocialMedia(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
