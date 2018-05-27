package abilities;

import cardLogic.card.Ability;

public class DivineShield extends Ability {
    private boolean shield;

    public DivineShield(boolean shield, String name) {
        super(name);
        this.shield = shield;
    }

    public int useShield(int toAbsorbDamage) {
        if (shield) {
            this.shield = false;
            return 0;
        }
        return toAbsorbDamage;
    }
}
