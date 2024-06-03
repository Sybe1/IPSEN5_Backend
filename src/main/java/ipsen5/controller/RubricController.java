package ipsen5.controller;

import ipsen5.dao.RubricDAO;
import ipsen5.dto.RubricDTO;
import ipsen5.models.Criteria;
import ipsen5.models.Rubric;
import ipsen5.services.InputValidator;
import ipsen5.services.RatingValidator;
import ipsen5.services.RubricValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rubric")
public class RubricController {
    private final RubricDAO rubricDAO;
    private RubricValidator validator;

    public RubricController(RubricDAO rubricDAO, RubricValidator validator) {
        this.rubricDAO = rubricDAO;
        this.validator = validator;
    }

    @GetMapping("/{id}/criteria")
    public Set<Criteria> getCriteriaByRubricId(@PathVariable UUID id) {
        return rubricDAO.getCriteriaByRubricId(id);
    }

    @GetMapping
    public ResponseEntity<List<Rubric>> getAllRubrics(){
        return ResponseEntity.ok(this.rubricDAO.getAllRubrics());
    }

    @PostMapping
    public ResponseEntity<String> createRubric(@RequestBody RubricDTO rubricDTO){
        validator.rubricValidations(rubricDTO);
        this.rubricDAO.createRubric(rubricDTO);
        return ResponseEntity.ok("Created a new Rubric");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editRubric(@PathVariable UUID id, @RequestBody RubricDTO rubricDTO){
        validator.rubricValidations(rubricDTO);
        this.rubricDAO.editRubric(id, rubricDTO);
        return ResponseEntity.ok("Edited rubric with id: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRubric(@PathVariable("id") UUID id){
        this.rubricDAO.deleteRubric(id);
        return ResponseEntity.ok("deleted rubric with id: " + id);
    }
}
