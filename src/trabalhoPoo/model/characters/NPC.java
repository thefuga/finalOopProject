/**
 * NPC.
 * This is the class of all non-fightable NPC's in the game. Every non-fightable
 * NPC should extend this.
 * @author Erick Costa Fuga.
 * @author Arthur Cardozo Godinho.
 */

package trabalhoPoo.model.characters;

public abstract class NPC extends Character {
    
    
    /**
     * Constructor of NPC class.
     * This is the constructor of the NPC class. It only calls Character's 
     * constructor (it's super class).
     * @param name Name of the character being created.
     * @param level Level of the character being created.
     */
    public NPC(String name, int level){
        super(name, level);  
    }
    
    /**
     * 
     * @return 
     */
    public String interact(){
        return "Hello there, hero!\nWhat can i do for you?";
    }
}
