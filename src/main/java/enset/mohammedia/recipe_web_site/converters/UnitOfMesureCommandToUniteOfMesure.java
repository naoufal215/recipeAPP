package enset.mohammedia.recipe_web_site.converters;

import enset.mohammedia.recipe_web_site.commands.UnitOfMesureCommand;
import enset.mohammedia.recipe_web_site.entities.UnitOfMesure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMesureCommandToUniteOfMesure implements Converter<UnitOfMesureCommand, UnitOfMesure> {

    @Synchronized
    @Override
    public UnitOfMesure convert(@Nullable UnitOfMesureCommand source) {
        if(null==source){
            return null;
        }
        return new UnitOfMesure(source.getId(),source.getDescription(),source.getValue());
    }
}
