package pl.sdk;

import pl.sdk.creatures.BattleObject;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.GuiBattleObject;
import pl.sdk.hero.Hero;
import pl.sdk.special_fields.Field;
import pl.sdk.spells.SpellBook;

import javax.management.MBeanAttributeInfo;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class GameEngine {

    public final static int BOARD_WIDTH = 20;
    public final static int BOARD_HEIGHT = 15;

    public static final String CURRENT_CREATURE_CHANGED = "CURRENT_CREATURE_CHANGED";
    public static final String CREATURE_MOVED = "CREATURE_MOVED";
    public static final String CREATURE_ATTACKED = "CREATURE_ATTACKED";
    public static final String END_OF_TURN = "END_OF_TURN";
    private final Board board;
    private final CreatureTurnQueue queue;
    private final PropertyChangeSupport observerSupport;
    private final Hero hero1;
    private final Hero hero2;
    private boolean blockMoving;
    private boolean blockAttacking;
    private List<Creature> creatures1;
    private List<Creature> creatures2;
    private List<BattleObject> machines1;
    private List<BattleObject> machines2;
    private final AttackEngine attackEngine;

//    public GameEngine(List<Creature> aCreatures1, List<Creature> aCreatures2) {
//        this(aCreatures1, aCreatures2, new Board());
//    }

    public GameEngine(Hero aHero1, Hero aHero2, Board aBoard) {
        board = aBoard;
        hero1 = aHero1;
        hero2 = aHero2;
        creatures1 = aHero1.getCreatures();
        creatures2 = aHero2.getCreatures();
        machines1 = aHero1.getMachines();
        machines2 = aHero2.getMachines();
        attackEngine = new AttackEngine(board);
        putCreaturesToBoard(creatures1, creatures2);
        putMachinesToBoard(machines1, machines2);
        List<BattleObject> twoSidesCreatures = new ArrayList<>();
        twoSidesCreatures.addAll(creatures1);
        twoSidesCreatures.addAll(creatures2);
        twoSidesCreatures.sort((c1, c2) -> c2.getMoveRange() - c1.getMoveRange());
        queue = new CreatureTurnQueue(twoSidesCreatures);
        twoSidesCreatures.forEach(queue::addObserver);
        observerSupport = new PropertyChangeSupport(this);
        addObserver(END_OF_TURN, (PropertyChangeListener) hero1.getSpellBook());
        addObserver(END_OF_TURN, (PropertyChangeListener) hero2.getSpellBook());
    }



    public void addObserver(String aEventType, PropertyChangeListener aObs) {
        if (END_OF_TURN.equals(aEventType)) {
            queue.addObserver(aObs);
        } else {
            observerSupport.addPropertyChangeListener(aEventType, aObs);
        }

    }

    public void removeObserver(PropertyChangeListener aObs) {
        observerSupport.removePropertyChangeListener(aObs);
    }

    void notifyObservers(PropertyChangeEvent aEvent) {
        observerSupport.firePropertyChange(aEvent);
    }

    public void move(Point aTargetPoint) {
        if (blockMoving) {
            return;
        }
        Point oldPosition = board.get(queue.getActiveCreature());
        board.move(queue.getActiveCreature(), aTargetPoint);
        blockMoving = true;
        notifyObservers(new PropertyChangeEvent(this, CREATURE_MOVED, oldPosition, aTargetPoint));
    }

    public void pass() {
        BattleObject oldActiveCreature = queue.getActiveCreature();
        queue.next();
        blockAttacking = false;
        blockMoving = false;
        BattleObject newActiveCreature = queue.getActiveCreature();
        notifyObservers(new PropertyChangeEvent(this, CURRENT_CREATURE_CHANGED, oldActiveCreature, newActiveCreature));
    }

    public void attack(int aX, int aY) {
        if (blockAttacking) {
            return;
        }
        BattleObject activeCreature = queue.getActiveCreature();
        attackEngine.attack(activeCreature, aX, aY);
        blockAttacking = true;
        blockMoving = true;
        notifyObservers(new PropertyChangeEvent(this, CREATURE_ATTACKED, null, null));
    }

    private void putCreaturesToBoard(List<Creature> aCreatures1, List<Creature> aCreatures2) {
        putCreaturesFromOneSideToBoard(aCreatures1, 0);
        putCreaturesFromOneSideToBoard(aCreatures2, GameEngine.BOARD_WIDTH - 1);
    }

    private void putCreaturesFromOneSideToBoard(List<Creature> aCreatures, int aX) {
        for (int i = 0; i < aCreatures.size(); i++) {
            board.add(new Point(aX, i * 2 + 1), aCreatures.get(i));
        }
    }
    private void putMachinesToBoard(List<BattleObject> aMachines1, List<BattleObject> aMachines2) {
        putMachinesFromOneSideToBoard(aMachines1, 0);
        putMachinesFromOneSideToBoard(aMachines2, GameEngine.BOARD_WIDTH - 1);
    }

    private void putMachinesFromOneSideToBoard(List<BattleObject> aMachines, int aX) {
        for (int i = 0; i < aMachines.size(); i++) {
            board.add(new Point(aX, 13-i*2), aMachines.get(i));
        }
    }


    public BattleObject get(int aX, int aY) {
        return board.get(aX, aY);
    }

    public Field getField(int aX, int aY)
    {
        return board.getField(aX,aY);
    }

    public BattleObject getActiveCreature() {
        return queue.getActiveCreature();
    }

    public boolean canMove(int aX, int aY) {
        return board.canMove(getActiveCreature(), aX, aY);
    }

    protected void unlockMoving() {
        blockMoving = false;
    }

    public boolean canAttack(int aX, int aY) {
        boolean isP1Creature = creatures1.contains(getActiveCreature());
        boolean theSamePlayerUnit;
        if (isP1Creature) {
            theSamePlayerUnit = isPlayerOneUnit(aX, aY);
        } else {
            theSamePlayerUnit = isPlayerTwoUnit(aX, aY);
        }

        return !theSamePlayerUnit && board.get(getActiveCreature()).distance(new Point(aX, aY)) <= getActiveCreature().getAttackRange()
                && attackEngine.canAttack(getActiveCreature(), get(aX, aY));
    }
    public boolean isPlayerOneUnit(int aX,int aY) {
        return creatures1.contains(board.get(aX, aY));
    }
    public boolean isPlayerTwoUnit(int aX,int aY){
        return creatures2.contains(board.get(aX, aY));
    }
}
