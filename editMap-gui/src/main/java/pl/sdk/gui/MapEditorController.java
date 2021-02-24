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
        MapTile poisonTile = new MapTile();
        MapTile mountainTile = new MapTile();
        MapTile charmTile = new MapTile();
        MapTile thunderStormTile = new MapTile();
        MapTile wallTile = new MapTile();

        Field lava = FieldsFactory.create("Lava");
        Field stone = FieldsFactory.create("Stone");
        Field water = FieldsFactory.create("Water");
        Field poison = FieldsFactory.create("Poison");
        Field mountain = FieldsFactory.create("Mountain");
        Field charm = FieldsFactory.create("Charm");
        Field thunderStorm = FieldsFactory.create("ThunderStorm");
        Field wall = FieldsFactory.create("Wall");

        addingField(lavaTile, lava);
        addingField(waterTile, water);
        addingField(stoneTile, stone);
        addingField(poisonTile, poison);
        addingField(mountainTile, mountain);
        addingField(charmTile, charm);
        addingField(thunderStormTile, thunderStorm);
        addingField(wallTile, wall);

        sideMap.add(lavaTile,1,1);
        sideMap.add(waterTile,1,2);
        sideMap.add(stoneTile,1,3);
        sideMap.add(poisonTile,1,4);
        sideMap.add(mountainTile, 1, 5);
        sideMap.add(charmTile, 1 , 6);
        sideMap.add(thunderStormTile, 1, 7);
        sideMap.add(wallTile, 1, 8);

        buttonLabel.getChildren().add(sideMap);

        buttonLabel.getChildren().add(new InformationButton());
        buttonLabel.getChildren().add(new TemplateButton(this));
        refreshGui();
    }

    public void setBoard(Board board)
    {
        this.board=board;
        mapEditorEngine.setBoard(board);
    }

    private void addingField(MapTile mapTile, Field field) {
        mapTile.addCreatureWithoutAmount(field.getName());
        mapTile.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->
        {
            if(e.getButton() == MouseButton.PRIMARY) {
                mapEditorEngine.setChosenGuiTile(field);
                mapTile.setBorder(Color.BLACK);
            }else if(e.getButton() == MouseButton.SECONDARY)
            {
                mapEditorEngine.setChosenGuiTile(null);
                mapTile.setBorder(Color.WHITE);
            }
        });
    }

    public void terminateThread()
    {
        mapEditorEngine.terminateThread();
    }

    public void refreshGui() {
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
