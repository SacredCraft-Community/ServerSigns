package de.czymm.serversigns.asgard.command.impl;

import de.czymm.serversigns.asgard.command.SubCommand;
import de.czymm.serversigns.asgard.utils.LocationUtil;
import de.czymm.serversigns.asgard.utils.SendUtil;
import de.czymm.serversigns.asgard.walk.WalkConfig;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

/**
 * de.czymm.serversigns.asgard.command.impl.SubCommandREMOVE
 * ServerSigns
 *
 * @author coldrain
 * @since 2021/6/24
 **/
public class SubCommandREMOVE implements SubCommand {
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
                SendUtil.warn(sender,"该方块本来就不为walk类型");
                return;
            }
            if (WalkConfig.data.getStringList("walk").contains(str)){
                List<String> list = WalkConfig.data.getStringList("walk");
                list.remove(str);
                WalkConfig.data.set("walk", list);
                SendUtil.tell(sender,"删除成功");
                return;
            }
            SendUtil.warn(sender,"该方块本来就不为walk类型");
        }
    }
}
