package pl.sdk.creatures;


import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FirstAidTentTest {

    public static final int NOT_IMPORTANT = 5;
    private Random randomizer;


    @BeforeEach
    void init(){
        randomizer = mock(Random.class);
        when(randomizer.nextInt(anyInt())).thenReturn(5);
    }

    @Test

    void shouldHeal(){
        FirstAidTent tent = new FirstAidTent.BuilderForTesting()
                .name("tent")
                .attack(0)
                .armor(NOT_IMPORTANT)
                .maxHp(NOT_IMPORTANT)
                .moveRange(NOT_IMPORTANT)
                .damageCalculator(new HealCalculateDamageStrategy())
                .damage(Range.closed(5, 5))
                .build();
        Creature attacker = new Creature.BuilderForTesting()
                .name("Attacker")
                .attack(0)
                .armor(NOT_IMPORTANT)
                .maxHp(100)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(20,20))
                .build();
        Creature defender = new Creature.BuilderForTesting()
                .name("Defender")
                .attack(NOT_IMPORTANT)
                .armor(0)
                .maxHp(100)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(5,5))
                .build();
        attacker.getAttackStrategy().attack(attacker, defender);
        tent.getAttackStrategy().attack(tent, defender);

        assertEquals(85,defender.getCurrentHp());

    }
    @Test
    void shouldNotOverheal(){
        FirstAidTent tent = new FirstAidTent.BuilderForTesting()
                .name("tent")
                .attack(0)
                .armor(NOT_IMPORTANT)
                .maxHp(NOT_IMPORTANT)
                .moveRange(NOT_IMPORTANT)
                .damageCalculator(new HealCalculateDamageStrategy())
                .damage(Range.closed(5, 5))
                .build();
        Creature attacker = new Creature.BuilderForTesting()
                .name("Attacker")
                .attack(0)
                .armor(NOT_IMPORTANT)
                .maxHp(100)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(2,2))
                .build();
        Creature defender = new Creature.BuilderForTesting()
                .name("Defender")
                .attack(NOT_IMPORTANT)
                .armor(0)
                .maxHp(100)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(5,5))
                .build();
        attacker.getAttackStrategy().attack(attacker, defender);
        tent.getAttackStrategy().attack(tent, defender);

        assertEquals(100,defender.getCurrentHp());

    }

    @Test
    void shouldTakeDamage() {
        FirstAidTent tent=new FirstAidTent.BuilderForTesting()
                .name("FirstAidTent")
                .attack(NOT_IMPORTANT)
                .armor(NOT_IMPORTANT)
                .maxHp(100)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(NOT_IMPORTANT, NOT_IMPORTANT))
                .build();
        Creature attacker=new Creature.BuilderForTesting()
                .name("Attacker")
                .attack(5)
                .armor(NOT_IMPORTANT)
                .maxHp(NOT_IMPORTANT)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(5, 5))
                .build();
        attacker.getAttackStrategy().attack(attacker, tent);
        assertEquals(95, tent.getCurrentHp());
    }

    @Test
    void shouldGetDestroyed() {
        FirstAidTent tent=new FirstAidTent.BuilderForTesting()
                .name("FirstAidTent")
                .attack(NOT_IMPORTANT)
                .armor(NOT_IMPORTANT)
                .maxHp(5)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(5, 5))
                .build();
        Creature attacker=new Creature.BuilderForTesting()
                .name("Attacker")
                .attack(5)
                .armor(NOT_IMPORTANT)
                .maxHp(NOT_IMPORTANT)
                .moveRange(NOT_IMPORTANT)
                .damage(Range.closed(NOT_IMPORTANT, NOT_IMPORTANT))
                .build();
        attacker.getAttackStrategy().attack(attacker, tent);
        assertEquals(0, tent.getCurrentHp());
        assertEquals(0, tent.getAmount());
    }


}
