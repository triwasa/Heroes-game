package pl.sdk.creatures;

import com.google.common.collect.Range;

import java.util.List;

public class InfernoFactory extends AbstractFactory {
    private static final String EXCEPTION_MESSAGE = "We support tiers from 1 to 7";

    public Creature create(boolean aIsUpgraded, int aTier, int aAmount) {
        if(aIsUpgraded) {
            switch (aTier) {
                case 1:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.FAMILIAR)
                            .amount(aAmount)
                            .build();
                case 2:
                    Creature magog = new Creature.Builder()
                            .statistic(CreatureStatistic.MAGOG)
                            .amount(aAmount)
                            .build();
                    return new BlockCounterAttackCreatureDecorator(new ShootingCreatureDecorator(new SplashDamageCreatureDecorator(magog, getSplashForMagog())));
                case 3:
                    Creature cerberus = new Creature.Builder()
                            .statistic(CreatureStatistic.CERBERUS)
                            .amount(aAmount)
                            .build();
                    return new BlockCounterAttackCreatureDecorator(new SplashDamageCreatureDecorator(cerberus, getSplashForCerberus()));
                case 4:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.HORNED_DEAMON)
                            .amount(aAmount)
                            .build();
                case 5:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.PIT_LORD)
                            .amount(aAmount)
                            .build();
                case 6:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.EFREET_SULTAN)
                            .amount(aAmount)
                            .damageCalculator(new CalculateDamageIncreaseVersusSpecifiedCreaturesStrategy(150, List.of(CreatureStatistic.GENIE.getTranslatedName(), CreatureStatistic.MASTER_GENIE.getTranslatedName())))
                            .build();
                case 7:
                    Creature archDevil = new Creature.Builder()
                            .statistic(CreatureStatistic.ARCH_DEVIL)
                            .amount(aAmount)
                            .damageCalculator(new CalculateDamageIncreaseVersusSpecifiedCreaturesStrategy(150, List.of(CreatureStatistic.ANGEL.getTranslatedName(), CreatureStatistic.ARCH_DEVIL.getTranslatedName())))
                            .build();
                    return new BlockCounterAttackCreatureDecorator(archDevil);
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        }
        else {
            switch(aTier) {
                case 1:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.IMP)
                            .amount(aAmount)
                            .build();
                case 2:
                    Creature gog = new Creature.Builder()
                            .statistic(CreatureStatistic.GOG)
                            .amount(aAmount)
                            .build();
                    return new BlockCounterAttackCreatureDecorator(new ShootingCreatureDecorator(gog));
                case 3:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.HELL_HOUND)
                            .amount(aAmount)
                            .build();
                case 4:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.DEAMON)
                            .amount(aAmount)
                            .build();
                case 5:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.PIT_FIEND)
                            .amount(aAmount)
                            .build();
                case 6:
                    return new Creature.Builder()
                            .statistic(CreatureStatistic.EFREETI)
                            .amount(aAmount)
                            .damageCalculator(new CalculateDamageIncreaseVersusSpecifiedCreaturesStrategy(150, List.of(CreatureStatistic.GENIE.getTranslatedName(), CreatureStatistic.MASTER_GENIE.getTranslatedName())))
                            .build();
                case 7:
                    Creature devil = new Creature.Builder()
                            .statistic(CreatureStatistic.DEVIL)
                            .amount(aAmount)
                            .damageCalculator(new CalculateDamageIncreaseVersusSpecifiedCreaturesStrategy(150, List.of(CreatureStatistic.ANGEL.getTranslatedName(), CreatureStatistic.ARCH_DEVIL.getTranslatedName())))
                            .build();
                    return new BlockCounterAttackCreatureDecorator(devil);
                default:
                    throw new IllegalArgumentException(EXCEPTION_MESSAGE);

            }
        }
    }
    private boolean[][] getSplashForCerberus() {
        boolean[][] splashDamageTable = new boolean[3][3];
        splashDamageTable[2][2] = true;
        splashDamageTable[1][2] = true;
        splashDamageTable[0][2] = true;
        return splashDamageTable;
    }
    private boolean[][] getSplashForMagog() {
        boolean[][] splashDamageTable = new boolean[3][3];
        splashDamageTable[0][1] = true;
        splashDamageTable[2][1] = true;
        splashDamageTable[1][1] = true;
        splashDamageTable[1][2] = true;
        splashDamageTable[1][0] = true;
        return splashDamageTable;
    }
}
