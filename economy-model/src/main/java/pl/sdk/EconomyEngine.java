package pl.sdk;

import pl.sdk.creatures.EconomyCreature;
import pl.sdk.hero.CreatureShop;
import pl.sdk.hero.EconomyHero;

import java.beans.PropertyChangeSupport;

public class EconomyEngine {
    public static final String HERO_BOUGHT_CREATURE = "HERO_BOUGHT_CREATURE";
    public static final String ACTIVE_HERO_CHANGED = "ACTIVE_HERO_CHANGED";
    public static final String NEXT_ROUND = "NEXT_ROUND";
    private final EconomyHero hero1;
    private final EconomyHero hero2;
    private EconomyHero activeHero;
    private final CreatureShop creatureShop = new CreatureShop();
    private int roundNumber;
    private final PropertyChangeSupport observerSupport;

    public EconomyEngine(EconomyHero aHero1, EconomyHero aHero2) {
        hero1 = aHero1;
        hero2 = aHero2;
        activeHero = hero1;
        roundNumber = 1;
        observerSupport = new PropertyChangeSupport(this);
    }

    public void buy(EconomyCreature aEconomyCreature) {
        creatureShop.buy(activeHero,aEconomyCreature);
        observerSupport.firePropertyChange(HERO_BOUGHT_CREATURE, null, null);
    }

    EconomyHero getActiveHero() {
        return activeHero;
    }

    void pass() {
        if (activeHero == hero1){
            activeHero = hero2;
            observerSupport.firePropertyChange(ACTIVE_HERO_CHANGED, hero1, activeHero);
        }
        else{
            activeHero = hero1;
            observerSupport.firePropertyChange(ACTIVE_HERO_CHANGED, hero2, activeHero);
            roundNumber += 1;
            observerSupport.firePropertyChange(NEXT_ROUND, roundNumber - 1, roundNumber);
        }
    }

    int getRoundNumber() {
        return roundNumber;
    }
}
