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
public class Rating {
    @Id
    @GeneratedValue
    private UUID id;

    private int grade;
    @ManyToOne
    private User user_id;

    @ManyToOne
    private Post post_id;

    public Rating(int grade, Post postId) {

    }

    public Rating() {
    }
}
