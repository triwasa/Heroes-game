import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.Board;
import pl.sdk.MapEditorEngine;
import pl.sdk.Point;
import pl.sdk.special_fields.Field;
import pl.sdk.special_fields.FieldsFactory;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class AddingAndRemovingFieldsTest {

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
    void addingTest() {
        mapEditorEngine.setActivePoint(new Point(3, 3));
        mapEditorEngine.setActivePoint(new Point(4, 4));
        mapEditorEngine.setChosenGuiTile(FieldsFactory.create("Lava"));
        mapEditorEngine.add();
        board.add(new Point(3,3), FieldsFactory.create("Lava"));
        board.add(new Point(4,4), FieldsFactory.create("Lava"));
        assertEquals(mapEditorEngine.getField(2,2), board.getFieldsMap().get(new Point(2,2)));
        assertEquals(mapEditorEngine.getField(3,3), board.getFieldsMap().get(new Point(3,3)));
        assertEquals(mapEditorEngine.getField(4,4), board.getFieldsMap().get(new Point(4,4)));
    }

    @Test
    void deletingTest()
    {
        mapEditorEngine.setActivePoint(new Point(2,2));
        mapEditorEngine.remove();
        Field normal = FieldsFactory.create("Normal");
        assertEquals(mapEditorEngine.getField(2,2).getName(), normal.getName());
    }
}
