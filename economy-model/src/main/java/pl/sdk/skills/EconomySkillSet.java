package pl.sdk.skills;

import java.util.*;

public class EconomySkillSet {

    private HashSet<EconomySkill> skillSet;

    public EconomySkillSet(){
        skillSet = new HashSet<EconomySkill>();
    }

    public void addSkill(EconomySkill skill) {
        boolean canAdd = true;
        Iterator<EconomySkill> value = skillSet.iterator();
        while (value.hasNext()) {
            EconomySkill skillToCompare = value.next();
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

    void removeSkill(EconomySkill skill){
        skillSet.remove(skill);
    }

    public boolean contains(EconomySkill skill){
        return skillSet.contains(skill);
    }

    public HashSet<EconomySkill> getSkillSet() {
        return skillSet;
    }

    public int getSize(){
        return skillSet.size();
    }
}