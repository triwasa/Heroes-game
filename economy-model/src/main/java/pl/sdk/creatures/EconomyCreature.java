package pl.sdk.creatures;

public class EconomyCreature {

    private final CreatureStatistic stats;
    private final int amount;
    private final int goldCost;

    EconomyCreature(CreatureStatistic aStats, int aAmount, int aGoldCost) {
        stats = aStats;
        amount = aAmount;
        goldCost = aGoldCost;
    }

    public int getAmount() {
        return amount;
    }

    public int getGoldCost() {
        return goldCost;
    }

    public String getName(){
        return stats.getTranslatedName();
    }

    public boolean isUpgraded() {
        return stats.isUpgraded();
    }

    public int getTier() {
        return stats.getTier();
    }
}
