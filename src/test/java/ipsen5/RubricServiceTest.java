package ipsen5;

import ipsen5.models.Role;
import ipsen5.models.Rubric;
import ipsen5.repository.RubricRepository;
import ipsen5.services.RoleService;
import ipsen5.services.RubricService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RubricServiceTest {
    @Mock
    private RubricRepository rubricRepository;
    @InjectMocks
    private RubricService rubricService;

    private Rubric rubric;
    private Rubric rubric1;
    private Rubric rubric2;

    @BeforeEach
    public void setup(){
        rubricRepository = Mockito.mock(RubricRepository.class);
        rubricService = new RubricService(rubricRepository);
        rubric = new Rubric("Text");
        rubric.setId(UUID.randomUUID());
        rubric1 = new Rubric("Audio");
        rubric1.setId(UUID.randomUUID());
        rubric2 = new Rubric("Video");
        rubric2.setId(UUID.randomUUID());

    }

    @Test
    public void testFindAllRubrics(){
        List<Rubric> rubrics = Arrays.asList(new Rubric("text"), new Rubric("Audio"));
        when(rubricRepository.findAll()).thenReturn(rubrics);
        List<Rubric> foundRubrics = rubricService.getAllRubrics();
        assertNotNull(foundRubrics);
        assertEquals(2, foundRubrics.size());
        assertEquals("text", foundRubrics.get(0).getTitle());
        assertEquals("Audio", foundRubrics.get(1).getTitle());
    }
    @Test
    public void testGetRubricById() {
        Rubric rubric = new Rubric();
        String uuidFromString = "ad5d5761-b3eb-40f9-817d-126b72acb0d4";
        UUID rubricId = UUID.fromString(uuidFromString);
        rubric.setId(rubricId);

        when(rubricRepository.findById(rubricId)).thenReturn(Optional.of(rubric));

        Optional<Rubric> foundRubric = Optional.ofNullable(rubricService.findById(rubricId));
        assertTrue(foundRubric.isPresent());
        assertEquals(rubricId, foundRubric.get().getId());
    }


}
