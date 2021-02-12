package moe.kyomotoi.effectiveplugin.socket;

import moe.kyomotoi.effectiveplugin.utils.BukkitLog;
import moe.kyomotoi.effectiveplugin.utils.Config;
import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Collections;

class Client extends WebSocketServer {

    public static BukkitLog log;
    public static Config config;

    public Client(int port) throws UnknownHostException {
        super(new InetSocketAddress(port));
    }

    public Client(InetSocketAddress address) {
        super(address);
    }

    public Client(int port, Draft_6455 draft) {
        super(new InetSocketAddress(port), Collections.<Draft>singletonList(draft));
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        conn.send("[EffectivePlugin] EffectivePlugin successfully opended!");
        log.info("[EffectivePlugin] EffectivePlugin successfully opended!");
        log.info("[EffectivePlugin] New connection: " + handshake.getResourceDescriptor());
        log.info("[EffectivePlugin] " + conn.getRemoteSocketAddress().getAddress().getHostAddress() + "successfully connected!");
    }

    @Override
    public void onClose(WebSocket conn, int code, String resaon, boolean remote) {
        log.warning("§c[EffectivePlugin] " + conn + "has been disconnected.");
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        log.info("[EffectivePlugin] " + message);
    }

    @Override
    public void onMessage(WebSocket conn, ByteBuffer message) {
        log.info("[EffectivePlugin] " + message.array());
    }

    public static void socketConnect(String[] args) throws InterruptedException, IOException {
        int port = config.readConfig().getInt("ws_config.port");
        try {
            port = Integer.parseInt(args[0]);
        } catch (Exception e) {
        }
        Client s = new Client(port);
        s.start();
        log.info("[EffectivePlugin] Started on port: " + s.getPort());

        BufferedReader sysin = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String in = sysin.readLine();
            log.info("[EffectivePlugin] " + in);
            // 此处判断是否继续，否则跳过，
        }
    }

    @Override
    public void onError(WebSocket conn, Exception e) {
        e.printStackTrace();
    }

    @Override
    public void onStart() {
        log.info("[EffectivePlugin] Started!");
        setConnectionLostTimeout(0);
        setConnectionLostTimeout(100);
    }

//    public void Send(WebSocket conn, String text) {
//        conn.send(text);
//    }
}
