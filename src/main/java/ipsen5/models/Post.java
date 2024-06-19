package ipsen5.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9 .,!?()@&:`'-]+$", message = "Title not right format")
    private String title;

    @Column(columnDefinition = "TEXT")
    @NotBlank
    private String text;

    @NotBlank
    @URL
    private String imageUrl;

    @NotNull
    private LocalDate localDate;

    @ElementCollection
    private List<String> genres;

    @ManyToOne
    @NotNull
    private User user;

    @OneToMany(mappedBy = "post")
    @JsonManagedReference
    private List<Rating> ratings;

    public Post() {
    }

    public Post(String title, String text, String imageUrl, LocalDate localDate, List<String> genres, User user) {
        this.title = title;
        this.text = text;
        this.imageUrl = imageUrl;
        this.localDate = localDate;
        this.genres = genres;
        this.user = user;
    }

    public double getAverageRating() {
        return ratings.stream()
                .filter(rating -> rating.getPost().getId().equals(this.id))
                .mapToInt(Rating::getGrade)
                .average()
                .orElse(0.0);
    }
}
