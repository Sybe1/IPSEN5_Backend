package ipsen5.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RubricElements {
    @EmbeddedId
    private RubricElementsId id;

    public RubricElements() {
    }

    public RubricElements(RubricElementsId id) {
        this.id = id;
    }
}
