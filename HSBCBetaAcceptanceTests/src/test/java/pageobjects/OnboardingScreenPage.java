package pageobjects;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by lionelyarboi on 31/07/2017.
 */
public class OnboardingScreenPage extends CommonElements {

    @iOSFindBy(accessibility = "Log on now")
    private IOSElement logOnNowButton;

    @iOSFindBy(accessibility = "Continue")
    private IOSElement continueButton;

    @iOSFindBy(accessibility = "Include a bank")
    private IOSElement includeABank;

    public OnboardingScreenPage(IOSDriver driver) {
         PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void swipeToConnectWithHSBC(int numberOfSwipes, IOSDriver driver){
        for(int i = 0; i < numberOfSwipes; i++){
            IosHelperActionMethods.swipe(300,333,37,300,driver);
        }
    }

    public IOSElement getContinueButton() {
        return continueButton;
    }

    public IOSElement getLogOnNowButton() {
        return logOnNowButton;
    }

    public IOSElement getIncludeABank() {
        return includeABank;
    }
}
