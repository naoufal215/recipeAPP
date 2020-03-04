package enset.mohammedia.recipe_web_site.controllers;

import enset.mohammedia.recipe_web_site.services.IRecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Slf4j
public class IndexController {

    private IRecipeService recipeService;

    @Autowired
    public IndexController(IRecipeService recipeService){
        this.recipeService=recipeService;
    }

    @GetMapping({"","/","/index","indexs","f"})
    public String index(Model model){
        model.addAttribute("recipies",recipeService.getAllRecipes());
        return "index";
    }

    @GetMapping({"/recipe/show/{id}"})
    public String viewByRecipe(@PathVariable("id") Long id, Model model){
        try {
            model.addAttribute("recipe",recipeService.findById(id));
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        return "recipeView";
    }

}
