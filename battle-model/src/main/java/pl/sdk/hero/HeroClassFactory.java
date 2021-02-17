package pl.sdk.hero;

import static pl.sdk.hero.HeroClassName.*;

public class HeroClassFactory {

    private static final String EXCEPTION_MESSAGE = "There is no hero with that name";

    public Hero create(String aName){
        switch (aName) {
            case KNIGHT:
                return new Hero(HeroClassStatistic.KNIGHT);
            case CLERIC:
                return new Hero(HeroClassStatistic.CLERIC);
            case RANGER:
                return new Hero(HeroClassStatistic.RANGER);
            case DRUID:
                return new Hero(HeroClassStatistic.DRUID);
            case ALCHEMIST:
                return new Hero(HeroClassStatistic.ALCHEMIST);
            case WIZARD:
                return new Hero(HeroClassStatistic.WIZARD);
            case DEMONIAC:
                return new Hero(HeroClassStatistic.DEMONIAC);
            case HERETIC:
                return new Hero(HeroClassStatistic.HERETIC);
            case DEATH_KNIGHT:
                return new Hero(HeroClassStatistic.DEATH_KNIGHT);
            case NECROMANCER:
                return new Hero(HeroClassStatistic.NECROMANCER);
            case OVERLORD:
                return new Hero(HeroClassStatistic.OVERLORD);
            case WARLOCK:
                return new Hero(HeroClassStatistic.WARLOCK);
            case BARBARIAN:
                return new Hero(HeroClassStatistic.BARBARIAN);
            case BATTLE_MAGE:
                return new Hero(HeroClassStatistic.BATTLE_MAGE);
            case BEASTMASTER:
                return new Hero(HeroClassStatistic.BEASTMASTER);
            case WITCH:
                return new Hero(HeroClassStatistic.WITCH);
            case PLANESWALKER:
                return new Hero(HeroClassStatistic.PLANESWALKER);
            case ELEMENTALIST:
                return new Hero(HeroClassStatistic.ELEMENTALIST);
            case CAPTAIN:
                return new Hero(HeroClassStatistic.CAPTAIN);
            case NAVIGATOR:
                return new Hero(HeroClassStatistic.NAVIGATOR);
            default:
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }

    }
}
