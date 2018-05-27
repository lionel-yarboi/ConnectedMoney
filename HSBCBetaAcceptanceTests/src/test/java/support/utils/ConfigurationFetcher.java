package support.utils;

import java.util.Properties;

/**
 * Created by 44029273 on 10/03/2017.
 */
public class ConfigurationFetcher {

    public static Config fetch() {
        Properties properties = System.getProperties();
        String mongoUrl = (String) properties.get("mongoUrl");
        String mongoDbName = (String) properties.get("mongoDbName");

        return new Config(mongoUrl, mongoDbName);
    }
}
