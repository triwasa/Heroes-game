package pl.sdk.creatures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.Board;
import pl.sdk.GameEngine;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MultipleRetaliationsCreatureTest {


    private Creature attacker;
    private Creature defender;
    private Random rand;

    @BeforeEach
    void init() {
        rand = mock(Random.class);
        when(rand.nextInt(anyInt())).thenReturn(0);

        attacker = new Creature.Builder()
                .statistic(CreatureStatistic.TEST)
                .damageCalculator(new DefaultCalculateStrategy(rand))
                .build();
        defender = new Creature.Builder()
                .statistic(CreatureStatistic.TEST)
                .build();
    }

//        @Test
//        void hasTwoRetaliationsPerRound() {
//        defender = new MultipleRetaliationsCreatureDecorator(defender,2);
//        GameEngine gameEngine = new GameEngine(List.of(attacker), List.of(defender) , new Board());
//
//        attacker.attack(defender);
//        assertTrue(defender.canCounterAttack());
//
//        attacker.attack(defender);
//        assertFalse(defender.canCounterAttack());
//
//        gameEngine.pass();
//        gameEngine.pass();
//
//        assertTrue(defender.canCounterAttack());
//
//        attacker.attack(defender);
//        assertTrue(defender.canCounterAttack());
//
//
//    }
}
