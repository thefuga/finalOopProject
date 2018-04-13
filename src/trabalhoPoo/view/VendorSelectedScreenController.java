/**
 * FXML Controller class
 * @author Erick Costa Fuga.
 * @author Arthur Cardozo Godinho.
 */
package trabalhoPoo.view;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TitledPane;
import trabalhoPoo.Game;
import trabalhoPoo.model.characters.Vendor;
import trabalhoPoo.characters.model.interactions.NpcInteractions;
import trabalhoPoo.model.items.Item;


public class VendorSelectedScreenController {

    Game mainApp;
    Vendor vendor;
    
    @FXML
    TitledPane vendorTitledPane;
    @FXML
    ListView<Item> goodsList;
    @FXML
    ProgressBar healthBar;
    @FXML
    ProgressBar energyBar;
    
    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {
        healthBar.setStyle("-fx-accent: red");
        healthBar.setProgress(1);
        energyBar.setStyle("-fx-accent: blue");
        energyBar.setProgress(1);
        goodsList.setCellFactory(param -> new ListCell<Item>(){
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
     * Set game.
     * Gives the reference from the Game class to this controller.
     * @param mainApp 
     * @param vendor
     */
    public void setGame(Game mainApp, Vendor vendor){
        this.mainApp = mainApp;
        this.vendor = vendor;
        mainApp.getMainScreenController().setDialogsTextArea(this.vendor.interact());
        vendorTitledPane.setText(this.vendor.getName());
        goodsList.setItems(FXCollections.observableArrayList(vendor.getGoods()));    
    }
    
    /**
     * Go back button action.
     */
    @FXML
    private void goBack(){
        mainApp.showTownScreen();
    }
    
    /**
     * Buy button action.
     */
    @FXML
    private void buyButton(){
        NpcInteractions.buyItemFromVendor(mainApp.getGameData().getPlayer(), vendor, goodsList.getSelectionModel().getSelectedItem());
    }
    
    /**
     * View item button action.
     */
    @FXML
    private void viewItemButton(){
         mainApp.showSelectedItemScreen(goodsList.getSelectionModel().getSelectedItem());
    }
    
}
