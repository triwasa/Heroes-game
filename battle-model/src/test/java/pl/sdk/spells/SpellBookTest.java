package pl.sdk.spells;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.Hero;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SpellBookTest {
    private SpellBook spellBook;
    private SpellFactory spellFactory;
    private Hero owner;

    @BeforeEach
    void init(){
        this.owner = new Hero();
        this.spellBook = new SpellBook(owner);
        this.spellFactory = new SpellFactory();
        this.spellBook.addSpell(spellFactory.create(SpellEnum.BLESS));
    }

    @Test
    void addSpellToTheSpellBook(){
        this.spellBook.addSpell(spellFactory.create(SpellEnum.MAGIC_ARROW_AIR));
        assertEquals(2, spellBook.getSize());
    }

    @Test
    void removeSpellToTheSpellBook(){
        Spell spell = spellFactory.create(SpellEnum.BLESS);
        this.spellBook.addSpell(spell);
        this.spellBook.removeSpell(spell);
        assertEquals(1, this.spellBook.getUsesOfSpell(spell));

    }

    @Test
    void removeAllSpellToTheSpellBook(){
        Spell spell = spellFactory.create(SpellEnum.BLESS);
        this.spellBook.removeSpell(spell);
        assertEquals(0, this.spellBook.getSize());

    }

    @Test
    void addFewTheSameSpellToTheSpellBook(){
        Spell spell = spellFactory.create(SpellEnum.BLESS);
        this.spellBook.addSpell(spell);
        this.spellBook.addSpell(spell);
        this.spellBook.addSpell(spell);
        assertEquals(1, this.spellBook.getSize());
        assertEquals(4, this.spellBook.getUsesOfSpell(spell));
    }
}
