package pl.sdk.creatures;

import com.google.common.collect.Range;

enum CreatureStatistic implements CreatureStatisticIf{

    // TEST CREATURES
    TEST("name",2,2,10,1,Range.closed(2,2),0,"for unit testing", "ground",false, "NECROPOLIS"),



    // NECROPOLIS FRACTION
    SKELETON("Skeleton",5,4,6,4,Range.closed(1,3),1,"Average lvl1 foot soldier, but always in huge numbers thanks to necromancy skill and skeleton transformer.", "ground",false, "NECROPOLIS"),
    WALKING_DEAD("Walking Dead",5,5,15,3,Range.closed(2,3),2,"Basically its the same skeleton with more hit points. I prefer buying 2 skeletons instead.", "ground",false, "NECROPOLIS"),
    WIGHT("Wight",7,7,18,5,Range.closed(3,5),3,"Regenerating ability is really good when fighting weak enemies, especially shooters.Special: top wight of the stack regenerates all lost damage in the beginning of each round", "flying",false, "NECROPOLIS"),
    VAMPIRE("Vampire",10,9,30,6,Range.closed(5,8),4,"NOTHING compared to their upgraded brothers. Keep the population growing and recruit after the upgrade. Special: no enemy retaliation.", "flying",false, "NECROPOLIS"),
    LICH("Lich",13,10,30,6,Range.closed(11,15),5,"Now they last longer and are able to do more damage! A must for good necropolis army.Special: death cloud range attack - damages living creatures on adjacent hexes to target.", "ground",false, "NECROPOLIS"),
    BLACK_KNIGHT("Black Knight",16,16,120,7,Range.closed(15,30),6,"Awesome ground unit. As any undead it cannot be blinded, so your enemies will have to look out. Special: 20% chance to curse enemy.", "ground",false, "NECROPOLIS"),
    BONE_DRAGON("Bone Dragon",17,15,150,9,Range.closed(25,50),7,"They are truly fearsome for enemies with low morale. Simply keeping them on battlefield scares enemies.Special: -1 to enemy morale.", "flying",false, "NECROPOLIS"),
    SKELETON_WARRIOR("Skeleton Warrior",6,6,6,5,Range.closed(1,3),1,"Numerous skeletons become even better, but running back to town and upgrading is a problem... If there is no room in your army for ordinary skeletons, necromancy skill will resurrect skeleton warriors, but there will be less of them than normal skeletons, so it might be a good idea not to upgrade cursed temple at all.", "ground",true, "NECROPOLIS"),
    ZOMBIE("Zombie",5,5,20,4,Range.closed(2,3),2,"Attack ratings are way too low... In my opinion, necropolis has the worst lvl2 creature.Special: 20% chance to disease enemies (-2Att -2Def for 3 rounds)", "ground",true, "NECROPOLIS"),
    WRAITH("Wraith",7,7,18,5,Range.closed(3,5),3,"Regenerating ability is really good when fighting weak enemies, especially shooters. Special: top wight of the stack regenerates all lost damage in the beginning of each round", "ground",true, "NECROPOLIS"),
    VAMPIRE_LORD("Vampire Lord",10,10,40,9,Range.closed(5,8),4,"My favorite necropolis unit. Use them as main striking unit and you might end up with no losses!Special: no enemy retaliation ; resurrects members of their own stack by restoring health equal to the amount of damage they do to living enemies.\n", "flying",true, "NECROPOLIS"),
    POWER_LICH("Power Lich",13,10,40,7,Range.closed(11,15),5,"Now they last longer and are able to do more damage! A must for good necropolis army.Special: death cloud range attack - damages living creatures on adjacent hexes to target.", "ground",true, "NECROPOLIS"),
    DREAD_KNIGHT("Dread Knight",18,18,120,9,Range.closed(15,30),6,"I think it's the best lvl6 unit in the game! Double damage ability puts Dread Knights above Naga Queens.Special: 20% chance to curse enemy ; 20% chance to do double damage.", "ground",true, "NECROPOLIS"),
    GHOST_DRAGON("Ghost Dragon",19,17,200,14,Range.closed(25,50),7,"When situation seems hopeless, take a chance on the best enemy stack! If you'll get lucky, half their hit points will be gone instantly!! Ageing ability makes ghost dragons as dangerous as other lvl7 creatures.Special: -1 to enemy morale ; 20% chance to age enemy (halve hit points of all stack members).\n", "flying",true, "NECROPOLIS"),

