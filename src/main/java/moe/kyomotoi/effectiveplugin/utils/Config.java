package moe.kyomotoi.effectiveplugin.utils;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Config extends JavaPlugin {

    public static BukkitLog log;
    File file = new File(getDataFolder(), "config.yml");

    public YamlConfiguration readConfig()  {
        return YamlConfiguration.loadConfiguration(file);
    }
}
