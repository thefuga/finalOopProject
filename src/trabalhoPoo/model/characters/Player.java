/**
 * Player.
 * This is the class of players of the game. Every player "combat class" must 
 * extend this. This class is abstract because every player should have a combat 
 * class (ie. mage, warrior, etc..), but it contains every basic methods and 
 * attributes a player needs - child classes will only have methods for specific
 * abilities.
 * TODO: Implement methods to level up manually or (better option) add listeners
 * to the character's level to so. Player's Experience must also be added.
 * @author Erick Costa Fuga.
 * @author Arthur Cardozo Godinho.
 */
package trabalhoPoo.model.characters;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import trabalhoPoo.model.items.EquippedItems;
import trabalhoPoo.model.quests.Quest;
import trabalhoPoo.model.items.Item;
import trabalhoPoo.model.items.Consumable;


public abstract class Player extends Fightable{
    
    //Constant to calculate next level;
    private static final int NEXT_LEVEL_MULTIPLIER = 10;
    
    //Player's initial values
    private static final int INITIAL_LEVEL = 1;
    private static final int INITIAL_GOLD = 100;
    
    //Attributes
    private final IntegerProperty gold;
    private final IntegerProperty experience;
    private final ObservableList<Quest> activeQuests;
    private final ObservableList<Quest> completedQuests;
    private final ObservableList<Item> inventory;
    private final EquippedItems equippedItems;
    
    
    /**
     * Constructor of Player classe.
     * This is the constructor of the Player class. It set's player's attributes
     * based on the constants above and calls Fightable's constructor 
     * (it's super class).
     * @param name Name of the character being created.
     */
    protected Player(String name){
        super(name, INITIAL_LEVEL);
        gold = new SimpleIntegerProperty(INITIAL_GOLD);
        activeQuests = FXCollections.observableArrayList();
        completedQuests = FXCollections.observableArrayList();
        inventory = FXCollections.observableArrayList();
        equippedItems = new EquippedItems(this);
        experience = new SimpleIntegerProperty(0);
        experience.addListener(
                (observable, oldValue, newValue) -> {
                    if(experience.intValue() >= (Math.pow(NEXT_LEVEL_MULTIPLIER, getLevel()) / Math.pow(getLevel(), 2)))
                        getLevelProperty().set(getLevel() + 1);
                });
        
    }
    
    /**
     * Must be implemented.
     * @return 
     */
    public abstract int specialAttack();
    
//    /**
//     * DEPRECATED.
//     * @param direction 
//     */
//    public void walk(String direction){
//        switch(direction){
//            case "N":
//                //TODO
//            case "NE":
//                //TODO
//            case "E":
//                //TODO
//            case "SE":
//                //TODO
//            case "S":
//                //TODO
//            case "SW":
//                //TODO
//            case "W":
//                //TODO
//            case "NW":
//                //TODO
//            default:
//                //TODO
//        }         
//    }
    
    /**
     * Pick quest.
     * Method used to pick a quest.
     * @param quest Quest to be picked.
     */
    public void pickQuest(Quest quest){
        if (quest.getMinimumLevel().equals(getLevel()))
            activeQuests.add(quest);  
    }
    
    /**
     * Complet quest.
     * Method used to complet a quest.
     * @param quest Quest to be completed.
     */
    public void completeQuest(Quest quest){
        if(activeQuests.contains(quest)){
            completedQuests.add(quest);
            activeQuests.remove(quest);
        }
    }

    /**
     * Get gold.
     * @return Gold on this player.
     */
    public int getGold() {
        return gold.get();
    }
    
    /**
     * Get gold property.
     * @return Gold property on this player.
     */
    public IntegerProperty getGoldProperty() {
        return gold;
    }

    /**
     * Get inventory.
     * Returns read-only observableList.
     * @return 
     */
    public ObservableList<Item> getInventory() {
        return FXCollections.unmodifiableObservableList(inventory);
    }

    /**
     * Get active quests.
     * @return Active quests on this player.
     */
    public ObservableList<Quest> getActiveQuests() {
        return activeQuests;
    }

    /**
     * Get completed quests.
     * @return Completed quests on this player.
     */
    public ObservableList<Quest> getCompletedQuests() {
        return completedQuests;
    }
    
    /**
     * Get deffense power.
     * This method returns the deffense power on players. It overrides the 
     * original method to return the deffense power with equipped armor.
     * @return Deffense power.
     */
    @Override
    public Integer getDeffensePower(){
        return super.getDeffensePower() + equippedItems.getEquippedArmor().getBaseDeffense();
    }

    /**
     * Drop item.
     * Method to drop items from this player's inventory.
     * @param item 
     */
    public void dropItem(Item item){
        if(inventory.contains(item))
            inventory.remove(item);
    }
    
    /**
     * Get Experience.
     * @return Player's experience.
     */
    public Integer getExperience(){
        return experience.getValue();
    }
    
    /**
     * Get Experience Property.
     * @return Property of Player's experience.
     */
    public IntegerProperty getExperienceProperty(){
        return experience;
    }
    
    /**
     * 
     * @return 
     */
    public Integer getNextLevelExperience(){
        return Math.round((float)(Math.pow(NEXT_LEVEL_MULTIPLIER, getLevel()) / Math.pow(getLevel(), 2)));
    }
    
    /**
     * 
     * @param experience 
     */
    public void gainExperience(int experience){
        if(experience >= 0)
            this.experience.set(this.experience.get() + experience);
    }
    
    /**
     * Pick item.
     * Method to add items on this player's inventory.
     * @param item Item to be added.
     */
    public void pickItem(Item item){
        inventory.add(item);
    }
    
    /**
     * Set gold.
     * Sets the gold on this player.
     * @param gold
     */
    public void setGold(int gold){
        this.gold.set(gold);
    }
    
    
    
    /**
     * Get equipped items.
     * Return the equipped items on this player.
     * @return equippedItems.
     */
    public EquippedItems getEquippedItems(){
        return equippedItems;
    }
    
    /**
     * Use comsumable.
     * Method to use a consumable item and restore energy or HP.
     * @param consumable to be used.
     * @return True if successfull, false otherwise.
     */
    public boolean useComsumable(Consumable consumable){
        if(getInventory().contains(consumable)){
            if(getCurrentEnergy() < getMaximumEnergy() || getCurrentHp() < getMaximumHp()){
                setCurrentEnergy(getCurrentEnergy() + consumable.getEnergyRestored());
                setCurrentHp(getCurrentHp() + consumable.getHpRestored());
                if(getCurrentEnergy() > getMaximumEnergy())
                    setCurrentEnergy(getMaximumEnergy());
                if(getCurrentHp() > getMaximumHp())
                    setCurrentHp(getMaximumHp());
                dropItem(consumable);
                return true;
            }
        }
        return false;
    }
    
    /**
     * 
     * @param experience 
     */
    public void levelUp(Number experience){
        if(experience.intValue() >= (Math.pow(NEXT_LEVEL_MULTIPLIER, getLevel()) / Math.pow(getLevel(), 2)))
            getLevelProperty().set(getLevel() + 1);
    }
}
