package pl.sdk.creatures;

public  class DefaultAttackStrategy implements AttackStrategy {

    public void beforeAttack(BattleObject aAttacker, BattleObject aDefender) {

    }

    public void attack(BattleObject aAttacker, BattleObject aDefender) {
        if (aAttacker.isAlive()){
            beforeAttack(aAttacker,aDefender);
            int damageToDeal = aAttacker.getCalculateDamage().calculateDamage(aAttacker,aDefender);
            aDefender.getDamageApplier().calculateDamageToApply(damageToDeal, aDefender);
            afterAttack(aAttacker,aDefender);
            counterAttack(aAttacker,aDefender);
        }
    }

   public void afterAttack(BattleObject aAttacker, BattleObject aDefender) {

   }

   public void counterAttack(BattleObject aAttacker, BattleObject aDefender) {
           if (aDefender.canCounterAttack()){
               int damageToDealInCounterAttack = aDefender.getCalculateDamage().calculateDamage(aDefender, aAttacker);
               aAttacker.getDamageApplier().calculateDamageToApply(damageToDealInCounterAttack, aAttacker);
               aDefender.counterAttackedInThisTurn();
           }
       }

}
