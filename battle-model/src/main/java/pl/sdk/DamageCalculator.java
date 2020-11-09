package pl.sdk;

public class DamageCalculator {

    int calculateDamage(Creature attacker, Creature aDefender) {
        int damageToDeal = attacker.getAttack() - aDefender.getArmor();
        if (damageToDeal < 0){
            damageToDeal = 0;
        }
        return damageToDeal;
    }
}
