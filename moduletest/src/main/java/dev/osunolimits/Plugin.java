package dev.osunolimits;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import dev.osunolimits.plugins.PluginConfig;
import dev.osunolimits.plugins.ShiinaPlugin;
import dev.osunolimits.routes.get.modular.ModuleRegister;
import dev.osunolimits.routes.get.modular.ShiinaModule;

/**
 * ModuleTest v1.0!
 * By NoLimits
 */
public class Plugin extends ShiinaPlugin
{
    public static Logger log = (Logger) LoggerFactory.getLogger(Plugin.class);
    public static PluginConfig config;

    @Override
    protected void onDisable(String pluginName) {
       
    }

    @Override
    protected void onEnable(String pluginName) {
        ModuleRegister.registerModule("home", ShiinaModule.fromRawHtml("SimeRawHtmlModule", "infos", "plugins/onlmodules/test.html"));
    }

}
