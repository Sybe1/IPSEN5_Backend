package ipsen5.models;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class PostCategoryId implements Serializable {
    @ManyToOne(cascade = CascadeType.REMOVE)
    @NotNull
    private Post postId;

    @ManyToOne
    @NotNull
    private Category categoryId;

    public PostCategoryId(Post postId, Category categoryId) {
        this.postId = postId;
        this.categoryId = categoryId;
    }

    public PostCategoryId() {

    }
}
