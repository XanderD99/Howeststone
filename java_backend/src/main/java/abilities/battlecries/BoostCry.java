package abilities.battlecries;

import abilities.Battlecry;
import cardLogic.card.Card;
import cardLogic.card.Minion;
import game.Player;

public class BoostCry extends Battlecry {
    private int amount;

    public BoostCry(int amount, String name) {
        super(name);
        this.amount = amount;
    }

    public void doBoostCry(Player player) {
        switch (getName()) {
            case "+2_Health":
                boostHealth(player);
                break;
            case "+3_Health":
                boostHealth(player);
                break;
            case "+1/+1":
                boostHealthAttack(player);
                break;
            default:
                break;
        }
    }

    private void boostHealthAttack(Player player) {
        Card randomCard = player.getCardsOnField().getRandomCard();
        if (player.getCardsOnField().checkListSize() > 0) {
            ((Minion) player.getCardsOnField().getCard(randomCard)).gainHealth(amount);
            ((Minion) player.getCardsOnField().getCard(randomCard)).gainAttValue(amount);
        } else {
            System.err.println("no minion to boost");
        }
    }

    private void boostHealth(Player player) {
        Card randomCard = player.getCardsOnField().getRandomCard();
        if (player.getCardsOnField().checkListSize() > 0) {
            ((Minion) player.getCardsOnField().getCard(randomCard)).gainHealth(amount);
        } else {
            System.err.println("no minion to boost");
        }
    }
}
