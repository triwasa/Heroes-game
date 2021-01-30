package pl.sdk.creatures;

public interface AttackStrategy {
    void attack(AttackingBattleObject aAttacker, DefendingBattleObject aDefender);
}
