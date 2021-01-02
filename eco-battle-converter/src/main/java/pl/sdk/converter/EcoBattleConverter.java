package pl.sdk.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sdk.Board;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;
import pl.sdk.gui.BattleMapController;
import pl.sdk.gui.MapEditorController;
import pl.sdk.hero.EconomyHero;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EcoBattleConverter {

    public static void startBattle(EconomyHero aPlayer1, EconomyHero aPlayer2) {
        Scene scene = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(EcoBattleConverter.class.getClassLoader().getResource("fxml/battleMap.fxml"));
            loader.setController(new BattleMapController(convert(aPlayer1),convert(aPlayer2)));
            scene = new Scene(loader.load());
//            ObjectMapper objectMapper = new ObjectMapper();
//            Board board = objectMapper.readValue(new File("result.json"), Board.class);
            Stage aStage = new Stage();
            aStage.setScene(scene);
            aStage.setX(5);
            aStage.setY(5);
            aStage.show();
        } catch (IOException aE) {
            aE.printStackTrace();
        }
    }

    public static List<Creature> convert(EconomyHero aPlayer1) {
        List<Creature>ret = new ArrayList<>();
        NecropolisFactory factory = new NecropolisFactory();
        aPlayer1.getCreatures().forEach(ecoCreature ->
                ret.add(factory.create(ecoCreature.isUpgraded(),ecoCreature.getTier(),ecoCreature.getAmount())));
        return ret;
    }

    public static void startEditting()
    {
        Scene scene = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(EcoBattleConverter.class.getClassLoader().getResource("fxml/editorMap.fxml"));
            Board board = new Board();
            /*
            robiac setController musimy przekazac jakis plik zalozmy jsona z gotowa lista pol specjalnych
            czyli wczytujemy plik
            jak nie istnieje to przekazujemy pusta liste
            jak istnieje to mamy juz cos w boardzie
            es
            czyli json -> board
            i tak samo odpalaja walke, wiec trzeba zrobic deserializacje
             */
           loader.setController(new MapEditorController(board));
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

    private Board jsonToBoardConverter(File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Board boardOfObstacles = objectMapper.readValue(file,Board.class);
        return boardOfObstacles;
    }
}
