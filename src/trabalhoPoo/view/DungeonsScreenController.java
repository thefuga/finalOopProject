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
import trabalhoPoo.Game;
import trabalhoPoo.model.rooms.Dungeon;


public class DungeonsScreenController {

    Game mainApp;
    
    @FXML
    ListView<Dungeon> dungeonsList;
    
    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {
        dungeonsList.setCellFactory(param -> new ListCell<Dungeon>(){
            @Override
            protected void updateItem(Dungeon dungeon, boolean empty){
                super.updateItem(dungeon, empty);
                if(empty || dungeon == null || dungeon.getDungeonTitle() == null){
                    setText(null);
                }
                else{
                    setText(dungeon.getDungeonTitle());
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
        mainApp.getMainScreenController().setDialogsTextArea("");
        ObservableList<Dungeon> dungeons = FXCollections.observableArrayList();
        mainApp.getGameData().getDungeons().stream().forEach((dungeon) -> {
            dungeons.add(dungeon);
        });
        dungeonsList.setItems(dungeons);
    }
    
    /**
     * Go back button action.
     */
    @FXML
    private void goBack(){
        mainApp.showTownScreen();
    }
    
    /**
     * Enter dungeon button action.
     */
    @FXML
    private void enterDungeon(){
        if(mainApp.getGameData().getPlayer().getLevel() >= dungeonsList.getSelectionModel().getSelectedItem().getMinimumLevel())
            mainApp.showInsideDungeonsScreen(dungeonsList.getSelectionModel().getSelectedItem());
    }
}
