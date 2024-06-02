package ipsen5.dao;

import ipsen5.dto.PostDTO;
import ipsen5.models.Post;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class PostDAO {
    private final PostRepository postRepository;

    public PostDAO(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return this.postRepository.findAll();
    }

    public void createPost(PostDTO postDTO) {
        this.postRepository.save(new Post(postDTO.title, postDTO.text, postDTO.imageUrl, postDTO.localDate, postDTO.user));
    }

    public void editPost(UUID id, PostDTO postDTO) {
        Post post = this.postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        post.setText(postDTO.text);
        post.setUser(postDTO.user);
        post.setImageUrl(postDTO.imageUrl);
        post.setLocalDate(postDTO.localDate);
        post.setTitle(postDTO.title);
        this.postRepository.save(post);
    }

    public void deletePost(UUID id) {
        this.postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        this.postRepository.deleteById(id);
    }

    public Optional<Post> getPostById(UUID id) {
        return this.postRepository.findById(id);
    }

    public List<Post> searchPostsByTitle(String title) {
        return this.postRepository.findByTitleContaining(title);
    }
}
