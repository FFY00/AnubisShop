/*
 * Copyright 2016 FFY00
 * 
 * Simple Non Code License (SNCL) v1.10.0
 */
package cf.ffy00.shop;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 *
 * @author FFY00 <FFY00 at ffy00.cf>
 */
public class CommandManager implements CommandExecutor{
    
    private ShopPlugin plugin;
    
    public CommandManager(ShopPlugin plugin){
        this.plugin = plugin;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] agrs) {
        if(label.equalsIgnoreCase("shop")){
            
            return true;
        } else if(label.equalsIgnoreCase("shopadmin")){
            
            return true;
        } else {
            return false;
        }
    }
    
}
