package pl.sdk.hero;

import pl.sdk.spell.EconomySpell;


public class SpellShop {
    public void buy(EconomyHero aHero, EconomySpell aEconomySpell) {
        aHero.substractGold(aEconomySpell.getCost());
        try{
            aHero.addSpell(aEconomySpell);
        }catch(Exception e){
            aHero.addGold(aEconomySpell.getCost());
            throw new IllegalStateException("hero already has the spell");
        }
    }
}
