package ipsen5.models;

import ipsen5.models.enums.SocialMediaCategories;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class SocialMedia {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @NotNull
    private User user;

    @NotNull
    private SocialMediaCategories socialMediaCategory;

    @NotBlank
    private String socialMediaLink;


    public SocialMedia() {
    }

    public SocialMedia(UUID id, User user, SocialMediaCategories socialMediaCategory, String socialMediaLink) {
        this.id = id;
        this.user = user;
        this.socialMediaCategory = socialMediaCategory;
        this.socialMediaLink = socialMediaLink;
    }
}
