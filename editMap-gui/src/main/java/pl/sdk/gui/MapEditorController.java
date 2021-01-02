package pl.sdk.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import pl.sdk.Board;
import pl.sdk.MapEditorEngine;
import pl.sdk.Point;
import pl.sdk.creatures.GuiTile;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class MapEditorController implements PropertyChangeListener {

    @FXML
    private GridPane gridMap;
    @FXML
    private Button addingButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button removeButton;
    @FXML
    private Button randomButton;
    @FXML
    private Button cleanButton;

    private Board board;

    private final MapEditorEngine mapEditorEngine;

    public MapEditorController(Board board) {
        this.board= board;
        mapEditorEngine = new MapEditorEngine(board);

        //TODO
        // dekorator na remove
        // dostepne pola do wyboru ale to jak juz fabryka bedzie gotowa
        // deserializacja
        // # MapEditorEngine
        // # MapEditorController
        // # poprawki w EcoBattleConverter
    }

    @FXML
    void initialize()
    {
        mapEditorEngine.addObserver(MapEditorEngine.ADDING_OBSTACLES,this);
        mapEditorEngine.addObserver(MapEditorEngine.REMOVING_OBSTACLES,this);
        mapEditorEngine.addObserver(MapEditorEngine.RANDOM_GENERATE,this);
        mapEditorEngine.addObserver(MapEditorEngine.CLEAN_MAP,this);
        addingButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> mapEditorEngine.add());
        saveButton.addEventHandler(MouseEvent.MOUSE_CLICKED,e-> {
            try {
                mapEditorEngine.save();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        removeButton.addEventHandler(MouseEvent.MOUSE_CLICKED,e-> mapEditorEngine.remove());
        randomButton.addEventHandler(MouseEvent.MOUSE_CLICKED,e-> mapEditorEngine.randomGenerate());
        cleanButton.addEventHandler(MouseEvent.MOUSE_CLICKED,e-> mapEditorEngine.clean());
        refreshGui();
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
                    if (event.getButton() == MouseButton.PRIMARY && mapEditorEngine.getActivePoint() == null) {
                        rec.setBackground(Color.GREEN);
                        rec.setBorder(Color.GREEN);
                        mapEditorEngine.setActivePoint(new Point(finalX, finalY));

                    }else if (event.getButton() == MouseButton.SECONDARY
                            && mapEditorEngine.getActivePoint().equals(new Point(finalX,finalY)))
                    {
                        rec.setBackground(Color.WHITE);
                        rec.setBorder(Color.BLACK);
                        mapEditorEngine.removeActivePoint();
                    }
                });
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        refreshGui();
    }
}
