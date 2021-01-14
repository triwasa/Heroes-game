package pl.sdk.creatures;

import com.google.common.collect.Range;


public class FirstAidTent extends Creature {


    private String name = "FirstAidTent";
    private int attack = 0;
    private int armor = 0;
    private int maxHp = 75;
    private int currentHp = 75;
    private int defence = 0;
    public Range<Integer> healAmount = Range.closed(1,25);




    public void attack(Creature aDefaultForTests){
        int damageToDeal = 0;
        aDefaultForTests.applyDamage(damageToDeal);
    }

////    public void heal(Creature creature){
////        creature.getCurrentHp() = creature.getCurrentHp()+healAmount;
////        if (creature.getCurrentHp() > creature.getMaxHp()){
////
////        }
//
//
//
//    }





    @Override
    public int getAmount() {
        if(currentHp > 0){
            return 1;
        }
        else return 0;
    }
}
