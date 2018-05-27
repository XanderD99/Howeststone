package abilities;

import cardLogic.card.Ability;
import game.Player;
import cardLogic.card.Card;
import cardLogic.card.Minion;
import cardLogic.card.Weapon;
import reusables.ReusableMethods;

import java.util.Random;

public class Battlecry {
    private String name;

    public Battlecry(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /*public int gainAttack(int dmgToGain, int turns) {
        //for always
        return attVal += dmgToGain;
        //still need to put in a way to do it for one turn
    }*/

    //still need to check if minion heals by checking cards in hand
    /*public void gainHealth(int healVal, Card[] targets boolean cardHealer) {
//        int amountOfCards = 0;
//        //boolean cardHeal = cardHealer;
//        int valToAdd = 0;
//        if(cardHealer){
//            valToAdd = amountOfCards;
//        } else {
//            valToAdd = healVal;
//        }
        for (Card target : targets) {
            //amountOfCards++;
            if (target instanceof Minion) {
                ((Minion) target).gainHealth(healVal);
            } else {
                hero.gainHealth(healVal);
            }
        }
    }*/

    /*public void gainWeaponStats(int durToGain, int dmgToGain) {
        Weapon w = hero.getWeapon();
        //durToGain = -durToGain;
        w.gainDurability(durToGain);
        w.gainAttVal(dmgToGain);
    }*/

    /*public void dealDmg(int dmg, Card[] targets) {
        strategy.dealDmg(dmg, targets);
    }

    public void destroyMinion(Minion m) {
        strategy.destroyMinion(m);
    }

    public void forceAbility(Ability ability, Minion target) {
        strategy.forceAbility(ability, target);
    }

    public void setStrategy(ReusableMethods strategy) {
        this.strategy = strategy;
    }*/
}
