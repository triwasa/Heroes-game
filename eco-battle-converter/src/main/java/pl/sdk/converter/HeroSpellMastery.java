package pl.sdk.converter;

import pl.sdk.hero.EconomyHero;
import pl.sdk.skill.Skill;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class HeroSpellMastery {

    HashMap<String, Integer> heroSpellMastery = new HashMap<String, Integer>();

    HeroSpellMastery(EconomyHero economyHero) {
        List<Skill> skills = economyHero.getSkills().stream()
                .collect(Collectors.toList());

        for (Skill skill : skills) {
            if (skill.getName().equals("Air Magic")) {
                heroSpellMastery.put("Air Magic", skill.getLevel());
            }
            else if (skill.getName().equals("Water Magic")) {
                heroSpellMastery.put("Water Magic", skill.getLevel());
            }
            else if (skill.getName().equals("Fire Magic")) {
                heroSpellMastery.put("Fire Magic", skill.getLevel());
            }
            else if (skill.getName().equals("Earth Magic")) {
                heroSpellMastery.put("Earth Magic", skill.getLevel());
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
