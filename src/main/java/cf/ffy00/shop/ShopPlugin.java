/*
 * Copyright 2016 FFY00
 * 
 * Simple Non Code License (SNCL) v1.10.0
 */

package cf.ffy00.shop;

import cf.ffy00.shop.listeners.SignChangeListener;
import cf.ffy00.shop.listeners.PlayerInteractListener;
import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author FFY00 <FFY00 at ffy00.cf>
 */
public final class ShopPlugin extends JavaPlugin {
    
    public static ShopPlugin plugin;
    private static PluginDescriptionFile pl;
    private static File bukkitFolder;
    private static File pluginsFolder;
    private static File pluginFolder;
    private static File dbFile;
    private static final ShopAPI api = new ShopAPI();

    @Override
    public void onEnable() {
        plugin = this;
        pl = getDescription();
        Bukkit.getConsoleSender().sendMessage("§bEnabling §cAnubisShop §bv" + pl.getVersion() + " by FFY00!");
        setupConfig();
        
        // Declare Listenerss
        getServer().getPluginManager().registerEvents(new SignChangeListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§bDisabling §cAnubisShop §bv" + pl.getVersion() + " by FFY00!");
    }
    
    /*
    * Setup Config
    */
    private void setupConfig(){
        bukkitFolder = getDataFolder();
        pluginsFolder = new File(bukkitFolder, "plugins");
        pluginFolder = new File(pluginsFolder, pl.getName());
        dbFile = new File(pluginFolder, "data");
        if(!new File (bukkitFolder, "config.yml").exists()){
            saveDefaultConfig();
        }
        if(!dbFile.exists()){
            api.writeFile(getResource(""), dbFile);
        }
    }
    
}