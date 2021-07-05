package moe.kyomotoi.effectiveplugin;

import moe.kyomotoi.effectiveplugin.socket.WebsocketServer;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.net.InetSocketAddress;

public final class EffectivePlugin extends JavaPlugin implements Listener {

    public WebsocketServer s;

    @Override
    public void onEnable() {
        getLogger().info("EffectivePlugin is running.");
        getLogger().info("Project: https://github.com/Kyomotoi/EffectivePlugin");

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
        try {
            s = new WebsocketServer(new InetSocketAddress(getConfig().getString("WebSocket.host"), getConfig().getInt("WebSocket.port")));
            s.start();
            getLogger().info("Started on: " + s.getAddress() + ":" + s.getPort());
        } catch (Exception err) {
            getLogger().warning("Running websocket failed, track:");
            err.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("Thanks for using!");
    }
}
