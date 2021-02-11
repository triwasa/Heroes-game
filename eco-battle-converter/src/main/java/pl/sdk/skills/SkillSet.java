package pl.sdk.skills;

import pl.sdk.hero.Hero;

import java.util.*;

public class SkillSet {

private HashSet<Skill> skillSet;

public SkillSet(){
    skillSet = new HashSet<Skill>();
}

void addSkill(Skill skill) {
    if (skill.getTier() == 1) {
        skillSet.add(skill);
    } else {
        Iterator<Skill> value = skillSet.iterator();
        while (value.hasNext()) {
            Skill skillToCompare = value.next();
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
public void apply(Hero hero) {
    SkillApplier applier = new SkillApplier();
    Iterator<Skill> value = skillSet.iterator();
    while (value.hasNext()) {
        applier.apply(value.next(), hero);
    }
}
void removeSkill(Skill skill){
    skillSet.remove(skill);
    }

public boolean contains(Skill skill){
       return skillSet.contains(skill);
    }


}