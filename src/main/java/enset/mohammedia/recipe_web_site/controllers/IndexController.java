package enset.mohammedia.recipe_web_site.controllers;

import enset.mohammedia.recipe_web_site.services.IRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
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

}
