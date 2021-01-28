package pl.sdk.gui;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import pl.sdk.Board;
import pl.sdk.MapEditorEngine;
import pl.sdk.Point;
import pl.sdk.special_fields.Field;
import pl.sdk.special_fields.FieldsFactory;


import javax.xml.bind.JAXBException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class MapEditorController implements PropertyChangeListener {

    @FXML
    private GridPane gridMap;
    @FXML
    private Button randomButton;
    @FXML
    private Button cleanButton;

    private GridPane sideMap;

    @FXML
    VBox buttonLabel;


    private DecoratedAddingButton decoratedAddingButton;

    private DecoratedRemovingButton decoratedRemovingButton;
    private Board board;

    private final MapEditorEngine mapEditorEngine;

    public MapEditorController(Board board) {
        this.board= board;
        mapEditorEngine = new MapEditorEngine(board);
        this.sideMap = new GridPane();
        //TODO
        // deserializacja
        // # poprawki w EcoBattleConverter
        // polaczenie wszystkiego w BattleControllerze
    }


    @FXML
    void initialize()
    {
        decoratedAddingButton = new DecoratedAddingButton(mapEditorEngine);
        buttonLabel.getChildren().add(decoratedAddingButton);

        mapEditorEngine.addObserver(MapEditorEngine.ADDING_OBSTACLES,this);
        mapEditorEngine.addObserver(MapEditorEngine.ADDING_OBSTACLES_BUTTON,decoratedAddingButton);

        decoratedRemovingButton = new DecoratedRemovingButton(mapEditorEngine);
        buttonLabel.getChildren().add(decoratedRemovingButton);
        mapEditorEngine.addObserver(MapEditorEngine.REMOVING_OBSTACLES,this);
        mapEditorEngine.addObserver(MapEditorEngine.REMOVING_OBSTACLES_BUTTON,decoratedRemovingButton);

        mapEditorEngine.addObserver(MapEditorEngine.RANDOM_GENERATE,this);
        mapEditorEngine.addObserver(MapEditorEngine.CLEAN_MAP,this);

        mapEditorEngine.addObserver(MapEditorEngine.CHANGE_CHOSEN_TILE,this);

        randomButton.addEventHandler(MouseEvent.MOUSE_CLICKED,e-> mapEditorEngine.randomGenerate());
        cleanButton.addEventHandler(MouseEvent.MOUSE_CLICKED,e-> mapEditorEngine.clean());
        MapTile lavaTile = new MapTile();
        MapTile waterTile = new MapTile();
        MapTile stoneTile = new MapTile();
        Field lava = FieldsFactory.create("Lava");
        Field stone = FieldsFactory.create("Stone");
        Field water = FieldsFactory.create("Water");
        lavaTile.addCreatureWithoutAmount(lava.getName());
        lavaTile.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->
        {
            if(e.getButton() == MouseButton.PRIMARY) {
                mapEditorEngine.setChosenGuiTile(lava);
                lavaTile.setBorder(Color.BLACK);
            }else if(e.getButton() == MouseButton.SECONDARY)
            {
                mapEditorEngine.setChosenGuiTile(null);
                lavaTile.setBorder(Color.WHITE);
            }
        });
        waterTile.addCreatureWithoutAmount(water.getName());
        waterTile.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->
        {
            if(e.getButton() == MouseButton.PRIMARY) {
                mapEditorEngine.setChosenGuiTile(water);
                waterTile.setBorder(Color.BLACK);
            }else if(e.getButton() == MouseButton.SECONDARY)
            {
                mapEditorEngine.setChosenGuiTile(null);
                waterTile.setBorder(Color.WHITE);
            }
        });
        stoneTile.addCreatureWithoutAmount(stone.getName());
        stoneTile.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->
        {
            if(e.getButton() == MouseButton.PRIMARY) {
                mapEditorEngine.setChosenGuiTile(stone);
                stoneTile.setBorder(Color.BLACK);
            }else if(e.getButton() == MouseButton.SECONDARY)
            {
                mapEditorEngine.setChosenGuiTile(null);
                stoneTile.setBorder(Color.WHITE);
            }
        });
        sideMap.add(lavaTile,1,1);
        sideMap.add(waterTile,1,2);
        sideMap.add(stoneTile,1,3);
        buttonLabel.getChildren().add(sideMap);
        refreshGui();
    }

    public void terminateThread()
    {
        mapEditorEngine.terminateThread();
    }

    private void refreshGui() {
        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 15; y++) {
                MapTile rec = new MapTile();
                gridMap.add(rec, x, y);
                int finalX = x;
                int finalY = y;

                Field c =  mapEditorEngine.getField(x, y);
                if (!c.getName().equals("Normal")) {
                     rec.addCreatureWithoutAmount(c.getName());
                }
                rec.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
                {
                    if (event.getButton() == MouseButton.PRIMARY && !mapEditorEngine.isPointInActivePointList(finalX,finalY) && (finalX != 0 && finalX != 19  )) {
                       if(mapEditorEngine.getChosenGuiTile() != null)
                       {
                           mapEditorEngine.addFieldBySingleClick(finalX,finalY);
                           rec.addCreatureWithoutAmount(mapEditorEngine.getField(finalX,finalY).getName());
                       }else {
                           rec.setBackground(Color.GREEN);
                           rec.setBorder(Color.GREEN);
                           mapEditorEngine.setActivePoint(new Point(finalX, finalY));
                       }
                    }else if (event.getButton() == MouseButton.SECONDARY
                            && mapEditorEngine.isActivePointListEmpty() != 0 && mapEditorEngine.isPointInActivePointList(finalX,finalY))
                    {
                        rec.setBackground(Color.WHITE);
                        rec.setBorder(Color.BLACK);
                        mapEditorEngine.removeActivePoint(finalX,finalY);
                    }
                });
            }
        }
        sideMap.getChildren().stream().forEach((e)->
        {
            ((MapTile) e).setBorder(Color.WHITE);
        });
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        if(aPropertyChangeEvent.getPropertyName().equals(MapEditorEngine.CHANGE_CHOSEN_TILE))
        {
            sideMap.getChildren().stream().forEach((e)->
            {
                ((MapTile) e).setBorder(Color.WHITE);
            });
        }
        else if (!aPropertyChangeEvent.getPropertyName().equals(MapEditorEngine.ADDING_OBSTACLES_BUTTON) && !aPropertyChangeEvent.getPropertyName().equals(MapEditorEngine.REMOVING_OBSTACLES_BUTTON) ) {
            refreshGui();
        }

    }

    public void saveFile() throws JAXBException {
        mapEditorEngine.save();
    }
}
