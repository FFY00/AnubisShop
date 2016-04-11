/*
 * Copyright 2016 FFY00
 * 
 * Simple Non Code License (SNCL) v1.10.0
 */
package cf.ffy00.shop.listeners;

import static cf.ffy00.shop.ShopAPI.isShop;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;

/**
 *
 * @author FFY00 <FFY00 at ffy00.cf>
 */
public class LeavesDecayListener implements Listener{
    
    @EventHandler
    public void onLeavesDecay(LeavesDecayEvent e){
        Block b = e.getBlock();
        if(b.getType().equals(Material.SIGN)
                    || b.getType().equals(Material.SIGN_POST)
                    || b.getType().equals(Material.WALL_SIGN)){
            Sign s = (Sign) b.getState();
            if(isShop(s)){
                e.setCancelled(true);
            }
        }
    }
    
}
