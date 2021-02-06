package pl.sdk.artifacts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.hero.Hero;
import pl.sdk.spells.Spell;
import pl.sdk.spells.SpellFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.sdk.artifacts.ArtifactName.*;
import static pl.sdk.spells.SpellEnum.*;

public class EquippingSpellBuffArtifactTest {

    private Hero hero;
    private List<Spell> spells;
    private final ArtifactAbstractFactory artifactFactory = new ArtifactPrimaryFactory();
    private final SpellFactory spellFactory = new SpellFactory();

    @BeforeEach
    void init(){
        spells = new ArrayList<>();
        hero = new Hero();
    }

    @Test
    void ArtifactDamageShouldIncreaseSpellDamageOfOneSpell(){
//        Spell airSpell = spellFactory.create(MAGIC_ARROW);
//        spells.add(airSpell);
//        hero.addSpells(spells);
//
//        (artifactFactory.create(ORB_OF_THE_FIRMAMENT)).buff(hero); // + 50% damage of AIR spells
//
//        assertEquals(0.5, airSpell.getExtraDamage());

    }

    @Test
    void ArtifactDamageShouldIncreaseSpellDamageOfFewSpells(){
//        Spell airSpell = spellFactory.create(MAGIC_ARROW);
//        Spell airSpell2 = spellFactory.create(LIGHTNING_BOLT);
//        Spell fireSpell = spellFactory.create(FIRE_BALL);
//
//        spells.add(airSpell);
//        spells.add(airSpell2);
//        spells.add(fireSpell);
//        hero.addSpells(spells);
//
//        (artifactFactory.create(ORB_OF_THE_FIRMAMENT)).buff(hero); // + 50% damage of AIR spells
//
//        assertEquals(0.5, airSpell.getExtraDamage());
//        assertEquals(0.5, airSpell2.getExtraDamage());
//        assertEquals(0, fireSpell.getExtraDamage());
    }

    @Test
    void ArtifactDurationShouldIncreaseSpellDurationOfOneSpell(){
//        Spell spell = new spellFactory.create(BLOODLUST);
//        spells.add(spell);
//        hero.addSpells(spells);
//
//        int primarySpellDuration = spell.getDuration();
//
//        (artifactFactory.create(RING_OF_CONJURING)).buff(hero); // + 2 duration
//
//        assertEquals(primarySpellDuration + 2, airSpell.getDuration());
    }

    @Test
    void ArtifactDurationShouldIncreaseSpellDurationOfFewSpells(){
//        Spell spell1 = spellFactory.create(BLOODLUST);
//        Spell spell2 = spellFactory.create(SHIELD);
//        Spell spell3 = spellFactory.create(SLOW);
//        spells.add(spell1);
//        spells.add(spell2);
//        spells.add(spell3);
//        hero.addSpells(spells);
//
//        int primarySpellDuration1 = spell1.getDuration();
//        int primarySpellDuration2 = spell2.getDuration();
//        int primarySpellDuration3 = spell3.getDuration();
//
//        (artifactFactory.create(CAPE_OF_CONJURING)).buff(hero); // + 3 duration
//
//        assertEquals(primarySpellDuration1 + 2, spell1.getDuration());
//        assertEquals(primarySpellDuration2 + 2, spell2.getDuration());
//        assertEquals(primarySpellDuration3 + 2, spell3.getDuration());
    }

    @Test
    void ArtifactSpellBookShouldAddEarthSpellsToHeroCorrectly(){
//        hero.addSpells(spells);
//
//        (artifactFactory.create(TOME_OF_EARTH_MAGIC)).buff(hero); // + all earth spells
//
//        assertEquals(19, hero.getSpells().size());
    }

    @Test
    void ArtifactSpellBookShouldAddAirSpellsToHeroCorrectly(){
//        hero.addSpells(spells);
//
//        (artifactFactory.create(TOME_OF_AIR_MAGIC)).buff(hero); // + all air spells
//
//        assertEquals(20, hero.getSpells().size());
    }

    @Test
    void ArtifactSpellBookShouldAddFireSpellsToHeroCorrectly(){
//        hero.addSpells(spells);
//
//        (artifactFactory.create(TOME_OF_FIRE_MAGIC)).buff(hero); // + all fire spells
//
//        assertEquals(18, hero.getSpells().size());
    }

    @Test
    void ArtifactSpellBookShouldAddWaterSpellsToHeroCorrectly(){
//        hero.addSpells(spells);
//
//        (artifactFactory.create(TOME_OF_WATER_MAGIC)).buff(hero); // + all water spells
//
//        assertEquals(19, hero.getSpells().size());
    }

    @Test
    void ArtifactSpellBookShouldAdd5TierSpellsToHeroCorrectly(){
//        hero.addSpells(spells);
//
//        (artifactFactory.create(SPELLBINDERS_HAT)).buff(hero); // + all 5 tier spells
//
//        assertEquals(12, hero.getSpells().size());
    }
}
