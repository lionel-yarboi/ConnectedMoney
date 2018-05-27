package support.utils;

import cucumber.api.Scenario;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;

import java.io.*;

import static support.utils.Logger.logger;


public class HelperMethods {

    public static void embedScreenshot(Scenario scenario, IOSDriver driver) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = driver
                        .getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException wde) {
                System.err.println(wde.getMessage());
            }
        }
    }

    public static void killAppiumProcess() {
        Runtime rt = Runtime.getRuntime();
        try {
            logger.info("Killing Appium processes ...");
            Process node = rt.exec("killall -9 node");
            node.destroyForcibly();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getEnvironment() {
        String environment = System.getProperty("env");
        if( environment == null || environment.isEmpty()) {
            throw new IllegalArgumentException("Please pass a value to JVM property 'env' in the format -Denv=<environment>, where value of environment may be the literal 'ci' or 'qa'");
        }
        return environment;
    }
}
