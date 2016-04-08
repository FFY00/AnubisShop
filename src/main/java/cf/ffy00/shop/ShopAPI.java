/*
 * Copyright 2016 FFY00
 * 
 * Simple Non Code License (SNCL) v1.10.0
 */
package cf.ffy00.shop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.bukkit.block.Sign;

/**
 *
 * @author FFY00 <FFY00 at ffy00.cf>
 */
public class ShopAPI {
    
    /*
    * Write binary file from InputStream
    */
    public boolean writeFile(InputStream in, File file) {
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
    public boolean isShop(Sign s){
        return false;
    }
    
}
