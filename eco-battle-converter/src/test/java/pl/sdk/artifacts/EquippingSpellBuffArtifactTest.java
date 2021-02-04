package pl.sdk.artifacts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.hero.Hero;
import pl.sdk.spells.Spell;
import pl.sdk.spells.SpellFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        Spell airSpell = spellFactory.create("Magic Arrow");
        spells.add(airSpell);
        hero.addSpells(spells);

        (artifactFactory.create("Orb of Firmament")).buff(hero); // + 50% damage of AIR spells

        assertEquals(0.5, airSpell.getExtraDamage());

    }

    @Test
    void ArtifactDamageShouldIncreaseSpellDamageOfFewSpells(){
        Spell airSpell = spellFactory.create("Magic Arrow");
        Spell airSpell2 = spellFactory.create("Lightning Bolt");
        Spell fireSpell = spellFactory.create("Fire Ball");

        spells.add(airSpell);
        spells.add(airSpell2);
        spells.add(fireSpell);
        hero.addSpells(spells);

        (artifactFactory.create("Orb of Firmament")).buff(hero); // + 50% damage of AIR spells

        assertEquals(0.5, airSpell.getExtraDamage());
        assertEquals(0.5, airSpell2.getExtraDamage());
        assertEquals(0, fireSpell.getExtraDamage());
    }

    @Test
    void ArtifactDurationShouldIncreaseSpellDurationOfOneSpell(){
        Spell spell = new spellFactory.create("Bloodlust");
        spells.add(spell);
        hero.addSpells(spells);

        int primarySpellDuration = spell.getDuration();

        (artifactFactory.create("Ring of Conjuring")).buff(hero); // + 2 duration

        assertEquals(primarySpellDuration + 2, airSpell.getDuration());
    }

    @Test
    void ArtifactDurationShouldIncreaseSpellDurationOfFewSpells(){
        Spell spell1 = spellFactory.create("Bloodlust");
        Spell spell2 = spellFactory.create("Shield");
        Spell spell3 = spellFactory.create("Slow");
        spells.add(spell1);
        spells.add(spell2);
        spells.add(spell3);
        hero.addSpells(spells);

        int primarySpellDuration1 = spell1.getDuration();
        int primarySpellDuration2 = spell2.getDuration();
        int primarySpellDuration3 = spell3.getDuration();

        (artifactFactory.create("Cape of Conjuring")).buff(hero); // + 3 duration

        assertEquals(primarySpellDuration1 + 2, spell1.getDuration());
        assertEquals(primarySpellDuration2 + 2, spell2.getDuration());
        assertEquals(primarySpellDuration3 + 2, spell3.getDuration());
    }

    @Test
    void ArtifactSpellBookShouldAddEarthSpellsToHeroCorrectly(){
        hero.addSpells(spells);

        (artifactFactory.create("Tome of Earth Magic")).buff(hero); // + all earth spells

        assertEquals(19, hero.getSpells().size());
    }

    @Test
    void ArtifactSpellBookShouldAddAirSpellsToHeroCorrectly(){
        hero.addSpells(spells);

        (artifactFactory.create("Tome of Air Magic")).buff(hero); // + all air spells

        assertEquals(20, hero.getSpells().size());
    }

    @Test
    void ArtifactSpellBookShouldAddFireSpellsToHeroCorrectly(){
        hero.addSpells(spells);

        (artifactFactory.create("Tome of Fire Magic")).buff(hero); // + all fire spells

        assertEquals(18, hero.getSpells().size());
    }

    @Test
    void ArtifactSpellBookShouldAddWaterSpellsToHeroCorrectly(){
        hero.addSpells(spells);

        (artifactFactory.create("Tome of Water Magic")).buff(hero); // + all water spells

        assertEquals(19, hero.getSpells().size());
    }

    @Test
    void ArtifactSpellBookShouldAdd5TierSpellsToHeroCorrectly(){
        hero.addSpells(spells);

        (artifactFactory.create("Spellbinder's Hat")).buff(hero); // + all 5 tier spells

        assertEquals(12, hero.getSpells().size());
    }
}
