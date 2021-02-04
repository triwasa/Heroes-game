package pl.sdk.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pl.sdk.Board;

public class TemplateButton extends Button {

    private Stage dialog;
    private ToggleGroup radioGroup;
    public TemplateButton(MapEditorController mapEditorController)
    {
        super("Templates");
        getStyleClass().add("creatureButton");
        radioGroup = new ToggleGroup();
        addEventHandler(MouseEvent.MOUSE_CLICKED,(e)->
        {
           String templateName =  startDialogAndReturnChosenMap();
           if(templateName != null && !templateName.equals("Don't change map"))
           {
               // deserialization example map from template based on name of map
               mapEditorController.setBoard(new Board());
           }
           mapEditorController.refreshGui();
        });
    }

    private String startDialogAndReturnChosenMap() {
        VBox centerPane = new VBox();
        HBox bottomPane = new HBox();
        HBox topPane = new HBox();
        Stage dialog = prepareWindow(centerPane, bottomPane, topPane);
        prepareTop(topPane);
        dialog.showAndWait();
        RadioButton selectedRadioButton =
                (RadioButton) radioGroup.getSelectedToggle();
        if(selectedRadioButton != null) System.out.println(selectedRadioButton.getText());
        return null;
        // return  radioGroup.getSelectedToggle().getUserData().toString();
    }

    private void prepareTop(HBox aTopPane) {

        RadioButton radioButton1 = new RadioButton("Lava Map");
        RadioButton radioButton2 = new RadioButton("Stone Map");
        RadioButton radioButton3 = new RadioButton("Lava-Water Map");
        RadioButton radioButton4 = new RadioButton("Poison Map");
        RadioButton radioButton5 = new RadioButton("Don't change map");

        radioButton1.setToggleGroup(radioGroup);
        radioButton2.setToggleGroup(radioGroup);
        radioButton3.setToggleGroup(radioGroup);
        radioButton4.setToggleGroup(radioGroup);
        radioButton5.setToggleGroup(radioGroup);

        aTopPane.getChildren().add(new VBox(radioButton1));
        aTopPane.getChildren().add(new VBox(radioButton2));
        aTopPane.getChildren().add(new VBox(radioButton3));
        aTopPane.getChildren().add(new VBox(radioButton4));
        aTopPane.getChildren().add(new VBox(radioButton5));

    }

    private Stage prepareWindow(Pane aCenter, Pane aBottom, Pane aTop) {
        dialog = new Stage();
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane, 700,350);
        scene.getStylesheets().add("fxml/main.css");
        dialog.setScene(scene);
        dialog.initOwner(this.getScene().getWindow());
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Templates");
        pane.setTop(aTop);
        pane.setCenter(aCenter);
        pane.setBottom(aBottom);
        return dialog;
    }
}
