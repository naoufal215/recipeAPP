package enset.mohammedia.recipe_web_site.services.impl;

import enset.mohammedia.recipe_web_site.entities.Recipe;
import enset.mohammedia.recipe_web_site.repositories.RecipeRepository;
import enset.mohammedia.recipe_web_site.services.IRecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RecipeServiceImpl implements IRecipeService {

    RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe findById(Long id) throws Exception {
        return recipeRepository.findById(id).orElseThrow(()->new Exception("no recipe found"));
    }
}
