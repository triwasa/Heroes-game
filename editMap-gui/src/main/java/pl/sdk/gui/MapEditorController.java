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
import pl.sdk.creatures.GuiTile;
import pl.sdk.creatures.LavaTile;
import pl.sdk.creatures.RockTile;


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

        randomButton.addEventHandler(MouseEvent.MOUSE_CLICKED,e-> mapEditorEngine.randomGenerate());
        cleanButton.addEventHandler(MouseEvent.MOUSE_CLICKED,e-> mapEditorEngine.clean());
        MapTile mapTile = new MapTile();
        MapTile mapTile2 = new MapTile();
        GuiTile lava = new LavaTile();
        GuiTile rock = new RockTile();
        mapTile.addCreatureWithoutAmount(lava.getName());
        mapTile.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->
        {
            mapEditorEngine.setChosenGuiTile(lava);
            mapTile.setBorder(Color.LIGHTBLUE);
        });
        mapTile2.addCreatureWithoutAmount(rock.getName());
        mapTile2.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->
        {
            mapEditorEngine.setChosenGuiTile(rock);
            mapTile2.setBorder(Color.LIGHTBLUE);
        });
        sideMap.add(mapTile,1,1);
        sideMap.add(mapTile2,1,2);
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

                GuiTile c =  mapEditorEngine.get(x, y);
                if (c != null) {
                    if(!c.isItObstacle()) {
                        rec.addCreature(c.getName(), c.getAmount());
                    } rec.addCreatureWithoutAmount(c.getName());
                }
                rec.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
                {
                    if (event.getButton() == MouseButton.PRIMARY && mapEditorEngine.getActivePoint() == null && (finalX != 0 && finalX != 19  )) {
                        rec.setBackground(Color.GREEN);
                        rec.setBorder(Color.GREEN);
                        mapEditorEngine.setActivePoint(new Point(finalX, finalY));
                    }else if (event.getButton() == MouseButton.SECONDARY
                            && mapEditorEngine.getActivePoint() != null && mapEditorEngine.getActivePoint().getX() ==finalX && mapEditorEngine.getActivePoint().getY() ==finalY)
                    {
                        rec.setBackground(Color.WHITE);
                        rec.setBorder(Color.BLACK);
                        mapEditorEngine.removeActivePoint();
                    }
                });
            }
        }
        sideMap.getChildren().stream().forEach((e)->
        {
            if(e instanceof MapTile)
            {
                ((MapTile) e).setBorder(Color.BLACK);
            }
        });
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        if (!aPropertyChangeEvent.getPropertyName().equals(MapEditorEngine.ADDING_OBSTACLES_BUTTON) && !aPropertyChangeEvent.getPropertyName().equals(MapEditorEngine.REMOVING_OBSTACLES_BUTTON) ) {
            refreshGui();
        }
    }

    public void saveFile() throws IOException {
        mapEditorEngine.save();
    }
}
