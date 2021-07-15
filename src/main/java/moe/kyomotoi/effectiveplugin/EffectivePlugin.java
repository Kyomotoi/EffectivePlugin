package moe.kyomotoi.effectiveplugin;

import moe.kyomotoi.effectiveplugin.event.Player;
import moe.kyomotoi.effectiveplugin.socket.WebsocketServer;
import org.bukkit.plugin.java.JavaPlugin;
import org.java_websocket.server.WebSocketServer;

public final class EffectivePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("EffectivePlugin is running.");
        getLogger().info("Project: https://github.com/Kyomotoi/EffectivePlugin");

        getServer().getPluginManager().registerEvents(new Player(), this);

        getLogger().info("Load config...");
        try {
            getConfig().options().copyDefaults();
        } catch (Exception err) {
            getLogger().warning("Try to write default config failed, track:");
            err.printStackTrace();
        }
        saveDefaultConfig();
        getLogger().info("Load config success!");

        getLogger().info("Start running Websocket...");
        WebSocketServer s = WebsocketServer.main();
        s.start();
        getLogger().info("Started on: " + s.getAddress() + ":" + s.getPort());
        }

    @Override
    public void onDisable() {
        getLogger().info("Thanks for using!");
    }
}
