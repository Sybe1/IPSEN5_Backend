package ipsen5.dao;

import ipsen5.dto.StatusDTO;
import ipsen5.dto.UserDTO;
import ipsen5.models.Status;
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

    public Optional<User> getUserBymail(String mail) {
        return Optional.ofNullable(this.userRepository.findByEmail(mail));
    }

//    public void editRole(Long id, RoleDTO roleDTO) {
//        Role role = this.roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
//        role.setName(roleDTO.name);
//        this.roleRepository.save(role);
//    }

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
        this.userRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        this.userRepository.deleteById(id);
    }
}
