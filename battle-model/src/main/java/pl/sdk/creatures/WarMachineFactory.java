package pl.sdk.creatures;

import static pl.sdk.creatures.CreatureStatistic.*;

public class WarMachineFactory extends AbstractFactory {
    private static final String EXCEPTION_MESSAGE="We support tiers from 1 to 3";

    @Override
    public BattleObject create(boolean aIsUpgraded, int aTier, int aAmount) {
        switch (aTier) {
            case 1:
                return new Catapult(CATAPULT);
            case 2:
                return new FirstAidTent(FIRSTAIDTENT);
            case 3:
                return new Ballista(BALLISTA);
            default:
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }
}

