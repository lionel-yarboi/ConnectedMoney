package support;

import com.google.common.base.Function;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.IosHelperActionMethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * Created by Yarboi on 14/12/2016.
 */
public class WaitHelper {

    private WebDriverWait wait;
    private IOSDriver driver;

    public WaitHelper(IOSDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 500);
    }

    public void waitUntilDisplayed(WebElement element) {
        wait.until(visibilityOf(element));
    }

    public boolean isElementPresent(IOSElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    //Use this method for any server related waits
    public void pollingUntilElementDisplayed(IOSElement element, String pollingMessage){
        Wait<IOSDriver> wait = new FluentWait<>(driver)
                .withTimeout(15, TimeUnit.MINUTES)
                .pollingEvery(5, TimeUnit.SECONDS)
                .withMessage(pollingMessage)
                .ignoring(org.openqa.selenium.NoSuchElementException.class);

        IOSElement waitingElement = wait.until((Function<IOSDriver, IOSElement>) driver -> element);
        waitingElement.isDisplayed();
    }

    public void scrollUntilElementsDisplayed(List <IOSElement> element, String directionOfScroll){
        Wait<IOSDriver> wait = new FluentWait<>(driver)
                .withTimeout(2, TimeUnit.MINUTES)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(org.openqa.selenium.NoSuchElementException.class);
        IosHelperActionMethods.scroll(directionOfScroll,driver);
        IOSElement waitingElement = wait.until((Function<IOSDriver, IOSElement>) driver -> element.get(0));
        waitingElement.isDisplayed();
    }

    public void scrollUntilElementDisplayed(IOSElement element, String directionOfScroll){
        Wait<IOSDriver> wait = new FluentWait<>(driver)
                .withTimeout(2, TimeUnit.MINUTES)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(org.openqa.selenium.NoSuchElementException.class);
        IosHelperActionMethods.scroll(directionOfScroll,driver);
        IOSElement waitingElement = wait.until((Function<IOSDriver, IOSElement>) driver -> element);
        waitingElement.isDisplayed();
    }
}
