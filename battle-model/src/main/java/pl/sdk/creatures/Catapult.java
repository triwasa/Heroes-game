
package pl.sdk.creatures;

import com.google.common.collect.Range;

import java.util.Random;

public class Catapult extends Creature implements BattleObject {

    private CreatureStatisticIf stats;
    private int currentHp;


    Catapult(CreatureStatisticIf aStats) {
        this.stats=aStats;
        currentHp=stats.getMaxHp();
    }

    private final Random rand=new Random();


    public void attack(Fortification aDefender) {

        int damageToDeal=calculateDamage(this);
        aDefender.applyDamage(damageToDeal);

    }


    int calculateDamage(Catapult aAttacker) {
        return rand.nextInt(aAttacker.getDamage().upperEndpoint() - aAttacker.getDamage().lowerEndpoint() + 1) + aAttacker.getDamage().lowerEndpoint() - 1;
    }


}

