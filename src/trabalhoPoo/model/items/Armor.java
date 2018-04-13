/**
 * Armor.
 * This is the Armor class.
 * @author Erick Costa Fuga.
 * @author Arthur Cardozo Godinho.
 */
package trabalhoPoo.model.items;


public class Armor extends Item{
    
    private final Integer baseDeffense;
    
    /**
     * Constructor of Armor calss.
     * This is the constructor of Armor class. It sets the armor's base deffense 
     * and calls Item constructor (it's super class).
     * @param price Price of the item.
     * @param minimumLevel Minimum level required to use the item.
     * //@param quality Quality of the item.
     * @param name Name of the item.
     * @param baseDeffense Base damage of the Weapon.
     */
    public Armor(int price, int minimumLevel, /*String quality,*/int baseDeffense, String name){
        super(price, minimumLevel, name);
        this.baseDeffense = baseDeffense;
    }

    /**
     * Get Base Deffense.
     * @return Base deffense of the armor.
     */
    public Integer getBaseDeffense() {
        return baseDeffense;
    }
    
}
