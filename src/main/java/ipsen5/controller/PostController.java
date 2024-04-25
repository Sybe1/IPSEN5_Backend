package ipsen5.controller;

import ipsen5.dao.CategoryDAO;
import ipsen5.dao.PostDAO;
import ipsen5.dto.CategoryDTO;
import ipsen5.dto.PostDTO;
import ipsen5.models.Category;
import ipsen5.models.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/post")
public class PostController {
    private final PostDAO postDAO;

    public PostController(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(){
        return ResponseEntity.ok(this.postDAO.getAllPosts());
    }

    @PostMapping
    public ResponseEntity<String> createPost(@RequestBody PostDTO postDTO){
        this.postDAO.createPost(postDTO);
        return ResponseEntity.ok("Created a new Post");
    }
}
