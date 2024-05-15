package ipsen5.dao;

import ipsen5.dto.PostCategoryDTO;
import ipsen5.models.Category;
import ipsen5.models.Post;
import ipsen5.models.PostCategory;
import ipsen5.models.PostCategoryId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class PostCategoryDAO {

    private final PostCategoryRepository postCategoryRepository;

    public PostCategoryDAO(PostCategoryRepository postCategoryRepository) {
        this.postCategoryRepository = postCategoryRepository;
    }

    public List<PostCategory> getPostCategories() {
        return this.postCategoryRepository.findAll();
    }

    public void createPostCategory(PostCategoryDTO postCategoryDTO) {
        PostCategoryId postCategoryId = new PostCategoryId(postCategoryDTO.post, postCategoryDTO.category);
        this.postCategoryRepository.save(new PostCategory(postCategoryId));
    }

    public void deletePostCategory(Post postId, Category categoryId) {
        PostCategoryId postCategoryId = new PostCategoryId(postId, categoryId);
        this.postCategoryRepository.findById(postCategoryId).orElseThrow(() -> new RuntimeException("PostCategory not found"));
        this.postCategoryRepository.deleteById(postCategoryId);
    }
}
