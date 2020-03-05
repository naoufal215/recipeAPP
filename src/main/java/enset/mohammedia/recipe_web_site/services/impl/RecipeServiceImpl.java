package enset.mohammedia.recipe_web_site.services.impl;

import enset.mohammedia.recipe_web_site.commands.RecipeCommand;
import enset.mohammedia.recipe_web_site.converters.RecipeCommandToRecipe;
import enset.mohammedia.recipe_web_site.entities.Recipe;
import enset.mohammedia.recipe_web_site.repositories.RecipeRepository;
import enset.mohammedia.recipe_web_site.services.IRecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class RecipeServiceImpl implements IRecipeService {

    RecipeRepository recipeRepository;
    RecipeCommandToRecipe recipeCommandToRecipe;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe findById(Long id) throws Exception {
        return recipeRepository.findById(id).orElseThrow(()->new Exception("no recipe found"));
    }

    @Override
    @Transactional
    public Recipe save(RecipeCommand recipeCommand){
        Recipe savedRecipe= recipeRepository.save(Objects.requireNonNull(recipeCommandToRecipe.convert(recipeCommand)));
        log.info(String.format("new Recipe was saved to DB with ID: %s",savedRecipe.getId()));
        return savedRecipe;
    }
}
