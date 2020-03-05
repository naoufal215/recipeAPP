package enset.mohammedia.recipe_web_site.converters;

import enset.mohammedia.recipe_web_site.commands.IngredientCommand;
import enset.mohammedia.recipe_web_site.entities.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    private UnitOfMesureCommandToUniteOfMesure unitOfMesureToMesure;


    public IngredientCommandToIngredient(UnitOfMesureCommandToUniteOfMesure unitOfMesureToMesure) {
        this.unitOfMesureToMesure = unitOfMesureToMesure;
    }

    @Synchronized
    @Override
    public Ingredient convert(@Nullable IngredientCommand source) {
                if(null==source){
                    return null;
                }
                return new Ingredient(source.getId(),source.getDescription(),source.getAmount(),
                        unitOfMesureToMesure.convert(source.getUnitOfMesure()),null);
    }
}
