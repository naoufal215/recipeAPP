package enset.mohammedia.recipe_web_site.entities;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    Category category;

    @BeforeEach
    public void setUp(){
        category=new Category();
    }

    @Test
    void addRecipe() {
        category.addRecipe(new Recipe());
        assertEquals(1,category.getRecipes().size());
    }

    @Test
    void setId() {
        int id = 4;
        category.setId(id);
        assertEquals(id,category.getId());


    }

    @Test
    void setDescription() {
    }

    @Test
    void setRecipes() {
    }

    @Test
    void getId() {
    }

    @Test
    void getDescription() {
    }

    @Test
    void getRecipes() {
    }
}