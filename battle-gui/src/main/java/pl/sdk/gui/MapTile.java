package pl.sdk.gui;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class MapTile extends StackPane {

    private final Rectangle rec;

    public MapTile() {
        rec = new Rectangle(60, 60, Color.WHITE);
        rec.setStroke(Color.BLACK);
        getChildren().add(rec);
    }

    void addCreature(String aName, int aAmount){
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        ImageView image = new ImageView(new Image(getClass().getResourceAsStream("/graphics/creatures/" + aName + ".png")));
        image.setFitHeight(46);
        image.setFitWidth(46);
        vbox.getChildren().add(image);
        Text text = new Text(String.valueOf(aAmount));
        text.setFont(new Font(10.0));
        vbox.getChildren().add(text);
        getChildren().add(vbox);
    }

    void addCreatureWithoutAmount(String aName)
    {
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        ImageView image = new ImageView(new Image(getClass().getResourceAsStream("/graphics/creatures/" + aName + ".png")));
        image.setFitHeight(57);
        image.setFitWidth(57);
        vbox.getChildren().add(image);
        getChildren().add(vbox);
    }

    void setBackGroundImage(String aName)
    {
        Image image = (new Image(getClass().getResourceAsStream("/graphics/creatures/" + aName + ".png")));
        rec.setFill(new ImagePattern(image));
    }
    void setBackground(Color aColor){
        rec.setFill(aColor);
    }

    void setBorder( Color aColor)
    {
        rec.setStroke(aColor);
    }
}
