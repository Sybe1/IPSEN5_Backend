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
public class Submission {
    @Id
    @GeneratedValue
    private UUID id;
    private String text;
    @ManyToOne
    private Post post_id;

    @ManyToOne
    private User user_id;

    public Submission(String text, User userId, Post post_id) {

    }

    public Submission() {

    }
}
