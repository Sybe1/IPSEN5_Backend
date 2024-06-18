package ipsen5.dao;

import ipsen5.config.JWTUtil;
import ipsen5.dto.AuthenticationDTO;
import ipsen5.dto.LoginResponse;
import ipsen5.dto.UserDTO;
import ipsen5.models.Role;
import ipsen5.models.User;
import ipsen5.repository.RoleRepository;
import ipsen5.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class UserDAO {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTUtil jwtUtil;


    public UserDAO(UserRepository userRepository,
                   RoleRepository roleRepository,
                   PasswordEncoder passwordEncoder,
                   JWTUtil jwtUtil) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
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

    public LoginResponse registerUser(AuthenticationDTO authenticationDTO) {
        User user = userRepository.findByEmail(authenticationDTO.email);
        if (user != null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Can not register with this email"
            );
        }

        User user1 = userRepository.findByUsername(authenticationDTO.username);
        if (user1 != null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Can not register with this username"
            );
        }

        System.out.println("dezee " + authenticationDTO.imageUrl);


        if (authenticationDTO.imageUrl == null){
            System.out.println("dezee " + authenticationDTO.imageUrl);
            authenticationDTO.imageUrl = "https://t4.ftcdn.net/jpg/00/64/67/27/360_F_64672736_U5kpdGs9keUll8CRQ3p3YaEv2M6qkVY5.jpg";
        }

        System.out.println("dezee " + authenticationDTO.imageUrl);

        String encodedPassword = passwordEncoder.encode(authenticationDTO.password);

        List<Role> allRoles = roleRepository.findAll();
        authenticationDTO.role = allRoles.get(2);

        User registerdCustomUser = new User(authenticationDTO.username, authenticationDTO.first_name, authenticationDTO.last_name,
                authenticationDTO.email, encodedPassword, authenticationDTO.imageUrl, authenticationDTO.donation_link,
                authenticationDTO.role);
        userRepository.save(registerdCustomUser);
        String token = jwtUtil.generateToken(registerdCustomUser.getEmail());
        return new LoginResponse(registerdCustomUser.getEmail(), token);
    }
}
