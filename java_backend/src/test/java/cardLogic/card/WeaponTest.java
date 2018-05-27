package cardLogic.card;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeaponTest {
    @Test
    public void testAttVal(){
        Weapon w = new Weapon("2", 2, "Slicer", "myImg.png", "hunter", "ab", 2, 4);
        int attVal = w.getAttValue();
        assertEquals(2, attVal);
    }

    @Test
    public void testGetDurability(){
        Weapon w = new Weapon("2", 2, "Slicer", "myImg.png", "hunter", "ab", 2, 4);
        int durability = w.getDurability();
        assertEquals(4, durability);
    }

    @Test
    public void testDurability(){

    }
}
