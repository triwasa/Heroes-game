package pl.sdk.creatures;

import com.google.common.collect.Range;

import java.beans.PropertyChangeEvent;

class ShootingCreatureDecorator extends Creature {

    private final Creature decorated;

    ShootingCreatureDecorator(Creature aDecorated){
        decorated = aDecorated;
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
    public boolean isAlive() {
        return decorated.isAlive();
    }

    @Override
    public int getCurrentHp() {
        return decorated.getCurrentHp();
    }

    @Override
    protected void setCurrentHpToMaximum() {
        decorated.setCurrentHpToMaximum();
    }

    @Override
    public String getName() {
        return decorated.getName();
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
    public boolean[][] getSplashRange() {
        return decorated.getSplashRange();
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
        return Double.MAX_VALUE;
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
