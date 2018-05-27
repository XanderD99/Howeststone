package abilities.battlecries;

import abilities.Battlecry;
import cardLogic.card.Card;
import game.Player;

public class SheepCry extends Battlecry {
    public SheepCry(String name) {
        super(name);
    }

    public void doSheepCry(Player opponent) {
        Card randomCard = opponent.getCardsOnField().getRandomCard();
        Card sheepCard = opponent.getSpecialCards().getCardById("CS2_tk1");
        if (opponent.getCardsOnField().checkListSize() > 0) {
            opponent.getCardsOnField().remove(randomCard);
            opponent.getGraveyard().add(randomCard);
            opponent.getCardsOnField().add(sheepCard);
        } else {
            System.err.println("no minions to Polymorph");
        }
    }
}
