package ipsen5.services;

import ipsen5.dto.PostDTO;
import ipsen5.models.Post;
import ipsen5.models.Reaction;
import ipsen5.models.User;
import ipsen5.models.enums.PrefferedDestination;
import ipsen5.repository.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final RatingRepository ratingRepository;
    private final ReactionRepository reactionRepository;
    private final PostCategoryRepository postCategoryRepository;

    public PostService(PostRepository postRepository,
                       UserRepository userRepository, RatingRepository ratingRepository, ReactionRepository reactionRepository, CategoryRepository categoryRepository, PostCategoryRepository postCategoryRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.ratingRepository = ratingRepository;
        this.reactionRepository = reactionRepository;
        this.postCategoryRepository = postCategoryRepository;
    }

    public List<Post> getAllPosts() {
        return this.postRepository.findAll();
    }

    public void createPost(PostDTO postDTO) {
        this.postRepository.save(new Post(postDTO.title, postDTO.text, postDTO.imageUrl, postDTO.prefferedDestination, LocalDate.now(), postDTO.genres, postDTO.user));
    }

    public void editPost(UUID id, PostDTO postDTO) {
        Post post = this.postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        post.setText(postDTO.text);
        post.setUser(postDTO.user);
        post.setImageUrl(postDTO.imageUrl);
        post.setPrefferedDestination(postDTO.prefferedDestination);
        post.setLocalDate(postDTO.localDate);
        post.setTitle(postDTO.title);
        this.postRepository.save(post);
    }

    @Transactional
    public void deletePost(UUID id) {
        Post post = this.postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        this.ratingRepository.deleteByPostId(id);
        List<Reaction> reactionsToDelete = this.reactionRepository.findByPostId(post);
        this.reactionRepository.deleteAll(reactionsToDelete);
        this.postCategoryRepository.deleteById_PostId(post);
        this.postRepository.deleteById(id);
    }

    public Optional<Post> getPostById(UUID id) {
        return this.postRepository.findById(id);
    }

    public List<Post> searchPostsByTitle(String title) {
        return this.postRepository.findByTitleContaining(title);
    }

    public List<Post> getPostsByUserId(String username) {
        User user = this.userRepository.findByUsername(username);
        return this.postRepository.findByUser(user);
    }

    public List<Post> getPostsByPrefferedDestination(PrefferedDestination prefferedDestination) {
        return this.postRepository.findByPrefferedDestination(prefferedDestination);
    }
}
