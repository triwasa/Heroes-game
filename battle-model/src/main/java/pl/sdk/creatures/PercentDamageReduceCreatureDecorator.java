package pl.sdk.creatures;

import com.google.common.collect.Range;
import pl.sdk.spells.Immunity;
import pl.sdk.spells.SpellEnum;

import java.beans.PropertyChangeEvent;

public class PercentDamageReduceCreatureDecorator extends Creature {

    private final Creature decorated;
    private final float damageResist;

    public PercentDamageReduceCreatureDecorator(Creature aDecorated, int percent) {
        decorated = aDecorated;
        damageResist = 1 - (float)percent/100;
    }
    @Override
    public boolean isCreature() {
        return decorated.isCreature();
    }

    @Override
    public boolean isFortification() {
        return decorated.isFortification();
    }

    @Override
    public int getBaseMoveRange() {
        return decorated.getBaseMoveRange();
    }

    @Override
    public int getResistance() {
        return decorated.getResistance();
    }

    @Override
    public int getBaseMaxHp() {
        return decorated.getBaseMaxHp();
    }

    @Override
    public boolean canFortificationAttack() {
        return decorated.canFortificationAttack();
    }

    @Override
    public boolean canCreatureAttack() {
        return decorated.canCreatureAttack();
    }

    @Override
    public void increaseSpeed(int aMoveRangeToIncrease) {
        decorated.increaseSpeed(aMoveRangeToIncrease);
    }

    @Override
    public void increaseHealth(int aHpToIncrease) {
        decorated.increaseHealth(aHpToIncrease);
    }

    @Override
    public void increaseResistance(int aResistanceToIncrease) {
        decorated.increaseResistance(aResistanceToIncrease);
    }

    @Override
    protected void setCurrentHpToMaximum() {
        decorated.setCurrentHpToMaximum();
    }



    @Override
    public void counterAttackedInThisTurn() {
        decorated.counterAttackedInThisTurn();
    }

    @Override
    public void applyDamage(int aDamageToApply) {
        int decreasedDamage = Math.round(aDamageToApply * damageResist);
        decorated.applyDamage(decreasedDamage);
    }


    @Override
    public boolean isAlive() {
        return decorated.isAlive();
    }

    @Override
    public boolean[][] getSplashRange() {
        return decorated.getSplashRange();
    }

    @Override
    public void addImmunity(SpellEnum s) {
        decorated.addImmunity(s);
    }

    @Override
    public Immunity getImmunity() {
        return decorated.getImmunity();
    }

    @Override
    public int getCurrentHp() {
        return decorated.getCurrentHp();
    }

    @Override
    public String getName() { return decorated.getName(); }

    @Override
    public boolean canCounterAttack() {
        return decorated.canCounterAttack();
    }

    @Override
    public int getMoveRange() {
        return decorated.getMoveRange();
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) { }

    @Override
    public int getAttack() {
        return decorated.getAttack();
    }

    @Override
    public int getArmor() {
        return decorated.getArmor();
    }

    @Override
    public Range<Integer> getDamage() {
        return decorated.getDamage();
    }

    @Override
    public int getAmount() {
        return decorated.getAmount();
    }

    @Override
    public String currentHealth() {
        return decorated.currentHealth();
    }

    @Override
    public String toString() {
        return decorated.toString();
    }

    @Override
    public double getAttackRange() {
        return decorated.getAttackRange();
    }

    @Override
    public int getMaxHp() {
        return decorated.getMaxHp();
    }
    @Override
    public boolean backToPreviousPositionMechanic() {
        return decorated.backToPreviousPositionMechanic();
    }
}
