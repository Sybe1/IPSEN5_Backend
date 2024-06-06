package ipsen5.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne
    @JoinColumn(name = "post_id_id" , insertable = false, updatable = false)
    @JsonBackReference
    private Post post;

    public Rating(RatingId id, int grade) {
        this.id = id;
        this.grade = grade;
    }

    public Rating() {
    }
}
