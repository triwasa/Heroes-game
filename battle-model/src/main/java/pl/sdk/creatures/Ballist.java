package pl.sdk.creatures;

import com.google.common.collect.Range;

public class Ballist extends Creature {

    private String name = "Ballista";
    private int attack = 10;
    private int armor = 10;
    private int maxHp = 250;
    private int currentHp = 250;
    private int defence = 0;
    private Range<Integer> damage = Range.closed(2,3);

    private DefaultCalculateStrategy dealDamageCalc = new DefaultCalculateStrategy();


    public void attack(Creature aDefaultForTests){
        int damageToDeal = dealDamageCalc.calculateDamage(this, aDefaultForTests);
        aDefaultForTests.applyDamage(damageToDeal);
    }

    @Override
    public Range<Integer> getDamage() {
        return damage;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public int getAmount() {
        if(currentHp > 0){
            return 1;
        }
        else return 0;
    }




}
