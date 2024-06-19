package ipsen5.controller;

import ipsen5.services.PostCategoryService;
import ipsen5.dto.PostCategoryDTO;
import ipsen5.models.Category;
import ipsen5.models.Post;
import ipsen5.models.PostCategory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://clownfish-app-5x89u.ondigitalocean.app"})
@RequestMapping("/postcategory")
public class PostCategoryController {

    private final PostCategoryService postCategoryService;

    public PostCategoryController(PostCategoryService postCategoryService) {
        this.postCategoryService = postCategoryService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('POSTCATEGORY_GET') || hasAuthority('POSTCATEGORY') || hasAuthority('ALL') || hasAuthority('GETTEN')")
    public ResponseEntity<List<PostCategory>> getPostCategories() {
        return ResponseEntity.ok(this.postCategoryService.getPostCategories());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('POSTCATEGORY_POST') || hasAuthority('POSTCATEGORY') || hasAuthority('ALL') || hasAuthority('POSTEN')")
    public  ResponseEntity<String> createPostCategory(@RequestBody PostCategoryDTO postCategoryDTO) {
        this.postCategoryService.createPostCategory(postCategoryDTO);
        return ResponseEntity.ok("Created a new PostCategory with PostId " + postCategoryDTO.post + "and CategoryId " + postCategoryDTO.category);
    }

    @DeleteMapping("/{postId}/{categoryId}")
    @PreAuthorize("hasAuthority('POSTCATEGORY_DELETE') || hasAuthority('POSTCATEGORY') || hasAuthority('ALL') || hasAuthority('DELETEN')")
    public ResponseEntity<?> deletePostCategory(@PathVariable Post postId, @PathVariable Category categoryId) {
        this.postCategoryService.deletePostCategory(postId, categoryId);
        return ResponseEntity.ok("deleted PostCategory with postId: " + postId + "and categoryId" + categoryId);
    }
}

