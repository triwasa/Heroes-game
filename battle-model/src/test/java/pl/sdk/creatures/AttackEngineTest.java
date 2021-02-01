package pl.sdk.creatures;

import com.google.common.collect.Range;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.AttackEngine;
import pl.sdk.Board;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AttackEngineTest {

    public static final int NOT_IMPORTANT = 5;
    private Random randomizer;
    private AttackEngine attackEngine;

    @BeforeEach
    void init(){
        randomizer = mock(Random.class);
        when(randomizer.nextInt(anyInt())).thenReturn(4);
        attackEngine = new AttackEngine(new Board());
    }


    @Test
    void creatureShouldDealExactlyDamageWhenAttackAndArmorAreEquals(){
        Creature attacker = new Creature.BuilderForTesting()
                .name("Attacker")
                .attack(10)
                .armor(NOT_IMPORTANT)
                .maxHp(100)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(20,20))
                .build();
        Creature defender = new Creature.BuilderForTesting()
                .name("Defender")
                .attack(NOT_IMPORTANT)
                .armor(10)
                .maxHp(100)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(5,5))
                .build();

        attackEngine.attack(attacker,defender);

        assertEquals(80,defender.getCurrentHp());
    }

    @Test
    void creatureShouldDealDamagePlus10PercentWhenAttackIsGreaterThenArmorBy2Points(){
        Creature attacker = new Creature.BuilderForTesting()
                .name("Attacker")
                .attack(10)
                .armor(NOT_IMPORTANT)
                .maxHp(100)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(20,20))
                .build();
        Creature defender = new Creature.BuilderForTesting()
                .name("Defender")
                .attack(NOT_IMPORTANT)
                .armor(8)
                .maxHp(100)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(NOT_IMPORTANT,NOT_IMPORTANT))
                .build();

        attackEngine.attack(attacker,defender);

        assertEquals(78,defender.getCurrentHp());
    }

    @Test
    void creatureShouldDealDamageMinus5PercentWhenArmorIsGreaterThenAttackBy2Points(){
        Creature attacker = new Creature.BuilderForTesting()
                .name("Attacker")
                .attack(10)
                .armor(NOT_IMPORTANT)
                .maxHp(100).moveRange(NOT_IMPORTANT)
                .damage(Range.closed(10,20))
                .damageCalculator(new DefaultCalculateStrategy(randomizer))
                .build();
        Creature defender = new Creature.BuilderForTesting()
                .name("Defender")
                .attack(NOT_IMPORTANT)
                .armor(12)
                .maxHp(100)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(NOT_IMPORTANT,NOT_IMPORTANT))
                .build();
        attackEngine.attack(attacker,defender);

        assertEquals(87,defender.getCurrentHp());
    }

    @Test
    void shouldDealTwoXMoreDamageWhenStackHasTwoUnits(){
        Creature attacker = new Creature.BuilderForTesting()
                .name("Attacker")
                .attack(10).armor(NOT_IMPORTANT)
                .maxHp(100).moveRange(NOT_IMPORTANT)
                .damage(Range.closed(10,20))
                .damageCalculator(new DefaultCalculateStrategy(randomizer))
                .amount(2)
                .build();
        Creature defender = new Creature.BuilderForTesting()
                .name("Defender")
                .attack(NOT_IMPORTANT)
                .armor(12)
                .maxHp(100)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(NOT_IMPORTANT,NOT_IMPORTANT))
                .build();
        attackEngine.attack(attacker,defender);

        assertEquals(74,defender.getCurrentHp());
    }

    @Test
    void canAttack() {
        assertFalse(attackEngine.canAttack(new Creature(),new Wall()));
        assertTrue(attackEngine.canAttack(new Creature(),new Ballista()));
        assertTrue(attackEngine.canAttack(new Ballista(),new Creature()));
        assertTrue(attackEngine.canAttack(new Keep(),new Creature()));
        assertFalse(attackEngine.canAttack(new Catapult(), new Creature()));
        assertTrue(attackEngine.canAttack(new Catapult(), new Wall()));
    }
}