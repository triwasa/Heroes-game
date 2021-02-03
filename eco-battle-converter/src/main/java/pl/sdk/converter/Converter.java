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

        List<Artifact> artifacts = new ArrayList<Artifact>();
        List<Skill> skills = new ArrayList<Skill>();

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


        HeroSpellMastery hsm = new HeroSpellMastery(economyHero);

        List<Creature> creatures = convertCreatures(economyHero, skills);
        List<Spell> spells = convertSpells(economyHero, hsm);

        hero.addCreatures(creatures);
        hero.addSpells(spells);

        // apply artifacts on hero -> modify hero's stats, creatures and spells
        artifacts.forEach(a -> a.apply(hero));

        // TODO: convert skills [Intelligence, Wisdom, Eagle Eye] - add to hero ?

        // check if hero has Intelligence skill -> if yes increase mana
        increaseMana(hero);

        return hero;
    }

    private static List<Creature> convertCreatures(EconomyHero economyHero, List<Skill> skills) {
        NecropolisFactory factory = new NecropolisFactory();
        List<Creature> creatures = new ArrayList<>();
        economyHero.getCreatures().forEach(ecoCreature -> {
            // create creatures with modified stats by hero's default stats
            Creature c = factory.create(ecoCreature.isUpgraded(), ecoCreature.getTier(), ecoCreature.getAmount());

            // apply skills [Archery, Offence, Armourer, Resistance, Leadership, Luck]
            // apply war machines skills [Artillery, Ballistics, First aid, Eagle Eye]
            skills.forEach(skill -> skill.apply(c));

            creatures.add(c);
        });
        return creatures;
    }

    private static List<Spell> convertSpells(EconomyHero economyHero, HeroSpellMastery hsm) {
        SpellFactory spellFactory = new SpellFactory();
        List<Spell> spells = new ArrayList<Spell>();
        economyHero.getSpells().forEach(ecoSpell -> {
            Spell s = spellFactory.create(ecoSpell.getName(), hsm);

            // skills increasing damage - only [Sorcery]
            applySorcery(s);

            spells.add(s);
        });
        return spells;
    }
}
