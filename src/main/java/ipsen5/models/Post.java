package ipsen5.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
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

    private String title;
    private String text;
    private String imageUrl;
    private LocalDate localDate;
    @ElementCollection
    private List<String> genres;
    @ManyToOne
    private User user;

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
}
