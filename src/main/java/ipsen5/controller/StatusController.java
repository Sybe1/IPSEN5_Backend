package ipsen5.controller;

import ipsen5.services.StatusService;
import ipsen5.dto.StatusDTO;
import ipsen5.models.Status;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://clownfish-app-5x89u.ondigitalocean.app"})
@RequestMapping("/status")
public class StatusController {
    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }
    @GetMapping
    @PreAuthorize("hasAuthority('STATUS_GET') || hasAuthority('STATUS') || hasAuthority('ALL') || hasAuthority('GETTEN')")
    public ResponseEntity<List<Status>> getAllRatings(){
        return ResponseEntity.ok(this.statusService.getAllStatus());
    }
    @PostMapping
    @PreAuthorize("hasAuthority('STATUS_POST') || hasAuthority('STATUS') || hasAuthority('ALL') || hasAuthority('POSTEN')")
    public ResponseEntity<String> createStatus(@RequestBody StatusDTO statusDTO){
        this.statusService.createStatus(statusDTO);
        return ResponseEntity.ok("Created a new Status");
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('STATUS_PUT') || hasAuthority('STATUS') || hasAuthority('ALL') || hasAuthority('UPDATEN')")
    public ResponseEntity<String> editStatus(@PathVariable UUID id, @RequestBody StatusDTO statusDTO){
        this.statusService.editStatus(id, statusDTO);
        return ResponseEntity.ok("Edited status with id: " + id);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('STATUS_DELETE') || hasAuthority('STATUS') || hasAuthority('ALL') || hasAuthority('DELETEN')")
    public ResponseEntity<?> deleteStatus(@PathVariable("id") UUID id){
        this.statusService.deleteStatus(id);
        return ResponseEntity.ok("deleted status with id: " + id);
    }
}
