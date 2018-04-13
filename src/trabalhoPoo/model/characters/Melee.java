/**
 * Melee.
 * This is class of melee players. It may have different attacks from other 
 * classes.
 * @author Erick Costa Fuga.
 * @author Arthur Cardozo Godinho.
 */
package trabalhoPoo.model.characters;

/**
 *
 * @author Erick
 */
public class Melee extends Player{
    
    private static final int MELEE_SPECIAL_ATTACK_COOLDOWN = 4;
    
    public Melee(String name){
        super(name);
    }
    
    /**
     * Attack.
     * Returns an int corresponding to the damage from a basic attack of a
     * Melee player.
     * @return 
     */
    @Override
    public int attack(){
        if(getSpecialAttackCooldown() > 0)
            setSpecialAttackCooldown(getSpecialAttackCooldown() - 1);
        return Math.round(getAttackPower() * BASIC_ATTACK_MULTIPLIER * getEquippedItems().getEquippedWeapon().getBaseDamage());
    }
    
    /**
     * Special attack.
     * This method returns an int corresponding to the damage from an special
     * attack of a Melee player.
     * @return Total damagem from an special attack if the ability is ready.
     * Returns -1 otherwise.
     */
    @Override
    public int specialAttack(){
        if(getSpecialAttackCooldown() == 0){
            setSpecialAttackCooldown(MELEE_SPECIAL_ATTACK_COOLDOWN);
            return attack() * SPECIAL_ATTACK_MULTIPLIER;
        }   
        return -1;
    }
}
