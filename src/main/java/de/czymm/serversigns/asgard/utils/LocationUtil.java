package de.czymm.serversigns.asgard.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.Collections;

/**
 * de.czymm.serversigns.asgard.utils.LocationUtil
 * ServerSigns
 *
 * @author coldrain
 * @since 2021/6/24
 **/
public class LocationUtil {
    public static String toString(Location loc){
        return loc.getWorld().getName()+","+loc.getBlockX()+","+loc.getBlockY()+","+loc.getBlockZ();
    }
    public static Block getTargetBlockExact(Player player){
        return player.getTargetBlock(Collections.singleton(Material.AIR),10);
    }
}
