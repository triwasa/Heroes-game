package pl.sdk.creatures;

import com.google.common.collect.Range;

import java.util.List;

public class TowerFactory extends AbstractFactory {

    private static final String EXCEPTION_MESSAGE = "We support tiers from 1 to 7";

    public Creature create(boolean aIsUpgraded, int aTier, int aAmount) {
        if(aIsUpgraded) {
            switch (aTier) {
                case 1:
                    Creature masterGremlin = new Creature.Builder()
                            .statistic(CreatureStatistic.MASTER_GREMLIN)
                            .amount(aAmount)
                            .build();
                    return new BlockCounterAttackCreatureDecorator(new ShootingCreatureDecorator(masterGremlin));
                case 2:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.OBSIDIAN_GARGOYLE)
                            .amount(aAmount)
                            .build();
                case 3:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.IRON_GOLEM)
                            .amount(aAmount)
                            .build();
                case 4:
                    Creature archMage = new Creature.Builder()
                            .statistic(CreatureStatistic.ARCH_MAGE)
                            .amount(aAmount)
                            .build();
                    return new BlockCounterAttackCreatureDecorator(new ShootingCreatureDecorator(archMage));
                case 5:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.MASTER_GENIE)
                            .amount(aAmount)
                            .damageCalculator(new CalculateDamageIncreaseVersusSpecifiedCreaturesStrategy(150, List.of(CreatureStatistic.EFREET_SULTAN.getTranslatedName(), CreatureStatistic.EFREETI.getTranslatedName())))
                            .build();
                case 6:
                    return new BlockCounterAttackCreatureDecorator.Builder()
                            .statistic(CreatureStatistic.NAGA_QUEEN)
                            .amount(aAmount)
                            .build();
                case 7:
                    Creature titan = new Creature.Builder()
                            .statistic(CreatureStatistic.TITAN)
                            .amount(aAmount)
                            .damageCalculator(new CalculateDamageIncreaseVersusSpecifiedCreaturesStrategy(150, List.of(CreatureStatistic.BLACK_DRAGON.getTranslatedName())))
                            .build();
                    return new BlockCounterAttackCreatureDecorator(new ShootingCreatureDecorator(titan));
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }

        }
        else {
            switch (aTier) {
                case 1:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.GREMLIN)
                            .amount(aAmount)
                            .build();
                case 2:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.STONE_GARGOYLE)
                            .amount(aAmount)
                            .build();
                case 3:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.STONE_GOLEM)
                            .amount(aAmount)
                            .build();
                case 4:
                    Creature mage = new Creature.Builder()
                            .statistic(CreatureStatistic.MAGE)
                            .amount(aAmount)
                            .build();
                    return new BlockCounterAttackCreatureDecorator(new ShootingCreatureDecorator(mage));
                case 5:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.GENIE)
                            .amount(aAmount)
                            .damageCalculator(new CalculateDamageIncreaseVersusSpecifiedCreaturesStrategy(150, List.of(CreatureStatistic.EFREET_SULTAN.getTranslatedName(), CreatureStatistic.EFREETI.getTranslatedName())))
                            .build();
                case 6:
                    return new BlockCounterAttackCreatureDecorator.Builder()
                            .statistic(CreatureStatistic.NAGA)
                            .amount(aAmount)
                            .build();
                case 7:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.GIANT)
                            .amount(aAmount)
                            .build();
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);

            }
        }
    }
}
