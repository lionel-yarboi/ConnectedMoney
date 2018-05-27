package support;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hsbc.rbwm.digital.pfm.test.collaborators.*;
import com.hsbc.rbwm.digital.pfm.test.collaborators.HSBCLogin;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import pageobjects.*;
import support.database.MinimumAppVersionDAO;

import javax.inject.Singleton;
import java.net.UnknownHostException;

@Configuration
@PropertySource("classpath:application-${env}.properties")
@PropertySource("classpath:mobile.properties")
public class ExecutionConfiguration {

    @Value("${dsp.authenticateUrl}")
    private String dspAuthenticateUrl;

    @Value("${dsp.authorizeUrl}")
    private String dspAuthorizeUrl;

    @Value("${dsp.redirectUri}")
    private String dspRedirectUri;

    @Value("${dsp.clientId}")
    private String dspClientId;

    @Value("${userManager.termsAndConditions.root}")
    private String rootURI;

    @Value("${userManager.termsAndConditions.status}")
    private String statusURI;

    @Value("${userManager.termsAndConditions.latest}")
    private String latestURI;

    @Value("${userManager.termsAndConditions.accept}")
    private String acceptURI;

    @Value("${userManager.minimumAppVersionUrl")
    private String minimumAppVersion;

    @Value("${appLocation}")
    private String appLocation;

    @Value("${deviceName}")
    private String deviceName;

    @Value("${platformVersion}")
    private String platformVersion;

    @Value("${platformName}")
    private String platformName;

    @Value("${userManager.mongodb.uri}")
    private String mongoDb;

    @Value("${userManager.mongodb.database}")
    private String mongoDatabase;

    @Value("${UDID}")
    private String UDID;

    @Bean
    DesiredCapabilities capabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITEST");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        caps.setCapability(MobileCapabilityType.APP, appLocation);
        caps.setCapability(MobileCapabilityType.FULL_RESET, true);
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 240);
        caps.setCapability(MobileCapabilityType.UDID, UDID);
        return caps;
    }

    @Bean
    AppiumDriverLocalService builder(){
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
        return AppiumDriverLocalService.buildService(builder);
    }

    @Bean
    AppiumSetup appiumSetup() {
        AppiumSetup serviceStart = new AppiumSetup(builder());
        serviceStart.startService();
        return serviceStart;
    }

    @Bean
    HSBCLogin hsbcLogin() {
        return new HSBCLogin(dspAuthenticateUrl, dspAuthorizeUrl, dspRedirectUri, dspClientId);
    }

    @Bean
    RegistrationOrchestration registrationSteps(HSBCLogin hsbcLogin,
                                                CredentialsHolder credentialsHolder) {
        return new RegistrationOrchestration(hsbcLogin, credentialsHolder);
    }

    @Bean
    @Profile({"ci", "qa", "dev", "dev-simulator"})
    AuthorizationHeadersFactory apiGatewayAuthorizationHeadersFactory() {
        return new ApiGatewayAuthorizationHeadersFactory();
    }

    @Bean
    @Profile({"local", "local-simulator"})
    AuthorizationHeadersFactory internalAuthorizationHeadersFactory() {
        return new InternalAuthorizationHeadersFactory();
    }

    @Bean
    @Singleton
    CredentialsHolder credentialsHolder(AuthorizationHeadersFactory authorizationHeadersFactory) {
        return new CredentialsHolder(authorizationHeadersFactory);
    }

    @Bean
    MinimumAppVersionDAO minimumAppVersionDAO(){
        return new MinimumAppVersionDAO(mongoTemplate());
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    DriverFactory driver(DesiredCapabilities capabilities) {
        return new DriverFactory(capabilities);
    }

    @Bean
    ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    OnboardingScreenPage onboardingScreenPage(DriverFactory driver) {
        return new OnboardingScreenPage(driver.getDriver());
    }

    @Bean
    LoginScreenPage loginScreenPage(DriverFactory driver) {
        return new LoginScreenPage(driver.getDriver());}

    @Bean
    InstitutionScreenPage institutionScreenPage(DriverFactory driver) {
        return new InstitutionScreenPage(driver.getDriver());}

    @Bean
    PermissionsScreenPage permissionsScreenPage(DriverFactory driver){
        return new PermissionsScreenPage(driver.getDriver());
    }

    @Bean
    SettingsScreenPage settingsScreenPage(DriverFactory driver){
        return new SettingsScreenPage(driver.getDriver());
    }

    @Bean
    YouScreenPage youScreenPage(DriverFactory driver){
        return new YouScreenPage(driver.getDriver());
    }

    @Bean
    AccountDetailScreenPage accountDetailScreenPage(DriverFactory driver){
        return new AccountDetailScreenPage(driver.getDriver());
    }

    @Bean
    MinimumAppVersionPage minimumAppVersionPage(DriverFactory driver){
        return new MinimumAppVersionPage(driver.getDriver());
    }

    @Bean
    WaitHelper waitHelper(DriverFactory driver){
        return new WaitHelper(driver.getDriver());
    }

    @Bean
    MongoDbFactory mongoDbFactory() {
        SimpleMongoDbFactory mongo = null;
        try {
            mongo = new SimpleMongoDbFactory(client(), mongoDatabase);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return mongo;
    }

    @Bean
    MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongoDbFactory());
    }

    @Bean
    public MongoClient client() throws UnknownHostException {
        MongoClientOptions.Builder builder = MongoClientOptions.builder();
        return new MongoClient(new MongoClientURI(mongoDb, builder));
    }

}
