package pl.sdk.creatures;

import com.google.common.collect.Range;
import pl.sdk.warMachines.WarMachinesStatisticIf;

import java.util.Random;

public class Catapult extends Creature {

    private String name = "Catapult";
    private int attack = 10;
    private int armor = 10;
    private int maxHp = 1000;
    private int currentHp = 1000;
    public Range<Integer> damage = Range.closed(1,2);
    private final Random rand=new Random();




    public void attack(Fortification aDefender) {

        int damageToDeal = calculateDamage(this);
        aDefender.applyDamage(damageToDeal);

    }


    int calculateDamage(Catapult aAttacker) {
        return rand.nextInt(aAttacker.getDamage().upperEndpoint() - aAttacker.getDamage().lowerEndpoint()+1) + aAttacker.getDamage().lowerEndpoint()-1;
    }




}
