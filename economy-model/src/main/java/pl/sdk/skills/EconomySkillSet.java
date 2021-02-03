package pl.sdk.skills;

import java.util.*;

public class EconomySkillSet {

    private HashSet<EconomySkill> skillSet;

    public EconomySkillSet(){
        skillSet = new HashSet<EconomySkill>();
    }

    void addSkill(EconomySkill skill) {
        if (skill.getStats().getTier() == 1) {
            skillSet.add(skill);
        } else {
            Iterator<EconomySkill> value = skillSet.iterator();
            while (value.hasNext()) {
                EconomySkill skillToCompare = value.next();
                if (skill.getStats().getCoreName() == skillToCompare.getStats().getCoreName()) {
                    if (skill.getStats().getTier() > skillToCompare.getStats().getTier()) {
                        skillSet.remove(skillToCompare);
                        skillSet.add(skill);
                        break;
                    }
                }
            }
        }
    }

    void removeSkill(EconomySkill skill){
        skillSet.remove(skill);
    }

    public boolean contains(EconomySkill skill){
        return skillSet.contains(skill);
    }


}