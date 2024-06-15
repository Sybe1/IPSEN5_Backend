package ipsen5.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Reaction {
    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9 .,!?()@&:'-]+$")
    private String text;

    @ManyToOne
    @NotNull
    private Post postId;

    @ManyToOne
    @NotNull
    private User user_id;

    public Reaction(String text, Post post_id, User user_id) {
        this.id = id;
        this.text = text;
        this.postId = post_id;
        this.user_id = user_id;
    }

    public Reaction() {

    }
}
