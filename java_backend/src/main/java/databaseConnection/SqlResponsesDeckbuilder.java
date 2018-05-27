package databaseConnection;

import cardLogic.Cards;
import cardLogic.card.Card;
import cardLogic.card.Minion;
import cardLogic.card.Spell;
import cardLogic.card.Weapon;
import databaseConnection.SqlDatabase;
import databaseConnection.SqlStatements;

import javax.print.DocFlavor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class SqlResponsesDeckbuilder extends SqlResponses {
    private Cards cards = new Cards();

    private String deckId;
    private String deckClass;

    public String getDeckId() {
        return deckId;
    }

    public Cards getCards() {
        return cards;
    }

    public Cards getAllCards() {
        try (
                Connection connection = db.getConnection();
                PreparedStatement stmt = connection.prepareStatement(SqlStatements.GET_ALL_CARDS_FOR_DECK_BUILDER)
        ) {

            filterCard(stmt, cards);

        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return cards;
    }

    public Cards getDeck() {
        getDeck(deckClass, deckId);
        return deck;
    }

    public void setDeckId(String selectedClass, String selectedDeck) {

        deckId = "";
        deckClass = selectedClass;

        if (selectedClass.equals("Mage")) {
            deckId += "MD_";
        } else {
            deckId += "HD_";
        }

        if (selectedDeck.equals("Deck A")) {
            deckId += "01";
        } else if (selectedDeck.equals("Deck B")) {
            deckId += "02";
        } else {
            deckId += "03";
        }
    }

    public void saveDeck(HashMap map) {
        String selectedClass = map.get("class").toString();
        String selectedDeck = map.get("deck").toString();
        setDeckId(selectedClass, selectedDeck);
        String string = map.get("ids").toString().replace("[", "").replace("]", "").replace(" ", "");
        String[] values = string.split(",");

        if (!isDeckValid(values)) {
            throw new IllegalArgumentException("not a legal deck");
        }

        deleteDeck();

        try (
                Connection connection = db.getConnection();
                PreparedStatement stmt = connection.prepareStatement(SqlStatements.INSERT_CARD_IN_DECK)
        ) {
            stmt.setString(1, deckId);
            for (String value : values) {
                System.out.println(value);
                if(value.substring(value.length()-3, value.length()).equals("_01")){
                    System.out.println("removing _01");
                    value = value.replace("_01","");
                }
                stmt.setString(2, value);
                stmt.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("saved");
    }

    private boolean isDeckValid(String[] values) {
        for (String cardId : values) {
            int appearences = 0;

            for (String i : values) {
                if (i.equals(cardId)) {
                    appearences++;
                }
            }

            if (appearences > 2) {
                return false;
            }
        }
        return true;
    }

    public void deleteDeck() {
        try (
                Connection connection = db.getConnection();
                PreparedStatement stmt = connection.prepareStatement(SqlStatements.DELETE_DECK)
        ) {

            System.out.println(deckId);
            stmt.setString(1, deckId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("deleted");
    }
}
