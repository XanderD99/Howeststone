package reusables;


import abilities.*;


import abilities.battlecries.*;
import cardLogic.card.*;
import game.Player;
import heroLogic.Hero;

import java.util.Random;
import java.util.concurrent.TimeUnit;

//Strategy Pattern
public class ReusableMethods {
    private Hero hero;
    private Player player;

    public void dealDmg(int dmg, Card[] targets) {
        int newDmg = dmg / targets.length;
        for (Card target : targets) {
            if (target instanceof Minion) {
                ((Minion) target).loseHealth(newDmg);
            } else if (target instanceof Weapon) {
                ((Weapon) target).loseDurability(((Weapon) target).getDurability(), newDmg);
            } else {

                hero.loseHealth(newDmg);
            }
        }
    }

    public void drawCard() {
        player.drawCard();
    }

    public static boolean random(int chance) {
        Random rand = new Random();

        return rand.nextInt(100) < chance;
    }

    public static void pause(int timeInMilliSeconds){
        try {
            TimeUnit.MILLISECONDS.sleep(timeInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void console(String who, String text){
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_RED = "\u001B[31m";

        switch (who){
            case "bot":
                System.out.println(ANSI_CYAN + "bot says: " + ANSI_RESET + text);
                break;

            default:
                System.out.println(ANSI_RED + "console: " + ANSI_RESET + text);
                break;
        }
    }

    public static void console(String text){
        console("", text);
    }

    public void forceAbility(Ability ability, Minion target) {
        //TODO: Force ability on a minion
    }

    public void destroyMinion(Minion m) {
        m.loseHealth(m.getHealth());
    }

    public Ability switchAbilities(String ability) {
        if (ability == null) {
            return null;
        }

        switch (ability) {
            case "Stealth":
                return new Stealth(true, ability);
            case "Taunt":
                return new Taunt(ability);
            case "DivineShield":
                return new DivineShield(true, ability);
            case "Charge":
                return new Charge(true, ability);
            case "Windfury":
                return new Windfury(true, ability);
            case "Poisonous":
                return new Poisonous(false, ability);
            default:
                return null;
        }
    }

    public Battlecry switchBattlecries(String battlecry) {
        if (battlecry == null) {
            return null;
        }
        switch (battlecry) {
            case "2_damage_all_other_end_turn":
                return new DamageCry(2, battlecry);
            case "3_damage_2_random_enemy_minion":
                return new DamageCry(3, battlecry);
            case "3_damage_enemy_hero":
                return new DamageCry(3, battlecry);
            case "3_damage_split_enemy":
                return new DamageCry(3, battlecry);
            case "3_damage_split_random":
                return new DamageCry(3, battlecry);
            case "5_damage_2_damage_adjecent":
                return new DamageCry(5, battlecry);
            case "1_damage_all_enemy_minion":
                return new DamageCry(1, battlecry);
            case "4_damage_all_enemy_minion":
                return new DamageCry(4, battlecry);
            case "10_damage":
                return new DamageCry(10, battlecry);
            case "6_damage":
                return new DamageCry(6, battlecry);
            case "2_damage":
                return new DamageCry(2, battlecry);
            case "1_damage":
                return new DamageCry(1, battlecry);
            case "+3_Health":
                return new BoostCry(3, battlecry);
            case "+2_Health":
                return new BoostCry(2, battlecry);
            case "+1/+1":
                return new BoostCry(1, battlecry);
            case "kill_random_enemy_minion":
                return new KillCry(battlecry);
            case "Health_1_enemy_minion":
                return new ForceHealthCry(1, battlecry);
            case "Draw_2_card":
                return new DrawCardCry(2, battlecry);
            case "Draw_card":
                return new DrawCardCry(1, battlecry);
            case "sheep":
                return new SheepCry(battlecry);
            default:
                return null;
        }
    }
}
