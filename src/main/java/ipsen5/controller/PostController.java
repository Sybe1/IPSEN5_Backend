package ipsen5.controller;

import ipsen5.dao.PostDAO;
import ipsen5.dto.PostDTO;
import ipsen5.models.Post;
import ipsen5.services.UserInputValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/post")
public class PostController {
    private final PostDAO postDAO;
    private UserInputValidator validator;
    public PostController(PostDAO postDAO, UserInputValidator validator) {
        this.postDAO = postDAO;
        this.validator = validator;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(){
        return ResponseEntity.ok(this.postDAO.getAllPosts());
    }

    @PostMapping
    public ResponseEntity<String> createPost(@RequestBody PostDTO postDTO){
        if (!validator.isValidDescription(postDTO.text)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid text provided"
            );
        }
        if (!validator.isNotNull(postDTO.user)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid user provided"
            );
        }
        this.postDAO.createPost(postDTO);
        return ResponseEntity.ok("Created a new Post");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editPost(@PathVariable UUID id, @RequestBody PostDTO postDTO){
        if (!validator.isValidDescription(postDTO.text)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid text provided"
            );
        }
        if (!validator.isNotNull(postDTO.user)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid user provided"
            );
        }
        this.postDAO.editPost(id, postDTO);
        return ResponseEntity.ok("Edited post with id: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable("id") UUID id){
        this.postDAO.deletePost(id);
        return ResponseEntity.ok("deleted post with id: " + id);
    }
}