package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import databaseConnection.SqlResponsesGame;
import databaseConnection.SqlResponsesDeckbuilder;
import game.Game;
import game.Player;
import io.javalin.Context;
import io.javalin.Javalin;
import org.json.simple.JSONArray;

import java.io.IOException;
import java.util.HashMap;


class Routes {
    private SqlResponsesDeckbuilder sqlResponsesDeckbuilder = new SqlResponsesDeckbuilder();
    private SqlResponsesGame gameSql = new SqlResponsesGame();
    private SqlResponsesGame gameSql2 = new SqlResponsesGame();
    private Game g;

    Routes(final Javalin server) {
        server.get("/", this::login);

        server.get("/API/deckbuilder/getAllCards", this::cards);
        server.post("/API/deckbuilder/chooseDeck", this::selectDeck);
        server.get("/API/deckbuilder/getDeck", this::getDeck);
        server.post("/API/deckbuilder/saveDeck", this::saveDeck);

        server.get("/API/gameSql/gameInfo", this::getGame);
        server.post("/API/gameSql/createNewGame", this::createNewGame);
        server.post("/API/gameSql/startGame", this::startGame);
        server.post("/API/gameSql/cardField", this::cardField);
        server.post("/API/gameSql/attack", this::attack);
        server.post("/API/gameSql/endTurn", this::endTurn);
    }

    private void login(final Context context) {
        context.redirect("/index.html");
    }

    private void cards(Context context) {
        context.json(sqlResponsesDeckbuilder.getAllCards());
    }

    private void selectDeck(Context context) throws IOException {
        final String s = context.body();

        final HashMap result = new ObjectMapper().readValue(s, HashMap.class);

        sqlResponsesDeckbuilder.setDeckId(result.get("class").toString(), result.get("deck").toString());
    }

    private void getDeck(Context context) {
        context.json(sqlResponsesDeckbuilder.getDeck());
    }

    private void saveDeck(Context context) {
        try {
            final String s = context.body();
            final HashMap result = new ObjectMapper().readValue(s, HashMap.class);
            sqlResponsesDeckbuilder.saveDeck(result);
        } catch (IOException ex) {
            ex.fillInStackTrace();
        } catch (Exception ex){
            context.status(400);
        }
    }


    private void getGame(Context context) {
        final JSONArray array = new JSONArray();
        array.add(g.getPlayerOne());
        array.add(g.getPlayerTwo());
        context.json(array);
    }

    private void createNewGame(Context context) throws IOException, InterruptedException {
        final String s = context.body();
        final HashMap result = new ObjectMapper().readValue(s, HashMap.class);
        gameSql.getSheep();

        //gameSql.getDeck(result.get("class").toString(), result.get("deck").toString());

        g = new Game("player", gameSql.getDeck(result.get("class").toString(), result.get("deck").toString()), gameSql.getDeck("Mage", "MD_01"), gameSql.getSpecialCards(), result.get("class").toString());

    }

    private void startGame(Context context) {
        g.startGame();
    }

    private void cardField(Context context) {
        String s = context.body();
        /*HashMap result = new ObjectMapper().readValue(s, HashMap.class);

        String id = result.get("id").toString();*/

        final Player currentPlayer = g.getTurn().getCurrentPlayer();

        currentPlayer.placeCard(s, g.getPlayerTwo());
    }

    private void endTurn(Context context) {
        g.endTurn("player");
    }

    private void attack(Context context) throws IOException {
        String s = context.body();
        HashMap result = new ObjectMapper().readValue(s, HashMap.class);

        String yourCardId = result.get("attacker").toString();
        String opponentCardId = result.get("attacked").toString();

        if (yourCardId.equals("heroPower")){
            g.getPlayerOne().heroPower(g.getPlayerTwo(),opponentCardId);
        }else if (opponentCardId.equals("hero")) {
            g.getPlayerOne().attack(g.getPlayerTwo(), yourCardId);
        } else {
            g.getPlayerOne().attack(g.getPlayerTwo(), opponentCardId, yourCardId);
        }
    }
}

