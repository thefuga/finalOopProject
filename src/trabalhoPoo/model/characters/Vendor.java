/**
 * Vendor.
 * This is the class of every vendor in tha game. It has all attributes and 
 * methods required to buy and sell items. Note that a vendor never interacts
 * directly with a player. The NpcInteractions class should be used for this.
 * Some of the methods in this class are not final and may still have more 
 * functionality.
 * @author Erick Costa Fuga.
 * @author Arthur Cardozo Godinho.
 */
package trabalhoPoo.model.characters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import trabalhoPoo.model.items.Item;

public class Vendor extends NPC{
    
    private final List<Item> goods;
    
    /**
     * Constructor of Vendor class.
     * This is the constructor of the Vendor class. It sets the goods this 
     * vendor has and calls NPC's constructor (it's super class).
     * @param name
     * @param level
     * @param goods
     */
    public Vendor(String name, int level, List<Item> goods){
        super(name, level);
        this.goods = new ArrayList<>();
        this.goods.addAll(goods);
    }

    
    /**
     * Get goods.
     * This method return's the goods this vendor has.
     * @return read-only list containing this vendor's goods. It should only be
     * used to check the goods this vendor has.
     */
    public List<Item> getGoods() {
        return Collections.unmodifiableList(goods); //Returns read-only list
    }
    
    
    /**
     * Sell item.
     * This method should be used when a vendor is selling an item.
     * @param item Item being sold.
     * @return the item in case of success, null otherwise.
     */
    public Item sell(Item item){
        for(Item itemIterator: goods){
            if(itemIterator.equals(item))
                return item;
        }
        return null;
    }
    
    
    /**
     * Purchase item.
     * This method should be used when a vendor is buying an item.
     * @param item Item being purchased.
     * @return item's price.
     */
    public int purchase(Item item){
        goods.add(item);
       return item.getPrice();
    }
    
    /**
     * Level Increased.
     * As this NPC does not have other atributes that should be changed when
     * level changes, it won't have implementation of this method.
     */
    @Override
    protected void levelIncreasedInherited(){}
    
    /**
     * HP Listener.
     * As this NPC does not have other atributes that should be changed when
     * HP changes, it won't have implementation of this method for now.
     * @param hp
     */
    @Override
    protected void hpListener(Number hp){}
}
