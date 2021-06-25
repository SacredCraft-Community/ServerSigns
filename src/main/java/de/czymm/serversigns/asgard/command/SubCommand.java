package de.czymm.serversigns.asgard.command;

import org.bukkit.command.CommandSender;

/**
 * de.czymm.serversigns.asgard.command.SubCommand
 * ServerSigns
 *
 * @author coldrain
 * @since 2021/6/24
 **/
public interface SubCommand {
    void execute(CommandSender sender, String[] args);
}
