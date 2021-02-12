import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.*;
import pl.sdk.special_fields.FieldsFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class SavingTest {

    private Board board;
    private MapEditorEngine mapEditorEngine;
    @BeforeEach
    void init()
    {
        board = new Board();
        board.add(new Point(2,2), FieldsFactory.create("Lava"));
        mapEditorEngine = new MapEditorEngine(board);
    }

    @Test
    void savingTest() throws JAXBException, IOException {
        mapEditorEngine.save();

        Board boardFromFile = new Board();

        JAXBContext contextFields = JAXBContext.newInstance(FieldsHolder.class);
        JAXBContext contextPoints = JAXBContext.newInstance(PointHolder.class);
        File file = new File("fields.xml");
        System.out.println(file.getAbsolutePath());
        if(file.canRead() && file.isFile()) {
            FieldsHolder holder1 = (FieldsHolder) contextFields.createUnmarshaller().unmarshal(new FileReader("fields.xml"));
            PointHolder pointHolder1 = (PointHolder) contextPoints.createUnmarshaller().unmarshal(new FileReader("point.xml"));
            for (int i = 0; i < holder1.getThings().size(); i++) {
                boardFromFile.add(pointHolder1.getThings().get(i), holder1.getThings().get(i));
            }
        }
        assertEquals(boardFromFile.getFieldsMap().get(new Point(2,2)).getName(),board.getFieldsMap().get(new Point(2,2)).getName());
        assertEquals(boardFromFile.getFieldsMap().keySet(),board.getFieldsMap().keySet());

        File fileToDelete = new File(".").getCanonicalFile();
        String fileWithPointsToString = fileToDelete.toString()+"/point.xml";
        String fileWithFieldsToString = fileToDelete.toString()+"/fields.xml";
        Files.deleteIfExists(Paths.get(fileWithPointsToString));
        Files.deleteIfExists(Paths.get(fileWithFieldsToString));
    }
}
