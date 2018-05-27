package abilities;

import cardLogic.card.Ability;

public class Charge extends Ability {
    private boolean charge;

    public Charge(boolean charge, String name) {
        super(name);
        this.charge = charge;
    }

    public boolean isCharge() {
        return charge;
    }


    public void useCharge() {
        this.charge = false;
    }
}
