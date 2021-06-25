package de.czymm.serversigns.asgard.walk;

import de.czymm.serversigns.ServerSignsPlugin;
import de.czymm.serversigns.asgard.utils.LocationUtil;
import de.czymm.serversigns.asgard.utils.SendUtil;
import de.czymm.serversigns.signs.ServerSign;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Locale;

/**
 * de.czymm.serversigns.asgard.walk.WalkHandler
 * ServerSigns
 *
 * @author coldrain
 * @since 2021/6/24
 **/
public class WalkHandler implements Listener {
    public void init(){
        Bukkit.getPluginManager().registerEvents(this,ServerSignsPlugin.INSTANCE);
    }

    @EventHandler
    public void walk(PlayerMoveEvent e){
        if (e.getTo() == null || e.getFrom().getBlock().equals(e.getTo().getBlock())){
            return;
        }
        Location loc = e.getTo().getBlock().getLocation();
        loc.setY(loc.getY()-1.0d);
        ServerSign sign = ServerSignsPlugin.INSTANCE.serverSignsManager
            .getServerSignByLocation(loc);
        if (sign == null) {
            return;
        }
        String locStr = LocationUtil.toString(loc);
        if (WalkConfig.data.getStringList("walk").contains(locStr)){
            // 执行动作
            ServerSignsPlugin.INSTANCE.serverSignExecutor.executeSignFull(e.getPlayer(),sign,null);
        }
    }
}
