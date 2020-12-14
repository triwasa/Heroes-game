package pl.sdk.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EcoController {
    @FXML
    HBox heroStateHBox;
    @FXML
    HBox shopsBox;
    @FXML
    Button readyButton;
    private final List<Creature> creatureList;
    private final List<Creature> creatureList2;
    private List<Creature> currentCreatureList;
    private int roundCounter;

    public EcoController() {
        creatureList = new ArrayList<>();
        creatureList2 = new ArrayList<>();
        currentCreatureList = creatureList;
        roundCounter = 1;
    }

    @FXML
    void initialize(){
        refreshGui();
        readyButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) ->
        {
            if (currentCreatureList == creatureList){
                currentCreatureList = creatureList2;
            }
            else
            {
                currentCreatureList = creatureList;
                roundCounter += 1;
            }

            if (roundCounter < 4){
                refreshGui();
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
            loader.setController(new BattleMapController(creatureList,creatureList2));
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

        NecropolisFactory factory = new NecropolisFactory();
        VBox creatureShop = new VBox();
        for (int i = 1; i < 8; i++) {
            creatureShop.getChildren().add(new CreatureButton(this, factory, false,i));
            creatureShop.getChildren().add(new CreatureButton(this, factory, true,i));
        }
        shopsBox.getChildren().add(creatureShop);

        VBox creaturesBox = new VBox();

        currentCreatureList.forEach(c ->
        {
            HBox tempHbox = new HBox();
            tempHbox.getChildren().add(new Label(String.valueOf(c.getAmount())));
            tempHbox.getChildren().add(new Label(c.getName()));
            creaturesBox.getChildren().add(tempHbox);
        });
        heroStateHBox.getChildren().add(creaturesBox);
    }

    void buy(Creature aCreature) {
        currentCreatureList.add(aCreature);
    }
}
