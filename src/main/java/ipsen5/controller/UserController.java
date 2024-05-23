package ipsen5.controller;

import ipsen5.dao.UserDAO;
import ipsen5.dto.StatusDTO;
import ipsen5.dto.UserDTO;
import ipsen5.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
public class UserController {
    private final UserDAO userDAO;
//    private StatusValidator validator;

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
//        this.validator = validator;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(this.userDAO.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable UUID id){
        return ResponseEntity.ok(this.userDAO.getUserById(id));
    }

    @GetMapping("/mail/{mail}")
    public ResponseEntity<Optional<User>> getUserBymail(@PathVariable String mail){
        return ResponseEntity.ok(this.userDAO.getUserBymail(mail));
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> editUser(@PathVariable UUID id, @RequestBody UserDTO userDTO){
//        validator.statusValidations(statusDTO);
        this.userDAO.editUser(id, userDTO);
        return ResponseEntity.ok("Edited user with id: " + id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStatus(@PathVariable UUID id){
        this.userDAO.deleteUser(id);
        return ResponseEntity.ok("deleted user with id: " + id);
    }
}
