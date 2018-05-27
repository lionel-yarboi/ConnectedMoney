package pageobjects;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by lionelyarboi on 28/07/2017.
 */
public class YouScreenPage extends CommonElements {

    private IOSDriver driver;

    @iOSFindBy(accessibility = "Settings")
    private IOSElement settingsButton;

    @iOSFindBy(accessibility = "Add institution")
    private IOSElement addInstitution;

    @iOSFindBy(accessibility = "Not connected")
    private List<IOSElement> failedPollingCard;

    @iOSFindBy(accessibility = "Your accounts")
    private IOSElement yourAccountsLabel;

    @iOSFindBy(accessibility = "Mortgage account")
    private List<IOSElement> mortgageAccount;


    public YouScreenPage(IOSDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public List<IOSElement> getMortgageAccount() {
        return mortgageAccount;
    }

    public WebElement getAccounts(String accountName){
        return (WebElement) driver.findElementsByAccessibilityId(accountName).get(0);
    }

    public IOSElement getSettingsButton() {
        return settingsButton;
    }

    public IOSElement getAddInstitution() {
        return addInstitution;
    }

    public List<IOSElement> getFailedPollingCard() {
        return failedPollingCard;
    }

    public IOSElement getYourAccountsLabel() {
        return yourAccountsLabel;
    }
}

