package game;


import cardLogic.Cards;

import java.util.Random;

public class Game {
    private Player playerOne;
    private Player playerTwo;
    private Turn turn;


    public Game(String playerName, Cards playerCards, Cards botCards, Cards specialCards, String heroClass) {
        this.playerOne = new HumanPlayer(playerName, playerCards, specialCards, heroClass);
        this.playerTwo = new AiPlayer("opponent", botCards, specialCards, "Mage");
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public Turn getTurn() {
        return turn;
    }

    public void startGame() {
        //one player get's chosen to play first, first get's 3 cards
        //other player get's 3 with additional coin card.
        //first turn
        startCards(playerOne);
        startCards(playerTwo);
        System.out.println("start game");

        turn = new Turn(coinFlip());

        if(turn.getCurrentPlayer().equals(playerTwo)){
            AiPlay();
        }
    }

    private void endGame() {

    }

    private Player coinFlip() {
        Random random = new Random();
        return random.nextBoolean() ? playerOne : playerTwo;
    }

    private void startCards(Player player) {
        player.drawCard();
        player.drawCard();
        player.drawCard();

    }

    public void AiPlay(){
        playerTwo.play(playerOne);

        endTurn(playerTwo.getName());
    }

    public void endTurn(String pusher) {
        if (turn.getCurrentPlayer().getName().equals(pusher)){
            if (turn.getCurrentPlayer().equals(playerOne)) {
                playerTwo.drawCard();
                turn.setCurrentPlayer(playerTwo);

                AiPlay();
            } else {
                playerOne.drawCard();
                turn.setCurrentPlayer(playerOne);
            }
        }
        else{
            System.out.println("its not your turn friend");
        }
    }
}
