package pl.sdk.creatures;

import com.google.common.collect.Range;

public class Ballista extends Creature implements BattleObject {

    private CreatureStatisticIf stats;
    private int currentHp;


    Ballista(CreatureStatisticIf aStats) {
        this.stats=aStats;
        currentHp=stats.getMaxHp();
    }


    private DefaultCalculateStrategy dealDamageCalc=new DefaultCalculateStrategy();


    public void attack(Creature aDefaultForTests) {
        int damageToDeal=dealDamageCalc.calculateDamage(this, aDefaultForTests);
        aDefaultForTests.getDamageApplier().applyDamage(damageToDeal, aDefaultForTests);
    }

    @Override
    public Range<Integer> getDamage() {
        return stats.getDamage();
    }

    @Override
    public int getAttack() {
        return stats.getAttack();
    }

    @Override
    public int getAmount() {
        if (currentHp > 0) {
            return 1;
        } else return 0;
    }


}
