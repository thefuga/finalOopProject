/**
 * Items.
 * This is the base class of all items in the game. It holds the basic 
 * attributes for every item in the game. Every kind of item should extend this.
 * @author Erick Costa Fuga.
 * @author Arthur Cardozo Godinho.
 */
package trabalhoPoo.model.items;


public abstract class Item {

    private final Integer price;
    private final Integer minimumLevel;
   // private final String quality; Not implemented for now
    private final String name;
    
    
    /**
     * Constructor of Item class.
     * This is the constructor of Item class. It sets item's price and name.
     * @param price Price of the item.
     * @param minimumLevel Minimum level required to use the item.
     * //@param quality Quality of the item.
     * @param name Name of the item.
     */
    protected Item(int price, int minimumLevel, /*String quality,*/ String name){
        this.price = price;
        this.minimumLevel = minimumLevel;
        //this.quality = quality;
        this.name = name;
    }
    
    /**
     * Get price.
     * @return Price of the item.
     */
    public Integer getPrice(){
        return price;
    }

    /**
     * Get Minimum Level.
     * @return Minimum level to use the item.
     */
    public Integer getMinimumLevel() {
        return minimumLevel;
    }
    
    /**
     * Get name.
     * @return Name of the item.
     */
    public String getName(){
        return name;
    }
}
