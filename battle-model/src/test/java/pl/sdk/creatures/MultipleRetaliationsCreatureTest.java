package pl.sdk.creatures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.Board;
import pl.sdk.GameEngine;
import pl.sdk.hero.Hero;

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

        @Test
        void hasTwoRetaliationsPerRound() {
        defender = new MultipleRetaliationsCreatureDecorator(defender,2);
        Hero hero1 = new Hero();
        hero1.addCreatures(List.of(attacker));
            Hero hero2 = new Hero();
            hero2.addCreatures(List.of(defender));
        GameEngine gameEngine = new GameEngine(hero1, hero2 , new Board());

            attacker.getAttackStrategy().attack(attacker,defender);
        assertTrue(defender.canCounterAttack());

            attacker.getAttackStrategy().attack(attacker,defender);
        assertFalse(defender.canCounterAttack());

        gameEngine.pass();
        gameEngine.pass();

        assertTrue(defender.canCounterAttack());

        attacker.getAttackStrategy().attack(attacker,defender);
        assertTrue(defender.canCounterAttack());


    }
}
