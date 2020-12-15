package pl.sdk.creatures;

import java.util.List;
import java.util.Random;

public class CalculateDamageIncreaseVersusSpecifiedCreaturesStrategy extends AbstractCalculateDamageStrategy {
    private final int increaseFactor;
    private final List<String> specifiedCreaturesNames;

    CalculateDamageIncreaseVersusSpecifiedCreaturesStrategy(int aIncreaseFactor, List aSpecifiedCreatures) {
        this(aIncreaseFactor, aSpecifiedCreatures,new Random());
    }

    CalculateDamageIncreaseVersusSpecifiedCreaturesStrategy(int aIncreaseFactor, List aSpecifiedCreatures,Random rand) {
        super(rand);
        increaseFactor = aIncreaseFactor;
        specifiedCreaturesNames = aSpecifiedCreatures;
    }
    @Override
    public int calculateDamage(Creature aAttacker, Creature aDefender) {

        int randValue = getRand().nextInt(aAttacker.getDamage().upperEndpoint() - aAttacker.getDamage().lowerEndpoint() + 1) + aAttacker.getDamage().lowerEndpoint();

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
        double wholeStackDamageToDealAfterChange = changeDamageAfter(wholeStackDamageToDeal, aAttacker);

        if(specifiedCreaturesNames.contains(aDefender.getName())) {
            wholeStackDamageToDealAfterChange = wholeStackDamageToDealAfterChange * increaseFactor/100;
        }

        return (int)wholeStackDamageToDealAfterChange;
    }

    @Override
    double changeDamageAfter(double aWholeStackDamageToDeal, Creature aAttacker) {
        return aWholeStackDamageToDeal;
    }
}
