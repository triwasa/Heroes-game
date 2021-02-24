package pl.sdk.creatures;

import pl.sdk.hero.Hero;

import static pl.sdk.creatures.CreatureStatistic.*;

public class WarMachineFactory{
    private static final String EXCEPTION_MESSAGE="We support tiers from 1 to 3";


    public BattleObject create(int aTier, Hero hero) {
        switch (aTier) {
            case 1:
                return new Catapult(CATAPULT);
            case 2:
                return new FirstAidTent(FIRSTAIDTENT);
            case 3:
                return new Ballista(BALLISTA, hero);
            default:
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }
}