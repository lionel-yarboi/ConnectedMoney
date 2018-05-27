package step_definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.ios.IOSDriver;
import org.springframework.beans.factory.annotation.Autowired;
import pageobjects.OnboardingScreenPage;
import support.DriverFactory;
import support.WaitHelper;

import static org.junit.Assert.assertTrue;

@CucumberStep
public class OnboardingScreenStep {

    @Autowired
    private DriverFactory driver;

    @Autowired
    private OnboardingScreenPage onboardingScreenPage;

    @Autowired
    private WaitHelper waitHelper;

    @Given("^I am on Onboarding screen$")
    public void iAmOnOnboardingScreen() throws Throwable {
        waitHelper.waitUntilDisplayed(driver.getDriver().findElementByAccessibilityId("Welcome to HSBC Beta"));
    }

    @When("^I scroll to end of Onboarding$")
    public void iScrollToEndOfOnboarding() throws Throwable {
        onboardingScreenPage.swipeToConnectWithHSBC(4, driver.getDriver());
    }

    @Then("^I should see content$")
    public void iShouldSeeContent() throws Throwable {
        assertTrue(driver.getDriver().findElementByAccessibilityId("safetyNet").isDisplayed());
    }

    @And("^I tap continue button$")
    public void iTapContinueButton() throws Throwable {
        waitHelper.waitUntilDisplayed(onboardingScreenPage.getContinueButton());
        onboardingScreenPage.getContinueButton().click();
    }

    @Then("^I should see onboarding screen$")
    public void iShouldSeeOnboardingScreen() throws Throwable {
        assertTrue(driver.getDriver().findElementByAccessibilityId("Welcome to HSBC Beta").isDisplayed());
    }

    @And("^I tap include my bank button$")
    public void iTapIncludeMyBankButton() throws Throwable {
        waitHelper.waitUntilDisplayed(onboardingScreenPage.getIncludeABank());
        onboardingScreenPage.getIncludeABank().click();
    }

    @And("^Accounts have successfully been added$")
    public void accountsHaveSuccessfullyBeenAdded() throws Throwable {
        waitHelper.pollingUntilElementDisplayed(onboardingScreenPage.getContinueButton(), "wait for continue button");
        onboardingScreenPage.getContinueButton().click();
    }
}
