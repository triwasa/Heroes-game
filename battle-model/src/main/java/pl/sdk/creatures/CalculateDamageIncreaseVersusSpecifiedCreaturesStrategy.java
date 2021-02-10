package pl.sdk.creatures;

import pl.sdk.hero.Hero;

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
    double changeDamageAfter(double aWholeStackDamageToDeal, Attacker aAttacker, Defender aDefender) {
        if(specifiedCreaturesNames.contains(aDefender.getName())) {
            aWholeStackDamageToDeal = aWholeStackDamageToDeal * increaseFactor/100;
        }
        return aWholeStackDamageToDeal;
    }

    @Override
    public int calculateDamage(Attacker attacker, Defender aDefender, Hero hero) {
        return 0;
    }
}
