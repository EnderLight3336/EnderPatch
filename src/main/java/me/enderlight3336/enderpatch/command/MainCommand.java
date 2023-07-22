package me.enderlight3336.enderpatch.command;

import me.enderlight3336.enderpatch.EnderPatch;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.ArrayList;
import java.util.List;

public class MainCommand implements TabExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length >= 1) {
            if (strings[0].equalsIgnoreCase("version")) {
                commandSender.sendMessage(ChatColor.DARK_PURPLE + "插件版本是: " + EnderPatch.getVersion());
            } else {
                commandSender.sendMessage(ChatColor.DARK_PURPLE + "EnderPatch命令列表");
                commandSender.sendMessage("/enderpatch version");
            }
        } else {
            commandSender.sendMessage(ChatColor.DARK_PURPLE + "EnderPatch命令列表");
            commandSender.sendMessage("/enderpatch version");
        }

        return true;
    }

    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        List<String> value = new ArrayList();
        if (strings.length == 1) {
            value.add("version");
            return value;
        } else {
            return null;
        }
    }
}
