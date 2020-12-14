package pl.sdk.creatures;

import com.google.common.collect.Range;

enum CreatureStatistic implements CreatureStatisticIf{

    // TEST CREATURES
    TEST("name",2,1,10,1,Range.closed(2,2),0,"for unit testing",false),

    // NECROPILIS FRACTION
    SKELETON("Skeleton",5,4,6,4,Range.closed(1,3),1,"Average lvl1 foot soldier, but always in huge numbers thanks to necromancy skill and skeleton transformer.",false),
    WALKING_DEAD("Walking Dead",5,5,15,3,Range.closed(2,3),2,"Basically its the same skeleton with more hit points. I prefer buying 2 skeletons instead.",false),
    WIGHT("Wight",7,7,18,5,Range.closed(3,5),3,"Regenerating ability is really good when fighting weak enemies, especially shooters.\nSpecial: top wight of the stack regenerates all lost damage in the beginning of each round",false),
    VAMPIRE("Vampire",10,9,30,6,Range.closed(5,8),4,"NOTHING compared to their upgraded brothers. Keep the population growing and recruit after the upgrade.\nSpecial: no enemy retaliation.",false),
    LICH("Lich",13,10,30,6,Range.closed(11,15),5,"Now they last longer and are able to do more damage! A must for good necropolis army.\nSpecial: death cloud range attack - damages living creatures on adjacent hexes to target.\n",false),
    BLACK_KNIGHT("Black Knight",16,16,120,7,Range.closed(15,30),6,"Awesome ground unit. As any undead it cannot be blinded, so your enemies will have to look out.\nSpecial: 20% chance to curse enemy.\n",false),
    BONE_DRAGON("Bone Dragon",17,15,150,9,Range.closed(25,50),7,"They are truly fearsome for enemies with low morale. Simply keeping them on battlefield scares enemies.\nSpecial: -1 to enemy morale.\n",false),
    SKELETON_WARRIOR("Skeleton Warrior",6,6,6,5,Range.closed(1,3),1,"Numerous skeletons become even better, but running back to town and upgrading is a problem... If there is no room in your army for ordinary skeletons, necromancy skill will resurrect skeleton warriors, but there will be less of them than normal skeletons, so it might be a good idea not to upgrade cursed temple at all.",true),
    ZOMBIE("Zombie",5,5,20,4,Range.closed(2,3),2,"Attack ratings are way too low... In my opinion, necropolis has the worst lvl2 creature.\nSpecial: 20% chance to disease enemies (-2Att -2Def for 3 rounds)\n",true),
    WRAITH("Wraith",7,7,18,5,Range.closed(3,5),3,"Regenerating ability is really good when fighting weak enemies, especially shooters.\nSpecial: top wight of the stack regenerates all lost damage in the beginning of each round\n",true),
    VAMPIRE_LORD("Vampire Lord",10,10,40,9,Range.closed(5,8),4,"My favorite necropolis unit. Use them as main striking unit and you might end up with no losses!\nSpecial: no enemy retaliation ; resurrects members of their own stack by restoring health equal to the amount of damage they do to living enemies.\n",true),
    POWER_LICH("Power Lich",13,10,40,7,Range.closed(11,15),5,"Now they last longer and are able to do more damage! A must for good necropolis army.\nSpecial: death cloud range attack - damages living creatures on adjacent hexes to target.\n",true),
    DREAD_KNIGHT("Dread Knight",18,18,120,9,Range.closed(15,30),6,"I think it's the best lvl6 unit in the game! Double damage ability puts Dread Knights above Naga Queens.\nSpecial: 20% chance to curse enemy ; 20% chance to do double damage.\n",true),
    GHOST_DRAGON("Ghost Dragon",19,17,200,14,Range.closed(25,50),7,"When situation seems hopeless, take a chance on the best enemy stack! If you'll get lucky, half their hit points will be gone instantly!! Ageing ability makes ghost dragons as dangerous as other lvl7 creatures.\nSpecial: -1 to enemy morale ; 20% chance to age enemy (halve hit points of all stack members).\n",true),

