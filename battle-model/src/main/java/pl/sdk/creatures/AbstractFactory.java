package pl.sdk.creatures;

public abstract class AbstractFactory {
    abstract Creature create(boolean aIsUpgraded, int aTier, int aAmount);
}
