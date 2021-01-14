package pl.sdk.skills;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SkillSet {

private Set<Skill> skillSet;

public SkillSet(){
    skillSet = new HashSet<Skill>();
}

void addSkill(Skill skill) {
    if (skill.getTier() == 1) {
        skillSet.add(skill);
    } else {
        Iterator value = skillSet.iterator();
        while (value.hasNext()) {
            Skill skillToCompare = skillSet.iterator().next();
            if (skill.getCoreName() == skillToCompare.getCoreName()) {
                if (skill.getTier() > skillToCompare.getTier()) {
                    skillSet.remove(skillToCompare);
                    skillSet.add(skill);
                    break;
                }
            }
        }
    }
}

void removeSkill(Skill skill){
    skillSet.remove(skill);
    }

public boolean contains(Skill skill){
       return skillSet.contains(skill);
    }
}