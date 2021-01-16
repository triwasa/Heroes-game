package pl.sdk.creatures;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Test;
import pl.sdk.warMachines.WarMachinesStatisticIf;

import static org.junit.jupiter.api.Assertions.*;

class CatapultTest {

    @Test
    public void shouldAttackWalls(){
        Catapult catapult = new Catapult();
        Wall wall = new Wall();
        catapult.damage= Range.closed(1,1);
        catapult.attack(wall);

        assertEquals(1, wall.getCurrentHp());




    }

}