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
    private String name;
    private String email;
    private String online_profiles;
    private String story_title;
    private String type;
    private String text;
    private int wordCount;
    private String genre;
    private String additional_notes;
    private String prefferd_destination;
    private Boolean platform_presence;
    private Boolean extra_feedback;
    private Boolean express_experience;

    @ManyToOne
    private Status statusID;

    @ManyToOne
    private User user_id;
  
    @ManyToOne
    private Rubric rubric;

    @Lob
    private byte[] pdf;


    public Submission(String name, String email, String online_profiles, String story_title, String type, String text, int wordCount, String genre, String additional_notes, String prefferd_destination, Boolean platform_presence, Boolean extra_feedback, Boolean express_experience, Status statusID, User user_id, Rubric rubric) {
        this.name = name;
        this.email = email;
        this.online_profiles = online_profiles;
        this.story_title = story_title;
        this.type = type;
        this.text = text;
        this.wordCount = wordCount;
        this.genre = genre;
        this.additional_notes = additional_notes;
        this.prefferd_destination = prefferd_destination;
        this.platform_presence = platform_presence;
        this.extra_feedback = extra_feedback;
        this.express_experience = express_experience;
        this.statusID = statusID;
        this.user_id = user_id;
        this.rubric = rubric;
    }

    public Submission() {

    }
}
