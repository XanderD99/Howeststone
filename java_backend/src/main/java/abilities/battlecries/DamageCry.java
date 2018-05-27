package abilities.battlecries;

import abilities.Battlecry;
import cardLogic.card.Card;
import cardLogic.card.Minion;
import game.Player;
import reusables.ReusableMethods;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DamageCry extends Battlecry {
    private int amount;


    public DamageCry(int amount, String name) {
        super(name);
        this.amount = amount;
    }

    public void doDamageCry(Player player, Player opponent) {
        switch (getName()) {
            case "2_damage_all_other_end_turn":
                damageAllOtherEndTurn(player, opponent);
                break;
            case "3_damage_2_random_enemy_minion":
                randomEnemyMinion(opponent);
                randomEnemyMinion(opponent);
                break;
            case "3_damage_enemy_hero":
                damageEnemyHero(opponent);
                break;
            case "3_damage_split_enemy":
                damageSplitEnemy(opponent);
                break;
            case "3_damage_split_random":
                damageSplitRandom(player, opponent);
                break;
            case "5_damage_2_damage_adjecent":
                damageWithAdjacent(opponent);
                break;
            case "1_damage_all_enemy_minion":
                damageAllEnemyMinion(opponent);
                break;
            case "4_damage_all_enemy_minion":
                damageAllEnemyMinion(opponent);
                break;
            default:
                damage(opponent);
                break;
        }
    }

    private void damageAllOtherEndTurn(Player player, Player opponent) {
        List<Card> cardsPlayer = new CopyOnWriteArrayList<>(player.getCardsOnField().getCards());
        List<Card> CardsOpponent = new CopyOnWriteArrayList<>(opponent.getCardsOnField().getCards());
        if (player.getCardsOnField().checkListSize() > 0) {
            Card card = player.getCardsOnField().getCardById("EX1_249");
            for (Card cp : cardsPlayer) {
                if (cp != card) {
                    ((Minion) player.getCardsOnField().getCard(cp)).loseHealth(amount);
                    controlMinion(player, cp);
                }
            }
        }
        if (opponent.getCardsOnField().checkListSize() > 0) {
            for (Card co : CardsOpponent) {
                ((Minion) opponent.getCardsOnField().getCard(co)).loseHealth(amount);
                controlMinion(opponent, co);
            }
        }
    }

    private void damage(Player opponent) {
        randomEnemy(opponent, amount, null);
    }

    private void damageSplitRandom(Player player, Player opponent) {
        Card card = player.getCardsOnField().getCardById("EX1_249");
        int i = 3;
        while (i > 0) {
            if (ReusableMethods.random(50)) {
                randomEnemy(opponent, 1, null);
            } else {
                randomEnemy(player, 1, card);
            }
            i--;
        }
    }

    private void damageSplitEnemy(Player opponent) {
        int i = 3;
        while (i > 0) {
            randomEnemy(opponent, 1, null);
            i--;
        }
    }

    private void randomEnemyMinion(Player opponent) {
        Card randomCard = opponent.getCardsOnField().getRandomCard();
        ((Minion) opponent.getCardsOnField().getCard(randomCard)).loseHealth(amount);
        controlMinion(opponent, randomCard);
    }

    private void randomEnemy(Player opponent, int damage, Card card) {
        Card randomCard = opponent.getCardsOnField().getRandomCard();
        if (ReusableMethods.random(50) && opponent.getCardsOnField().checkListSize() > 0 && card != null) {
            while (!randomCard.getId().equals(card.getId())) {
                randomCard = opponent.getCardsOnField().getRandomCard();
            }
            ((Minion) opponent.getCardsOnField().getCard(randomCard)).loseHealth(damage);
            controlMinion(opponent, randomCard);
        } else {
            opponent.getHero().loseHealth(damage);
        }

    }

    private void damageWithAdjacent(Player opponent) {
        int listSize = opponent.getCardsOnField().checkListSize();
        Card randomCard = opponent.getCardsOnField().getRandomCard();
        if (listSize >= 3) {
            List<Card> copy = new CopyOnWriteArrayList<>(opponent.getCardsOnField().getCards());
            copy.remove(randomCard);
            copy.subList(0, 2);
            for (Card c : copy) {
                ((Minion) opponent.getCardsOnField().getCard(c)).loseHealth(2);
                controlMinion(opponent, c);
            }
            ((Minion) opponent.getCardsOnField().getCard(randomCard)).loseHealth(amount);
            controlMinion(opponent, randomCard);
        } else if (listSize >= 2) {
            List<Card> copy = new CopyOnWriteArrayList<>(opponent.getCardsOnField().getCards());
            copy.remove(randomCard);
            copy.subList(0, 1);
            for (Card c : copy) {
                ((Minion) opponent.getCardsOnField().getCard(c)).loseHealth(2);
                controlMinion(opponent, c);
            }
            ((Minion) opponent.getCardsOnField().getCard(randomCard)).loseHealth(amount);
            controlMinion(opponent, randomCard);
        } else if (listSize == 1) {
            ((Minion) opponent.getCardsOnField().getCard(randomCard)).loseHealth(amount);
            controlMinion(opponent, randomCard);
        }
    }

    private void damageAllEnemyMinion(Player opponent) {
        List<Card> cardsOpponent = new CopyOnWriteArrayList<>(opponent.getCardsOnField().getCards());
        if (opponent.getCardsOnField().checkListSize() > 0) {
            for (Card co : cardsOpponent) {
                ((Minion) opponent.getCardsOnField().getCard(co)).loseHealth(amount);
                controlMinion(opponent, co);
            }
        }
    }

    private void damageEnemyHero(Player opponent) {
        opponent.getHero().loseHealth(amount);
    }

    private void controlMinion(Player player, Card card) {
        if (((Minion) card).getHealth() > 0) {
            player.replaceCardOnField(card, card);
        } else {
            player.removeCardOnField(card);
        }

    }

}
