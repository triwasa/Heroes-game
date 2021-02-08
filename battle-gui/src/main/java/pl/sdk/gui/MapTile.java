package pl.sdk.gui;

import javafx.geometry.Pos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.PopupWindow;
import pl.sdk.creatures.BattleObjectStatistic;

import java.util.HashMap;
import java.util.Map;


public class MapTile extends StackPane {

    private final Rectangle rec;

    public MapTile() {
        rec = new Rectangle(60, 60, Color.WHITE);
        rec.setStroke(Color.BLACK);
        getChildren().add(rec);
    }

    void addObject(String aName, int aAmount){
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

    void addObject(String aName, int aAmount, boolean isRightPlayerCreature) {
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        ImageView image = new ImageView(new Image(getClass().getResourceAsStream("/graphics/creatures/" + aName + ".png")));
        if(isRightPlayerCreature) {
            flip(image);
        }
        image.setFitHeight(46);
        image.setFitWidth(46);
        vbox.getChildren().add(image);
        Text text = new Text(String.valueOf(aAmount));
        text.setFont(new Font(10.0));
        vbox.getChildren().add(text);
        getChildren().add(vbox);
    }

    /*void addToolTip(BattleObjectStatistic cStats) {
        Label label = new Label();
        Tooltip tooltip = new Tooltip();
        tooltip.setAnchorLocation(PopupWindow.AnchorLocation.CONTENT_TOP_RIGHT);
        tooltip.setText("Name: " + cStats.getName() + "\n" +
               "Health: " + cStats.getCurrentHp() + "/" + cStats.getMaxHp());
        label.setTooltip(tooltip);

        getChildren().add(label);
    }*/

    private void flip(ImageView image) {
        image.setTranslateZ(image.getBoundsInLocal().getWidth() / 2.0);
        image.setRotationAxis(Rotate.Y_AXIS);
        image.setRotate(180);
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
