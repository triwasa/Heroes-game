package pl.sdk.fields;
import org.junit.jupiter.api.Test;
import pl.sdk.Board;
import pl.sdk.Point;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;
import pl.sdk.special_fields.Field;
import pl.sdk.special_fields.FieldsFactory;

import static org.junit.jupiter.api.Assertions.*;

public class FieldWorkingTest {

    @Test
    void shouldReturCorrectFieldType(){
    }

    @Test
    void canNotStandOnTheField(){
        Creature movingCreature = NecropolisFactory.createDefaultForTests();
    }

    @Test
    void canStandOnTheField(){
    }

    @Test
    void isLavaHurtingCreature(){
        Field lava = FieldsFactory.create("Lava");

        Creature movingCreature = NecropolisFactory.createDefaultForTests();
        lava.apply(movingCreature);
        assertEquals(5, movingCreature.getCurrentHp(), "Lava is not giving damage");
    }

    @Test
    void isCreatureRangeSmallerByStandingOnTheField(){
    }
}