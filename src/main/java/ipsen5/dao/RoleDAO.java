package ipsen5.dao;

import ipsen5.dto.RoleDTO;
import ipsen5.models.Role;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleDAO {
    private final RoleRepository roleRepository;

    public RoleDAO(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return this.roleRepository.findAll();
    }

    public void createRole(RoleDTO roleDTO) {
        this.roleRepository.save(new Role(roleDTO.name));
    }
}
