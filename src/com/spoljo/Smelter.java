package com.spoljo;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
 
public class Smelter extends JavaPlugin {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	if(command.getName().equalsIgnoreCase("smelt") && sender instanceof Player){
    		
    	}
        if (!(sender instanceof Player)) {
            sender.sendMessage("§3[§5Smelter§3] §cYou must be in game to perform this command."); 
            return true;}
        if (!sender.hasPermission("smelter.use")){
            sender.sendMessage("§3[§5Smelter§3]  §cYou don't have permission to use this command. "); 
            return true;}
        ItemStack toSmelt = ((Player)sender).getItemInHand(); 
        Material type = toSmelt.getType(); 
        if (type.equals(Material.AIR)){
            sender.sendMessage("§3[§5Smelter§3] §cYou can't smelt air. §2d(-_-)b"); 
            return true;
        } else if (type.equals(Material.COAL_ORE)) toSmelt.setType(Material.COAL); 
        else if (type.equals(Material.IRON_ORE)) toSmelt.setType(Material.IRON_INGOT); 
        else if (type.equals(Material.LAPIS_ORE)){
            toSmelt.setType(Material.INK_SACK); 
            toSmelt.setDurability((short)4);}
        else if (type.equals(Material.GOLD_ORE)) toSmelt.setType(Material.GOLD_INGOT); 
        else if (type.equals(Material.DIAMOND_ORE)) toSmelt.setType(Material.DIAMOND); 
        else if (type.equals(Material.REDSTONE_ORE)) toSmelt.setType(Material.REDSTONE); 
        else if (type.equals(Material.EMERALD_ORE)) toSmelt.setType(Material.EMERALD);
        else if (type.equals(Material.COBBLESTONE)) toSmelt.setType(Material.STONE);
        else if (type.equals(Material.SAND)) toSmelt.setType(Material.GLASS);
        else{
            sender.sendMessage("§3[§5Smelter§3] §cYou can't smelt that item. "); 
            return true;}
        sender.sendMessage("§3[§5Smelter§3] §cI have smelted this item for you! §2=§6]"); 
        return true;}
    
}