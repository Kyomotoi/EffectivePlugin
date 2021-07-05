package moe.kyomotoi.effectiveplugin.socket;

import org.bukkit.plugin.Plugin;
import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Collections;

public class WebsocketServer extends WebSocketServer {

    Plugin plugin = moe.kyomotoi.effectiveplugin.EffectivePlugin.getPlugin(moe.kyomotoi.effectiveplugin.EffectivePlugin.class);

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
        broadcast("[EffectivePlugin] " + conn + "is lost.");
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        broadcast(message);
        System.out.println(conn + ": " + message);
        conn.send("testing");
    }

    @Override
    public void onMessage(WebSocket conn, ByteBuffer message) {
        broadcast(message.array());
        System.out.println(conn + ": " + message);
    }

//    public static void main(String[] args) throws InterruptedException, IOException {
//        int port = 123;
//        WebsocketServer s = new WebsocketServer(port);
//        s.start();
//        log.info("[EffectivePlugin] Started on: " + s.getAddress() + ":" + s.getPort());
//    }

    @Override
    public void onError(WebSocket conn, Exception err) {
        err.printStackTrace();
    }

    @Override
    public void onStart() {
        plugin.getLogger().info("Started!");
        setConnectionLostTimeout(5);
    }
}