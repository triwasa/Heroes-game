package pl.sdk.creatures;

public interface CalculateDamageStrategy {

    int calculateDamage(BattleObject attacker, CreatureDefender aDefender);
}
