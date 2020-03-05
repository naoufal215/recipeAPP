package enset.mohammedia.recipe_web_site.converters;

import enset.mohammedia.recipe_web_site.commands.UnitOfMesureCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class UnitOfMesureCommandToUniteOfMesureTest {

    private  UnitOfMesureCommandToUniteOfMesure unitOfMesureCommandToUniteOfMesure;
    @BeforeEach
    void setUp() {
        unitOfMesureCommandToUniteOfMesure=new UnitOfMesureCommandToUniteOfMesure();
    }

    @Test
    void convert() {
        UnitOfMesureCommand unitOfMesureCommand=new UnitOfMesureCommand();
        long id = 1L;
        unitOfMesureCommand.setId(id);
        assertEquals(id, Objects.requireNonNull(unitOfMesureCommandToUniteOfMesure.convert(unitOfMesureCommand)).getId());
    }

    @Test
    void convert_test_case_null() {
        UnitOfMesureCommand unitOfMesureCommand=null;
        assertNull(unitOfMesureCommandToUniteOfMesure.convert(unitOfMesureCommand));
    }

}