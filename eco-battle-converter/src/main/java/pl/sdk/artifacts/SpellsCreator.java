package pl.sdk.artifacts;

import pl.sdk.spells.Spell;
import pl.sdk.spells.SpellFactory;

import java.util.ArrayList;
import java.util.List;

public class SpellsCreator {
    private final SpellFactory spellFactory = new SpellFactory();
    private final String EXCEPTION = "Cannot create spells with that magic type or tier";
    private final String FIRE = "FIRE";
    private final String AIR = "AIR";
    private final String WATER = "WATER";
    private final String EARTH = "EARTH";


    protected List<Spell> createSpellsByMagicType(String aMagicType){
        List<Spell> spellList = new ArrayList<>();
        switch (aMagicType){
//            case FIRE:
//                spellList.add(spellFactory.create(MAGIC_ARROW));
//                spellList.add(spellFactory.create(VISIONS));
//                spellList.add(spellFactory.create(BLOODLUST));
//                spellList.add(spellFactory.create(CURSE));
//                spellList.add(spellFactory.create(PROTECTION_FROM_FIRE));
//                spellList.add(spellFactory.create(BLIND));
//                spellList.add(spellFactory.create(FIRE_WALL));
//                spellList.add(spellFactory.create(FIREBALL));
//                spellList.add(spellFactory.create(LAND_MINE));
//                spellList.add(spellFactory.create(MISFORTUNE));
//                spellList.add(spellFactory.create(ARMAGEDDON));
//                spellList.add(spellFactory.create(BERSERK));
//                spellList.add(spellFactory.create(FIRE_SHIELD));
//                spellList.add(spellFactory.create(FRENZY);
//                spellList.add(spellFactory.create(INFERNO));
//                spellList.add(spellFactory.create(SLAYER));
//                spellList.add(spellFactory.create(SACRIFICE));
//                spellList.add(spellFactory.create(SUMMON_FIRE_ELEMENTAL));
//            case AIR:
//                spellList.add(spellFactory.create(MAGIC_ARROW));
//                spellList.add(spellFactory.create(VISIONS));
//                spellList.add(spellFactory.create(HASTE));
//                spellList.add(spellFactory.create(VIEW_AIR));
//                spellList.add(spellFactory.create(DISGUISE));
//                spellList.add(spellFactory.create(DISRUPTING_RAY));
//                spellList.add(spellFactory.create(FORTUNE));
//                spellList.add(spellFactory.create(LIGHTNING_BOLT));
//                spellList.add(spellFactory.create(PRECISION));
//                spellList.add(spellFactory.create(PROTECTION_FROM_AIR));
//                spellList.add(spellFactory.create(AIR_SHIELD));
//                spellList.add(spellFactory.create(DESTROY_UNDEAD));
//                spellList.add(spellFactory.create(HYPNOTIZE));
//                spellList.add(spellFactory.create(CHAIN_LIGHTNING));
//                spellList.add(spellFactory.create(COUNTERSTRIKE));
//                spellList.add(spellFactory.create(DIMENSION_DOOR));
//                spellList.add(spellFactory.create(FLY));
//                spellList.add(spellFactory.create(MAGIC_MIROR));
//                spellList.add(spellFactory.create(SUMMON_AIR_ELEMENTAL));
//                spellList.add(spellFactory.create(TITANS_LIGHTNING_BOLT));
//            case EARTH:
//                spellList.add(spellFactory.create(MAGIC_ARROW));
//                spellList.add(spellFactory.create(VISIONS));
//                spellList.add(spellFactory.create(SHIELD));
//                spellList.add(spellFactory.create(SLOW));
//                spellList.add(spellFactory.create(STONE SKIN));
//                spellList.add(spellFactory.create(VIEW_EARTH));
//                spellList.add(spellFactory.create(DEATH_RIPPLE));
//                spellList.add(spellFactory.create(QUICKSAND));
//                spellList.add(spellFactory.create(ANIMATE_DEAD));
//                spellList.add(spellFactory.create(ANTI_MAGIC));
//                spellList.add(spellFactory.create(EARTHQUAKE));
//                spellList.add(spellFactory.create(FORCE_FIELD));
//                spellList.add(spellFactory.create(PROTECTION_FROM_EARTH));
//                spellList.add(spellFactory.create(METEOR_SHOWER));
//                spellList.add(spellFactory.create(RESURRECTION));
//                spellList.add(spellFactory.create(HASSORROWTE));
//                spellList.add(spellFactory.create(TOWN PORTAL));
//                spellList.add(spellFactory.create(IMPLOSION));
//                spellList.add(spellFactory.create(SUMMON_EARTH_ELEMENTAL));
//            case WATER:
//                spellList.add(spellFactory.create(MAGIC_ARROW));
//                spellList.add(spellFactory.create(VISIONS));
//                spellList.add(spellFactory.create(CURE));
//                spellList.add(spellFactory.create(DISPEL));
//                spellList.add(spellFactory.create(BLESS));
//                spellList.add(spellFactory.create(PROTECTION_FROM_WATER));
//                spellList.add(spellFactory.create(SUMMON_BOAT));
//                spellList.add(spellFactory.create(ICE_BOLT));
//                spellList.add(spellFactory.create(REMOVE_OBSTACLE));
//                spellList.add(spellFactory.create(SCULTTLE_BOAT));
//                spellList.add(spellFactory.create(WEAKNESS));
//                spellList.add(spellFactory.create(FORGETFULNESS));
//                spellList.add(spellFactory.create(FROST_RING));
//                spellList.add(spellFactory.create(MIRTH));
//                spellList.add(spellFactory.create(TELEPORT));
//                spellList.add(spellFactory.create(CLONE));
//                spellList.add(spellFactory.create(PRAYER));
//                spellList.add(spellFactory.create(WATER_WALK));
//                spellList.add(spellFactory.create(SUMMON_WATER_ELEMENTAL));
            default:
                throw new IllegalArgumentException(EXCEPTION);
        }
//        return spellList;
    }

    protected List<Spell> createSpellsByTier(int aTier){
        List<Spell> spellList = new ArrayList<>();
        switch (aTier) {
            case 5:
//                spellList.add(spellFactory.create(DIMENSION_DOOR));
//                spellList.add(spellFactory.create(FLY));
//                spellList.add(spellFactory.create(MAGIC_MIRROR));
//                spellList.add(spellFactory.create(SUMOMON_AIR_ELEMENTAL));
//                spellList.add(spellFactory.create(TITANS_LIGHTNING_BOLT));
//                spellList.add(spellFactory.create(IMPLOSION));
//                spellList.add(spellFactory.create(SUMMON_EARTH_ELEMENTAL));
//                spellList.add(spellFactory.create(SACRIFICE));
//                spellList.add(spellFactory.create(SUMMON_FIRE_ELEMENTAL));
//                spellList.add(spellFactory.create(SUMMON_WATER_ELEMENTAL));
            default:
                throw new IllegalArgumentException(EXCEPTION);
        }
//        return spellList;
    }
}
