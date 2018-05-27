package pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import support.WaitHelper;

import java.util.HashMap;


/**
 * Created by lionelyarboi on 28/07/2017.
 */
public class IosHelperActionMethods {

    public static void scroll(String direction, IOSDriver driver) {
        try {
            JavascriptExecutor js = driver;
            HashMap<String, String> scrollObject = new HashMap<String, String>();
            scrollObject.put("direction", direction);
            js.executeScript("mobile: scroll", scrollObject);
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void swipe(int startSwipeX, int startSwipeY, int endSwipeX, int holdDownDuration, IOSDriver driver){
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width*0.10);
        int endX = (int) (size.width*0.8);
        int startY = size.height/2;
        driver.swipe(startSwipeX, startSwipeY, endSwipeX, startSwipeY, holdDownDuration);
    }

    public static void horizontalSwipe(String element, int offSetWidth, int offSetHeight, IOSDriver driver) throws Exception {
        MobileElement slider = (MobileElement) driver.findElementByAccessibilityId(element);
        Dimension size = slider.getSize();

        TouchAction swipe = new TouchAction(driver)
                .press(slider, 0, size.height)
                .waitAction()
                .moveTo(slider, offSetWidth , offSetHeight )
                .release();
        swipe.perform();
    }
}
