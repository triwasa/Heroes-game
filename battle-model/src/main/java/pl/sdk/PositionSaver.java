package pl.sdk;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PositionSaver implements PropertyChangeListener {
    private Point oldPosition;
    private Point currentPosition;
    private int additionalPercentDamage;
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
          additionalPercentOfDamageToDeal();
      }
      else if(event.getPropertyName().equals(GameEngine.CREATURE_ATTACKED)) {
          //possibleMove();
          oldPosition = null;
          additionalPercentDamage = 0;
      }
      else {
          oldPosition = null;
          currentPosition = null;
          additionalPercentDamage = 0;
      }

    }
   /* public void possibleMove() {
        if(engine.getActiveCreature().backToPreviousPositionMechanic() && oldPosition != null) {
            engine.unlockMoving();
            engine.move(oldPosition);
        }
    }*/

    public void additionalPercentOfDamageToDeal() {
        additionalPercentDamage = (int)Math.sqrt((oldPosition.getY() - currentPosition.getY()) * (oldPosition.getY() - currentPosition.getY())
                + (oldPosition.getX() - currentPosition.getX()) * (oldPosition.getX() - currentPosition.getX()));
        additionalPercentDamage = additionalPercentDamage * 5;
    }
    public int getAdditionalPercentDamageFromPositioning() {
        if(additionalPercentDamage > 45) {
            return 45;
        }
        else {
            return additionalPercentDamage;
        }
    }
}
