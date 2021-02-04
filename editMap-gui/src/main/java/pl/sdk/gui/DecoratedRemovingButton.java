package pl.sdk.gui;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import pl.sdk.MapEditorEngine;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DecoratedRemovingButton extends Button implements PropertyChangeListener {


    DecoratedRemovingButton(MapEditorEngine mapEditorEngine)
    {
        super("Remove");
        setDisable(true);
        addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            mapEditorEngine.remove();
        });
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals(MapEditorEngine.REMOVING_OBSTACLES_BUTTON))
        {
            setDisable((Boolean) evt.getNewValue());
        }
    }
}
