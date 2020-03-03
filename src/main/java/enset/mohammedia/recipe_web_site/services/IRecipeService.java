package enset.mohammedia.recipe_web_site.services;

import enset.mohammedia.recipe_web_site.entities.Recipe;

import java.util.List;

public interface IRecipeService {

    List<Recipe> getAllRecipes();
}
