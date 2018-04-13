/**
 * FXML Controller class
 * @author Erick Costa Fuga.
 * @author Arthur Cardozo Godinho.
 */
package trabalhoPoo.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import trabalhoPoo.Game;
import trabalhoPoo.model.items.Armor;
import trabalhoPoo.model.items.Consumable;
import trabalhoPoo.model.items.Item;
import trabalhoPoo.model.items.Weapon;


public class SelectedItemScreenController {

    private Game mainApp;
    
    @FXML
    private Label itemName;
    @FXML
    private Label label3;
    @FXML
    private Label label5;
    @FXML
    private Label label4;
    @FXML
    private Label label2;
    @FXML
    private Label label1;

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
     * @param item
     */
    public void setGame(Game mainApp, Item item){
        this.mainApp = mainApp;
        itemName.setText(item.getName());
        label1.setText("Value: " + item.getPrice());
        label2.setText("Minimum level: " + item.getMinimumLevel());
        if(item instanceof Weapon)
            label3.setText("Base damage: " + ((Weapon) item).getBaseDamage());
        if(item instanceof Armor)
            label3.setText("Base deffense: " + ((Armor) item).getBaseDeffense());
        if(item instanceof Consumable){
            label3.setText("HP restored: " + ((Consumable) item).getHpRestored());
            label4.setText("Energy restored: " + ((Consumable) item).getEnergyRestored());
        }
    }
}
