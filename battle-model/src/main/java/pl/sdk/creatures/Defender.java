package pl.sdk.creatures;

public interface Defender extends BattleObjectStatistic {
    void currentHpAfterAttack(int currentHp);
    void amountAfterAttack(int aAmount);
    DamageApplierIf getDamageApplier();
    void applyDamage(int damageToApply);
    boolean isCreature();
    boolean isFortification();
    void counterAttack(BattleObject attacker);
}
