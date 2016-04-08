/*
 * Copyright 2016 FFY00
 * 
 * Simple Non Code License (SNCL) v1.10.0
 */
package cf.ffy00.shop.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 *
 * @author FFY00 <FFY00 at ffy00.cf>
 */
public final class PlayerInteractListener implements Listener{
    
    public void onPlayerInteract(PlayerInteractEvent e){
        if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.LEFT_CLICK_BLOCK)){
            Player p = (Player) e.getPlayer();
            Block b = e.getClickedBlock();
            if(b.getType().equals(Material.SIGN)
                    || b.getType().equals(Material.SIGN_POST)
                    || b.getType().equals(Material.WALL_SIGN)){
                
            }
        }
    }
    
}
