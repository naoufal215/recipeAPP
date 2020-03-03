package enset.mohammedia.recipe_web_site.repositories;

import enset.mohammedia.recipe_web_site.entities.UnitOfMesure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnitOfMesureRepository extends JpaRepository<UnitOfMesure,Long> {

    Optional<UnitOfMesure> findByDescription(String description);
}
