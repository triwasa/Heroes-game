package pl.sdk;

public class NewDamageCalc extends DamageCalculator {

    @Override
    int calculateDamage(Creature aAttacker, Creature aDefender) {
        double ret;
        if (aAttacker.getAttack() >= aDefender.getArmor()){
            int attackPoints = aAttacker.getAttack() - aDefender.getArmor();
            if (attackPoints > 60){
                attackPoints = 60;
            }
            ret = aAttacker.getDamage() * (1 + (attackPoints)*0.05);
        }else{
            int defencePoints = aDefender.getArmor() - aAttacker.getAttack();
            if (defencePoints > 12){
                defencePoints = 12;
            }
            ret = aAttacker.getDamage() * (1 - defencePoints *0.025);
        }

        if (ret < 0){
            ret = 0;
        }
        return (int)ret;
    }
}
