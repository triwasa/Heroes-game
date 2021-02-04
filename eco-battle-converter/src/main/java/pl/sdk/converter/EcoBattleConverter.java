package pl.sdk.converter;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import pl.sdk.Board;
import pl.sdk.Holder;
import pl.sdk.PointHolder;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.NecropolisFactory;
import pl.sdk.gui.BattleMapController;
import pl.sdk.gui.MapEditorController;
import pl.sdk.hero.EconomyHero;
import pl.sdk.hero.Hero;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
            aStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent windowEvent) {
                    try {
                        File file = new File(".").getCanonicalFile();
                        String fileWithPointsToString = file.toString()+"/point.xml";
                        String fileWithFieldsToString = file.toString()+"/fields.xml";
                        Files.deleteIfExists(Paths.get(fileWithPointsToString));
                        Files.deleteIfExists(Paths.get(fileWithFieldsToString));
//                    } catch (IOException | JAXBException aE) {
                    } catch (IOException aE) {
                        aE.printStackTrace();
                    }
                    aStage.close();
                }
            });
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


            MapEditorController mapEditorController = new MapEditorController(xmlToBoardConverter());
            loader.setController(mapEditorController);
            scene = new Scene(loader.load());
            Stage aStage = new Stage();
            aStage.setScene(scene);
            aStage.setX(5);
            aStage.setY(5);
            aStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent windowEvent) {
                    mapEditorController.terminateThread();
                    try {
                    mapEditorController.saveFile();
                    } catch (JAXBException aE) {
                        aE.printStackTrace();
                    }
                    aStage.close();
                }
            });
            aStage.show();
//        } catch (IOException | JAXBException aE) {
        } catch (IOException | JAXBException aE) {
            aE.printStackTrace();
        }
    }

    private static Board xmlToBoardConverter() throws IOException, JAXBException {
        Board board = new Board();

        JAXBContext contextFields = JAXBContext.newInstance(Holder.class);
        JAXBContext contextPoints = JAXBContext.newInstance(PointHolder.class);
        File file = new File("./fields.xml");
        if(file.canRead() && file.isFile()) {
            Holder holder1 = (Holder) contextFields.createUnmarshaller().unmarshal(new FileReader("./fields.xml"));
            PointHolder pointHolder1 = (PointHolder) contextPoints.createUnmarshaller().unmarshal(new FileReader("./point.xml"));

            for (int i = 0; i < holder1.getThings().size(); i++) {
                board.add(pointHolder1.getThings().get(i), holder1.getThings().get(i));
            }
        }
        return board;
    }

    public static Hero convertHero(EconomyHero economyHero) {
        return Converter.convert(economyHero);
    }
}
