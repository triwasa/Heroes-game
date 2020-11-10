package pl.sdk.gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.net.URL;

class MapTile extends StackPane {

    private final Rectangle rec;

    public MapTile() {
        rec = new Rectangle(40, 40, Color.WHITE);
        rec.setStroke(Color.BLACK);
        getChildren().add(rec);
    }

    void addCreature(String aName, String currentHp){
        ImageView image = new ImageView(new Image(getClass().getResourceAsStream("/graphics/creatures/" + aName + ".png")));
        image.setFitHeight(40);
        image.setFitWidth(40);
        getChildren().add(image);
        getChildren().add(new Text(currentHp));
    }

    void setBackground(Color aColor){
        rec.setFill(aColor);
    }
}
