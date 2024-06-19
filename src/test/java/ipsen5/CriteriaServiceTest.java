package ipsen5;

import ipsen5.dto.CriteriaDTO;
import ipsen5.models.Criteria;
import ipsen5.repository.CriteriaRepository;
import ipsen5.services.CriteriaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CriteriaServiceTest {
    @Mock
    private CriteriaRepository criteriaRepository;

    @InjectMocks
    private CriteriaService criteriaService;

    @BeforeEach
    public void setup(){
        criteriaRepository = Mockito.mock(CriteriaRepository.class);
        criteriaService = new CriteriaService(criteriaRepository);
    }

    @Test
    public void testGetCriteriaById() {
        Criteria criteria = new Criteria();
        UUID randomUUID2 = UUID.randomUUID();
        criteria.setId(randomUUID2);

        when(criteriaRepository.findById(randomUUID2)).thenReturn(Optional.of(criteria));

        Optional<Criteria> foundCriteria = criteriaService.getCriteriaById(randomUUID2);

        assertTrue(foundCriteria.isPresent());
        assertEquals(randomUUID2, foundCriteria.get().getId());
    }

    @Test
    public void testGetCriteriaByIdNotFound() {
        UUID randomUUID2 = UUID.randomUUID();
        when(criteriaRepository.findById(randomUUID2)).thenReturn(Optional.empty());

        Optional<Criteria> foundCriteria = criteriaService.getCriteriaById(randomUUID2);

        assertFalse(foundCriteria.isPresent());
    }

    @Test
    public void testCreateCriteriaWithInvalidData() {
        CriteriaDTO invalidCriteriaDTO = new CriteriaDTO("", "SubName", "Very bad", "Bad", "Decent", "Really good", "Very good", "Excellent");

        assertThrows(RuntimeException.class, () -> {
            criteriaService.createCriteria(invalidCriteriaDTO);
        });
    }

    @Test
    public void testEditCriteria() {
        UUID criteriaId = UUID.randomUUID();
        Criteria existingCriteria = new Criteria("OldMain", "OldSub", "OldZero", "OldOne", "OldTwo", "OldThree", "OldFour", "OldFive");
        existingCriteria.setId(criteriaId);

        when(criteriaRepository.findById(criteriaId)).thenReturn(Optional.of(existingCriteria));

        CriteriaDTO criteriaDTO = new CriteriaDTO("NewMain", "NewSub", "NewZero", "NewOne", "NewTwo", "NewThree", "NewFour", "NewFive");

        criteriaService.editCriteria(criteriaId, criteriaDTO);

        assertEquals("NewMain", existingCriteria.getMainName());
        assertEquals("NewSub", existingCriteria.getSubName());
        assertEquals("NewZero", existingCriteria.getZeroPoints());
        assertEquals("NewTwo", existingCriteria.getTwoPoints());
        assertEquals("NewFour", existingCriteria.getFourPoints());
        assertEquals("NewThree", existingCriteria.getThreePoints());
        assertEquals("NewOne", existingCriteria.getOnePoints());
        assertEquals("NewFive", existingCriteria.getFivePoints());

        verify(criteriaRepository, times(1)).save(existingCriteria);
    }


    @Test
    public void testDeleteCriteria() {
        UUID criteriaId = UUID.randomUUID();
        Criteria existingCriteria = new Criteria();
        existingCriteria.setId(criteriaId);

        when(criteriaRepository.findById(criteriaId)).thenReturn(Optional.of(existingCriteria));

        criteriaService.deleteCriteria(criteriaId);

        verify(criteriaRepository, times(1)).deleteById(criteriaId);
    }



}
