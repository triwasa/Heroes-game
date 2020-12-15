package pl.sdk;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.Creature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;

public class CraetureMoveToPreviousPositionAfterAttackTest {
    Creature creatrueMoveToPrevPositionAfterAttack;
    Creature defender;
    @BeforeEach
    void init() {
        creatrueMoveToPrevPositionAfterAttack = spy(Creature.class);
        defender = spy(Creature.class);
    }

/*
    @Test
    void moveToPrevPositionAfterAttack() {
       Board board = new Board();
       Point previousPosition = new Point(0,0);
       board.add(previousPosition, creatrueMoveToPrevPositionAfterAttack);
       board.add(new Point(0,10), defender);

       board.move(creatrueMoveToPrevPositionAfterAttack, new Point(0, 9));
       creatrueMoveToPrevPositionAfterAttack.attack(defender);

        assertEquals(previousPosition, board.get(creatrueMoveToPrevPositionAfterAttack));

    }
*/
}
