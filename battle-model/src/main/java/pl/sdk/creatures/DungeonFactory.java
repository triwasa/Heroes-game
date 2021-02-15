package pl.sdk.creatures;

import java.util.List;

public class DungeonFactory extends AbstractFactory {

    private static final String EXCEPTION_MESSAGE = "We support tiers from 1 to 7";

    public Creature create(boolean aIsUpgraded, int aTier, int aAmount) {
        if(aIsUpgraded) {
            switch (aTier) {
                case 1:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.INFERNAL_TROGLODYTE)
                            .amount(aAmount)
                            .build();
                case 2:
                    Creature harpyHag = new Creature.Builder()
                            .statistic(CreatureStatistic.HARPY_HAG)
                            .amount(aAmount)
                            .attackStrategy(new BlockCounterAttackAttackStrategy(new DefaultAttackStrategy()))
                            .build();
                    return new CreatureMoveToPreviousPositionAfterAttackDecorator(harpyHag);
                case 3:
                    Creature grandElf = new Creature.Builder()
                            .statistic(CreatureStatistic.EVIL_EYE)
                            .amount(aAmount)
                            .attackStrategy(new BlockCounterAttackAttackStrategy(new DefaultAttackStrategy()))
                            .build();
                    return new ShootingCreatureDecorator(grandElf);
                case 4:
                    Creature medusaQueen = new Creature.Builder()
                            .statistic(CreatureStatistic.MEDUSA_QUEEN)
                            .amount(aAmount)
                            .attackStrategy(new BlockCounterAttackAttackStrategy(new DefaultAttackStrategy()))
                            .build();
                    return new ShootingCreatureDecorator(medusaQueen);
                case 5:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.MINOTAUR_KING)
                            .amount(aAmount)
                            .build();
                case 6:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.SCORPICORE)
                            .amount(aAmount)
                            .build();
                case 7:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.BLACK_DRAGON)
                            .amount(aAmount)
                            .damageCalculator(new CalculateDamageIncreaseVersusSpecifiedCreaturesStrategy(150, List.of(CreatureStatistic.GIANT.getTranslatedName(), CreatureStatistic.TITAN.getTranslatedName())))
                            .build();
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        }
        else {
            switch (aTier) {
                case 1:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.TROGLODYTE)
                            .amount(aAmount)
                            .build();
                case 2:
                    return new CreatureMoveToPreviousPositionAfterAttackDecorator(new Creature.Builder()
                            .statistic(CreatureStatistic.HARPY)
                            .amount(aAmount)
                            .build());
                case 3:
                    Creature beholder = new Creature.Builder()
                            .statistic(CreatureStatistic.BEHOLDER)
                            .amount(aAmount)
                            .attackStrategy(new BlockCounterAttackAttackStrategy(new DefaultAttackStrategy()))
                            .build();
                    return new ShootingCreatureDecorator(beholder);
                case 4:
                    Creature medusa = new Creature.Builder()
                            .statistic(CreatureStatistic.MEDUSA)
                            .amount(aAmount)
                            .attackStrategy(new BlockCounterAttackAttackStrategy(new DefaultAttackStrategy()))
                            .build();
                    return new ShootingCreatureDecorator(medusa);
                case 5:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.MINOTAUR)
                            .amount(aAmount)
                            .build();
                case 6:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.MANTICORE)
                            .amount(aAmount)
                            .build();
                case 7:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.RED_DRAGON)
                            .amount(aAmount)
                            .build();
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);

            }
        }
    }
}
