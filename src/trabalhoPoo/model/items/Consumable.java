/**
 * Consumable.
 * This is the consumable class. It is used to create objects that will restore
 * a player HP and/or energy.
 * @author Erick Costa Fuga.
 * @author Arthur Cardozo Godinho.
 */
package trabalhoPoo.model.items;


public class Consumable extends Item{
    
    private final Integer energyRestored;
    private final Integer hpRestored;
    
    /**
     * Constructor of consumable class.
     * @param price Price of the item.
     * @param minimumLevel Minimum level required to use the item.
     * @param name Name of the item.
     * @param energyRestored Energy restored by the consumable.
     * @param hpRestored Hp restored by the consumable.
     */
    public Consumable(int price, int minimumLevel, int energyRestored, int hpRestored, String name){
        super(price, minimumLevel, name);
        this.energyRestored = energyRestored;
        this.hpRestored = hpRestored;
    }
    
    /**
     * Get Energy Restored.
     * @return  Energy restored by the consumable.
     */
    public Integer getEnergyRestored(){
        return energyRestored;
    }
    
    /**
     * Get Hp Restored.
     * @return Hp restored by the consumable.
     */
    public Integer getHpRestored(){
        return hpRestored;
    }
}
