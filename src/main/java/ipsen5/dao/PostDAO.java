package ipsen5.dao;

import ipsen5.dto.CategoryDTO;
import ipsen5.dto.PostDTO;
import ipsen5.models.Category;
import ipsen5.models.Post;
import org.springframework.stereotype.Component;

import java.util.List;

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
        this.postRepository.save(new Post(postDTO.text, postDTO.user));
    }
}
