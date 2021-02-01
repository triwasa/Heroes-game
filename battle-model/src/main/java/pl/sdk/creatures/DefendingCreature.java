package pl.sdk.creatures;

public interface DefendingCreature extends BattleObjectStatistic {
    void counterAttack(BattleObject aDefender);
    int getArmor();
    void currentHpAfterAttack(int aCurrentHp);
    void amountAfterAttack(int aAmount);

}
