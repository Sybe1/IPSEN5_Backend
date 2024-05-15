package ipsen5.utils;

import ipsen5.dao.CriteriaRepository;
import ipsen5.dao.RubricElementsRepository;
import ipsen5.dao.RubricRepository;
import ipsen5.models.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RubricElementsSeeder {
    private RubricRepository rubricRepository;
    private CriteriaRepository criteriaRepository;
    private RubricElementsRepository rubricElementsRepository;

    public RubricElementsSeeder(RubricRepository rubricRepository, CriteriaRepository criteriaRepository, RubricElementsRepository rubricElementsRepository) {
        this.rubricRepository = rubricRepository;
        this.criteriaRepository = criteriaRepository;
        this.rubricElementsRepository = rubricElementsRepository;
    }

    public void seedRubricElements() {
        List<Rubric> allRubrics = rubricRepository.findAll();
        List<Criteria> allCriteria = criteriaRepository.findAll();

        RubricElements rubricElements = new RubricElements();
        RubricElementsId rubricElementsId = new RubricElementsId(allCriteria.get(0), allRubrics.get(0));
        rubricElements.setId(rubricElementsId);
        rubricElementsRepository.save(rubricElements);

        RubricElements rubricElements2 = new RubricElements();
        RubricElementsId rubricElementsId2 = new RubricElementsId(allCriteria.get(1), allRubrics.get(0));
        rubricElements2.setId(rubricElementsId2);
        rubricElementsRepository.save(rubricElements2);

        RubricElements rubricElements3 = new RubricElements();
        RubricElementsId rubricElementsId3 = new RubricElementsId(allCriteria.get(1), allRubrics.get(1));
        rubricElements3.setId(rubricElementsId3);
        rubricElementsRepository.save(rubricElements3);
    }
}