    // CASTLE FRACTION
    PIKEMAN("Pikeman",4,5,10,4,Range.closed(1,3),1, "Toughest lvl1 unit, but a bit slow.", "ground", false, "CASTLE"),
    HALBERDIER("Halberdier", 6,5,10,5,Range.closed(2,3),1, "Now they are faster and do more damage. Will make a good defence for shooters.", "ground", true, "CASTLE"),
    ARCHER("Archer",6, 3,10,4, Range.closed(2,3),2, "Archer's upgrade is literally 2 times better. Upgrade them quickly.", "ground", false, "CASTLE"),
    MARKSMAN("Marksman", 6,3,10,6,Range.closed(2,3),2 ,"Special: Fires 2 shots per ranged attack. Awesome upgrade, but they still lack defence...", "ground",true, "CASTLE"),
    GRIFFIN("Griffin",8,8,25,6, Range.closed(3,6),3, "Special: can retaliate against 2 attacks per turn. High in population, griffins become castle's main unit for the midgame.", "flying", false, "CASTLE"),
    ROYAL_GRIFFIN("Royal Griffin", 9,9,25,9, Range.closed(3,6), 3, "Special: unlimited retaliations. Send them right in the middle of the battlefield. Everyone who comes will get some ;)", "flying", true, "CASTLE"),
    SWORDSMAN("Swordsman",10, 12,35,5, Range.closed(6,9), 4, "Not too good unit the upgrade and also too slow.", "ground", false, "CASTLE"),
    CRUSADER("Crusader", 12,12,35,6, Range.closed(7,10), 4, "Special: attacks twice. Good upgrade, but still lacks speed. Seem undefeatable in large numbers.", "ground", true, "CASTLE"),
    MONK("Monk",12,7,30,5, Range.closed(10,12),5, "Good shooter, nice damage.", "ground",false, "CASTLE"),
    ZEALOT("Zealot", 12,10,30,7, Range.closed(10,12), 5, "Special: no penalty for hand-to-hand attacks. Zealots are skilled enough to use the same magic powers at very close range. Better defence too.", "ground", true, "CASTLE"),
    CAVALIER("Cavalier", 15, 15, 100, 7, Range.closed(15,25), 6, "Special: +5% damage for each hex traveled to creature attacked. Make sure that the path is as long as possible - they need some speed!", "ground", false, "CASTLE"),
    CHAMPION("Champion", 16,16,100,9, Range.closed(20,25), 6, "Special: +5% damage for each hex traveled to creature attacked. That's up to 45% extra damage possible! Champions also have better aiming skills.", "ground", true, "CASTLE"),
    ANGEL("Angel", 20,20,200,12, Range.closed(50,50), 7, "Special: 150% damage to devils. Nice combat ratings and great constant damage - no need to bless them. Note that before the update patches Angels and Archangels didn't cost any gems, just gold. This has been added to try to balance the castle a little. I think it's still too powerful.", "flying", false, "CASTLE"),
    ARCHANGEL("Archangel",30,30,250,18, Range.closed(50,50), 7, "Special: 150% damage to devils ; Resurrect dead allied troops once per combat. Best attack, defence and speed in a whole game! Resurrection is a very convenient abbility. Those fast wings take up a whole extra hex! :] Possibly the best creature in the game.", "flying",true, "CASTLE"),

    // TOWER FRACTION
    GREMLIN("Gremlin",3,3,4,4, Range.closed(1,2), 1, "Gremlins are only better than imps... cheap and plentiful too, but slow and weak in all aspects. If you have quite a lot of them, enemy may be very surprised how much damage gremlins can do. Upgrade is awesome.", "ground", false , "TOWER"),
    MASTER_GREMLIN("Master Gremlin",4,4,4,5, Range.closed(1,2), 1, "Master gremlins are the only level one shooters (except for halflings in AB) and provide a great advantage in early stages of the game, thank god the gremlin rush desn't work anymore, it was unstoppable. Otherways, awesome upgrade, but keep the ammo cart handy, these guys have only 8 shots. They do have a hand-to-hand penalty, so try to block them.", "ground", true, "TOWER"),
    STONE_GARGOYLE("Stone Gargoyle",6,6,16,6, Range.closed(2,3), 2 , "Special: non-living. Not a very good fighter, but quite useful for preventing enemy shooters from using their range attacks.", "flying", false, "TOWER"),
    OBSIDIAN_GARGOYLE("Obsidian Gargoyle", 7,7,16,9, Range.closed(2,3),2, "Special: non-living. 30 Gold for 3 extra speed and 1 attack and defence... not a good upgrade, but makes them better shooter-blockers. I would prefer to save money for golems who will last a whole lot longer. Recruit gargoyles only when you are quite desperate for army.", "flying", true, "TOWER"),
    STONE_GOLEM("Stone Golem", 7,10,30, 3, Range.closed(4,5), 3, "Special: non-living, take 50% damage from spells. Great town defenders because spells just don't take them that easy! Too slow for heroes though, that's what upgrade is for.", "ground",false, "TOWER"),
    IRON_GOLEM("Iron Golem", 9,10,35,5, Range.closed(4,5),3, "Special: non-living, take 25% damage from spells. Great upgrade! Speed is usable for hero armies while extra hit points and magic resistance make them even tougher. Only a foolish player will cast offensive spells on iron golems, only a quarter damage will get through. Iron golems are great to defend shooters.", "ground", true, "TOWER"),
    MAGE("Mage", 11,8,25,5, Range.closed(7,9), 4, "Special: no hand-to hand penalty, hero spells cost -2 mana. Good offensive shooters, but even though they suffer no hand-to-hand penalty, keep them defended because their hit points and defence are low. Spell bonus is great! Magic arrows cost 2 mana! Note that when all magi on the battlefield are dead, spell bonus disappears.", "ground", false, "TOWER"),
    ARCH_MAGE("Arch Mage",12,9,30,7,Range.closed(7,9),4, "Special: no hand-to hand penalty, hero spells cost -2 mana, no penalty for shooting through seige walls. Reasonable upgrade adds speed, improves defensive ratings and wall penetration will decrease the range penalty in seige attacks.", "ground", true, "TOWER"),
    GENIE("Genie",12,12,40,7, Range.closed(13,16),5, "Special: 150% damage to efreet. Offensive unit with big lack of hit points, do not attack unless it will destroy the target. I would prefer 1 naga instead of 2 genies.", "flying", false, "TOWER"),
    MASTER_GENIE("Master Genie",12,12,40,11, Range.closed(13,16),5 , "Special: 150% damage to efreet, can cast random beneficial spells on allied stacks with spell power of 6 at advanced spell level (spells are not totally ridiculously chosen though, ex: will not cast prot. from water when fighting wandering creatures).", "flying",true, "TOWER"),
    NAGA("Naga",16,13,110,5,Range.closed(20,20), 6, "Special: no enemy retaliation. Nagas and naga queens are necromancer's black and dread knights' toughest competitors for the first place amongst the level 6 units. Nothing to comment really, this unit is great all around, just don't bother blessing or cursing that great constant damage.", "ground", false, "TOWER"),
    NAGA_QUEEN("Naga Queen",16,13,110,7, Range.closed(30,30), 6, "Special: no enemy retaliation. Extra speed and extra 50% of that constant damage are worth the extra 500 gold that make naga queen the most expensive in level 6.", "ground", true, "TOWER"),
    GIANT("Giant", 19,16,150,7,Range.closed(40,60), 7, "Special: immune to mind-affecting spells. Their damage is great, especially if blessed. Their dwelling is really cheap compared to other level 7 dwellings. The only drawback is the gem cost. Anyway, a good unit to recruit and upgrade later in the game. Nagas and giants make a hardly beatable ground attack force.", "ground", false, "TOWER"),
    TITAN("Titan", 24,24,300,11,Range.closed(40,60), 7, "Special: immune to mind-affecting spells, no hand-to-hand penalty, do 150% damage to black dragons.",  "ground",true, "TOWER"),

