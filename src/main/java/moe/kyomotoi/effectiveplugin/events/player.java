package moe.kyomotoi.effectiveplugin.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

class EventPlayer implements Listener {

    @EventHandler
    public void PlayerSendMessage(AsyncPlayerChatEvent event) {
    }

    @EventHandler
    public void PlayerLoginServer(AsyncPlayerPreLoginEvent event) {
    }

    @EventHandler
    public void PlayerAdvancementDone(PlayerAdvancementDoneEvent event) {
    }

    @EventHandler
    public void PlayerAnimation(PlayerAnimationEvent event) {
    }

    @EventHandler
    public void PlayerJoinServer(PlayerJoinEvent event) {
    }
}
