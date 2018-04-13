/**
 * FXML Controller class
 *
 * @author Erick
 */
package trabalhoPoo.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import trabalhoPoo.Game;
import trabalhoPoo.model.items.Armor;
import trabalhoPoo.model.items.Consumable;
import trabalhoPoo.model.items.Item;
import trabalhoPoo.model.items.Weapon;

public class InventoryController {

    Game mainApp;
    
    @FXML
    Label itemName;
    @FXML
    Label label1;
    @FXML
    Label label2;
    @FXML
    Label label3;
    @FXML
    Label label4;
    @FXML
    Label label5;
    @FXML
    Label goldLabel;
    @FXML
    ListView<Item> inventoryList;
    @FXML
    Button itemButton;
    
    Item selectedItem;
    
    /**
     * Initializes the controller class.
     */
    public void initialize() {
        inventoryList.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> fillItemSpecification(newValue));
        inventoryList.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selectedItem = newValue);
        inventoryList.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> fillItemButton(newValue));
        inventoryList.setCellFactory(param -> new ListCell<Item>(){
            @Override
            protected void updateItem(Item item, boolean empty){
                super.updateItem(item, empty);
                if(empty || item == null || item.getName() == null){
                    setText(null);
                }
                else{
                    setText(item.getName());
                }
            }
        });
    }
    
    /**
     * 
     * @param mainApp 
     */
    public void setGame(Game mainApp){
        this.mainApp = mainApp;
        goldLabel.setText("Gold: " + mainApp.getGameData().getPlayer().getGold());
        inventoryList.setItems(mainApp.getGameData().getPlayer().getInventory());
    }
    
    /**
     * 
     * @param item 
     */
    private void fillItemSpecification(Item item){
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
    
    /**
     * 
     * @param item 
     */
    private void fillItemButton(Item item){
        if(null == item)
            itemButton.setText("");
        else if(item instanceof Weapon || item instanceof Armor)
            itemButton.setText("Equip item");
        else
            itemButton.setText("Use item");
    }
    
    /**
     * 
     */
    @FXML
    private void itemActionButton(){
        if(selectedItem != null){
            if(selectedItem instanceof Armor)
                mainApp.getGameData().getPlayer().getEquippedItems().equipArmor((Armor) selectedItem);
            else if(selectedItem instanceof Weapon)
                mainApp.getGameData().getPlayer().getEquippedItems().equipWeapon((Weapon) selectedItem);
            else if(selectedItem instanceof Consumable)
                 mainApp.getGameData().getPlayer().useComsumable((Consumable) selectedItem);
        }
    }
    
}
