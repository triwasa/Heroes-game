package pl.sdk.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sdk.Board;

public class Start extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("fxml/battleMap.fxml"));
        loader.setController(new MapEditorController(new Board()));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setX(5);
        stage.setY(5);
        stage.show();
    }
}
