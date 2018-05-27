package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.ios.IOSElement;
import org.springframework.beans.factory.annotation.Autowired;
import pageobjects.InstitutionScreenPage;
import support.DriverFactory;
import support.WaitHelper;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

@CucumberStep
public class InstitutionScreenStep {

    @Autowired
    private WaitHelper waitHelper;

    @Autowired
    private DriverFactory driver;

    @Autowired
    private InstitutionScreenPage institutionScreenPage;

    @When("^I select \"([^\"]*)\"$")
    public void iSelect(String institution) throws Throwable {
        driver.getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        assertTrue(driver.getDriver().findElementByAccessibilityId(institution).isDisplayed());
    }
    @Then("^I should see institution screen$")
    public void iShouldSeeInstitutionScreen() throws Throwable {
        waitHelper.waitUntilDisplayed(driver.getDriver().findElementByAccessibilityId("HSBC"));
        assertTrue(driver.getDriver().findElementByAccessibilityId("HSBC").isDisplayed());
    }

    @And("^I should see connection options$")
    public void iShouldSeeConnectionOptions() throws Throwable {
        assertTrue(institutionScreenPage.getSecureYourData().isDisplayed());
    }

    @Then("^I should see failed login screen$")
    public void iShouldSeeFailedLoginScreen() throws Throwable {
        waitHelper.waitUntilDisplayed(institutionScreenPage.getTryAgain());
        assertTrue(institutionScreenPage.getErrorText().isDisplayed());
    }

    @When("^I tap to try again$")
    public void iTapToTryAgain() throws Throwable {
        institutionScreenPage.getTryAgain().click();
    }

    @Then("^I should see failed bank login institution screen$")
    public void iShouldSeeOtherBankInstitutionScreen() throws Throwable {
        waitHelper.pollingUntilElementDisplayed(institutionScreenPage.getYourUsername(), "Wait until username textfield displayed");
        assertTrue(institutionScreenPage.getLoginButton().isDisplayed());
    }

    @And("^I tap \"([^\"]*)\" bank$")
    public void iAddABankAccount(String bankAccount) throws Throwable {
        new WaitHelper(driver.getDriver()).pollingUntilElementDisplayed((IOSElement)driver.getDriver().findElementByAccessibilityId(bankAccount), "wait for account list");
        driver.getDriver().findElementByAccessibilityId("HSBC").click();
    }
}
