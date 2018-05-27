package abilities.battlecries;

import abilities.Battlecry;
import cardLogic.card.Card;
import cardLogic.card.Minion;
import game.Player;

public class ForceHealthCry extends Battlecry {
    private int amount;

    public ForceHealthCry(int amount, String name) {
        super(name);
        this.amount = amount;
    }

    public void doForceHealthCry(Player opponent) {
        Card randomCard = opponent.getCardsOnField().getRandomCard();
        if (opponent.getCardsOnField().checkListSize() > 0) {
            ((Minion) opponent.getCardsOnField().getCard(randomCard)).setHealth(amount);
        } else {
            System.err.println("no minions to force health");
        }
    }
}
