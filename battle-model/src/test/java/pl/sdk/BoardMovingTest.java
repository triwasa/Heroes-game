package pl.sdk;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardMovingTest {

    private Board board;
    private Creature creature;

    @BeforeEach
    void init(){
        board = new Board();
        creature = new Creature.Builder()
                .name("Name")
                .attack(2)
                .armor(1)
                .maxHp(10)
                .moveRange(1)
                .damage(Range.closed(2,2))
                .build();
        board.add(new Point(0,0), creature);
    }

    @Test
    void creatureShouldMoveCorrectly(){
        board.move(new Point(0,0), new Point(0,1));

        Creature creatureFromBoard = board.get(0, 1);

        assertEquals(creature,creatureFromBoard);
        assertNull(board.get(0,0));
    }

    @Test
    void shouldThrowExceptionWhenCreatureTryingToMoveToNotEmptyField(){
        board.add(new Point(0,1), new Creature.Builder()
                .name("Name")
                .attack(2)
                .armor(1)
                .maxHp(10)
                .moveRange(1)
                .damage(Range.closed(2,2))
                .build());

        assertThrows(IllegalArgumentException.class, () -> board.move(new Point(0,0), new Point(0,1)));

        Creature creatureFromBoard = board.get(0, 0);
        assertEquals(creature,creatureFromBoard);
    }

    @Test
    void canMoveWhenCreatureHasEnoughtMovePoint(){
        creature = new Creature.Builder()
                .name("Name")
                .attack(2)
                .armor(1)
                .maxHp(10)
                .moveRange(1)
                .damage(Range.closed(2,2))
                .build();
        board.add(new Point(5,5), creature);

        assertTrue(board.canMove(creature, 6,5 ));
        assertTrue(board.canMove(creature, 4,5 ));
        assertTrue(board.canMove(creature, 5,4 ));
        assertTrue(board.canMove(creature, 5,6 ));
    }

    @Test
    void cannotMoveWhenCreatureHasNotEnoughtMovePoint(){
        Creature creature = new Creature.Builder()
                .name("Name")
                .attack(2)
                .armor(1)
                .maxHp(10)
                .moveRange(1)
                .damage(Range.closed(2,2))
                .build();
        board.add(new Point(5,5), creature);

        assertFalse(board.canMove(creature, 6,6 ));
    }

    @Test
    void cannotMoveWhenTileIsTaken(){
        Creature creature = new Creature.Builder()
                .name("Name")
                .attack(2)
                .armor(1)
                .maxHp(10)
                .moveRange(1)
                .damage(Range.closed(2,2))
                .build();
        board.add(new Point(5,5), creature);

        assertFalse(board.canMove(creature, 0,0 ));
    }

}