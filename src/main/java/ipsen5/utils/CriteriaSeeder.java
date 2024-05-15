package ipsen5.utils;

import ipsen5.dao.CriteriaRepository;
import ipsen5.models.Criteria;
import org.springframework.stereotype.Component;

@Component
public class CriteriaSeeder {

    private CriteriaRepository criteriaRepository;

    public CriteriaSeeder(CriteriaRepository criteriaRepository) {
        this.criteriaRepository = criteriaRepository;
    }

    public void seedCriteria() {
        Criteria criteria = new Criteria();
        criteria.setName("Storyline");
        criteria.setZeroPoints("No storyline ");
        criteria.setTwoPoints("Really bad storyline");
        criteria.setFourPoints("Bad storyline");
        criteria.setSixPoints("Ok storyline");
        criteria.setEightPoints("Good storyline");
        criteria.setTenPoints("Perfect storyline");
        criteriaRepository.save(criteria);

        Criteria criteria2 = new Criteria();
        criteria2.setName("Character development");
        criteria2.setZeroPoints("No character development");
        criteria2.setTwoPoints("Really bad character development");
        criteria2.setFourPoints("Bad character development");
        criteria2.setSixPoints("Ok character development");
        criteria2.setEightPoints("Good character development");
        criteria2.setTenPoints("Perfect character development");
        criteriaRepository.save(criteria2);

        Criteria criteria3 = new Criteria();
        criteria3.setName("Details");
        criteria3.setZeroPoints("No details");
        criteria3.setTwoPoints("Really bad details");
        criteria3.setFourPoints("Bad details");
        criteria3.setSixPoints("Ok details");
        criteria3.setEightPoints("Good details");
        criteria3.setTenPoints("Perfect details");
        criteriaRepository.save(criteria3);
    }
}