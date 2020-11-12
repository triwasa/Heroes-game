package pl.sdk;

import com.google.common.collect.Range;

import java.beans.PropertyChangeEvent;

public class ShootingCreatureDecorator extends Creature {

    private final Creature decorated;

    ShootingCreatureDecorator(Creature aDecorated){
        decorated = aDecorated;
    }

    @Override
    void attack(Creature aDefender) {
        decorated.attack(aDefender);
    }

    @Override
    protected int calculateDamage(Creature aAttacker, Creature aDefender) {
        return decorated.calculateDamage(aAttacker, aDefender);
    }

    @Override
    protected void counterAttack(Creature aDefender) {
        decorated.counterAttack(aDefender);
    }

    @Override
    void performAfterAttack(int aDamageToDeal) {
        decorated.performAfterAttack(aDamageToDeal);
    }

    @Override
    void applyDamage(int aDamageToApply) {
        decorated.applyDamage(aDamageToApply);
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
    public String getName() {
        return decorated.getName();
    }

    @Override
    boolean canCounterAttack() {
        return decorated.canCounterAttack();
    }

    @Override
    int getMoveRange() {
        return decorated.getMoveRange();
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        decorated.propertyChange(aPropertyChangeEvent);
    }

    @Override
    int getAttack() {
        return decorated.getAttack();
    }

    @Override
    int getArmor() {
        return decorated.getArmor();
    }

    @Override
    Range<Integer> getDamage() {
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
    double getAttackRange() {
        return Double.MAX_VALUE;
    }
}
