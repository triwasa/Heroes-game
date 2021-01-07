package pl.sdk.converter;

import pl.sdk.Hero;
import pl.sdk.creatures.NecropolisFactory;
import pl.sdk.hero.EconomyHero;

public class Converter {

    public static Hero convert(EconomyHero economyHero) {
        NecropolisFactory factory = new NecropolisFactory();
//        ArtifactFactory artifactFactory = new ArtifactFactory();
//        SkillFactory skillFactory = new SkillFactory();
//        SpellFactory spellFactory = new SpellFactory();
//
//        Hero hero = new Hero();
//
//        economyHero.getCreatures().forEach(ecoCreature ->
//                hero.addCreature(factory.create(ecoCreature.isUpgraded(),ecoCreature.getTier(),ecoCreature.getAmount())));
//
//        economyHero.getSkills().forEach(ecoSkill ->
//                hero.addSkill(skillFactory.create(ecoSkill.getName(), ecoSkill.getLevel)));
//
//        economyHero.getArtifacts().forEach(ecoArtifact ->
//                hero.addArtifact(artifactFactory.create(ecoArtifact.getName())));
//
//        economyHero.getSpells().forEach(ecoSpell ->
//                hero.addSpell(spellFactory.create(ecoSpell.getName(), ecoSpell.getLevel())));

        // TODO apply everything on hero and his creatures

        return null;
    }
}