    //INFERNO FRACTION
    IMP("Imp",2,3,4,5, Range.closed(1,2), 1, "Weakest level 1 unit in Heroes 3 which is also quite expensive. Useless all around :)", "ground", false, "INFERNO"),
    FAMILIAR("Familiar", 4,4,4,7, Range.closed(1,2), 1, "Special: 20% of mana spent by enemy hero on spells will be chanelled into your hero's mana pool. Upgrade is well worth doing: attack and defence become closer to medium for level 1, good speed and the mana chanelling abbility which makes it somewhat worthy having familiars present at the long battles. Think about it: he spends 20 mana and you'll get 4! Damage range does not reach 3 which is a big disadvantage. If you get the grail, you can get hordes of these guys :)", "ground", true, "INFERNO"),
    GOG("Gog",6,4,13,4, Range.closed(2,4), 2, "Very good shooter, nice damage range and hit points are a meaningful number to them. Speed is too slow before upgraded though.", "ground", false, "INFERNO"),
    MAGOG("Magog",7,4,13,6, Range.closed(2,4), 2, "Special: ranged attack also affects adjacent hexes with fire damage. Magog cannot beat marksman's two shots, but if enemies are standing close together, the advantage can be even grater. Note that fireproof units do not suffer magog's adjacent damage.", "ground",true, "INFERNO"),
    HELL_HOUND("Hell Hound",10,6,25,7, Range.closed(2,7), 3, "Good offensive unit, low on defence. Strongly affected by bless and curse spells.", "ground", false, "INFERNO"),
    CERBERUS("Cerberus",10,8,25,8, Range.closed(2,7), 3, "Special: can attack 3 adjacent enemies at once, no enemy retaliation. Great upgrade. This is the only case in the game where stats get downgraded, damage in this case because this damage can be done to 3 enemies at once. Better defence and with no retaliation it's a good idea to charge and attack the crowd.\n", "ground", true, "INFERNO"),
    DEAMON("Deamon",10,10,35,5,Range.closed(7,9), 4, "Average unit for level 4, but the price is very reasonable.", "ground", false, "INFERNO"),
    HORNED_DEAMON("Horned Deamon", 10,10,40,6, Range.closed(7,9), 4, "One of the smallest upgrades in the game: 5 hit points and 1 speed for 20 gold... reasonable, but horned demons are now below-average among level 4 upgrades, but their price still remains low.", "ground", true, "INFERNO"),
    PIT_FIEND("Pit Fiend",13,13,45,6, Range.closed(13,17), 5, "Not a very good level 5 creature, but costly. Demons and pit fiends kinda balance each outher out. Note how often number 13 is used :)", "ground", false, "INFERNO"),
    PIT_LORD("Pit Lord", 13,13,45,7, Range.closed(13,17),5, "Special: Can resurrect dead allied stack as demons once per combat. Number of raised demons cannot be larger than the number of pit lords performing the resurrection. Max number of demons is determined by the total hit points of the target stack.", "ground", true, "INFERNO"),
    EFREETI("Efreeti", 16,12,90,9, Range.closed(16,24), 6, "Special: Immune to fire, 150% damage vs genies. Reasonable creature, can be purchased early due to inferno's specific building plan. Good troop for armageddon spellcaster.", "flying", false, "INFERNO"),
    EFREET_SULTAN("Efrret Sultan", 16,14,90,13, Range.closed(16,24),6 , "Special: Immune to fire, 150% damage vs genies, have fire shield spell on. Excellent upgrade. Their speed is only matched by some level 7 upgrades and... dragon flies. Enemy will think well before attacking efreet sultans: portion of the damage returns back to the attacker plus the retaliation. Good to use them against high level creatures because fire shield damage will surpass their mighty defence without being decreased.", "flying", true, "INFERNO"),
    DEVIL("Devil",19,21,160,11, Range.closed(30,40), 7, "Special: no enemy retaliation, 150% damage to angels, -1 enemy luck while present on the battlefield. Makes a tough opponent because of speed and no enemy retaliation. Devil can beat an angel in one on one combat.",  "teleport",false, "INFERNO"),
    ARCH_DEVIL("Arch Devil",26,28,200,17, Range.closed(30,40), 7 , "Special: no enemy retaliation, 150% damage to angels, -1 enemy luck while present on the battlefield. Arch devil is no match for an arch angel. Otherways, a really powerful creature for non-retaliated attacks with outwaiting the opponent.", "teleport", true, "INFERNO"),

