package pl.sdk.creatures;

import com.google.common.collect.Range;

import java.util.Random;


public class FirstAidTent extends Creature implements BattleObject {


    private CreatureStatisticIf stats;
    private int currentHp;


    FirstAidTent(CreatureStatisticIf aStats) {
        this.stats=aStats;
        currentHp=stats.getMaxHp();
    }

    private final Random rand=new Random();


    @Override
    public Range<Integer> getDamage() {
        return stats.getDamage();
    }

//    @Override
//    public void attack(Creature aDefender) {
//        int healValue=rand.nextInt(stats.getDamage().upperEndpoint() - stats.getDamage().lowerEndpoint() + 1) + stats.getDamage().lowerEndpoint();
//        aDefender.applyHeal(-healValue);
//    }
//
//    @Override
//    public void applyHeal(int aHealToApply) {
//        int fullCurrentHp=currentHp - aHealToApply;
//        if (fullCurrentHp > stats.getMaxHp()) {
//            currentHp=stats.getMaxHp();
//        } else currentHp=fullCurrentHp;
//    }


    @Override
    public int getAmount() {
        if (currentHp > 0) {
            return 1;
        } else return 0;
    }

}
