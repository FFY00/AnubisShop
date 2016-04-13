/*
 * Copyright 2016 FFY00
 * 
 * Simple Non Code License (SNCL) v1.10.0
 */
package cf.ffy00.shop.listeners;

import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

/**
 *
 * @author FFY00 <FFY00 at ffy00.cf>
 */
public final class SignChangeListener implements Listener{
    
    @EventHandler
    public void onSignChange(SignChangeEvent e){
        Sign s = (Sign) e.getBlock().getState();
        if(s.getLine(3).contains("Shop #") ){
            try{
                Integer.parseInt(s.getLine(3).split("#")[1]);
                
            } catch(NumberFormatException ex){}
        }
    }
    
}
