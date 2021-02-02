import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdk.Board;
import pl.sdk.MapEditorEngine;
import pl.sdk.Point;
import pl.sdk.special_fields.FieldsFactory;

import static org.junit.jupiter.api.Assertions.*;

public class CleaningTest {

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
    void cleaningTest()
    {
        mapEditorEngine.clean();
        assertEquals(mapEditorEngine.getField(2,2).getName(),FieldsFactory.create("Normal").getName());
    }
}
