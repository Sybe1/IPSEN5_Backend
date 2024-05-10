package ipsen5.controller;

import ipsen5.config.JWTUtil;
import ipsen5.dao.UserRepository;
import ipsen5.dto.AuthenticationDTO;
import ipsen5.dto.LoginResponse;
import ipsen5.models.User;
import ipsen5.services.InputValidator;
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

    private final UserRepository userDAO;
    private final JWTUtil jwtUtil;
    private final AuthenticationManager authManager;
    private final PasswordEncoder passwordEncoder;
    private InputValidator validator;

    public AuthController(UserRepository userDAO, JWTUtil jwtUtil, AuthenticationManager authManager,
                          PasswordEncoder passwordEncoder, InputValidator validator) {
        this.userDAO = userDAO;
        this.jwtUtil = jwtUtil;
        this.authManager = authManager;
        this.passwordEncoder = passwordEncoder;
        this.validator = validator;
    }

    @PostMapping("/register")
    public ResponseEntity<LoginResponse> register(@RequestBody AuthenticationDTO authenticationDTO) {
        if (!validator.isValidEmail(authenticationDTO.email)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid email provided"
            );
        }
        if (!validator.isValidPassword(authenticationDTO.password)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid password provided"
            );
        }
        if (!validator.isValidName(authenticationDTO.first_name)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid first name provided"
            );
        }
        if (!validator.isValidName(authenticationDTO.last_name)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid last name provided"
            );
        }
        if (!validator.isValidLink(authenticationDTO.donation_link)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid donation link provided"
            );
        }
        if (!validator.isNotNull(authenticationDTO.role)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No role provided"
            );
        }

        User user = userDAO.findByEmail(authenticationDTO.email);

        if (user != null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Can not register with this email"
            );
        }
        String encodedPassword = passwordEncoder.encode(authenticationDTO.password);

        User registerdCustomUser = new User(authenticationDTO.first_name, authenticationDTO.last_name, authenticationDTO.email, encodedPassword, authenticationDTO.donation_link, authenticationDTO.role);
        userDAO.save(registerdCustomUser);
        String token = jwtUtil.generateToken(registerdCustomUser.getEmail());
        LoginResponse loginResponse = new LoginResponse(registerdCustomUser.getEmail(), token);
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody AuthenticationDTO body) {
        try {
            UsernamePasswordAuthenticationToken authInputToken =
                    new UsernamePasswordAuthenticationToken(body.email, body.password);

            authManager.authenticate(authInputToken);

            String token = jwtUtil.generateToken(body.email);

            User user = userDAO.findByEmail(body.email);
            LoginResponse loginResponse = new LoginResponse(user.getEmail(), token);


            return ResponseEntity.ok(loginResponse);

        } catch (AuthenticationException authExc) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "No valid credentials"
            );
        }
    }

}
