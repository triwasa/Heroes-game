package pl.sdk;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.sdk.creatures.GuiTile;
import pl.sdk.creatures.LavaTile;
import pl.sdk.creatures.RockTile;
import pl.sdk.special_fields.Field;
import pl.sdk.special_fields.FieldsFactory;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

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
        return board.isTileTakenByField(activePoint);
    }

    public void removeActivePoint() {
        activePoint=null;
    }

    public void save() throws IOException, JAXBException {

        JAXBContext context = JAXBContext.newInstance(Holder.class);
        JAXBContext contextPoint = JAXBContext.newInstance(PointHolder.class);
        Holder holder = new Holder();
        PointHolder pointHolder = new PointHolder();
        Set<Point> list = board.getFieldsMap().keySet();
        List<Field> guiTileList = board.getFieldsMap().values().stream().collect(Collectors.toList());
        guiTileList.stream().forEach((p)-> holder.addThing(p));
        list.stream().forEach((p)->pointHolder.addThing(p) );

        Marshaller jaxbMarshaller = contextPoint.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(pointHolder, new File("point.xml"));

        Marshaller jaxFields = context.createMarshaller();
        jaxFields.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxFields.marshal(holder, new File("fields.xml"));

        notifyObservers(new PropertyChangeEvent(this, SAVING_OBSTACLES, null, null));
    }

    public void remove() {
        if (activePoint != null && board.getField(activePoint.getX(), activePoint.getY()) != null) {
            board.removeField(new Point(activePoint.getX(), activePoint.getY()));
            removeActivePoint();
            notifyObservers(new PropertyChangeEvent(this, REMOVING_OBSTACLES, null, false));
        }
        else return ;
    }

    public void clean()
    {
        board.removeAllFields();
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
        board.removeAllFields();
        Random random = new Random();
        int randomAmountOfObstacles = random.nextInt(19*14);
        int randomX,randomY;
        // potem bedzie bazowal na Enumie z fabryki
        List<Field> guiTileList = Arrays.asList(FieldsFactory.create("Lava"),FieldsFactory.create("Stone"),FieldsFactory.create("Water"));
        for(int i=0;i<randomAmountOfObstacles;i++)
        {
            randomX= random.nextInt(18) + 1;
            randomY = random.nextInt(15);
            if(!board.isTileTakenByField(new Point(randomX,randomY))) {
                board.add(new Point(randomX, randomY),guiTileList.get((randomX+randomY)%3));
            }else continue;
        }
        notifyObservers(new PropertyChangeEvent(this, RANDOM_GENERATE, null, null));

    }
}