    // FORTRESS FRACTION
    GNOLL("Gnoll",3,5,6,4, Range.closed(2,3), 1, "Above-average level 1 creature with good defence ratings and damage.", "ground",false, "FORTRESS"),
    GNOLL_MARADEUR("Gnoll Maradeur",4,6,6,5, Range.closed(2,3), 1 , "1 speed, 1 attack and 1 defence for 20 gold extra? Bad upgrade looking at the value, also costs 10 wood to upgrade the dwelling, so it's not worth doing unless you're really wealthy.", "ground", true, "FORTRESS"),
    LIZARDMAN("Lizardman", 5,6,14,4,Range.closed(2,3), 2, "This table shows lizardman stats with the latest game patch applied. Originally they've had 12 hit points, 1-3 damage and population of 8. A much-needed balancing for Fortress.", "ground", false, "FORTRESS"),
    LIZARD_WARRIOR("Lizard Warrior", 6,8,15,5,Range.closed(2,5), 2, "With the latest game patch, lizard warrior cost went up from 130 to 140, attack from 5 to 6, defence from 7 to 8, health from 12 to 15 and damage from 2-3 to 2-5! So what you are getting now is quite a decent shooter with excellent health and defence. This creature upgrade is excellent value for money, so you must do it. I'm glad the balancing took place, even though fortress is still unfairly weak in the mage guild department, this goes some of the way to make it average. Bless/curse will make a lot of difference to lizard warriors.", "ground", true, "FORTRESS"),
    SERPENT_FLY("Serpent Fly",7,9,20,9, Range.closed(2,5), 3, "Special: dispels all beneficial spells on the target. Costly and weakish. Damage range is big, strongly affected by bless or curse. Attack enemies that have many beneficial spells on them, enemy will be really frustrated if he spent few rounds casting bless, haste, shiled or something like that on one creature and it all goes off in an instant.", "flying", false, "FORTRESS"),
    DRAGON_FLY("Dragon Fly",8,10,20,13,Range.closed(2,5), 3, "Special: dispels all beneficial spells on the target. Attack casts weakness on enemies. Before the patch dragon flies had no weakness special and att/def of 6/8, so the upgrade became much more reasonable. Dragon fly's speed can only be beaten by efreet sultan (he has the same speed) and some of level 7 upgrades! That means you will often be the first to cast the spell in combat (haste would be nice to keep it that way).", "flying",true, "FORTRESS"),
    BASILISK("Basilisk", 11,11,35,5,Range.closed(6,10), 4, "Special: 20% to turn target to stone, stone lasts for 3 turns, stoned enemies take 50% damage, unstoned if attacked. Finally a better creature, normal for level 4. Useful for both offence and defence. Stoning abbility can be especially nice to block the holes in your seige walls for a while with... stoned enemies!", "ground", false, "FORTRESS"),
    GREATER_BASILISK("Greater Basilisk", 12,12,40,7,Range.closed(6,10), 4, "Special: 20% to turn target to stone, stone lasts for 3 turns, stoned enemies take 50% damage, unstoned if attacked. Good upgrade, improves basilisks all-around.", "ground",true, "FORTRESS"),
    GORGON("Gorgon", 10,14,70,5,Range.closed(12,16), 5, "To compensate for the previous creatures, fortress rules in level 5. Gorgons are very tough, but try to save them until the upgrade, that's where they become extremely valuable.", "ground", false, "FORTRESS"),
    MIGHTY_GORGON("Mighty Gorgon", 11,16,70,6, Range.closed(12,16), 5, "Special: 10% chance of killing 1 top creature of enemy stack per 10 mighty gorgons attacking. One of the best upgrades in the game, we can forget the minor stats upgrades, the special abbility is awesome! Yes, even if it's an archangel commanded by a hero with 30 defence, he can die instantly from mighty gorgon's gaze.", "ground",true, "FORTRESS"),
    WYVERN("Wyvern", 14,14,70,7, Range.closed(14,18), 6, "Below-average level 6 creature. Damage is ok, but wyverns die quickly because they are the only strong flies in fortress...", "flying", false, "FORTRESS"),
    WYVERN_MONARCH("Wyvern Monarch", 14,14,70,11,Range.closed(18,22), 6, "Special: chance to poison living enemies (stack's maximum health will be reduced every turn, can be removed by cure spell). Costly upgrade raises the damage by 4 and adds a poison abbility which can be very useful to weaken a strong stack. Hit points are very low for level 6 upgrade, so use wyvern monarchs as an offensive unit to finish off the weaklings and to try to poison really strong stacks (better do that after they used their retaliation).", "flying", true, "FORTRESS"),
    HYDRA("Hydra", 16,18,175,5,Range.closed(25,45), 7, "Special: attacks all adjacent hexes, no enemy retaliation. Costs no special resources and the special abbility is one of the greatest: hydras attack all 8 hexes around them without fear of retaliation! ", "ground", false, "FORTRESS"),
    CHAOS_HYDRA("Chaos Hydra", 18,20,250,7, Range.closed(25,45), 7, "Special: attacks all adjacent hexes, no enemy retaliation. Extra 75 hit points, 2 attack and defence, but most importantly extra speed. Well, speed still remains the slowest among level 7 upgrades, but the strategic use is at it's best.", "ground", true, "FORTRESS"),

