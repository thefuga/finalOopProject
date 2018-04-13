/**
 * FXML Controller class
 * @author Erick Costa Fuga.
 * @author Arthur Cardozo Godinho.
 */
package trabalhoPoo.view;

import javafx.fxml.FXML;
import trabalhoPoo.Game;




public class VendorsScreenController {

    Game mainApp;
    
    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() { 
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
     * Armor vendor button action.
     */
    @FXML
    private void armorsButton(){
        mainApp.showArmorVendorScreen();
    }
    
    /**
     * Weapon vendor button action.
     */
    @FXML
    private void weaponsButton(){
        mainApp.showWeaponVendorScreen();
    }
    
    /**
     * Cunsumable vendor button action.
     */
    @FXML
    private void consumablesButton(){
        mainApp.showConsumableVendorScreen();
    }
}
