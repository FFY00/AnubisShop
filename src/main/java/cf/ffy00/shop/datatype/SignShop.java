/*
 * Copyright 2016 FFY00
 * 
 * Simple Non Code License (SNCL) v1.10.0
 */
package cf.ffy00.shop.datatype;

import org.bukkit.ChatColor;
import org.bukkit.block.Sign;

/**
 *
 * @author FFY00 <FFY00 at ffy00.cf>
 */
public class SignShop {
    
    /*
                             Sign Model
    
    0:         Player Name               <- Just for info
    1:   B BUY_PRICE:SELL_PRICE S        <- Just for info
    2:     ITEM NAME (MATERIAL)          <- Just for info
    3:          SHOP #1                  <- SHOP ID! Where the magic happens...
    */
    
    public SignShop(Sign s){
        String id = ChatColor.stripColor(s.getLine(3)).split("#")[1];
    }
    
    public String getOwner(){
        return "";
    }
    
}
