package de.czymm.serversigns.asgard.command.impl;

import de.czymm.serversigns.asgard.command.SubCommand;
import de.czymm.serversigns.asgard.utils.LocationUtil;
import de.czymm.serversigns.asgard.utils.SendUtil;
import de.czymm.serversigns.asgard.walk.WalkConfig;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.*;

/**
 * de.czymm.serversigns.asgard.command.impl.SubCommandADD
 * ServerSigns
 *
 * @author coldrain
 * @since 2021/6/24
 **/
public class SubCommandADD implements SubCommand {
    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)){
            SendUtil.warn(sender,"该命令只有玩家可以使用");
            return;
        }
        Block block = LocationUtil.getTargetBlockExact((Player) sender);
        if (block != null){
            if (block.getType() == Material.AIR){
                SendUtil.warn(sender,"你不能右键空气");
                return;
            }
            String str = LocationUtil.toString(block.getLocation());
            if (WalkConfig.data.getStringList("walk") == null){
                WalkConfig.data.set("walk", Collections.singletonList(str));
                WalkConfig.update();
                SendUtil.tell(sender,"设置完毕!");
                return;
            }
            if (WalkConfig.data.getStringList("walk").contains(str)){
                SendUtil.warn(sender,"该方块已经为walk类型");
                return;
            }
            List<String> list = WalkConfig.data.getStringList("walk");
            list.add(str);
            WalkConfig.data.set("walk", list);
            WalkConfig.update();
            SendUtil.tell(sender,"设置完毕!");
        }
    }
}
