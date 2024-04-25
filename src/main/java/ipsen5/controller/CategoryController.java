package ipsen5.controller;

import ipsen5.dao.CategoryDAO;
import ipsen5.dto.CategoryDTO;
import ipsen5.models.Category;
import ipsen5.services.UserInputValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/category")
public class CategoryController {

    private final CategoryDAO categoryDAO;
    private UserInputValidator validator;


    public CategoryController(CategoryDAO categoryDAO, UserInputValidator validator) {
        this.categoryDAO = categoryDAO;
        this.validator = validator;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getCategories(){
        return ResponseEntity.ok(this.categoryDAO.getAllCategories());
    }

    @PostMapping
    public ResponseEntity<String> createCategory(@RequestBody CategoryDTO categoryDTO){
        if (!validator.isValidName(categoryDTO.name)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid name provided"
            );
        }
        if (!validator.isValidDescription(categoryDTO.description)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid description provided"
            );
        }
        this.categoryDAO.createCategory(categoryDTO);
        return ResponseEntity.ok("Created a new category named " + categoryDTO.name);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editCategory(@PathVariable UUID id, @RequestBody CategoryDTO categoryDTO){
        if (!validator.isValidName(categoryDTO.name)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid name provided"
            );
        }
        if (!validator.isValidDescription(categoryDTO.description)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No valid description provided"
            );
        }
        this.categoryDAO.editCategory(id, categoryDTO);
        return ResponseEntity.ok("Edited category with id: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") UUID id){
        this.categoryDAO.deleteCategory(id);
        return ResponseEntity.ok("deleted category with id: " + id);
    }
}
