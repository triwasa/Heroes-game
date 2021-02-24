package pl.sdk.creatures;

import com.google.common.collect.Range;
import pl.sdk.hero.Hero;

import java.beans.PropertyChangeEvent;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class BallistickDecorator implements BattleObject {

    private final BattleObject decorated;
    private final ballistickAttackStrategy attackStrategy;

    public BallistickDecorator(BattleObject aDecorated, int ballistickTier) {
        decorated = aDecorated;
        attackStrategy = new ballistickAttackStrategy(ballistickTier);

    }

    @Override
    public AttackStrategy getAttackStrategy() {
        return attackStrategy;
    }

    @Override
    public CalculateDamageStrategy getCalculateDamage() {
        return decorated.getCalculateDamage();
    }

    @Override
    public void applyDamage(int aDamageToApply) { decorated.applyDamage(aDamageToApply); }

    @Override
    public Range<Integer> getDamage() {
        return decorated.getDamage();
    }

    @Override
    public int getAttack() {
        return decorated.getAttack();
    }

    @Override
    public double getAttackRange() {
        return Double.MAX_VALUE;
    }

    @Override
    public boolean canFortificationAttack(Fortification fortification) { return decorated.canFortificationAttack(fortification); }

    @Override
    public boolean canCreatureAttack() {
        return decorated.canCreatureAttack();
    }

    @Override
    public DamageApplierIf getDamageApplier() { return decorated.getDamageApplier(); }

    @Override
    public String getMovementType() {
        return decorated.getMovementType();
    }

    @Override
    public int getMoveRange() { return decorated.getMoveRange(); }

    @Override
    public boolean canCounterAttack() {
        return decorated.canCounterAttack();
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
    public boolean[][] getSplashRange() { return decorated.getSplashRange(); }

    @Override
    public String getName() {
        return decorated.getName();
    }

    @Override
    public int getAmount() { return decorated.getAmount(); }

    @Override
    public int getMaxHp() {
        return decorated.getMaxHp();
    }

    @Override
    public int getArmor() {
        return decorated.getArmor();
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
    public void counterAttackedInThisTurn() { decorated.counterAttackedInThisTurn(); }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) { decorated.propertyChange(propertyChangeEvent);}

}
