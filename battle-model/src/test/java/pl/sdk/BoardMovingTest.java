package pl.sdk;

import com.google.common.collect.Range;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.Board;
import pl.sdk.Point;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.GuiTile;
import pl.sdk.creatures.NecropolisFactory;
import pl.sdk.special_fields.Field;
import pl.sdk.special_fields.FieldsFactory;

import static org.junit.jupiter.api.Assertions.*;

class BoardMovingTest {

    private Board board;
    private Creature creature;

    @BeforeEach
    void init(){
        board = new Board();
        creature = NecropolisFactory.createDefaultForTests();
        board.add(new Point(0,0), creature);

        // added for special fields
        board.add(new Point(5,5), FieldsFactory.create("Lava"));
        board.add(new Point(6,6), FieldsFactory.create("Stone"));
        board.add(new Point(7,7), FieldsFactory.create("Water"));
    }

    @Test
    void creatureShouldMoveCorrectly(){
        board.move(new Point(0,0), new Point(0,1));

        GuiTile creatureFromBoard = board.get(0, 1);

        assertEquals(creature,creatureFromBoard);
        assertNull(board.get(0,0));
    }

    @Test
    void shouldThrowExceptionWhenCreatureTryingToMoveToNotEmptyField(){
        board.add(new Point(0,1), NecropolisFactory.createDefaultForTests());

        assertThrows(IllegalArgumentException.class, () -> board.move(new Point(0,0), new Point(0,1)));

        GuiTile creatureFromBoard = board.get(0, 0);
        assertEquals(creature,creatureFromBoard);
    }

    @Test
    void canMoveWhenCreatureHasEnoughtMovePoint(){
        creature = NecropolisFactory.createDefaultForTests();
        board.add(new Point(5,5), creature);

        assertTrue(board.canMove(creature, 6,5 ));
        assertTrue(board.canMove(creature, 4,5 ));
        assertTrue(board.canMove(creature, 5,4 ));
        assertTrue(board.canMove(creature, 5,6 ));
    }

    @Test
    void cannotMoveWhenCreatureHasNotEnoughtMovePoint(){
            Creature creature = NecropolisFactory.createDefaultForTests();
            board.add(new Point(5,5), creature);

            assertFalse(board.canMove(creature, 6,6));

    }

    @Test
    void cannotMoveWhenTileIsTaken(){
        GuiTile creature = NecropolisFactory.createDefaultForTests();
        board.add(new Point(5,5), creature);

        assertFalse(board.canMove(creature, 0,0 ));
    }

    @Test
    void canNotStandOnTheField(){
        Creature movingCreature = NecropolisFactory.createDefaultForTests();
        board.add(new Point(4,4), creature);


    }

    // added for special fields
    @Test
    void LavaFieldDamage(){

    }

    void pathSearchTest() {
        GuiTile creature = new NecropolisFactory().create(false , 1, 1);
        board.add(new Point(4,5), creature);
        board.add(new Point(4,4), new NecropolisFactory().create(false , 1, 1));
        board.add(new Point(3,4), new NecropolisFactory().create(false , 1, 1));
        board.add(new Point(2,4), new NecropolisFactory().create(false , 1, 1));
        board.add(new Point(5,4), new NecropolisFactory().create(false , 1, 1));
        board.add(new Point(6,4), new NecropolisFactory().create(false , 1, 1));
        board.add(new Point(7,4), new NecropolisFactory().create(false , 1, 1));
        assertFalse(board.canMove(creature, 5,3));
    }
}