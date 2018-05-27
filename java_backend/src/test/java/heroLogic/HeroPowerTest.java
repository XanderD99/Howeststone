package heroLogic;

import cardLogic.card.Minion;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeroPowerTest {

    @Test
    public void testFireBlastOnHero() {
        Hero h = new Hero("Mage");
        Hero h2 = new Hero("Hunter");
        int healthpre = h2.getHealth();
        h.useHeropower(h2);
        int healthafter = h2.getHealth();
        assertEquals(healthpre - 1, healthafter);
    }

    @Test
    public void testFireBlastOnMinion() {
        Hero h = new Hero("Mage");
        Minion m = new Minion("20", 2, "MinionCard", "myMinion.img", "hunter", null, 5, 3, null);

        int healthpre = m.getHealth();
        h.useHeropower(m);
        int healthafter = m.getHealth();
        assertEquals(healthpre - 1, healthafter);
    }

    @Test
    public void testSteadyshot() {
        Hero h = new Hero("Hunter");
        Hero h2 = new Hero("Mage");

        int healthpre = h2.getHealth();
        h.useHeropower(h2);
        int healthafter = h2.getHealth();

        assertEquals(healthpre - 2, healthafter);
    }
}
