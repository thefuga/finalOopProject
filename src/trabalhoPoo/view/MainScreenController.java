/**
 * FXML Controller class
 * @author Erick Costa Fuga.
 * @author Arthur Cardozo Godinho.
 */

package trabalhoPoo.view;

import javafx.scene.control.ProgressBar;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import trabalhoPoo.Game;


public class MainScreenController {
    
    //Reference to main app
    Game mainApp;
    
    //
    @FXML
    AnchorPane secondaryScreen;
    @FXML
    ProgressBar healthBar;
    @FXML
    ProgressBar energyBar;
    @FXML
    ProgressBar experienceBar;
    @FXML
    ImageView avatar;
    @FXML 
    TitledPane playerTitledPane;
    @FXML
    TextArea dialogsTextArea;
    
    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {
        healthBar.setStyle("-fx-accent: red");
        energyBar.setStyle("-fx-accent: blue");
        experienceBar.setStyle("-fx-accent: grey");
    }

    /**
     * Set game.
     * Gives the reference from the Game class to this controller.
     * @param mainApp 
     */
    public void setGame(Game mainApp){
        this.mainApp = mainApp;
        energyBar.setProgress(mainApp.getGameData().getPlayer().getCurrentEnergy() / mainApp.getGameData().getPlayer().getMaximumEnergy());
        healthBar.setProgress(mainApp.getGameData().getPlayer().getCurrentHp() / mainApp.getGameData().getPlayer().getMaximumHp());
        experienceBar.setProgress(mainApp.getGameData().getPlayer().getExperience());
        
        mainApp.getGameData().getPlayer().getCurrentEnergyProperty().addListener((observable, oldValue, newValue) -> {
            energyBar.setProgress(
                    newValue.floatValue() / mainApp.getGameData().getPlayer().getMaximumEnergy());
        });
        mainApp.getGameData().getPlayer().getCurrentHpProperty().addListener((observable, oldValue, newValue) -> {
            healthBar.setProgress(
                    newValue.floatValue() / mainApp.getGameData().getPlayer().getMaximumHp());
        });
        mainApp.getGameData().getPlayer().getExperienceProperty().addListener((observable, oldValue, newValue) -> {
            experienceBar.setProgress(
                    newValue.floatValue() / mainApp.getGameData().getPlayer().getNextLevelExperience());
        });
        playerTitledPane.setText(mainApp.getGameData().getPlayer().getName());    
        
        avatar.setImage(new Image("file:" + mainApp.getGameData().getPlayerAvatarPath()));
        
        mainApp.showTownScreen();
    }
    
    /**
     * Inventory button action.
     */
    @FXML
    private void inventoryButton(){
        mainApp.showInventory();
    }
    
    /**
     * Character info button action.
     */
    @FXML
    private void equippedItemsButton(){
        mainApp.showCharacterInfoScreen();
    }
    
    /**
     * Quests button action.
     */
    @FXML
    private void questsButton(){
        mainApp.showQuests();
    }
    
    /**
     * Vendors button action.
     */
    @FXML
    private void vendorsButton(){
        mainApp.showVendorsScreen();
    }

    /**
     * Get Secondary Screen.
     * Gets the secondary pane on this screen.
     * @return 
     */
    public AnchorPane getSecondaryScreen() {
        return secondaryScreen;
    }
    
    /**
     * Set dialogs text area.
     * Sets the text on the dialog area.
     * @param text Text to be displayed.
     */
    public void setDialogsTextArea(String text){
        dialogsTextArea.setText(text);
    }
    
}
