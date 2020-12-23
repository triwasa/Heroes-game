package pl.sdk.creatures;

import com.google.common.collect.Range;

public class FortressFactory extends AbstractFactory {

    public static final String EXCEPTION_MESSAGE = "We support tiers from 1 to 7";

    public Creature create(boolean aIsUpgraded, int aTier, int aAmount) {
        if(aIsUpgraded) {
            switch (aTier) {
                case 1:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.GNOLL_MARADEUR)
                            .amount(aAmount)
                            .build();
                case 2:
                    Creature lizardWarrior = new Creature.Builder()
                            .statistic(CreatureStatistic.LIZARD_WARRIOR)
                            .amount(aAmount)
                            .build();
                    return new BlockCounterAttackCreatureDecorator(new ShootingCreatureDecorator(lizardWarrior));
                case 3:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.DRAGON_FLY)
                            .amount(aAmount)
                            .build();
                case 4:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.GREATER_BASILISK)
                            .amount(aAmount)
                            .build();
                case 5:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.MIGHTY_GORGON)
                            .amount(aAmount)
                            .build();
                case 6:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.WYVERN_MONARCH)
                            .amount(aAmount)
                            .build();
                case 7:
                    Creature hydra = new Creature.Builder()
                            .statistic(CreatureStatistic.CHAOS_HYDRA)
                            .amount(aAmount)
                            .build();
                    return new BlockCounterAttackCreatureDecorator(new SplashDamageCreatureDecorator(hydra,getSplashForHydra()));
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        }
        else {
            switch (aTier) {
                case 1:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.GNOLL)
                            .amount(aAmount)
                            .build();
                case 2:
                    Creature lizardman = new Creature.Builder()
                            .statistic(CreatureStatistic.LIZARDMAN)
                            .amount(aAmount)
                            .build();
                    return new BlockCounterAttackCreatureDecorator(new ShootingCreatureDecorator(lizardman));
                case 3:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.SERPENT_FLY)
                            .amount(aAmount)
                            .build();
                case 4:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.BASILISK)
                            .amount(aAmount)
                            .build();
                case 5:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.GORGON)
                            .amount(aAmount)
                            .build();
                case 6:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.WYVERN)
                            .amount(aAmount)
                            .build();
                case 7:
                    Creature hydra = new Creature.Builder()
                            .statistic(CreatureStatistic.HYDRA)
                            .amount(aAmount)
                            .build();
                    return new BlockCounterAttackCreatureDecorator(new SplashDamageCreatureDecorator(hydra,getSplashForHydra()));
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        }
    }
    public boolean[][] getSplashForHydra() {
        boolean[][] splashDamageTable = new boolean[3][3];
        splashDamageTable[0][0] = true;
        splashDamageTable[0][1] = true;
        splashDamageTable[0][2] = true;
        splashDamageTable[1][0] = true;
        splashDamageTable[1][1] = true;
        splashDamageTable[1][2] = true;
        splashDamageTable[2][0] = true;
        splashDamageTable[2][1] = true;
        splashDamageTable[2][2] = true;
        return splashDamageTable;
    }
}
