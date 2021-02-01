package pl.sdk.creatures;

public interface CalculateDamageStrategy {

    int calculateDamage(BattleObject attacker, DefendingCreature aDefender);
}