    // RAMPART FRACTION
    CENTAUR("Centaur",5,3,8,6, Range.closed(2,3), 1, "Centaurs and Centaur Captains are the best and the most expensive lvl 1 units.", "ground", false, "RAMPART"),
    CENTAUR_CAPTAIN("Centaur Captain", 6,3,10,8,Range.closed(2,3), 1, "Haliberdier kills Centaur Captain in 1 on 1 combat, but speed makes Centaur Captains better. Centaur Captains are better attackers than defenders, so attack before attacked. Good upgrade.", "ground", true, "RAMPART"),
    DWARF("Dwarf", 6,7,20,3, Range.closed(2,4), 2, "Special: 20% magic resistance. Real slowdown for your hero. Good defenders. Good for garrison shooter defence. Toughest lvl 2 units.", "ground", false, "RAMPART"),
    BATTLE_DWARF("Battle Dwarf",7,7,20,5,Range.closed(2,4), 2, "Special: 40% magic resistance. Now your hero can take them, speed will do until the endgame. Resists about 2 out of 5 spells!", "ground", true, "RAMPART"),
    WOOD_ELF("Wood Elf",9,5,15,6,Range.closed(3,5), 3, "The only shooter for Rampart. Elves are offensive units and need a good defence.", "ground", false, "RAMPART"),
    GRAND_ELF("Grand Elf",9,5,15,7,Range.closed(3,5), 3, "Special: fires two shots per attack. Awesome upgrade - doubles the attack and costs only 25 gold extra!", "ground", true, "RAMPART"),
    PEGASUS("Pegasus", 9,8,30,8, Range.closed(5,9), 4, "Special: enemy spellcasters must pay 2 extra spell points per spell when Pegasi are present. If you're short on money, 1 Pegasus is better than 3 Centaurs and more useful than 2 Dwarves.", "flying", false, "RAMPART"),
    SILVER_PEGASUS("Silver Pegasus",9,10,30,12,Range.closed(5,9),4 , "Special: enemy spellcasters must pay 2 extra spell points per spell when Silver Pegasi are present. Weakest non-shooting lvl 4 unit, but really fast and annoying to enemy spellcasters. Highest pop among lvl 4.", "flying", true, "RAMPART"),
    DENDROID_GUARD("Dendroid Guard",9,12,55,3, Range.closed(10,14), 5, "Special: creatures attacked by Dendroids are held in place by their roots until Dendroids move or are killed. Way too slow for hero's army, but excellent for garrison - Dendroid's roots will hold flies in place while Elves do their job from a very nice close-up. Worst lvl 5 unit but maximum population is the highest among lvl 5.", "ground", false, "RAMPART"),
    DENDROID_SOLDIER("Dendroid Soldier", 9, 12,65,4, Range.closed(10,14), 5, "Special: creatures attacked by Dendroids are held in place by their roots until Dendroids move or are killed. Really hard to identify the upgrade by picture, but if you look closer, Dendroid Soldiers have a few extra branches and bigger feet :) Bad upgrade: 1sp and 10hp for 75 gold! Too slow for hero, excellent for garrison.", "ground", true, "RAMPART"),
    UNICORN("Unicorn", 15,14,90,7,Range.closed(18,22), 6, "Special: 20% chance to blind enemy. Aura increases magic resistace of all adjacent creatures by 20%. Good upgrade makes unicorn an excellent lvl 6 unit with a very small price!", "ground", false, "RAMPART"),
    WAR_UNICORN("War Unicorn", 15,14,110,9, Range.closed(18,22), 6, "Special: 20% chance to blind enemy. Aura increases magic resistace of all adjacent creatures by 20%. Good upgrade makes unicorn an excellent lvl 6 unit with a very small price!", "ground", true, "RAMPART"),
    GREEN_DRAGON("Green Dragon", 18,18,180,10, Range.closed(40,50), 7, "Special: attack affects 2 hexes. Immune to spells levels 1-3. A little weaker, cheaper and slower than Red Dragon, otherways indentical.", "flying", false, "RAMPART"),
    GOLD_DRAGON("Gold Dragon",27,27,250,16, Range.closed(40,50), 7, "Special: attack affects 2 hexes. Immune to spells levels 1-4. While equal in price to Black Dragon, Gold Dragon has less immunity and hit points, but has more attack, defence and speed. Has a little weak spot for powerful enemy earth spellcasters - lvl 5 implosion.", "flying", true, "RAMPART"),

