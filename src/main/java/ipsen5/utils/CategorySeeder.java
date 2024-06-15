package ipsen5.utils;

import ipsen5.dao.CategoryRepository;
import ipsen5.models.Category;
import org.springframework.stereotype.Component;

@Component
public class CategorySeeder {

    private final CategoryRepository categoryRepository;

    public CategorySeeder(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void seedCategory(){
        Category category = new Category();
        category.setName("OFFICIAL SELECTION");
        category.setDescription("Hier staan alle posts in die door de keuring zijn gekomen.");
        categoryRepository.save(category);

        Category category2 = new Category();
        category2.setName("BABELs CHOICE");
        category2.setDescription("Hier staan alle posts in die zijn uitgelicht door The Babel Company.");
        categoryRepository.save(category2);

        Category category3 = new Category();
        category3.setName("SANDBOX");
        category3.setDescription("Hier staan alle posts in die door de minimale keuring zijn " +
                "gekomen en nu door het publiek beoordeelt gaan worden.");
        categoryRepository.save(category3);
    }
}
