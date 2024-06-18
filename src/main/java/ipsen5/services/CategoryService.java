package ipsen5.services;

import ipsen5.dto.CategoryDTO;
import ipsen5.models.Category;
import ipsen5.repository.CategoryRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }

    public void createCategory(CategoryDTO categoryDTO) {
        this.categoryRepository.save(new Category(categoryDTO.name, categoryDTO.description));
    }

    public void editCategory(UUID id, CategoryDTO categoryDTO) {
        Category category = this.categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        category.setName(categoryDTO.name);
        category.setDescription(categoryDTO.description);
        this.categoryRepository.save(category);
    }

    public void deleteCategory(UUID id) {
        this.categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        this.categoryRepository.deleteById(id);
    }
}
