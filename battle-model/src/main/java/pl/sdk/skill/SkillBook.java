package pl.sdk.skill;

import pl.sdk.Hero;

import java.util.HashSet;
import java.util.Set;

public class SkillBook {

private Set<Skill> skillBook = new HashSet<Skill>();
private Hero owner = new Hero();

public SkillBook(Hero hero){
    owner = hero;
}

public void addSkill(Skill skill){
    skillBook.add(skill);
}

void removeSkill(Skill skill){
        skillBook.remove(skill);
    }

public boolean contains(Skill skill){
       return skillBook.contains(skill);
    }
}