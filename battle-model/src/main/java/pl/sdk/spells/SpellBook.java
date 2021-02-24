package pl.sdk.spells;

import pl.sdk.creatures.Creature;
import pl.sdk.hero.Hero;
import pl.sdk.spells.cast.ChangeStatisticBySpellStrategy;
import pl.sdk.spells.cast.DefaultAttackSpellStrategy;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;

public class SpellBook implements PropertyChangeListener {
    private Set<Spell> spellBook = new HashSet<Spell>();
    private Spell spellInThisTurn;
    public SpellBook(){
        this.spellInThisTurn= null;
    }

    public Set<Spell> getSpellBook(){
        return this.spellBook;
    }

    boolean contains(Spell spell) {
        return getSpellOfName(spell.getTechName()) != null;
    }

    public void addSpell(Spell spell){
        if(contains(spell)){
            spellBook.add(getSpellOfName(spell.getTechName()));
        }
        else {
            spellBook.add(spell);
        }
    }

    public void removeSpell(Spell spell){
        spellBook.remove(getSpellOfName(spell.getTechName()));
    }
    public Integer getSize(){
        return spellBook.size();
    }

    public Spell getSpellOfName(SpellEnum techName){
        for(Spell i: spellBook){
            if(i.getTechName().equals(techName)){
                return i;
            }
        }
        return null;
    }

    private Creature checkTypeOfSpell(Spell spell, Creature creature, Hero owner) {
        if (spell.getType().equals(SpellEnum.typeOfSpell.ATTACK)) {
            DefaultAttackSpellStrategy str = new DefaultAttackSpellStrategy();
            creature = str.castSpell(creature, spell, owner);
        } else if (spell.getType().equals(SpellEnum.typeOfSpell.CANGESTATISTIC)) {
            ChangeStatisticBySpellStrategy str = new ChangeStatisticBySpellStrategy();
            creature = str.castSpell(creature, spell, owner);
        }
        return creature;
    }

    private Boolean prepareToCastSpell(Spell spell) {
        if (contains(spell) && spellInThisTurn== null) {
            spellInThisTurn = spell;
            removeSpell(spell);
            return true;
        }
        return false;
    }



    public Creature castSpell(Spell spell, Creature creature, Hero owner) {
        if (prepareToCastSpell(spell)) {
            return checkTypeOfSpell(spell, creature, owner);
        } else {
            return creature;
        }
    }

    public List<Creature> castSpell(Spell spell, List<Creature> creatures, Hero owner){
        if(prepareToCastSpell(spell)) {
            List<Creature> listOfCreatures = new ArrayList<>();
            if (spell.getDuration().equals(SpellEnum.durationOfSpell.AREA)) {
                for (Creature creature : creatures) {
                    listOfCreatures.add(checkTypeOfSpell(spell, creature, owner));
                }
                return listOfCreatures;
            }
        }
        return creatures;
    }


    public void perpareToCastSpell(Spell spell, Creature creature){
        try {
            if(contains(spell) && creature.isCreature()) {
                spellInThisTurn = spell;
            }
        }catch (Exception ex){
            System.err.println(ex);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.spellInThisTurn=null;
    }

    public void clearSpell() {
        this.spellBook.clear();
    }
}
