package pl.sdk.artifacts;

import pl.sdk.spells.Spell;
import pl.sdk.spells.SpellEnum;

import java.util.List;
import java.util.Set;

public class ArtifactSpellBookType extends ArtifactSpellBuff {
    private final SpellEnum.magicTypeOfSpell magicType;

    public ArtifactSpellBookType(ArtifactStatisticIf aStat, SpellEnum.magicTypeOfSpell aMagicType) {
        stats = aStat;
        this.magicType = aMagicType;
    }

    @Override
    void buffSpell(Set<Spell> spells) {
        Set<Spell> spellsToAdd = createSpells();
        spellsToAdd.forEach(spell -> {
            if(!spells.contains(spell)) {
                spells.add(spell);
            }});
    }

    private Set<Spell> createSpells(){
        SpellsCreator spellsCreator = new SpellsCreator();
        return spellsCreator.createSpellsByMagicType(magicType);
    }
}
