package pl.sdk.creatures;

public class EconomyNeutralFactory extends EconomyAbstractFactory {
    private static final String EXCEPTION_MESSAGE = "We support tiers from 1 to 6 in netural";

    public EconomyCreature create(boolean aIsUpgraded, int aTier, int aAmount) {

            switch (aTier) {
                case 1:
                    return new EconomyCreature(CreatureStatistic.AIR_ELEMENTAL, aAmount, 250);
                case 2:
                    return new EconomyCreature(CreatureStatistic.WATER_ELEMENTAL, aAmount, 300);
                case 3:
                    return new EconomyCreature(CreatureStatistic.FIRE_ELEMENTAL, aAmount, 350);
                case 4:
                    return new EconomyCreature(CreatureStatistic.EARTH_ELEMENTAL, aAmount, 400);
                case 5:
                    return new EconomyCreature(CreatureStatistic.GOLD_GOLEM, aAmount, 500);
                case 6:
                    return new EconomyCreature(CreatureStatistic.DIAMOND_GOLEM, aAmount, 750);
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }
}
