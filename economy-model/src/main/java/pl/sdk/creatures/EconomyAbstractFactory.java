package pl.sdk.creatures;

public abstract class EconomyAbstractFactory {
    abstract EconomyCreature create(boolean aIsUpgraded, int aTier, int aAmount);
}
