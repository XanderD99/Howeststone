package abilities;

import cardLogic.card.Ability;

public class DivineShield extends Ability {
    private boolean shield;

    public DivineShield(boolean shield, String name) {
        super(name);
        this.shield = shield;
    }

    public boolean isShield() {
        return shield;
    }

    //divine shield is continuous use while running turns
    public int useShield(int toAbsorbDamage) {
        if (shield) {
            this.shield = false;
            return 0;
        }
        return toAbsorbDamage;
    }
}
