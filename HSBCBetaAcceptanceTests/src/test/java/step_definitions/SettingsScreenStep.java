package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.ios.IOSDriver;
import org.springframework.beans.factory.annotation.Autowired;
import pageobjects.SettingsScreenPage;
import support.DriverFactory;
import support.WaitHelper;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

@CucumberStep
public class SettingsScreenStep {

    @Autowired
    private SettingsScreenPage settingsScreenPage;

    @Autowired
    private WaitHelper waitHelper;

    @Autowired
    private DriverFactory driver;

    @Given("^I am on settings screen$")
    public void iAmOnSettingsScreen() throws Throwable {
        waitHelper.waitUntilDisplayed(settingsScreenPage.getVersion());
    }

    @And("^I should see help$")
    public void iShouldSeeHelp() throws Throwable {
        assertTrue(settingsScreenPage.getHelp().isDisplayed());
    }

    @And("^I should see contact us$")
    public void iShouldSeeContactUs() throws Throwable {
        assertTrue(settingsScreenPage.getContactUs().isDisplayed());
    }

    @And("^I should see version$")
    public void iShouldSeeVersion() throws Throwable {
        assertTrue(settingsScreenPage.getVersion().isDisplayed());
    }

    @And("^I should see delete profile$")
    public void iShouldSeeDeleteProfile() throws Throwable {
        assertTrue(settingsScreenPage.getDeleteProfile().isDisplayed());
    }

    @And("^I should see close button$")
    public void iShouldSeeCloseButton() throws Throwable {
        assertTrue(settingsScreenPage.getCloseButton().isDisplayed());
    }

    @When("^I tap close button$")
    public void iTapCloseButton() throws Throwable {
        settingsScreenPage.getCloseButton().click();
    }

    @When("^I tap log off button$")
    public void iTapLogOffButton() throws Throwable {
        settingsScreenPage.getLogOut().click();
        settingsScreenPage.getLogOutActionSheetButton().click();
    }

    @When("^I tap contact us$")
    public void iTapContactUs() throws Throwable {
        settingsScreenPage.getContactUs().click();
    }

    @Then("^I should see contact us action sheet with Email and telephone options$")
    public void iShouldSeeContactUsActionSheetWithEmailAndTelephoneOptions() throws Throwable {
        assertTrue(settingsScreenPage.getEmailButton().isDisplayed());
        assertTrue(settingsScreenPage.getTelephoneButton().isDisplayed());
    }

    @And("^I tap telephone$")
    public void iTapTelephone() throws Throwable {
        settingsScreenPage.getTelephoneButton().click();
    }

    @Then("^I should see support team number \"([^\"]*)\" displayed$")
    public void iShouldSeeSupportTeamNumberDisplayed(String telephoneNumber) throws Throwable {
        assertTrue(driver.getDriver().findElementByAccessibilityId(telephoneNumber).isDisplayed());
    }

    @And("^I tap cancel$")
    public void iTapCancel() throws Throwable {
        settingsScreenPage.getCancelButton().click();
    }

    @Then("^I should not see contact us action sheet displayed$")
    public void iShouldSeeSettingScreenDisplayed() throws Throwable {
        driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        assertFalse(waitHelper.isElementPresent(settingsScreenPage.getCancelButton()));
    }
}