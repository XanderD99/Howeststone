package game;

import abilities.Taunt;
import cardLogic.Cards;
import cardLogic.card.Card;
import cardLogic.card.Minion;
import cardLogic.card.Spell;
import heroLogic.Hero;
import abilities.Battlecry;
import cardLogic.card.Ability;
import reusables.ReusableMethods;

import java.util.List;


public abstract class Player {
    private String name;
    private Cards cards;
    private Cards cardsInHand;
    private Cards cardsOnField;
    private Cards graveyard;
    private Cards specialCards;
    private Hero hero;
    private int manaLimit;
    private int availableMana;

    public Player(String name, Cards cards, Cards specialCards, String hero) {
        this.name = name;
        this.cards = cards;
        this.cardsInHand = new Cards();
        this.cardsOnField = new Cards();
        this.graveyard = new Cards();
        this.specialCards = specialCards;
        this.hero = new Hero(hero);
        this.manaLimit = 0;
        this.availableMana = 0;
    }

    public Player() {

    }

    public String getName() {
        return name;
    }

    public Cards getCards() {
        return cards;
    }

    public Hero getHero() {
        return hero;
    }

    public int getManaLimit() {
        return manaLimit;
    }

    public int getAvailableMana() {
        return availableMana;
    }

    public Cards getCardsInHand() {
        return cardsInHand;
    }

    public Cards getCardsOnField() {
        return cardsOnField;
    }

    public Cards getGraveyard() {
        return graveyard;
    }

    public Cards getSpecialCards() {
        return specialCards;
    }

    private void placeCardInHand(Card card) {
        if (cardsInHand.checkListSize() < 10) {
            cardsInHand.add(card);
            cards.remove(card);
        }
    }

    private void placeCardOnField(Card card, Player opponent) {

        if (enoughMana(card) && yourTurn() && card instanceof Minion && cardsOnField.checkListSize() < 7) {

            decreaseMana(card.getManaCost());
            ((Minion) card).controlForCharge();
            ((Minion) card).controlForTaunt();
            ((Minion) card).controlForStealth();
            cardsInHand.remove(card);

            cardsOnField.add(card);
            card.doBattlecry(this, opponent);
        }

        if (enoughMana(card) && card instanceof Spell) {
            decreaseMana(card.getManaCost());
            cardsInHand.remove(card);
            card.doBattlecry(this, opponent);

            cardsOnField.add(card);
            ReusableMethods.pause(500);
            cardsOnField.remove(card);
            graveyard.add(card);

        }
    }

    public void replaceCardOnField(Card originalCard, Card card) {
        cardsOnField.remove(originalCard);
        cardsOnField.add(card);
    }

    public void removeCardOnField(Card card) {
        cardsOnField.remove(card);
        graveyard.add(card);
    }

    private boolean yourTurn() {
        return this.equals(new Turn().getCurrentPlayer());
    }

    private boolean enoughMana(Card card) {
        return card.getManaCost() <= this.getAvailableMana();
    }

    private boolean enoughMana() {
        return 2 <= this.getAvailableMana();
    }

    private void decreaseMana(int usedMana) {
        this.availableMana -= usedMana;
    }

    public void attack(Player opponent, String opponentCardId, String yourCardId) {
        Minion playerCardOrg = this.getCardFromField(yourCardId);
        Minion opponentCardOrg = opponent.getCardFromField(opponentCardId);

        if (playerCardOrg != null && playerCardOrg.getFatigue() == 0 && !lookForTaunt(opponent) && opponentCardOrg != null && opponentCardOrg.getPriority() == 1) {
            attackMinion(opponent, playerCardOrg, opponentCardOrg);
        } else if (opponentCardOrg != null && playerCardOrg != null && playerCardOrg.getFatigue() == 0 && opponentCardOrg.getAbility() instanceof Taunt) {
            attackMinion(opponent, playerCardOrg, opponentCardOrg);
        }
    }

    public void attack(Player opponent, String yourCardId) {
        Minion playerCard = this.getCardFromField(yourCardId);
        if (playerCard != null && playerCard.getFatigue() == 0 && !lookForTaunt(opponent)) {
            playerCard.gainFatigue();

            playerCard.attackHero(opponent.getHero());
        }
    }

    private void attackMinion(Player opponent, Minion playerCardOrg, Minion opponentCardOrg) {
        playerCardOrg.gainFatigue();
        playerCardOrg.attack(opponentCardOrg);

        if (opponentCardOrg != null) {
            if (opponentCardOrg.getHealth() > 0) {
                opponent.replaceCardOnField(opponentCardOrg, opponentCardOrg);
            } else {
                opponent.removeCardOnField(opponentCardOrg);
            }
        }

        if (playerCardOrg.getHealth() > 0) {
            replaceCardOnField(playerCardOrg, playerCardOrg);
        } else {
            removeCardOnField(playerCardOrg);
        }
    }

    private Minion getCardFromField(String cardId) {

        Card card = cardsOnField.getCardById(cardId);

        if (card instanceof Minion) {
            return ((Minion) card);
        } else {
            return null;
        }
    }

    public void heroPower(Player opponent, String target) {
        if (opponent.getHero().getFatigue() == 0) {
            if (enoughMana() && yourTurn()) {
                Minion opponentCard = opponent.getCardFromField(target);
                if (lookForTaunt(opponent)) {
                    if (opponentCard != null && opponentCard.getAbility() instanceof Taunt) {
                        getHero().useHeropower(opponentCard);
                    }

                    decreaseMana(2);
                } else {
                    if ((target.equals("hero") || getHero().getHeroClass().equals("Hunter")) && !lookForTaunt(opponent)) {
                        getHero().useHeropower(opponent.getHero());
                    } else {
                        getHero().useHeropower(opponentCard);
                        if (opponentCard != null && opponentCard.getHealth() < 1) {
                            opponent.removeCardOnField(opponentCard);
                        }
                    }

                    decreaseMana(2);
                }
            }
        }
    }

    public void clearCards() {
        cards.clearTable();
    }

    public void increaseManaLimit() {
        if (manaLimit < 10) {
            this.manaLimit++;
        }
        gainMana();
    }

    private void gainMana() {
        this.availableMana = manaLimit;
    }

    public void loseMana(int manaCost) {
        if (availableMana > 0 && availableMana - manaCost >= 0) {
            this.availableMana -= manaCost;
        } else {
            availableMana = 0;
        }
    }

    public void drawCard() {
        Card drawnCard = cards.getRandomCard();
        placeCardInHand(drawnCard);
    }

    public void placeCard(String id, Player opponent) {
        Card card = cardsInHand.getCardById(id);
        placeCardOnField(card, opponent);
    }

    private boolean lookForTaunt(Player opponent) {
        List<Card> cards = opponent.getCardsOnField().getCards();

        for (Card c : cards) {
            if (c instanceof Minion) {
                Ability defender = ((Minion) c).getAbility();
                if (defender instanceof Taunt) {
                    return true;
                }
            }
        }

        return false;
    }

    public void placeCard(Card card, Player opponent) {
        placeCardOnField(card, opponent);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", cards=" + cards +
                ", cardsInHand=" + cardsInHand +
                ", cardsOnField=" + cardsOnField +
                ", graveyard=" + graveyard +
                ", specialCards=" + specialCards +
                ", hero=" + hero +
                ", manaLimit=" + manaLimit +
                ", availableMana=" + availableMana +
                '}';
    }

    public void play(Player playerOne) {
        //only used in aiPlayer
    }
}
