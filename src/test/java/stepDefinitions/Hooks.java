package stepDefinitions;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.compress.utils.IOUtils;
import testlink.api.java.client.TestLinkAPIResults;
import utilities.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import static utilities.JsonConversion.cs;

public class Hooks {
    private static final String BSTACK_PASSED = "passed";
    private static final String BSTACK_FAILED = "failed";
    public static String imagePath1;
    public static String concatt = ".";
    static String testCaseDescription;
    String imagePath;
    String pathForLogger;

    @Before("@Android")
    public void beforeMobileTestMethod(Scenario scenario) {
        try {
            if (scenario.getName().contains("_"))
                testCaseDescription = scenario.getName().split("_")[1].trim();
            else
                testCaseDescription = scenario.getName();

            RunCukesTest.logger = RunCukesTest.extent.startTest(testCaseDescription);
            RunCukesTest.tagName = scenario.getSourceTagNames().toString().replace("[@", "").replace("]", "").trim();

            LogUtil.infoLog(getClass(), "Mobile Tests Started: " + scenario.getName());
            LogUtil.infoLog(Hooks.class,
                    "Mobile Test is executed in OS: " + GlobalUtil.getCommonSettings().getAndroidName());

        } catch (Exception th) {
            LogUtil.infoLog(getClass(), "Error while loading scenario name");
            th.printStackTrace();
        }
    }

    @Before("@IOS")
    public void beforeiOSMobileTestMethod(Scenario scenario) {
        try {
            if (scenario.getName().contains("_"))
                testCaseDescription = scenario.getName().split("_")[1].trim();
            else
                testCaseDescription = scenario.getName();

            RunCukesTest.logger = RunCukesTest.extent.startTest(testCaseDescription);
            RunCukesTest.tagName = scenario.getSourceTagNames().toString().replace("[@", "").replace("]", "").trim();

            LogUtil.infoLog(getClass(), "Mobile Tests Started: " + scenario.getName());
            LogUtil.infoLog(Hooks.class,
                    "Mobile Test is executed in OS: " + GlobalUtil.getCommonSettings().getIosBrowser());

        } catch (Exception th) {
            LogUtil.infoLog(getClass(), "Error while loading scenario name");
            th.printStackTrace();
        }
    }

    @Before("@Web")
    public void beforeMethodAmazon(Scenario scenario) {
//        if (scenario.getName().contains("_"))
//            testCaseDescription = scenario.getName().split("_")[1].trim();
//        else
//            testCaseDescription = scenario.getName();
//
//        RunCukesTest.logger = RunCukesTest.extent.startTest(testCaseDescription);
//        RunCukesTest.tagName = scenario.getSourceTagNames().toString().replace("[@", "").replace("]", "").trim();
//
//        LogUtil.infoLog(getClass(),
//                "\n+----------------------------------------------------------------------------------------------------------------------------+");
//        LogUtil.infoLog(getClass(), "Test Started: " + scenario.getName());
//        LogUtil.infoLog(Hooks.class,
//                "Test is executed in Environment: " + GlobalUtil.getCommonSettings().getExecutionEnv());
//        LogUtil.infoLog(Hooks.class, "Test is started with browser: " + GlobalUtil.getCommonSettings().getBrowser());
//
//        if (scenario.getName().contains("_"))
//            testCaseDescription = scenario.getName().split("_")[1].trim();
//        else
        testCaseDescription = scenario.getName();

        RunCukesTest.logger = RunCukesTest.extent.startTest(testCaseDescription);
        RunCukesTest.tagName = scenario.getSourceTagNames().toString().replace("[@", "").replace("]", "").trim();

        LogUtil.infoLog(getClass(),
                "\n+----------------------------------------------------------------------------------------------------------------------------+");
        LogUtil.infoLog(getClass(), "Test Started: " + scenario.getName());
        LogUtil.infoLog(Hooks.class,
                "Test is executed in Environment: " + GlobalUtil.getCommonSettings().getExecutionEnv());
        LogUtil.infoLog(Hooks.class, "Test is started with browser: " + GlobalUtil.getCommonSettings().getBrowser());

        GlobalUtil.setDriver(DriverUtil.getBrowser(GlobalUtil.getCommonSettings().getExecutionEnv(),
                GlobalUtil.getCommonSettings().getBrowser()));
    }

