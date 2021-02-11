package pl.sdk.hero;

import pl.sdk.skills.EconomySkill;

public class SkillShop {
    public static void buy(EconomyHero aHero, EconomySkill aEconomySklill) {
        aHero.substractGold(aEconomySklill.getGoldCost());
        try{
            aHero.addSkill(aEconomySklill);
        }catch(Exception e){
            aHero.addGold(aEconomySklill.getGoldCost());
            throw new IllegalStateException("hero already has the skill");
        }
    }
}
