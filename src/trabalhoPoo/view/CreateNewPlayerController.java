/**
 * FXML Controller class
 *
 * @author Erick Costa Fuga.
 * @author Arthur Cardozo Godinho.
 */
package trabalhoPoo.view;

import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import trabalhoPoo.Game;
import trabalhoPoo.model.characters.Melee;


public class CreateNewPlayerController {

    private Game mainApp;
    private Stage createNewPlayerStage;
    
    @FXML
    TextField nameTextField;
    @FXML 
    MenuButton classMenuButton;
    @FXML
    MenuItem meleeMenuItem;
    @FXML
    MenuItem rangedMenuItem;
    
    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {
        meleeMenuItem.setOnAction(action -> {
            classMenuButton.setText(meleeMenuItem.getText());
        });
        
        rangedMenuItem.setOnAction(action -> {
            classMenuButton.setText(rangedMenuItem.getText());
        });
    }    
    
    /**
     * Set game.
     * Gives the reference from the Game class to this controller.
     * @param mainApp 
     */
    public void setGame(Game mainApp){
        this.mainApp = mainApp;
    }
    
    /**
     * Set Create new player stage.
     * Set's the stage for this screen.
     * @param createNewPlayerStage 
     */
    public void setCreateNewPlayerStage(Stage createNewPlayerStage){
        this.createNewPlayerStage = createNewPlayerStage;
    }
    
    /**
     * Done button action.
     */
    @FXML
    private void doneButton(){
        switch(classMenuButton.getText()){
            case "Melee":
                mainApp.getGameData().setPlayer(new Melee(nameTextField.getText()));
                createNewPlayerStage.close();
                mainApp.getGameData().setPlayerAvatarPath("src/trabalhoPoo/preloadedFiles/warriorAvatar.png");
                break;
            case "Ranged":
                mainApp.getGameData().setPlayer(new Melee(nameTextField.getText()));
                createNewPlayerStage.close();
                mainApp.getGameData().setPlayerAvatarPath("src/trabalhoPoo/preloadedFiles/hunterAvatar.png");
                break;
        }
    }
}
