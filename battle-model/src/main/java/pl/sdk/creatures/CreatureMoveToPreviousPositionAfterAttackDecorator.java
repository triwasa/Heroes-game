package pl.sdk.creatures;

import com.google.common.collect.Range;
import pl.sdk.spells.Immunity;
import pl.sdk.spells.SpellEnum;

import java.beans.PropertyChangeEvent;

public class CreatureMoveToPreviousPositionAfterAttackDecorator extends Creature {

    private final Creature decorated;


    public CreatureMoveToPreviousPositionAfterAttackDecorator(Creature aDecorated) {
        decorated = aDecorated;
    }

    @Override
    void setCurrentHpToMaximum() {
        decorated.setCurrentHpToMaximum();
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
    public void addImmunity(SpellEnum s) {
        decorated.addImmunity(s);
    }

    @Override
    public Immunity getImmunity() {
        return decorated.getImmunity();
    }

    @Override
    public void counterAttackedInThisTurn() {
        decorated.counterAttackedInThisTurn();
    }

    @Override
    public String getMovementType() {
        return decorated.getMovementType();
    }

    @Override
    public DamageApplierIf getDamageApplier() {
        return decorated.getDamageApplier();
    }

    @Override
    public AttackStrategy getAttackStrategy() {
        return decorated.getAttackStrategy();
    }

    @Override
    public CalculateDamageStrategy getCalculateDamage() {
        return decorated.getCalculateDamage();
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
    public int getCurrentHp() {
        return decorated.getCurrentHp();
    }

    @Override
    public String getName() {
        return decorated.getName();
    }

    @Override
    public boolean canCounterAttack() {
        return decorated.canCounterAttack();
    }

    @Override
    public int getMoveRange() {
        return decorated.getMoveRange();
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        decorated.propertyChange(aPropertyChangeEvent);
    }

    @Override
    public void applyDamage(int aDamageToApply) {
        decorated.applyDamage(aDamageToApply);
    }

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
        return true;
    }
}
