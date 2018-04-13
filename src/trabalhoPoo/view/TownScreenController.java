/**
 * FXML Controller class
 * @author Erick Costa Fuga.
 * @author Arthur Cardozo Godinho.
 */
package trabalhoPoo.view;

import javafx.fxml.FXML;
import trabalhoPoo.Game;


public class TownScreenController {

    Game mainApp;
    /**
     * Initializes the controller class.
     */
    public void initialize() {
    }    

    /**
     * Set game.
     * Gives the reference from the Game class to this controller.
     * @param mainApp 
     */
    public void setGame(Game mainApp){
        this.mainApp = mainApp;
        mainApp.getMainScreenController().setDialogsTextArea("Welcome to the City. hero!\n" +
                                                             "Here you'll find everything you need to get\n" +
                                                             "ready for combat, aswell as lots of challenging\n" +
                                                             "missions.\n" +
                                                             "Feel free to walk around!");
    }
    
    /**
     * Dungeons button action.
     */
    @FXML
    private void dungeonsButton() {
        mainApp.showDungeonsScreen();
    }

    /**
     * Quests to pick button action.
     */
    @FXML
    private void questsToPickButton() {
        mainApp.showQuestsToPickScreen();
    }

    /**
     * Vendors button action.
     */
    @FXML
    private void vendorsButton() {
        mainApp.showVendorsScreen();
    }
    
}
