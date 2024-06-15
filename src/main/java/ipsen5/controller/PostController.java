package ipsen5.controller;

import ipsen5.dao.PostDAO;
import ipsen5.dto.PostDTO;
import ipsen5.models.Post;
import ipsen5.services.PostValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/post")
public class PostController {
    private final PostDAO postDAO;
    private PostValidator validator;
    public PostController(PostDAO postDAO, PostValidator validator) {
        this.postDAO = postDAO;
        this.validator = validator;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(){
        return ResponseEntity.ok(this.postDAO.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Post>> getPostById(@PathVariable UUID id){
        return ResponseEntity.ok(this.postDAO.getPostById(id));
    }

    @GetMapping("/user/{user}")
    public ResponseEntity<List<Post>> getPostsByUserId(@PathVariable String user){
        return ResponseEntity.ok(this.postDAO.getPostsByUserId(user));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('POST_POST') || hasAuthority('POST') || hasAuthority('ALL') || hasAuthority('POSTEN')")
    public ResponseEntity<String> createPost(@RequestBody PostDTO postDTO){
        validator.postValidations(postDTO);
        this.postDAO.createPost(postDTO);
        return ResponseEntity.ok("Created a new Post");
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('POST_PUT') || hasAuthority('POST') || hasAuthority('ALL') || hasAuthority('UPDATEN')")
    public ResponseEntity<String> editPost(@PathVariable UUID id, @RequestBody PostDTO postDTO){
        validator.postValidations(postDTO);
        this.postDAO.editPost(id, postDTO);
        return ResponseEntity.ok("Edited post with id: " + id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('POST_DELETE') || hasAuthority('POST') || hasAuthority('ALL') || hasAuthority('DELETEN')")
    public ResponseEntity<?> deletePost(@PathVariable("id") UUID id){
        this.postDAO.deletePost(id);
        return ResponseEntity.ok("deleted post with id: " + id);
    }

    @GetMapping("/search/{title}")
    @PreAuthorize("hasAuthority('POST_GET') || hasAuthority('POST') || hasAuthority('ALL') || hasAuthority('GETTEN')")
    public ResponseEntity<List<Post>> searchPostsByTitle(@PathVariable String title) {
        List<Post> posts = postDAO.searchPostsByTitle(title);
        return ResponseEntity.ok(posts);
    }
}
