package moe.kyomotoi.effectiveplugin;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class EffectivePlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("EffectivePlugin has been enable.");
        getLogger().info("Project: https://github.com/Kyomotoi/EffectivePlugin");
        getLogger().info("开始加载配置...");
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        getLogger().info("Thanks for using!");
    }

    public FileConfiguration load(File file) {
        if (!(file.exists())) {
            try {
                file.createNewFile();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        return YamlConfiguration.loadConfiguration(file);
    }

    public void LoadConfig() {
        File file = new File(getDataFolder(), "config.yml");

        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }

        if (!file.exists()) {
            this.saveDefaultConfig();
        }

        this.reloadConfig();

        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("插件配置加载完毕");
    }
}
