package pl.sdk.gui;

import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
public class ImageTile extends StackPane {

    private final Rectangle rec;

    public ImageTile(String name)
    {
        rec = new Rectangle(400,300);
        rec.setStroke(Color.BLACK);
        getChildren().add(rec);
        setBackGroundImage(name);
    }

    void setBackGroundImage(String aName)
    {
        Image image = (new Image(getClass().getResourceAsStream("/graphics/maps/" + aName + ".png")));
        rec.setFill(new ImagePattern(image));
    }
}
