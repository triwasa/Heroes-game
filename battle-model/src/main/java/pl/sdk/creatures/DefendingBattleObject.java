package pl.sdk.creatures;

public interface DefendingBattleObject extends BattleObjectStatistic {
    void counterAttack(BattleObject aDefender);
    int getArmor();
}
