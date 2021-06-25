package de.czymm.serversigns.asgard.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

/**
 * de.czymm.serversigns.asgard.utils.SendUtil
 * ServerSigns
 *
 * @author coldrain
 * @since 2021/6/24
 **/
public class SendUtil {
    public static void tell(CommandSender sender,String msg){
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7&l[&f&lAsgard&7&l] &7" + msg));
    }
    public static void warn(CommandSender sender,String msg){
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&c&l[&4&lAsgard&c&l] &c" + msg));
    }
}
