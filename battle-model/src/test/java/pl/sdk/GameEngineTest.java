package pl.sdk;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Test;
import pl.sdk.creatures.*;
import pl.sdk.hero.Hero;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;

class GameEngineTest {

    @Test
    void shouldRecognizeFriendlyCreatureAndDoNotAttackHer(){
        NecropolisFactory factory = new NecropolisFactory();
        List<Creature> l1 = List.of(factory.create(true, 5,1), spy(Creature.class));
        List<Creature> l2 = List.of(factory.create(true, 5,1), spy(Creature.class));

        Hero h1 = new Hero();
        h1.addCreatures(l1);
        Hero h2 = new Hero();
        h2.addCreatures(l2);

        GameEngine engine = new GameEngine(h1,h2, new Board());
        assertTrue(engine.canAttack(GameEngine.BOARD_WIDTH-1, 1));
        assertFalse(engine.canAttack(0,1));
        assertFalse(engine.canAttack(0,1));
   }
    @Test
    void tentShouldNotTargetOpponentUnits(){
        WarMachineFactory warMachineFactory= new WarMachineFactory();
        NecropolisFactory factory = new NecropolisFactory();

        List<Creature> listOfCreatures = List.of(factory.create(true, 5,1));
        Hero h1 = new Hero();
        Hero h2 = new Hero();
        h2.addCreatures(listOfCreatures);
        List<BattleObject> listOfMachines = new ArrayList<>();
        listOfMachines.add(warMachineFactory.create(2, h2));
        h1.addWarmachines(listOfMachines);

        GameEngine engine = new GameEngine(h1,h2, new Board());
        assertFalse(engine.canAttack(GameEngine.BOARD_WIDTH-1, 1));
    }
    @Test
    void tentShouldTargetAllyUnits(){
        WarMachineFactory warMachineFactory= new WarMachineFactory();
        List<Creature> listOfCreatures = List.of(NecropolisFactory.createDefaultForTests());
        Hero h1 = new Hero();
        Hero h2 = new Hero();

        List<BattleObject> listOfMachines = new ArrayList<>();
        listOfMachines.add(warMachineFactory.create(2, h2));
        h1.addWarmachines(listOfMachines);
        h1.addCreatures(listOfCreatures);
        h2.addCreatures(listOfCreatures);

        GameEngine engine = new GameEngine(h1,h2, new Board());
        engine.pass();
        engine.pass();
        assertTrue(engine.canAttack(0, 1));

    }
   @Test
    void canAttackTestForSpecifiedBattleObjects() {
        AttackEngine attackEngine = new AttackEngine(new Board());
        Creature creature = AbstractFactory.getFraction(AbstractFactory.NECROPOLIS).create(true,1,1);

        BattleObject balista = new WarMachineFactory().create(3, new Hero());
        BattleObject catapult = new WarMachineFactory().create(1, new Hero());

        BattleObject wall = new Wall();

        assertTrue(attackEngine.canAttack(balista,creature));
        assertTrue(attackEngine.canAttack(creature,balista));
        assertFalse(attackEngine.canAttack(catapult,creature));
        assertFalse(attackEngine.canAttack(catapult,catapult));
        assertTrue(attackEngine.canAttack(balista,balista));
        assertTrue(attackEngine.canAttack(catapult,wall));

   }
   @Test
   void CanCreatureAttackWallsAndCanCyclopAttackWalls() {
        AttackEngine attackEngine = new AttackEngine(new Board());

        Creature cyclop = AbstractFactory.getFraction(AbstractFactory.STRONGHOLD).create(true, 6, 1);
        Creature creature = AbstractFactory.getFraction(AbstractFactory.NECROPOLIS).create(true,1,1);//Cyclop
        BattleObject wall = new Wall();
        assertTrue(attackEngine.canAttack(cyclop,wall));
        assertFalse(attackEngine.canAttack(creature,wall));

   }

    @Test
    void addMachinesToBoardTest() {
        WarMachineFactory warMachineFactory= new WarMachineFactory();
        List<Creature> listOfCreatures = List.of(NecropolisFactory.createDefaultForTests());
        Hero h1 = new Hero();
        Hero h2 = new Hero();
        h1.addCreatures(listOfCreatures);
        h2.addCreatures(listOfCreatures);

        List<BattleObject> listOfMachines = new ArrayList<>();
        listOfMachines.add(warMachineFactory.create(2, h2));
        h1.addWarmachines(listOfMachines);

        GameEngine engine = new GameEngine(h1,h2, new Board());

        assertEquals(engine.get(0, 14), listOfMachines.get(0));
    }

}
