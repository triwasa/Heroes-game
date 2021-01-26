package pl.sdk;

import pl.sdk.creatures.Creature;
import pl.sdk.creatures.GuiTile;
import pl.sdk.special_fields.Field;

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
    private boolean blockMoving;
    private boolean blockAttacking;
    private List<Creature> creatures1;
    private List<Creature> creatures2;
    private final PositionSaver positionSaver;

//    public GameEngine(List<Creature> aCreatures1, List<Creature> aCreatures2) {
//        this(aCreatures1, aCreatures2, new Board());
//    }

    public GameEngine(List<Creature> aCreatures1, List<Creature> aCreatures2, Board aBoard) {
        board = aBoard;
        creatures1 = aCreatures1;
        creatures2 = aCreatures2;
        putCreaturesToBoard(creatures1, creatures2);
        List<Creature> twoSidesCreatures = new ArrayList<>();
        twoSidesCreatures.addAll(aCreatures1);
        twoSidesCreatures.addAll(aCreatures2);
        twoSidesCreatures.sort((c1, c2) -> c2.getMoveRange() - c1.getMoveRange());
        queue = new CreatureTurnQueue(twoSidesCreatures);
        twoSidesCreatures.forEach(queue::addObserver);

        observerSupport = new PropertyChangeSupport(this);

        positionSaver = new PositionSaver(this);
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
        Creature oldActiveCreature = queue.getActiveCreature();
        queue.next();
        blockAttacking = false;
        blockMoving = false;
        Creature newActiveCreature = queue.getActiveCreature();
        notifyObservers(new PropertyChangeEvent(this, CURRENT_CREATURE_CHANGED, oldActiveCreature, newActiveCreature));
    }

    public void attack(int aX, int aY) {
        if (blockAttacking) {
            return;
        }
        Creature activeCreature = queue.getActiveCreature();
        boolean[][] splashRange = activeCreature.getSplashRange();
        for (int x = 0; x < splashRange.length; x++) {
            for (int y = 0; y < splashRange.length; y++) {
                if (splashRange[x][y]) {
                    Creature attackedCreature = (Creature) board.get(aX + x - 1, aY + y - 1);
                    if (attackedCreature != null){
                        activeCreature.attack((Creature) board.get(aX + x - 1, aY + y - 1));
                    }
                }
            }
        }
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

    public GuiTile get(int aX, int aY) {
        return board.get(aX, aY);
    }

    public Field getField(int aX, int aY)
    {
        return board.getField(aX,aY);
    }

    public Creature getActiveCreature() {
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
            theSamePlayerUnit = creatures1.contains(board.get(aX, aY));
        } else {
            theSamePlayerUnit = creatures2.contains(board.get(aX, aY));
        }

        return !theSamePlayerUnit && board.get(getActiveCreature()).distance(new Point(aX, aY)) <= getActiveCreature().getAttackRange();
    }
}
