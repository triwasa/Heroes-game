package pl.sdk.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pl.sdk.EconomyEngine;
import pl.sdk.creatures.EconomyCreature;
import pl.sdk.creatures.EconomyNecropolisFactory;
import pl.sdk.hero.EconomyHero;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class EcoController implements PropertyChangeListener {
    @FXML
    HBox heroStateHBox;
    @FXML
    HBox shopsBox;
    @FXML
    Button readyButton;
    private final EconomyEngine economyEngine;

    public EcoController(EconomyHero aHero1, EconomyHero aHero2) {
        economyEngine = new EconomyEngine(aHero1, aHero2);
    }

    @FXML
    void initialize(){
        refreshGui();
        economyEngine.addObserver(EconomyEngine.ACTIVE_HERO_CHANGED,this);
        economyEngine.addObserver(EconomyEngine.HERO_BOUGHT_CREATURE,this);
        economyEngine.addObserver(EconomyEngine.NEXT_ROUND,this);

        readyButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) ->
        {
            if (economyEngine.getRoundNumber() < 4){
                economyEngine.pass();
            }
            else{
                goToBattle();
            }
        });
    }

    private void goToBattle() {
        Scene scene = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("fxml/battleMap.fxml"));
//            loader.setController(new BattleMapController(creatureList,creatureList2));
            scene = new Scene(loader.load());
            Stage aStage = new Stage();
            aStage.setScene(scene);
            aStage.setX(5);
            aStage.setY(5);
            aStage.show();
        } catch (IOException aE) {
            aE.printStackTrace();
        }
    }

    void refreshGui() {
        shopsBox.getChildren().clear();
        heroStateHBox.getChildren().clear();

        EconomyNecropolisFactory factory = new EconomyNecropolisFactory();
        VBox creatureShop = new VBox();
        for (int i = 1; i < 8; i++) {
            creatureShop.getChildren().add(new CreatureButton(this, factory, false,i));
            creatureShop.getChildren().add(new CreatureButton(this, factory, true,i));
        }
        shopsBox.getChildren().add(creatureShop);

        VBox creaturesBox = new VBox();
        economyEngine.getActiveHero().getCreatures().forEach(c ->
        {
            HBox tempHbox = new HBox();
            tempHbox.getChildren().add(new Label(String.valueOf(c.getAmount())));
            tempHbox.getChildren().add(new Label(c.getName()));
            creaturesBox.getChildren().add(tempHbox);
        });
        heroStateHBox.getChildren().add(creaturesBox);
    }

    void buy(EconomyCreature aCreature) {
        economyEngine.buy(aCreature);
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        refreshGui();
    }
}
