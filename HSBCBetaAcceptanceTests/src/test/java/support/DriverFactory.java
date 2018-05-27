package support;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;

import static support.utils.HelperMethods.killAppiumProcess;
import static support.utils.Logger.logger;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class DriverFactory {

    private final DesiredCapabilities capabilities;

    private IOSDriver driver;

    public DriverFactory(DesiredCapabilities capabilities) {
        this.capabilities = capabilities;
    }

    private void setupDriver() {
        if (driver == null) {
            try {
                killPort();
                killAppiumProcess();
                driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    public IOSDriver getDriver() {
        setupDriver();
        return driver;
    }

    void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            logger.info("Driver quit");
        }
    }

    private void killPort() {
        Runtime rt = Runtime.getRuntime();
        try {
            logger.info("Killing default port 4723 ...");
            Process node = rt.exec("lsof -n -i4TCP:4723");
            node.destroyForcibly();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
