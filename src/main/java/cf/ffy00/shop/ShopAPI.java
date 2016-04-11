/*
 * Copyright 2016 FFY00
 * 
 * Simple Non Code License (SNCL) v1.10.0
 */
package cf.ffy00.shop;

import cf.ffy00.shop.datatype.SignShop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;

/**
 *
 * @author FFY00 <FFY00 at ffy00.cf>
 */
public final class ShopAPI {
    
    /*
    * Write binary file from InputStream
    */
    public static boolean writeFile(InputStream in, File file) {
        try {
            try (OutputStream out = new FileOutputStream(file)) {
                byte[] buf = new byte[1024];
                int len;
                while((len=in.read(buf))>0){
                    out.write(buf,0,len);
                }
            }
            in.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /*
    * Checks if the Sign is a Shop Sign
    */
    public static boolean isShop(Sign s){
        return true;
    }
    
    /*
    * Checks if the Sign is a Shop Sign
    */
    public static SignShop getShop(Sign s){
        return new SignShop();
    }
    
    /*
    * Check for an relative sign
    */
    public static boolean hasRelativeSign(Block b){
        if(b.getState() instanceof Sign
                    || b.getRelative(BlockFace.UP).getState() instanceof Sign
                    || b.getRelative(BlockFace.EAST).getState() instanceof Sign
                    || b.getRelative(BlockFace.NORTH).getState() instanceof Sign
                    || b.getRelative(BlockFace.SOUTH).getState() instanceof Sign
                    || b.getRelative(BlockFace.WEST).getState() instanceof Sign){
            return true;
        } else {
            return false;
        }
    }
    
}
