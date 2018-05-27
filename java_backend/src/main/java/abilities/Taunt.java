package abilities;

import cardLogic.card.Ability;

public class Taunt extends Ability {

    public Taunt(String name) {
        super(name);
    }

    public int setTaunt() {
        return 2;
    }
}
