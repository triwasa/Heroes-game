package pl.sdk;

import pl.sdk.creatures.EconomyCreature;
import pl.sdk.hero.CreatureShop;
import pl.sdk.hero.EconomyHero;

public class EconomyEngine {
    private final EconomyHero hero1;
    private final EconomyHero hero2;
    private final CreatureShop creatureShop = new CreatureShop();

    public EconomyEngine(EconomyHero aHero1, EconomyHero aHero2) {
        hero1 = aHero1;
        hero2 = aHero2;
    }

    public void buy(EconomyCreature aEconomyCreature) {
        creatureShop.buy(hero1,aEconomyCreature);
    }
}
