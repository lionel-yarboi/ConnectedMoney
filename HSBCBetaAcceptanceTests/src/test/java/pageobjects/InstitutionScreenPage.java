package pageobjects;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by lionelyarboi on 31/07/2017.
 */
public class InstitutionScreenPage {

    @iOSFindBy(accessibility = "Connecting with HSBC")
    private IOSElement connectingWithHSBC;

    @iOSFindBy(accessibility = "Secure your data")
    private IOSElement secureYourData;

    @iOSFindBy(accessibility = "Set up a passcode")
    private IOSElement setUpAPasscode;

    @iOSFindBy(accessibility = "Connect")
    private IOSElement connectButton;

    @iOSFindBy(accessibility = "your username textfield")
    private IOSElement yourUsername;

    @iOSFindBy(accessibility = "memorable answer textfield")
    private IOSElement memorableAnswer;

    @iOSFindBy(accessibility = "password textfield")
    private IOSElement password;

    @iOSFindBy(accessibility = "Oops… something went wrong")
    private IOSElement errorText;

    @iOSFindBy(accessibility = "Try again")
    private IOSElement tryAgain;

    @iOSFindBy(accessibility = "Login")
    private IOSElement loginButton;


    public InstitutionScreenPage(IOSDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public IOSElement getConnectingWithHSBC() {
        return connectingWithHSBC;
    }

    public IOSElement getSecureYourData() {
        return secureYourData;
    }

    public IOSElement getYourUsername() {
        return yourUsername;
    }

    public IOSElement getMemorableAnswer() {
        return memorableAnswer;
    }

    public IOSElement getPassword() {
        return password;
    }

    public IOSElement getErrorText() {
        return errorText;
    }

    public IOSElement getTryAgain() {
        return tryAgain;
    }

    public IOSElement getLoginButton() {
        return loginButton;
    }
}
