package abilities.battlecries;

import abilities.Battlecry;
import cardLogic.card.Card;
import game.Player;

public class KillCry extends Battlecry {
    public KillCry(String name) {
        super(name);
    }

    public void doKillCry(Player opponent) {
        Card randomCard = opponent.getCardsOnField().getRandomCard();
        if (opponent.getCardsOnField().checkListSize() > 0) {
            opponent.getCardsOnField().remove(randomCard);
            opponent.getGraveyard().add(randomCard);
        } else {
            System.err.println("no minions to kill");
        }
    }
}
