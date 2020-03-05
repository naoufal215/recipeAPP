package enset.mohammedia.recipe_web_site.commands;

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
public class CategoryCommand {

    private Long id;
    private String description;
    private Set<RecipeCommand> recipes=new HashSet<>();
}
