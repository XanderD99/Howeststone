package cardLogic.card;

import abilities.Battlecry;
import abilities.battlecries.*;
import game.Player;
import heroLogic.Hero;
import reusables.ReusableMethods;

import java.util.Objects;

public abstract class Card {
    private String id;
    private int manaCost;
    private String name;
    private String img;
    private String playerClass;
    private Battlecry battlecry;

    public Card(String id, int manaCost, String name, String img, String playerClass, Battlecry battlecry) {
        this.id = id;
        this.manaCost = manaCost;
        this.name = name;
        this.img = img;
        this.playerClass = playerClass;
        this.battlecry = battlecry;
    }

    public String getId() {
        return id;
    }

    public int getManaCost() {
        return manaCost;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public Battlecry getBattlecry() {
        return battlecry;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void attack(Minion minion, Hero target) {
        target.loseHealth(minion.getAttValue());
    }

    public void heal(int healValue, Minion minion) {
        minion.gainHealth(healValue);
    }

    public void attackBoost(int attValue, Minion minion) {
        minion.gainAttValue(attValue);
    }

    public void doBattlecry(Player player, Player opponent) {
        Battlecry battlecry = this.getBattlecry();

        if (battlecry instanceof DamageCry) {
            ReusableMethods.console("Damage card(s) casted.");

            ((DamageCry) battlecry).doDamageCry(player, opponent);
        } else if (battlecry instanceof BoostCry) {
            ReusableMethods.console("Boost card(s) casted.");
            ((BoostCry) battlecry).doBoostCry(player);
        } else if (battlecry instanceof DrawCardCry) {
            ReusableMethods.console("Draw card(s) casted.");
            ((DrawCardCry) battlecry).doDrawCardCry(player);
        } else if (battlecry instanceof ForceHealthCry) {
            ReusableMethods.console("Force Health card(s) casted.");
            ((ForceHealthCry) battlecry).doForceHealthCry(opponent);
        } else if (battlecry instanceof KillCry) {
            ReusableMethods.console("Kill card(s) casted.");
            ((KillCry) battlecry).doKillCry(opponent);
        } else if (battlecry instanceof SheepCry) {
            ReusableMethods.console("Polymorph card casted.");
            ((SheepCry) battlecry).doSheepCry(opponent);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return manaCost == card.manaCost &&
                Objects.equals(id, card.id) &&
                Objects.equals(name, card.name) &&
                Objects.equals(img, card.img) &&
                Objects.equals(playerClass, card.playerClass) &&
                Objects.equals(battlecry, card.battlecry);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, manaCost, name, img, playerClass, battlecry);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", manaCost=" + manaCost +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", playerClass='" + playerClass + '\'' +
                ", battlecry=" + battlecry +
                '}';
    }
}
