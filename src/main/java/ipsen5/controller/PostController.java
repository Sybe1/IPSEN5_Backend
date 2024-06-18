package ipsen5.controller;

import ipsen5.services.PostService;
import ipsen5.dto.PostDTO;
import ipsen5.models.Post;
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
    private final PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(){
        return ResponseEntity.ok(this.postService.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Post>> getPostById(@PathVariable UUID id){
        return ResponseEntity.ok(this.postService.getPostById(id));
    }

    @GetMapping("/user/{user}")
    public ResponseEntity<List<Post>> getPostsByUserId(@PathVariable String user){
        return ResponseEntity.ok(this.postService.getPostsByUserId(user));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('POST_POST') || hasAuthority('POST') || hasAuthority('ALL') || hasAuthority('POSTEN')")
    public ResponseEntity<String> createPost(@RequestBody PostDTO postDTO){
        this.postService.createPost(postDTO);
        return ResponseEntity.ok("Created a new Post");
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('POST_PUT') || hasAuthority('POST') || hasAuthority('ALL') || hasAuthority('UPDATEN')")
    public ResponseEntity<String> editPost(@PathVariable UUID id, @RequestBody PostDTO postDTO){
        this.postService.editPost(id, postDTO);
        return ResponseEntity.ok("Edited post with id: " + id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('POST_DELETE') || hasAuthority('POST') || hasAuthority('ALL') || hasAuthority('DELETEN')")
    public ResponseEntity<?> deletePost(@PathVariable("id") UUID id){
        this.postService.deletePost(id);
        return ResponseEntity.ok("deleted post with id: " + id);
    }

    @GetMapping("/search/{title}")
    @PreAuthorize("hasAuthority('POST_GET') || hasAuthority('POST') || hasAuthority('ALL') || hasAuthority('GETTEN')")
    public ResponseEntity<List<Post>> searchPostsByTitle(@PathVariable String title) {
        List<Post> posts = postService.searchPostsByTitle(title);
        return ResponseEntity.ok(posts);
    }
}
