/**
 * Game class.
 * This is the class responsible for all the execution of the game and control
 * of the game. 
 * @author Erick Costa Fuga.
 * @author Arthur Cardozo Godinho.
 */
package trabalhoPoo;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import trabalhoPoo.model.items.Item;
import trabalhoPoo.model.rooms.Dungeon;
import trabalhoPoo.view.CharacterInfoScreenController;
import trabalhoPoo.view.CreateNewPlayerController;
import trabalhoPoo.view.DungeonsScreenController;
import trabalhoPoo.view.InsideDungeonScreenController;
import trabalhoPoo.view.InventoryController;
import trabalhoPoo.view.MainScreenController;
import trabalhoPoo.view.QuestsController;
import trabalhoPoo.view.QuestsToPickScreenController;
import trabalhoPoo.view.RootLayoutController;
import trabalhoPoo.view.SelectedItemScreenController;
import trabalhoPoo.view.TownScreenController;
import trabalhoPoo.view.VendorSelectedScreenController;
import trabalhoPoo.view.VendorsScreenController;


public class Game extends Application implements java.io.Serializable{

    MainScreenController mainScreenController;
    private Stage primaryStage;
    private BorderPane rootLayout;
    GameData gameData;
    
    /**
     * Default constructor.
     */
    public Game(){
        gameData = new GameData();
    }
    
    /**
     * Start method.
     * @param primaryStage 
     */
    @Override
    public void start(Stage primaryStage) {
       this.primaryStage = primaryStage;
       this.primaryStage.setTitle("The Man Who Kills the Mobs");
       initRootLayout();
       
       gameData.getPlayer().getIsAliveProperty().addListener((observable, oldValue, newValue) -> {
            showGameOverScreen();
        });
       
       showMainScreen();
    }
    
