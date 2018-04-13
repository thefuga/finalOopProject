/**
 * This is the class of Ranged Weapons of the game.
 * @author Erick Costa Fuga.
 * @author Arthur Cardozo Godinho.
 */
package trabalhoPoo.model.items;


public class RangedWeapon extends Weapon{
    
    /**
     * Constructor of Ranged Weapon class.
     * This is the constructor of RangedWeapon class. It calls Weapon constructor 
     * (it's super class). In future it should have specific methods and 
     * atributes.
     * @param price Price of the item.
     * @param minimumLevel Minimum level required to use the item.
     * //@param quality Quality of the item.
     * @param name Name of the item.
     * @param baseDamage Base damage of the Weapon.
     */
    public RangedWeapon(int price, int minimumLevel, int baseDamage, String name){
        super(price, minimumLevel, baseDamage, name);
    }
    
    //TODO specific methods here.
}
