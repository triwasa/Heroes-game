package pl.sdk.creatures;

import com.google.common.collect.Range;

public class Wall implements BattleObject, Fortification {

    private int maxHp = 2;
    private int currentHp = 2;
    private int level = 1;
    private DamageApplierIf damageApplier;


    @Override
    public AttackStrategy getAttackStrategy() {
        return null;
    }

    @Override
    public CalculateDamageStrategy getCalculateDamage() {
        return null;
    }

    @Override
    public Range<Integer> getDamage() {
        return null;
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
    public boolean canFortifficationAttack() {
        return false;
    }

    @Override
    public boolean canCreatureAttack() {
        return false;
    }

    @Override
    public DamageApplierIf getDamageApplier() {
        return null;
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
    public boolean isAlive() {
        return false;
    }

    @Override
    public int getCurrentHp() {
        return 0;
    }

    @Override
    public boolean[][] getSplashRange() {
        return new boolean[0][];
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getAmount() {
        return 0;
    }

    @Override
    public int getMaxHp() {
        return 0;
    }

    @Override
    public void currentHpAfterAttack(int currentHp) {

    }

    @Override
    public int getArmor() {
        return 0;
    }

    @Override
    public void amountAfterAttack(int aAmount) {

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
    public void counterAttack(Attacker attacker) {

    }
}
