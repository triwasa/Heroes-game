package pl.sdk.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pl.sdk.Board;

import javax.swing.*;

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
        VBox topPane = new VBox();
        Stage dialog = prepareWindow(centerPane, bottomPane, topPane);
        prepareTop(topPane);
        dialog.showAndWait();
        RadioButton selectedRadioButton =
                (RadioButton) radioGroup.getSelectedToggle();
        if(selectedRadioButton != null) System.out.println(selectedRadioButton.getText());
        return null;
        // return  radioGroup.getSelectedToggle().getUserData().toString();
    }

    private void prepareTop(VBox aTopPane) {
        aTopPane.setSpacing(50);
        RadioButton radioButton1 = new RadioButton("LavaMap");
        RadioButton radioButton2 = new RadioButton("StoneMap");
        RadioButton radioButton3 = new RadioButton("Lava-WaterMap");
        RadioButton radioButton4 = new RadioButton("PoisonMap");
       // RadioButton radioButton5 = new RadioButton("Don't change map");

        radioButton1.setToggleGroup(radioGroup);
        radioButton2.setToggleGroup(radioGroup);
        radioButton3.setToggleGroup(radioGroup);
        radioButton4.setToggleGroup(radioGroup);

        //radioButton5.setToggleGroup(radioGroup);

        VBox box1 = new VBox();
        box1.setSpacing(30);
        box1.getChildren().add(radioButton1);
        box1.getChildren().add(new ImageTile("LavaMap"));

        VBox box2 = new VBox();
        box2.setSpacing(30);
        box2.getChildren().add(radioButton2);
        box2.getChildren().add(new ImageTile("StoneMap"));

        HBox hbox1 = new HBox();
        hbox1.setSpacing(70);
        hbox1.getChildren().add(box1);
        hbox1.getChildren().add(box2);

        VBox box3 = new VBox();
        box3.setSpacing(30);
        box3.getChildren().add(radioButton3);
        box3.getChildren().add(new ImageTile("Lava-WaterMap"));

        VBox box4 = new VBox();
        box4.setSpacing(30);
        box4.getChildren().add(radioButton4);
        box4.getChildren().add(new ImageTile("PoisonMap"));

        HBox hbox2 = new HBox();
        hbox2.setSpacing(70);
        hbox2.getChildren().add(box3);
        hbox2.getChildren().add(box4);

        aTopPane.getChildren().add(hbox1);
        aTopPane.getChildren().add(hbox2);
        HBox hbox3 = new HBox();
        Button unChose = new Button("Deselect your choice");
        hbox3.getChildren().add(unChose);
        hbox3.setAlignment(Pos.CENTER);
        unChose.addEventHandler(MouseEvent.MOUSE_CLICKED,(e)->
        {
            if(radioGroup.getSelectedToggle() != null) radioGroup.getSelectedToggle().setSelected(false);
        });
        aTopPane.getChildren().add(hbox3);

    }

    private Stage prepareWindow(Pane aCenter, Pane aBottom, Pane aTop) {
        dialog = new Stage();
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane, 900,850);
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
