package step_definitions;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import pageobjects.MinimumAppVersionPage;
import support.DriverFactory;
import support.WaitHelper;
import support.database.MinimumAppVersionDAO;

import static org.junit.Assert.assertTrue;

@CucumberStep
public class MinimumAppVersionStep {

    @Autowired
    private MinimumAppVersionDAO minimumAppVersionDAO;

    @Autowired
    private MinimumAppVersionPage minimumAppVersionPage;

    @Autowired
    private WaitHelper waitHelper;

    @Autowired
    private DriverFactory driverFactory;

    @Given("^A new app version \"([^\"]*)\" is available$")
    public void aNewAppVersionIsAvailable(String appVersion) throws Throwable {
        minimumAppVersionDAO.updateMinimumAppVersion(appVersion);
    }

    @Then("^I should see alert for new app version$")
    public void iShouldSeeAlertForNewAppVersion() throws Throwable {
        waitHelper.waitUntilDisplayed(minimumAppVersionPage.getUpdateYourAppAlert());
        assertTrue(minimumAppVersionPage.getUpdateYourAppAlert().isDisplayed());
    }

}
