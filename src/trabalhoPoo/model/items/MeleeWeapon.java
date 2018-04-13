/**
 * This is the class of Melee Weapons of the game.
 * @author Erick Costa Fuga.
 * @author Arthur Cardozo Godinho.
 */
package trabalhoPoo.model.items;


public class MeleeWeapon extends Weapon{
    
    /**
     * Constructor of Melee Weapon class.
     * This is the constructor of MeleeWeapon class. It calls Weapon constructor 
     * (it's super class). In future it should have specific methods and 
     * atributes.
     * @param price Price of the item.
     * @param minimumLevel Minimum level required to use the item.
     * //@param quality Quality of the item.
     * @param name Name of the item.
     * @param baseDamage Base damage of the Weapon.
     */
    public MeleeWeapon(int price, int minimumLevel, /*String quality,*/ int baseDamage, String name){
        super(price, minimumLevel, /*quality,*/baseDamage, name);
    }
    
    //TODO specific methods here.
}
