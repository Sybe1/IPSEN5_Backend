package ipsen5.controller;

import ipsen5.dao.StatusDAO;
import ipsen5.dto.RatingDTO;
import ipsen5.dto.StatusDTO;
import ipsen5.models.Rating;
import ipsen5.models.Status;
import ipsen5.services.UserInputValidator;
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
    private UserInputValidator validator;

    public StatusController(StatusDAO statusDAO) {
        this.statusDAO = statusDAO;
        this.validator = validator;
    }
    @GetMapping
    public ResponseEntity<List<Status>> getAllRatings(){
        return ResponseEntity.ok(this.statusDAO.getAllStatus());
    }
    @PostMapping
    public ResponseEntity<String> createStatus(@RequestBody StatusDTO statusDTO){
        if (!validator.isNotNull(statusDTO.status)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid status provided"
            );
        }
        if (!validator.isNotNull(statusDTO.status)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No status post provided"
            );
        }
        this.statusDAO.createStatus(statusDTO);
        return ResponseEntity.ok("Created a new Rating");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> editStatus(@PathVariable UUID id, @RequestBody StatusDTO statusDTO){
        if (!validator.isNotNull(statusDTO.status)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No status grade provided"
            );
        }
        if (!validator.isNotNull(statusDTO.status)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No status post provided"
            );
        }
        this.statusDAO.editStatus(id, statusDTO);
        return ResponseEntity.ok("Edited status with id: " + id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStatus(@PathVariable("id") UUID id){
        this.statusDAO.deleteStatus(id);
        return ResponseEntity.ok("deleted status with id: " + id);
    }
}
