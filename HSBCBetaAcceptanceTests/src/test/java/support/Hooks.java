package support;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.ios.IOSDriver;
import org.springframework.beans.factory.annotation.Autowired;
import support.database.MinimumAppVersionDAO;

import javax.inject.Singleton;

import static support.LoadProperties.loadPropertiesFile;
import static support.utils.HelperMethods.*;

public class Hooks {

    @Autowired
    private AppiumSetup appiumSetup;

    @Autowired
    private DriverFactory driver;

    @Autowired
    private MinimumAppVersionDAO minimumAppVersionDAO;

    @Before()
    public void setup() {
        loadPropertiesFile("application-".concat(getEnvironment()).concat(".properties"));
    }

    @After("@miniappversion")
    public void minimumAppTearDown(){
        minimumAppVersionDAO.updateMinimumAppVersion("1.0");
    }

    @After
    public void tearDown(Scenario scenario) {
        embedScreenshot(scenario,driver.getDriver());
    }
}
