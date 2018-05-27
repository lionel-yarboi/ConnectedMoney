package pageobjects;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by lionelyarboi on 14/08/2017.
 */
public class AccountDetailScreenPage extends CommonElements {
    @iOSFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeStaticText[2]")
    private IOSElement lastUpdated;

    @iOSFindBy(accessibility = "Account information, tap to expand")
    private IOSElement accountInformationExpanded;

    @iOSFindBy(accessibility = "Account information")
    private IOSElement accountInformationHeader;

    @iOSFindBy(accessibility = "Name")
    private IOSElement nameHeader;

    @iOSFindBy(accessibility = "SMB account")
    private IOSElement nameValue;

    public AccountDetailScreenPage(IOSDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public IOSElement getLastUpdated() {
        return lastUpdated;
    }

    public IOSElement getAccountInformationExpanded() {
        return accountInformationExpanded;
    }

}
