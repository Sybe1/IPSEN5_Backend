package ipsen5.utils;

import ipsen5.dao.CategoryRepository;
import ipsen5.dao.PostCategoryRepository;
import ipsen5.dao.PostRepository;
import ipsen5.models.Category;
import ipsen5.models.Post;
import ipsen5.models.PostCategory;
import ipsen5.models.PostCategoryId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostCategorySeeder {
    private PostRepository postRepository;
    private CategoryRepository categoryRepository;
    private PostCategoryRepository postCategoryRepository;

    public PostCategorySeeder(PostRepository postRepository, CategoryRepository categoryRepository, PostCategoryRepository postCategoryRepository) {
        this.postRepository = postRepository;
        this.categoryRepository = categoryRepository;
        this.postCategoryRepository = postCategoryRepository;
    }

    public void seedPostCategory(){
        List<Post> allPosts = postRepository.findAll();
        List<Category> allCategories = categoryRepository.findAll();

        PostCategoryId postCategoryId = new PostCategoryId(allPosts.get(0), allCategories.get(0));
        PostCategory postCategory = new PostCategory();
        postCategory.setId(postCategoryId);
        postCategoryRepository.save(postCategory);

        PostCategoryId postCategoryId2 = new PostCategoryId(allPosts.get(1), allCategories.get(0));
        PostCategory postCategory2 = new PostCategory();
        postCategory2.setId(postCategoryId2);
        postCategoryRepository.save(postCategory2);

        PostCategoryId postCategoryId3 = new PostCategoryId(allPosts.get(1), allCategories.get(1));
        PostCategory postCategory3 = new PostCategory();
        postCategory3.setId(postCategoryId3);
        postCategoryRepository.save(postCategory3);
    }
}
