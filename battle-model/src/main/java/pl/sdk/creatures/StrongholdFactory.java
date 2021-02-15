package pl.sdk.creatures;


public class StrongholdFactory extends AbstractFactory {

    private static final String EXCEPTION_MESSAGE = "We support tiers from 1 to 7";

    public Creature create(boolean aIsUpgraded, int aTier, int aAmount){
        if(aIsUpgraded) {
            switch (aTier) {
                case 1:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.HOBGOBLIN)
                            .amount(aAmount)
                            .build();
                case 2:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.WOLF_RAIDER)
                            .amount(aAmount)
                            .attackStrategy(new MulitpleAttackAttackStrategy(new DefaultAttackStrategy(),2))
                            .build();

                case 3:
                    Creature orcchieftain = new Creature.Builder()
                            .statistic(CreatureStatistic.ORC_CHIEFTAIN)
                            .amount(aAmount)
                            .attackStrategy(new BlockCounterAttackAttackStrategy(new DefaultAttackStrategy()))
                            .build();
                    return new ShootingCreatureDecorator(orcchieftain);
                case 4:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.OGRE_MAGI)
                            .amount(aAmount)
                            .build();
                case 5:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.THUNDERBIRD)
                            .amount(aAmount)
                            .build();
                case 6:
                    Creature cyclopsKing = new Creature.Builder()
                            .statistic(CreatureStatistic.CYCLOPS_KING)
                            .amount(aAmount)
                            .attackStrategy(new BlockCounterAttackAttackStrategy(new DefaultAttackStrategy()))
                            .build();
                    return new CreatureCanAttackSiegeWallsDecorator(new ShootingCreatureDecorator(cyclopsKing),true);
                case 7:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.ANCIENT_BEHEMOTH)
                            .amount(aAmount)
                            .damageCalculator(new CalculateDamageDefenceDecreaseStrategy(80))
                            .build();
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        }
        else {
            switch (aTier) {
                case 1:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.GOBLIN)
                            .amount(aAmount)
                            .build();
                case 2:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.WOLF_RIDER)
                            .amount(aAmount)
                            .build();
                case 3:
                    Creature orc = new Creature.Builder()
                            .statistic(CreatureStatistic.ORC)
                            .amount(aAmount)
                            .attackStrategy(new BlockCounterAttackAttackStrategy(new DefaultAttackStrategy()))
                            .build();
                    return new ShootingCreatureDecorator(orc);
                case 4:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.OGRE)
                            .amount(aAmount)
                            .build();
                case 5:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.ROC)
                            .amount(aAmount)
                            .build();
                case 6:
                    Creature cyclops = new Creature.Builder()
                            .statistic(CreatureStatistic.CYCLOPS)
                            .amount(aAmount)
                            .attackStrategy(new BlockCounterAttackAttackStrategy(new DefaultAttackStrategy()))
                            .build();
                    return new CreatureCanAttackSiegeWallsDecorator(new ShootingCreatureDecorator(cyclops), false);
                case 7:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.BEHEMOTH)
                            .amount(aAmount)
                            .damageCalculator(new CalculateDamageDefenceDecreaseStrategy(40))
                            .build();
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        }
    }
}
