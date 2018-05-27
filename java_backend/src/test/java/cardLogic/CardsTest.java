package cardLogic;


import cardLogic.card.Card;
import cardLogic.card.Minion;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CardsTest {

    @Test
    public void addCard() {
        Cards cards = new Cards();

        Card card = new Minion("1a", 1, "derp", "img", "Mage",  5, 5, null);
        Card card2 = new Minion("2a", 1, "derp", "img", "Mage", 5, 5, null);
        Card card3 = new Minion("3a", 1, "derp", "img", "Mage",  5, 5, null);
        cards.add(card);
        cards.add(card);
        cards.add(card2);

        assertEquals(card, cards.getCardById("1a"));

        assertEquals(3, cards.checkListSize());
    }

    @Test
    public void removeCard() {
        Cards cards = new Cards();

        Card card = new Minion("1a", 1, "derp", "img", "Mage",  5, 5, null);
        Card card2 = new Minion("2a", 1, "derp", "img", "Mage", 5, 5, null);
        Card card3 = new Minion("3a", 1, "derp", "img", "Mage",  5, 5, null);
        cards.add(card);
        cards.add(card);
        cards.add(card2);

        cards.remove(card2);
        cards.remove(card);

        assertNotEquals(card2, cards.getCardById("2a"));

        assertEquals(card, cards.getCardById("1a"));

        assertEquals(1, cards.checkListSize());
    }
}