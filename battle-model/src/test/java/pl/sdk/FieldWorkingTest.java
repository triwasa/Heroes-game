package pl.sdk;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.Board;
import pl.sdk.Point;
import pl.sdk.creatures.BattleObject;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.InfernoFactory;
import pl.sdk.creatures.NecropolisFactory;
import pl.sdk.special_fields.Field;
import pl.sdk.special_fields.FieldsFactory;

import static org.junit.jupiter.api.Assertions.*;

public class FieldWorkingTest {

    private Board board;
    private Creature creature;

    @BeforeEach
    void init() {
        board = new Board();
        board.add(new Point(1,2), FieldsFactory.create("Lava"));
        board.add(new Point(4,4), FieldsFactory.create("ThunderStorm"));
        board.add(new Point(3,3), FieldsFactory.create("Stone"));
    }

    @Test
    void canNotStandOnTheStone() {
        Creature movingCreature = NecropolisFactory.createDefaultForTests();
        board.add(new Point(3,2), movingCreature);
        assertFalse(board.canMove( movingCreature,3, 3));
    }

    @Test
    void isLavaHurtingCreature() {
        Field lava = FieldsFactory.create("Lava");

        Creature movingCreature = NecropolisFactory.createDefaultForTests();
        lava.apply(movingCreature);
        assertEquals(5, movingCreature.getCurrentHp(), "Lava is not giving damage!");
    }

    @Test
    void isLavaFieldHurtingWhenStandingOn() {
        Creature movingCreature = NecropolisFactory.createDefaultForTests();
        board.add(new Point(1,1), movingCreature);
        board.move( movingCreature, new Point(1, 2));
        assertEquals(5, movingCreature.getCurrentHp(), "Lava is not giving damage!");
    }

    @Test
    //walking creature
    void isLavaFieldHurtingWhenGoingThrough() {
        NecropolisFactory factory = new NecropolisFactory();
        Creature movingCreature = factory.create(false, 1, 1);
        board.add(new Point(1,1), movingCreature);
        board.move( movingCreature, new Point(1, 3));
        assertEquals(1, movingCreature.getCurrentHp(), "Lava is not giving damage!");
    }

    @Test
    //flying creature
    void isLavaFieldHurtingWhenFlyingAbove() {
        NecropolisFactory factory = new NecropolisFactory();
        Creature movingCreature = factory.create(false, 3, 1);
        board.add(new Point(1,1), movingCreature);
        board.move( movingCreature, new Point(1, 3));
        assertEquals(18, movingCreature.getCurrentHp(), "Lava is giving damage!");
    }

    @Test
    //teleporting creature
    void isLavaFieldHurtingWhenTeleportingThrough() {
        InfernoFactory factory = new InfernoFactory();
        Creature movingCreature = factory.create(false, 7, 1);
        board.add(new Point(1,1), movingCreature);
        board.move( movingCreature, new Point(1, 3));
        assertEquals(160, movingCreature.getCurrentHp(), "Lava is giving damage!");
    }

    @Test
    //walking creature
    void isThunderStormFieldHurtingWhenGoingUnder() {
        NecropolisFactory factory = new NecropolisFactory();
        Creature movingCreature = factory.create(false, 1, 1);
        board.add(new Point(4,2), movingCreature);
        board.move( movingCreature, new Point(4, 5));
        assertEquals(6, movingCreature.getCurrentHp(), "ThunderStorm is giving damage!");
    }

    @Test
    //flying creature
    void isThunderStormFieldHurtingWhenFlyingThrough() {
        NecropolisFactory factory = new NecropolisFactory();
        Creature movingCreature = factory.create(false, 3, 1);
        board.add(new Point(4,2), movingCreature);
        board.move( movingCreature, new Point(4, 5));
        assertEquals(13, movingCreature.getCurrentHp(), "ThunderStorm is not giving damage!");
    }

    @Test
    //teleporting creature
    void isThunderStormFieldHurtingWhenTeleportingThrough() {
        InfernoFactory factory = new InfernoFactory();
        Creature movingCreature = factory.create(false, 7, 1);
        board.add(new Point(4,2), movingCreature);
        board.move( movingCreature, new Point(4, 5));
        assertEquals(160, movingCreature.getCurrentHp(), "ThunderStorm is giving damage!");
    }
}