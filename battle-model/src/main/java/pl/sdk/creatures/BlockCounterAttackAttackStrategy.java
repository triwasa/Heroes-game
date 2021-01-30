package pl.sdk.creatures;

import pl.sdk.creatures.AttackStrategy;
import pl.sdk.creatures.AttackingBattleObject;
import pl.sdk.creatures.DefendingBattleObject;

public class BlockCounterAttackAttackStrategy implements AttackStrategy {
    @Override
    public void attack(AttackingBattleObject aAttacker, DefendingBattleObject aDefender) {
            if (aAttacker.isAlive()){
                int damageToDeal = aAttacker.getCalculateDamage().calculateDamage(aAttacker,aDefender);
                aDefender.getApplyDamage().applyDamage(damageToDeal, aDefender);
            }
    }

}
