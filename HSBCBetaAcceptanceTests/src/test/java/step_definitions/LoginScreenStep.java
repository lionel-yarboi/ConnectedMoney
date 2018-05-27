package step_definitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import pageobjects.InstitutionScreenPage;
import pageobjects.LoginScreenPage;
import pageobjects.OnboardingScreenPage;
import support.DriverFactory;
import support.WaitHelper;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * Created by lionelyarboi on 27/07/2017.
 */
@CucumberStep
public class LoginScreenStep {

    @Autowired
    private WaitHelper waitHelper;

    @Autowired
    private OnboardingScreenPage onboardingScreenPage;

    @Autowired
    private LoginScreenPage loginScreenPage;

    @Autowired
    private InstitutionScreenPage institutionScreenPage;

    @Autowired
    private DriverFactory driver;

    @Given("^I am on login screen$")
    public void iAmOnLoginScreen() throws Throwable {
        waitHelper.waitUntilDisplayed(driver.getDriver().findElementByAccessibilityId("Welcome to HSBC Beta"));
        onboardingScreenPage.swipeToConnectWithHSBC(4, driver.getDriver());
        onboardingScreenPage.getLogOnNowButton().click();
        waitHelper.waitUntilDisplayed(loginScreenPage.getYourUsername());
        assertTrue(loginScreenPage.getForgotLoginButton().isDisplayed());
    }

    @And("^I should see username$")
    public void iShouldSeeUsername() throws Throwable {
        assertTrue(loginScreenPage.getYourUsername().isDisplayed());
    }

    @And("^I should see memorable answer$")
    public void iShouldSeeMemorableAnswer() throws Throwable {
        assertTrue(loginScreenPage.getMemorableAnswer().isDisplayed());
    }

    @And("^I should see password field$")
    public void iShouldSeePasswordField() throws Throwable {
        assertTrue(loginScreenPage.getPassword().isDisplayed());
    }

    @And("^I should see forgotten password button$")
    public void iShouldSeeForgottenPasswordButton() throws Throwable {
        assertTrue(loginScreenPage.getForgotLoginButton().isDisplayed());
    }

    @And("^I (?:login|enter) with (?:valid|invalid) credentials$")
    public void iLoginWithInvalidCredentials(DataTable userCredentials) throws Throwable {
        waitHelper.waitUntilDisplayed(loginScreenPage.getYourUsername());
        waitHelper.pollingUntilElementDisplayed(loginScreenPage.getYourUsername(), "Waiting for username field");
        List<Map<String,String>> maps = userCredentials.asMaps(String.class, String.class);
        maps.forEach(m -> institutionScreenPage.getYourUsername().sendKeys(m.get("Username")));
        institutionScreenPage.getYourUsername().click();
        maps.forEach(m -> institutionScreenPage.getPassword().sendKeys(m.get("Password")));
        institutionScreenPage.getPassword().click();
        maps.forEach(m -> institutionScreenPage.getMemorableAnswer().sendKeys(m.get("MemorableAnswer")));
        institutionScreenPage.getMemorableAnswer().click();
        loginScreenPage.getLogOnButton().click();
    }

    @Then("^I should see login screen$")
    public void iShouldSeeLoginScreen() throws Throwable {
        waitHelper.waitUntilDisplayed(institutionScreenPage.getYourUsername());
        assertTrue(institutionScreenPage.getYourUsername().isDisplayed());
        assertTrue(institutionScreenPage.getPassword().isDisplayed());
        assertTrue(institutionScreenPage.getMemorableAnswer().isDisplayed());
    }
}
