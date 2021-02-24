package pl.sdk.converter;

import pl.sdk.hero.EconomyHero;
import pl.sdk.skills.EconomySkill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HeroSpellMastery {

    HashMap<String, Integer> heroSpellMastery = new HashMap<>();

    HeroSpellMastery(EconomyHero economyHero) {
        List<EconomySkill> skills = new ArrayList<>(economyHero.getSkillList());

        for (EconomySkill skill : skills) {
            switch (skill.getName()) {
                case "Air Magic":
                    heroSpellMastery.put("Air Magic", skill.getTier());
                    break;
                case "Water Magic":
                    heroSpellMastery.put("Water Magic", skill.getTier());
                    break;
                case "Fire Magic":
                    heroSpellMastery.put("Fire Magic", skill.getTier());
                    break;
                case "Earth Magic":
                    heroSpellMastery.put("Earth Magic", skill.getTier());
                    break;
            }
        }
    }

    public Integer getAirMagic() {
        return heroSpellMastery.get("Air Magic");
    }
    public Integer getWaterMagic() {
        return heroSpellMastery.get("Water Magic");
    }
    public Integer getFireMagic() {
        return heroSpellMastery.get("Fire Magic");
    }
    public Integer getEarthMagic() {
        return heroSpellMastery.get("Earth Magic");
    }
}
