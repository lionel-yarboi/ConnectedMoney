package pageobjects;

import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public abstract class CommonElements {

    @iOSFindBy(accessibility = "close")
    private IOSElement closeButton;

    @iOSFindBy(accessibility = "Back")
    private IOSElement backButton;

    public IOSElement getCloseButton() {
        return closeButton;
    }

    public IOSElement getBackButton() {
        return backButton;
    }
}
