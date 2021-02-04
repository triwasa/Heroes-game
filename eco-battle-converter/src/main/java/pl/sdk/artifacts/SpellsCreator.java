package pl.sdk.artifacts;

import pl.sdk.spells.Spell;
import pl.sdk.spells.SpellFactory;

import java.util.ArrayList;
import java.util.List;

public class SpellsCreator {
    private final SpellFactory spellFactory = new SpellFactory();
    private final String EXCEPTION = "Cannot create spells with that magic type or tier";

    protected List<Spell> createSpellsByMagicType(String aMagicType){
        List<Spell> spellList = new ArrayList<>();
        switch (aMagicType){
            case "FIRE":
                spellList.add(spellFactory.create("MAGIC ARROW"));
                spellList.add(spellFactory.create("VISIONS"));
                spellList.add(spellFactory.create("BLOODLUST"));
                spellList.add(spellFactory.create("CURSE"));
                spellList.add(spellFactory.create("PROTECTION FROM FIRE"));
                spellList.add(spellFactory.create("BLIND"));
                spellList.add(spellFactory.create("FIRE WALL"));
                spellList.add(spellFactory.create("FIREBALL"));
                spellList.add(spellFactory.create("LAND MINE"));
                spellList.add(spellFactory.create("MISFORTUNE"));
                spellList.add(spellFactory.create("ARMAGEDDON"));
                spellList.add(spellFactory.create("BERSERK"));
                spellList.add(spellFactory.create("FIRE SHIELD"));
                spellList.add(spellFactory.create("FRENZY"));
                spellList.add(spellFactory.create("INFERNO"));
                spellList.add(spellFactory.create("SLAYER"));
                spellList.add(spellFactory.create("SACRIFICE"));
                spellList.add(spellFactory.create("SUMMON FIRE ELEMENTAL"));
            case "AIR":
                spellList.add(spellFactory.create("MAGIC ARROW"));
                spellList.add(spellFactory.create("VISIONS"));
                spellList.add(spellFactory.create("HASTE"));
                spellList.add(spellFactory.create("VIEW AIR"));
                spellList.add(spellFactory.create("DISGUISE"));
                spellList.add(spellFactory.create("DISRUPTING RAY"));
                spellList.add(spellFactory.create("FORTUNE"));
                spellList.add(spellFactory.create("LIGHTNING BOLT"));
                spellList.add(spellFactory.create("PRECISION"));
                spellList.add(spellFactory.create("PROTECTION FROM AIR"));
                spellList.add(spellFactory.create("AIR SHIELD"));
                spellList.add(spellFactory.create("DESTROY UNDEAD"));
                spellList.add(spellFactory.create("HYPNOTIZE"));
                spellList.add(spellFactory.create("CHAIN LIGHTNING"));
                spellList.add(spellFactory.create("COUNTERSTRIKE"));
                spellList.add(spellFactory.create("DIMENSION DOOR"));
                spellList.add(spellFactory.create("FLY"));
                spellList.add(spellFactory.create("MAGIC MIROR"));
                spellList.add(spellFactory.create("SUMMON AIR ELEMENTAL"));
                spellList.add(spellFactory.create("TITAN'S LIGHTNING BOLT"));
            case "EARTH":
                spellList.add(spellFactory.create("MAGIC ARROW"));
                spellList.add(spellFactory.create("VISIONS"));
                spellList.add(spellFactory.create("SHIELD"));
                spellList.add(spellFactory.create("SLOW"));
                spellList.add(spellFactory.create("STONE SKIN"));
                spellList.add(spellFactory.create("VIEW EARTH"));
                spellList.add(spellFactory.create("DEATH RIPPLE"));
                spellList.add(spellFactory.create("QUICKSAND"));
                spellList.add(spellFactory.create("ANIMATE DEAD"));
                spellList.add(spellFactory.create("ANTI-MAGIC"));
                spellList.add(spellFactory.create("EARTHQUAKE"));
                spellList.add(spellFactory.create("FORCE FIELD"));
                spellList.add(spellFactory.create("PROTECTION FROM EARTH"));
                spellList.add(spellFactory.create("METEOR SHOWER"));
                spellList.add(spellFactory.create("RESURRECTION"));
                spellList.add(spellFactory.create("HASSORROWTE"));
                spellList.add(spellFactory.create("TOWN PORTAL"));
                spellList.add(spellFactory.create("IMPLOSION"));
                spellList.add(spellFactory.create("SUMMON EARTH ELEMENTAL"));
            case "WATER":
                spellList.add(spellFactory.create("MAGIC ARROW"));
                spellList.add(spellFactory.create("VISIONS"));
                spellList.add(spellFactory.create("CURE"));
                spellList.add(spellFactory.create("DISPEL"));
                spellList.add(spellFactory.create("BLESS"));
                spellList.add(spellFactory.create("PROTECTION FROM WATER"));
                spellList.add(spellFactory.create("SUMMON BOAT"));
                spellList.add(spellFactory.create("ICE BOLT"));
                spellList.add(spellFactory.create("REMOVE OBSTACLE"));
                spellList.add(spellFactory.create("SCULTTLE BOAT"));
                spellList.add(spellFactory.create("WEAKNESS"));
                spellList.add(spellFactory.create("FORGETFULNESS"));
                spellList.add(spellFactory.create("FROST RING"));
                spellList.add(spellFactory.create("MIRTH"));
                spellList.add(spellFactory.create("TELEPORT"));
                spellList.add(spellFactory.create("CLONE"));
                spellList.add(spellFactory.create("PRAYER"));
                spellList.add(spellFactory.create("WATER WALK"));
                spellList.add(spellFactory.create("SUMMON WATER ELEMENTAL"));
            default:
                throw new IllegalArgumentException(EXCEPTION);
        }
        return spellList;
    }

    protected List<Spell> createSpellsByTier(int aTier){
        List<Spell> spellList = new ArrayList<>();
        switch (aTier) {
            case 5:
                spellList.add(spellFactory.create("DIMENSION DOOR"));
                spellList.add(spellFactory.create("FLY"));
                spellList.add(spellFactory.create("MAGIC MIRROR"));
                spellList.add(spellFactory.create("SUMOMON AIR ELEMENTAL"));
                spellList.add(spellFactory.create("TITAN'S LIGHTNING BOLT"));
                spellList.add(spellFactory.create("IMPLOSION"));
                spellList.add(spellFactory.create("SUMMON EARTH ELEMENTAL"));
                spellList.add(spellFactory.create("SACRIFICE"));
                spellList.add(spellFactory.create("SUMMON FIRE ELEMENTAL"));
                spellList.add(spellFactory.create("SUMMON WATER ELEMENTAL"));
            default:
                throw new IllegalArgumentException(EXCEPTION);
        }
        return spellList;
    }
}
