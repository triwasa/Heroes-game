package pl.sdk.creatures;

import com.google.common.collect.Range;
import pl.sdk.fortifications.FortificationStatisticIf;

import java.beans.PropertyChangeEvent;

public class Keep implements BattleObject, Fortification {


    private int currentHp;
    private PossibleAttackManagerIf possibleAttackManager;
    private FortificationStatisticIf stats;
    private CalculateDamageStrategy calculateDamageStrategy;
    private DamageApplierIf damageApplier;
    private AttackStrategy attackStrategy;
    private int amount;
    boolean counterAttackedThisTurn=true;


    Keep(FortificationStatisticIf aStats){
        this.stats = aStats;
        currentHp=stats.getMaxHp();
        possibleAttackManager = new PossibleAttackManagerForCreature();
        calculateDamageStrategy = new DefaultCalculateStrategy();
        damageApplier = new DefaultDamageApplier();
        attackStrategy = new DefaultAttackStrategy();
        amount = 1;

    }


    @Override
    public AttackStrategy getAttackStrategy() {
        return attackStrategy;
    }

    @Override
    public CalculateDamageStrategy getCalculateDamage() {
        return calculateDamageStrategy;
    }

    @Override
    public Range<Integer> getDamage() {
        return stats.getDamage();
    }

    @Override
    public int getAttack() {
        return 0;
    }

    @Override
    public double getAttackRange() {
        return 0;
    }

    @Override
    public boolean canFortificationAttack(Fortification fortification) {
        return possibleAttackManager.canFortificationAttack();
    }

    @Override
    public boolean canCreatureAttack() {
        return possibleAttackManager.canCreatureAttack();
    }



    @Override
    public DamageApplierIf getDamageApplier() {
        return damageApplier;
    }

    @Override
    public void applyDamage(int aDamageToApply) {
        int fullCurrentHp = currentHp - aDamageToApply;
        if (fullCurrentHp <= 0) {
            amount = 0;
            currentHp = 0;
        }
        else
        {
            currentHp = fullCurrentHp;
        }

    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public String getMovementType() {
        return null;
    }

    @Override
    public int getMoveRange() {
        return 0;
    }

    @Override
    public boolean canCounterAttack() {
        return false;
    }

    @Override
    public boolean isAlive() {
        return amount > 0;
    }

    @Override
    public int getCurrentHp() {
        return currentHp;
    }

    @Override
    public boolean[][] getSplashRange() {
        return new boolean[0][];
    }

    @Override
    public String getName() {
        return stats.getTranslatedName();
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public int getMaxHp() {
        return stats.getMaxHp();
    }



    @Override
    public int getArmor() {
        return 0;
    }



    @Override
    public boolean isCreature() {
        return false;
    }

    @Override
    public boolean isFortification() {
        return true;
    }


    @Override
    public void counterAttackedInThisTurn() {

    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

    }
}
