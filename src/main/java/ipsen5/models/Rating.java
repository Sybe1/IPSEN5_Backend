package ipsen5.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Rating {
    @EmbeddedId
    private RatingId id;

    private int grade;

    public Rating(RatingId id, int grade) {
        this.id = id;
        this.grade = grade;
    }

    public Rating() {
    }
}