    @After("@Android")
    public void afterMobileTestMethod(Scenario scenario) {
        String testName;
        if (scenario.getName().contains("_"))
            testName = scenario.getName().split("_")[0].trim();
        else
            testName = scenario.getName();

        if (scenario.isFailed()) {
            try {
                String scFileName = "ScreenShot_" + System.currentTimeMillis();
                String screenshotFilePath = ConfigReader.getValue("screenshotPath") + "\\" + scFileName + ".png";

                imagePath = HTMLReportUtil.testFailMobileTakeScreenshot(screenshotFilePath);

                InputStream is = new FileInputStream(imagePath);
                byte[] imageBytes = IOUtils.toByteArray(is);
                Thread.sleep(2000);
                String base64 = Base64.getEncoder().encodeToString(imageBytes);
                pathForLogger = RunCukesTest.logger.addBase64ScreenShot("data:image/png;base64," + base64);
                RunCukesTest.logger.log(LogStatus.FAIL,
                        HTMLReportUtil.failStringRedColor("Failed at point: " + pathForLogger) + GlobalUtil.e);

                byte[] screenshot = KeywordUtil.takeMobileScreenshot(imagePath);
                scenario.attach(screenshot, "image/png", "Failed Screenshot");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            LogUtil.infoLog(Hooks.class,
                    "Test has ended closing Application: " + cs.getAndroidName());  //GlobalUtil.getCommonSettings().getAndroidName()
        }
        //Ending extent report and closing Mobile driver
        GlobalUtil.getMDriver().quit();
        //GlobalUtil.getAndroidDriver().quit();
        RunCukesTest.extent.endTest(RunCukesTest.logger);
    }

    @After("@IOS")
    public void afterIOSMobileTestMethod(Scenario scenario) {
        String testName;
        if (scenario.getName().contains("_"))
            testName = scenario.getName().split("_")[0].trim();
        else
            testName = scenario.getName();

        if (scenario.isFailed()) {
            try {
                String scFileName = "ScreenShot_" + System.currentTimeMillis();
                String screenshotFilePath = ConfigReader.getValue("screenshotPath") + "\\" + scFileName + ".png";

                imagePath = HTMLReportUtil.testFailMobileTakeScreenshot(screenshotFilePath);

                InputStream is = new FileInputStream(imagePath);
                byte[] imageBytes = IOUtils.toByteArray(is);
                Thread.sleep(2000);
                String base64 = Base64.getEncoder().encodeToString(imageBytes);
                pathForLogger = RunCukesTest.logger.addBase64ScreenShot("data:image/png;base64," + base64);
                RunCukesTest.logger.log(LogStatus.FAIL,
                        HTMLReportUtil.failStringRedColor("Failed at point: " + pathForLogger) + GlobalUtil.e);

                byte[] screenshot = KeywordUtil.takeMobileScreenshot(imagePath);
                scenario.attach(screenshot, "image/png", "Failed Screenshot");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            LogUtil.infoLog(Hooks.class,
                    "Test has ended closing Application: " + cs.getIosName());  //GlobalUtil.getCommonSettings().getAndroidName()
        }
        //Ending extent report and closing Mobile driver
        GlobalUtil.getIosDriver().quit();
        //GlobalUtil.getAndroidDriver().quit();
        RunCukesTest.extent.endTest(RunCukesTest.logger);
    }

    @After("@Web") //@Amazon
    public void afterMethodSmoke(Scenario scenario) {
        String testName;
        if (scenario.getName().contains("_"))
            testName = scenario.getName().split("_")[0].trim();
        else
            testName = scenario.getName();

        if (scenario.isFailed()) {
            try {
                String scFileName = "ScreenShot_" + System.currentTimeMillis();
                String screenshotFilePath = ConfigReader.getValue("screenshotPath") + "\\" + scFileName + ".png";
                imagePath = HTMLReportUtil.testFailTakeScreenshot(screenshotFilePath);

                InputStream is = new FileInputStream(imagePath);
                byte[] imageBytes = IOUtils.toByteArray(is);
                Thread.sleep(2000);
                String base64 = Base64.getEncoder().encodeToString(imageBytes);
                pathForLogger = RunCukesTest.logger.addBase64ScreenShot("data:image/png;base64," + base64);
                RunCukesTest.logger.log(LogStatus.FAIL,
                        HTMLReportUtil.failStringRedColor("Failed at point: " + pathForLogger) + GlobalUtil.e);

                byte[] screenshot = KeywordUtil.takeScreenshot(imagePath);
                scenario.attach(screenshot, "image/png", "Failed Screenshot");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            LogUtil.infoLog(Hooks.class,
                    "Test has ended closing browser: " + GlobalUtil.getCommonSettings().getBrowser());
        }

        // close the browsers
        GlobalUtil.getDriver().close();
        GlobalUtil.getDriver().quit();
        RunCukesTest.extent.endTest(RunCukesTest.logger);
    }
}