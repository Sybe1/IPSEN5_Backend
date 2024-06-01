package ipsen5.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FeedbackPerElement {
    @EmbeddedId
    @JsonProperty("id")
    private FeedbackPerElementId id;

    private int grade;
    private String feedback;

    public FeedbackPerElement() {
    }

    public FeedbackPerElement(FeedbackPerElementId id, int grade, String feedback){
        this.id = id;
        this.grade = grade;
        this.feedback = feedback;
    }
}
