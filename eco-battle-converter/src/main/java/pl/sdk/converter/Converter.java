package pl.sdk.converter;

import pl.sdk.Hero;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;
import pl.sdk.hero.EconomyHero;
import pl.sdk.skill.Skill;
import pl.sdk.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static Hero convert(EconomyHero economyHero) {
//        NecropolisFactory factory = new NecropolisFactory();
//        ArtifactFactory artifactFactory = new ArtifactFactory();
//        SkillFactory skillFactory = new SkillFactory();
//        SpellFactory spellFactory = new SpellFactory();
//
//        List<Artifact> artifacts = new ArrayList<>();
//        List<Skill> skills = new ArrayList<>();
//
//        Hero hero = new Hero().Builder()
//                .attack(economyHero.getStats().getAttack())
//                .defence(economyHero.getStats().getDefence())
//                .spell(economyHero.getStats().getSpell())
//                .knowledge(economyHero.getStats().getKnowledge())
//                .build();
//
//
//        economyHero.getSkills().forEach(ecoSkill ->
//                skills.add(skillFactory.create(ecoSkill.getName(), ecoSkill.getLevel)));
//        economyHero.getArtifacts().forEach(ecoArtifact ->
//                artifacts.add(artifactFactory.create(ecoArtifact.getName())));
//
//
//        economyHero.getCreatures().forEach(ecoCreature -> {
//            Creature c = factory.create(ecoCreature.isUpgraded(),ecoCreature.getTier(),ecoCreature.getAmount());
//
//            artifacts.forEach(artifact -> artifact.apply(c));
//            skills.forEach(skill -> skill.apply(c));
//            c.increaseStats(hero.getStats());
//
//            hero.addCreature(c);
//        });
//
//
//        economyHero.getSpells().forEach(ecoSpell -> {
//            Spell s = spellFactory.create(ecoSpell.getName(), ecoSpell.getLevel());
//
//            artifacts.forEach(artifact -> artifact.apply(s));
//            skills.forEach(skill -> skill.apply(s));
//
//            hero.addSpell(s);
//        });
//
//        return hero;
        return null;
    }
}
