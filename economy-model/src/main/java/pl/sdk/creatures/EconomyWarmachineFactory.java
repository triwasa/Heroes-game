package pl.sdk.creatures;

public class EconomyWarmachineFactory extends EconomyAbstractFactory {
    private static final String EXCEPTION_MESSAGE="We support tiers from 1 to 3";

    public EconomyCreature create(boolean isUpgraded, int aTier, int aAmount) {

        switch (aTier) {
            case 1:
                return new EconomyCreature(CreatureStatistic.CATAPULT, 1, 0);
            case 2:
                return new EconomyCreature(CreatureStatistic.FIRSTAIDTENT, 1, 750);
            case 3:
                return new EconomyCreature(CreatureStatistic.BALLISTA, 1, 2500);

            default:
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }

    }

}

