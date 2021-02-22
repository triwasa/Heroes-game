package pl.sdk.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sdk.hero.EconomyHero;
import static pl.sdk.hero.HeroClassName.*;

public class EconomyStart extends Application {

    @Override
    public void start(Stage aStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("fxml/eco.fxml"));
        // TODO: implement choosing heroClassName
        loader.setController(new EcoController(new EconomyHero(DEATH_KNIGHT,  3000), new EconomyHero(DEATH_KNIGHT , 3000)));
        Scene scene = new Scene(loader.load());
        aStage.setScene(scene);
        aStage.setX(5);
        aStage.setY(5);
        aStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
