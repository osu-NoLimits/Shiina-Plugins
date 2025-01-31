package dev.osunolimits;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import dev.osunolimits.plugins.PluginConfig;
import dev.osunolimits.plugins.ShiinaPlugin;
import dev.osunolimits.routes.get.Beatmap;
import dev.osunolimits.routes.get.Beatmaps;
import dev.osunolimits.routes.get.clans.Clans;

/**
 * Pager v1.0!
 * By NoLimits
 */
public class Plugin extends ShiinaPlugin
{
    public static Logger log = (Logger) LoggerFactory.getLogger(Plugin.class);
    public static PluginConfig config;
    public static Config pagerConfig;

    @Override
    protected void onDisable(String pluginName) {
       
    }

    @Override
    protected void onEnable(String pluginName) {
        config = new PluginConfig(pluginName, Config.class);
        
        config.loadConfig();
        pagerConfig = (Config) config.getConfig();

        if(pagerConfig != null) {
            Beatmaps.pageSize = pagerConfig.beatmapPages;
            Clans.pageListingSize = pagerConfig.clanPages;
            Beatmaps.pageSize = pagerConfig.beatmapPages;
            Beatmap.pageSize = pagerConfig.BeatmapScorePages;
            log.info("Pager config applied to Beatmaps, Clans, Beatmap, and BeatmapScores");
        }
    }

}
