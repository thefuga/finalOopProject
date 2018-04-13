/**
 * Dungeon.
 * This is the dungeon class. It golds information about the dungeon and a list
 * of enemies inside.
 * @author Arthur Cardozo Godinho.
 * @author Erick Costa Fuga.
 */
package trabalhoPoo.model.rooms;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import trabalhoPoo.model.characters.Enemy;

public class Dungeon {
    
    private final String dungeonTitle;
    private final String dungeonDescription;
    private final ObservableList<Enemy> enemies;
    private final Integer minimumLevel;
    
    /**
     * Dungeon constructor.
     * This is the dungeon constructor. It sets all info on this dungeon.
     * @param dungeonTitle Title of the dungeon;
     * @param dungeonDescription Description of the dungeon.
     * @param minimumLevel Minimum level to enter the dungeon.
     * @param enemies List of enemies on this dungeon.
     */
    public Dungeon(String dungeonTitle, String dungeonDescription, int minimumLevel, List<Enemy> enemies){
        this.dungeonTitle = dungeonTitle;
        this.dungeonDescription = dungeonDescription;
        this.minimumLevel = minimumLevel;
        this.enemies = FXCollections.observableArrayList(enemies);
    }
    
    /**
     * Get minimum level.
     * @return minimun level to enter in this dungeon.
     */
    public Integer getMinimumLevel(){
        return minimumLevel;
    }

    /**
     * Get dungeon title.
     * @return dungeon title.
     */
    public String getDungeonTitle() {
        return dungeonTitle;
    }

    /**
     * Get dungeon description.
     * @return dungeon descriptio.
     */
    public String getDungeonDescription() {
        return dungeonDescription;
    }

    /**
     * Get enemies.
     * @return list of enemies.
     */
    public ObservableList<Enemy> getEnemies() {
        return enemies;
    }
}