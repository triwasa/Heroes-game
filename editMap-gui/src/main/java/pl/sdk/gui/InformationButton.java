package pl.sdk.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InformationButton extends Button{
    private Stage dialog;

    public InformationButton(MapEditorController aEcoController) {
        super("Informations");
        getStyleClass().add("creatureButton");

        addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
             startDialogAndGetCreatureAmount();
        });
    }

    private void startDialogAndGetCreatureAmount() {
        VBox centerPane = new VBox();
        HBox bottomPane = new HBox();
        VBox topPane = new VBox();
        Stage dialog = prepareWindow(centerPane, bottomPane, topPane);
        prepareTop(topPane);
        prepareCenter(centerPane);
        dialog.showAndWait();

    }

    private void prepareCenter(VBox centerPane) {
        HBox secondMethod = new HBox();
        secondMethod.getChildren().add(new Label("Second Method: "));
        VBox secondInstruction = new VBox();
        secondInstruction.getChildren().add(new Label("Choose field on the right side of our application"));
        secondInstruction.getChildren().add(new Label("Next click wherever you want on the map to add field"));
        secondMethod.getChildren().add(secondInstruction);
        centerPane.getChildren().add(secondMethod);
    }

    private void prepareTop(VBox aTopPane) {
        //TODO creature cops should be visible here
        aTopPane.getChildren().add(new Label ("How to add fields to map:"));
        aTopPane.getChildren().add(new Label ("\n"));
        HBox firstMethod = new HBox();
        firstMethod.getChildren().add(new Label("First Method: "));
        VBox firstInstruction = new VBox();
        firstInstruction.getChildren().add(new Label("Choose one or many tiles on map"));
        firstInstruction.getChildren().add(new Label("Next choose field on the right side of our application"));
        firstInstruction.getChildren().add(new Label("Next click Add Button"));
        firstMethod.getChildren().add(firstInstruction);
        aTopPane.getChildren().add(firstMethod);

    }

    private Stage prepareWindow(Pane aCenter, Pane aBottom, Pane aTop) {
        dialog = new Stage();
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane, 700,350);
        scene.getStylesheets().add("fxml/main.css");
        dialog.setScene(scene);
        dialog.initOwner(this.getScene().getWindow());
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Informations");
        pane.setTop(aTop);
        pane.setCenter(aCenter);
        pane.setBottom(aBottom);
        return dialog;
    }


}