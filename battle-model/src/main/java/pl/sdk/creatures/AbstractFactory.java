package pl.sdk.creatures;

public abstract class AbstractFactory {
    public abstract Creature create(boolean aIsUpgraded, int aTier, int aAmount);
}
