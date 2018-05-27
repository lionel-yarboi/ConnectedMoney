package step_definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import pageobjects.*;
import support.DriverFactory;
import support.WaitHelper;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@CucumberStep
public class YouScreenStep {

    @Autowired
    private YouScreenPage youScreenPage;

    @Autowired
    private DriverFactory driver;

    @Autowired
    private WaitHelper waitHelper;

    @Then("^I should see you screen$")
    public void iShouldSeeYouScreen() throws Throwable {
        assertTrue(youScreenPage.getYourAccountsLabel().isDisplayed());
    }

    @And("^I tap settings icon$")
    public void iTapSettingsIcon() throws Throwable {
        youScreenPage.getSettingsButton().click();
    }

    @When("^I tap to add institution$")
    public void iTapToAddInstitution() throws Throwable {
        youScreenPage.getAddInstitution().click();
    }

    @Then("^I should see \"([^\"]*)\" card on youscreen$")
    public void iShouldSeeCardOnYouscreen(String failedLoginMessage) throws Throwable {
        waitHelper.pollingUntilElementDisplayed((IOSElement) driver.getDriver().findElementByAccessibilityId(failedLoginMessage),"Wait for failed status");
        assertTrue(driver.getDriver().findElementByAccessibilityId(failedLoginMessage).isDisplayed());
    }

    @And("^I am on you screen$")
    public void iAmOnYouscreen() throws Throwable {
        waitHelper.pollingUntilElementDisplayed(youScreenPage.getYourAccountsLabel(),"Wait for you screen to load");
    }


    @When("^I tap \"([^\"]*)\" in account list$")
    public void iTapInAccountList(String account) throws Throwable {
        waitHelper.pollingUntilElementDisplayed(youScreenPage.getYourAccountsLabel(), "Wait for polling to load");
        driver.getDriver().findElementByAccessibilityId(account).click();
    }

    @Then("^I should see \"([^\"]*)\" balance displayed$")
    public void iShouldSeeBalance(String balance) throws Throwable {
        assertTrue(driver.getDriver().findElementByAccessibilityId(balance).isDisplayed());
    }

    @And("^I scroll to bottom of screen$")
    public void iScrollToBottomOfScreen() throws Throwable {
        IosHelperActionMethods.scroll("down",driver.getDriver());
    }

    @Then("^I should see failed polling card with message \"([^\"]*)\"$")
    public void iShouldSeeFailedPollingCardWithMessage(String failedMessage) throws Throwable {
        waitHelper.pollingUntilElementDisplayed((IOSElement) driver.getDriver().findElementByAccessibilityId(failedMessage), "Waiting for failed polling card");
    }

    @When("^I tap failed polling card$")
    public void iTapFailedPollingCard() throws Throwable {
        IOSElement card = youScreenPage.getFailedPollingCard().get(3);
        card.click();
    }

    @When("^I select an account of type (.*)$")
    public void iSelectAnAccountOfTypeBANKAC(String accountTypeName) throws Throwable {
        waitHelper.scrollUntilElementDisplayed((IOSElement)driver.getDriver().findElementByAccessibilityId(accountTypeName),"down");
        driver.getDriver().findElementByAccessibilityId(accountTypeName).click();
    }

    @Then("^\"([^\"]*)\" account should not be visible$")
    public void accountShouldNotBeVisible(String mortgageAccount) throws Throwable {
        assertFalse(waitHelper.isElementPresent((IOSElement) driver.getDriver().findElementByAccessibilityId(mortgageAccount)));
    }


    @Then("^I should see LOY ISA PREM account with balance '£(\\d+),(\\d+)'$")
    public void iShouldSeeLOYISAPREMAccountWithBalance£(int arg0, int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should see (.*) account with balance (.*)$")
    public void iShouldSeeLOYISAPREMAccountWithBalance(String accountName, String balance) throws Throwable {
        assertTrue(driver.getDriver().findElementByAccessibilityId(accountName).isDisplayed());
        assertTrue(driver.getDriver().findElementByAccessibilityId(balance).isDisplayed());
    }
}
