package pl.sdk.creatures;


import com.google.common.collect.Range;

public class FirstAidTent implements CreatureDefender, BattleObject  {


    private CreatureStatisticIf stats;
    private int currentHp;


    FirstAidTent(CreatureStatisticIf aStats){
        this.stats = aStats;
        currentHp = stats.getMaxHp();
    }

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
    public boolean attackable(CreatureAttacker attacker) {
        return true;
    }

    @Override
    public boolean attackable(FortificationAttacker attacker) {
        return false;
    }

    @Override
    public void counterAttack(BattleObject aDefender) {

    }

    @Override
    public int getArmor() {
        return 0;
    }

    @Override
    public void currentHpAfterAttack(int aCurrentHp) {

    }

    @Override
    public void amountAfterAttack(int aAmount) {

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
    public int getCurrentHp() {
        return 0;
    }

    @Override
    public boolean[][] getSplashRange() {
        return new boolean[0][];
    }

    @Override
    public DamageApplierIf getDamageApplier() {
        return null;
    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public int getLevel() {
        return 0;
    }
}
