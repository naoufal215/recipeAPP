package enset.mohammedia.recipe_web_site.repositories;

import enset.mohammedia.recipe_web_site.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Optional<Category> findByDescription(String description);

}
