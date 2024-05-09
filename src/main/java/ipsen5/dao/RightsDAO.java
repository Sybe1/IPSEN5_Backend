package ipsen5.dao;

import ipsen5.dto.RightsDTO;
import ipsen5.dto.RoleDTO;
import ipsen5.models.Rights;
import ipsen5.models.Role;
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

    public void editRights(Long id, RightsDTO rightsDTO) {
        Rights rights = this.rightsRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        rights.setName(rightsDTO.name);
        this.rightsRepository.save(rights);
    }

    public void deleteRights(Long id) {
        this.rightsRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        this.rightsRepository.deleteById(id);
    }
}
