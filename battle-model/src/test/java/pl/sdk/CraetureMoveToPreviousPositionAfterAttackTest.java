/*
package pl.sdk;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.Creature;
import pl.sdk.PositionSaver;
import pl.sdk.creatures.CreatureMoveToPreviousPositionAfterAttackDecorator;


import java.util.List;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;

public class CraetureMoveToPreviousPositionAfterAttackTest {
    Creature creatrueMoveToPrevPositionAfterAttack;
    Creature defender;
    Creature defultCreature;
    Point currentPosition;
    Point previousPosition;
    @BeforeEach
    void init() {
        creatrueMoveToPrevPositionAfterAttack = spy(Creature.class);
        defultCreature = spy(Creature.class);
        defender = spy(Creature.class);
    }


    @Test
    void moveToPrevPositionAfterAttack() {
       creatrueMoveToPrevPositionAfterAttack = new CreatureMoveToPreviousPositionAfterAttackDecorator(creatrueMoveToPrevPositionAfterAttack);
       Board board = new Board();
       GameEngine engine = new GameEngine(List.of(creatrueMoveToPrevPositionAfterAttack), List.of(defender), board);
       previousPosition = board.get(creatrueMoveToPrevPositionAfterAttack);
       engine.move(new Point(board.get(defender).getX() + 1, board.get(defender).getY()));
       currentPosition = board.get(creatrueMoveToPrevPositionAfterAttack);
       engine.attack(board.get(defender).getX(), board.get(defender).getY());
       currentPosition = board.get(creatrueMoveToPrevPositionAfterAttack);

       assertTrue(previousPosition.equals(currentPosition));

    }

    @Test
    void avoidMovingToPreviousPositionByNormalCreature() {
        Board board = new Board();
        GameEngine engine = new GameEngine(List.of(defultCreature), List.of(defender), board);
        previousPosition = board.get(defultCreature);
        engine.move(new Point(board.get(defender).getX() + 1, board.get(defender).getY()));
        currentPosition = board.get(defultCreature);
        engine.attack(board.get(defender).getX(), board.get(defender).getY());
        currentPosition = board.get(defultCreature);

        assertFalse(previousPosition.equals(currentPosition));
    }

    @Test
    void avoidFalsePositioningForMovingToPreviousPositionCreature() {
        creatrueMoveToPrevPositionAfterAttack = new CreatureMoveToPreviousPositionAfterAttackDecorator(creatrueMoveToPrevPositionAfterAttack);
        Board board = new Board();
        GameEngine engine = new GameEngine(List.of(defender), List.of(creatrueMoveToPrevPositionAfterAttack), board);
        previousPosition = board.get(defender);
        engine.move(new Point(board.get(defender).getX() + 1, board.get(defender).getY()));
        engine.pass();
        currentPosition = board.get(creatrueMoveToPrevPositionAfterAttack);
        engine.attack(board.get(defender).getX(), board.get(defender).getY());
        Point currentPosition2 = board.get(creatrueMoveToPrevPositionAfterAttack);

        assertTrue(currentPosition.equals(currentPosition2));
        assertFalse(previousPosition.equals(currentPosition));
    }

}
*/
