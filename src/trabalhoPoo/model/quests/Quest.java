/**
 * Quest.
 * This is the class of the quests of the game.
 * @author Erick Costa Fuga.
 * @author Arthur Cardozo Godinho.
 */
package trabalhoPoo.model.quests;

public class Quest {
    
    Integer minimumLevel;
    Integer goldReward;
    Integer experienceGained;
    String questTitle;
    String objectiveDescription;
    Integer objective; //Objectives will always have a counter. For example: "kill 10 monsters" or "pick 2 items".
    Boolean isCompleted;
    
    
    /**
     * Constructor of Quest Class.
     * This is the constructor of the Quest class. It set's all atributes and 
     * initializes the quest as incomplete.
     * @param questTitle Description of a quest.
     * @param objectiveDescription Description of the objective.
     * @param goldReward Gold rewarded when completing the quest.
     * @param minimumLevel Minimum level required to pick this quest.
     * @param objective Actual objective.
     * @param experienceGained Experience gained when completing this quest.
     */
    public Quest(String questTitle, String objectiveDescription, Integer goldReward,
            int minimumLevel, int objective, int experienceGained){
        this.questTitle = questTitle;
        this.objectiveDescription = objectiveDescription;
        this.goldReward = goldReward;
        this.objective = objective;
        this.minimumLevel = minimumLevel;
        this.experienceGained = experienceGained;
        isCompleted = false;
    }

    /**
     * Get minimum level.
     * @return Minimum Level required to pick this quest.
     */
    public Integer getMinimumLevel() {
        return minimumLevel;
    }

    /**
     * Get Is Completed.
     * @return Boolean to check if the quest is completed.
     */
    public Boolean getIsCompleted() {
        return isCompleted;
    }
    
    /**
     * Get Overall Description.
     * @return Overall description of the quest.
     */
    public String getQuestTitle() {
        return questTitle;
    }

    /**
     * Get Objective Description.
     * @return Objective description of the quest.
     */
    public String getObjectiveDescription() {
        return objectiveDescription;
    }

    /**
     * Get Objective.
     * @return Objective of the quest.
     */
    public Integer getObjective() {
        return objective;
    }

    /**
     * Get Reward.
     * @return Reward of the quest.
     */
    public Integer getGoldReward() {
        return goldReward;
    }
    
    /**
     * Get Experience Gained.
     * @return Experience Gained by completing the quest the quest.
     */
    public Integer getExperienceGained() {
        return experienceGained;
    }
    
    /**
     * Set Is Completed.
     * Sets this quest as completed.
     */
    public void setIsCompleted() {
        this.isCompleted = true;
    }
}
