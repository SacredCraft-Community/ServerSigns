package de.czymm.serversigns.asgard.walk;

import de.czymm.serversigns.ServerSignsPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * de.czymm.serversigns.asgard.walk.WalkConfig
 * ServerSigns
 * 因为没有TConfig就只能写这么个类
 *
 * @author coldrain
 * @since 2021/6/24
 **/
public class WalkConfig {
    private static File file = new File(ServerSignsPlugin.INSTANCE.getDataFolder(),"walkdata.yml");

    public static void init(){
        if(!file.exists()){
            ServerSignsPlugin.INSTANCE.saveResource("walkdata.yml",false);
        }
        data = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration data = null;

    // 将缓存中的config保存到文件中
    public static void update() {
        try {
            data.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reload(){
        init();
    }
}
