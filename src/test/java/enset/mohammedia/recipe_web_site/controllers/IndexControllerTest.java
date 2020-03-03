package enset.mohammedia.recipe_web_site.controllers;

import enset.mohammedia.recipe_web_site.entities.Recipe;
import enset.mohammedia.recipe_web_site.services.impl.RecipeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IndexControllerTest {

    IndexController indexController;

    @Mock
    RecipeServiceImpl recipeService;

    @Mock
    Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        indexController=new IndexController(recipeService);
    }

    @Test
    public void testMVC() throws Exception {
        MockMvc mockMvc= MockMvcBuilders.standaloneSetup(indexController).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"));
    }

    @Test
    void index() {
        Recipe recipe=new Recipe();
        List<Recipe> recipies = new ArrayList<>();
        recipies.add(recipe);
        Mockito.when(recipeService.getAllRecipes()).thenReturn(recipies);
        String result= indexController.index(model);
        assertEquals("index",result);
        ArgumentCaptor resultOfRecipies=ArgumentCaptor.forClass(List.class);
        Mockito.verify(recipeService,Mockito.times(1)).getAllRecipes();
        Mockito.verify(model,Mockito.times(1)).addAttribute(ArgumentMatchers.eq("recipies"),resultOfRecipies.capture());
        List capturedResult=resultOfRecipies.getAllValues();
        assertEquals(1,capturedResult.size());
        //assertEquals(recipe,capturedResult.get(1));
    }
}