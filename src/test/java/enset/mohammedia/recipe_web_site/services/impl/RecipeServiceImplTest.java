package enset.mohammedia.recipe_web_site.services.impl;

import enset.mohammedia.recipe_web_site.entities.Recipe;
import enset.mohammedia.recipe_web_site.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RecipeServiceImplTest {

    private RecipeServiceImpl recipeService;

    @Mock
    private RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService= new RecipeServiceImpl(recipeRepository);
    }

    @Test
    void getAllRecipes() {

        Recipe recipe=new Recipe();
        Mockito.when(recipeRepository.findAll()).thenReturn(List.of(recipe));

        List<Recipe> result=recipeService.getAllRecipes();

        Mockito.verify(recipeRepository,Mockito.times(1)).findAll();

        assertEquals(1,result.size());

    }
}