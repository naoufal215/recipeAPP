package enset.mohammedia.recipe_web_site.entities;


import lombok.Getter;

@Getter
public enum Difficulty {

    EASY("easy"),
    MODERATE("moderate"),
    HARD("hard");

    private String value;

    Difficulty(String value){
        this.value=value;
    }
}
