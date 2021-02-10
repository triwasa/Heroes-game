package pl.sdk.creatures;


import java.util.Random;

class MaxCalculateDamageStrategy extends AbstractCalculateDamageStrategy {

    MaxCalculateDamageStrategy(Random aRand) {
        super(aRand);
    }

    @Override
    public int calculateDamage(Attacker aAttacker, Defender aDefender) {

        int randValue = aAttacker.getDamage().upperEndpoint();

        double oneCreatureDamageToDeal;
        if (aAttacker.getAttack() >= aDefender.getArmor()){
            int attackPoints = aAttacker.getAttack() - aDefender.getArmor();
            if (attackPoints > 60){
                attackPoints = 60;
            }
            oneCreatureDamageToDeal = randValue * (1 + (attackPoints)*0.05);
        }else{
            int defencePoints = aDefender.getArmor() - aAttacker.getAttack();
            if (defencePoints > 12){
                defencePoints = 12;
            }
            oneCreatureDamageToDeal = randValue * (1 - defencePoints *0.025);
        }

        if (oneCreatureDamageToDeal < 0){
            oneCreatureDamageToDeal = 0;
        }
        double wholeStackDamageToDeal = aAttacker.getAmount() * oneCreatureDamageToDeal;
        double wholeStackDamageToDealAfterChange = changeDamageAfter(wholeStackDamageToDeal, aAttacker, aDefender);
        return (int)wholeStackDamageToDealAfterChange;
    }

    @Override
    double changeDamageAfter(double aWholeStackDamageToDeal, Attacker aAttacker, Defender aDefender) {
        return aWholeStackDamageToDeal;
    }


}