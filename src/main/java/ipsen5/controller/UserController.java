package ipsen5.controller;

import ipsen5.dao.UserDAO;
import ipsen5.dto.StatusDTO;
import ipsen5.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/status")
public class UserController {
    private final UserDAO userDAO;
//    private StatusValidator validator;

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
//        this.validator = validator;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(this.userDAO.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getAllUsers(@PathVariable UUID id){
        return ResponseEntity.ok(this.userDAO.getUserById(id));
    }


//    @PutMapping("/{id}")
//    public ResponseEntity<String> editUser(@PathVariable UUID id, @RequestBody StatusDTO statusDTO){
//        validator.statusValidations(statusDTO);
//        this.statusDAO.editStatus(id, statusDTO);
//        return ResponseEntity.ok("Edited status with id: " + id);
//    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStatus(@PathVariable UUID id){
        this.userDAO.deleteUser(id);
        return ResponseEntity.ok("deleted user with id: " + id);
    }
}
