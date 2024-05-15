package ipsen5.dao;

import ipsen5.dto.RolePriviligesDTO;
import ipsen5.models.*;
import ipsen5.models.enums.Rights;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RolePriviligesDAO {

    private final RolePriviligesRepository rolePriviligesRepository;

    public RolePriviligesDAO(RolePriviligesRepository rolePriviligesRepository) {
        this.rolePriviligesRepository = rolePriviligesRepository;
    }

    public List<RolePriviliges> getPostCategories() {
        return this.rolePriviligesRepository.findAll();
    }

    public void createRolePriviliges(RolePriviligesDTO rolePriviligesDTO) {
        RolePriviligesId rolePriviligesId = new RolePriviligesId(rolePriviligesDTO.role, rolePriviligesDTO.rights);
        this.rolePriviligesRepository.save(new RolePriviliges(rolePriviligesId));
    }

    public void deleteRolePriviliges(Role roleId, Rights rightsId) {
        RolePriviligesId rolePriviligesId = new RolePriviligesId(roleId, rightsId);
        this.rolePriviligesRepository.findById(rolePriviligesId).orElseThrow(() -> new RuntimeException("RolePriviliges not found"));
        this.rolePriviligesRepository.deleteById(rolePriviligesId);
    }
}
