package pl.sdk.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.checkerframework.checker.units.qual.C;
import pl.sdk.EconomyEngine;
import pl.sdk.artifacts.EconomyArtifact;
import pl.sdk.artifacts.EconomyArtifactPrimaryFactory;
import pl.sdk.converter.EcoBattleConverter;
import pl.sdk.creatures.EconomyCreature;
import pl.sdk.creatures.EconomyNecropolisFactory;
import pl.sdk.creatures.EconomyTowerFactory;
import pl.sdk.hero.EconomyHero;
import pl.sdk.skills.EconomySkill;
import pl.sdk.spell.EconomySpell;

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
    @FXML
    Label playerLabel;
    @FXML
    Label currentGoldLabel;
    @FXML
    Label roundNumberLabel;
    @FXML
    Button editMapButton;
    @FXML
    Button creatureShop;
    @FXML
    Button artifactShop;
    @FXML
    Button spellShop;
    @FXML
    Button skillShop;
    private final EconomyEngine economyEngine;

    public EcoController(EconomyHero aHero1, EconomyHero aHero2) {
        economyEngine = new EconomyEngine(aHero1, aHero2);
    }

    @FXML
    void initialize() {
        refreshGui();
        economyEngine.addObserver(EconomyEngine.ACTIVE_HERO_CHANGED, this);
        economyEngine.addObserver(EconomyEngine.HERO_BOUGHT_CREATURE, this);
        economyEngine.addObserver(EconomyEngine.HERO_BOUGHT_ARTIFACT, this);
        economyEngine.addObserver(EconomyEngine.HERO_BOUGHT_SKILL, this);
        economyEngine.addObserver(EconomyEngine.HERO_BOUGHT_SPELL,this);
        economyEngine.addObserver(EconomyEngine.NEXT_ROUND, this);

        readyButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) ->
        {
            if (economyEngine.getRoundNumber() == 3 && economyEngine.getActiveHero().equals(economyEngine.getPlayer2())) {
                goToBattle();
            } else {
                economyEngine.pass();
            }
        });

        editMapButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) ->
        {
            goToEditor();
        });

        artifactShop.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) ->
        {
            EconomyNecropolisFactory factory = new EconomyNecropolisFactory();
            VBox shop = new VBox();
            for (int i = 1; i < 8; i++) {
                shop.getChildren().add(new CreatureButton(this, factory, false, i));
                shop.getChildren().add(new CreatureButton(this, factory, true,i));
            }
            createShopButtons(shop);
        });
        creatureShop.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) ->
        {
            EconomyTowerFactory factory = new EconomyTowerFactory();
            VBox shop = new VBox();
            for (int i = 1; i < 8; i++) {
                shop.getChildren().add(new CreatureButton(this, factory, false, i));
                shop.getChildren().add(new CreatureButton(this, factory, true,i));
            }
            createShopButtons(shop);
        });
    }

    private void goToBattle() {
        EcoBattleConverter.startBattle(economyEngine.getPlayer1(), economyEngine.getPlayer2());
    }

    private void goToEditor() {
        EcoBattleConverter.startEditing();
    }
    void createShopButtons(VBox box) {
        shopsBox.getChildren().clear();
        shopsBox.getChildren().add(box);
        refreshGui();
    }

    void refreshGui() {
        playerLabel.setText(economyEngine.getActiveHero().toString());
        currentGoldLabel.setText(String.valueOf(economyEngine.getActiveHero().getGold()));
        roundNumberLabel.setText(String.valueOf(economyEngine.getRoundNumber()));
        heroStateHBox.getChildren().clear();


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
    void buyArtifact(EconomyArtifact artifact){economyEngine.buyArtifact(artifact);}
    void buySkill(EconomySkill aSkill){economyEngine.buySkill(aSkill);}
    void buySpell(EconomySpell aspell){economyEngine.buySpell(aspell);}

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        refreshGui();
    }
}
