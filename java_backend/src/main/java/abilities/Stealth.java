package abilities;

import cardLogic.card.Ability;

public class Stealth extends Ability {
    private boolean stealth;

    public Stealth(boolean stealth, String name) {
        super(name);
        this.stealth = stealth;
    }

    public boolean isStealth() {
        return stealth;
    }

    public int useStealth() {
        this.stealth = false;
        return 1;
    }

    public int setStealth() {
        return 0;
    }
}
