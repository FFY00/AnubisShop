/*
 * Copyright 2016 FFY00
 * 
 * Simple Non Code License (SNCL) v1.10.0
 */
package cf.ffy00.shop.listeners;

import static cf.ffy00.shop.ShopAPI.getShop;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonEvent;

/**
 *
 * @author FFY00 <FFY00 at ffy00.cf>
 */
public class BlockPistonListener implements Listener{
    
    @EventHandler
    public void onBlockPiston(BlockPistonEvent e){
        Block b = e.getBlock();
        if(b.getState() instanceof Sign){
            Sign s = (Sign) e.getBlock();
            if(getShop(s).isShop()){
                e.setCancelled(true);
            }
        }
    }
    
}
