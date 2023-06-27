package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import jirautil.JiraUtil;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

/**
 * This class will get date and time, and it will rename the file with date and
 * time
 */
public class GlobalUtil {

    /**
     * The constant jiraApi.
     */
    public static JiraUtil jiraApi;
    /**
     * The constant errorMsg.
     */
    public static String errorMsg;
    /**
     * The constant e.
     */
    public static Throwable e;
    private static CommonSettings commonSettings = new CommonSettings();

    @Getter
    @Setter
    private static WebDriver webDriver = null;
    @Getter
    @Setter
    private static WebDriver Driver;

    @Getter
    @Setter
    public static AppiumDriver<MobileElement> MDriver;
    public static AndroidDriver<MobileElement> androidDriver;
    public static IOSDriver<IOSElement> iosDriver;

    /**
     * Gets common settings.
     *
     * @return common settings
     */
    public static CommonSettings getCommonSettings() {
        return commonSettings;
    }

    /**
     * Sets common settings.
     *
     * @param commonSettings the common settings
     */
    public static void setCommonSettings(CommonSettings commonSettings) {
        GlobalUtil.commonSettings = commonSettings;
    }

    /**
     * Gets m driver.
     *
     * @return the m driver
     */
    public static AndroidDriver<?> getAndroidDriver() {
        return androidDriver;
    }

    /**
     * Sets m driver.
     *
     * @param androidDriver the Android driver
     */
    @SuppressWarnings("unchecked")
    public static void setAndroidDriver(AndroidDriver<?> androidDriver) {
        GlobalUtil.androidDriver = (AndroidDriver<MobileElement>) androidDriver;
    }

    /**
     * Gets ios driver.
     *
     * @return the ios driver
     */
    public static IOSDriver<?> getIosDriver() {
        return iosDriver;
    }

    /**
     * Sets ios driver.
     *
     * @param iosDriver the ios driver
     */
    public static void setIosDriver(IOSDriver<?> iosDriver) {
        GlobalUtil.iosDriver = (IOSDriver<IOSElement>) iosDriver;
    }

//    public static void setDriver(WebDriver driver) {
//        GlobalUtil.webDriver = driver;
//    }
//
//    public static WebDriver getDriver() {
//        return Driver;
//    }
}
