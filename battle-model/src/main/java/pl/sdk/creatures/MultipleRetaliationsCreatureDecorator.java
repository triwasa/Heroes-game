package pl.sdk.creatures;

import com.google.common.collect.Range;

import java.beans.PropertyChangeEvent;

public class MultipleRetaliationsCreatureDecorator extends Creature {

    private final Creature decorated;
    private final int maxRetaliationsAmount;
    private int currentRetaliationsAmount;

    public MultipleRetaliationsCreatureDecorator(Creature aDecorated, int aRetaliationsAmount){
        decorated = aDecorated;
        maxRetaliationsAmount = aRetaliationsAmount;
        currentRetaliationsAmount = maxRetaliationsAmount;
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
    public int getLevel() {
        return super.getLevel();
    }

    @Override
    protected void counterAttackedInThisTurn() {
        currentRetaliationsAmount = currentRetaliationsAmount - 1;
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
        return currentRetaliationsAmount > 0;
    }

    @Override
    public int getMoveRange() {
        return decorated.getMoveRange();
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        currentRetaliationsAmount = maxRetaliationsAmount;
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
        return decorated.backToPreviousPositionMechanic();
    }
}

