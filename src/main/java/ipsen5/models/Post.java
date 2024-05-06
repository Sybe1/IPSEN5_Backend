package ipsen5.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue
    private UUID id;

    private String text;

    @ManyToOne
    private User user;

    public Post() {
    }

    public Post(String text, User user) {
        this.text = text;
        this.user = user;
    }
}
