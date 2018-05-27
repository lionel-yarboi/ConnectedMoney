package support;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import static support.utils.Logger.logger;

/**
 * Created by Yarboi on 13/12/2016.
 */
class AppiumSetup {

    private AppiumDriverLocalService appiumDriverLocalService;

    AppiumSetup(AppiumDriverLocalService localService){
        this.appiumDriverLocalService = localService;
    }

     void startService() {
        stopService();
        if (!appiumDriverLocalService.isRunning()) {
            logger.info("Starting service....");
            appiumDriverLocalService.start();
        }
    }

     void stopService() {
        if (appiumDriverLocalService.isRunning()) {
            logger.info("Shutting down service....");
            appiumDriverLocalService.stop();
        }
    }
}
