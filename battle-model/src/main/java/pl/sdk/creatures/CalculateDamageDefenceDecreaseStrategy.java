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
    public int calculateDamage(AttackingBattleObject aAttacker, DefendingBattleObject aDefender) {

        int decreasedDefenderArmor = (aDefender.getArmor() * decreasedArmor)/100;
        Creature copyOfDefenderWithDecreasedArmor = new DecreasedArmorCreatureDecorator((Creature)aDefender, decreasedDefenderArmor);

        int wholeStackDamageToDeal = super.calculateDamage(aAttacker,copyOfDefenderWithDecreasedArmor);

        return wholeStackDamageToDeal;
    }

    @Override
    double changeDamageAfter(double aWholeStackDamageToDeal, AttackingBattleObject aAttacker, DefendingBattleObject aDefender) {
        return aWholeStackDamageToDeal;
    }
}
