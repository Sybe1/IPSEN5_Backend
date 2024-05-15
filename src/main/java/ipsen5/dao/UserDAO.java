package ipsen5.dao;

import ipsen5.models.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class UserDAO {
    private final UserRepository userRepository;

    public UserDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public Optional<User> getUserById(UUID id) {
        return this.userRepository.findById(id);
    }

//    public void editRole(Long id, RoleDTO roleDTO) {
//        Role role = this.roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
//        role.setName(roleDTO.name);
//        this.roleRepository.save(role);
//    }

    public void deleteUser(UUID id) {
        this.userRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        this.userRepository.deleteById(id);
    }
}
