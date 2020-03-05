package enset.mohammedia.recipe_web_site.converters;

import enset.mohammedia.recipe_web_site.commands.RecipeCommand;
import enset.mohammedia.recipe_web_site.entities.Category;
import enset.mohammedia.recipe_web_site.entities.Ingredient;
import enset.mohammedia.recipe_web_site.entities.Notes;
import enset.mohammedia.recipe_web_site.entities.Recipe;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {


    private NotesCommandToNotes notesCommandToNotes;
    private IngredientCommandToIngredient ingredientCommandToIngredient;
    private CategoryCommandToCategory categoryCommandToCategory;

    @Autowired
    public RecipeCommandToRecipe(NotesCommandToNotes notesCommandToNotes, IngredientCommandToIngredient ingredientCommandToIngredient, CategoryCommandToCategory categoryCommandToCategory) {
        this.notesCommandToNotes = notesCommandToNotes;
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
        this.categoryCommandToCategory = categoryCommandToCategory;
    }

    @Synchronized
    @Override
    public Recipe convert(@Nullable RecipeCommand source) {
        if(null==source){
            return null;
        }
        Notes convertedNotes = notesCommandToNotes.convert(source.getNotes());

        Set<Ingredient> convertedIngredientSet = source.getIngredients()
                .stream()
                .map(ingredientCommandToIngredient::convert)
                .collect(Collectors.toSet());

        Set<Category> convertedCategoriesSet = source.getCategories().stream().map(categoryCommandToCategory::convert).collect(Collectors.toSet());
        Recipe recipe= new Recipe(source.getId(),source.getDescription(),source.getPrepTime(),source.getCookTime(),source.getServings(),
                source.getSource(),source.getUrl(),source.getDirections(),
                null,source.getDifficulty(), convertedNotes,
                null,
                convertedCategoriesSet);

        if (convertedNotes != null) {
            convertedNotes.setRecipe(recipe);
        }

        convertedIngredientSet=convertedIngredientSet.stream().map(ingredient -> {
            ingredient.setRecipe(recipe);
            return ingredient;
        }).collect(Collectors.toSet());
        recipe.setIngredients(convertedIngredientSet);

        convertedCategoriesSet=convertedCategoriesSet.stream().map(category -> {
            category.getRecipes().add(recipe);
            return category;
        }).collect(Collectors.toSet());
        recipe.setCategories(convertedCategoriesSet);

        return recipe;
    }
}
