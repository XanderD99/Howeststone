package abilities;

import cardLogic.card.Ability;
import cardLogic.card.Card;
import cardLogic.card.Minion;
import cardLogic.card.Weapon;
import heroLogic.Hero;
import reusables.ReusableMethods;

public class Deathrattle extends Ability {
    private Hero hero;
    private ReusableMethods strategy;

    public Deathrattle(String name){
        super(name);
    }

    public void dealDmg(int dmg, Card[] targets) {
        strategy.dealDmg(dmg, targets);
    }

    //@Override
    public void drawCard() {
        strategy.drawCard();
    }

    //@Override
    public void forceAbility(Ability ability, Minion target) {
        strategy.forceAbility(ability, target);
    }

    public void setStrategy(ReusableMethods strategy) {
        this.strategy = strategy;
    }
}
