package pl.sdk.creatures;

import java.util.Random;

public class CalculateDamageDefenceDecreaseStrategy extends AbstractCalculateDamageStrategy {
    public final int decreasedArmor;

    CalculateDamageDefenceDecreaseStrategy(int aDecreasedArmor) {
        this(aDecreasedArmor, new Random());

    }
    CalculateDamageDefenceDecreaseStrategy(int aDecreaseFactor, Random aRand) {
        super(aRand);
        decreasedArmor = 100 - aDecreaseFactor;
    }
    @Override
    public int calculateDamage(Creature aAttacker, Creature aDefender) {

        int decreasedDefenderArmor = (aDefender.getArmor() * decreasedArmor)/100;
        Creature copyOfDefender = new Creature.Builder().copyOfCreatureWithDifferentArmorValue(aDefender,decreasedDefenderArmor);

        int wholeStackDamageToDeal = super.calculateDamage(aAttacker,copyOfDefender);

        return wholeStackDamageToDeal;
    }

    @Override
    double changeDamageAfter(double aWholeStackDamageToDeal, Creature aAttacker, Creature aDefender) {
        return aWholeStackDamageToDeal;
    }
}
