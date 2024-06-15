package ipsen5.controller;

import ipsen5.dao.CategoryDAO;
import ipsen5.dto.CategoryDTO;
import ipsen5.models.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/category")
public class CategoryController {

    private final CategoryDAO categoryDAO;


    public CategoryController(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('CATEGORY_GET') || hasAuthority('CATEGORY') || hasAuthority('ALL') || hasAuthority('GETTEN')")
    public ResponseEntity<List<Category>> getCategories(){
        return ResponseEntity.ok(this.categoryDAO.getAllCategories());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('CATEGORY_POST') || hasAuthority('CATEGORY') || hasAuthority('ALL') || hasAuthority('POSTEN')")
    public ResponseEntity<String> createCategory(@RequestBody CategoryDTO categoryDTO){
        this.categoryDAO.createCategory(categoryDTO);
        return ResponseEntity.ok("Created a new category named " + categoryDTO.name);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('CATEGORY_PUT') || hasAuthority('CATEGORY') || hasAuthority('ALL') || hasAuthority('UPDATEN')")
    public ResponseEntity<String> editCategory(@PathVariable UUID id, @RequestBody CategoryDTO categoryDTO){
        this.categoryDAO.editCategory(id, categoryDTO);
        return ResponseEntity.ok("Edited category with id: " + id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('CATEGORY_DELETE') || hasAuthority('CATEGORY') || hasAuthority('ALL') || hasAuthority('DELETEN')")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") UUID id){
        this.categoryDAO.deleteCategory(id);
        return ResponseEntity.ok("deleted category with id: " + id);
    }
}