    // DUNGEON FRACTION
    TROGLODYTE("Troglodyte", 4,3,5,4,Range.closed(1,3), 1, "Special: immune to blind spell. Average level 1 creature. Strongly affected by bless and curse.", "ground", false, "DUNGEON"),
    INFERNAL_TROGLODYTE("Infernal Troglodyte", 5,4,6,5, Range.closed(1,3), 1, "Special: immune to blind spell. Upgrade is expensive but quite reasonable. Damage range is still huge.", "ground", true, "DUNGEON"),
    HARPY("Harpy", 6,5,14,6, Range.closed(1,4), 2, "Special: return to the hex they started from after an attack. Quite a weak creature with huge damage range (bless and curse do well), but the abbility is very unique, not very useful before the upgrade though. Once enemy stack has used up their retaliation, it's harpy time! ;)", "flying", false, "DUNGEON"),
    HARPY_HAG("Harpy Hag", 6,6,14,9, Range.closed(1,4),2, "Special: return to the hex they started from after an attack, no enemy retaliation. Great upgrade. Now you can annoy your enemies from 9 hexes away, like from the other side of castle walls without loosing any harpy hags. Take note that both harpies and harpy hags retreat back when attacking shooters, so sometimes it's better to move close without attacking to prevent the more powerful range attacks.", "flying", true, "DUNGEON"),
    BEHOLDER("Beholder",9,7,22,5, Range.closed(3,5), 3, "Special: no hand-to-hand penalty. Good shooter, plenty of hit points and no fear of close combat.", "ground", false, "DUNGEON"),
    EVIL_EYE("Evil Eye",10,8,22,7,Range.closed(3,5), 3, "Special: no hand-to-hand penalty. Little all-around upgrade. Evil eyes make a good shooter unit and they don't die as quick as most low level shooters.", "ground", true, "DUNGEON"),
    MEDUSA("Medusa", 9,9,25,5, Range.closed(6,8), 4, "Special: no hand-to-hand penalty, hand-to-hand attacks have 20% chance to turn enemies to stone: 3 rounds, take 50% damage, unstoned when attacked. Very good creature, would be a better deal than beholder if had more than 4 shots...", "ground",false, "DUNGEON"),
    MEDUSA_QUEEN("Medusa Queen",10,10,30,6,Range.closed(6,8), 4, "Special: no hand-to-hand penalty, hand-to-hand attacks have 20% chance to turn enemies to stone: 3 rounds, take 50% damage, unstoned when attacked. Definitely worth upgrading: double shots, extra health and other minor upgrades for only 30 gold. Medusa queens and evil eyes make a good shooting combo together, especially at such early levels.", "ground", true, "DUNGEON"),
    MINOTAUR("Minotaur",14,12,50,6,Range.closed(12,20), 5, "Special: minotaur's morale is never below 1. Good level 5 fighter with a reasonable price. Minotaur's strategy is pretty simple: just go and smash, although a little blessing would be very useful. With the moral bonus, there's always a hope for a second turn.", "ground",false, "DUNGEON"),
    MINOTAUR_KING("Minotaur King",15,15,50,8, Range.closed(12,20), 5, "Special: minotaur's morale is never below 1. Good upgrade: 2 extra speed and much better defence rating. Smash strategy remains.","ground", true, "DUNGEON"),
    MANTICORE("Manticore",15,13,80,7, Range.closed(14,20), 6, "The only dungeon creature without a special abbility, manticores are below-average for level 6 and lack hit points.", "flying", false, "DUNGEON"),
    SCORPICORE("Scorpicore", 16,14,80,11, Range.closed(14,20), 6, "Special: 20% chance to paralyze: take 50% damage, unparalyzed after 3 rounds or when attacked. Is there any actual difference between stoning and paralyzing? Hmmm... 200 gold for paralyzing, speed and 2 combat points... Scorpicores are a bit too expensive and 80 hit points is not enough - that's what happens when you breed a lion-bat-scorpion.", "flying", true, "DUNGEON"),
    RED_DRAGON("Red Dragon", 19,19,180,11, Range.closed(40,50), 7, "Special: immune to spells level 1-3. Stronger than green dragon, but otherways a dragon like any other.", "flying", false, "DUNGEON"),
    BLACK_DRAGON("Black Dragon",25,25,300,15,Range.closed(40,50), 7, "Special: immune to all spells, 150% damage to giants and titans. Little trick: titans do 150% damage to black dragons, but giants don't, so if you attack some giants, there's a definite bonus! Stronger than gold dragon, but not than archangel. Great for armageddon casters. Black dragons are terror of those heroes who have chosen magic over might, although there is one artifact that can break black dragon's spell immunity.", "flying", true, "DUNGEON"),

