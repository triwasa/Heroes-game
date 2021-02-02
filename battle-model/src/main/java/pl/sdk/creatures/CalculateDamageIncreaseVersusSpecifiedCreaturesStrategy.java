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
    double changeDamageAfter(double aWholeStackDamageToDeal, CreatureAttacker aAttacker, CreatureDefender aDefender) {
        if(specifiedCreaturesNames.contains(aDefender.getName())) {
            aWholeStackDamageToDeal = aWholeStackDamageToDeal * increaseFactor/100;
        }
        return aWholeStackDamageToDeal;
    }
}
