package me.enderlight3336.enderpatch.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerCommandListener implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        if (!event.isCancelled()) {
            String s = event.getMessage();
            String s1;
            if (s.indexOf(" ", 1) == -1) {
                s1 = s.toLowerCase();
            } else {
                s1 = s.substring(0, s.indexOf(" ", 1)).toLowerCase() + s.substring(s.indexOf(" ", 1));
            }

            event.setMessage(s1);
        }
    }
}
