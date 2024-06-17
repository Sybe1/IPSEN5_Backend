package ipsen5.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity(name = "Users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9_]{3,20}$", message = "Username must be between 3 and 20 characters long and can only contain letters, numbers, and underscores")
    private String username;

    @NotBlank
    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ'\\-\\s]+$", message = "First name can only contain letters, hyphens, and spaces")
    private String first_name;

    @NotBlank
    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ'\\-\\s]+$", message = "Last name can only contain letters, hyphens, and spaces")
    private String last_name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    @Pattern(regexp = "^https?://(?:www\\.)?[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}(?:/[^\\s]*)?$", message = "Invalid URL format")
    private String imageUrl;

    @NotBlank
    @Pattern(regexp = "^https?://(?:www\\.)?[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}(?:/[^\\s]*)?$", message = "Invalid URL format")
    private String donation_link;

    @ManyToOne
    private Role role;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Notification> notifications;

    public User() {
    }

    public User(String username, String first_name, String last_name, String email, String password, String imageUrl, String donation_link, Role role) {
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.imageUrl = imageUrl;
        this.donation_link = donation_link;
        this.role = role;
    }
}
