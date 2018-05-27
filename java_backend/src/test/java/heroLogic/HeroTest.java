package heroLogic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeroTest {

    @Test
    public void health() {
        Hero hero = new Hero("Mage");

        assertEquals(30, hero.getHealth());
        hero.loseHealth(4);
        hero.gainHealth(5);
        assertEquals(30, hero.getHealth());
    }

    @Test
    public void heroPower() {
        Hero hero = new Hero("Mage");

        //assertEquals(HeroPower.FIREBLAST, hero.getHeroPower());
    }
}