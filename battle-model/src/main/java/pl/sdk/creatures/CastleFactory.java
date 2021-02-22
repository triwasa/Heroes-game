package pl.sdk.creatures;

import java.util.List;

public class CastleFactory extends AbstractFactory {

    private static final String EXCEPTION_MESSAGE = "We support tiers from 1 to 7";

    public Creature create(boolean aIsUpgraded, int aTier, int aAmount) {
        if(aIsUpgraded) {
            switch (aTier) {
                case 1:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.HALBERDIER)
                            .amount(aAmount)
                            .build();
                case 2:
                    Creature marksman = new Creature.Builder()
                            .statistic(CreatureStatistic.MARKSMAN)
                            .amount(aAmount)
                            .attackStrategy(new MulitpleAttackAttackStrategy(new BlockCounterAttackAttackStrategy(new DefaultAttackStrategy()),2))
                            .build();
                    return new ShootingCreatureDecorator(marksman);
                case 3:
                    Creature royalGriffin =  new Creature.Builder()
                            .statistic(CreatureStatistic.ROYAL_GRIFFIN)
                            .amount(aAmount)
                            .attackStrategy(new BlockCounterAttackAttackStrategy(new DefaultAttackStrategy()))
                            .build();
                    return new MultipleRetaliationsCreatureDecorator(royalGriffin,Integer.MAX_VALUE);
                case 4:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.CRUSADER)
                            .amount(aAmount)
                            .attackStrategy(new MulitpleAttackAttackStrategy(new DefaultAttackStrategy(),2))
                            .build();

                case 5:
                    Creature zealot = new Creature.Builder()
                            .statistic(CreatureStatistic.ZEALOT)
                            .amount(aAmount)
                            .attackStrategy(new BlockCounterAttackAttackStrategy(new DefaultAttackStrategy()))
                            .build();
                    return new ShootingCreatureDecorator(zealot);
                case 6:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.CHAMPION)
                            .amount(aAmount)
                            .build();
                case 7:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.ARCHANGEL)
                            .amount(aAmount)
                            .damageCalculator(new CalculateDamageIncreaseVersusSpecifiedCreaturesStrategy(150, List.of(CreatureStatistic.DEVIL.getTranslatedName(), CreatureStatistic.ARCH_DEVIL.getTranslatedName())))
                            .build();
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        }
        else {
            switch (aTier) {
                case 1:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.PIKEMAN)
                            .amount(aAmount)
                            .build();
                case 2:
                    Creature archer = new Creature.Builder()
                            .statistic(CreatureStatistic.ARCHER)
                            .amount(aAmount)
                            .attackStrategy(new BlockCounterAttackAttackStrategy(new DefaultAttackStrategy()))
                            .build();
                    return new ShootingCreatureDecorator(archer);
                case 3:
                    Creature griffin = new Creature.Builder()
                            .statistic(CreatureStatistic.GRIFFIN)
                            .amount(aAmount)
                            .build();
                    return new MultipleRetaliationsCreatureDecorator(griffin,2);
                case 4:
                   return new Creature.Builder()
                            .statistic(CreatureStatistic.SWORDSMAN)
                            .amount(aAmount)
                            .build();
                case 5:
                    Creature monk = new Creature.Builder()
                            .statistic(CreatureStatistic.MONK)
                            .amount(aAmount)
                            .attackStrategy(new BlockCounterAttackAttackStrategy(new DefaultAttackStrategy()))
                            .build();
                    return new ShootingCreatureDecorator(monk);
                case 6:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.CAVALIER)
                            .amount(aAmount)
                            .build();
                case 7:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.ANGEL)
                            .amount(aAmount)
                            .damageCalculator(new CalculateDamageIncreaseVersusSpecifiedCreaturesStrategy(150, List.of(CreatureStatistic.DEVIL.getTranslatedName(), CreatureStatistic.ARCH_DEVIL.getTranslatedName())))
                            .build();
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);

            }
        }
    }
}
