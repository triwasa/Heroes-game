package pl.sdk.creatures;

import com.google.common.collect.Range;
import java.beans.PropertyChangeEvent;
import java.util.Random;

public class DoubleDamagePercentChanceDecorator extends Creature {

    private final Creature decorated;
    private final int percentToDealDoubleDamage;

    public DoubleDamagePercentChanceDecorator(Creature aDecorated, int aPercent) {
        decorated = aDecorated;
        percentToDealDoubleDamage = aPercent;
    }

    @Override
    protected void setCurrentHpToMaximum() {
        decorated.setCurrentHpToMaximum();
    }

    @Override
    public void attack(Creature aDefender) {
        int bonusDamage = calculateDamage(decorated, aDefender);
        aDefender.applyDamage(bonusDamage);
        decorated.attack(aDefender);
    }

    @Override
    protected void counterAttack(Creature aDefender) {
        decorated.counterAttack(aDefender);
    }

    @Override
    void counterAttackedInThisTurn() {
        decorated.counterAttackedInThisTurn();
    }

    @Override
    public void applyDamage(int aDamageToApply) {
        decorated.applyDamage(aDamageToApply);
    }

    @Override
    int calculateDamage(Creature aAttacker, Creature aDefender) {
        Random rand = new Random();
        int roll = (rand.nextInt(100) + 1);
        System.out.println("rolld100 = " + roll);
        if (roll > percentToDealDoubleDamage){
            return 0;
        }
        else{
            return (decorated.calculateDamage(aAttacker, aDefender));
        }

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
