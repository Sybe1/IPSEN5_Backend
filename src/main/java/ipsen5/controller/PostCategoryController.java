package ipsen5.controller;

import ipsen5.dao.PostCategoryDAO;
import ipsen5.dto.PostCategoryDTO;
import ipsen5.models.Category;
import ipsen5.models.Post;
import ipsen5.models.PostCategory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postcategory")
public class PostCategoryController {

    private final PostCategoryDAO postCategoryDAO;

    public PostCategoryController(PostCategoryDAO postCategoryDAO) {
        this.postCategoryDAO = postCategoryDAO;
    }

    @GetMapping
    public ResponseEntity<List<PostCategory>> getPostCategories() {
        return ResponseEntity.ok(this.postCategoryDAO.getPostCategories());
    }

    @PostMapping
    public  ResponseEntity<String> createPostCategory(@RequestBody PostCategoryDTO postCategoryDTO) {
        this.postCategoryDAO.createPostCategory(postCategoryDTO);
        return ResponseEntity.ok("Created a new PostCategory with PostId " + postCategoryDTO.post + "and CategoryId " + postCategoryDTO.category);
    }

    @DeleteMapping("/{postId}/{categoryId}")
    public ResponseEntity<?> deletePostCategory(@PathVariable Post postId, @PathVariable Category categoryId) {
        this.postCategoryDAO.deletePostCategory(postId, categoryId);
        return ResponseEntity.ok("deleted PostCategory with postId: " + postId + "and categoryId" + categoryId);
    }
}

