package pl.sdk.skills;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SkillSetEconomyTest {

    public static final int NOT_IMPORTANT = 5;

    @Test
    void skillShouldBeAddedCorrectly() {
        EconomySkillSet aSkillSet = new EconomySkillSet();
        EconomySkillFactory skillFactory = new EconomySkillFactory();
        EconomySkill offence = skillFactory.create("offence",1);
        aSkillSet.addSkill(offence);
        assertEquals(true, aSkillSet.contains(offence));
        assertEquals(1, aSkillSet.getSize());
    }

    @Test
    void skillShouldBeReplacedCorrectly() {
        EconomySkillSet aSkillSet = new EconomySkillSet();
        EconomySkillFactory skillFactory = new EconomySkillFactory();
        EconomySkill offence1 = skillFactory.create("offence",1);
        aSkillSet.addSkill(offence1);
        EconomySkill offence2 = skillFactory.create("offence",2);
        aSkillSet.addSkill(offence2);
        assertEquals(false, aSkillSet.contains(offence1));
        assertEquals(true, aSkillSet.contains(offence2));
        assertEquals(1, aSkillSet.getSize());
    }

    @Test
    void skillWithLowerTierShouldNotBeAdded(){
        EconomySkillSet aSkillSet = new EconomySkillSet();
        EconomySkillFactory skillFactory = new EconomySkillFactory();
        EconomySkill offence2 = skillFactory.create("offence",2);
        aSkillSet.addSkill(offence2);
        EconomySkill offence1 = skillFactory.create("offence",1);
        aSkillSet.addSkill(offence1);
        assertEquals(false, aSkillSet.contains(offence1));
        assertEquals(true, aSkillSet.contains(offence2));
        assertEquals(1, aSkillSet.getSize());
    }
}

