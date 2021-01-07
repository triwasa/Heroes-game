package pl.sdk.creatures;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DamageDefenceDecreaseCalculatorTest {

    private int NOT_IMPORTANT = 5;
    private int THE_SAME_FOR_BOTH_CREATURES = 10;
    private Creature attacker;
    private Creature defender;
    private Random rand;

    @BeforeEach
    void init(){
        rand = mock(Random.class);
        when(rand.nextInt(anyInt())).thenReturn(0);
        attacker = new Creature.BuilderForTesting()
                .name("Armor Reducer")
                .maxHp(100)
                .attack(10)
                .armor(THE_SAME_FOR_BOTH_CREATURES)
                .damage(Range.closed(10, 20))
                .moveRange(NOT_IMPORTANT)
                .build();
        defender = new Creature.BuilderForTesting()
                .name("Defender")
                .maxHp(100)
                .attack(THE_SAME_FOR_BOTH_CREATURES)
                .armor(10)
                .damage(Range.closed(NOT_IMPORTANT, NOT_IMPORTANT))
                .moveRange(NOT_IMPORTANT)
                .build();

    }

    @Test
    void shouldUseSixtyPercentOfArmor() {
        CalculateDamageStrategy calc = new CalculateDamageDefenceDecreaseStrategy(40,rand);

        int result = calc.calculateDamage(attacker, defender);

        assertEquals(12, result);
    }

    @Test
    void shouldUseTwentyPercentOfArmor() {
        CalculateDamageStrategy calc = new CalculateDamageDefenceDecreaseStrategy(80,rand);

        int result = calc.calculateDamage(attacker, defender);

        assertEquals(14, result);
    }
}
