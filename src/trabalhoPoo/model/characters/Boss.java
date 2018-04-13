/**
 * Boss.
 * This is the class of every boss in the game. It extends Enemy class. The only
 * difference between this class and it's parent is the specialAttack method, 
 * which is a stronger attack only present in bosses.
 * @author Erick Costa Fuga.
 * @author Arthur Cardozo Godinho.
 */
package trabalhoPoo.model.characters;

import java.util.List;
import trabalhoPoo.model.items.Item;

public class Boss extends Enemy{
    
    private static final int BOSS_SPECIAL_ATTACK_COOLDOWN = 3;
    
    /**
     * Constructor of Boss class.
     * This is the constructor of the Boss class. It only calls Enemy's 
     * constructor because it has no attributes.
     * @param name Name of the Boss being created.
     * @param level Level of the Boss being created.
     * @param lootTable Loot table of the Boss being created.
     */
    public Boss(String name, int level, List<Item> lootTable){
        super(name, level, lootTable);
    }
    
    /**
     * Special attack.
     * This method returns an int corresponding to the damage from an special
     * attack. It is based on attack power and a constant multiplier. 
     * @return Total damagem from an special attack.
     */
    public int specialAttack(){
        if(getSpecialAttackCooldown() == 0){
            setSpecialAttackCooldown(BOSS_SPECIAL_ATTACK_COOLDOWN);
            return attack() * SPECIAL_ATTACK_MULTIPLIER;
        }   
        return -1;
    }
}
