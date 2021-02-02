package pl.sdk.creatures;

public class WarMachineFactory extends AbstractFactory {
    private static final String EXCEPTION_MESSAGE="We support tiers from 1 to 3";

    @Override
    public Creature create(boolean aIsUpgraded, int aTier, int aAmount) {


        switch (aTier) {
            case 1:
                return new Catapult(CreatureStatistic.CATAPULT);
            case 2:
                return new FirstAidTent(CreatureStatistic.FIRSTAIDTENT);
            case 3:
                Ballista ballista = new Ballista(CreatureStatistic.BALLISTA);
                return new ShootingCreatureDecorator(ballista);
            default:
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }
}

