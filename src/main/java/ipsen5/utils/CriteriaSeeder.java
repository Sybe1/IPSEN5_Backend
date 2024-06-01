package ipsen5.utils;

import ipsen5.dao.CriteriaRepository;
import ipsen5.dao.RubricRepository;
import ipsen5.models.Criteria;
import ipsen5.models.Rubric;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
public class CriteriaSeeder {

    private CriteriaRepository criteriaRepository;
    private RubricRepository rubricRepository;

    public CriteriaSeeder(CriteriaRepository criteriaRepository,
                          RubricRepository rubricRepository) {
        this.criteriaRepository = criteriaRepository;
        this.rubricRepository = rubricRepository;
    }

    @Transactional
    public void seedCriteria() {
        UUID rubricId = rubricRepository.findAll().get(0).getId();
        Rubric rubric = rubricRepository.findById(rubricId).orElse(null);

        System.out.println("de naam is..:" + rubric);
        if (rubric != null) {
            Criteria criteria1 = new Criteria();
            criteria1.setName("Storyline");
            criteria1.setZeroPoints("No storyline");
            criteria1.setTwoPoints("Really bad storyline");
            criteria1.setFourPoints("Bad storyline");
            criteria1.setSixPoints("Ok storyline");
            criteria1.setEightPoints("Good storyline");
            criteria1.setTenPoints("Perfect storyline");
            criteria1.getRubrics().add(rubric);
            criteriaRepository.save(criteria1);

            rubric.getCriteria().add(criteria1);
            rubricRepository.save(rubric);

            Criteria criteria2 = new Criteria();
            criteria2.setName("Character development");
            criteria2.setZeroPoints("No character development");
            criteria2.setTwoPoints("Really bad character development");
            criteria2.setFourPoints("Bad character development");
            criteria2.setSixPoints("Ok character development");
            criteria2.setEightPoints("Good character development");
            criteria2.setTenPoints("Perfect character development");
            criteria2.getRubrics().add(rubric);
            criteriaRepository.save(criteria2);

            rubric.getCriteria().add(criteria2);
            rubricRepository.save(rubric);

            Criteria criteria3 = new Criteria();
            criteria3.setName("Details");
            criteria3.setZeroPoints("No details");
            criteria3.setTwoPoints("Really bad details");
            criteria3.setFourPoints("Bad details");
            criteria3.setSixPoints("Ok details");
            criteria3.setEightPoints("Good details");
            criteria3.setTenPoints("Perfect details");
            criteria3.getRubrics().add(rubric);
            criteriaRepository.save(criteria3);

            rubric.getCriteria().add(criteria3);
            rubricRepository.save(rubric);


        }
    }
}