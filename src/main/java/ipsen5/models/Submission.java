package ipsen5.models;

import ipsen5.models.enums.PrefferedDestination;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9 .,!?()@&:'_-]+$", message = "1")
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9 .,!?()@&:'_-]+$", message = "1")
    private String online_profiles;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9 .,!?()@&:'_-]+$", message = "2")
    private String story_title;


    @Pattern(regexp = "^[a-zA-Z0-9 .,!?()@&:'_-]+$", message = "3")
    private String type;

    @NotNull
    @Min(0)
    private int wordCount;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9 .,!?()@&:'_-]+$", message = "5")
    private String genre;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9 .,!?()@&:'_-]+$", message = "6")
    private String additional_notes;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PrefferedDestination prefferd_destination;

    @NotNull
    private Boolean platform_presence;

    @NotNull
    private Boolean extra_feedback;

    @NotNull
    private Boolean express_experience;

    @ManyToOne
    @NotNull
    private Status statusID;

    @ManyToOne
    @NotNull
    private User user_id;
  
    @ManyToOne
    @NotNull
    private Rubric rubric;

    @Lob
    private byte[] pdf;

    @Lob
    private byte[] picture;


    public Submission(String name, String email, String online_profiles, String story_title, String type, int wordCount, String genre, String additional_notes, PrefferedDestination prefferd_destination, Boolean platform_presence, Boolean extra_feedback, Boolean express_experience, Status statusID, User user_id, Rubric rubric) {
        this.name = name;
        this.email = email;
        this.online_profiles = online_profiles;
        this.story_title = story_title;
        this.type = type;
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
