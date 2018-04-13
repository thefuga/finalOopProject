/**
 *
 * @author Erick
 */
package trabalhoPoo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static java.util.Spliterators.iterator;
import trabalhoPoo.model.characters.Enemy;
import trabalhoPoo.model.characters.Player;
import trabalhoPoo.model.characters.QuestGiver;
import trabalhoPoo.model.characters.Vendor;
import trabalhoPoo.model.items.Armor;
import trabalhoPoo.model.items.Consumable;
import trabalhoPoo.model.items.Item;
import trabalhoPoo.model.items.MeleeWeapon;
import trabalhoPoo.model.items.RangedWeapon;
import trabalhoPoo.model.quests.Quest;
import trabalhoPoo.model.rooms.Dungeon;
import static trabalhoPoo.util.fileManager.readTextFile;


public class GameData {
    
    private Player player; //The player. Should be created when the game starts.
    private final Vendor weaponVendor; //Vendor of Weapons. Should be created and all of it's items loaded here.
    private final Vendor armorVendor; //Vendor of Armor. Should be created and all of it's items loaded here.
    private final Vendor consumableVendor; //Vendor of Consumables. Should be created and all of it's items loaded here.
    private final List<Dungeon> dungeons; //List of Dungeons. Should be created and loaded here.
    private final QuestGiver questGiver; //The quest giver of the game. Should be created and all of it's quests loaded here.
    private final List<Enemy> enemies; //List of enemies available in the game. Should be used to populate dungeons.
    private String playerAvatarPath; //Player's avatar.
    
    /**
     * Game data constructor.
     * Loads and initializes game data.
     */
    GameData(){
        player = null;
        weaponVendor = loadWeaponVendor();
        armorVendor = loadArmorVendor();
        consumableVendor = loadConsumableVendor();
        enemies = loadEnemies();
        dungeons = loadDungeons();
        questGiver = loadQuestGiver();
    }
    
    /**
     * Gat player.
     * @return player.
     */
    public Player getPlayer() {
        return player;
    }
    /**
     * Get weapon Vendor.
     * @return Weapon vendor.
     */
    public Vendor getWeaponVendor() {
        return weaponVendor;
    }

    /**
     * Get Armor Vendor.
     * @return Armor Vendor.
     */
    public Vendor getArmorVendor() {
        return armorVendor;
    }

    /**
     * Get COnsumable Vendor.
     * @return Consumable Vendor.
     */
    public Vendor getConsumableVendor() {
        return consumableVendor;
    }

    /**
     * Get dungeons.
     * @return list of dungeons.
     */
    public List<Dungeon> getDungeons() {
        return dungeons;
    }

    /**
     * Get quest giver.
     * @return Quest giver.
     */
    public QuestGiver getQuestGiver() {
        return questGiver;
    }

    /**
     * Set player.
     * @param player 
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Get player avatar path.
     * @return player avatar path.
     */
    public String getPlayerAvatarPath() {
        return playerAvatarPath;
    }

    /**
     * Set player avatar path.
     * @param playerAvatarPath 
     */
    public void setPlayerAvatarPath(String playerAvatarPath) {
        this.playerAvatarPath = playerAvatarPath;
    }

    
    //---------------------------PRIVATE METHODS--------------------------------
    //All methods here are responsible for load and initialize game data.
    
    private Vendor loadWeaponVendor(){
        ArrayList<ArrayList<String>> loadedData = readTextFile("WeaponVendor.txt");
        return new Vendor(loadedData.get(0).get(0), Integer.parseInt(loadedData.get(0).get(1)), loadWeapons());
    }
    

    private Vendor loadArmorVendor(){
        ArrayList<ArrayList<String>> loadedData = readTextFile("ArmorVendor.txt");
        return new Vendor(loadedData.get(0).get(0), Integer.parseInt(loadedData.get(0).get(1)), loadArmors());
    }
    

    private Vendor loadConsumableVendor(){
        ArrayList<ArrayList<String>> loadedData = readTextFile("ConsumableVendor.txt");
        return new Vendor(loadedData.get(0).get(0), Integer.parseInt(loadedData.get(0).get(1)), loadConsumables());
    }
    
    private QuestGiver loadQuestGiver(){
        ArrayList<ArrayList<String>> loadedData = readTextFile("QuestGiver.txt");
        return new QuestGiver(loadedData.get(0).get(0), Integer.parseInt(loadedData.get(0).get(1)), loadQuests());
    }
    

