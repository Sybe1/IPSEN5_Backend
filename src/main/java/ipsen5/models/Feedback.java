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
public class Feedback {
    @Id
    @GeneratedValue
    private UUID id;

    private String general_text;

    @ManyToOne
    private User user;

    @ManyToOne
    private Rubric rubric;

    public Feedback() {
    }

    public Feedback(String general_text, User user, Rubric rubric) {
        this.general_text = general_text;
        this.user = user;
        this.rubric = rubric;
    }
}
