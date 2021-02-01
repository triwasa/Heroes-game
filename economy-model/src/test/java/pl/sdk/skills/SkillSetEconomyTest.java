package pl.sdk.skills;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;


public class SkillSetEconomyTest {

    private SkillSet skillSet;
    public static final int NOT_IMPORTANT = 5;

    //TODO: fix tests with creatures

    @Test
    void skillShouldBeAddedCorrectly(){
        SkillSet aSkillSet = new SkillSet();
        SkillFactory skillFactory = new SkillFactory();
        Skill offence = skillFactory.create("offence 1");
        aSkillSet.addSkill(offence);
        assertEquals(true,aSkillSet.contains(offence));
    }

    @Test
    void skillShouldBeReplacedCorrectly(){
        SkillSet aSkillSet = new SkillSet();
        SkillFactory skillFactory = new SkillFactory();
        Skill offence1 = skillFactory.create("offence 1");
        aSkillSet.addSkill(offence1);
        Skill offence2 = skillFactory.create("offence 2");
        aSkillSet.addSkill(offence2);
        assertEquals(false,aSkillSet.contains(offence1));
        assertEquals(true,aSkillSet.contains(offence2));
    }
/*
<<<<<<< Updated upstream:battle-model/src/test/java/pl/sdk/skill/SkillBookBasicTest.java
}
=======
*/
}
