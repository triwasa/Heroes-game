package pl.sdk.creatures;

public interface DefendingBattleObject extends BattleObjectStatistic {
    void counterAttack(AttackingBattleObject aDefender);
    int getArmor();
    boolean isAlive();
}
