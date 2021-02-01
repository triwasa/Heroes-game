package pl.sdk;

import org.junit.jupiter.api.Test;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;

import java.beans.PropertyChangeEvent;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class SplashDamageCreatureTest {

    @Test
    void checkSplashDamage(){
        Creature splashCreature = new NecropolisFactory().create(true,5, 1);
        Creature defender = spy(Creature.class);
        Creature splashMock1 = spy(Creature.class);
        Creature splashMock2 = spy(Creature.class);
        Creature splashMock3 = spy(Creature.class);
        Creature splashMock4 = spy(Creature.class);
        Creature notSplashMock1 = spy(Creature.class);
        Creature notSplashMock2 = spy(Creature.class);
        Creature notSplashMock3 = spy(Creature.class);

        Board board = new Board();
        board.add(new Point(10,10),defender);
        board.add(new Point(10,9),splashMock1);
        board.add(new Point(10,11),splashMock2);
        board.add(new Point(9,10),splashMock3);
        board.add(new Point(11,10),splashMock4);
        board.add(new Point(11,11),splashMock4);
        board.add(new Point(11,13),splashMock4);
        board.add(new Point(0,2),splashMock4);

        GameEngine gameEngine = new GameEngine(List.of(splashCreature), Collections.emptyList(), board);
        gameEngine.attack(10,10);

        verify(defender).getDamageApplier().applyDamage(anyInt(),defender);
        verify(notSplashMock1,never()).getDamageApplier().applyDamage(anyInt(),notSplashMock1);
        verify(notSplashMock2,never()).getDamageApplier().applyDamage(anyInt(),notSplashMock2);
        verify(notSplashMock3,never()).getDamageApplier().applyDamage(anyInt(),notSplashMock3);
        verify(splashMock1).getDamageApplier().applyDamage(anyInt(),splashMock1);
        verify(splashMock2).getDamageApplier().applyDamage(anyInt(),splashMock2);
        verify(splashMock3).getDamageApplier().applyDamage(anyInt(),splashMock3);
        verify(splashMock4).getDamageApplier().applyDamage(anyInt(),splashMock4);
    };

    @Test
    void checkUnitWithoutSplashDamage(){
        Creature notSplashCreature = new NecropolisFactory().create(true,2, 1);
        Creature defender = spy(Creature.class);
        Creature splashMock1 = spy(Creature.class);
        Creature splashMock2 = spy(Creature.class);
        Creature splashMock3 = spy(Creature.class);
        Creature splashMock4 = spy(Creature.class);
        Creature notSplashMock1 = spy(Creature.class);
        Creature notSplashMock2 = spy(Creature.class);
        Creature notSplashMock3 = spy(Creature.class);

        Board board = new Board();
        board.add(new Point(1,1),defender);
        board.add(new Point(0,0),splashMock1);
        board.add(new Point(0,2),splashMock2);
        board.add(new Point(1,2),splashMock3);
        board.add(new Point(1,0),splashMock4);
        board.add(new Point(11,11),splashMock4);
        board.add(new Point(11,13),splashMock4);
        board.add(new Point(3,2),splashMock4);

        GameEngine gameEngine = new GameEngine(List.of(notSplashCreature), Collections.emptyList(), board);
        gameEngine.attack(1,1);

        verify(defender).getDamageApplier().applyDamage(anyInt(),defender);
        verify(notSplashMock1,never()).getDamageApplier().applyDamage(anyInt(),notSplashMock1);
        verify(notSplashMock2,never()).getDamageApplier().applyDamage(anyInt(),notSplashMock2);
        verify(notSplashMock3,never()).getDamageApplier().applyDamage(anyInt(),notSplashMock3);
        verify(splashMock1,never()).getDamageApplier().applyDamage(anyInt(),splashMock1);
        verify(splashMock2,never()).getDamageApplier().applyDamage(anyInt(),splashMock2);
        verify(splashMock3,never()).getDamageApplier().applyDamage(anyInt(),splashMock3);
        verify(splashMock4,never()).getDamageApplier().applyDamage(anyInt(),splashMock4);
    };


}
