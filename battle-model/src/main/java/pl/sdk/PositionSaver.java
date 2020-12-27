package pl.sdk;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PositionSaver implements PropertyChangeListener {
    private Point oldPosition;
    private Point currentPosition;
    private int additionalDamage;
    private GameEngine engine;
    PositionSaver(GameEngine aGameEngine) {
        engine = aGameEngine;
        engine.addObserver(GameEngine.CREATURE_ATTACKED, this);
        engine.addObserver(GameEngine.CREATURE_MOVED, this);
        engine.addObserver(GameEngine.CURRENT_CREATURE_CHANGED, this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {

      if(event.getPropertyName().equals(GameEngine.CREATURE_MOVED)) {
          oldPosition = (Point)event.getOldValue();
          currentPosition = (Point)event.getNewValue();
          additionalDamageFromPositioning();
      }
      else if(event.getPropertyName().equals(GameEngine.CREATURE_ATTACKED)) {
          possibleMove();
          oldPosition = null;
          additionalDamage = 0;
      }
      else {
          oldPosition = null;
          currentPosition = null;
          additionalDamage = 0;
      }

    }
    public void possibleMove() {
        if(engine.getActiveCreature().backToPreviousPositionMechanic() && oldPosition != null) {
            engine.unlockMoving();
            engine.move(oldPosition);
        }
    }

    public void additionalDamageFromPositioning() {
        additionalDamage = (int)Math.sqrt((oldPosition.getY() - currentPosition.getY()) * (oldPosition.getY() - currentPosition.getY())
                + (oldPosition.getX() - currentPosition.getX()) * (oldPosition.getX() - currentPosition.getX()));
    }
    public int getAdditionalDamageFromPositioning() {
        return additionalDamage;
    }
}
