package pl.sdk.skills;

import pl.sdk.hero.Hero;

import java.util.*;

public class SkillSet {

private HashSet<Skill> skillSet;

public SkillSet(){
    skillSet = new HashSet<Skill>();
}

    void addSkill(Skill skill) {
        boolean canAdd = true;
        Iterator<Skill> value = skillSet.iterator();
        while (value.hasNext()) {
            Skill skillToCompare = value.next();
            if (skillToCompare.getCoreName() == skill.getCoreName()){
                if (skill.getTier() > skillToCompare.getTier()){
                    skillSet.remove(skillToCompare);
                }
                else {
                    canAdd = false;
                }
            }
        }
        if (canAdd == true){
            skillSet.add(skill);
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

    public int getSize(Skill skill){
        return skillSet.size();
    }

}