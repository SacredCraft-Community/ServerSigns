package de.czymm.serversigns.asgard.command;

import de.czymm.serversigns.asgard.command.impl.SubCommandADD;
import de.czymm.serversigns.asgard.command.impl.SubCommandLIST;
import de.czymm.serversigns.asgard.command.impl.SubCommandREMOVE;
import de.czymm.serversigns.asgard.utils.SendUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Locale;

/**
 * de.czymm.serversigns.asgard.command.CommandHandler
 * ServerSigns
 *
 * @author coldrain
 * @since 2021/6/24
 **/
public class CommandHandler implements CommandExecutor {
    public void init(){
        Bukkit.getPluginCommand("serversignsasgard").setExecutor(this);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            SendUtil.tell(sender, "&f/svsa add &8- &7将指向的方块设置为walk类型");
            SendUtil.tell(sender, "&f/svsa remove &8- &7将指向的方块从walk类型方块list中删除");
            SendUtil.tell(sender, "&f/svsa list &8- &7列出所有walk类型的方块");
            return true;
        }
        executeSubCommand(sender, args);
        return true;
    }

    private void executeSubCommand(CommandSender sender,String[] args){
        switch (args[0].toUpperCase()){
            case "ADD": {
                new SubCommandADD().execute(sender, args);
                return;
            }
            case "REMOVE":{
                new SubCommandREMOVE().execute(sender, args);
                return;
            }
            case "LIST":{
                new SubCommandLIST().execute(sender, args);
                return;
            }
            default:{
                SendUtil.warn(sender,"参数错误");
            }
        }
    }
}
