/**
 * Enemy.
 * This is the class of every "enemy" in the game. It has a basic attack method
 * and a loot table.
 * TODO: must implement attribute and methods to yield experience to player's
 * who "kill" the enemy.
 * @author Erick Costa Fuga
 * @author Arthur Cardozo Godinho.
 */
package trabalhoPoo.model.characters;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import trabalhoPoo.model.items.Item;

public class Enemy extends Fightable{
    //Experience multiplier
    private static final int ENEMY_EXPERIENCE_MULTIPLIER = 10;
    
    //Attributes
    private final ObservableList<Item> lootTable;
    private final Integer experienceYield;
    
    /**
     * Constructor of Enemy class.
     * This is the constructor of the Enemy class. It set's the loot table of 
     * the enemy and calls Fightable's constructor (it's super class).
     * @param name Name of the enemy being created.
     * @param level Level of the enemy being created.
     * @param lootTable Loot table of the enemy being created.
     */
    public Enemy(String name, int level, List<Item> lootTable){
        super(name, level);
        this.lootTable = FXCollections.observableArrayList();
        this.lootTable.addAll(lootTable); 
        experienceYield = level * ENEMY_EXPERIENCE_MULTIPLIER;
    }
    
    public Integer getExperienceYield(){
        return experienceYield;
    }
    /**
     * Get loot table.
     * This method returns the loot table from an enemy.
     * @return Returns a read-only list containing the enemy's loot table. It
     * should only be used to check items dropped from the enemy.
     */
    public List<Item> getLootTable() {
        return FXCollections.unmodifiableObservableList(lootTable);
    }
    
    /**
     * Loot item.
     * This method should be used to loot an item from a dead enemy. It checks
     * if the enemy is alive, if not, checks if the enemy actually have the item
     * and if so, returns it. Returns null if the enemy is alive or doesn't have
     * the item.
     * @param item
     * @return 
     */
    public Item lootItem(Item item){
        if(!getIsAlive()){
            if(lootTable.remove(item))
                return item;
        }
        return null;
    }
    
     /**
     * Attack.
     * Returns an int corresponding to the damage from a basic attack of an 
     * Enemy.
     * @return 
     */
    @Override
    public int attack(){
        if(getSpecialAttackCooldown() > 0)
            setSpecialAttackCooldown(getSpecialAttackCooldown() - 1);
        return Math.round(getAttackPower() * BASIC_ATTACK_MULTIPLIER);
    }
}
