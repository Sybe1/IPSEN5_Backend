package ipsen5.models;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class RubricElementsId implements Serializable{
    @ManyToOne
    private Criteria criteriaId;
    @ManyToOne
    private Rubric rubricId;

    public RubricElementsId() {
    }

    public RubricElementsId(Criteria criteriaId, Rubric rubricId) {
        this.criteriaId = criteriaId;
        this.rubricId = rubricId;
    }
}
