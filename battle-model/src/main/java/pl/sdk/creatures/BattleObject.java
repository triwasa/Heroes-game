package pl.sdk.creatures;


import com.google.common.collect.Range;

public interface BattleObject extends Defender {
    canMove(Point);
    moveX(Point);
    canAttack(Point);
    attackStrategy;
    attackApplier;


}


public interface GuiBattleObject extends Defender {

    String getName();
    canMove(Point);
    canAttack(Point);

}
