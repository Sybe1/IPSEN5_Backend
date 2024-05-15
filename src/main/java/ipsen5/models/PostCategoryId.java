package ipsen5.models;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class PostCategoryId implements Serializable {
    @ManyToOne
    private Post postId;

    @ManyToOne
    private Category categoryId;

    public PostCategoryId(Post postId, Category categoryId) {
        this.postId = postId;
        this.categoryId = categoryId;
    }

    public PostCategoryId() {

    }
}
