package databaseConnection;

import cardLogic.Cards;
import cardLogic.card.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SqlResponsesGame extends SqlResponses {
    private Cards specialCards = new Cards();

    public Cards getSpecialCards() {
        return specialCards;
    }

    public List getCards() {
        return deck.getCards();
    }

    public void getSheep() {
        try (
                Connection connection = db.getConnection();
                PreparedStatement stmt = connection.prepareStatement(SqlStatements.GET_SHEEP)
        ) {

            try (ResultSet rs = stmt.executeQuery()) {
                specialCards.clear();
                while (rs.next()) {
                    String cardId = rs.getString("cardId");
                    Card c;
                    if (specialCards.getCardById(cardId) == null) {
                        c = createMinion(cardId, rs);
                    } else {
                        c = createMinion(cardId + "_01", rs);
                    }
                    specialCards.add(c);
                }
            }
            System.out.println(specialCards);

        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }
}
