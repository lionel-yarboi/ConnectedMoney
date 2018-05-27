package pageobjects;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by lionelyarboi on 28/07/2017.
 */
public class SettingsScreenPage extends CommonElements{

    @iOSFindBy(accessibility = "Log out")
    private IOSElement logOut;

    @iOSFindBy(accessibility = "Log Out")
    private IOSElement logOutActionSheetButton;

    @iOSFindBy(accessibility = "Settings")
    private IOSElement settings;

    @iOSFindBy(accessibility = "Help")
    private IOSElement help;

    @iOSFindBy(accessibility = "Contact us")
    private IOSElement contactUs;

    @iOSFindBy(accessibility = "Version")
    private IOSElement version;

    @iOSFindBy(accessibility = "Delete profile")
    private IOSElement deleteProfile;

    @iOSFindBy(accessibility = "Email")
    private IOSElement emailButton;

    @iOSFindBy(accessibility = "Telephone")
    private IOSElement telephoneButton;

    @iOSFindBy(accessibility = "Cancel")
    private IOSElement cancelButton;

    public SettingsScreenPage(IOSDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public IOSElement getLogOut() {
        return logOut;
    }

    public IOSElement getHelp() {
        return help;
    }

    public IOSElement getContactUs() {
        return contactUs;
    }

    public IOSElement getVersion() {
        return version;
    }

    public IOSElement getDeleteProfile() {
        return deleteProfile;
    }

    public IOSElement getEmailButton() {
        return emailButton;
    }

    public IOSElement getTelephoneButton() {
        return telephoneButton;
    }

    public IOSElement getCancelButton() {
        return cancelButton;
    }

    public IOSElement getLogOutActionSheetButton() {
        return logOutActionSheetButton;
    }
}
