package me.enderlight3336.enderpatch;

import me.enderlight3336.enderpatch.command.CommandRegister;
import me.enderlight3336.enderpatch.command.MainCommand;
import me.enderlight3336.enderpatch.listener.PlayerCommandListener;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.InputStreamReader;

public final class EnderPatch extends JavaPlugin {
    private static EnderPatch instance;
    private static String version;

    public void onEnable() {
        instance = this;
        version = YamlConfiguration.loadConfiguration(new InputStreamReader(this.getResource("plugin.yml"))).getString("version");
        File folder = new File(String.valueOf(this.getDataFolder()));
        folder.mkdir();
        this.getConfig().options().copyDefaults();
        this.saveDefaultConfig();
        if (this.getConfig().getBoolean("command_to_lowercase.enable")) {
            this.getServer().getPluginManager().registerEvents(new PlayerCommandListener(), instance);
        }

        CommandRegister.registerCommand(instance, new MainCommand(), (String)null, new String[]{"enderpatch"});
    }

    public void onDisable() {
        HandlerList.unregisterAll();
        instance = null;
    }

    public static EnderPatch getInstance() {
        return instance;
    }

    public static String getVersion() {
        return version;
    }
}
