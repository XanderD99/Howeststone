package abilities;

import cardLogic.card.Ability;
import cardLogic.card.Minion;
import org.junit.Test;
import static org.junit.Assert.*;

public class DivineShieldTest {

    @Test
    public void testDivineShieldTrue(){
        Minion m1 = new Minion("e2", 2, "derp", "img", "mage", 5, 2, new DivineShield(true, "DivineShield"));
        Minion m2 = new Minion("ezefz8", 2, "derp", "img", "mage", 10, 3, null);
        int preDefendedAttackHealth = m1.getHealth();

        m2.attack(m1);
        int afterDefendedAttackHealth = m1.getHealth();

        assertEquals(preDefendedAttackHealth, afterDefendedAttackHealth);
        m2.attack(m1);

        int afterNormalAttackHealth = m1.getHealth();

        assertNotEquals(afterDefendedAttackHealth, afterNormalAttackHealth);
    }

    @Test
    public void testDivineShieldFalse(){
        Minion m1 = new Minion("e2", 2, "derp", "img", "mage", 5, 2, new DivineShield(false, "DivineShield"));
        Minion m2 = new Minion("ezefz8", 2, "derp", "img", "mage", 10, 3, null);

        int preDefendedAttackHealth = m1.getHealth();
        m2.attack(m1);
        int afterDefendedAttackHealth = m1.getHealth();
        assertNotEquals(preDefendedAttackHealth, afterDefendedAttackHealth);
    }
}
