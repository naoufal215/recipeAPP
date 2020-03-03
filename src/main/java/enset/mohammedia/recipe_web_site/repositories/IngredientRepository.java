package enset.mohammedia.recipe_web_site.repositories;

import enset.mohammedia.recipe_web_site.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient,Long> {
}
