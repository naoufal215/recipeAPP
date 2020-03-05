package enset.mohammedia.recipe_web_site.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotesCommand {

    private Long id;
    private RecipeCommand recipe;
    private String  recipeNotes;
}