    private List<Dungeon> loadDungeons(){
        ArrayList<ArrayList<String>> loadedData = readTextFile("Dungeons.txt");
        List<Dungeon> loadedDungeons = new ArrayList<>();
        List<Enemy> dungeonEnemies = new ArrayList<>();
        
        dungeonEnemies.add(enemies.get(0));
        loadedDungeons.add(new Dungeon(loadedData.get(0).get(0), loadedData.get(0).get(1), Integer.parseInt(loadedData.get(0).get(2)), dungeonEnemies));
        
        dungeonEnemies.add(enemies.get(1));
        loadedDungeons.add(new Dungeon(loadedData.get(1).get(0), loadedData.get(1).get(1), Integer.parseInt(loadedData.get(1).get(2)), dungeonEnemies));
        
        dungeonEnemies.add(enemies.get(2));
        loadedDungeons.add(new Dungeon(loadedData.get(2).get(0), loadedData.get(2).get(1), Integer.parseInt(loadedData.get(2).get(2)), dungeonEnemies));
        
        dungeonEnemies.add(enemies.get(3));
        loadedDungeons.add(new Dungeon(loadedData.get(3).get(0), loadedData.get(3).get(1), Integer.parseInt(loadedData.get(3).get(2)), dungeonEnemies));
        
        dungeonEnemies.add(enemies.get(4));
        loadedDungeons.add(new Dungeon(loadedData.get(4).get(0), loadedData.get(4).get(1), Integer.parseInt(loadedData.get(4).get(2)), dungeonEnemies));
        
        dungeonEnemies.add(enemies.get(4));
        loadedDungeons.add(new Dungeon(loadedData.get(5).get(0), loadedData.get(5).get(1), Integer.parseInt(loadedData.get(5).get(2)), dungeonEnemies));
        return loadedDungeons;
    }
    

    private List<Item> loadWeapons(){
        ArrayList<ArrayList<String>> loadedFile;
        loadedFile = readTextFile("MeleeWeapons.txt");
        List<Item> loadedWeapons = new ArrayList<>();
        //Loads melee weapons:
        for(ArrayList<String> loadedMeleeWeapon: loadedFile){
            loadedWeapons.add(new MeleeWeapon(Integer.parseInt(loadedMeleeWeapon.get(0)),
                                   Integer.parseInt(loadedMeleeWeapon.get(1)),
                                   Integer.parseInt(loadedMeleeWeapon.get(2)),
                                   loadedMeleeWeapon.get(3)));
        }
        
        //Loads ranged weapons:
        loadedFile = readTextFile("RangedWeapons.txt");
        for(ArrayList<String> loadedRangedWeapon: loadedFile){
            loadedWeapons.add(new RangedWeapon(Integer.parseInt(loadedRangedWeapon.get(0)),
                                               Integer.parseInt(loadedRangedWeapon.get(1)),
                                               Integer.parseInt(loadedRangedWeapon.get(2)),
                                               loadedRangedWeapon.get(3)));
        }
        
        return loadedWeapons;
    }
    

    private List<Item> loadArmors(){
        ArrayList<ArrayList<String>> loadedFile;
        loadedFile = readTextFile("Armors.txt");
        List<Item> loadedArmors = new ArrayList<>();
        //Loads armors:
        for(ArrayList<String> loadedArmor: loadedFile){
            loadedArmors.add(new Armor(Integer.parseInt(loadedArmor.get(0)),
                                       Integer.parseInt(loadedArmor.get(1)),
                                       Integer.parseInt(loadedArmor.get(2)),
                                       loadedArmor.get(3)));
        }
        
        return loadedArmors;
    }
    

    private List<Item> loadConsumables(){
        ArrayList<ArrayList<String>> loadedFile;
        loadedFile = readTextFile("Consumables.txt");
        List<Item> loadedConsumables = new ArrayList<>();
        //Loads armors:
        for(ArrayList<String> loadedConsumable: loadedFile){
            loadedConsumables.add(new Consumable(Integer.parseInt(loadedConsumable.get(0)),
                                                 Integer.parseInt(loadedConsumable.get(1)),
                                                 Integer.parseInt(loadedConsumable.get(2)),
                                                 Integer.parseInt(loadedConsumable.get(3)),
                                                 loadedConsumable.get(4)));
        }
        
        return loadedConsumables;
    }
    

    private List<Quest> loadQuests(){
        ArrayList<ArrayList<String>> loadedFile;
        loadedFile = readTextFile("Quests.txt");
        List<Quest> loadedQuests = new ArrayList<>();
        //Loads melee weapons:
        for(ArrayList<String> loadedQuest: loadedFile){
            loadedQuests.add(new Quest(loadedQuest.get(0),
                                       loadedQuest.get(1),
                                       Integer.parseInt(loadedQuest.get(2)),
                                       Integer.parseInt(loadedQuest.get(3)),
                                       Integer.parseInt(loadedQuest.get(4)),
                                       Integer.parseInt(loadedQuest.get(5))));
        }
        return loadedQuests;
    }
    

    private List<Enemy> loadEnemies(){
        ArrayList<ArrayList<String>> loadedFile;
        loadedFile = readTextFile("Enemies.txt");
        List<Enemy> loadedEnemies = new ArrayList<>();
        for(ArrayList<String> loadedEnemy: loadedFile){
            loadedEnemies.add(new Enemy(loadedEnemy.get(0),
                                        Integer.parseInt(loadedEnemy.get(1)),
                                        new ArrayList<>()));
        }
        return loadedEnemies;
    }
}
