package utilities;

import com.relevantcodes.extentreports.LogStatus;

//import constants.AppNameConstants;
//import constants.androidConstants.AndroidConstants;
//import constants.iosConstants.IosConstants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.OperatingSystem;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import stepDefinitions.RunCukesTest;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * The type Driver util.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DriverUtil {

    private static final String APPIUM_URL = "http://0.0.0.0:4723/wd/hub";

    private static final Map<String, WebDriver> drivers = new HashMap<>();

    public static String testName;

    /**
     * Invoke local mobile browser android.
     *
     * @param deviceDetails the device details
     */
    public static void invokeLocalMobileBrowserAndroid(String deviceDetails) {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        String deviceName = deviceDetails.split("_")[0];
        String osVersion = deviceDetails.split("_")[1];

        LogUtil.infoLog(DriverUtil.class, String.format("Execution started for Android on device - %s with OS Version - %s", deviceName, osVersion));

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, osVersion);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigReader.getValue("platformName"));
        capabilities.setCapability("appPackage", "com.payfare.paidapp");
        capabilities.setCapability("appActivity", "com.payfare.paidapp.ui.authentication.WelcomeScreenActivity");
        try {
            GlobalUtil.setAndroidDriver(new AndroidDriver<>(new URL(APPIUM_URL), capabilities));
        } catch (MalformedURLException e) {
            LogUtil.infoLog(DriverUtil.class, e.getMessage());
            e.printStackTrace();
        }
        GlobalUtil.getAndroidDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        RunCukesTest.logger.log(LogStatus.INFO, HTMLReportUtil.infoStringBlueColor("Execution done By The Device: " + deviceDetails));
    }


    /**
     * Invoke sauce labs for android app.
     *
     * @param browserRequired the browser required
     * @param deviceName      the device name
     * @param platformVersion the platform version
     * @param buildName       the build name
     */
    public static void invokeSauceLabsForAndroidApp(boolean browserRequired, String deviceName, String platformVersion, String buildName) {

        try {

            String appName = null;

            MutableCapabilities sauceOptions = new MutableCapabilities();
            sauceOptions.setCapability("build", buildName);
            sauceOptions.setCapability("name", testName);
//            if (!(ConfigReader.getValue("sauceLabsTunnelName").equalsIgnoreCase("PlaceholderName")))
//                sauceOptions.setCapability("tunnelName", ConfigReader.getValue("sauceLabsTunnelName"));
//            sauceOptions.setCapability("tunnelOwner", ConfigReader.getValue("sauceConnectTunnelOwner"));

            MutableCapabilities caps = new MutableCapabilities();
            caps.setCapability("platformName", "Android");
            if (browserRequired)
                caps.setCapability("browserName", "Chrome");
            caps.setCapability("app", appName);
            caps.setCapability("appium:deviceName", deviceName);
            caps.setCapability("appium:platformVersion", platformVersion);
            caps.setCapability("newCommandTimeout", 90);
            caps.setCapability("sauceLabsNetworkCaptureEnabled", true);
            caps.setCapability("sauce:options", sauceOptions);

            URL url = new URL("https://" + GlobalUtil.getCommonSettings().getHostName() + ":" + GlobalUtil.getCommonSettings().getKey() + "@ondemand.us-west-1.saucelabs.com:443/wd/hub");

            GlobalUtil.setAndroidDriver(new AndroidDriver(url, caps));

            LogUtil.infoLog(DriverUtil.class, "\n\n+===========================================================================================================+");
            LogUtil.infoLog(DriverUtil.class, "SauceLabs build Name = " + buildName);
            LogUtil.infoLog(DriverUtil.class, String.format("Execution started for Android on device - %s with OS Version - %s", deviceName, platformVersion));
            LogUtil.infoLog(DriverUtil.class, "\n\n+===========================================================================================================+");

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    //iOS Driver Methods

    /**
     * Invoke local iOS app.
     *
     * @param deviceDetails the device details
     */
    public static void invokeLocaliOSApp(String deviceDetails) {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        String deviceName = deviceDetails.split("_")[0];
        String osVersion = deviceDetails.split("_")[1];

        LogUtil.infoLog(DriverUtil.class, String.format("Execution started for iOS on device - %s with OS Version - %s", deviceName, osVersion));

        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, osVersion);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");

        String udid=System.getProperty("udid");
        if(udid==null)
            capabilities.setCapability("udid", "8F8A1CDC-7F5A-4652-914F-8EBCCFF99A52");
        else
            capabilities.setCapability("udid", "8F8A1CDC-7F5A-4652-914F-8EBCCFF99A52");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability(MobileCapabilityType.APP,"Users/atul/Downloads/CORE.app");

        try {
            GlobalUtil.setIosDriver(new IOSDriver<IOSElement>(new URL(APPIUM_URL), capabilities));

        } catch (MalformedURLException e) {
            LogUtil.errorLog(DriverUtil.class, e.getMessage());
            e.printStackTrace();
        }

        GlobalUtil.getIosDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * Invoke local iOS browser.
     *
     * @param deviceDetails the device details
     */
    public static void invokeLocaliOSBrowser(String deviceDetails) {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        String deviceName = deviceDetails.split("_")[0];
        String osVersion = deviceDetails.split("_")[1];

        LogUtil.infoLog(DriverUtil.class, String.format("Execution started for iOS on device - %s with OS Version - %s", deviceName, osVersion));

        // capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, IosConstants.PLATFORM_NAME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, osVersion);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        //capabilities.setCapability(MobileCapabilityType.APP, IosConstants.APP_LOCATION);
        //capabilities.setCapability(MobileCapabilityType.UDID, IosConstants.SIMULATOR_IPHONE11_UDID);
        try {
            GlobalUtil.setIosDriver(new IOSDriver<IOSElement>(new URL(APPIUM_URL), capabilities));

        } catch (MalformedURLException e) {
            LogUtil.errorLog(DriverUtil.class, e.getMessage());
            e.printStackTrace();
        }
        GlobalUtil.getIosDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        RunCukesTest.logger.log(LogStatus.INFO, HTMLReportUtil.infoStringBlueColor("Execution done By The Device: " + deviceDetails));
    }

    /**
     * Invoke sauce labs for ios app.
     *
     * @param browserRequired the browser required
     * @param deviceName      the device name
     * @param platformVersion the platform version
     * @param buildName       the build name
     */
    public static void invokeSauceLabsForIosApp(boolean browserRequired, String deviceName, String platformVersion, String buildName) {

        try {

            String appName = null;
            MutableCapabilities sauceOptions = new MutableCapabilities();
            sauceOptions.setCapability("build", buildName);
            sauceOptions.setCapability("name", testName);

//            if (!(ConfigReader.getValue("sauceLabsTunnelName").equalsIgnoreCase("PlaceholderName")))
//                sauceOptions.setCapability("tunnelName", ConfigReader.getValue("sauceLabsTunnelName"));
//            sauceOptions.setCapability("tunnelOwner", ConfigReader.getValue("sauceConnectTunnelOwner"));

            MutableCapabilities caps = new MutableCapabilities();
            caps.setCapability("platformName", "iOS");
            if (browserRequired)
                caps.setCapability("browserName", "Safari");
            caps.setCapability("app", appName);
            caps.setCapability("appium:deviceName", deviceName);
            caps.setCapability("appium:platformVersion", platformVersion);
            caps.setCapability("newCommandTimeout", 90);
            caps.setCapability("sauceLabsNetworkCaptureEnabled", true);
            caps.setCapability("sauce:options", sauceOptions);

            URL url = new URL("https://" + GlobalUtil.getCommonSettings().getHostName() + ":" + GlobalUtil.getCommonSettings().getKey() + "@ondemand.us-west-1.saucelabs.com:443/wd/hub");

            GlobalUtil.setIosDriver(new IOSDriver(url, caps));

            LogUtil.infoLog(DriverUtil.class, "\n\n+===========================================================================================================+");
            LogUtil.infoLog(DriverUtil.class, "SauceLabs build Name = " + buildName);
            LogUtil.infoLog(DriverUtil.class, String.format("Execution started for iOS on device - %s with iOS - %s", deviceName, platformVersion));
            LogUtil.infoLog(DriverUtil.class, "\n\n+===========================================================================================================+");

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    //Web Browser methods

    /**
     * Invoke local browser web driver.
     *
     * @param osName      the os name
     * @param browserName the browser name
     * @return the web driver
     */
    public static WebDriver invokeLocalBrowserWeb(String osName, String browserName) {
        WebDriver browser = null;
        OperatingSystem operatingSystem;
        try {
            osName = osName.toUpperCase();
            browserName = browserName.toUpperCase();

            switch (osName) {
                case "MAC":
                    operatingSystem = OperatingSystem.MAC;
                    break;
                case "WINDOWS":
                    operatingSystem = OperatingSystem.WIN;
                    break;
                case "LINUX":
                    operatingSystem = OperatingSystem.LINUX;
                    break;
                default:
                    throw new Exception("Invalid OS Name - " + osName);
            }

            browser = drivers.get(browserName);
            if (browser == null)
                switch (browserName) {
                    case "CHROME":
                        WebDriverManager.chromedriver().operatingSystem(operatingSystem).setup();
                        browser = new ChromeDriver();
                        break;
                    case "FIREFOX":
                        WebDriverManager.firefoxdriver().operatingSystem(operatingSystem).setup();
                        browser = new FirefoxDriver();
                        break;
                    default:
                        throw new Exception("Invalid Browser Name - " + browserName);
                }
            drivers.put(browserName, browser);
            browser.manage().window().maximize();
            browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            LogUtil.errorLog(DriverUtil.class, "Browser not launched. Please check the configuration ", e);
            e.printStackTrace();
        }
        return browser;
    }

    /**
     * Invoke sauce labs browser web driver.
     *
     * @param browserName    the browser name
     * @param osName         the os name
     * @param browserVersion the browser version
     * @param buildId        the build id
     * @param testName       the test name
     * @return the web driver
     */
    public static WebDriver invokeSauceLabsBrowserWeb(String browserName, String osName, String browserVersion, String buildId, String testName) {
        WebDriver browser = null;
        String URL;
        browserName = browserName.split("_")[0].toUpperCase();
        DesiredCapabilities desiredCapabilities;

        try {
            switch (browserName) {
                case "CHROME":
                    desiredCapabilities = DesiredCapabilities.chrome();
                    break;
                case "FIREFOX":
                    desiredCapabilities = DesiredCapabilities.firefox();
                    break;
                case "IE":
                    desiredCapabilities = DesiredCapabilities.internetExplorer();
                    break;
                default:
                    throw new Exception("Invalid Browser Name - " + browserName);
            }

            desiredCapabilities.setCapability("platform", osName);
            desiredCapabilities.setCapability("version", browserVersion);
            desiredCapabilities.setCapability("build", buildId);
            desiredCapabilities.setCapability("name", testName);
            desiredCapabilities.setCapability("extendedDebugging", "true");

            URL = "https://" + GlobalUtil.getCommonSettings().getHostName() + ":" + GlobalUtil.getCommonSettings().getKey() + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";
            browser = new RemoteWebDriver(new URL(URL), desiredCapabilities);

            drivers.put(browserName, browser);

        } catch (Exception e) {
            LogUtil.errorLog(DriverUtil.class, "Browser not launched. Please check the configuration ", e);
            e.printStackTrace();
        }

        return browser;
    }

    /**
     * Gets browser.
     *
     * @param exeEnv the exe env
     * @return the browser
     */
    public static WebDriver getBrowser(String exeEnv) {

        WebDriver browser;
        String browserName;
        String osName;

        if (exeEnv.equalsIgnoreCase("Remote")) {

            browserName = GlobalUtil.getCommonSettings().getBrowser().split("_")[0];
            String browserVersion = GlobalUtil.getCommonSettings().getBrowser().split("_")[1];
            osName = GlobalUtil.getCommonSettings().getRemoteOS();
            String buildId = "Build 1";
            String testName = "Web Test Dummy 1";

            browser = invokeSauceLabsBrowserWeb(browserName, osName, browserVersion, buildId, testName);

            LogUtil.infoLog(DriverUtil.class, String.format("Browser launched on Remote - Browser = %s, OS = %s, Browser Version = %s, Build Name = %s, " + "Test Name = %s", browserName, osName, browserVersion, buildId, testName));
        } else {

            browserName = GlobalUtil.getCommonSettings().getBrowser().split("_")[0];
            osName = GlobalUtil.getCommonSettings().getRemoteOS();

            browser = invokeLocalBrowserWeb(osName, browserName);

            LogUtil.infoLog(DriverUtil.class, String.format("Browser launched on Local - Browser = %s, OS = %s", browserName, osName));
        }
        return browser;
    }

    /**
     * Close all driver.
     */
    public static void closeAllDriver() {

        drivers.entrySet().forEach(key -> {
            key.getValue().quit();
            key.setValue(null);
        });

        LogUtil.infoLog(DriverUtil.class, "Closing Browsers");
    }

    /**
     * Gets img ref.
     *
     * @param imgFile the img file
     * @return the img ref
     */
    public static String getImgRef(String imgFile) {
        return new DriverUtil().getRefImage(imgFile);
    }

    //New Invoke Methods
    public static AppiumDriver<MobileElement> invokeLocalMobileAppAndroid(String deviceDetails) {
        String deviceName;
        String osVersion;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if(System.getProperty("device_detail")==null) {
            deviceName= deviceDetails.split("_")[0];
            osVersion= deviceDetails.split("_")[1];
        }
        else
        {
            String dd=System.getProperty("device_detail");
            deviceName= dd.split("_")[0];
            osVersion= dd.split("_")[1];
        }

        System.out.println(deviceName);
        System.out.println(osVersion);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, osVersion);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability("fullReset", "true");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigReader.getValue("platformName"));
        File apkFile = new File("src/test/resources/APK/Nykaa_base.apk");

        capabilities.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());
//        capabilities.setCapability("appPackage", "com.fsn.nykaa");
//        capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
//        capabilities.setCapability("appActivity", "com.fsn.nykaa.splash.SplashScreenActivity");
        try {
            GlobalUtil.MDriver= new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            System.err.println("");
            e.printStackTrace();
        }
        GlobalUtil.MDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return GlobalUtil.MDriver;
    }
    private String getRefImage(String imgFile) {
        String openCVImgsFolder = "OpenCVImages/";
        URL refImgUrl = getClass().getClassLoader().getResource(openCVImgsFolder + imgFile + ".png");
        File refImgFile;
        try {
            refImgFile = Paths.get(refImgUrl.toURI()).toFile();
            LogUtil.infoLog(DriverUtil.class, "File Found : " + refImgFile.exists());
            return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}