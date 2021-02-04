package pl.sdk.creatures;

import com.google.common.collect.Range;

import java.beans.PropertyChangeEvent;

public class DecreasedArmorCreatureDecorator extends Creature {

    private final Creature decorated;
    private final int decreasedArmor;

    public DecreasedArmorCreatureDecorator(Creature aDecorated, int aDecreasedArmor){
        decorated = aDecorated;
        decreasedArmor = aDecreasedArmor;
    }

    @Override
    protected void setCurrentHpToMaximum() {
        decorated.setCurrentHpToMaximum();
    }

    @Override
    public void counterAttack(BattleObject aAttacker) {
        decorated.counterAttack(aAttacker);
    }

    @Override
    void counterAttackedInThisTurn() {
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
    public void currentHpAfterAttack(int aCurrentHp) {
        decorated.currentHpAfterAttack(aCurrentHp);
    }

    @Override
    public void amountAfterAttack(int aAmount) {
        decorated.amountAfterAttack(aAmount);
    }

    @Override
    public int getAttack() {
        return decorated.getAttack();
    }

    @Override
    public int getArmor() {
        return decreasedArmor;
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
