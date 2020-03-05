package enset.mohammedia.recipe_web_site.repositories;

import enset.mohammedia.recipe_web_site.entities.Category;
import enset.mohammedia.recipe_web_site.services.IRecipeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CategoryRepositoryIT {

    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    @DirtiesContext
    void findByDescription_american() {
        Optional<Category> category=categoryRepository.findByDescription("American");
        Assertions.assertTrue(category.isPresent());
        Assertions.assertEquals("American", category.get().getDescription());

    }

    @Test
    void findByDescription_italian() {
        Optional<Category> category=categoryRepository.findByDescription("Italian");
        Assertions.assertTrue(category.isPresent());
        Assertions.assertEquals("Italian", category.get().getDescription());

    }
}