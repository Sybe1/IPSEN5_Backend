package ipsen5.models;

import jakarta.persistence.*;
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
    private Boolean extra_feedback;
    private String story_Details;
    @OneToOne
    private Feedback feedbackID;

    @ManyToOne
    private Status statusID;

    @ManyToOne
    private User user_id;

    public Submission(String text, Boolean extra_feedback, String story_Details, Feedback feedbackID, Status statusID, User user_id) {
        this.text = text;
        this.extra_feedback = extra_feedback;
        this.story_Details = story_Details;
        this.feedbackID = feedbackID;
        this.statusID = statusID;
        this.user_id = user_id;
    }

    public Submission() {

    }
}
