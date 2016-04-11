/*
 * Copyright 2016 FFY00
 * 
 * Simple Non Code License (SNCL) v1.10.0
 */
package cf.ffy00.shop.listeners;

import static cf.ffy00.shop.ShopAPI.getShop;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 *
 * @author FFY00 <FFY00 at ffy00.cf>
 */
public final class PlayerInteractListener implements Listener{
    
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){
        if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.LEFT_CLICK_BLOCK)){
            Player p = e.getPlayer();
            Block b = e.getClickedBlock();
            if(b.getState() instanceof Sign){
                Sign s = (Sign) b.getState();
                if(getShop(s).isShop()){
                    
                }
            }
        }
    }
    
}
