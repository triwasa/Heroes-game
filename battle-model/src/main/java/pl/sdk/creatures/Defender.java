package pl.sdk.creatures;

public interface Defender extends BattleObjectStatistic {

    DamageApplierIf getDamageApplier();
    void applyDamage(int damageToApply);
    boolean isCreature();
    boolean isFortification();
}
