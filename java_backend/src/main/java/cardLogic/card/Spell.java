package cardLogic.card;

import abilities.Battlecry;

public class Spell extends Card {
    public Spell(String id, int manaCost, String name, String img, String playerClass, Battlecry battlecry) {
        super(id, manaCost, name, img, playerClass, battlecry);
    }

    @Override
    public String toString() {
        return "Spell{" +
                ", " + super.toString() +
                '}';
    }
}
