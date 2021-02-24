package pl.sdk.spells;

import pl.sdk.creatures.Creature;
import pl.sdk.hero.Hero;
import pl.sdk.spells.cast.ChangeStatisticBySpellStrategy;
import pl.sdk.spells.cast.DefaultAttackSpellStrategy;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class SpellBook implements PropertyChangeListener {
    private HashMap<Spell, Integer> spellBook = new HashMap<Spell, Integer>();
    private Spell spellInThisTurn;
    public SpellBook(){
        this.spellInThisTurn= null;
    }

    public Set<Spell> getSpellBook(){
        return spellBook.keySet();
    }

    boolean contains(Spell spell) {
        return getSpellOfName(spell.getName()) != null;
    }

    public void addSpell(Spell spell){
        if(contains(spell)){
            spellBook.put(getSpellOfName(spell.getName()), spellBook.get(getSpellOfName(spell.getName()))+1);
        }
        else {
            spellBook.put(spell, 1);
        }
    }

    public void removeSpell(Spell spell){
        if(contains(spell)){
            spellBook.put(getSpellOfName(spell.getName()), getUsesOfSpell(getSpellOfName(spell.getName())) -1);
            if(getUsesOfSpell(getSpellOfName(spell.getName()))==0){
                spellBook.remove(getSpellOfName(spell.getName()));
            }
        }
    }
    public Integer getSize(){
        return spellBook.size();
    }

    public Spell getSpellOfName(String name){
        for(Spell i: spellBook.keySet()){
            if(i.getName().equals(name)){
                return i;
            }
        }
        return null;
    }


    public int getUsesOfSpell(Spell spell) {
        return this.spellBook.get(getSpellOfName(spell.getName()));
    }

    public Creature castSpell(Spell spell, Creature creature, Hero owner){
        perpareToCastSpell(spell, creature);
                if (spell.getType().equals(SpellEnum.typeOfSpell.ATTACK)) {
                    DefaultAttackSpellStrategy str = new DefaultAttackSpellStrategy();
                    str.castSpell(creature, spell, owner);
                } else if (spell.getType().equals(SpellEnum.typeOfSpell.CANGESTATISTIC)) {
                    ChangeStatisticBySpellStrategy str = new ChangeStatisticBySpellStrategy();
                    creature = str.castSpell(creature, spell, owner);
                }
                return creature;
            }

    public List<Creature> castSpell(Spell spell, List<Creature> creatures, Hero owner){
        if(spell.getDuration().equals(SpellEnum.durationOfSpell.AREA)) {
            perpareToCastSpell(spell, creatures.get(0));
            for (Creature creature : creatures) {
                castSpell(spell, creature, owner);
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
}
