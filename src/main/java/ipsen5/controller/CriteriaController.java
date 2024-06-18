package ipsen5.controller;

import ipsen5.services.CriteriaService;
import ipsen5.dto.CriteriaDTO;
import ipsen5.models.Criteria;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/criteria")
public class CriteriaController {
    private final CriteriaService criteriaService;

    public CriteriaController(CriteriaService criteriaService) {
        this.criteriaService = criteriaService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('CRITERIA_GET') || hasAuthority('CRITERIA') || hasAuthority('ALL') || hasAuthority('GETTEN')")
    public ResponseEntity<List<Criteria>> getAllCriteria(){
        return ResponseEntity.ok(this.criteriaService.getAllCriteria());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('CRITERIA_GET') || hasAuthority('CRITERIA') || hasAuthority('ALL') || hasAuthority('GETTEN')")
    public ResponseEntity<Optional<Criteria>> getCriteriaById(@PathVariable UUID id){
        return ResponseEntity.ok(this.criteriaService.getCriteriaById(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('CRITERIA_POST') || hasAuthority('CRITERIA') || hasAuthority('ALL') || hasAuthority('POSTEN')")
    public ResponseEntity<String> createCriteria(@RequestBody CriteriaDTO criteriaDTO){
        this.criteriaService.createCriteria(criteriaDTO);
        return ResponseEntity.ok("Created a new Criteria named");
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('CRITERIA_PUT') || hasAuthority('CRITERIA') || hasAuthority('ALL') || hasAuthority('UPDATEN')")
    public ResponseEntity<String> editCriteria(@PathVariable UUID id, @RequestBody CriteriaDTO criteriaDTO){
        this.criteriaService.editCriteria(id, criteriaDTO);
        return ResponseEntity.ok("Edited criteria with id: " + id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('CRITERIA_DELETE') || hasAuthority('CRITERIA') || hasAuthority('ALL') || hasAuthority('DELETEN')")
    public ResponseEntity<?> deleteCriteria(@PathVariable("id") UUID id){
        this.criteriaService.deleteCriteria(id);
        return ResponseEntity.ok("deleted criteria with id: " + id);
    }
}
