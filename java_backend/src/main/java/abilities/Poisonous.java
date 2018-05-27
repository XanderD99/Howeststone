package abilities;

import cardLogic.card.Ability;
import cardLogic.card.Minion;

public class Poisonous extends Ability {
    private boolean used;

    public Poisonous(boolean used, String name) {
        super(name);
        this.used = used;
    }

    public boolean isUsed() {
        return used;
    }

}
