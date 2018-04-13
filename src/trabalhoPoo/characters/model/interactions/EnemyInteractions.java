/**
 * This class controls interactions between players and Enemys.
 * It should be used whenever a player must interact with an enemy of any kind.
 * Enemys won't have control over players and vice-versa. This class will 
 * control all combat mechanics.
 * @author Erick Costa Fuga.
 * @author Arthur Cardozo Godinho.
 */
package trabalhoPoo.characters.model.interactions;

import trabalhoPoo.model.characters.Boss;
import trabalhoPoo.model.characters.Enemy;
import trabalhoPoo.model.characters.Player;

public abstract class EnemyInteractions {
    
    
    /**
     * Attack Enemy.
     * This method should be called when a player must attack an enemy. It 
     * controls all actions necessary to perform the task.
     * @param player Player attacking an enemy.
     * @param enemy Enemy to be attacked.
     */
    public static void attackEnemy(Player player, Enemy enemy){
        enemy.setCurrentHp(enemy.getCurrentHp() - Math.round((float)player.attack() / (float)enemy.getDeffensePower()));
        if(enemy.getIsAlive()){
            attackPlayer(player, enemy);
            return;
        }
        giveExperience(player, enemy);
    }
    
    /**
     * Special Attack Enemy.
     * This method should be called when a player must use an special attack on 
     * an enemy. It controls all actions necessary to perform the task.
     * @param player Player attacking an enemy.
     * @param enemy Enemy to be attacked.
     */
    public static void specialAttackEnemy(Player player, Enemy enemy){
        enemy.setCurrentHp(enemy.getCurrentHp() - Math.round(((float)player.specialAttack() / (float)enemy.getDeffensePower())));
        if(enemy.getIsAlive()){
            attackPlayer(player, enemy);
            return;
        }
        giveExperience(player, enemy);
    }
    
    /**
     * Attack player.
     * This method is called when an enemy is attacking a player. It is called
     * by the player's attack method.
     * @param player Player to be attacked.
     * @param enemy Enemy to attack the player.
     */
    private static void attackPlayer(Player player, Enemy enemy){
        if(enemy instanceof Boss){
            if(specialAttackPlayer(player, (Boss) enemy))
                return;
        }
        player.setCurrentHp(player.getCurrentHp() - Math.round((float)player.getDeffensePower() / (float)enemy.attack()));
    }
    
    /**
     * Attack player.
     * This method is called when an enemy (i.e. boss) must use an special 
     * attack on a player. It is called by the player's attack method.
     * @param player Player to be attacked.
     * @param enemy Enemy to attack the player.
     */
    private static boolean specialAttackPlayer(Player player, Boss boss){
        if(boss.getSpecialAttackCooldown() == 0){
            player.setCurrentHp(player.getCurrentHp() - Math.round((float)(boss.specialAttack() / (float)player.getDeffensePower())));
            return true;
        }
        return false;
    }
    
    /**
     * Give experience.
     * This method is called whenever a player kills an enemy. It increases the
     * experience on the player who killed the enemy.
     * @param player Player to give experience.
     * @param enemy Enemy who yield experience.
     */
    private static void giveExperience(Player player, Enemy enemy){
        if(player.getIsAlive())
           player.gainExperience(enemy.getExperienceYield());
    }
}
