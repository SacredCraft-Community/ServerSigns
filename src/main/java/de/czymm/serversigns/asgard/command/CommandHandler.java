package de.czymm.serversigns.asgard.command;

import de.czymm.serversigns.asgard.utils.LocationUtil;
import de.czymm.serversigns.asgard.utils.SendUtil;
import de.czymm.serversigns.asgard.walk.WalkConfig;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

/**
 * de.czymm.serversigns.asgard.command.CommandHandler
 * ServerSigns
 *
 * @author coldrain
 * @since 2021/6/24
 **/
public class CommandHandler implements CommandExecutor {
    public void init(){
        Bukkit.getPluginCommand("svsmode").setExecutor(this);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            SendUtil.warn(sender,"该命令只有玩家可以使用");
            return true;
        }
        Block block = LocationUtil.getTargetBlockExact((Player) sender);
        if (block != null){
            if (block.getType() == Material.AIR){
                SendUtil.warn(sender,"你不能右键空气");
                return true;
            }
            String str = LocationUtil.toString(block.getLocation());
            if (WalkConfig.data.getStringList("walk") == null){
                WalkConfig.data.set("walk", Collections.singletonList(str));
                WalkConfig.update();
                SendUtil.tell(sender,"切换ServerSigns方块类型: &f踩踏");
                return true;
            }
            if (WalkConfig.data.getStringList("walk").contains(str)){
                List<String> list = WalkConfig.data.getStringList("walk");
                list.remove(str);
                WalkConfig.data.set("walk", list);
                SendUtil.tell(sender,"切换ServerSigns方块类型: &f交互");
                return true;
            }
            List<String> list = WalkConfig.data.getStringList("walk");
            list.add(str);
            WalkConfig.data.set("walk", list);
            WalkConfig.update();
            SendUtil.tell(sender,"切换ServerSigns方块类型: &f踩踏");
        }
        return true;
    }
}
