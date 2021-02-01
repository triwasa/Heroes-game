package pl.sdk.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pl.sdk.Board;
import pl.sdk.Holder;
import pl.sdk.PointHolder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

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
           if(templateName != null) {
               try {
                   mapEditorController.setBoard(xmlToBoardConverter(templateName));
               } catch (IOException ioException) {
                   ioException.printStackTrace();
               } catch (JAXBException jaxbException) {
                   jaxbException.printStackTrace();
               }
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
        if(selectedRadioButton != null){
            return  selectedRadioButton.getText();
        }else return null;
    }

    private void prepareTop(VBox aTopPane) {
        aTopPane.setSpacing(50);
        RadioButton radioButton1 = new RadioButton("LavaMap");
        RadioButton radioButton2 = new RadioButton("StoneMap");
        RadioButton radioButton3 = new RadioButton("Lava-WaterMap");
        RadioButton radioButton4 = new RadioButton("PoisonMap");

        radioButton1.setToggleGroup(radioGroup);
        radioButton2.setToggleGroup(radioGroup);
        radioButton3.setToggleGroup(radioGroup);
        radioButton4.setToggleGroup(radioGroup);

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

    private static Board xmlToBoardConverter(String name) throws IOException, JAXBException {
        Board board = new Board();

        JAXBContext contextFields = JAXBContext.newInstance(Holder.class);
        JAXBContext contextPoints = JAXBContext.newInstance(PointHolder.class);
        File file = new File(ImageTile.class.getClassLoader().getResource("graphics/maps/"+ name + ".xml").getFile());
        if(file.canRead() && file.isFile()) {
            Holder holder1 = (Holder) contextFields.createUnmarshaller().unmarshal( new File(ImageTile.class.getClassLoader().getResource("graphics/maps/"+ name + ".xml").getFile()));
            PointHolder pointHolder1 = (PointHolder) contextPoints.createUnmarshaller().unmarshal( new File(ImageTile.class.getClassLoader().getResource("graphics/maps/"+ name + "Points.xml").getFile()));

            for (int i = 0; i < holder1.getThings().size(); i++) {
                board.add(pointHolder1.getThings().get(i), holder1.getThings().get(i));
            }
        }
        return board;
    }

}
