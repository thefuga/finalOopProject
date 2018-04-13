/**
 * FXML Controller class
 * @author Erick Costa Fuga.
 * @author Arthur Cardozo Godinho.
 */
package trabalhoPoo.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TitledPane;
import trabalhoPoo.Game;
import trabalhoPoo.characters.model.interactions.NpcInteractions;
import trabalhoPoo.model.items.Item;
import trabalhoPoo.model.quests.Quest;



public class QuestsToPickScreenController {

    Game mainApp;
    
    @FXML
    TitledPane questGiverTitledPane;
    @FXML
    ListView<Quest> questsList;
    @FXML
    ProgressBar healthBar;
    @FXML
    ProgressBar energyBar;
    
    /**
     * Initializes the controller class.
     */
    public void initialize() {
        healthBar.setStyle("-fx-accent: red");
        healthBar.setProgress(1);
        energyBar.setStyle("-fx-accent: blue");
        energyBar.setProgress(1);
        questsList.setCellFactory(param -> new ListCell<Quest>(){
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
        mainApp.getMainScreenController().setDialogsTextArea(mainApp.getGameData().getQuestGiver().interact());
        questGiverTitledPane.setText(mainApp.getGameData().getQuestGiver().getName());
        ObservableList<String> quests = FXCollections.observableArrayList();
        mainApp.getGameData().getQuestGiver().getQuestsToGive().stream().forEach((quest) -> {
            quests.add(quest.getQuestTitle());
        });
        questsList.setItems(mainApp.getGameData().getQuestGiver().getQuestsToGive());
    }
    
    /**
     * Go back button action.
     */
    @FXML
    private void goBack(){
        mainApp.showTownScreen();
    }
    
    /**
     * Pick quest button action.
     */
    @FXML
    private void pickQuest(){
        NpcInteractions.pickQuest(mainApp.getGameData().getPlayer(), mainApp.getGameData().getQuestGiver(), questsList.getSelectionModel().getSelectedItem());
    }
    
    /**
     * Complete quest button action.
     */
    @FXML
    private void completeQuest(){
        NpcInteractions.completeQuest(mainApp.getGameData().getPlayer(), mainApp.getGameData().getQuestGiver(), questsList.getSelectionModel().getSelectedItem());
    }
}
