package pl.sdk.creatures;

import pl.sdk.hero.Hero;

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
    public int calculateDamage(Attacker aAttacker, Defender aDefender) {

        int decreasedDefenderArmor = (aDefender.getArmor() * decreasedArmor)/100;
        Defender copyOfDefenderWithDecreasedArmor = new DecreasedArmorDefenderDecorator(aDefender, decreasedDefenderArmor);

        int wholeStackDamageToDeal = super.calculateDamage(aAttacker,copyOfDefenderWithDecreasedArmor);

        return wholeStackDamageToDeal;
    }

    @Override
    double changeDamageAfter(double aWholeStackDamageToDeal, Attacker aAttacker, Defender aDefender) {
        return aWholeStackDamageToDeal;
    }
}
