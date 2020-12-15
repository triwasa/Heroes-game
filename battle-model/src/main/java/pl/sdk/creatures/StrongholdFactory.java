package pl.sdk.creatures;


public class StrongholdFactory {

    public static final String EXCEPTION_MESSAGE = "We support tiers from 1 to 7";

    public Creature create(boolean aIsUpgraded, int aTier, int aAmount){
        if(aIsUpgraded) {
            switch (aTier) {
                case 1:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.HOBGOBLIN)
                            .amount(aAmount)
                            .build();
                case 2:
                    Creature wolfRaider = new Creature.Builder()
                            .statistic(CreatureStatistic.WOLF_RAIDER)
                            .amount(aAmount)
                            .build();
                    return new MultipleAttackCreatureDecorator(wolfRaider,2);
                case 3:
                    Creature orcchieftain = new Creature.Builder()
                            .statistic(CreatureStatistic.ORC_CHIEFTAIN)
                            .amount(aAmount)
                            .build();
                    return new BlockCounterAttackCreatureDecorator(new ShootingCreatureDecorator(orcchieftain));
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
                            .build();
                    return new BlockCounterAttackCreatureDecorator(new ShootingCreatureDecorator(cyclopsKing));
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
                            .build();
                    return new BlockCounterAttackCreatureDecorator(new ShootingCreatureDecorator(orc));
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
                            .build();
                    return new BlockCounterAttackCreatureDecorator(new ShootingCreatureDecorator(cyclops));
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
