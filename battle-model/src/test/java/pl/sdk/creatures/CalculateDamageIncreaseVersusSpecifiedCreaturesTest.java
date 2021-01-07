package pl.sdk.creatures;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculateDamageIncreaseVersusSpecifiedCreaturesTest {

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
                .name("Attacker")
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
    void checkIfAttackerDoMoreDamageToDefenderInList() {
        CalculateDamageStrategy calc = new CalculateDamageIncreaseVersusSpecifiedCreaturesStrategy(150, List.of(defender.getName()), rand);

        int result = calc.calculateDamage(attacker,defender);
        assertEquals(15, result);
    }
    @Test
    void checkIfAttackerDoNotDealMoreDamageToDefenderNotInList() {
        CalculateDamageStrategy calc = new CalculateDamageIncreaseVersusSpecifiedCreaturesStrategy(150, List.of(new Creature().getName()), rand);

        int result = calc.calculateDamage(attacker,defender);
        assertEquals(10, result);
    }

    @Test
    void attackerHasTwoHundredPercentFactorVersusDefender() {
        CalculateDamageStrategy calc = new CalculateDamageIncreaseVersusSpecifiedCreaturesStrategy(200, List.of(defender.getName()), rand);

        int result = calc.calculateDamage(attacker,defender);
        assertEquals(20,result);
    }
}
