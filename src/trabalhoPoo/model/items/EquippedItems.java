/**
 * Equipped Items.
 * This is the class responsible for a player's equipped items. It has 
 * attributes of the items that are eqquiped on a player and also controls 
 * player's attributes that may be affected by an equipped item.
 * @author Erick Costa Fuga.
 * @author Arthur Cardozo Godinho.
 */
package trabalhoPoo.model.items;

import trabalhoPoo.model.characters.Melee;
import trabalhoPoo.model.characters.Player;
import trabalhoPoo.model.characters.Ranged;

public class EquippedItems {
    
    private final Player player;
    private Armor equippedArmor;
    private Weapon equippedWeapon;
    
    /**
     * Constructor of EquippedItems class.
     * This is the constructor of EquippedItems class.
     * @param player Refference of the player that is creating this.
     */
    public EquippedItems(Player player){
        this.player = player;
    }

    /**
     * Get Equipped Armor.
     * @return Equipped Armor.
     */
    public Armor getEquippedArmor() {
        return equippedArmor == null ? new Armor(0, 0, 1, "") : equippedArmor;
    }

    /**
     * Get Equipped Weapon.
     * @return Equipped Weapon.
     */
    public Weapon getEquippedWeapon() {
        return equippedWeapon == null ? 
                (equippedWeapon instanceof RangedWeapon ? 
                new RangedWeapon(0, 0, 1, "") : new MeleeWeapon(0, 0, 1, "")) : equippedWeapon;
    }
    
    /**
     * Equip armor.
     * Equips an armor item on a player.
     * @param armor Armor to be equipped.
     * @return true if successfull, false otherwise.
     */
    public boolean equipArmor(Armor armor){
        if(player.getLevel() >= armor.getMinimumLevel()){
            if(equippedArmor == null){
                equippedArmor = armor;
                player.dropItem(armor);
                return true;
            }
            player.pickItem(equippedArmor);
            equippedArmor = armor;
            player.dropItem(armor);
            return true;
        }
        return false;
    }
    
    /**
     * Unequip armor.
     * Unequips an armor from the player and stores it in the inventory.
     * @return true if successfull, false otherwise.
     */
    public boolean unequipArmor(){
        if(equippedArmor != null){
            player.pickItem(equippedArmor);
            equippedArmor = null;
            return true;
        }
        return false;    
    }
    
    /**
     * Equip weapon.
     * Equips a weapon item on a player.
     * @param weapon Armor to be equipped.
     * @return true if successfull, false otherwise.
     */
    public boolean equipWeapon(Weapon weapon){
        if(player.getLevel() >= weapon.getMinimumLevel()){
            if((weapon instanceof RangedWeapon && player instanceof Ranged) || 
                    (weapon instanceof MeleeWeapon && player instanceof Melee)){ //Checks if the weapon to be equipped is compatible with the player's class
                if(equippedArmor == null){
                    equippedWeapon = weapon;
                    player.dropItem(weapon);
                    return true;
                }
                player.pickItem(equippedArmor);
                equippedWeapon = weapon;
                player.dropItem(weapon);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Unequip weapon.
     * Unequips a weapon from the player and stores it in the inventory.
     * @return true if successfull, false otherwise.
     */
    public boolean unequipWeapon(){
        if(equippedWeapon != null){
            player.pickItem(equippedWeapon);
            equippedWeapon = null;
            return true;
        }
        return false;
    }
}
