package ipsen5.dao;

import ipsen5.dto.UserDTO;
import ipsen5.models.Role;
import ipsen5.models.User;
import ipsen5.repository.RoleRepository;
import ipsen5.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class UserDAO {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserDAO(UserRepository userRepository,
                   RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public Optional<User> getUserById(UUID id) {
        return this.userRepository.findById(id);
    }

    public Optional<User> getUserBymail(String mail) {
        return Optional.ofNullable(this.userRepository.findByEmail(mail));
    }

    public void editUser(UUID id, UserDTO userDTO) {
        User user = this.userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setFirst_name(userDTO.first_name);
        user.setLast_name(userDTO.last_name);
        user.setPassword(userDTO.password);
        user.setEmail(userDTO.email);
        user.setImageUrl(userDTO.imageUrl);
        user.setDonation_link(userDTO.donation_link);
        this.userRepository.save(user);
    }

    public void deleteUser(UUID id) {
        this.userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        this.userRepository.deleteById(id);
    }

    public Optional<User> getUserByUsername(String username) {
        return Optional.ofNullable(this.userRepository.findByUsername(username));
    }

    public void editUserRole(User user, UUID roleId) {
        Role role = this.roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role not found"));
        user.setRole(role);
        this.userRepository.save(user);
    }
}
