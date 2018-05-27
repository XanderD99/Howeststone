package databaseConnection;

import cardLogic.Cards;
import cardLogic.card.Card;
import cardLogic.card.Minion;
import cardLogic.card.Spell;
import cardLogic.card.Weapon;
import reusables.ReusableMethods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class SqlResponses {
    Cards deck = new Cards();

    public Cards getDeck() {
        return deck;
    }

    private ReusableMethods instance = new ReusableMethods();

    static SqlDatabase db = new SqlDatabase(
            "jdbc:mysql://localhost:3306/howeststone?verifyServerCertificate=false&useSSL=true&serverTimezone=UTC",
            "root",
            ""
    );

    public Cards getDeck(String playerClass, String deckId) {
        deck = new Cards();
        try (
                Connection connection = db.getConnection();
                PreparedStatement stmt = connection.prepareStatement(SqlStatements.GET_DECK)
        ) {
            stmt.setString(1, playerClass);
            stmt.setString(2, deckId);

            filterCard(stmt, deck);

        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return deck;
    }

    Cards filterCard(PreparedStatement stmt, Cards cards) throws SQLException {
        try (ResultSet rs = stmt.executeQuery()) {
            cards.clear();
            while (rs.next()) {
                String cardId = rs.getString("cardId");
                Card c = null;
                switch (rs.getString("type")) {
                    case "Minion":
                        if (cards.getCardById(cardId) == null) {
                            c = createMinion(cardId, rs);
                        } else {
                            c = createMinion(cardId + "_01", rs);
                        }
                        break;
                    case "Weapon":
                        if (cards.getCardById(cardId) == null) {
                            c = createWeapon(cardId, rs);
                        } else {
                            c = createWeapon(cardId + "_01", rs);
                        }
                        break;
                    case "Spell":
                        if (cards.getCardById(cardId) == null) {
                            c = createSpell(cardId, rs);
                        } else {
                            c = createSpell(cardId + "_01", rs);
                        }
                        break;
                }

                cards.add(c);
            }
        }
        return cards;
    }

    Card createMinion(String id, ResultSet rs) throws SQLException {
        return new Minion(id,
                rs.getInt("cost"), rs.getString("cards.name"),
                rs.getString("img"), rs.getString("playerClass"),
                instance.switchBattlecries(rs.getString("battlecry")),
                rs.getInt("health"), rs.getInt("attack"),
                instance.switchAbilities(rs.getString("ability")));
    }

    private Card createWeapon(String id, ResultSet rs) throws SQLException {
        return new Weapon(id,
                rs.getInt("cost"), rs.getString("cards.name"),
                rs.getString("img"), rs.getString("playerClass"),
                rs.getString("ability"), rs.getInt("attack"),
                rs.getInt("durability"));
    }

    private Card createSpell(String id, ResultSet rs) throws SQLException {
        return new Spell(id, rs.getInt("cost"),
                rs.getString("cards.name"), rs.getString("img"),
                rs.getString("playerClass"), instance.switchBattlecries(rs.getString("battlecry")));
    }

}
