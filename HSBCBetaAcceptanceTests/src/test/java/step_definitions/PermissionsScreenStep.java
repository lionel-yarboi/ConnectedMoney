package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import pageobjects.InstitutionScreenPage;
import pageobjects.IosHelperActionMethods;
import pageobjects.PermissionsScreenPage;
import support.DriverFactory;
import support.WaitHelper;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@CucumberStep
public class PermissionsScreenStep {

    @Autowired
    private PermissionsScreenPage permissionsScreenPage;

    @Autowired
    private InstitutionScreenPage institutionScreenPage;

    @Autowired
    private WaitHelper waitHelper;

    @Autowired
    private DriverFactory driver;

    @And("^I set my passcode$")
    public void iEnterPasscode() throws Throwable {
        waitHelper.waitUntilDisplayed(permissionsScreenPage.getCreareAPassCodeText());
        permissionsScreenPage.getCreareAPassCodeText().click();
        permissionsScreenPage.enterPasscode("1");
        permissionsScreenPage.confirmPasscode("1");
    }

    @When("^I enter incorrect passcode$")
    public void iEnterIncorrectConfirmationPasscode() throws Throwable {
        waitHelper.waitUntilDisplayed(permissionsScreenPage.getCreareAPassCodeText());
        permissionsScreenPage.getCreareAPassCodeText().click();
        permissionsScreenPage.enterPasscode("1");
        permissionsScreenPage.confirmPasscode("2");
    }

    @And("^I enable push notifications$")
    public void iTapEnablePushNotificationsButton() throws Throwable {
        permissionsScreenPage.getEnableNotificationsButton().click();
        permissionsScreenPage.getEnablePushNotificationsButton().click();
    }

    @Then("^I should see green tick displayed on polling screen$")
    public void iShouldSeeGreenTickDisplayedOnPollingScreen() throws Throwable {
        waitHelper.waitUntilDisplayed(permissionsScreenPage.getEnableNotificationsButton());
        IosHelperActionMethods.horizontalSwipe("Enable notifications",333,333,driver.getDriver());
        assertTrue(permissionsScreenPage.getCheckBoxConfirmed().isDisplayed());
    }

    @When("^I accept iOS notifications alert")
    public void iAcceptNotifications() throws Throwable {
        driver.getDriver().findElementByAccessibilityId("Allow").click();
    }

    @And("^I tap not now$")
    public void iTapNotNow() throws Throwable {
        permissionsScreenPage.getNotNowButton().click();
    }

    @Then("^I should see polling screen$")
    public void iShouldSeePollingScreen() throws Throwable {
        assertTrue(permissionsScreenPage.getCreareAPassCodeText().isDisplayed());
    }

    @And("^I should not see green tick displayed$")
    public void iShouldNotSeeGreenTickDisplayed() throws Throwable {
        assertFalse(waitHelper.isElementPresent(permissionsScreenPage.getCheckBoxConfirmed()));
    }

    @Then("^I should see green tick displayed on polling screen passcode card$")
    public void iShouldSeeGreenTickDisplayed() throws Throwable {
        waitHelper.isElementPresent(permissionsScreenPage.getCheckBoxConfirmed());
        assertTrue(permissionsScreenPage.getCheckBoxConfirmed().isDisplayed());
    }

    @Then("^I should see green tick displayed on notifications button$")
    public void iShouldSeeGreenTickDisplayedOnNotificationsButton() throws Throwable {
        IosHelperActionMethods.swipe(240,388,37,300,driver.getDriver());
        waitHelper.waitUntilDisplayed(permissionsScreenPage.getEnableNotificationsButton());
        assertTrue(permissionsScreenPage.getCheckBoxConfirmed().isDisplayed());
    }

    @Then("^I should see connecting screen$")
    public void iShouldSeeConnectingScreen() throws Throwable {
        waitHelper.waitUntilDisplayed(institutionScreenPage.getConnectingWithHSBC());
        assertTrue(institutionScreenPage.getConnectingWithHSBC().isDisplayed());
    }

    @Then("^I should see error message \"([^\"]*)\"$")
    public void iShouldSeeErrorMessage(String errorMessage) throws Throwable {
        assertTrue(driver.getDriver().findElementByAccessibilityId(errorMessage).isDisplayed());
    }

    @And("^I am on polling screen$")
    public void iAmOnPollingScreen() throws Throwable {
        waitHelper.waitUntilDisplayed(permissionsScreenPage.getSecureYourDataButton());
    }

    @When("^I defer push notifications$")
    public void iDeferPushNotifications() throws Throwable {
        permissionsScreenPage.getEnableNotificationsButton().click();
        permissionsScreenPage.getNotNowButton().click();
    }

    @And("^I disable push notifications$")
    public void iDisablePushNotifications() throws Throwable {
        permissionsScreenPage.getNotNowButton().click();
    }

    @When("^I close and reopen app$")
    public void iCloseAndReopenApp() throws Throwable {
        driver.getDriver().runAppInBackground(3);
    }

    @Then("^I should see passcode screen$")
    public void iShouldSeePasscodeScreen() throws Throwable {
        waitHelper.pollingUntilElementDisplayed(permissionsScreenPage.getSecureYourDataButton(), "Wait for passcode screen");
    }

    @When("^I enter my passcode$")
    public void iEnterMyPasscode() throws Throwable {
        permissionsScreenPage.enterPasscode("1");
    }
}