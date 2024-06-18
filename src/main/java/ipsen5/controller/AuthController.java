package ipsen5.controller;

import ipsen5.config.JWTUtil;
import ipsen5.dao.UserDAO;
import ipsen5.repository.RoleRepository;
import ipsen5.repository.UserRepository;
import ipsen5.dto.AuthenticationDTO;
import ipsen5.dto.LoginResponse;
import ipsen5.models.User;
import ipsen5.services.AuthService;
import ipsen5.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<LoginResponse> register(@RequestBody AuthenticationDTO authenticationDTO) {
        LoginResponse loginResponse = authService.registerUser(authenticationDTO);
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody AuthenticationDTO authenticationDTO) {
        LoginResponse loginResponse = authService.loginUser(authenticationDTO);
        return ResponseEntity.ok(loginResponse);
    }

}
