package pl.sdk.converter;

import pl.sdk.hero.Hero;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;
import pl.sdk.hero.EconomyHero;
import pl.sdk.skill.Skill;
import pl.sdk.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static Hero convert(EconomyHero economyHero) {
        ArtifactFactory artifactFactory = new ArtifactFactory();
        SkillFactory skillFactory = new SkillFactory();

        List<Artifact> artifacts = new ArrayList<>();
        List<Skill> skills = new ArrayList<>();

        // create new hero with default stats of economyHero
        Hero hero = new Hero.Builder()
                .attack(economyHero.getStats().getAttack())
                .defence(economyHero.getStats().getDefence())
                .power(economyHero.getStats().getPower())
                .knowledge(economyHero.getStats().getKnowledge())
                .build();

        economyHero.getSkills().forEach(ecoSkill ->
                skills.add(skillFactory.create(ecoSkill.getName(), ecoSkill.getLevel)));
        economyHero.getArtifacts().forEach(ecoArtifact ->
                artifacts.add(artifactFactory.create(ecoArtifact.getName())));


        // apply artifacts on hero -> modify hero's stats [ attack, defence, power, knowledge]
        artifacts.forEach(a -> a.apply(hero));


        List<Creature> creatures = convertCreatures(economyHero, artifacts, skills, hero);
        hero.addCreatures(creatures);

        SpellMasteries masteries = new SpellMasteries(BASIC, BASIC, BASIC, BASIC);

        List<Spell> spells = convertSpells(economyHero, artifacts, skills, masteries);
        hero.addSpells(spells);

        return hero;
    }

    private static List<Creature> convertCreatures(EconomyHero economyHero, List<Artifact> artifacts, List<Skill> skills, Hero hero) {
        NecropolisFactory factory = new NecropolisFactory();
        List<Creature> creatures = new ArrayList<>();
        economyHero.getCreatures().forEach(ecoCreature -> {
            // create creatures with modified stats by hero's stats
            Creature c = factory.create(ecoCreature.isUpgraded(), ecoCreature.getTier(), ecoCreature.getAmount(), hero.getStats());

            // apply artifacts like spell immunity, magic resistance
            artifacts.forEach(artifact -> artifact.apply(c));

            // apply skills [Archery, Offence, Armourer, Resistance, Leadership, Luck]
            skills.forEach(skill -> skill.apply(c));

            creatures.add(c);
        });
        return creatures;
    }

    private static List<Spell> convertSpells(EconomyHero economyHero, List<Artifact> artifacts, List<Skill> skills, SpellMasteries masteries) {
        SpellFactory spellFactory = new SpellFactory();
        List<Spell> spells = new ArrayList<>();
        economyHero.getSpells().forEach(ecoSpell -> {
            Spell s = spellFactory.create(ecoSpell.getName(), economyHero.getPower(), masteries);

            // artifacts:
            //      - increasing spell duration [Collar of Conjuring, Ring of Conjuring, Cape of Conjuring]
            //      - increasing spell damage [Orb of the Firmament, Orb of Silt, Orb of Tempstuous Fire, Orb of Driving Rain ]
            artifacts.forEach(artifact -> artifact.apply(s));
            // skills increasing damage [Sorcery]
            skills.forEach(skill -> skill.apply(s));

            spells.add(s);
        });
        return spells;
    }
}
