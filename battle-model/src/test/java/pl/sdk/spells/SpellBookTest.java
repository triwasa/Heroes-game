package pl.sdk.spells;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NeutralFactory;
import pl.sdk.hero.Hero;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SpellBookTest {
    private SpellBook spellBook;
    private SpellFactory spellFactory;
    private Hero owner;
    private Creature creature;
    private Creature copyCreature;
    private NeutralFactory neutralFactory;
    private List<Creature> listOfCreatures;

    @BeforeEach
    void init(){
        this.owner = new Hero();
        this.spellBook = new SpellBook();
        this.spellFactory = new SpellFactory();
        this.neutralFactory = new NeutralFactory();
        this.spellBook.addSpell(spellFactory.create(SpellEnum.BLESS));
        this.creature = this.neutralFactory.create(false, 1, 20);
        this.copyCreature=this.neutralFactory.create(false, 1, 20);
        this.listOfCreatures = new ArrayList<Creature>();
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

    @Test
    void castSpellToAttackCreature(){
        Integer amount = creature.getAmount();
        Spell spell = spellFactory.create(SpellEnum.MAGIC_ARROW_AIR);
        this.spellBook.addSpell(spell);
        creature = this.spellBook.castSpell(spellFactory.create(SpellEnum.MAGIC_ARROW_AIR), creature, owner);
        assertNotEquals(amount, creature.getAmount());
    }
    @Test
    void castSpellToChangeStatisticOfCreature(){
        Integer attack = creature.getAttack();
        Spell spell = spellFactory.create(SpellEnum.BLESS);
        this.spellBook.addSpell(spell);
        Creature creature1 = this.spellBook.castSpell(spellFactory.create(SpellEnum.BLESS), creature, owner);
        assertNotEquals(attack, creature1.getAttack());
    }
    @Test
    void castSpellToAttackManyTargets(){
        List<Creature> listOfCreatures = new ArrayList<>();
        listOfCreatures.add(creature);
        listOfCreatures.add(copyCreature);
        Integer amout = creature.getAmount();
        Spell spell = spellFactory.create(SpellEnum.FROST_RING2);
        this.spellBook.addSpell(spell);
        this.spellBook.castSpell(spellFactory.create(SpellEnum.FROST_RING2), listOfCreatures, owner);
        assertEquals(creature.getAmount(), copyCreature.getAmount());
        assertNotEquals(creature.getAmount(), amout);
    }

    @Test
    void cannotSpellToAttackManyTargetsIfItNotIsAreaTypeSpell(){
        listOfCreatures.add(creature);
        listOfCreatures.add(copyCreature);
        Integer amout = creature.getAmount();
        this.spellBook.castSpell(spellFactory.create(SpellEnum.MAGIC_ARROW_AIR), listOfCreatures, owner);
        assertEquals(creature.getAmount(), copyCreature.getAmount());
        assertEquals(creature.getAmount(), amout);
    }

    @Test
    void youCanCastOnlyOneSpellInTurn(){
        Spell spell = spellFactory.create(SpellEnum.MAGIC_ARROW_AIR);
        this.spellBook.addSpell(spell);
        this.spellBook.addSpell(spell);
        Integer amount = creature.getAmount();
        creature = this.spellBook.castSpell(spellFactory.create(SpellEnum.MAGIC_ARROW_AIR), creature, owner);
        assertNotEquals(amount, creature.getAmount());
        Integer amountAfterOneSpell = creature.getAmount();
        creature = this.spellBook.castSpell(spellFactory.create(SpellEnum.MAGIC_ARROW_AIR), creature, owner);
        assertEquals(amountAfterOneSpell, creature.getAmount());
    }
}
