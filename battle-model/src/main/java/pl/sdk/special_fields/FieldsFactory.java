package pl.sdk.special_fields;

public class FieldsFactory {

    private static final String EXCEPTION_MESSAGE = "This field's name does not exist";

    public static Field create( String name ){
        switch (name) {
            case "Normal":
                return new Field(true, false, 0, 1);
            case "Lava":
                return new Field(true, true, 10, 0.4); //damage per round
            case "Stone":
                return new Field(false, false, 0, 0);
            case "Water":
                return new Field(true, false, 0, 0.6);
            default:
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);

        }
    }

}