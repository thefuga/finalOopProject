/**
 * This class controls interactions between players and NPCs.
 * For now, vendors won't have gold on them and their goods will never change,
 * but the class may be more usefull for interactions with vendors in the future
 * in case this changes. This class will control interactions, so an NPC will 
 * never have to control player's attributes.
 * @author Erick Costa Fuga.
 * @author Arthur Cardozo Godinho.
 */

package trabalhoPoo.characters.model.interactions;

import trabalhoPoo.model.characters.Player;
import trabalhoPoo.model.characters.QuestGiver;
import trabalhoPoo.model.characters.Vendor;
import trabalhoPoo.model.quests.Quest;
import trabalhoPoo.model.items.Item;

public abstract class NpcInteractions {
    
    /**
     * Sell item to vendor.
     * This method should be used to manage this kind of interaction. It checks
     * if the player have the item, calls the purchase method from Vendor, 
     * adding the item's value to player's total gold Finally removes the item 
     * from player's inventory.
     * @param player Player selling the item.
     * @param vendor Vendor purchasing the item.
     * @param item Item being sold.
     * @return Returns true if operation was successfull. False otherwise.
     */
    public static boolean sellItemToVendor(Player player, Vendor vendor, Item item){
        
        if(player.getInventory().contains(item)){//Checks if player actually have the item
            player.setGold(player.getGold() + vendor.purchase(item));//Sells the item to the vendor, getting the ammount of gold the item worths
            player.dropItem(item);//Removes the sold item from player's inventory
            return true;
        }
        return false;
    }
    
    /**
     * Buy item from vendor.
     * This method should be used to manage this kind of interaction. It checks
     * if the vendor have the item. If yes, checks if player have the ammount of
     * gold requiered to purchase the item. Then it calls the sell method from
     * vendor and add the returned item to the player's inventory. Finally, 
     * removes the gold from player's total ammount.
     * @param player
     * @param vendor
     * @param item
     * @return Returns true if operation was successfull. False otherwise.
     */
    public static boolean buyItemFromVendor(Player player, Vendor vendor, Item item){
        
        if(vendor.getGoods().contains(item)){//Checks if vendor actually have the item
            if(player.getGold() >= item.getPrice()){//Checks if player have the ammount of gold requiered to complete the transaction
                player.pickItem(vendor.sell(item));//Add the item to the player's inventory. Calls Vendor.sell() method getting the item from the vendor.
                player.setGold(player.getGold() - item.getPrice());
                return true;
            }
        }
        
        return false;
    }
    
    
    /**
     * Pick Quest.
     * This method should be used to manage this kind of interaction. It checks
     * if the player has the minimum level to pick the quest, then checks if the
     * quest giver actually have the quest. If yes, calls the pickQuest method
     * from the player and the giveQuest method from the quest giver.
     * @param player 
     * @param questGiver
     * @param quest
     * @return Returns true if operation was successfull. False otherwise.
     */
    public static boolean pickQuest(Player player, QuestGiver questGiver, Quest quest){
        if(player.getLevel() >= quest.getMinimumLevel()){
            if(questGiver.getQuestsToGive().contains(quest)){
                player.pickQuest(questGiver.giveQuest(quest));
                return true;
            }
        }
        return false;
    }
    
    /**
     * Complete Quest.
     * This method should be used to manage this kind of interaction. It checks 
     * if the quest is actually completed, then checks if the quest giver has 
     * this quest in it's given quests list. If yes, calls player's 
     * completeQuest method and pickItem method with quest giver's completeQuest
     * method as paramater.
     * @param player
     * @param questGiver
     * @param quest
     * @return Returns true if operation was successfull. False otherwise.
     */
    public static boolean completeQuest(Player player, QuestGiver questGiver, Quest quest){
        if(quest.getIsCompleted()){
            if(questGiver.getQuestsGiven().contains(quest)){
                player.completeQuest(quest);
                player.gainExperience(quest.getExperienceGained());
                player.setGold(player.getGold() + questGiver.completeQuest(quest));
                return true;
            }
        }
        return false;
    }
}
