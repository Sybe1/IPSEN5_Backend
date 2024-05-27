package ipsen5.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
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
    @ManyToOne
    private User user;

    public Post() {
    }

    public Post(String title, String text, String imageUrl, LocalDate localDate, User user) {
        this.title = title;
        this.text = text;
        this.imageUrl = imageUrl;
        this.localDate = localDate;
        this.user = user;
    }
}
