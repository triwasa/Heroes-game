package pl.sdk.gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pl.sdk.creatures.NecropolisFactory;


public class CreatureButton extends Button {

    private final String creatureName;
    private Stage dialog;

    public CreatureButton(EcoController aEcoController, NecropolisFactory aFactory, boolean aUpgraded, int aTier) {
        super(aFactory.create(aUpgraded,aTier,1).getName());
        creatureName = aFactory.create(aUpgraded,aTier,1).getName();
        getStyleClass().add("creatureButton");

        addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            int amount = startDialogAndGetCreatureAmount();
            aEcoController.buy(aFactory.create(aUpgraded,aTier,amount));
            aEcoController.refreshGui();
        });
    }

    private int startDialogAndGetCreatureAmount() {
        VBox centerPane = new VBox();
        HBox bottomPane = new HBox();
        Stage dialog = prepareWindow(centerPane, bottomPane);
        Slider slider = createSlider();
        prepareConfirmAndCancelButton(bottomPane);
        centerPane.getChildren().add(slider);

        dialog.showAndWait();

        return (int)slider.getValue();
    }

    private Stage prepareWindow(Pane aCenter, Pane aBottom) {
        dialog = new Stage();
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane, 500,300);
        dialog.setScene(scene);
        dialog.initOwner(this.getScene().getWindow());
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Buying " + creatureName);

        pane.setCenter(aCenter);
        pane.setBottom(aBottom);
        return dialog;
    }

    private void prepareConfirmAndCancelButton(HBox aBottomPane) {
        Button okButton = new Button("OK");
        okButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> dialog.close());
        Button cancelButton = new Button("CLOSE");
        cancelButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> dialog.close());
        aBottomPane.getChildren().add(okButton);
        aBottomPane.getChildren().add(cancelButton);
    }

    private Slider createSlider() {
        Slider slider = new Slider();
        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(40);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(10);
        slider.setMinorTickCount(5);
        slider.setBlockIncrement(10);
        return slider;
    }
}