    // CASTLE FRACTION
    PIKEMAN("Pikeman",4,5,10,4,Range.closed(1,3),1, "Toughest lvl1 unit, but a bit slow.", false),
    HALBERDIER("Halberdier", 6,5,10,5,Range.closed(2,3),1, "Now they are faster and do more damage. Will make a good defence for shooters.\n", true),
    ARCHER("Archer",6, 3,10,4, Range.closed(2,3),2, "Archer's upgrade is literally 2 times better. Upgrade them quickly.\n", false),
    MARKSMAN("Marksman", 6,3,10,6,Range.closed(2,3),2 ,"Special: Fires 2 shots per ranged attack. Awesome upgrade, but they still lack defence...\n", true),
    GRIFFIN("Griffin",8,8,25,6, Range.closed(3,6),3, "Special: can retaliate against 2 attacks per turn. High in population, griffins become castle's main unit for the midgame.\n", false),
    ROYAL_GRIFFIN("Royal Griffin", 9,9,25,9, Range.closed(3,6), 3, "Special: unlimited retaliations. Send them right in the middle of the battlefield. Everyone who comes will get some ;)\n", true),
    SWORDSMAN("Swordsman",10, 12,35,5, Range.closed(6,9), 4, "Not too good unit the upgrade and also too slow.\n", false),
    CRUSADER("Crusader", 12,12,35,6, Range.closed(7,10), 4, "Special: attacks twice. Good upgrade, but still lacks speed. Seem undefeatable in large numbers.\n", true),
    MONK("Monk",12,7,30,5, Range.closed(10,12),5, "Good shooter, nice damage.\n", false),
    ZEALOT("Zealot", 12,10,30,7, Range.closed(10,12), 5, "Special: no penalty for hand-to-hand attacks. Zealots are skilled enough to use the same magic powers at very close range. Better defence too.\n", true),
    CAVALIER("Cavalier", 15, 15, 100, 7, Range.closed(15,25), 6, "Special: +5% damage for each hex traveled to creature attacked. Make sure that the path is as long as possible - they need some speed!\n", false),
    CHAMPION("Champion", 16,16,100,9, Range.closed(20,25), 6, "Special: +5% damage for each hex traveled to creature attacked. That's up to 45% extra damage possible! Champions also have better aiming skills.\n", true),
    ANGEL("Angel", 20,20,200,12, Range.closed(50,50), 7, "Special: 150% damage to devils. Nice combat ratings and great constant damage - no need to bless them. Note that before the update patches Angels and Archangels didn't cost any gems, just gold. This has been added to try to balance the castle a little. I think it's still too powerful.\n", false),
    ARCHANGEL("Archangel",30,30,250,18, Range.closed(50,50), 7, "Special: 150% damage to devils ; Resurrect dead allied troops once per combat. Best attack, defence and speed in a whole game! Resurrection is a very convenient abbility. Those fast wings take up a whole extra hex! :] Possibly the best creature in the game.\n", true),

