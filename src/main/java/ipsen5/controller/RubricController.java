package ipsen5.controller;

import ipsen5.services.RubricService;
import ipsen5.dto.RubricDTO;
import ipsen5.models.Criteria;
import ipsen5.models.Rubric;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rubric")
public class RubricController {
    private final RubricService rubricService;

    public RubricController(RubricService rubricService) {
        this.rubricService = rubricService;
    }

    @GetMapping("/{id}/criteria")
    @PreAuthorize("hasAuthority('RUBRIC_GET') || hasAuthority('RUBRIC') || hasAuthority('ALL') || hasAuthority('GETTEN')")
    public Set<Criteria> getCriteriaByRubricId(@PathVariable UUID id) {
        return rubricService.getCriteriaByRubricId(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('RUBRIC_GET') || hasAuthority('RUBRIC') || hasAuthority('ALL') || hasAuthority('GETTEN')")
    public ResponseEntity<List<Rubric>> getAllRubrics(){
        return ResponseEntity.ok(this.rubricService.getAllRubrics());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('RUBRIC_POST') || hasAuthority('RUBRIC') || hasAuthority('ALL') || hasAuthority('POSTEN')")
    public ResponseEntity<String> createRubric(@RequestBody RubricDTO rubricDTO){
        this.rubricService.createRubric(rubricDTO);
        return ResponseEntity.ok("Created a new Rubric");
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('RUBRIC_PUT') || hasAuthority('RUBRIC') || hasAuthority('ALL') || hasAuthority('UPDATEN')")
    public ResponseEntity<String> editRubric(@PathVariable UUID id, @RequestBody RubricDTO rubricDTO){
        this.rubricService.editRubric(id, rubricDTO);
        return ResponseEntity.ok("Edited rubric with id: " + id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('RUBRIC_DELETE') || hasAuthority('RUBRIC') || hasAuthority('ALL') || hasAuthority('DELETEN')")
    public ResponseEntity<?> deleteRubric(@PathVariable("id") UUID id){
        this.rubricService.deleteRubric(id);
        return ResponseEntity.ok("deleted rubric with id: " + id);
    }
}
