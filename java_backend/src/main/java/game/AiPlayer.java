package game;

import abilities.Taunt;
import cardLogic.Cards;
import cardLogic.card.Ability;
import cardLogic.card.Card;
import cardLogic.card.Minion;
import cardLogic.card.Spell;
import reusables.ReusableMethods;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AiPlayer extends Player {

    public AiPlayer(String opponent, Cards cards2, Cards specialCards, String heroClass) {
        super(opponent, cards2, specialCards, heroClass);
    }

    public void play(Player playerOne) {
        talk("New round, let's go!");
        if (ReusableMethods.random(30)) {
            useHeroPower(playerOne);
        }

        playCards(playerOne);

        if (getAvailableMana() >= 2) {
            useHeroPower(playerOne);
        }

        attackOpponent(playerOne);

        talk("No more plays left, ending my turn.\n");
    }

    private void playCards(Player opponent) {
        try {
            List<Card> tauntsInHand = lookForTaunt(getCardsInHand().getCards());
            ReusableMethods.pause(500);
            if (tauntsInHand.size() != 0) {
                talk("I have a taunt in my hand.");
                talk("Let's try to play the taunt card(s) first!");
                placeCards(tauntsInHand, opponent);
            }

            List<Card> cardsInHand = new CopyOnWriteArrayList<>(getCardsInHand().getCards());
            List<Card> cardsOnField = new CopyOnWriteArrayList<>(getCardsOnField().getCards());

            ReusableMethods.pause(500);
            if (getAvailableMana() != 0) {
                if (lookForTaunt(getCardsOnField().getCards()).size() != 0) {
                    talk("I have a taunt card on my field.");
                    talk("Let's see if I have a Poisonous, Windfury or Charge card.");
                    List<Card> cardsWithPWC = lookForAttackAbilities(cardsOnField);
                    if (cardsWithPWC.size() != 0) {
                        talk("Found " + cardsWithPWC.size() + " card(s) with Poisonous, Windfury or Charge.");
                        placeCards(lookForAttackAbilities(cardsOnField), opponent);
                    }
                    talk("To bad I don't seem to have a card with Poisonous, Windfury or Charge. Lucky you!");
                    talk("Let's try to place my strongest cards first then.");
                    placeCards(cardsSortedOnAttack(cardsInHand), opponent);
                } else {
                    talk("Playing random cards.");
                    placeCards(cardsInHand, opponent);
                }
            }
            talk("No cards left that I can place.");
        } catch (ConcurrentModificationException ex) {
            ex.printStackTrace();
        }
    }

    private List<Card> lookForAttackAbilities(List<Card> cardsOnField) {
        List<Card> cards = new ArrayList<>();
        for (Card c : cardsOnField) {
            if (((Minion) c).getAbility() != null) {
                switch (((Minion) c).getAbility().getName()) {
                    case "Poisonous":
                        cards.add(c);
                        break;
                    case "Windfury":
                        cards.add(c);
                        break;
                    case "Charge":
                        cards.add(c);
                        break;
                }
            }
        }

        return cards;
    }

    private void placeCards(List<Card> cards, Player opponent) {
        for (Card c : cards) {
            ReusableMethods.pause(500);

            if (c.getManaCost() <= getAvailableMana()) {
                tellWhatCardToPlay(c);

                if (c instanceof Spell && opponent.getCardsOnField().getCards().size() != 0) {
                    placeCard(c, opponent);
                } else if (c instanceof Minion) {
                    placeCard(c, opponent);
                }
            }
        }
    }

    private void attackOpponent(Player opponent) {
        List<Card> yourCards = new CopyOnWriteArrayList<>(getCardsOnField().getCards());

        for (Card yc : yourCards) {
            ReusableMethods.pause(500);
            if (((Minion) yc).getAttValue() != 0 && ((Minion) yc).getFatigue() != 1) {
                ReusableMethods.pause(500);
                List<Card> taunts = lookForTaunt(opponent.getCardsOnField().getCards());
                if (taunts.size() != 0) {
                    talk("I must get rid the taunt card(s)!");
                    talk("Attacking opponent's taunt card!");
                    attack(opponent, getOpponentTauntId(opponent), yc.getId());
                } else if (ReusableMethods.random(55) && opponent.getCardsOnField().getCards().size() != 0) {
                    if (opponent.getCardsOnField().getRandomCard() != null) {
                        Card random = findCardToAttack(opponent.getCardsOnField(), yc);

                        String randomOpponentCard = random.getId();

                        talk("I will use " + yc.getName() + " to attack " + random.getName());

                        assert randomOpponentCard != null;
                        attack(opponent, randomOpponentCard, yc.getId());
                    }
                } else {
                    talk("Attacking the hero!");
                    attack(opponent, yc.getId());
                }
            }
        }
    }

    private Card findCardToAttack(Cards opponentCardsOnField, Card yc) {
        Card card = opponentCardsOnField.getRandomCard();
        int tries = 0;

        while (willIDie(yc, card) && tries != opponentCardsOnField.checkListSize()) {
            card = opponentCardsOnField.getRandomCard();

            tries++;
        }

        return card;
    }

    private boolean willIDie(Card myCard, Card opponentCard) {
        return ((Minion) myCard).getHealth() - ((Minion) opponentCard).getAttValue() <= 0;
    }

    private void useHeroPower(Player opponent) {
        if (this.getAvailableMana() >= 2) {
            ReusableMethods.pause(500);
            if (this.getHero().getHeroClass().equals("Mage")) {
                List<Card> taunts = lookForTaunt(opponent.getCardsOnField().getCards());
                if (taunts.size() != 0) {
                    talk("I must get rid the taunt card(s)!");
                    talk("Using hero power to attack opponent's taunt card!");
                    heroPower(opponent, getOpponentTauntId(opponent));
                } else if (ReusableMethods.random(30) && opponent.getCardsOnField().getCards().size() != 0) {
                    Card randomOpponentCard = opponent.getCardsOnField().getRandomCard();

                    talk("Using hero power to attack " + randomOpponentCard.getName());

                    heroPower(opponent, randomOpponentCard.getId());
                } else {
                    talk("Using hero power to attack my opponent's hero");

                    heroPower(opponent, "hero");
                }
            } else {
                talk("Using hero power to attack my opponent's hero");

                heroPower(opponent, "hero");
            }
        } else {
            talk("lucky him, I don't have enough mana left to use my hero power");
        }
    }

    private List<Card> lookForTaunt(List<Card> cards) {
        List<Card> taunts = new ArrayList<>();

        for (Card c : cards) {
            if (c instanceof Minion) {
                Ability defender = ((Minion) c).getAbility();
                if (defender instanceof Taunt) {
                    taunts.add(c);
                }
            }
        }

        return taunts;
    }

    private String getOpponentTauntId(Player opponent) {
        for (Card c : opponent.getCardsOnField().getCards()) {
            Ability defender = ((Minion) c).getAbility();
            if (defender instanceof Taunt) {
                return c.getId();
            }
        }

        return null;
    }

    private List<Card> cardsSortedOnAttack(List<Card> cards) {
        List<Card> sortedCards = new ArrayList<>(fillWithMinions(cards));

        sortedCards.sort((c1, c2) -> ((Minion) c2).getAttValue() - ((Minion) c1).getAttValue());

        return sortedCards;
    }

    private List<Minion> fillWithMinions(List<Card> cards) {
        List<Minion> minions = new ArrayList<>();
        for (Card c : cards) {
            if (c instanceof Minion) {
                minions.add((Minion) c);
            }
        }

        return minions;
    }

    private void tellWhatCardToPlay(Card c) {
        if (c instanceof Minion) {
            if (((Minion) c).getAbility() != null) {
                talk("Placing " + c.getName() + " ( " + ((Minion) c).getAbility().getName() + " ) on field.");
            } else {
                talk("Placing " + c.getName() + " on field.");
            }
        }

        if (c instanceof Spell) {
            talk("Casting " + c.getName());
        }
    }

    private void talk(String text) {
        ReusableMethods.pause(350);
        ReusableMethods.console("bot", text);
    }
}