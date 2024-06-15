package ipsen5.dao;

import ipsen5.dto.RolePriviligesDTO;
import ipsen5.models.*;
import ipsen5.models.enums.Rights;
import ipsen5.dao.RolePriviligesRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class RolePriviligesDAO {

    private final RolePriviligesRepository rolePriviligesRepository;
    private final RoleRepository roleRepository;


    public RolePriviligesDAO(RolePriviligesRepository rolePriviligesRepository, RoleRepository roleRepository) {
        this.rolePriviligesRepository = rolePriviligesRepository;
        this.roleRepository = roleRepository;
    }

    public List<RolePriviliges> getAllRolePriviliges() {
        return this.rolePriviligesRepository.findAll();
    }

    public List<RolePriviliges> getRolePriviligesByRoleId(UUID roleId) {
        Optional<Role> optionalRole = roleRepository.findById(roleId);
        Role role = optionalRole.get();
        return this.rolePriviligesRepository.findByIdRoleId(role);
    }

    public Optional<RolePriviliges> getRolePriviligesByRoleIdAndRights(UUID roleId, Rights rights) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        return Optional.ofNullable(rolePriviligesRepository.findByIdRoleIdAndIdRightsId(role, rights));
    }

    public void saveRolePriviliges(RolePriviligesDTO rolePriviligesDTO) {
        Role role = roleRepository.findById(rolePriviligesDTO.role)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        RolePriviliges rolePriviliges = new RolePriviliges();
        rolePriviliges.setId(new RolePriviligesId(role, rolePriviligesDTO.rights));

        this.rolePriviligesRepository.save(rolePriviliges);
    }

    public void deleteRolePriviliges(UUID roleId, Rights rights) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        RolePriviligesId id = new RolePriviligesId(role, rights);

        RolePriviliges rolePriviliges = this.rolePriviligesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RolePriviliges not found"));
        this.rolePriviligesRepository.delete(rolePriviliges);
    }
}
