/**
 * FXML Controller class
 * @author Erick Costa Fuga.
 * @author Arthur Cardozo Godinho.
 */
package trabalhoPoo.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import trabalhoPoo.Game;
import trabalhoPoo.model.quests.Quest;


public class QuestsController {

    Game mainApp;
    
    @FXML
    ListView<Quest> activeQuestsList;
    @FXML
    ListView<Quest> completedQuestsList;
    @FXML
    Label questTitle;
    @FXML
    Label questObjective;
    @FXML
    TextArea questDescription;
    
    
    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {
        activeQuestsList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> 
                showSelectedQuest(newValue));
        activeQuestsList.setCellFactory(param -> new ListCell<Quest>(){
            @Override
            protected void updateItem(Quest quest, boolean empty){
                super.updateItem(quest, empty);
                if(empty || quest == null || quest.getQuestTitle() == null){
                    setText(null);
                }
                else{
                    setText(quest.getQuestTitle());
                }
            }
        });
    }
    
    /**
     * Set game.
     * Gives the reference from the Game class to this controller.
     * @param mainApp 
     */
    public void setGame(Game mainApp){
        this.mainApp = mainApp;
        activeQuestsList.setItems(mainApp.getGameData().getPlayer().getActiveQuests());
        completedQuestsList.setItems(mainApp.getGameData().getPlayer().getCompletedQuests());
    }
    
    /**
     * Action to the listener.
     * @param quest 
     */
    private void showSelectedQuest(Quest quest){
        questTitle.setText(quest.getQuestTitle());
        questObjective.setText("Quest Objective: kill " + quest.getObjective() + " mobs");
        questDescription.setText(quest.getObjectiveDescription());
    }
}
