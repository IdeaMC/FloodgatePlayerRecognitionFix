package fun.xiantiao.floodgateplayerrecognitionfix;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.geysermc.floodgate.api.FloodgateApi;
import org.geysermc.geyser.api.GeyserApi;

/**
 * @author xiantiao
 */
public final class FloodgatePlayerRecognitionFix extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        //释放文件
        saveDefaultConfig();
        reloadConfig();

        // 注册事件
        getServer().getPluginManager().registerEvents(this,this);

        new Metrics(this,21477);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (
                !FloodgateApi.getInstance().isFloodgatePlayer(event.getPlayer().getUniqueId()) // 不是Floodgate玩家
             && GeyserApi.api().isBedrockPlayer(event.getPlayer().getUniqueId())               // 是Geyser玩家
            ) {
                //拒绝进入
                String kickMsg = getConfig().getString("msg","哎呀！ 出现了点问题 请重新进入！");
                event.getPlayer().kickPlayer(kickMsg);
            }
    }
}
