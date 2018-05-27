package abilities.battlecries;

import abilities.Battlecry;
import game.Player;

public class DrawCardCry extends Battlecry {
    private int amount;

    public DrawCardCry(int amount ,String name) {
        super(name);
        this.amount = amount;
    }

    public void doDrawCardCry(Player player) {
        if (amount == 1) {
            player.drawCard();
        }
        if (amount == 2) {
            player.drawCard();
            player.drawCard();
        }
    }
}
