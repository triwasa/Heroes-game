/*
package pl.sdk.creatures;

import com.google.common.collect.Range;

import java.util.Random;

public class Keep extends Creature implements Fortification {


    private String name = "Keep";
    private int maxHp = 2;
    private int currentHp = 2;
    private int attack = 1;
    private int level = 1;
    public Range<Integer> damage = Range.closed(15,15);
    private DefaultCalculateStrategy dealDamageCalc = new DefaultCalculateStrategy();


    @Override
    public int getLevel() {
        return level;
    }

    @Override
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

    @Override
    public void counterAttack(Attacker aDefender) {
        return;
    }
}
*/
