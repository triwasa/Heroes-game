package pl.sdk;


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

    private List<Point> activePointList;
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
        activePointList= new ArrayList<>();
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

    public void addFieldBySingleClick(int aX,int aY)
    {
        if(activePointList != null && getChosenGuiTile() != null && !board.isTileTakenByField(new Point(aX,aY))) {
            board.add(new Point(aX,aY), getChosenGuiTile());
            notifyObservers(new PropertyChangeEvent(this,ADDING_OBSTACLES_BUTTON,null, false));
        }
    }

    public void add()
    {
        if(activePointList != null && getChosenGuiTile() != null)
        {
            activePointList.stream().forEach((e) -> {
                board.add(new Point(e.getX(),e.getY()),getChosenGuiTile());
            });
            removeAllActivePoint();
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
        activePointList.add(activePoint);
    }

    public boolean isPointInActivePointList(int aX,int aY)
    {
        return activePointList.contains(new Point(aX,aY));
    }

    public Integer isActivePointListEmpty() {
        return activePointList.size();
    }

    public boolean isActiveTileTaken()
    {
        boolean taken= false;
        for(int i=0;i<activePointList.size();i++)
        {
            if(board.isTileTakenByField(activePointList.get(i))) taken=true;
        }
        return taken;
    }

    public void removeActivePoint(int aX,int aY) {
        int indexOf = activePointList.indexOf(new Point(aX,aY));
        if(indexOf != -1)
        {
            activePointList.remove(indexOf);
        }
    }

    public void save() throws  JAXBException {

        JAXBContext context = JAXBContext.newInstance(FieldsHolder.class);
        JAXBContext contextPoint = JAXBContext.newInstance(PointHolder.class);
        FieldsHolder holder = new FieldsHolder();
        PointHolder pointHolder = new PointHolder();
        Set<Point> list = board.getFieldsMap().keySet();
        List<Field> guiTileList = board.getFieldsMap().values().stream().collect(Collectors.toList());
        guiTileList.stream().forEach((p)-> holder.addThing(p.getFieldName()));
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
        if (isActivePointListEmpty() != 0 ) {
            activePointList.stream().forEach((e)->
            {
                if(board.isTileTakenByField(new Point(e.getX(),e.getY()))) {
                    board.removeField(new Point(e.getX(), e.getY()));
                }
            });
            removeAllActivePoint();
            notifyObservers(new PropertyChangeEvent(this, REMOVING_OBSTACLES, null, false));
        }
         return ;
    }
    void removeAllActivePoint()
    {
        activePointList.clear();
    }

    public void clean()
    {
        board.removeAllFields();
        removeAllActivePoint();
        notifyObservers(new PropertyChangeEvent(this, CLEAN_MAP, null, null));
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

        List<Field> guiTileList = Arrays.asList(FieldsFactory.create("Lava"),FieldsFactory.create("Stone"),FieldsFactory.create("Water"),FieldsFactory.create("Poison"),FieldsFactory.create("Mountain"),FieldsFactory.create("Charm"),FieldsFactory.create("ThunderStorm"),FieldsFactory.create("Wall"));
        for(int i=0;i<randomAmountOfObstacles;i++)
        {
            randomX= random.nextInt(18) + 1;
            randomY = random.nextInt(15);
            if(!board.isTileTakenByField(new Point(randomX,randomY))) {
                board.add(new Point(randomX, randomY),guiTileList.get((randomX+randomY)% guiTileList.size()));
            }else continue;
        }
        notifyObservers(new PropertyChangeEvent(this, RANDOM_GENERATE, null, null));

    }

    public void setBoard(Board board)
    {
        this.board=board;
    }
}
