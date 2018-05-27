package step_definitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import pageobjects.AccountDetailScreenPage;
import pageobjects.IosHelperActionMethods;
import support.DriverFactory;
import support.WaitHelper;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

@CucumberStep
public class AccountDetailScreenStep {

    @Autowired
    private DriverFactory driver;

    @Autowired
    private WaitHelper waitHelper;

    @Autowired
    private AccountDetailScreenPage accountDetailScreenPage;

    @And("^I tap first account in account list$")
    public void iTapFirstAccountInAccountList() throws Throwable {
        driver.getDriver().findElementByAccessibilityId("£84,699.00").click();
    }

    @And("^I should see balance$")
    public void iShouldSeeBalance() throws Throwable {
        waitHelper.waitUntilDisplayed(driver.getDriver().findElementByAccessibilityId("£84,699.00"));
        assertTrue(driver.getDriver().findElementByAccessibilityId("£84,699.00").isDisplayed());
    }

    @And("^I should see account subtype$")
    public void iShouldSeeAccountSubtype() throws Throwable {
        assertTrue(driver.getDriver().findElementByAccessibilityId("SMB account").isDisplayed());
    }

    @And("^I should see last updated$")
    public void iShouldSeeLastUpdated() throws Throwable {
        assertTrue(accountDetailScreenPage.getLastUpdated().isDisplayed());
    }

    @When("^I tap back button$")
    public void iTapBackButton() throws Throwable {
        accountDetailScreenPage.getBackButton().click();
    }

    @Then("^I should see account name$")
    public void iShouldSeeAccountName() throws Throwable {
        WebElement firstAccountName = (WebElement) driver.getDriver().findElementsByAccessibilityId("SMB account").get(0);
        assertTrue(firstAccountName.isDisplayed());
    }

    @And("^I should see account type$")
    public void iShouldSeeAccountType() throws Throwable {
        assertTrue(driver.getDriver().findElementByAccessibilityId("savings").isDisplayed());
    }

    @And("^I should see account number$")
    public void iShouldSeeAccountNumber() throws Throwable {
        assertTrue(driver.getDriver().findElementByAccessibilityId("xxxx4933").isDisplayed());

    }

    @And("^I should see available balance$")
    public void iShouldSeeAvailableBalance() throws Throwable {
        assertTrue(driver.getDriver().findElementByAccessibilityId("£4,699.00").isDisplayed());
    }

    @And("^I should see interest rate$")
    public void iShouldSeeInterestRate() throws Throwable {
        assertTrue(driver.getDriver().findElementByAccessibilityId("3%").isDisplayed());
    }

    @And("^I should see interest rate text displayed$")
    public void iShouldSeeInterestRateTextDisplayed() throws Throwable {
        waitHelper.waitUntilDisplayed(driver.getDriver().findElementByAccessibilityId("Refer to your provider for the current interest rate on your account"));
        assertTrue(driver.getDriver().findElementByAccessibilityId("Refer to your provider for the current interest rate on your account").isDisplayed());
    }

    @When("^I tap non HSBC account in account list$")
    public void iTapNonHSBCAccountInAccountList() throws Throwable {
        IosHelperActionMethods.scroll("down", driver.getDriver());
        driver.getDriver().findElementByAccessibilityId("£917.20").click();
    }

    @Then("^I should not see account information displayed$")
    public void iShouldNotSeeAccountInformationDisplayed() throws Throwable {
        driver.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        assertTrue(driver.getDriver().findElementsByAccessibilityId("current").size() < 1);
    }

    @Then("^I should see my recent transaction$")
    public void iShouldSeeMyRecentTransaction() throws Throwable {
        int i = 0;
        while(i < 2){
            IosHelperActionMethods.scroll("down", driver.getDriver());
            i++;
        }
        assertTrue(driver.getDriver().findElementByAccessibilityId("Salary").isDisplayed());
        assertTrue(driver.getDriver().findElementByAccessibilityId("+ £30.00").isDisplayed());
    }

    @And("^I tap to expand account information$")
    public void iTapToExpandAccountInformation(DataTable userCredentials) throws Throwable {
        accountDetailScreenPage.getAccountInformationExpanded().click();
    }

    @Then("^I should see \"([^\"]*)\" name displayed$")
    public void iShouldSeeNameDisplayed(String accountName) throws Throwable {
        waitHelper.pollingUntilElementDisplayed((IOSElement) driver.getDriver().findElementByAccessibilityId(accountName),"Waiting for account");
        assertTrue(driver.getDriver().findElementByAccessibilityId(accountName).isDisplayed());
    }

    @And("^I should see account information \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\" displayed$")
    public void iShouldSeeAccountInformationAndDisplayed(String accountName, String accountType, String accountNumber, String availableBalance, String interestRate) throws Throwable {
        assertTrue(((WebElement) driver.getDriver().findElementsByAccessibilityId(accountName).get(1)).isDisplayed());
        assertTrue(driver.getDriver().findElementByAccessibilityId(accountType).isDisplayed());
        assertTrue(driver.getDriver().findElementByAccessibilityId(accountNumber).isDisplayed());
        assertTrue(driver.getDriver().findElementByAccessibilityId(availableBalance).isDisplayed());
        assertTrue(driver.getDriver().findElementByAccessibilityId(interestRate).isDisplayed());
    }
}
