package cardLogic.card;

import abilities.DivineShield;
import heroLogic.Hero;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinionTest {

    @Test
    public void testHealth() {
        Minion m = new Minion("20", 2, "MinionCard", "myMinion.img", "hunter", null, 5, 3, new DivineShield(true, "DivineShield"));
        int health = m.getHealth();
        assertEquals(5, health);
    }


    @Test
    public void testGetAtt() {
        Minion m = new Minion("20", 2, "MinionCard", "myMinion.img", "hunter", null, 5, 3, new DivineShield(true, "DivineShield"));
        int attVal = m.getAttValue();
        assertEquals(3, attVal);
    }

    @Test
    public void testAttackMinion() {
        Minion m1 = new Minion("e2", 2, "derp", "img", "mage", null, 5, 2, new DivineShield(true, "DivineShield"));
        Minion m2 = new Minion("ezefz8", 2, "derp", "img", "mage", null, 10, 3, null);
        m1.attack(m2);
        int m2Health = m2.getHealth();
        assertEquals(8, m2Health);
    }

    @Test
    public void testAttackHero() {
        Minion m = new Minion("e2", 2, "derp", "img", "mage", null, 5, 2, null);
        Hero hero = new Hero("Hunter");
        m.attack(m, hero);
        assertEquals(28, hero.getHealth());
    }

    @Test
    public void heal() {
        Minion m = new Minion("e2", 2, "derp", "img", "mage", null, 5, 2, null);
        m.heal(3, m);
        assertEquals(8, m.getHealth());
    }

    @Test
    public void attackBoost() {
        Minion m = new Minion("e2", 2, "derp", "img", "mage", null, 5, 2, null);
        m.attackBoost(5, m);
        assertEquals(7, m.getAttValue());
    }

    @Test
    public void testGainHealth() {
        Minion m = new Minion("20", 2, "MinionCard", "myMinion.img", "hunter", null, 5, 3, null);
        int currentHealth = m.getHealth(); //5
        int toGain = 5;
        int newHealthTotal = m.gainHealth(toGain); //10
        assertEquals(currentHealth + 5, newHealthTotal);
    }

    @Test
    public void testLoseHealth() {
        Minion m = new Minion("20", 2, "MinionCard", "myMinion.img", "hunter", null, 10, 3, null);
        int currentHealth = m.getHealth(); //10
        int toLose = 5;
        int newHealthTotal = m.loseHealth(toLose);
        assertEquals(currentHealth - 5, newHealthTotal);
    }
}