package pl.sdk;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AttackCreatureTest {

    public static final int NOT_IMPORTANT = 5;

    @Test
    void creatureShouldDealExactlyDamageWhenAttackAndArmorAreEquals(){
        Creature attacker = new Creature("Attacker",10,NOT_IMPORTANT,100,NOT_IMPORTANT,20);
        Creature defender = new Creature("Defender",NOT_IMPORTANT,10,100, NOT_IMPORTANT,NOT_IMPORTANT);

        attacker.attack(defender);

        assertEquals(80,defender.getCurrentHp());
    }

    @Test
    void creatureShouldDealDamagePlus10PercentWhenAttackIsGreaterThenArmorBy2Points(){
        Creature attacker = new Creature("Attacker",10,NOT_IMPORTANT,100,NOT_IMPORTANT,20);
        Creature defender = new Creature("Defender",NOT_IMPORTANT,8,100, NOT_IMPORTANT,NOT_IMPORTANT);

        attacker.attack(defender);

        assertEquals(78,defender.getCurrentHp());
    }

    @Test
    void creatureShouldDealDamageMinus5PercentWhenArmorIsGreaterThenAttackBy2Points(){
        Creature attacker = new Creature("Attacker",10,NOT_IMPORTANT,100,NOT_IMPORTANT, Range.closed(10,20), new NewDamageCalc());
        Creature defender = new Creature("Defender",NOT_IMPORTANT,12,100, NOT_IMPORTANT,NOT_IMPORTANT);

        attacker.attack(defender);

//        assertEquals(81,defender.getCurrentHp());
        for (int i = 0; i < 1000 ; i++) {
            assertBetween(81,91,defender.getCurrentHp());
        }
    }

    private void assertBetween(int aLow, int aHigh, int aCurrentHp) {
        assertTrue(aCurrentHp >= aLow && aCurrentHp <= aHigh);
    }
}