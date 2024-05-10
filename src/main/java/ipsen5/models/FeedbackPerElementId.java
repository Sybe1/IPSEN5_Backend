package ipsen5.models;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class FeedbackPerElementId implements Serializable{
    @ManyToOne
    private Feedback feedbackId;
    @ManyToOne
    private Criteria criteriaId;

    public FeedbackPerElementId() {
    }

    public FeedbackPerElementId(Criteria criteriaId, Feedback feedbackId) {
        this.criteriaId = criteriaId;
        this.feedbackId = feedbackId;
    }
}
