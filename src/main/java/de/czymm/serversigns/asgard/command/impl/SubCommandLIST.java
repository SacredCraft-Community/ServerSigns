package de.czymm.serversigns.asgard.command.impl;

import de.czymm.serversigns.asgard.command.SubCommand;
import de.czymm.serversigns.asgard.utils.SendUtil;
import de.czymm.serversigns.asgard.walk.WalkConfig;
import org.bukkit.command.CommandSender;

/**
 * de.czymm.serversigns.asgard.command.impl.SubCommandLIST
 * ServerSigns
 *
 * @author coldrain
 * @since 2021/6/24
 **/
public class SubCommandLIST implements SubCommand {
    @Override
    public void execute(CommandSender sender, String[] args) {
        SendUtil.tell(sender, "已经标记的walk方块:");
        WalkConfig.data.getStringList("walk").forEach(
            s -> {
                SendUtil.tell(sender,s);
            }
        );
    }
}
