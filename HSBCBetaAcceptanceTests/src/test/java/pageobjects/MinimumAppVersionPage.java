package pageobjects;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by lionelyarboi on 24/10/2017.
 */
public class MinimumAppVersionPage extends CommonElements{

    @iOSFindBy(accessibility = "Time to update your app")
    private IOSElement updateYourAppAlert;

    public MinimumAppVersionPage(IOSDriver driver){

        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public IOSElement getUpdateYourAppAlert() {
        return updateYourAppAlert;
    }
}
