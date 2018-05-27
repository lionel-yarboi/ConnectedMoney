package support;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Yarboi on 09/01/2017.
 */
public class LoadProperties {

    private static final Properties props = new Properties();

    static void loadPropertiesFile(String propertiesFile) {
        try{
            InputStream inputStream =
                    LoadProperties.class.getClassLoader().getResourceAsStream(propertiesFile);
            props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProp(String prop) {
        return props.getProperty(prop);
    }
}
