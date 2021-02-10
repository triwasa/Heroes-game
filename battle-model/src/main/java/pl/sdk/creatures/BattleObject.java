package pl.sdk.creatures;

import java.beans.PropertyChangeListener;

public interface BattleObject extends Defender, Attacker, PropertyChangeListener {
    void counterAttackedInThisTurn();
}
