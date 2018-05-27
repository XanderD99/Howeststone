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

    @Override
    public String toString() {
        return ", AttValue: " + getAttValue() + ", Durability: " + getDurability();
    }
}
