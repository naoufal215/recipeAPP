package enset.mohammedia.recipe_web_site.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;

    @ManyToMany
    @JoinTable(name = "category_recipe",joinColumns =@JoinColumn(name="category_id"),
            inverseJoinColumns = @JoinColumn(name="recipe_id"))
    private Set<Recipe> recipes=new HashSet<>();

    public void addRecipe(Recipe recipe) {
        this.getRecipes().add(recipe);
    }
}
