package pl.sdk.creatures;

public interface DefendingBattleObject extends BattleObjectStatistic {
    DamageApplierIf getApplyDamage();
    void counterAttack(AttackingBattleObject aDefender);
    int getArmor();
    boolean isAlive();
}
