package enset.mohammedia.recipe_web_site.converters;

import enset.mohammedia.recipe_web_site.commands.CategoryCommand;
import enset.mohammedia.recipe_web_site.entities.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryCommandToCategory  implements Converter<CategoryCommand, Category> {


    @Synchronized
    @Override
    public Category convert(@Nullable CategoryCommand source){
        if(null==source){
            return null;
        }
        return new Category(source.getId(),source.getDescription(), null);

    }
}
