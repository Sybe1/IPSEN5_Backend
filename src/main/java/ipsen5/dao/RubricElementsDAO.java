package ipsen5.dao;

import ipsen5.dto.RubricElementsDTO;
import ipsen5.models.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RubricElementsDAO {

    private final RubricElementsRepository rubricElementsRepository;

    public RubricElementsDAO(RubricElementsRepository rubricElementsRepository) {
        this.rubricElementsRepository = rubricElementsRepository;
    }

    public List<RubricElements> getPostCategories() {
        return this.rubricElementsRepository.findAll();
    }

    public void createRubricElements(RubricElementsDTO rubricElementsDTO) {
        RubricElementsId rubricElementsId = new RubricElementsId(rubricElementsDTO.criteria, rubricElementsDTO.rubric);
        this.rubricElementsRepository.save(new RubricElements(rubricElementsId));
    }

    public void deleteRubricElements(Rubric rubricId, Criteria criteriaId) {
        RubricElementsId rubricElementsId = new RubricElementsId(criteriaId, rubricId);
        this.rubricElementsRepository.findById(rubricElementsId).orElseThrow(() -> new RuntimeException("RubricElements not found"));
        this.rubricElementsRepository.deleteById(rubricElementsId);
    }
}
