package enset.mohammedia.recipe_web_site.repositories;

import enset.mohammedia.recipe_web_site.entities.Category;
import enset.mohammedia.recipe_web_site.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {
}
