package ipsen5.utils;

import ipsen5.repository.CriteriaRepository;
import ipsen5.repository.RubricRepository;
import ipsen5.models.Criteria;
import ipsen5.models.Rubric;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
public class CriteriaSeeder {

    private final CriteriaRepository criteriaRepository;
    private final RubricRepository rubricRepository;

    public CriteriaSeeder(CriteriaRepository criteriaRepository,
                          RubricRepository rubricRepository) {
        this.criteriaRepository = criteriaRepository;
        this.rubricRepository = rubricRepository;
    }

    @Transactional
    public void seedCriteria() {
        UUID rubricId = rubricRepository.findAll().get(0).getId();
        Rubric rubric = rubricRepository.findById(rubricId).orElse(null);

        UUID rubricId2 = rubricRepository.findAll().get(1).getId();
        Rubric rubric2 = rubricRepository.findById(rubricId2).orElse(null);

        System.out.println("de naam is..:" + rubric);
        if (rubric != null) {
            Criteria criteria1 = new Criteria();
            criteria1.setMainName("Technique");
            criteria1.setSubName("Written");
            criteria1.setZeroPoints("Very bad");
            criteria1.setOnePoints("Bad");
            criteria1.setTwoPoints("Decent");
            criteria1.setThreePoints("Really good");
            criteria1.setFourPoints("Very good");
            criteria1.setFivePoints("Excillent");
            criteria1.getRubrics().add(rubric);
            criteria1.getRubrics().add(rubric2);
            criteriaRepository.save(criteria1);

            rubric.getCriteria().add(criteria1);
            rubricRepository.save(rubric);
            rubricRepository.save(rubric2);


            Criteria criteria3 = new Criteria();
            criteria3.setMainName("Immersion");
            criteria3.setSubName("Impact");
            criteria3.setZeroPoints("Very bad");
            criteria3.setOnePoints("Bad");
            criteria3.setTwoPoints("Decent");
            criteria3.setThreePoints("Really good");
            criteria3.setFourPoints("Very good");
            criteria3.setFivePoints("Excillent");

            criteria3.getRubrics().add(rubric);
            criteriaRepository.save(criteria3);
            rubric.getCriteria().add(criteria3);
            rubricRepository.save(rubric);

            Criteria criteria4 = new Criteria();
            criteria4.setMainName("Immersion");
            criteria4.setSubName("Immersion");
            criteria4.setZeroPoints("Very bad");
            criteria4.setOnePoints("Bad");
            criteria4.setTwoPoints("Decent");
            criteria4.setThreePoints("Really good");
            criteria4.setFourPoints("very good");
            criteria4.setFivePoints("Very good");
            criteria4.getRubrics().add(rubric);
            criteriaRepository.save(criteria4);
            rubric.getCriteria().add(criteria4);
            rubricRepository.save(rubric);

            Criteria criteria5 = new Criteria();
            criteria5.setMainName("Immersion");
            criteria5.setSubName("Engagement");
            criteria5.setZeroPoints("Very bad");
            criteria5.setOnePoints("Bad");
            criteria5.setTwoPoints("Decent");
            criteria5.setThreePoints("Ok details");
            criteria5.setFourPoints("Bad details");
            criteria5.setFivePoints("Good details");

            criteria5.getRubrics().add(rubric);
            criteriaRepository.save(criteria5);
            rubric.getCriteria().add(criteria5);
            rubricRepository.save(rubric);

            Criteria criteria2 = new Criteria();
            criteria2.setMainName("Plot & Theme");
            criteria2.setSubName("Message");
            criteria2.setZeroPoints("Very bad");
            criteria2.setOnePoints("Bad");
            criteria2.setTwoPoints("Decent");
            criteria2.setThreePoints("Really good");
            criteria2.setFourPoints("Very good");
            criteria2.setFivePoints("Excillent");
            criteria2.getRubrics().add(rubric);
            criteriaRepository.save(criteria2);

            rubric.getCriteria().add(criteria2);
            rubricRepository.save(rubric);

            Criteria criteria6 = new Criteria();
            criteria6.setMainName("Plot & Theme");
            criteria6.setSubName("Plot");
            criteria6.setZeroPoints("Very bad");
            criteria6.setOnePoints("Bad");
            criteria6.setTwoPoints("Decent");
            criteria6.setThreePoints("Really good");
            criteria6.setFourPoints("Very good");
            criteria6.setFivePoints("Excillent");
            criteria6.getRubrics().add(rubric);
            criteriaRepository.save(criteria6);

            rubric.getCriteria().add(criteria6);
            rubricRepository.save(rubric);

            Criteria criteria7 = new Criteria();
            criteria7.setMainName("Plot & Theme");
            criteria7.setSubName("Balance");
            criteria7.setZeroPoints("Very bad");
            criteria7.setOnePoints("Bad");
            criteria7.setTwoPoints("Decent");
            criteria7.setThreePoints("Really good");
            criteria7.setFourPoints("Very good");
            criteria7.setFivePoints("Excillent");
            criteria7.getRubrics().add(rubric);
            criteriaRepository.save(criteria7);

            rubric.getCriteria().add(criteria7);
            rubricRepository.save(rubric);

            Criteria criteria8 = new Criteria();
            criteria8.setMainName("Characters & Setting");
            criteria8.setSubName("Characters");
            criteria8.setZeroPoints("Very bad");
            criteria8.setOnePoints("Bad");
            criteria8.setTwoPoints("Decent");
            criteria8.setThreePoints("Really good");
            criteria8.setFourPoints("Very good");
            criteria8.setFivePoints("Excillent");
            criteria8.getRubrics().add(rubric);
            criteriaRepository.save(criteria8);

            rubric.getCriteria().add(criteria8);
            rubricRepository.save(rubric);

            Criteria criteria9 = new Criteria();
            criteria9.setMainName("Characters & Setting");
            criteria9.setSubName("Level of detail");
            criteria9.setZeroPoints("Very bad");
            criteria9.setOnePoints("Bad");
            criteria9.setTwoPoints("Decent");
            criteria9.setThreePoints("Really good");
            criteria9.setFourPoints("Very good");
            criteria9.setFivePoints("Excillent");
            criteria9.getRubrics().add(rubric);
            criteriaRepository.save(criteria9);

            rubric.getCriteria().add(criteria9);
            rubricRepository.save(rubric);

            Criteria criteria10 = new Criteria();
            criteria10.setMainName("Freshness of ideas");
            criteria10.setSubName("Level of detail");
            criteria10.setZeroPoints("Very bad");
            criteria10.setOnePoints("Bad");
            criteria10.setTwoPoints("Decent");
            criteria10.setThreePoints("Really good");
            criteria10.setFourPoints("Very good");
            criteria10.setFivePoints("Excillent");
            criteria10.getRubrics().add(rubric);
            criteriaRepository.save(criteria10);

            rubric.getCriteria().add(criteria10);
            rubricRepository.save(rubric);

            Criteria criteria11 = new Criteria();
            criteria11.setMainName("Freshness of ideas");
            criteria11.setSubName("Inventiveness");
            criteria11.setZeroPoints("Very bad");
            criteria11.setOnePoints("Bad");
            criteria11.setTwoPoints("Decent");
            criteria11.setThreePoints("Really good");
            criteria11.setFourPoints("Very good");
            criteria11.setFivePoints("Excillent");
            criteria11.getRubrics().add(rubric);
            criteriaRepository.save(criteria11);

            rubric.getCriteria().add(criteria11);
            rubricRepository.save(rubric);

            Criteria criteria12 = new Criteria();
            criteria12.setMainName("Freshness of ideas");
            criteria12.setSubName("Provocation of thought");
            criteria12.setZeroPoints("Very bad");
            criteria12.setOnePoints("Bad");
            criteria12.setTwoPoints("Decent");
            criteria12.setThreePoints("Really good");
            criteria12.setFourPoints("Very good");
            criteria12.setFivePoints("Excillent");
            criteria12.getRubrics().add(rubric);
            criteriaRepository.save(criteria12);

            rubric.getCriteria().add(criteria12);
            rubricRepository.save(rubric);
        }
    }
}