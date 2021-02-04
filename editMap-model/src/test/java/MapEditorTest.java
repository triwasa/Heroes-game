
import org.junit.jupiter.api.Test;
import pl.sdk.Board;
import pl.sdk.MapEditorEngine;
import pl.sdk.Point;
import pl.sdk.special_fields.FieldsFactory;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class MapEditorTest {

    @Test
    void creatingBoard()
    {
        Board board = new Board();
        board.add(new Point(2,2), FieldsFactory.create("Lava"));
        MapEditorEngine mapEditorEngine = new MapEditorEngine(board);

        assertEquals(mapEditorEngine.getField(2,2), board.getFieldsMap().get(new Point(2,2)));
    }
}
