package pl.sdk.creatures;

import com.google.common.collect.Range;
import pl.sdk.spells.Immunity;
import pl.sdk.spells.SpellEnum;

import java.beans.PropertyChangeEvent;

public class DecreasedArmorDefenderDecorator implements Defender {

    private final Defender decorated;
    private final int decreasedArmor;

    public DecreasedArmorDefenderDecorator(Defender aDecorated, int aDecreasedArmor){
        decorated = aDecorated;
        decreasedArmor = aDecreasedArmor;
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
    public String getMovementType() {
        return decorated.getMovementType();
    }

    @Override
    public DamageApplierIf getDamageApplier() {
        return decorated.getDamageApplier();
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
    public void applyDamage(int aDamageToApply) {
        decorated.applyDamage(aDamageToApply);
    }


    @Override
    public int getArmor() {
        return decreasedArmor;
    }


    @Override
    public int getAmount() {
        return decorated.getAmount();
    }


    @Override
    public String toString() {
        return decorated.toString();
    }

    @Override
    public int getMaxHp() {
        return decorated.getMaxHp();
    }


}
