package enset.mohammedia.recipe_web_site.converters;

import enset.mohammedia.recipe_web_site.commands.NotesCommand;
import enset.mohammedia.recipe_web_site.entities.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {



    @Synchronized

    @Override
    public Notes convert(@Nullable NotesCommand source) {
        if(null==source){
            return null;
        }
        return new Notes(source.getId(), null, source.getRecipeNotes());
    }
}
