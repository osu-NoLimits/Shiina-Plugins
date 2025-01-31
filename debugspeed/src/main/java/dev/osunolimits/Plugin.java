package dev.osunolimits;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import dev.osunolimits.plugins.PluginConfig;
import dev.osunolimits.plugins.ShiinaPlugin;
import spark.Spark;

/**
 * DebugSpeed v1.0!
 * By NoLimits
 */
public class Plugin extends ShiinaPlugin
{
    public static Logger log = (Logger) LoggerFactory.getLogger(Plugin.class);
    public static PluginConfig config;
    public static Config debugSpeedConfig;

    @Override
    protected void onDisable(String pluginName) {
       
    }

    @Override
    protected void onEnable(String pluginName) {
        config = new PluginConfig(pluginName, Config.class);
        
        config.loadConfig();
        debugSpeedConfig = (Config) config.getConfig();

        if(debugSpeedConfig == null) {
            return;
        }

        if(!debugSpeedConfig.enabled) {
            return;
        }

        log.info("DebugSpeed is watching routes and speed!");

        Spark.before((req, res) -> {
            long start = System.currentTimeMillis();
            req.attribute("start", start);
        });

        Spark.after((req, res) -> {
            long start = req.attribute("start");
            long end = System.currentTimeMillis();
            long time = end - start;
            log.info("Route: " + req.pathInfo() + " took " + time + "ms");
        });

       
    }

}
