/**
 * Fightable.
 * This is the class of all characters in the game that are able to fight. Every
 * character that may engage in combat must extend this.
 * @author Erick Costa Fuga.
 * @author Arthur Cardozo Godinho.
 */
package trabalhoPoo.model.characters;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Fightable extends Character{
    //Base value for Fightable
    protected static final int BASE_ATTACK_POWER = 10;
    protected static final int BASE_DEFFENSE_POWER = 10;
    protected static final float BASIC_ATTACK_MULTIPLIER = 0.5f;
    protected static final int SPECIAL_ATTACK_MULTIPLIER = 3;
    
    //Attributes
    private final IntegerProperty attackPower;
    private final IntegerProperty deffensePower;
    private final IntegerProperty specialAttackCooldown;
    private final BooleanProperty isAlive;
    
    /**
     * Constructor of Fightable class.
     * This is the constructor of the Fightable class. It sets some of the 
     * attributes based on characters level, and calls Character's 
     * constructor (it's super class).
     * @param name Name of the character being created.
     * @param level Level of the character being created.
     */
    public Fightable(String name, int level){
        super(name, level);
        attackPower = new SimpleIntegerProperty(BASE_ATTACK_POWER);
        deffensePower = new SimpleIntegerProperty(BASE_DEFFENSE_POWER);
        if(level > 1){
            attackPower.set((attackPower.get() * level) / attackPower.get());
            deffensePower.set((deffensePower.get() * level) / deffensePower.get());
        }
        this.isAlive = new SimpleBooleanProperty(true);
        specialAttackCooldown = new SimpleIntegerProperty(0);
        
    }

    /**
     * Get attack power.
     * This method returns the attack power on a fightable character.
     * @return Attack power.
     */
    public Integer getAttackPower() {
        return attackPower.getValue();
    }

    /**
     * Get deffense power.
     * This method returns the deffense power on a fightable character.
     * @return Deffense power.
     */
    public Integer getDeffensePower() {
        return deffensePower.getValue();
    }

    /**
     * Get is alive.
     * This method is used to check if an fightable character is alive.
     * @return Boolean indicating if character is alive.
     */
    public Boolean getIsAlive() {
        return isAlive.get();
    }
    
    /**
     * Get is alive property.
     * This method returns isAlive property.
     * @return BooleanProperty isAlive.
     */
    public BooleanProperty getIsAliveProperty() {
        return isAlive;
    }
    
    /**
     * Get Special Attack Cooldown.
     * @return Current cooldown on the special attack.
     */
    public Integer getSpecialAttackCooldown(){
        return specialAttackCooldown.getValue();
    }
    
    /**
     * Set Special Attack Cooldown.
     * @param cooldown
     */
    public void setSpecialAttackCooldown(int cooldown){
        specialAttackCooldown.set(cooldown);
    }
    
    /**
     * Level Increased Inherited.
     * Implementation of the Level Increased method for Fightable characters.
     */
    @Override
    protected void levelIncreasedInherited(){
        attackPower.set((attackPower.get() * getLevel()) / attackPower.get());
        deffensePower.set((deffensePower.get() * getLevel()) / deffensePower.get());
    }
    
    /**
     * HP Listener.
     * Implementation of the HP Listener for Fightable characters.
     * @param hp 
     */
    @Override
    protected void hpListener(Number hp){
        if(hp.intValue() <= 0)
            isAlive.set(false);
    }
    /**
     * Basic Attack.
     * Must be implemented.
     * @return 
     */
    public abstract int attack();
}
