/*
 * Copyright 2016 FFY00
 * 
 * Simple Non Code License (SNCL) v1.10.0
 */

package cf.ffy00.shop;

import cf.ffy00.shop.listeners.BlockBreakListener;
import cf.ffy00.shop.listeners.LeavesDecayListener;
import cf.ffy00.shop.listeners.SignChangeListener;
import cf.ffy00.shop.listeners.PlayerInteractListener;
import com.lenis0012.database.Database;
import com.lenis0012.database.DatabaseConfigBuilder;
import com.lenis0012.database.DatabaseFactory;
import com.lenis0012.database.Table;
import java.io.File;
import java.sql.SQLException;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
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
    private static DatabaseFactory dbf;
    private static Database db;
    
    // Table Vars
    private static Table TABLE_SHOPS;
    private static Table TABLE_CHESTS;

    @Override
    public void onEnable() {
        pl = getDescription();
        Bukkit.getConsoleSender().sendMessage("§bEnabling §cAnubisShop §bv" + pl.getVersion() + " by FFY00!");
        setupConfig();
        setupDatabase();
        
        // Declare Listenerss
        getServer().getPluginManager().registerEvents(new SignChangeListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        getServer().getPluginManager().registerEvents(new LeavesDecayListener(), this);
        
        plugin = this;
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§bDisabling §cAnubisShop §bv" + pl.getVersion() + " by FFY00!");
        db.close();
    }
    
    /*
    * Setup Config
    */
    private void setupConfig(){
        bukkitFolder = getDataFolder();
        pluginsFolder = new File(bukkitFolder, "plugins");
        pluginFolder = new File(pluginsFolder, pl.getName());
        if(!new File (bukkitFolder, "config.yml").exists()){
            saveDefaultConfig();
        }
    }
    
    /*
    * Setup Database
    */
    private void setupDatabase(){
        dbf = new DatabaseFactory(plugin);
        dbFile = new File(pluginFolder, "data.db");
        ConfigurationSection section = getConfig().getConfigurationSection("MySQL");
        DatabaseConfigBuilder config = new DatabaseConfigBuilder(section, dbFile);
        db = dbf.getDatabase(config);
        try {
            db.connect();
        } catch (SQLException ex) {
            Bukkit.getConsoleSender().sendMessage("§bError conecting with the database! Disabling....");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }
    
    /*
    * Setup the Database Tables
    */
    private void setupDatabaseTables(){
        TABLE_SHOPS = new Table("shops", "id INT NOT NULL AUTO_INCREMENT, name VARCHAR(16), PRIMARY KEY(id)");
        TABLE_CHESTS = new Table("chests", "id INT NOT NULL, "
                + "slot1 VARCHAR(24), "
                + "slot2 VARCHAR(24), "
                + "slot3 VARCHAR(24), "
                + "slot4 VARCHAR(24), "
                + "slot5 VARCHAR(24), "
                + "slot6 VARCHAR(24), "
                + "slot7 VARCHAR(24), "
                + "slot8 VARCHAR(24), "
                + "slot9 VARCHAR(24), "
                + "slot10 VARCHAR(24), "
                + "slot11 VARCHAR(24), "
                + "slot12 VARCHAR(24), "
                + "slot13 VARCHAR(24), "
                + "slot14 VARCHAR(24), "
                + "slot15 VARCHAR(24), "
                + "slot16 VARCHAR(24), "
                + "slot17 VARCHAR(24), "
                + "slot18 VARCHAR(24), "
                + "slot19 VARCHAR(24), "
                + "slot20 VARCHAR(24), "
                + "slot21 VARCHAR(24), "
                + "slot22 VARCHAR(24), "
                + "slot23 VARCHAR(24), "
                + "slot24 VARCHAR(24), "
                + "slot25 VARCHAR(24), "
                + "slot26 VARCHAR(24), "
                + "slot27 VARCHAR(24), "
                + "slot28 VARCHAR(24), "
                + "slot29 VARCHAR(24), "
                + "slot30 VARCHAR(24), "
                + "slot31 VARCHAR(24), "
                + "slot32 VARCHAR(24), "
                + "slot33 VARCHAR(24), "
                + "slot34 VARCHAR(24), "
                + "slot35 VARCHAR(24), "
                + "slot36 VARCHAR(24), "
                + "slot37 VARCHAR(24), "
                + "slot38 VARCHAR(24), "
                + "slot39 VARCHAR(24), "
                + "slot40 VARCHAR(24), "
                + "slot41 VARCHAR(24), "
                + "slot42 VARCHAR(24), "
                + "slot43 VARCHAR(24), "
                + "slot44 VARCHAR(24), "
                + "slot45 VARCHAR(24), "
                + "slot46 VARCHAR(24), "
                + "slot47 VARCHAR(24), "
                + "slot48 VARCHAR(24), "
                + "slot49 VARCHAR(24), "
                + "slot50 VARCHAR(24), "
                + "slot51 VARCHAR(24), "
                + "slot52 VARCHAR(24), "
                + "slot53 VARCHAR(24), "
                + "slot54 VARCHAR(24), "
                + "PRIMARY KEY(id)");
    }
    
    /*
    * Return DatabaseFactory
    */
    public static Database getDb(){
        return db;
    }
}