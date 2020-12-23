package pl.sdk.creatures;

public class NeutralFactory extends AbstractFactory {
    private static final String EXCEPTION_MESSAGE = "We support tiers from 1 to 6";

    public Creature create(boolean aIsUpgraded, int aTier, int aAmount) {

        switch (aTier) {
                case 1:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.AIR_ELEMENTAL)
                            .amount(aAmount)
                            .build();
                case 2:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.WATER_ELEMENTAL)
                            .amount(aAmount)
                            .build();
                case 3:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.FIRE_ELEMENTAL)
                            .amount(aAmount)
                            .build();
                case 4:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.EARTH_ELEMENTAL)
                            .amount(aAmount)
                            .build();
                case 5:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.GOLD_GOLEM)
                            .amount(aAmount)
                            .build();
                case 6:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.DIAMOND_GOLEM)
                            .amount(aAmount)
                            .build();
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        }

}

