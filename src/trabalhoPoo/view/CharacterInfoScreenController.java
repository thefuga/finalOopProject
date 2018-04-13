/**
 * FXML Controller class
 * @author Arthur Cardozo Godinho.
 * @author Erick Costa Fuga.
 */

package trabalhoPoo.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import trabalhoPoo.Game;


public class CharacterInfoScreenController {

    Game mainApp;
    
    @FXML
    Label armorLabel;
    @FXML
    Label weaponLabel;
    @FXML
    Label levelLabel;
    @FXML
    Label attackLabel;
    @FXML
    Label deffenseLabel;
    
    
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
        armorLabel.setText("Equipped armor: " + mainApp.getGameData().getPlayer().getEquippedItems().getEquippedArmor().getName());
        weaponLabel.setText("Equipped weapon: " + mainApp.getGameData().getPlayer().getEquippedItems().getEquippedWeapon().getName());
        levelLabel.setText(String.valueOf(mainApp.getGameData().getPlayer().getLevel()));
        attackLabel.setText(String.valueOf(mainApp.getGameData().getPlayer().getAttackPower()));
        deffenseLabel.setText(String.valueOf(mainApp.getGameData().getPlayer().getDeffensePower()));
    }
    
    /**
     * Unequip Armor button action.
     */
    @FXML
    private void unequipArmorButton(){
        mainApp.getGameData().getPlayer().getEquippedItems().unequipArmor();
        armorLabel.setText("Equipped armor: ");
    }
    
    /**
     * Unequip Weapon button action.
     */
    @FXML
    private void unequipWeaponButton(){
        mainApp.getGameData().getPlayer().getEquippedItems().unequipWeapon();
        weaponLabel.setText("Equipped weapon: ");
    }
}
