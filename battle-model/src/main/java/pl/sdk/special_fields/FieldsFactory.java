package pl.sdk.special_fields;

public class FieldsFactory {

    private static final String EXCEPTION_MESSAGE = "This field's name does not exist";

    public static Field create( String name ){
        switch (name) {
            case "Normal":
                return new Field(true, false, 0, 1, "Normal");
            case "Lava":
                return new Field(true, true, 10, 0.4, "Lava"); //damage per round
            case "Stone":
                return new Field(false, false, 0, 0, "Stone");
            case "Water":
                return new Field(true, false, 0, 0.6,"Water");
            default:
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);

        }
    }

}