package ipsen5.dao;

import ipsen5.dto.PostDTO;
import ipsen5.dto.RoleDTO;
import ipsen5.models.Category;
import ipsen5.models.Post;
import ipsen5.models.PostCategoryId;
import ipsen5.models.Role;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class RoleDAO {
    private final RoleRepository roleRepository;

    public RoleDAO(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return this.roleRepository.findAll();
    }

    public Optional<Role> findRoleByName(String name) {
        return roleRepository.findByName(name);
    }

    public void createRole(RoleDTO roleDTO) {
        this.roleRepository.save(new Role(roleDTO.name));
    }

    public void editRole(UUID id, RoleDTO roleDTO) {
        Role role = this.roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        role.setName(roleDTO.name);
        System.out.println("miss hiero " + roleDTO.name);
        this.roleRepository.save(role);
    }

    public void deleteRole(UUID id) {
        this.roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        this.roleRepository.deleteById(id);
    }
}
