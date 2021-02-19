package pl.sdk.converter;

import pl.sdk.artifacts.AbstractArtifact;
import pl.sdk.artifacts.ArtifactFactory;
import pl.sdk.creatures.*;
import pl.sdk.hero.HeroClassFactory;
import pl.sdk.skills.Skill;
import pl.sdk.skills.SkillApplier;
import pl.sdk.skills.SkillFactory;
import pl.sdk.hero.Hero;
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

        economyHero.getSkillList().forEach(ecoSkill ->
                skills.add(skillFactory.create(ecoSkill.getName(), ecoSkill.getLevel())));
        economyHero.getArtifacts().forEach(ecoArtifact -> {
            artifacts.add(artifactFactory.create(ecoArtifact.getName()));
        });

        HeroSpellMastery hsm = new HeroSpellMastery(economyHero);

        convertBattleObjects(economyHero, hero);
        convertSpells(economyHero, hero, hsm);

        artifacts.forEach(a -> a.buff(hero));

        heroIncreaseCreatureStats(hero);

        skills.forEach(skill -> skillApplier.apply(skill, hero));

        return hero;
    }

    private static void heroIncreaseCreatureStats(Hero hero) {
        Integer heroAttack = hero.getAttack();
        Integer heroDefence = hero.getDefence();

        hero.getCreatures().forEach(creature -> {
            creature.increaseAttack(heroAttack);
            creature.increaseArmor(heroDefence);
        });
    }

    private static void convertBattleObjects(EconomyHero economyHero, Hero hero) {
        List<Creature> creatures = new ArrayList<>();
        List<BattleObject> warmachines = new ArrayList<>();


        String WARMACHINE = "WARMACHINES";
        economyHero.getCreatures().forEach(ecoCreature -> {
            if (ecoCreature.getFraction().equals(WARMACHINE))  {
                BattleObject warmachine = FractionFactory.getFraction(ecoCreature.getFraction()).create(ecoCreature.isUpgraded(), ecoCreature.getTier(), ecoCreature.getAmount());
                warmachines.add(warmachine);
            }
            else {
                Creature c = (Creature) FractionFactory.getFraction(ecoCreature.getFraction()).create(ecoCreature.isUpgraded(), ecoCreature.getTier(), ecoCreature.getAmount());
                creatures.add(c);
            }

        });
        hero.addCreatures(creatures);
        hero.addWarmachines(warmachines);
    }

    private static void convertSpells(EconomyHero economyHero, Hero hero, HeroSpellMastery hsm) {
        SpellFactory spellFactory = new SpellFactory();
        List<Spell> spells = new ArrayList<Spell>();
//        economyHero.getSpells().forEach(ecoSpell -> {
//            Spell s = spellFactory.create(ecoSpell.getName(), hsm);
//
//            spells.add(s);
//        });
        hero.addSpells(spells);
    }
}
