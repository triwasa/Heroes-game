package pl.sdk.creatures;

public interface CreatureDefender extends BattleObjectStatistic {
    void counterAttack(BattleObject aDefender);
    int getArmor();
    void currentHpAfterAttack(int aCurrentHp);
    void amountAfterAttack(int aAmount);

}
