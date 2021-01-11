package pl.sdk.gui;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import pl.sdk.MapEditorEngine;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DecoratedAddingButton extends Button implements PropertyChangeListener  {


    DecoratedAddingButton(MapEditorEngine mapEditorEngine)
    {
        super("Add");
        setDisable(true);
        addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
           mapEditorEngine.add();
        });
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals(MapEditorEngine.ADDING_OBSTACLES_BUTTON))
        {
            setDisable((Boolean) evt.getNewValue());
        }
    }
}
