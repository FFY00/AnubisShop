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
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
/**
 *
 * @author FFY00 <FFY00 at ffy00.cf>
 */
public class ShopPlugin extends JavaPlugin {
    
    public static ShopPlugin plugin;
    private static PluginDescriptionFile pl;
    private static File bukkitFolder;
    private static File pluginFolder;
    
    private final File dataFolder = new File(pluginFolder, "data");

    @Override
    public void onEnable() {
        pl = getDescription();
        Bukkit.getConsoleSender().sendMessage("§bEnabling " + pl.getName() + " v" + pl.getVersion() + " by FFY00!");
        setupConfig();
        plugin = this;
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§bDisabling " + pl.getName() + " v" + pl.getVersion() + " by FFY00!");
    }
    
    /*
    * Setup Config
    */
    private void setupConfig(){
        bukkitFolder = getDataFolder();
        pluginFolder = new File(bukkitFolder, pl.getName());
        if(!new File (bukkitFolder, "config.yml").exists()){
            saveDefaultConfig();
        }
    }
    
    /*
    * Write binary file from InputStream
    */
    private void writeFile(InputStream in, File file) {
        try {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while((len=in.read(buf))>0){
                out.write(buf,0,len);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public File getPlayerDataFolder(){
        return dataFolder;
    }
    
}