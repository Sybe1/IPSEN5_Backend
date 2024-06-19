package ipsen5.repository;

import ipsen5.models.Post;
import ipsen5.models.PostCategory;
import ipsen5.models.PostCategoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostCategoryRepository extends JpaRepository<PostCategory, PostCategoryId> {

    void deleteById_PostId(Post post);
}
