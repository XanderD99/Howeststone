package heroLogic;

import cardLogic.card.Minion;
import cardLogic.card.Weapon;

public class Hero {
    private int health;
    private String heroClass;
    private Weapon weapon;
    private int fatigue;


    public Hero(String heroClass) {
        this.health = 30;
        this.heroClass = heroClass;
        this.fatigue = 0;
    }

    public int getHealth() {
        return health;
    }

    public String getHeroClass() {
        return heroClass;
    }

    public int getFatigue() {
        return fatigue;
    }

    private void gainFatigue() {
        this.fatigue = 1;
    }

    public void loseFatigue() {
        this.fatigue = 0;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void loseHealth(int targetAttValue) {
        this.health = this.health - targetAttValue;
    }

    public void gainHealth(int healValue) {
        if (this.health + healValue <= 30) {
            this.health = this.health + healValue;
        } else {
            this.health = 30;
        }
    }

    public void useHeropower(Object target) {
        if (getHeroClass().equals("Mage")) {
            if (target instanceof Minion) {
                ((Minion) target).loseHealth(HeroPower.useFireblast());
            } else {
                ((Hero) target).loseHealth(HeroPower.useFireblast());
            }
        } else if (getHeroClass().equals("Hunter")) {
            if (target instanceof Hero) {
                ((Hero) target).loseHealth(HeroPower.useSteadyshot());
            }
        }
        gainFatigue();
    }

    @Override
    public String toString() {
        return "Hero{" +
                "health=" + health +
                ", heroClass='" + heroClass + '\'' +
                ", weapon=" + weapon +
                '}';
    }
}