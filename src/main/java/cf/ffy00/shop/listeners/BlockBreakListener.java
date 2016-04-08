/*
 * Copyright 2016 FFY00
 * 
 * Simple Non Code License (SNCL) v1.10.0
 */
package cf.ffy00.shop.listeners;

import cf.ffy00.shop.LanguageManager;
import static cf.ffy00.shop.ShopAPI.isShop;
import static cf.ffy00.shop.ShopAPI.getShop;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;

/**
 *
 * @author FFY00 <FFY00 at ffy00.cf>
 */
public class BlockBreakListener {
    
    public void onBlockBreak(BlockBreakEvent e){
        Block b = e.getBlock();
        if(b.getType().equals(Material.SIGN)
                    || b.getType().equals(Material.SIGN_POST)
                    || b.getType().equals(Material.WALL_SIGN)){
            Sign s = (Sign) e.getBlock();
            if(isShop(s)){
                Player p = e.getPlayer();
                if(getShop(s).getOwner().equals(p.getName()) || p.hasPermission("shop.admin")){
                    p.sendMessage(LanguageManager.INFO_SHOP_BREAKED);
                } else {
                    e.setCancelled(true);
                    p.sendMessage(LanguageManager.ERR_CANT_BREAK_SHOP);
                }
            }
        }
    }
    
}
