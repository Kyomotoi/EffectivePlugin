package moe.kyomotoi.effectiveplugin.event;

import moe.kyomotoi.effectiveplugin.Utils;
import moe.kyomotoi.effectiveplugin.socket.WebsocketServer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.plugin.Plugin;
import org.java_websocket.server.WebSocketServer;

public class Player implements Listener {

    private final WebSocketServer s = WebsocketServer.main();
    Plugin plugin = moe.kyomotoi.effectiveplugin.EffectivePlugin.getPlugin(moe.kyomotoi.effectiveplugin.EffectivePlugin.class);
    String isFormant = plugin.getConfig().getString("Websocket.post-format");

    @EventHandler
    public void PlayerChat(AsyncPlayerChatEvent event) {
//        "From server player " + event.getPlayer().getName() + " message: " + event.getMessage()
//        if ("string".equals(isFormant)) {
//            s.broadcast("");
//        } else {
//            s.broadcast(Utils.StringToByte(""));
//        }
    }

    @EventHandler
    public void PlayerAdvancementDone(PlayerAdvancementDoneEvent event) {}

    @EventHandler
    public void PlayerArmorStandManipulate(PlayerArmorStandManipulateEvent event) {}

    @EventHandler
    public void PlayerBedEnter(PlayerBedEnterEvent event) {}

    @EventHandler
    public void PlayerBedLeave(PlayerBedLeaveEvent event) {}

    @EventHandler
    public void PlayerBucketEmpty(PlayerBucketEmptyEvent event) {}

    @EventHandler
    public void PlayerBucketEntity(PlayerBucketEntityEvent event) {}

    @EventHandler
    public void PlayerBucket(PlayerBucketEvent event) {}

    @EventHandler
    public void PlayerChangedWorld(PlayerChangedWorldEvent event) {}

    @EventHandler
    public void PlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {}

    @EventHandler
    public void PlayerCommandSend(PlayerCommandSendEvent event) {}

    @EventHandler
    public void PlayerDropItem(PlayerDropItemEvent event) {}

    @EventHandler
    public void PlayerEditBook(PlayerEditBookEvent event) {}

    @EventHandler
    public void PlayerEggThrow(PlayerEggThrowEvent event) {}

    @EventHandler
    public void PlayerExpChange(PlayerExpChangeEvent event) {}

    @EventHandler
    public void PlayerFish(PlayerFishEvent event) {}

    @EventHandler
    public void PlayerGameModeChange(PlayerGameModeChangeEvent event) {}

    @EventHandler
    public void PlayerHarvestBlock(PlayerHarvestBlockEvent event) {}
}
