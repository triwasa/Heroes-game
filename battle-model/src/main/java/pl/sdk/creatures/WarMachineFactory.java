package pl.sdk.creatures;

public class WarMachineFactory extends AbstractFactory {
    private static final String EXCEPTION_MESSAGE="We support tiers from 1 to 3";

    @Override
    public Creature create(boolean aIsUpgraded, int aTier, int aAmount) {


        switch (aTier) {
            case 1:
                Catapult catapult = new Catapult.Builder()
                        .statistic(CreatureStatistic.CATAPULT)
                        .amount(1)
                        .attackStrategy(new BlockCounterAttackAttackStrategy(new DefaultAttackStrategy()))
                        .build();
//                return new ShootingCreatureDecorator(catapult);
               // return null;
            case 2:
                //return new FirstAidTent(CreatureStatistic.FIRSTAIDTENT);
            case 3:
                Ballista ballista = new Ballista.Builder()
                        .statistic(CreatureStatistic.BALLISTA)
                        .amount(1)
                        .attackStrategy(new BlockCounterAttackAttackStrategy(new DefaultAttackStrategy()))
                        .build();
                    return new ShootingCreatureDecorator(ballista);
             //   return null;
            default:
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }
}

