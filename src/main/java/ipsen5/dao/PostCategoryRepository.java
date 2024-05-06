package ipsen5.dao;

import ipsen5.models.PostCategory;
import ipsen5.models.PostCategoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostCategoryRepository extends JpaRepository<PostCategory, PostCategoryId> {

}
