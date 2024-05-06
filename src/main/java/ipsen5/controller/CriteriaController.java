package ipsen5.controller;

import ipsen5.dao.CriteriaDAO;
import ipsen5.dto.CriteriaDTO;
import ipsen5.models.Criteria;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/criteria")
public class CriteriaController {
    private final CriteriaDAO criteriaDAO;

    public CriteriaController(CriteriaDAO criteriaDAO) {
        this.criteriaDAO = criteriaDAO;
    }

    @GetMapping
    public ResponseEntity<List<Criteria>> getAllCriteria(){
        return ResponseEntity.ok(this.criteriaDAO.getAllCriteria());
    }

    @PostMapping
    public ResponseEntity<String> createCriteria(@RequestBody CriteriaDTO criteriaDTO){
        this.criteriaDAO.createCriteria(criteriaDTO);
        return ResponseEntity.ok("Created a new Criteria named");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editCriteria(@PathVariable Long id, @RequestBody CriteriaDTO criteriaDTO){
        this.criteriaDAO.editCriteria(id, criteriaDTO);
        return ResponseEntity.ok("Edited criteria with id: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCriteria(@PathVariable("id") Long id){
        this.criteriaDAO.deleteCriteria(id);
        return ResponseEntity.ok("deleted criteria with id: " + id);
    }
}
