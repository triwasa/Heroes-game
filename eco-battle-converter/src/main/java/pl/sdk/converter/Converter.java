package pl.sdk.converter;

import pl.sdk.artifacts.AbstractArtifact;
import pl.sdk.artifacts.ArtifactPrimaryFactory;
import pl.sdk.skills.Skill;
import pl.sdk.skills.SkillFactory;
import pl.sdk.hero.Hero;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;
import pl.sdk.hero.EconomyHero;
import pl.sdk.spells.Spell;
import pl.sdk.spells.SpellFactory;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static Hero convert(EconomyHero economyHero) {
        ArtifactPrimaryFactory artifactFactory = new ArtifactPrimaryFactory();
        SkillFactory skillFactory = new SkillFactory();

        List<AbstractArtifact> artifacts = new ArrayList<>();
        List<Skill> skills = new ArrayList<>();

        // create new hero with default stats of economyHero
        Hero hero = new Hero.BuilderForTesting()
                .attack(economyHero.getAttack())
                .defence(economyHero.getDefense())
                .power(economyHero.getSpellPower())
                .knowledge(economyHero.getKnowledge())
                .build();

//        economyHero.getSkills().forEach(ecoSkill ->
//                skills.add(skillFactory.create(ecoSkill.getName(), ecoSkill.getLevel())));
//        economyHero.getArtifacts().forEach(ecoArtifact -> {
//            artifacts.add(artifactFactory.create(ecoArtifact.getName()));
//        });


        HeroSpellMastery hsm = new HeroSpellMastery(economyHero);

        List<Creature> creatures = convertCreatures(economyHero, skills);
        List<Spell> spells = convertSpells(economyHero, hsm);

        hero.addCreatures(creatures);
//        hero.addSpells(spells);

        // apply artifacts on hero -> modify hero's stats, creatures and spells
        artifacts.forEach(a -> a.buff(hero));

        // TODO: convert pl.sdk.skills [Intelligence, Wisdom, Eagle Eye] - add to hero ?

        // check if hero has Intelligence skill -> if yes increase mana
//        increaseMana(hero);

        return hero;
    }

    private static List<Creature> convertCreatures(EconomyHero economyHero, List<Skill> skills) {
        NecropolisFactory factory = new NecropolisFactory();
        List<Creature> creatures = new ArrayList<>();
        economyHero.getCreatures().forEach(ecoCreature -> {
            // create creatures with modified stats by hero's default stats
            Creature c = factory.create(ecoCreature.isUpgraded(), ecoCreature.getTier(), ecoCreature.getAmount());

            // apply creature pl.sdk.skills [Archery, Offence, Armourer, Resistance, Leadership, Luck]
            // apply war machines pl.sdk.skills [Artillery, Ballistics, First aid, Eagle Eye]
//            skills.forEach(skill -> skill.apply(c));

            creatures.add(c);
        });
        return creatures;
    }

    private static List<Spell> convertSpells(EconomyHero economyHero, HeroSpellMastery hsm) {
        SpellFactory spellFactory = new SpellFactory();
        List<Spell> spells = new ArrayList<Spell>();
//        economyHero.getSpells().forEach(ecoSpell -> {
//            Spell s = spellFactory.create(ecoSpell.getName(), hsm);
//
//            // pl.sdk.skills increasing damage - only [Sorcery]
//            applySorcery(s);
//
//            spells.add(s);
//        });
        return spells;
    }
}
