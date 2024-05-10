package ipsen5.controller;

import ipsen5.dao.StatusDAO;
import ipsen5.dto.StatusDTO;
import ipsen5.models.Status;
import ipsen5.services.InputValidator;
import ipsen5.services.StatusValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/status")
public class StatusController {
    private final StatusDAO statusDAO;
    private StatusValidator validator;

    public StatusController(StatusDAO statusDAO, StatusValidator validator) {
        this.statusDAO = statusDAO;
        this.validator = validator;
    }
    @GetMapping
    public ResponseEntity<List<Status>> getAllRatings(){
        return ResponseEntity.ok(this.statusDAO.getAllStatus());
    }
    @PostMapping
    public ResponseEntity<String> createStatus(@RequestBody StatusDTO statusDTO){
        validator.statusValidations(statusDTO);
        this.statusDAO.createStatus(statusDTO);
        return ResponseEntity.ok("Created a new Rating");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> editStatus(@PathVariable UUID id, @RequestBody StatusDTO statusDTO){
        validator.statusValidations(statusDTO);
        this.statusDAO.editStatus(id, statusDTO);
        return ResponseEntity.ok("Edited status with id: " + id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStatus(@PathVariable("id") UUID id){
        this.statusDAO.deleteStatus(id);
        return ResponseEntity.ok("deleted status with id: " + id);
    }
}
