package dev.osunolimits;

import dev.osunolimits.common.MySQL;
import dev.osunolimits.main.App;
import dev.osunolimits.modules.ShiinaRoute.ShiinaRequest;
import dev.osunolimits.routes.get.modular.ShiinaModule;
import redis.clients.jedis.JedisPooled;
import spark.Request;
import spark.Response;

public class ComplexModule extends ShiinaModule {

    @Override
    public String handle(Request req, Response res, ShiinaRequest shiina) {
        // MySQL instance
        MySQL mysql = shiina.mysql;

        // Redis instance
        JedisPooled redis = App.jedisPool;

        shiina.data.put("example", "This could be data that you can use in your template");

        return renderModuleTemplate("plugins/onlmodules/complex.html", shiina);
    }

    @Override
    public String moduleDescription() {
        return "This is a complex module";
    }

    @Override
    public String moduleName() {
        return "ComplexModule";
    }
    
}
