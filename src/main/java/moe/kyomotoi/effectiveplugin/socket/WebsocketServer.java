package moe.kyomotoi.effectiveplugin.socket;

import org.bukkit.plugin.Plugin;
import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;

public class WebsocketServer extends WebSocketServer {

    static Plugin plugin = moe.kyomotoi.effectiveplugin.EffectivePlugin.getPlugin(moe.kyomotoi.effectiveplugin.EffectivePlugin.class);
    public static WebsocketServer s = new WebsocketServer(new InetSocketAddress(plugin.getConfig().getString("WebSocket.host"), plugin.getConfig().getInt("WebSocket.port")));

    public WebsocketServer(int port) throws UnknownHostException {
        super(new InetSocketAddress(port));
    }

    public WebsocketServer(InetSocketAddress address) {
        super(address);
    }

    public WebsocketServer(int port, Draft_6455 draft) {
        super(new InetSocketAddress(port), Collections.<Draft>singletonList(draft));
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        conn.send("EffectivePlugin start!");
        broadcast("[EffectivePlugin] New connection: " + handshake.getResourceDescriptor());
        plugin.getLogger().info("New connection: " + conn.getRemoteSocketAddress());
        conn.send("Start work...");
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        plugin.getLogger().warning(conn + "is lost.");
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        conn.send(message);
    }

    public static WebsocketServer main() {
        return s;
    }

    @Override
    public void onError(WebSocket conn, Exception err) {
        err.printStackTrace();
    }

    @Override
    public void onStart() {
        plugin.getLogger().info("Started!");
        setConnectionLostTimeout(plugin.getConfig().getInt("Websocket.timeout"));
    }

    public void PostMessage(String content) {}

    public void PostMessage(Arrays content) {}
}
