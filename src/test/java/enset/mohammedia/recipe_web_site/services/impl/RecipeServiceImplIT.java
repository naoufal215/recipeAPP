package enset.mohammedia.recipe_web_site.services.impl;

import enset.mohammedia.recipe_web_site.commands.CategoryCommand;
import enset.mohammedia.recipe_web_site.commands.IngredientCommand;
import enset.mohammedia.recipe_web_site.commands.NotesCommand;
import enset.mohammedia.recipe_web_site.commands.RecipeCommand;
import enset.mohammedia.recipe_web_site.entities.Difficulty;
import enset.mohammedia.recipe_web_site.entities.Recipe;
import enset.mohammedia.recipe_web_site.services.IRecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class RecipeServiceImplIT {


    @Autowired
    IRecipeService recipeService;


    @BeforeEach
    void setUp() {
    }

    @Test
    void getAllRecipes() {
    }

    @Test
    void findById() {
    }

    @Test
    @DirtiesContext
    void save() {
        long id = 1L;
        String desc = "test1";
        RecipeCommand recipeCommand=new RecipeCommand(id, desc,12,13,14,
                "source test","http test","direction test",new HashSet<IngredientCommand>(),
                Difficulty.EASY,new NotesCommand(),new HashSet<CategoryCommand>());

        Recipe recipeResul=recipeService.save(recipeCommand);

        assertEquals(id,recipeResul.getId());
        assertEquals(desc,recipeResul.getDescription());

    }
}