    // STRONGHOLD FRACTION
    GOBLIN("Goblin", 4,2,5,5,Range.closed(1,2), 1, "Slightly weaker than average for level 1, but better than imp for a smaller price. Highly populated, goblin is a good offensive unit to start with. Nice speed for level 1, especially after the upgrade. Defence is lower than attack, so be sure to attack before attacked.", "ground", false, "STRONGHOLD"),
    HOBGOBLIN("Hobgoblin", 5,3,5,7, Range.closed(1,2), 1, "The speed is worth 10 gold, combined attack and defence increase. Hobgoblins are more able to attack before failing to defend themselves. However, the damage is lacking: 1-2 is lower than 1-3 or 2-3 that many other units of this level have. Since this upgrade is required for wolf raiders, you will probably end up doing it, but 5 wood and 5 ore are better saved for a castle.", "ground", true, "STRONGHOLD"),
    WOLF_RIDER("Wolf Rider",7,5,10,6,Range.closed(2,4), 2, "Basically you're getting the same goblin, slightly better stats and larger size. Weak for level 2, wolf rider is only slightly better than level 1 centaur captain. Wolves should attack before attacked, applies to wolf raiders especially.", "ground", false, "STRONGHOLD"),
    WOLF_RAIDER("Wolf Raider", 8,5,10,8,Range.closed(3,4), 2, "Special: Attacks twice. Awesome upgrade that makes wolves do about 2.5 times more damage. Defence and hit points remain the same, so use the sudden charge tactics.\n", "ground", true, "STRONGHOLD"),
    ORC("Orc",8,4,15,4,Range.closed(2,5), 3, "Weaker than beholders and elves, orcs are the weakest level 3 shooters, but that is also reflected in their low price. Reasonable stats, wide damage easily affected by bless and curse, slow speed which will be reflected on your hero movement, but if you plan using ogres in your army, they are just as slow, so feel free to take some orcs. Cyclops will replace orcs later on.", "ground", false, "STRONGHOLD"),
    ORC_CHIEFTAIN("Orc Cheiftain", 8,4,20,5,Range.closed(2,5), 3, "A small and cheap upgrade that makes orcs slightly faster (same as ogre magi) and tougher. Do it if you want orcs to last longer or if all your ogres are upgraded already, so that the lowest army speed will be 5 instead of 4. Comparing the pictures, orc chieftain has one extra axe - this is to be interpreted as double amount of shots :)",  "ground",true, "STRONGHOLD"),
    OGRE("Ogre",13,7,40,4,Range.closed(6,12), 4, "A great level 4 unit if it wasn't for the superlow speed. Nice damage, great attack, low price, while the low defence is backed up by plenty hit points. Orcs and ogres are a speed pair, so either have both or none for your main hero. Ogres make great defenders, bashing the enemy from close range as they approach your juicy shooters. For all ogres - watch out for curse and apply bless as required.", "ground",false, "STRONGHOLD"),
    OGRE_MAGI("Ogre Magi", 13,7,60,5,Range.closed(6,12), 4, "Special: Can cast bloodlust spell on one ally per round at spell power 6, advanced level. Great upgrade, 50% tougher for 33% extra price plus the spell bonus. Ogre magi are the toughest among their level, their supperiority undermined perhaps only by vampires' life drain. ", "ground", true, "STRONGHOLD"),
    ROC("Roc",13,11,60,7, Range.closed(11,15), 5, "Let's roc! A nice level 5 unit with higher hit points than most. Roc is also very balanced, having no weak sides such as damage range or low defence. Use them for whatever purpose, but being the only stronghold flyers they often die alone in the enemy crowd.", "flying", false, "STRONGHOLD"),
    THUNDERBIRD("Thunderbird", 13,11,60,11,Range.closed(11,15), 5, "Special: 20% chance for thunderbolt spell which does 10 damage per each thunderbird to target. Thunderbolt strike is a useful damage since it is not affected by defence. The only flying unit for stronghold, they are still not good enough to fly over the castle walls alone. This upgrade is good to get the earlier spellcasting turn: speed 11 is the highest in stronghold, followed by 9 of ancient behemoth. And hey, the looks are good, they actually look more powerful to your human opponent.", "flying", true, "STRONGHOLD"),
    CYCLOPS("Cyclops", 15,12,70,6, Range.closed(16,20), 6, "Special: can attack seige walls at basic ballistics level. Now we're shooting! Only titan's lightning can hit stronger than cyclops' rocks, and that abbility to attack seige walls is completely exlusive to cyclops. ", "ground", false, "STRONGHOLD"),
    CYCLOPS_KING("Cyclops King", 17,13,70,8,Range.closed(16,20), 6, "Special: can attack seige walls at advanced ballistics level. They aren't kings for nothing, packing two seige shots in one turn and leveling walls to the ground in no time. You'll notice that the lack of flyers is compensated by the cyclops' special abbilities.",  "ground",true, "STRONGHOLD"),
    BEHEMOTH("Behemoth", 17,17,160,6,Range.closed(30,50), 7, "Special: target is able to use only 60% of its defence when attacked by behemoth. That smile scares the hell out of whoever behemoth is attacking, reducing their abbility to defend themselves. Slow and quite vunerable, behemoth is also a cheap level 7 unit, definitely attack-oriented and able to deal huge damage by reducing enemy defence during the attack.", "ground", false, "STRONGHOLD"),
    ANCIENT_BEHEMOTH("Ancient Behemoth", 19,19,300,9, Range.closed(30,50), 7, "Special: target is able to use only 20% of its defence when attacked by ancient behemoth. Quite low on attack, defence and speed for the best creature, but hit points are at the top and the special abbility is amazing: the target is virtually defenceless however high it's skill is, even if it is commanded by a good hero, nothing helps, only 1/5th of defence will be useful to the scared enemy.","ground", true, "STRONGHOLD"),


