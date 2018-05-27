package abilities;

import cardLogic.card.Ability;

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