    /**
     * Initializes the root layout.
     */
    public void initRootLayout(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Game.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            
            primaryStage.setScene(scene);
            
            RootLayoutController controller = loader.getController();
            controller.setGame(this);
            
            primaryStage.show();   
            showCreateNewPlayer();
        }catch(IOException e){
        }
    }
    
    /**
     * Displays game over screen.
     */
    private void showGameOverScreen(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Game.class.getResource("view/GameOverScreen.fxml"));
            AnchorPane anchorPane = (AnchorPane) loader.load();

            rootLayout.setCenter(anchorPane);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    /**
     * Displays main screen.
     */
    public void showMainScreen(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Game.class.getResource("view/MainScreen.fxml"));
            AnchorPane anchorPane = (AnchorPane) loader.load();

            rootLayout.setCenter(anchorPane);
            
            mainScreenController = loader.getController();
            mainScreenController.setGame(this);
        }catch(IOException e){
        }
    }
    
    /**
     * Shows new player screen.
     */
    private void showCreateNewPlayer(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Game.class.getResource("view/CreateNewPlayer.fxml"));
            AnchorPane janela = (AnchorPane) loader.load();
            
            Stage createNewPlayerStage = new Stage();
            createNewPlayerStage.setTitle("Create new player");
            createNewPlayerStage.initModality(Modality.WINDOW_MODAL);
            createNewPlayerStage.initOwner(primaryStage);
            Scene scene = new Scene(janela);
            createNewPlayerStage.setScene(scene);
            
            CreateNewPlayerController controller = loader.getController();
            controller.setGame(this);
            controller.setCreateNewPlayerStage(createNewPlayerStage); 
            
            createNewPlayerStage.showAndWait();
        }catch(IOException e){
        }
    }
    
    /**
     * Displays inventory.
     */
    public void showInventory(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Game.class.getResource("view/Inventory.fxml"));
            AnchorPane janela = (AnchorPane) loader.load();
            
            Stage inventoryStage = new Stage();
            inventoryStage.setTitle("Inventory");
            inventoryStage.initModality(Modality.WINDOW_MODAL);
            inventoryStage.initOwner(primaryStage);
            Scene scene = new Scene(janela);
            inventoryStage.setScene(scene);
            
            InventoryController controller = loader.getController();
            controller.setGame(this);
            
            inventoryStage.showAndWait();
        }catch(IOException e){
        }
    }
    
    /**
     * Displays list of quests on a character.
     */
    public void showQuests(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Game.class.getResource("view/Quests.fxml"));
            AnchorPane janela = (AnchorPane) loader.load();
            
            Stage questsStage = new Stage();
            questsStage.setTitle("Inventory");
            questsStage.initModality(Modality.WINDOW_MODAL);
            questsStage.initOwner(primaryStage);
            Scene scene = new Scene(janela);
            questsStage.setScene(scene);
            
            QuestsController controller = loader.getController();
            controller.setGame(this);
            
            questsStage.showAndWait();
        }catch(IOException e){
        }
    }
    
    /**
     * Displays character info.
     */
    public void showCharacterInfoScreen(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Game.class.getResource("view/CharacterInfoScreen.fxml"));
            AnchorPane janela = (AnchorPane) loader.load();
            
            Stage equippedItemsStage = new Stage();
            equippedItemsStage.setTitle("Character info");
            equippedItemsStage.initModality(Modality.WINDOW_MODAL);
            equippedItemsStage.initOwner(primaryStage);
            Scene scene = new Scene(janela);
            equippedItemsStage.setScene(scene);
            
            CharacterInfoScreenController controller = loader.getController();
            controller.setGame(this);
            
            equippedItemsStage.showAndWait();
        }catch(IOException e){
        }
    }
    
    /**
     * Displays an item info.
     * @param item Item who's info will be displayed.
     */
    public void showSelectedItemScreen(Item item){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Game.class.getResource("view/SelectedItemScreen.fxml"));
            AnchorPane janela = (AnchorPane) loader.load();
            
            Stage equippedItemsStage = new Stage();
            equippedItemsStage.setTitle("Item info");
            equippedItemsStage.initModality(Modality.WINDOW_MODAL);
            equippedItemsStage.initOwner(primaryStage);
            Scene scene = new Scene(janela);
            equippedItemsStage.setScene(scene);
            
            SelectedItemScreenController controller = loader.getController();
            controller.setGame(this, item);
            
            equippedItemsStage.showAndWait();
        }catch(IOException e){
        }
    }
    
    /**
     * Displays town screen.
     */
    public void showTownScreen(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Game.class.getResource("view/TownScreen.fxml"));
            mainScreenController.getSecondaryScreen().getChildren().clear();
            mainScreenController.getSecondaryScreen().getChildren().add((AnchorPane) loader.load());
            
            TownScreenController controller = loader.getController();
            controller.setGame(this);
        }catch(IOException e){
        }
    }
    
    /**
     * Displays the vendors screen.
     */
    public void showVendorsScreen(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Game.class.getResource("view/VendorsScreen.fxml"));
            mainScreenController.getSecondaryScreen().getChildren().clear();
            mainScreenController.getSecondaryScreen().getChildren().add((AnchorPane) loader.load());
            
            VendorsScreenController controller = loader.getController();
            controller.setGame(this);
        }catch(IOException e){
        }
    }
    
    /**
     * Displays an armor vendor screen.
     */
    public void showArmorVendorScreen(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Game.class.getResource("view/VendorSelectedScreen.fxml"));
            mainScreenController.getSecondaryScreen().getChildren().clear();
            mainScreenController.getSecondaryScreen().getChildren().add((AnchorPane) loader.load());
            
            VendorSelectedScreenController controller = loader.getController();
            controller.setGame(this, gameData.getArmorVendor());
        }catch(IOException e){
        }
    }
    
    /**
     * Displays a weapon vendor screen.
     */
    public void showWeaponVendorScreen(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Game.class.getResource("view/VendorSelectedScreen.fxml"));
            mainScreenController.getSecondaryScreen().getChildren().clear();
            mainScreenController.getSecondaryScreen().getChildren().add((AnchorPane) loader.load());
            
            VendorSelectedScreenController controller = loader.getController();
            controller.setGame(this, gameData.getWeaponVendor());
        }catch(IOException e){
        }
    }
    
    /**
     * Displays a consumable vendor screen.
     */
    public void showConsumableVendorScreen(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Game.class.getResource("view/VendorSelectedScreen.fxml"));
            mainScreenController.getSecondaryScreen().getChildren().clear();
            mainScreenController.getSecondaryScreen().getChildren().add((AnchorPane) loader.load());
            
            VendorSelectedScreenController controller = loader.getController();
            controller.setGame(this, gameData.getConsumableVendor());
        }catch(IOException e){
        }
    }
    
    /**
     * Displays a sreen with available quests to pick.
     */
    public void showQuestsToPickScreen(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Game.class.getResource("view/QuestsToPickScreen.fxml"));
            mainScreenController.getSecondaryScreen().getChildren().clear();
            mainScreenController.getSecondaryScreen().getChildren().add((AnchorPane) loader.load());
            
            QuestsToPickScreenController controller = loader.getController();
            controller.setGame(this);
        }catch(IOException e){
        }
    }
    
    /**
     * Displays a list of dungeons.
     */
    public void showDungeonsScreen(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Game.class.getResource("view/DungeonsScreen.fxml"));
            mainScreenController.getSecondaryScreen().getChildren().clear();
            mainScreenController.getSecondaryScreen().getChildren().add((AnchorPane) loader.load());
            
            DungeonsScreenController controller = loader.getController();
            controller.setGame(this);
        }catch(IOException e){
        }
    }
    
    /**
     * Displays the dungeon and combat screen.
     * @param dungeon Dungeon to be displayed.
     */
    public void showInsideDungeonsScreen(Dungeon dungeon){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Game.class.getResource("view/InsideDungeonScreen.fxml"));
            mainScreenController.getSecondaryScreen().getChildren().clear();
            mainScreenController.getSecondaryScreen().getChildren().add((AnchorPane) loader.load());
            
            InsideDungeonScreenController controller = loader.getController();
            controller.setGame(this, dungeon);
        }catch(IOException e){
        }
    }
    
    /**
     * Get game data.
     * @return returns the game data.
     */
    public GameData getGameData(){
        return gameData;
    }

    /**
     * Get Main Screen Controller.
     * @return The main screen controller.
     */
    public MainScreenController getMainScreenController() {
        return mainScreenController;
    }
    
    
    //--------------------------------MAIN--------------------------------------
    /**
     * Main method.
     * @param args 
     */
    public static void main(String[] args) {
        Font.loadFont(Game.class.getResource("view/fonts/Barbarian.ttf").toExternalForm(), 10);
        Font.loadFont(Game.class.getResource("view/fonts/OLDENGL.TTF").toExternalForm(), 10);
        Font.loadFont(Game.class.getResource("view/fonts/BASKVILL.TTF").toExternalForm(), 10);
        launch(args);
    }
    
}
