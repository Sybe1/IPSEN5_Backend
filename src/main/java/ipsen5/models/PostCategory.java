package ipsen5.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PostCategory {
    @EmbeddedId
    private PostCategoryId id;

    public PostCategory(PostCategoryId id) {
        this.id = id;
    }

    public PostCategory() {
    }
}
