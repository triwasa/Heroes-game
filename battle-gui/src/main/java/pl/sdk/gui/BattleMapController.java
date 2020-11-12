package pl.sdk.gui;

import com.google.common.collect.Range;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import pl.sdk.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class BattleMapController implements PropertyChangeListener {

    @FXML
    private GridPane gridMap;

    @FXML
    private Button passButton;

    private final GameEngine gameEngine;

    public BattleMapController() {
        List<Creature> notUpgradedCreatures = new ArrayList<>();

        Creature c;
        c = new Creature.Builder()
                .name("Skeleton")
                .maxHp(6)
                .attack(5)
                .armor(4)
                .damage(Range.closed(1,3))
                .moveRange(4)
                .amount(70)
                .build();
        notUpgradedCreatures.add(c);
        c = new Creature.Builder()
                .name("Walking Dead")
                .maxHp(15)
                .attack(5)
                .armor(5)
                .damage(Range.closed(2,3))
                .moveRange(3)
                .amount(60)
                .build();
        notUpgradedCreatures.add(c);
        c = new Creature.Builder()
                .name("Wight")
                .maxHp(18)
                .attack(7)
                .armor(7)
                .damage(Range.closed(3,5))
                .moveRange(5)
                .amount(50)
                .build();
        notUpgradedCreatures.add(c);
        c = new Creature.Builder()
                .name("Vampire")
                .maxHp(30)
                .attack(10)
                .armor(9)
                .damage(Range.closed(5,8))
                .moveRange(6)
                .amount(40)
                .build();
        notUpgradedCreatures.add(c);
        c = new ShootingCreature.Builder()
                .name("Lich")
                .maxHp(30)
                .attack(13)
                .armor(10)
                .damage(Range.closed(11,13))
                .moveRange(6)
                .amount(30)
                .build();
        notUpgradedCreatures.add(c);
        c = new Creature.Builder()
                .name("Black Knight")
                .maxHp(120)
                .attack(16)
                .armor(16)
                .damage(Range.closed(15,30))
                .damageCalculator(new CalculateDamageIncreaseWithRandomChanceStrategy(0.2,2.0))
                .moveRange(7)
                .amount(20)
                .build();
        notUpgradedCreatures.add(c);
        c = new Creature.Builder()
                .name("Bone Dragon")
                .maxHp(150)
                .attack(17)
                .armor(15)
                .damage(Range.closed(25,50))
                .moveRange(9)
                .amount(10)
                .build();
        notUpgradedCreatures.add(c);

        List<Creature> upgradedCreatures = new ArrayList<>();
        c = new Creature.Builder()
                .name("Skeleton Warrior")
                .maxHp(6)
                .attack(6)
                .armor(6)
                .damage(Range.closed(1,3))
                .moveRange(5)
                .amount(75)
                .build();
        upgradedCreatures.add(c);
        c = new Creature.Builder()
                .name("Zombie")
                .maxHp(20)
                .attack(5)
                .armor(5)
                .damage(Range.closed(2,3))
                .moveRange(4)
                .amount(65)
                .build();
        upgradedCreatures.add(c);
        c = new Creature.Builder()
                .name("Wraith")
                .maxHp(18)
                .attack(7)
                .armor(7)
                .damage(Range.closed(3,5))
                .moveRange(7)
                .amount(55)
                .build();
        upgradedCreatures.add(c);
        c = new Creature.Builder()
                .name("Vampire Lord")
                .maxHp(40)
                .attack(10)
                .armor(10)
                .damage(Range.closed(5,8))
                .moveRange(9)
                .amount(45)
                .build();
        upgradedCreatures.add(c);
        c = new ShootingCreature.Builder()
                .name("Power Lich")
                .maxHp(40)
                .attack(13)
                .armor(10)
                .damage(Range.closed(11,15))
                .moveRange(7)
                .amount(35)
                .build();
        upgradedCreatures.add(c);
        c = new Creature.Builder()
                .name("Dread Knight")
                .maxHp(120)
                .attack(18)
                .armor(18)
                .damage(Range.closed(15,30))
                .damageCalculator(new CalculateDamageIncreaseWithRandomChanceStrategy(0.2,2.0))
                .moveRange(9)
                .amount(25)
                .build();
        upgradedCreatures.add(c);
        c = new Creature.Builder()
                .name("Bone Dragon")
                .maxHp(200)
                .attack(19)
                .armor(17)
                .damage(Range.closed(25,50))
                .moveRange(14)
                .amount(15)
                .build();
        upgradedCreatures.add(c);

        gameEngine = new GameEngine(notUpgradedCreatures, upgradedCreatures);

    }

    @FXML
    void initialize() {
        gameEngine.addObserver(GameEngine.CURRENT_CREATURE_CHANGED,this);
        gameEngine.addObserver(GameEngine.CREATURE_MOVED,this);
        gameEngine.addObserver(GameEngine.CREATURE_ATTACKED,this);

        passButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            gameEngine.pass();
        });

        refreshGui();
    }

    private void refreshGui() {
        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 15; y++) {
                MapTile rec = new MapTile();
                gridMap.add(rec, x, y);

                Creature c = gameEngine.get(x, y);
                if (c != null) {
                    rec.addCreature(c.getName(), c.getAmount());

                    if(c == gameEngine.getActiveCreature()){
                        rec.setBackground(Color.GREEN);
                    }
                    else if(gameEngine.canAttack(x,y)){
                        final int x1 = x;
                        final int y1 = y;
                        rec.setBackground(Color.RED);
                        rec.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> gameEngine.attack(x1,y1));
                    }
                }
                else if(gameEngine.canMove(x,y)){
                    final int x1 = x;
                    final int y1 = y;
                    rec.setBackground(Color.GREY);
                    rec.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> gameEngine.move(new Point(x1,y1)));
                }

            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        refreshGui();
    }
}
