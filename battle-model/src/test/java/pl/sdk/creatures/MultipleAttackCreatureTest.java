package pl.sdk.creatures;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.AttackEngine;
import pl.sdk.Board;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MultipleAttackCreatureTest {
    private Creature attacker;
    private Creature defender;
    private Random rand;


    @BeforeEach
    void init(){
        rand = mock(Random.class);
        when(rand.nextInt(anyInt())).thenReturn(0);

        defender = new Creature.Builder()
                .statistic(CreatureStatistic.TEST)
                .build();
    }
    @Test
    void twoAttacksByCreature() {
        attacker = new Creature.Builder()
                .statistic(CreatureStatistic.TEST)
                .damageCalculator(new DefaultCalculateStrategy(rand))
                .attackStrategy(new MulitpleAttackAttackStrategy(new DefaultAttackStrategy(),2))
                .build();
        attacker.getAttackStrategy().attack(attacker,defender);
        assertEquals(6, defender.getCurrentHp());
    }
    @Test
    void threeAttacksByCreaturee() {
        attacker = new Creature.Builder()
                .statistic(CreatureStatistic.TEST)
                .damageCalculator(new DefaultCalculateStrategy(rand))
                .attackStrategy(new MulitpleAttackAttackStrategy(new DefaultAttackStrategy(),3))
                .build();
        attacker.getAttackStrategy().attack(attacker,defender);
        assertEquals(4, defender.getCurrentHp());
    }
    @Test
    void isItWorkingWithBlockingDecorator() {
        attacker = new Creature.Builder()
                .statistic(CreatureStatistic.TEST)
                .damageCalculator(new DefaultCalculateStrategy(rand))
                .attackStrategy(new MulitpleAttackAttackStrategy(new BlockCounterAttackAttackStrategy(new DefaultAttackStrategy()),2))
                .build();
        attacker.getAttackStrategy().attack(attacker,defender);
        assertEquals(10, attacker.getCurrentHp());

    }
    @Test
    void creatureHasZeroAttacks() {
        attacker = new Creature.Builder()
                .statistic(CreatureStatistic.TEST)
                .damageCalculator(new DefaultCalculateStrategy(rand))
                .attackStrategy(new MulitpleAttackAttackStrategy(new DefaultAttackStrategy(),0))
                .build();
        attacker.getAttackStrategy().attack(attacker,defender);
        assertEquals(10, defender.getCurrentHp());
        assertEquals(10, attacker.getCurrentHp());
    }
}
