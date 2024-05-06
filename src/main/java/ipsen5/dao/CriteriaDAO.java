package ipsen5.dao;

import ipsen5.dto.CriteriaDTO;
import ipsen5.models.Criteria;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CriteriaDAO {
    private final CriteriaRepository criteriaRepository;

    public CriteriaDAO(CriteriaRepository criteriaRepository) {
        this.criteriaRepository = criteriaRepository;
    }

    public List<Criteria> getAllCriteria() {
        return this.criteriaRepository.findAll();
    }

    public void createCriteria(CriteriaDTO criteriaDTO) {
        this.criteriaRepository.save(new Criteria(criteriaDTO.name, criteriaDTO.zeroPoints, criteriaDTO.twoPoints, criteriaDTO.fourPoints, criteriaDTO.sixPoints, criteriaDTO.eightPoints, criteriaDTO.tenPoints));
    }

    public void editCriteria(Long id, CriteriaDTO criteriaDTO) {
        Criteria criteria = this.criteriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Criteria not found"));
        criteria.setName(criteriaDTO.name);
        criteria.setZeroPoints(criteriaDTO.zeroPoints);
        criteria.setTwoPoints(criteriaDTO.twoPoints);
        criteria.setFourPoints(criteriaDTO.fourPoints);
        criteria.setSixPoints(criteriaDTO.sixPoints);
        criteria.setEightPoints(criteriaDTO.eightPoints);
        criteria.setTenPoints(criteriaDTO.tenPoints);
        this.criteriaRepository.save(criteria);
    }

    public void deleteCriteria(Long id) {
        this.criteriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Criteria not found"));
        this.criteriaRepository.deleteById(id);
    }


}
