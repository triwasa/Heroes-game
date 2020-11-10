package pl.sdk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreatureCounterAttackTest {

    private static final int NOT_IMPORTANT = 5;

    @Test
    void creatureShouldCounterAttack(){
        Creature attacker = new Creature("Attacker",NOT_IMPORTANT,NOT_IMPORTANT,100,NOT_IMPORTANT,NOT_IMPORTANT);
        Creature defender = new Creature("Defender",NOT_IMPORTANT,NOT_IMPORTANT,100, NOT_IMPORTANT,10);

        attacker.attack(defender);

        assertEquals(90,attacker.getCurrentHp());
    }

    @Test
    void creatureShouldCounterAttackOnlyOnceAtTurn(){
        Creature attacker = new Creature("Attacker",NOT_IMPORTANT,NOT_IMPORTANT,100,NOT_IMPORTANT,NOT_IMPORTANT);
        Creature attacker2 = new Creature("Attacker2",NOT_IMPORTANT,NOT_IMPORTANT,100,NOT_IMPORTANT,NOT_IMPORTANT);
        Creature defender = new Creature("Defender",NOT_IMPORTANT,NOT_IMPORTANT,100, NOT_IMPORTANT,10);

        attacker.attack(defender);
        attacker2.attack(defender);

        assertEquals(90,attacker.getCurrentHp());
        assertEquals(100,attacker2.getCurrentHp());
    }

}