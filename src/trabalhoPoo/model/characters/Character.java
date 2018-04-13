/**
 * Character.
 * This is the base class of all characters in the game. Every kind of character
 * to be present in the game should extend this.
 * @author Erick Costa Fuga.
 * @author Arthur Cardozo Godinho.
 */
package trabalhoPoo.model.characters;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Character {
    //Base values for characters
    private static final int BASE_ENERGY = 10;
    private static final int BASE_HP = 10;
    
    //Attributes
    //private Location location; //This must be implemented somehow!
    private final IntegerProperty level;
    private Integer maximumEnergy;
    private Integer maximumHp;
    private final IntegerProperty currentEnergy;
    private final IntegerProperty currentHp;
    private final String name;
    
     
    /**
     * Constructor of Character class.
     * This is the constructor of the Character class. It sets some of the 
     * attributes based on the level of the character created.
     * @param name Name of the character being created.
     * @param level Level of the character being created.
     */
    protected Character(String name, int level){
        this.name = name;
        this.level = new SimpleIntegerProperty(level);
        this.maximumEnergy = BASE_ENERGY + (BASE_ENERGY * level) / BASE_ENERGY;
        this.maximumHp = BASE_HP + (BASE_HP * level) / BASE_HP;
        currentEnergy = new SimpleIntegerProperty(maximumEnergy);
        currentHp = new SimpleIntegerProperty(maximumHp);  
        this.level.addListener(
                (observable, oldValue, newValue) -> levelIncreased());  
        
        currentHp.addListener((observable, oldValue, newValue) -> hpListener(newValue));
    }

    /**
     * Get level.
     * @return Character's level.
     */
    public int getLevel() {
        return level.get();
    }
    
    public IntegerProperty getLevelProperty(){
        return level;
    }

    /**
     * Get Maxymum Energy.
     * @return Character's maximum Energy.
     */
    public int getMaximumEnergy() {
        return maximumEnergy;
    }

    /**
     * Get Maximum HP.
     * @return Character's maximum HP.
     */
    public int getMaximumHp() {
        return maximumHp;
    }

    /**
     * Get Current Energy.
     * @return Character's current Energy.
     */
    public Integer getCurrentEnergy() {
        return currentEnergy.getValue();
    }

    /**
     * Get Current Energy Property.
     * @return Property of character's current energy.
     */
    public IntegerProperty getCurrentEnergyProperty() {
        return currentEnergy;
    }
    
    /**
     * Get Current HP.
     * @return Character's current HP.
     */
    public Integer getCurrentHp() {
        return currentHp.getValue();
    }
    
    /**
     * Get Current HP Property.
     * @return Property of character's current HP.
     */
    public IntegerProperty getCurrentHpProperty() {
        return currentHp;
    }
    
    /**
     * Get name.
     * @return Character's name.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Set Current energy.
     * @param energy
     */
    public void setCurrentEnergy(int energy) {
        currentHp.set(energy);
    }
    
    /**
     * Set Current HP.
     * @param hp
     */
    public void setCurrentHp(int hp) {
        currentHp.set(hp);
    }
    
    /**
     * Level incresed.
     * Default action performed when a character's level increases.
     */
    private void levelIncreased(){
        maximumEnergy = BASE_ENERGY + (BASE_ENERGY * level.get()) / BASE_ENERGY;
        maximumHp = BASE_HP + (BASE_HP * level.get()) / BASE_HP;
        currentEnergy.set(maximumEnergy);
        currentHp.set(maximumHp);
        levelIncreasedInherited();
    }
    
    /**
     * Level Increased.
     * Action performed by classes that inherit this and may include other 
     * actions. Must be implemented.
     */
    protected abstract void levelIncreasedInherited();
    
    /**
     * 
     * @param hp
     */
    protected abstract void hpListener(Number hp);
    
}
