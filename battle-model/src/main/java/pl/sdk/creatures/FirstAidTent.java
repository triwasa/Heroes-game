package pl.sdk.creatures;

import com.google.common.collect.Range;
import pl.sdk.warMachines.WarMachinesStatisticIf;

import java.util.Random;


public class FirstAidTent extends Creature {


    private String name = "FirstAidTent";
    private final WarMachinesStatisticIf stats;
    private int attack = 0;
    private int armor = 0;
    private int maxHp = 75;
    private int currentHp = 75;
    private int defence = 0;
    public Range<Integer> healAmount = Range.closed(1,25);
    private final Random rand=new Random();

    public FirstAidTent(WarMachinesStatisticIf stats) {
        this.stats=stats;
    }



    public void heal(Creature aDefaultForTests){
        int healValue = rand.nextInt(healAmount.upperEndpoint());
        aDefaultForTests.applyDamage(-healValue);
    }

    @Override
    public void applyDamage(int aHealToApply) {
        int fullCurrentHp = currentHp - aHealToApply;
        if (fullCurrentHp > maxHp) {
            currentHp = maxHp;
        }
        else currentHp = fullCurrentHp;
    }












    @Override
    public int getAmount() {
        if(currentHp > 0){
            return 1;
        }
        else return 0;
    }

}
