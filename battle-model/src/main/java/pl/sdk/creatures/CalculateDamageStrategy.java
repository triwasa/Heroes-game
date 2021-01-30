package pl.sdk.creatures;

public interface CalculateDamageStrategy {

    int calculateDamage(AttackingBattleObject attacker, DefendingBattleObject aDefender);
}
