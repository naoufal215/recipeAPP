package enset.mohammedia.recipe_web_site.repositories;

import enset.mohammedia.recipe_web_site.entities.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<Notes,Long> {
}
