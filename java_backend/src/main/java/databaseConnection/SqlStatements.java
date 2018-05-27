package databaseConnection;

public class SqlStatements {
    public static final String GET_CARD_BY_ID = "SELECT * FROM cards WHERE cardId = ?";

    public static final String GET_DECK = "SELECT * FROM decks = d\n" +
            "JOIN cardsindeck c ON d.deckId = c.deckId\n" +
            "JOIN cards ON c.cardId = cards.cardId\n" +
            "WHERE class = ? AND d.deckId LIKE ?";

    public static final String DELETE_DECK = "DELETE FROM cardsindeck WHERE deckId = ?";

    public static final String DELETE_CARD_IN_FIELD = "DELETE FROM playercardsonfield WHERE cardId = ? AND playerName = ?";

    public static final String INSERT_CARD_IN_DECK = "INSERT INTO cardsindeck VALUES (?, ?)";

    public static final String INSERT_CARD_IN_FIELD = "INSERT INTO playercardsonfield VALUES (?, ?)";

    public static final String GET_ALL_CARDS_FOR_DECK_BUILDER = "SELECT * FROM cards WHERE name NOT LIKE 'The Coin' and name NOT LIKE 'Avatar of the Coin'";

    public static final String GET_SHEEP = "SELECT * FROM cards WHERE cardId = 'CS2_tk1'";
}
