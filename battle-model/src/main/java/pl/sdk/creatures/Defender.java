package pl.sdk.creatures;

public interface Defender extends BattleObjectStatistic {
    DamageApplierIf getDamageApplier();
    void currentHpAfterAttack(int currentHp);
    void amountAfterAttack(int aAmount);
    boolean isCreature();
    boolean isFortification();
    void counterAttack(Attacker attacker);
}
