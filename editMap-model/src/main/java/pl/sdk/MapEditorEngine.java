package pl.sdk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.sdk.creatures.GuiTile;
import pl.sdk.creatures.LavaTile;
import pl.sdk.creatures.RockTile;
import pl.sdk.special_fields.Field;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MapEditorEngine {

    private Point activePoint;
    private final PropertyChangeSupport observerSupport;

    public ActivePointThread activePointThread;
    public static final String ADDING_OBSTACLES = "ADDING_OBSTACLES";
    public static final String ADDING_OBSTACLES_BUTTON = "ADDING_OBSTACLES_BUTTON";

    public static final String SAVING_OBSTACLES = "SAVING_OBSTACLES";
    public static final String REMOVING_OBSTACLES = "REMOVING_OBSTACLES";
    public static final String REMOVING_OBSTACLES_BUTTON = "REMOVING_OBSTACLES_BUTTON";

    public static final String RANDOM_GENERATE = "RANDOM_GENERATE";
    public static final String CLEAN_MAP = "CLEAN_MAP";

    public static final String CHANGE_CHOSEN_TILE = "CHANGE_CHOSEN_TILE";

    private Board board;
    private Field chosenGuiTile;


    public MapEditorEngine(Board board)
    {
        observerSupport = new PropertyChangeSupport(this);
        this.board = board;
        activePointThread = new ActivePointThread(this);
        activePointThread.start();
        chosenGuiTile = null;
    }

    public Field getChosenGuiTile() {
        return chosenGuiTile;
    }

    public void setChosenGuiTile(Field chosenGuiTile) {
        notifyObservers(new PropertyChangeEvent(this, CHANGE_CHOSEN_TILE, null, null));
        this.chosenGuiTile = chosenGuiTile;
    }

    public void terminateThread()
    {
       activePointThread.stopThread();
    }

    public void addObserver(String aEventType, PropertyChangeListener aObs)
    {
        observerSupport.addPropertyChangeListener(aEventType, aObs);
    }

    public void removeObserver(PropertyChangeListener aObs){
        observerSupport.removePropertyChangeListener(aObs);
    }

    void notifyObservers(PropertyChangeEvent aEvent){
        observerSupport.firePropertyChange(aEvent);
    }

    public void notifyNotifier(String event, boolean bool)
    {
        notifyObservers(new PropertyChangeEvent(this,event,null,bool));
    }

    public void add()
    {
        if(activePoint!= null && getChosenGuiTile() != null)
        {
            board.add(new Point(activePoint.getX(),activePoint.getY()),getChosenGuiTile());
            removeActivePoint();
            removeChosenGuiTile();
            notifyObservers(new PropertyChangeEvent(this,ADDING_OBSTACLES,null, false));
        }else return ;
    }

    private void removeChosenGuiTile()
    {
        this.chosenGuiTile=null;
    }

    public void setActivePoint(Point activePoint)
    {
        this.activePoint=activePoint;
    }

    public Point getActivePoint()
    {
        return activePoint;
    }

    public boolean isActiveTileTaken()
    {
        return board.isTileTaken(activePoint);
    }

    public void removeActivePoint() {
        activePoint=null;
    }

    public void save() throws IOException {
        Writer writer = new FileWriter("result.json");
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
        gson.toJson(board.getFieldsMap(), writer);
        writer.close();
        notifyObservers(new PropertyChangeEvent(this, SAVING_OBSTACLES, null, null));
    }

    public void remove() {
        if (activePoint != null && board.get(activePoint.getX(), activePoint.getY()) != null) {
            board.remove(new Point(activePoint.getX(), activePoint.getY()));
            removeActivePoint();
            notifyObservers(new PropertyChangeEvent(this, REMOVING_OBSTACLES, null, false));
        }
        else return ;
    }

    public void clean()
    {
        board.removeAll();
        removeActivePoint();
        notifyObservers(new PropertyChangeEvent(this, CLEAN_MAP, null, null));
    }

    public GuiTile get(int aX, int aY) {
        return board.get(aX,aY);
    }

    public Field getField(int aX, int aY)
    {
        return board.getField(aX,aY);
    }

    public void randomGenerate() {
        board.removeAll();
        Random random = new Random();
        int randomAmountOfObstacles = random.nextInt(19*14);
        int randomX,randomY;
        // potem bedzie bazowal na Enumie z fabryki
        List<GuiTile> guiTileList = Arrays.asList(new RockTile(), new LavaTile());
        for(int i=0;i<randomAmountOfObstacles;i++)
        {
            randomX= random.nextInt(18) + 1;
            randomY = random.nextInt(15);
            if(!board.isTileTaken(new Point(randomX,randomY))) {
                board.add(new Point(randomX, randomY),guiTileList.get((randomX+randomY)%2));
            }else continue;
        }
        notifyObservers(new PropertyChangeEvent(this, RANDOM_GENERATE, null, null));

    }
}
