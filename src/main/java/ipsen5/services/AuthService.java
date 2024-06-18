package ipsen5.services;

import ipsen5.config.JWTUtil;
import ipsen5.dto.AuthenticationDTO;
import ipsen5.dto.LoginResponse;
import ipsen5.models.Role;
import ipsen5.models.User;
import ipsen5.repository.RoleRepository;
import ipsen5.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Component
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final JWTUtil jwtUtil;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authManager;


    public AuthService(PasswordEncoder passwordEncoder,
                       JWTUtil jwtUtil,
                       UserRepository userRepository,
                       RoleRepository roleRepository,
                       AuthenticationManager authManager) {
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.authManager = authManager;
    }

    public LoginResponse loginUser(AuthenticationDTO authenticationDTO){
        try {
            UsernamePasswordAuthenticationToken authInputToken =
                    new UsernamePasswordAuthenticationToken(authenticationDTO.email, authenticationDTO.password);

            authManager.authenticate(authInputToken);

            String token = jwtUtil.generateToken(authenticationDTO.email);

            User user = userRepository.findByEmail(authenticationDTO.email);
            return new LoginResponse(user.getEmail(), token);

        } catch (AuthenticationException authExc) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "No valid credentials"
            );
        }
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

        if (authenticationDTO.imageUrl == null){
            authenticationDTO.imageUrl = "https://t4.ftcdn.net/jpg/00/64/67/27/360_F_64672736_U5kpdGs9keUll8CRQ3p3YaEv2M6qkVY5.jpg";
        }

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
