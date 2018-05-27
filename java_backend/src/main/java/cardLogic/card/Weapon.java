package cardLogic.card;

public class Weapon extends Card {
    private int attValue;
    private int durability;


    public Weapon(String id, int manaCost, String name, String img, String playerClass, String ability, int attValue, int durability) {
        super(id, manaCost, name, img, playerClass, null);
        this.attValue = attValue;
        this.durability = durability;
    }

    public int getAttValue() {
        return attValue;
    }

    public int getDurability() {
        return durability;
    }

    public int attack(int attValue, int targetHealth) {
        return targetHealth - attValue;
    }

    public int gainDurability(int durToGain) {
        return durability += durToGain;
    }

    public int gainAttVal(int attToGain) {
        return attValue += attToGain;
    }

    public int loseDurability(int durability, int targetAttValue) {
        int newDurability = durability - targetAttValue;
        return newDurability;
    }

    @Override
    public String toString() {
        return ", AttValue: " + getAttValue() + ", Durability: " + getDurability();
    }
}
