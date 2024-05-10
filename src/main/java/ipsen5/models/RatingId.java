package ipsen5.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class RatingId implements Serializable {
    @ManyToOne
    private User user_id;

    @ManyToOne
    private Post post_id;

    public RatingId() {
    }

    public RatingId(User user_id, Post post_id) {
        this.user_id = user_id;
        this.post_id = post_id;
    }
}
