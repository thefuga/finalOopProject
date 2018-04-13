/**
 * Weapon.
 * This is the base class of every weapon in the game. Every kind of weapon 
 * should extend this.
 * @author Erick Costa Fuga.
 * @author Arthur Cardozo Godinho.
 */
package trabalhoPoo.model.items;

public abstract class Weapon extends Item{
    
    private final Integer baseDamage;
    
    /**
     * Constructor of Weapon calss.
     * This is the constructor of MeleeWeapon class. It sets the weapon's base damage 
     * and calls Weapon constructor (it's super class).
     * @param price Price of the item.
     * @param minimumLevel Minimum level required to use the item.
     * //@param quality Quality of the item.
     * @param name Name of the item.
     * @param baseDamage Base damage of the Weapon.
     */
    protected Weapon(int price, int minimumLevel, /*String quality,*/int baseDamage, String name){
        super(price, minimumLevel, /*quality,*/ name);
        this.baseDamage = baseDamage;
    }

    /**
     * Get base damage.
     * @return Item's base damage.
     */
    public int getBaseDamage() {
        return baseDamage;
    }
}
