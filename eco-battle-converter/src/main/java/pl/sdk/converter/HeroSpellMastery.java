package pl.sdk.converter;

import pl.sdk.hero.EconomyHero;
import pl.sdk.skills.EconomySkill;
import pl.sdk.skills.Skill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HeroSpellMastery {

    HashMap<String, Integer> heroSpellMastery = new HashMap<>();

    HeroSpellMastery(EconomyHero economyHero) {
        List<EconomySkill> skills = new ArrayList<>(economyHero.getSkills());

        for (EconomySkill skill : skills) {
            switch (skill.getName()) {
                case "Air Magic":
                    heroSpellMastery.put("Air Magic", skill.getLevel());
                    break;
                case "Water Magic":
                    heroSpellMastery.put("Water Magic", skill.getLevel());
                    break;
                case "Fire Magic":
                    heroSpellMastery.put("Fire Magic", skill.getLevel());
                    break;
                case "Earth Magic":
                    heroSpellMastery.put("Earth Magic", skill.getLevel());
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
