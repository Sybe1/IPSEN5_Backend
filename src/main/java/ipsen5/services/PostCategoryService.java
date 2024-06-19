package ipsen5.services;

import ipsen5.dto.PostCategoryDTO;
import ipsen5.models.Category;
import ipsen5.models.Post;
import ipsen5.models.PostCategory;
import ipsen5.models.PostCategoryId;
import ipsen5.repository.PostCategoryRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostCategoryService {

    private final PostCategoryRepository postCategoryRepository;

    public PostCategoryService(PostCategoryRepository postCategoryRepository) {
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
