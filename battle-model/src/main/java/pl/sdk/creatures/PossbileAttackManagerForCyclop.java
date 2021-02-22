package pl.sdk.creatures;

public class PossbileAttackManagerForCyclop implements PossibleAttackManagerIf {

    boolean canAttackAdvancedBallistics;
    PossbileAttackManagerForCyclop(boolean aCanAttackAdvancedBallistics) {
        canAttackAdvancedBallistics = aCanAttackAdvancedBallistics;
    }
    @Override
    public boolean canFortificationAttack(Fortification fortification) {
        if(canAttackAdvancedBallistics) {
            return true;
        }
        else if(fortification.getLevel() == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean canCreatureAttack() {
        return true;
    }
}
