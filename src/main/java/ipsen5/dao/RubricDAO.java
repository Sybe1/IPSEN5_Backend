package ipsen5.dao;

import ipsen5.dto.RubricDTO;
import ipsen5.models.Criteria;
import ipsen5.models.Rubric;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Component
public class RubricDAO {
    private final RubricRepository rubricRepository;

    public RubricDAO(RubricRepository rubricRepository) {
        this.rubricRepository = rubricRepository;
    }

    public List<Rubric> getAllRubrics() {
        return this.rubricRepository.findAll();
    }

    public Set<Criteria> getCriteriaByRubricId(UUID rubricId) {
        Rubric rubric = rubricRepository.findById(rubricId).orElse(null);
        if (rubric != null) {
            return rubric.getCriteria();
        }
        return null;
    }

    public void createRubric(RubricDTO rubricDTO) {
        this.rubricRepository.save(new Rubric(rubricDTO.title));
    }

    public Rubric findById(UUID rubricId) {
        return rubricRepository.findById(rubricId).orElse(null);
    }

    public void editRubric(UUID id, RubricDTO rubricDTO) {
        Rubric rubric = this.rubricRepository.findById(id).orElseThrow(() -> new RuntimeException("Rubric not found"));
        rubric.setTitle(rubricDTO.title);
        this.rubricRepository.save(rubric);
    }

    public void deleteRubric(UUID id) {
        this.rubricRepository.findById(id).orElseThrow(() -> new RuntimeException("Rubric not found"));
        this.rubricRepository.deleteById(id);
    }
}
