package ipsen5.controller;

import ipsen5.dao.SocialMediaDAO;
import ipsen5.dto.SocialMediaDTO;
import ipsen5.models.SocialMedia;
import ipsen5.models.enums.SocialMediaCategories;
import ipsen5.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/social-media")
@CrossOrigin(origins = "http://localhost:4200")
public class SocialMediaController {

    @Autowired
    private SocialMediaDAO socialMediaDAO;

    @GetMapping
    public List<SocialMedia> getAllSocialMedia() {
        return socialMediaDAO.getAllSocialMedia();
    }



    @GetMapping("/user/{username}")
    public ResponseEntity<List<SocialMedia>> getSocialMediaByUsername(@PathVariable String username){
        return ResponseEntity.ok(this.socialMediaDAO.getSocialMediaByUsername(username));
    }

    @PostMapping
    public ResponseEntity<SocialMedia> createSocialMedia(@RequestBody SocialMediaDTO socialMediaDTO) {
        User user = socialMediaDTO.user;
        SocialMediaCategories socialMediaCategory = socialMediaDTO.socialMediaCategories;

        SocialMedia socialMedia = new SocialMedia(UUID.randomUUID(), user, socialMediaCategory, socialMediaDTO.socialMediaLink);
        SocialMedia savedSocialMedia = socialMediaDAO.saveSocialMedia(socialMedia);
        return new ResponseEntity<>(savedSocialMedia, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SocialMedia> updateSocialMedia(@PathVariable UUID id, @RequestBody SocialMediaDTO socialMediaDTO) {
        Optional<SocialMedia> existingSocialMedia = socialMediaDAO.getSocialMediaById(id);
        if (existingSocialMedia.isPresent()) {
            SocialMedia socialMedia = existingSocialMedia.get();
            socialMedia.setUser(socialMediaDTO.user);
            socialMedia.setSocialMediaCategory(socialMediaDTO.socialMediaCategories);
            socialMedia.setSocialMediaLink(socialMediaDTO.socialMediaLink);

            SocialMedia updatedSocialMedia = socialMediaDAO.saveSocialMedia(socialMedia);
            return new ResponseEntity<>(updatedSocialMedia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSocialMedia(@PathVariable UUID id) {
        Optional<SocialMedia> existingSocialMedia = socialMediaDAO.getSocialMediaById(id);
        if (existingSocialMedia.isPresent()) {
            socialMediaDAO.deleteSocialMedia(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
