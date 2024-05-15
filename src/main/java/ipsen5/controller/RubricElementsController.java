package ipsen5.controller;

import ipsen5.dao.RubricElementsDAO;
import ipsen5.dto.RubricElementsDTO;
import ipsen5.models.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rubricelements")
public class RubricElementsController {
    private final RubricElementsDAO rubricElementsDAO;

    public RubricElementsController(RubricElementsDAO rubricElementsDAO) {
        this.rubricElementsDAO = rubricElementsDAO;
    }

    @GetMapping
    public ResponseEntity<List<RubricElements>> getPostCategories() {
        return ResponseEntity.ok(this.rubricElementsDAO.getPostCategories());
    }

    @PostMapping
    public  ResponseEntity<String> createRubricElements(@RequestBody RubricElementsDTO rubricElementsDTO) {
        this.rubricElementsDAO.createRubricElements(rubricElementsDTO);
        return ResponseEntity.ok("Created a new RubricElements with RubricID " + rubricElementsDTO.rubric + "and CriteriaID " + rubricElementsDTO.criteria);
    }

    @DeleteMapping("/{rubricId}/{criteriaId}")
    public ResponseEntity<?> deleteRubricElements(@PathVariable Rubric rubricId, @PathVariable Criteria criteriaId) {
        this.rubricElementsDAO.deleteRubricElements(rubricId, criteriaId);
        return ResponseEntity.ok("Deleted RubricElements with RubricID " + rubricId + "and CriteriaID " + criteriaId);
    }
}
