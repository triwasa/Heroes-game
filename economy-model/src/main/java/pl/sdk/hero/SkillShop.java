package pl.sdk.hero;

import pl.sdk.skills.EconomySklill;

public class SkillShop {
    public void buy(EconomyHero aHero, EconomySklill aEconomySklill) {
        aHero.substractGold(aEconomySklill.getGoldCost());
        try{
            aHero.addSkill(aEconomySklill);
        }catch(Exception e){
            aHero.addGold(aEconomySklill.getGoldCost());
            throw new IllegalStateException("hero already has the item");
        }
    }
}
