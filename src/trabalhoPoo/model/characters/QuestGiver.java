/**
 * Quest Giver.
 * This is the class of every Quest Giver in the game. It has attributes and 
 * methods required to handle quests to players. Note that a Quest Giver never 
 * interacts directly with a player. The NpcInteractions class should be used 
 * for this.
 * @author Erick Costa Fuga.
 * @author Arthur Cardozo Godinho.
 */
package trabalhoPoo.model.characters;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import trabalhoPoo.model.quests.Quest;


public class QuestGiver extends NPC{
    
    private final ObservableList<Quest> questsToGive;
    private final ObservableList<Quest> questsGiven;
    
    /**
     * Constructor of QuestGiver class.
     * This is the constructor of QuestGiver class. It set's the quests this
     * questgiver has and calls NPC's constructor(it's super class).
     * @param name
     * @param level
     * @param questsToGive 
     */
    public QuestGiver(String name, int level, List<Quest> questsToGive){
        super(name, level);
        this.questsToGive = FXCollections.observableArrayList(questsToGive);
        this.questsGiven = FXCollections.observableArrayList();
    }
    
    /**
     * Give quest.
     * This method if used to give a quest.
     * @param quest Quest to be given.
     * @return Given quest.
     */
    public Quest giveQuest(Quest quest){
        if(questsToGive.contains(quest)){
            questsGiven.add(quest);
            questsToGive.remove(quest); 
            return quest;
        }    
        return null;
    }
    
    /**
     * Complete quest.
     * This method is used to complete a quest. It remove's the quest from this
     * questgiver's list and returns the reward.
     * @param quest Quest to be completed.
     * @return Reward from quest.
     */
    public Integer completeQuest(Quest quest){
        if(questsGiven.contains(quest)){
            if(quest.getIsCompleted()){
                questsGiven.remove(quest);
                return quest.getGoldReward();
            }     
        } 
        return 0;
    }

    /**
     * Get Quests to Give.
     * @return Quests to give.
     */
    public ObservableList<Quest> getQuestsToGive() {
        return  FXCollections.unmodifiableObservableList(questsToGive);
    }
    
    /**
     * Get Quest Given.
     * @return Quest Given.
     */
    public ObservableList<Quest> getQuestsGiven() {
        return  FXCollections.unmodifiableObservableList(questsGiven);
    }
    
    /**
     * Level Increased.
     * As this NPC does not have other atributes that should be changed when
     * level changes, it won't have implementation of this method for now. 
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
