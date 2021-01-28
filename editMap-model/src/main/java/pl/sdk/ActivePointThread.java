package pl.sdk;

public class ActivePointThread extends Thread{

    private boolean exit;
    private MapEditorEngine mapEditorEngine;

    ActivePointThread(MapEditorEngine mapEditorEngine)
    {
        super();
        this.mapEditorEngine=mapEditorEngine;
        exit = false;
    }

    @Override
    public void run() {
        while (!exit)
        {
            if(mapEditorEngine.isActivePointListEmpty() != 0)
            {
                if(mapEditorEngine.isActiveTileTaken())
                {
                    mapEditorEngine.notifyNotifier(MapEditorEngine.ADDING_OBSTACLES_BUTTON,false);
                    mapEditorEngine.notifyNotifier(MapEditorEngine.REMOVING_OBSTACLES_BUTTON,false);
                }else{
                    mapEditorEngine.notifyNotifier(MapEditorEngine.ADDING_OBSTACLES_BUTTON,false);
                }

            }else
            {
                mapEditorEngine.notifyNotifier(MapEditorEngine.ADDING_OBSTACLES_BUTTON,true);
                mapEditorEngine.notifyNotifier(MapEditorEngine.REMOVING_OBSTACLES_BUTTON,true);
            }
        }
    }

    public void stopThread()
    {
        exit = true;
    }
}
