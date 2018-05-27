package abilities;

import cardLogic.card.Ability;

public class Windfury extends Ability {
    private boolean used;

    public Windfury(boolean used, String name) {
        super(name);
        this.used = used;
    }

    public void useWindfury() {
        this.used = false;
    }


    public boolean windfuryUsed() {
        return used;
    }
}
