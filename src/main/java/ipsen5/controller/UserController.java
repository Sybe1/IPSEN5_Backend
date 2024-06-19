package ipsen5.controller;

import ipsen5.services.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import ipsen5.dto.UserDTO;
import ipsen5.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://clownfish-app-5x89u.ondigitalocean.app"})
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('USER_GET') || hasAuthority('USER') || hasAuthority('ALL') || hasAuthority('GETTEN')")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable UUID id){
        return ResponseEntity.ok(this.userService.getUserById(id));
    }

    @GetMapping("/mail/{mail}")
    public ResponseEntity<Optional<User>> getUserBymail(@PathVariable String mail){
        return ResponseEntity.ok(this.userService.getUserBymail(mail));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Optional<User>> getUserByUsername(@PathVariable String username){
        return ResponseEntity.ok(this.userService.getUserByUsername(username));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('USER_PUT') || hasAuthority('USER') || hasAuthority('ALL') || hasAuthority('UPDATEN')")
    public ResponseEntity<String> editUser(@PathVariable UUID id, @RequestBody UserDTO userDTO){
        this.userService.editUser(id, userDTO);
        return ResponseEntity.ok("Edited user with id: " + id);
    }

    @PutMapping("/role/{roleId}")
    @PreAuthorize("hasAuthority('USER_PUT') || hasAuthority('USER') || hasAuthority('ALL') || hasAuthority('UPDATEN')")
    public ResponseEntity<?> editUserRole(@PathVariable UUID roleId, @RequestBody User user){
        userService.editUserRole(user, roleId);
        String message = "Edited user with id: " + user;
        return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"" + message + "\"}");
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('USER_DELETE') || hasAuthority('USER') || hasAuthority('ALL') || hasAuthority('DELETEN')")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable UUID id){
        this.userService.deleteUser(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "deleted post with id: " + id);
        return ResponseEntity.ok(response);
    }
}
