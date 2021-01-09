package pl.sdk.creatures;

public class EconomyFractionFactory {
    public static final String CASTLE = "Castle";
    public static final String TOWER = "Tower";
    public static final String INFERNO = "Inferno";
    public static final String FORTRESS = "Fortress";
    public static final String RAMPART = "Rampart";
    public static final String DUNGEON = "Dungeon";
    public static final String STRONGHOLD = "Stronghold";
    public static final String NECROPOLIS = "Nectropolis";
    public static final String NEUTRAL = "Neutral";
    private static final String EXCEPTION = "Fraction does not exist";

    public static EconomyAbstractFactory getFraction(String fraction) {
        switch (fraction) {
            case CASTLE:
                return new EconomyCastleFactory();
            case TOWER:
                return new EconomyTowerFactory();
            case INFERNO:
                return new EconomyInfernoFactory();
            case FORTRESS:
                return new EconomyFortressFactory();
            case RAMPART:
                return new EconomyRampartFactory();
            case DUNGEON:
                return new EconomyDungeonFactory();
            case STRONGHOLD:
                return new EconomyStrongholdFactory();
            case NECROPOLIS:
                return new EconomyNecropolisFactory();
            case NEUTRAL:
                return new EconomyNeutralFactory();
            default:
                throw new IllegalArgumentException(EXCEPTION);
        }
    }
}
