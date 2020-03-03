package enset.mohammedia.recipe_web_site.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private Integer preparationTime;
    @Getter
    @Setter
    private Integer cookTime;
    @Getter
    @Setter
    private Integer servings;
    @Getter
    @Setter
    private String source;
    @Getter
    @Setter
    private String url;

    @Getter
    @Setter
    @Lob
    private String directions;

    @Getter
    @Setter
    @Lob
    private Byte[] image;

    @Getter
    @Setter
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @Getter
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @Getter
    @Setter
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients=new HashSet<>();

    @Getter
    @Setter
    @ManyToMany(mappedBy = "recipes")
    private Set<Category> categories=new HashSet<>();


    public void setNotes(Notes notes) {
        this.notes = notes;
        this.notes.setRecipe(this);
    }

    public void addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
    }


    public void addCategory(Category category) {
        category.addRecipe(this);
        this.categories.add(category);
    }
}
