/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoPoo.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TitledPane;
import trabalhoPoo.Game;
import trabalhoPoo.model.characters.Enemy;
import trabalhoPoo.model.characters.Vendor;
import trabalhoPoo.characters.model.interactions.EnemyInteractions;
import trabalhoPoo.model.items.Item;
import trabalhoPoo.model.rooms.Dungeon;

/**
 * FXML Controller class
 *
 * @author Erick
 */
public class InsideDungeonScreenController {

    Game mainApp;
    Dungeon dungeon;
    
    @FXML
    private TitledPane targetTitledPane;
    @FXML
    private ProgressBar healthBar;
    @FXML
    private ProgressBar energyBar;
    @FXML
    private ListView<Enemy> enemiesList;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {
        healthBar.setStyle("-fx-accent: red");
        healthBar.setProgress(0);
        energyBar.setStyle("-fx-accent: blue");
        energyBar.setProgress(0);
        enemiesList.setCellFactory(param -> new ListCell<Enemy>(){
            @Override
            protected void updateItem(Enemy enemy, boolean empty){
                super.updateItem(enemy, empty);
                if(empty || enemy == null || enemy.getName() == null){
                    setText(null);
                }
                else{
                    setText(enemy.getName());
                }
            }
        });
        enemiesList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> 
                updateTarget(newValue));
    }
    
    /**
     * Set game.
     * Gives the reference from the Game class to this controller.
     * @param mainApp 
     * @param dungeon
     */
    public void setGame(Game mainApp, Dungeon dungeon){
        this.mainApp = mainApp;
        this.dungeon = dungeon;
        mainApp.getMainScreenController().setDialogsTextArea(dungeon.getDungeonTitle());
        enemiesList.setItems(FXCollections.observableArrayList(dungeon.getEnemies()));    
        //targetTitledPane.setText(enemiesList.getSelectionModel().getSelectedItem().getName());
    }

    /**
     * Attack button action.
     */
    @FXML
    private void attackButton() {
        if(enemiesList.getSelectionModel().getSelectedItem().getIsAlive()){
             EnemyInteractions.attackEnemy(mainApp.getGameData().getPlayer(), enemiesList.getSelectionModel().getSelectedItem());
             energyBar.setProgress((float)enemiesList.getSelectionModel().getSelectedItem().getCurrentEnergy() / (float)enemiesList.getSelectionModel().getSelectedItem().getMaximumEnergy());
             healthBar.setProgress((float)enemiesList.getSelectionModel().getSelectedItem().getCurrentHp() / (float)enemiesList.getSelectionModel().getSelectedItem().getMaximumHp());
        }
    }
    
    /**
     * Special attack button action.
     */
    @FXML
    private void specialAttackButton() {
        if(enemiesList.getSelectionModel().getSelectedItem().getIsAlive()){
             EnemyInteractions.specialAttackEnemy(mainApp.getGameData().getPlayer(), enemiesList.getSelectionModel().getSelectedItem());
             energyBar.setProgress((float)enemiesList.getSelectionModel().getSelectedItem().getCurrentEnergy() / (float)enemiesList.getSelectionModel().getSelectedItem().getMaximumEnergy());
             healthBar.setProgress((float)enemiesList.getSelectionModel().getSelectedItem().getCurrentHp() / (float)enemiesList.getSelectionModel().getSelectedItem().getMaximumHp());
        }
    }
    
    /**
     * Exit dungeon button action.
     */
    @FXML
    private void exitButton(){
        boolean canExit = true;
        for(Enemy enemy: dungeon.getEnemies())
            if(enemy.getCurrentHp() > 0)
                canExit = false;
        if(canExit)
            mainApp.showTownScreen();
    }
    
    /**
     * Update target.
     * Updates the health and energy bars.
     * @param enemy enemy who's target is being updated. 
     */
    private void updateTarget(Enemy enemy){
        targetTitledPane.setText(enemy.getName());
        energyBar.setProgress((float)enemy.getCurrentEnergy() / (float)enemy.getMaximumEnergy());
        healthBar.setProgress((float)enemy.getCurrentHp() / (float)enemy.getMaximumHp());
    }
    
}
