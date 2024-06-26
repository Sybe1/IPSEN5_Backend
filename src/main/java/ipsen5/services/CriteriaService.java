package ipsen5.services;

import ipsen5.dto.CriteriaDTO;
import ipsen5.models.Criteria;
import ipsen5.repository.CriteriaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class CriteriaService {
    private final CriteriaRepository criteriaRepository;

    public CriteriaService(CriteriaRepository criteriaRepository) {
        this.criteriaRepository = criteriaRepository;
    }

    public List<Criteria> getAllCriteria() {
        return this.criteriaRepository.findAll();
    }

    public Optional<Criteria> getCriteriaById(UUID criteriaId) {
        return this.criteriaRepository.findById(criteriaId);
    }

    public void createCriteria(CriteriaDTO criteriaDTO) {
        if (criteriaDTO.getMainName() == null || criteriaDTO.getMainName().isEmpty()) {
            throw new RuntimeException("Main name cannot be null or empty");
        }
        Criteria criteria = new Criteria(criteriaDTO.mainName, criteriaDTO.subName, criteriaDTO.zeroPoints, criteriaDTO.onePoints, criteriaDTO.twoPoints, criteriaDTO.threePoints, criteriaDTO.fourPoints, criteriaDTO.fivePoints);
        this.criteriaRepository.save(criteria);
    }


    public void editCriteria(UUID id, CriteriaDTO criteriaDTO) {
        Criteria criteria = this.criteriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Criteria not found"));
        criteria.setMainName(criteriaDTO.mainName);
        criteria.setSubName(criteriaDTO.subName);
        criteria.setZeroPoints(criteriaDTO.zeroPoints);
        criteria.setTwoPoints(criteriaDTO.twoPoints);
        criteria.setFourPoints(criteriaDTO.fourPoints);
        criteria.setThreePoints(criteriaDTO.threePoints);
        criteria.setOnePoints(criteriaDTO.onePoints);
        criteria.setFivePoints(criteriaDTO.fivePoints);
        this.criteriaRepository.save(criteria);
    }

    public void deleteCriteria(UUID id) {
        this.criteriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Criteria not found"));
        this.criteriaRepository.deleteById(id);
    }


}
