package ipsen5.dao;

import ipsen5.dto.RightsDTO;
import ipsen5.models.Rights;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RightsDAO {
    private final RightsRepository rightsRepository;

    public RightsDAO(RightsRepository rightsRepository) {
        this.rightsRepository = rightsRepository;
    }

    public List<Rights> getAllRights() {
        return this.rightsRepository.findAll();
    }

    public void createRights(RightsDTO rightsDTO) {
        this.rightsRepository.save(new Rights(rightsDTO.name));
    }

}
