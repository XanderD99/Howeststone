package game;

import cardLogic.card.Card;
import cardLogic.card.Minion;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Turn {

    private static Player currentPlayer;

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player player) {
        currentPlayer = player;
        increasePlayerMana();
        removeFatigue();
    }

    Turn() {
    }

    Turn(Player player) {
        currentPlayer = player;

        increasePlayerMana();
    }

    private void increasePlayerMana() {
        currentPlayer.increaseManaLimit();
    }

    private void removeFatigue() {
        List<Card> blep = new CopyOnWriteArrayList<>(currentPlayer.getCardsOnField().getCards());

        for (Card c : blep) {
            if (c instanceof Minion) {
                ((Minion) c).loseFatigue();
            }
        }

        currentPlayer.getHero().loseFatigue();
    }
}
