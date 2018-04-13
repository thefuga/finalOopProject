/**
 * FXML Controller class
 * @author Erick Costa Fuga.
 * @author Arthur Cardozo Godinho.
 */
package trabalhoPoo.view;

import trabalhoPoo.Game;


public class RootLayoutController {

    Game mainApp;
            
    /**
     * Initializes the controller class.
     */
    public void initialize() {
        // TODO
    }
    
    /**
     * Set game.
     * Gives the reference from the Game class to this controller.
     * @param mainApp 
     */
    public void setGame(Game mainApp){
        this.mainApp = mainApp;
    }
    
}