    // TOWER FRACTION
    GREMLIN("Gremlin",3,3,4,4, Range.closed(1,2), 1, "Gremlins are only better than imps... cheap and plentiful too, but slow and weak in all aspects. If you have quite a lot of them, enemy may be very surprised how much damage gremlins can do. Upgrade is awesome.\n", false),
    MASTER_GREMLIN("Master Gremlin",4,4,4,5, Range.closed(1,2), 1, "Master gremlins are the only level one shooters (except for halflings in AB) and provide a great advantage in early stages of the game, thank god the gremlin rush desn't work anymore, it was unstoppable. Otherways, awesome upgrade, but keep the ammo cart handy, these guys have only 8 shots. They do have a hand-to-hand penalty, so try to block them.\n", true),
    STONE_GARGOYLE("Stone Gargoyle",6,6,16,6, Range.closed(2,3), 2 , "Special: non-living. Not a very good fighter, but quite useful for preventing enemy shooters from using their range attacks.\n", false),
    OBSIDIAN_GARGOYLE("Obsidian Gargoyle", 7,7,16,9, Range.closed(2,3),2, "Special: non-living. 30 Gold for 3 extra speed and 1 attack and defence... not a good upgrade, but makes them better shooter-blockers. I would prefer to save money for golems who will last a whole lot longer. Recruit gargoyles only when you are quite desperate for army.\n", true),
    STONE_GOLEM("Stone Golem", 7,10,30, 3, Range.closed(4,5), 3, "Special: non-living, take 50% damage from spells. Great town defenders because spells just don't take them that easy! Too slow for heroes though, that's what upgrade is for.\n", false),
    IRON_GOLEM("Iron Golem", 9,10,35,5, Range.closed(4,5),3, "Special: non-living, take 25% damage from spells. Great upgrade! Speed is usable for hero armies while extra hit points and magic resistance make them even tougher. Only a foolish player will cast offensive spells on iron golems, only a quarter damage will get through. Iron golems are great to defend shooters.\n", true),
    MAGE("Mage", 11,8,25,5, Range.closed(7,9), 4, "Special: no hand-to hand penalty, hero spells cost -2 mana. Good offensive shooters, but even though they suffer no hand-to-hand penalty, keep them defended because their hit points and defence are low. Spell bonus is great! Magic arrows cost 2 mana! Note that when all magi on the battlefield are dead, spell bonus disappears.\n", false),
    ARCH_MAGE("Arch Mage",12,9,30,7,Range.closed(7,9),4, "Special: no hand-to hand penalty, hero spells cost -2 mana, no penalty for shooting through seige walls. Reasonable upgrade adds speed, improves defensive ratings and wall penetration will decrease the range penalty in seige attacks.\n", true),
    GENIE("Genie",12,12,40,7, Range.closed(13,16),5, "Special: 150% damage to efreet. Offensive unit with big lack of hit points, do not attack unless it will destroy the target. I would prefer 1 naga instead of 2 genies.\n", false),
    MASTER_GENIE("Master Genie",12,12,40,11, Range.closed(13,16),5 , "Special: 150% damage to efreet, can cast random beneficial spells on allied stacks with spell power of 6 at advanced spell level (spells are not totally ridiculously chosen though, ex: will not cast prot. from water when fighting wandering creatures).", true),
    NAGA("Naga",16,13,110,5,Range.closed(20,20), 6, "Special: no enemy retaliation. Nagas and naga queens are necromancer's black and dread knights' toughest competitors for the first place amongst the level 6 units. Nothing to comment really, this unit is great all around, just don't bother blessing or cursing that great constant damage.\n", false),
    NAGA_QUEEN("Naga Queen",16,13,110,7, Range.closed(30,30), 6, "Special: no enemy retaliation. Extra speed and extra 50% of that constant damage are worth the extra 500 gold that make naga queen the most expensive in level 6.\n", true),
    GIANT("Giant", 19,16,150,7,Range.closed(40,60), 7, "Special: immune to mind-affecting spells. Their damage is great, especially if blessed. Their dwelling is really cheap compared to other level 7 dwellings. The only drawback is the gem cost. Anyway, a good unit to recruit and upgrade later in the game. Nagas and giants make a hardly beatable ground attack force.\n", false),
    TITAN("Titan", 24,24,300,11,Range.closed(40,60), 7, "Special: immune to mind-affecting spells, no hand-to-hand penalty, do 150% damage to black dragons.", true);


    private final String name;
    private final int attack;
    private final int armor;
    private final int maxHp;
    private final int moveRange;
    private final Range<Integer> damage;
    private final int tier;
    private final String description;
    private final boolean isUpgraded;

    CreatureStatistic(String aName, int aAttack, int aArmor, int aMaxHp, int aMoveRange, Range<Integer> aDamage, int aTier, String aDescription, boolean aIsUpgraded) {
        name = aName;
        attack = aAttack;
        armor = aArmor;
        maxHp = aMaxHp;
        moveRange = aMoveRange;
        damage = aDamage;
        tier = aTier;
        description = aDescription;
        isUpgraded = aIsUpgraded;
    }

    public String getTranslatedName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getArmor() {
        return armor;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getMoveRange() {
        return moveRange;
    }

    public Range<Integer> getDamage(){
        return damage;
    }

    public int getTier() {
        return tier;
    }

    public String getDescription() {
        return description;
    }

    boolean isUpgraded() {
        return isUpgraded;
    }
}
