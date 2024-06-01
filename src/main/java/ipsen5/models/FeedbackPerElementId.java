package ipsen5.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@EqualsAndHashCode
@Getter
@Setter
public class FeedbackPerElementId implements Serializable{
    @ManyToOne
    private Submission submissionId;
    @ManyToOne
    private Criteria criteriaId;

    public FeedbackPerElementId() {
    }

    public FeedbackPerElementId(Criteria criteriaId, Submission submission) {
        this.criteriaId = criteriaId;
        this.submissionId = submission;
    }
}
