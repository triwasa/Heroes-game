package pl.sdk.converter;

import pl.sdk.artifacts.AbstractArtifact;
import pl.sdk.artifacts.ArtifactFactory;
import pl.sdk.hero.HeroClassFactory;
import pl.sdk.skills.Skill;
import pl.sdk.skills.SkillApplier;
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
        ArtifactFactory artifactFactory = new ArtifactFactory();
        SkillFactory skillFactory = new SkillFactory();
        HeroClassFactory heroClassFactory = new HeroClassFactory();

        List<AbstractArtifact> artifacts = new ArrayList<>();
        List<Skill> skills = new ArrayList<>();

        Hero hero = heroClassFactory.create(economyHero.getClassName());

        economyHero.getSkills().forEach(ecoSkill ->
                skills.add(skillFactory.create(ecoSkill.getName(), ecoSkill.getLevel())));
        economyHero.getArtifacts().forEach(ecoArtifact -> {
            artifacts.add(artifactFactory.create(ecoArtifact.getName()));
        });

        HeroSpellMastery hsm = new HeroSpellMastery(economyHero);

        List<Creature> creatures = convertCreatures(economyHero, hero, skills);
        List<Spell> spells = convertSpells(economyHero, hsm);

        hero.addCreatures(creatures);
        hero.addSpells(spells);

        // apply artifacts on hero -> modify hero's stats, creatures and spells
        artifacts.forEach(a -> a.buff(hero));

        return hero;
    }

    private static List<Creature> convertCreatures(EconomyHero economyHero, Hero hero,  List<Skill> skills) {
        NecropolisFactory factory = new NecropolisFactory();
        List<Creature> creatures = new ArrayList<>();
        SkillApplier skillApplier = new SkillApplier();

        economyHero.getCreatures().forEach(ecoCreature -> {
            Creature c = factory.create(ecoCreature.isUpgraded(), ecoCreature.getTier(), ecoCreature.getAmount());

            skills.forEach(skill -> skillApplier.apply(skill, hero));
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
//            //applySorcery(s);
//
//            spells.add(s);
//        });
        return spells;
    }
}
