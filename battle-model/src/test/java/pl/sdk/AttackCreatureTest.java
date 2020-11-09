package pl.sdk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        Creature attacker = new Creature("Attacker",10,NOT_IMPORTANT,100,NOT_IMPORTANT,20);
        Creature defender = new Creature("Defender",NOT_IMPORTANT,12,100, NOT_IMPORTANT,NOT_IMPORTANT);

        attacker.attack(defender);

        assertEquals(81,defender.getCurrentHp());
    }
}