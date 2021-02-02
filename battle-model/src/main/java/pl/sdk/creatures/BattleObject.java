package pl.sdk.creatures;

public interface BattleObject extends DefendingBattleObject, AttackingBattleObject {
    DamageApplierIf getDamageApplier();
    boolean isAlive();
    boolean canAttack();
}
