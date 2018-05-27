package cardLogic.card;

import abilities.*;
import heroLogic.Hero;
import org.jetbrains.annotations.NotNull;

public class Minion extends Card {
    private int health;
    private int attValue;
    private int fatigue;
    private Ability ability;
    private int priority;

    public Minion(String id, int manaCost, String name, String img, String playerClass, int health, int attValue, DivineShield divineShield) {
        super(id, manaCost, name, img, playerClass, null);
        this.health = health;
        this.attValue = attValue;
        this.fatigue = 1;
        this.ability = null;
        this.priority = 1;
    }

    public Minion(String id, int manaCost, String name, String img, String playerClass, Battlecry battlecry, int health, int attValue, Ability ability) {
        super(id, manaCost, name, img, playerClass, battlecry);
        this.health = health;
        this.attValue = attValue;
        this.fatigue = 1;
        this.ability = ability;
        this.priority = 1;
    }

    public int getHealth() {
        return health;
    }

    public int getAttValue() {
        return attValue;
    }

    public int getFatigue() {
        return fatigue;
    }

    public Ability getAbility() {
        return ability;
    }

    public int getPriority() {
        return priority;
    }

    public int loseFatigue() {
        return fatigue = 0;
    }

    public int gainFatigue() {
        return fatigue = 1;
    }

    private void setPriority(int priority) {
        this.priority = priority;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int loseHealth(int targetAttValue) {
        return this.health = this.health - targetAttValue;
    }

    public int gainHealth(int healValue) {
        return this.health = this.health + healValue;
    }

    public int gainAttValue(int attValue) {
        return this.attValue = this.attValue + attValue;
    }


    public void attack(Minion target) {
        //TODO: If minion has 2 abilities make a check for that
        Ability defender = target.getAbility();
        Ability attacker = this.getAbility();

        if (defender instanceof DivineShield || attacker instanceof DivineShield) {
            if (defender instanceof DivineShield) {
                target.loseHealth(((DivineShield) defender).useShield(this.getAttValue()));
                this.loseHealth(target.getAttValue());
            }
            if (attacker instanceof DivineShield) {
                this.loseHealth(((DivineShield) attacker).useShield(target.getAttValue()));
                target.loseHealth(this.getAttValue());
            }
        } else if (attacker instanceof Windfury) {
            if (((Windfury) attacker).windfuryUsed()) {
                ((Windfury) attacker).useWindfury();
                this.loseFatigue();
            }
            target.loseHealth(this.getAttValue());
            this.loseHealth(target.getAttValue());
        } else if (attacker instanceof Stealth) {
            if (((Stealth) attacker).isStealth()) {
                this.setPriority(((Stealth) attacker).useStealth());
            }
            target.loseHealth(target.getHealth());
            this.loseHealth(target.getAttValue());
        } else if (attacker instanceof Poisonous || defender instanceof Poisonous) {
            if (attacker instanceof Poisonous) {
                if (target.getHealth() - this.getAttValue() != target.getHealth()) {
                    target.loseHealth(target.getHealth());
                    this.loseHealth(target.getAttValue());
                }
                if (defender instanceof Poisonous) {
                    if (this.getHealth() - target.getAttValue() != this.getHealth()) {
                        this.loseHealth(this.getHealth());
                        target.loseHealth(this.getAttValue());
                    }
                }
            }
            if (defender instanceof Poisonous) {
                if (!((Poisonous) defender).isUsed()) {
                    this.loseHealth(this.getHealth());
                    target.loseHealth(this.getAttValue());
                }
            }
        } else {
            target.loseHealth(this.getAttValue());
            this.loseHealth(target.getAttValue());
        }
    }

    public void attackHero(Hero opponent) {
        Ability attacker = this.getAbility();

        if (attacker instanceof Windfury) {
            if (((Windfury) attacker).windfuryUsed()) {
                ((Windfury) attacker).useWindfury();
                this.loseFatigue();
            }
            opponent.loseHealth(this.getAttValue());
        } else if (attacker instanceof Stealth) {
            if (((Stealth) attacker).isStealth()) {
                this.setPriority(((Stealth) attacker).useStealth());
            }
            opponent.loseHealth(this.getAttValue());
        } else {
            opponent.loseHealth(this.getAttValue());
        }
    }

    public void controlForCharge() {
        Ability card = this.getAbility();

        if (card instanceof Charge) {
            if (((Charge) card).isCharge()) {
                ((Charge) card).useCharge();
                loseFatigue();
            }
        }
    }

    public void controlForTaunt() {
        Ability card = this.getAbility();

        if (card instanceof Taunt) {
            this.setPriority(((Taunt) card).setTaunt());
        }
    }

    public void controlForStealth() {
        Ability card = this.getAbility();

        if (card instanceof Stealth) {
            this.setPriority(((Stealth) card).setStealth());
        }
    }

    @Override
    public String toString() {
        return "Minion{" +
                "health=" + health +
                ", attValue=" + attValue +
                ", fatigue=" + fatigue +
                ", ability=" + ability +
                ", priority=" + priority +
                ", " + super.toString() +
                '}';
    }
}
