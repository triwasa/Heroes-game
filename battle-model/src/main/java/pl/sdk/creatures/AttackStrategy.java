package pl.sdk.creatures;

import pl.sdk.hero.Hero;

public interface AttackStrategy {
    void attack(BattleObject aAttacker, BattleObject aDefender);
    void beforeAttack(BattleObject aAttacker, BattleObject aDefender);
    void afterAttack(BattleObject aAttacker, BattleObject aDefender);
}

