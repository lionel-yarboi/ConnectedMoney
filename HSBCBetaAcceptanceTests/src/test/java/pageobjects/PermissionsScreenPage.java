package pageobjects;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by lionelyarboi on 31/08/2017.
 */
public class PermissionsScreenPage {

    private IOSDriver driver;

    public PermissionsScreenPage(IOSDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSFindBy(accessibility = "Secure your data")
    private IOSElement secureYourDataButton;

    @iOSFindBy(accessibility = "Create a passcode")
    private IOSElement creareAPassCodeText;

    @iOSFindBy(accessibility = "Passcodes did not match. Try again.")
    private IOSElement errorMessageLabel;

    @iOSFindBy(accessibility = "Enable notifications")
    private IOSElement enableNotificationsButton;

    @iOSFindBy(accessibility = "Enable Push Notifications")
    private IOSElement enablePushNotificationsButton;

    @iOSFindBy(accessibility = "checkboxConfirmed")
    private IOSElement checkBoxConfirmed;

    @iOSFindBy(accessibility = "Not now")
    private IOSElement notNowButton;


    public void enterPasscode(String passcodeDigit) {
        int i = 0;
        while(i < 6){
            driver.findElementByAccessibilityId(passcodeDigit).click();
            i++;
        }
    }

    public void confirmPasscode(String passcodeDigit) {
        int i = 0;
        while(i < 6){
            driver.findElementByAccessibilityId(passcodeDigit).click();
            i++;
        }
    }

    public IOSElement getCreareAPassCodeText() {
        return creareAPassCodeText;
    }

    public IOSElement getEnableNotificationsButton() {
        return enableNotificationsButton;
    }

    public IOSElement getNotNowButton() {
        return notNowButton;
    }

    public IOSElement getEnablePushNotificationsButton() {
        return enablePushNotificationsButton;
    }

    public IOSElement getCheckBoxConfirmed() {
        return checkBoxConfirmed;
    }

    public IOSElement getSecureYourDataButton() {
        return secureYourDataButton;
    }
}
