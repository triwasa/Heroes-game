package pl.sdk.creatures;

public class PossbileAttackManagerForFortification implements PossbileAttackMangerIf {
    @Override
    public boolean canFortifficationAttack() {
        return true;
    }

    @Override
    public boolean canCreatureAttack() {
        return false;
    }
}
