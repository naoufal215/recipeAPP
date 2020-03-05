package enset.mohammedia.recipe_web_site.commands;

import enset.mohammedia.recipe_web_site.entities.Difficulty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeCommand {

    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Set<IngredientCommand> ingredients=new HashSet<>();
    private Difficulty difficulty;
    private NotesCommand  notes;
    private Set<CategoryCommand> categories=new HashSet<>();
}
