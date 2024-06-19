package ipsen5;

import ipsen5.dto.ReactionDTO;
import ipsen5.dto.RoleDTO;
import ipsen5.models.Reaction;
import ipsen5.models.Role;
import ipsen5.models.Rubric;
import ipsen5.repository.PostRepository;
import ipsen5.repository.ReactionRepository;
import ipsen5.repository.RoleRepository;
import ipsen5.repository.RubricRepository;
import ipsen5.services.ReactionService;
import ipsen5.services.RoleService;
import ipsen5.services.RubricService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ReactionServiceTest {
    @Mock
    private ReactionRepository reactionRepository;

    @Mock
    private PostRepository postRepository;
    @InjectMocks
    private ReactionService reactionService;
    private Reaction reaction;
    private Reaction reaction1;
    private Reaction reaction2;

    @BeforeEach
    public void setup(){
        reactionRepository = Mockito.mock(ReactionRepository.class);
        reactionService = new ReactionService(reactionRepository, postRepository);
        reaction = new Reaction();
        reaction.setText("Eerste");
        reaction.setId(UUID.randomUUID());
    }

    @Test
    public void testReactionDelete() {
        UUID reactionId = UUID.randomUUID();

        when(reactionRepository.findById(reactionId)).thenReturn(Optional.of(new Reaction()));

        reactionService.deleteReaction(reactionId);

        verify(reactionRepository, Mockito.times(1)).findById(reactionId);
        verify(reactionRepository, Mockito.times(1)).deleteById(reactionId);
    }
    @Test
    public void testDeleteRoleNotFound() {
        UUID nonExistingId = UUID.randomUUID();

        when(reactionRepository.findById(nonExistingId)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            reactionService.deleteReaction(nonExistingId);
        });

        verify(reactionRepository, Mockito.times(1)).findById(nonExistingId);
        verify(reactionRepository, Mockito.never()).deleteById(nonExistingId);
        String expectedMessage = "Reaction not found";
        String actualMessage = exception.getMessage();
        assert(actualMessage.contains(expectedMessage));
    }




}