    // NEUTRALS (All neutrals are not upgraded)

    AIR_ELEMENTAL("Air Elemental",9,9,25,7,Range.closed(2,8), 1, "Special: immune to mind and meteor shower spells, takes double damage from lightning bolt and chain lightning. You may notice that price of elementals is their hit points multiplied by 10. All elementals have roughly the same attack and defence and average damage, except for earth elementals. Air elementals are fast, durable and cheap. Curse and bless affect their damage very strongly. Great creature for early game army if you manage to hire some.", "ground",false, "NEUTRAL"),
    WATER_ELEMENTAL("Water Elemental", 8,10,30,5,Range.closed(3,7), 2, "Special: immune to mind, ice bolt and frost ring spells, take double damage from fire wall, inferno, fireball and fire shield. Water elementals can slow down some heroes and are more of a defensive creature. Could be used for blocking shooters, but also good for early game army.", "ground",false, "NEUTRAL"),
    FIRE_ELEMENTAL("Fire Elemental",10,8,35,6,Range.closed(4,6), 3, "Special: immune to all mind and fire school spells, take double damage from ice ray and frost ring. Quite a durable creature, fire immunity can be a very strategic bonus. Speed and hit points are also reasonable.", "ground",false, "NEUTRAL"),
    EARTH_ELEMENTAL("Earth Elemental", 10,10,40,4,Range.closed(4,8), 4, "Special: immune to mind, lightning bolt and chain lightning spells, take double damage from meteor shower. The toughest of elementals (without AB expansion), has good stats, hit points and higher damage, but extra slow speed, making them unpractical for anything other than castle defence.", "ground",false, "NEUTRAL"),
    GOLD_GOLEM("Gold Golem", 11,12,50,5,Range.closed(8,10), 5, "Special: non-living; damage from spells reduced by 85%. Gold and diamond golems can only be recruited from tower's golem factory map dwelling where you get a choice of four types of golems. These guys take only 15% of damage from spells and therefore it is unwise for spellcasters to challenge them without sufficient might. They are not much on attack and pretty slow, but hit points, defence and magic resistance makes them extremely durable.","ground", false, "NEUTRAL"),
    DIAMOND_GOLEM("Diamond Golem", 13,12,60,5,Range.closed(10,14), 6, "Special: non-living; damage from spells reduced by 95%. Slow-moving defeat for any spellcaster who relies on magic and forgets that these golems are tough and take only 5% damage from spells! If you find a golem factory or two, have a hero buy 2 diamond golems every week from each factory. If it's a long game, you will have a nice surprise for your spellcasting opponent.","ground", false, "NEUTRAL"),

    // WARMACHINES

    BALLISTA("Ballista",10, 10, 250,0,Range.closed(2,3),3,"A ballista is a missile weapon that, like ranged units, shoots projectiles toward enemy troops, but is unable to retaliate against attacks. The Artillery and Archery secondary skills increase this damage. The ballista acts at the end of every combat round, followed only by the first aid tent, and can be controlled when a hero has learned any level of Artillery.", "none", false, "WARMACHINES"),
    FIRSTAIDTENT("First Aid Tent",0, 0, 75,0,Range.closed(1,25),2, "First Aid Tent heals 1-25 hit points of the top creature in target allied stack. The amount of health restored is affected by First Aid secondary skill, which also gives the player control over the tent rather than being chosen by computer. First Aid Tents act last at the combat round.", "none", false,"WARMACHINES"),
    CATAPULT("Catapult",0,10, 1000,0, Range.closed(1,1),1, "The Catapult only appears on the battlefield when siege attacking enemy towns with walls, which requires the town to have a fort, citadel, or castle. Its main use is to attack and destroy the walls in order to enable ground troops to attack the defenders. The Catapult can also attack and destroy the arrow towers of citadels and castles. The ballistics secondary skill enhances the performance of the Catapult. Basic ballistics gives the player control over the Catapult making it possible to aim at particular parts of the siege structures. During a siege, the Catapult shoots after the arrow towers, but before any other troop", "none", false, "WARMACHINES");




    private final String name;
    private final int attack;
    private final int armor;
    private final int maxHp;
    private final int moveRange;
    private final Range<Integer> damage;
    private final int tier;
    private final String description;
    private final String movement;
    private final boolean isUpgraded;
    private final String fraction;

    CreatureStatistic(String aName, int aAttack, int aArmor, int aMaxHp, int aMoveRange, Range<Integer> aDamage, int aTier, String aDescription, String aMovement, boolean aIsUpgraded, String aFraction) {
        name = aName;
        attack = aAttack;
        armor = aArmor;
        maxHp = aMaxHp;
        moveRange = aMoveRange;
        damage = aDamage;
        tier = aTier;
        description = aDescription;
        movement = aMovement;
        isUpgraded = aIsUpgraded;
        fraction = aFraction;
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

    public String getMovementType() {
        return movement;
    }

    boolean isUpgraded() {
        return isUpgraded;
    }

    public String getFraction() {
        return fraction;
    }
}
