package pageobjects;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by lionelyarboi on 27/07/2017.
 */
public class LoginScreenPage {

    public LoginScreenPage(IOSDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSFindBy(accessibility = "Log on")
    private IOSElement logOnButton;

    @iOSFindBy(accessibility = "your username textfield")
    private IOSElement yourUsername;

    @iOSFindBy(accessibility = "memorable answer textfield")
    private IOSElement memorableAnswer;

    @iOSFindBy(xpath = "password textfield")
    private IOSElement password;

    @iOSFindBy(xpath = "//XCUIElementTypeWindow[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton")
    private IOSElement connectButtonLogin;

    @iOSFindBy(accessibility = "Forgot your log on?")
    private IOSElement forgotLoginButton;


    public IOSElement getYourUsername() {
        return yourUsername;
    }

    public IOSElement getMemorableAnswer() {
        return memorableAnswer;
    }

    public IOSElement getPassword() {
        return password;
    }

    public IOSElement getLogOnButton() {
        return connectButtonLogin;
    }

    public IOSElement getForgotLoginButton() {
        return forgotLoginButton;
    }
}
