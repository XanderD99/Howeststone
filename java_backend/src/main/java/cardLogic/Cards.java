package cardLogic;

import cardLogic.card.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Cards {
    private List<Card> cards = new ArrayList<>();
    private int deckId;

    public Cards() {
    }

    public Cards(String deckId) {

    }

    public void setDeckId(int deckId) {
        this.deckId = deckId;
    }

    public int getDeckId() {
        return deckId;
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

    public int checkListSize() {
        return this.cards.size();
    }

    public void clear() {
        cards.clear();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public void remove(Card card) {
        cards.remove(card);
    }

    public Card getCardById(String cardId) {
        for (Card card : cards) {
            if (card.getId().equals(cardId)) {
                return card;
            }
        }
        return null;
    }

    public Card getCard(Card card) {
        for (Card c : cards) {
            if (c.getId().equals(card.getId())){
                return card;
            }
        }
        return null;
    }

    public void clearTable() {

    }

    public Card getRandomCard() {
        if (cards.size() > 0) {
            Random randomizer = new Random();
            return cards.get(randomizer.nextInt(cards.size()));
        }
        return null;
    }


    @Override
    public String toString() {
        return "Cards{" +
                "cards=" + cards +
                '}';
    }
}
