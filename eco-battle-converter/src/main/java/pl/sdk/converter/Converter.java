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
        SkillApplier skillApplier = new SkillApplier();

        List<AbstractArtifact> artifacts = new ArrayList<>();
        List<Skill> skills = new ArrayList<>();

        Hero hero = heroClassFactory.create(economyHero.getClassName());

        economyHero.getSkills().forEach(ecoSkill ->
                skills.add(skillFactory.create(ecoSkill.getName(), ecoSkill.getLevel())));
        economyHero.getArtifacts().forEach(ecoArtifact -> {
            artifacts.add(artifactFactory.create(ecoArtifact.getName()));
        });

        HeroSpellMastery hsm = new HeroSpellMastery(economyHero);

        List<Creature> creatures = convertCreatures(economyHero);
        List<Spell> spells = convertSpells(economyHero, hsm);

        hero.addCreatures(creatures);
        hero.addSpells(spells);

        artifacts.forEach(a -> a.buff(hero));
        skills.forEach(skill -> skillApplier.apply(skill, hero));

        return hero;
    }

    private static List<Creature> convertCreatures(EconomyHero economyHero) {
        NecropolisFactory factory = new NecropolisFactory();
        List<Creature> creatures = new ArrayList<>();

        economyHero.getCreatures().forEach(ecoCreature -> {
            Creature c = factory.create(ecoCreature.isUpgraded(), ecoCreature.getTier(), ecoCreature.getAmount());
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
//            spells.add(s);
//        });
        return spells;
    }
}
