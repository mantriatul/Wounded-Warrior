package mobileutil;

import constants.andriod.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import stepDefinitions.RunCukesTest;
import utilities.GlobalUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;
import utilities.LogUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MobileKeywords {
    public static ExtentTest test = null;
    public static Class<MobileKeywords> thisClass = MobileKeywords.class;

    public static String maskedImpNumber(String ac) {
        StringBuilder st = new StringBuilder();
        String x = ac.substring(ac.length() - 3);
        for (int i = 0; i <= ac.length() - 3; i++) {
            st.append("*");
        }
        String masked = st.append(x).toString();
        RunCukesTest.logger.log(LogStatus.INFO, HTMLReportUtil.infoStringBlueColor(masked));
        LogUtil.infoLog(MobileKeywords.class, masked);
        return masked;
    }

    public static boolean sizeVerification(By locator, int data) {
        int Data;
        Data = data + 1;
        try {
            List<MobileElement> list = (List<MobileElement>) GlobalUtil.getMDriver().findElements(locator);
            Assert.assertEquals(list.size(), Data);
            KeywordUtil.lastAction = " size is " + data;
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(KeywordUtil.lastAction));
            return true;
        } catch (Throwable th) {
            KeywordUtil.lastAction = " size is not " + data;
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor(KeywordUtil.lastAction));
            return false;
        }
    }

    public static void clickByIndex(By locator, int data) {
        try {
            List<MobileElement> list = (List<MobileElement>) GlobalUtil.getMDriver().findElements(locator);
            list.get(data).click();
            KeywordUtil.lastAction = " " + data;
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
        } catch (Throwable th) {
            KeywordUtil.lastAction = " size is not " + data;
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);

        }
    }

    public static boolean enteringCode(By locator, String value) {
        try {
            List<MobileElement> eles = (List<MobileElement>) GlobalUtil.getMDriver().findElements(locator);
            String[] data = value.split("");
            for (int i = 0; i <= eles.size() - 1; i++) {
                eles.get(i).sendKeys(data[i]);
                KeywordUtil.lastAction = data[i] + " entered ";
                LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            }
            return true;
        } catch (Throwable th) {
            System.out.println(" error while entering data ");
            return false;
        }
    }


    public static boolean setValue(By locator, String data) {
        WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), 20);
        MobileElement element = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        try {
            element.sendKeys(data);
            KeywordUtil.lastAction = " Data entered : " + data;
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(KeywordUtil.lastAction));
            return true;
        } catch (Throwable th) {
            KeywordUtil.lastAction = " Data not entered ";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor(KeywordUtil.lastAction));
            return false;
        }
    }

    public static boolean enter() throws IOException {
        Runtime.getRuntime().exec(" adb shell input keyevent 66 ");
        return true;
    }

    public static boolean textAssertion(By locator, String data) {
        try {
            WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), 70);
            MobileElement element = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            Assert.assertEquals(element.getText(), data);
            KeywordUtil.lastAction = data + " is verified";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(KeywordUtil.lastAction));
            return true;
        } catch (Throwable t) {
            KeywordUtil.lastAction = data + " is not verified";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor(KeywordUtil.lastAction));
            return false;
        }
    }

    public static boolean textAssertionContains(By locator, String data) {
        try {
            WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), 50);
            MobileElement element = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(locator));
            Assert.assertTrue(element.getText().contains(data));
            KeywordUtil.lastAction = data + " is verified";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(KeywordUtil.lastAction));
            return true;
        } catch (Throwable t) {
            KeywordUtil.lastAction = data + " is not verified";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor(KeywordUtil.lastAction));
            return false;
        }
    }

    public static void textAssertionsContains(By locator, String data) {
        List<MobileElement> element = (List<MobileElement>) GlobalUtil.getMDriver().findElements(locator);
        try {
            int i = 0;
            while (true) {
                if (element.get(i).getText().contains(data)) {
                    KeywordUtil.lastAction = data + " is verified ";
                    LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
                    RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(KeywordUtil.lastAction));
                    break;
                } else {
                    i++;
                }
            }
        } catch (Throwable t) {
            KeywordUtil.lastAction = data + " is not verified ";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor(KeywordUtil.lastAction));
        }
    }

    public static boolean tapsViaContains(By locator, String data) {
        List<MobileElement> element = (List<MobileElement>) GlobalUtil.getMDriver().findElements(locator);
        try {
            int i = 0;
            while (true) {
                if (element.get(i).getText().contains(data)) {
                    element.get(i).click();
                    KeywordUtil.lastAction = "Tapped on " + data;
                    RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(KeywordUtil.lastAction));
                    LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
                    break;
                } else {
                    i++;
                }
            }
            return true;
        } catch (Throwable t) {
            KeywordUtil.lastAction = data + " is not verified ";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor(KeywordUtil.lastAction));
            return false;
        }
    }

    public static boolean isButtonEnabled(By locator, String button) {
        try {
            Assert.assertTrue(GlobalUtil.getMDriver().findElement(locator).isEnabled());
            KeywordUtil.lastAction = button + " is enabled ";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            return true;
        } catch (Throwable t) {
            KeywordUtil.lastAction = button + " is disabled ";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            return false;
        }
    }

    public static MobileElement explicitlyWaitForElementToBeVisible(By locator, long timeOutInSecond) {
        WebDriverWait wait;
        MobileElement ele;
        try {
            wait = new WebDriverWait(GlobalUtil.getMDriver(), timeOutInSecond);
            ele = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.format("Element is visible within given %s.", timeOutInSecond)));
        } catch (Exception e) {
            GlobalUtil.e = e;
            GlobalUtil.errorMsg = e.getMessage();
            LogUtil.errorLog(MobileKeywords.class, e.getMessage());
            RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor(String.format("Element is not visible within given %s.", timeOutInSecond)));
            ele = null;
            Assert.fail(GlobalUtil.errorMsg);
        }
        return ele;
    }

    public static boolean isElementEnabled(By locator, String elementName) {
        boolean isElementEnabledTrue = false;
        try {
            isElementEnabledTrue = explicitlyWaitForElementToBeVisible(locator, Constants.EXPLICITLY_TIMEOUT_IN_SECOND).isEnabled();
            if (isElementEnabledTrue) {
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.format("%s is already enabled.", elementName)));
            } else {
                RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor(String.format("%s is not enabled.", elementName)));
                throw new Exception(elementName + " is found disabled.");
            }
        } catch (Exception e) {
            GlobalUtil.e = e;
            GlobalUtil.errorMsg = e.getMessage();
            LogUtil.errorLog(MobileKeywords.class, e.getMessage());
            Assert.fail(GlobalUtil.errorMsg);
        }
        return isElementEnabledTrue;
    }


    public static boolean isElementDisabled(By locator, String elementName) {
        boolean isElementNotEnabledTrue = false;
        try {
            isElementNotEnabledTrue = !explicitlyWaitForElementToBeVisible(locator, Constants.EXPLICITLY_TIMEOUT_IN_SECOND).isEnabled();
            if (isElementNotEnabledTrue) {
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.format("%s is disabled.", elementName)));
            } else {
                RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor(String.format("%s is already enabled.", elementName)));
                throw new Exception(elementName + " is found already enabled.");
            }
        } catch (Exception e) {
            GlobalUtil.e = e;
            GlobalUtil.errorMsg = e.getMessage();
            LogUtil.errorLog(MobileKeywords.class, e.getMessage());
            Assert.fail(GlobalUtil.errorMsg);
        }
        return isElementNotEnabledTrue;
    }

    public static Boolean isButtonDisabled(By locator, String button) {
        try {
            Assert.assertFalse(GlobalUtil.getMDriver().findElement(locator).isEnabled());
            KeywordUtil.lastAction = button + " is disabled ";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            return true;
        } catch (Throwable th) {
            KeywordUtil.lastAction = button + " is enabled ";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            return false;
        }
    }

    public static boolean taps(By locator, String elements) {
        WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), 20);
        MobileElement elm = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        if (elm == null) {
            KeywordUtil.lastAction = "Unable to tap on " + elements;
            RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor(KeywordUtil.lastAction));
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            return false;
        } else {
            elm.click();
            KeywordUtil.lastAction = "Tapped on " + elements;
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(KeywordUtil.lastAction));
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            return true;
        }
    }

    public static String getAmount(By locator) {
        WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), Constants.EXPLICITLY_TIMEOUT_IN_SECOND);
        MobileElement elm = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        String data = elm.getText();
        String[] special = data.split("\\$");
        String no = special[1];
        return no;
    }


    public static double randomAmountLess(String data) {
        double min = 0;
        double max = Double.parseDouble(data);
        double random_int = Math.floor(Math.random() * (max - min + 1) + min);
        return random_int;

    }

    public static double randomAmountMore(String data) {
        float max = Float.parseFloat(data) + 100;
        float min = Float.parseFloat(data) + 1;
        double random_int = (float) Math.floor(Math.random() * (max - min + 1) + min);
        return random_int * 92;

    }

    public static String getText(By locator) {
        WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), 50);
        MobileElement elm = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        LogUtil.infoLog(MobileKeywords.class, "Fetched Text : " + elm.getText());
        RunCukesTest.logger.log(LogStatus.INFO, HTMLReportUtil.infoStringBlueColor("Fetched Text : " + elm.getText()));
        return elm.getText();
    }

    public static int getSize(By locator) {
        List<MobileElement> elements = (List<MobileElement>) GlobalUtil.getMDriver().findElements(locator);
        return elements.size();
    }

    public static boolean sizeVerification(String data, int number) {
        try {
            Assert.assertEquals(data.length(), number);
            LogUtil.infoLog(MobileKeywords.class, "Size of " + data + " is equal to " + number);
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Size of " + data + " is equal to " + number));
            return true;
        } catch (Throwable t) {
            LogUtil.infoLog(MobileKeywords.class, "Size of " + data + " mismatched with " + number);
            RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor("Size of " + data + " mismatched with " + number));
            return false;
        }
    }

    public static boolean textVerification(By locator, String data, String log) {
        try {
            Assert.assertTrue(GlobalUtil.getMDriver().findElement(locator).getText().contains(data));
            LogUtil.infoLog(MobileKeywords.class, data + " present");
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(data + " present"));
            return true;
        } catch (Throwable t) {
            LogUtil.infoLog(MobileKeywords.class, "Unable to find " + data);
            RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor("Unable to find " + data));
            return false;
        }
    }

    public static boolean isMobileElementVisible(By locator, String logStep) {
        try {
            WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), 70);
            MobileElement elm = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            Assert.assertTrue(elm.isDisplayed());
            KeywordUtil.lastAction = logStep + " is visible";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(KeywordUtil.lastAction));
            return true;
        } catch (Throwable t) {
            KeywordUtil.lastAction = logStep + " not visible";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor(KeywordUtil.lastAction));
            return false;
        }
    }

    public static boolean isMobileElementNotVisible(By locator, String logStep) {
        try {
            MobileElement elm = (MobileElement) GlobalUtil.getMDriver().findElement(locator);
            Assert.assertFalse(elm.isDisplayed());
            KeywordUtil.lastAction = logStep + " is visible";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor(KeywordUtil.lastAction));
            return true;
        } catch (Throwable t) {
            KeywordUtil.lastAction = logStep + " is not visible";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(KeywordUtil.lastAction));
            return true;
        }
    }

    public static boolean isMobileElementVisibleForList(String data) {
        try {
            WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), 20);
            MobileElement elm = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.widget.TextView[@text='" + data + "']//following-sibling::android.widget.TextView")));
            Assert.assertTrue(elm.isDisplayed());
            LogUtil.infoLog(MobileKeywords.class, "Value of " + data + " is visible");
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Value of " + data + " is visible"));
            return true;
        } catch (Throwable t) {
            LogUtil.infoLog(MobileKeywords.class, "Values of " + data + " is missing");
            RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor("Value of " + data + " is visible"));
            return true;
        }
    }

    public static boolean isMobileElementSelected(By locator, String logStep) {
        WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), 20);
        MobileElement elm = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        try {
            Assert.assertTrue(elm.isSelected());
            KeywordUtil.lastAction = logStep + " is Selected ";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            //RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));
            return true;
        } catch (Throwable t) {
            KeywordUtil.lastAction = logStep + " not Selected ";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            return true;
        }
    }

    public static boolean isMobileElementsVisible(By locator, String logstep) {
        try {
            List<MobileElement> Elements = (List<MobileElement>) GlobalUtil.getMDriver().findElements(locator);
            for (MobileElement Element : Elements) {
                Assert.assertTrue(Element.isDisplayed());
            }
            LogUtil.infoLog(thisClass, logstep + " are visible");
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logstep + " are visible"));
            return true;
        } catch (Throwable t) {
            LogUtil.infoLog(thisClass, logstep + " not visible");
            RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor(logstep + " not visible"));
            return false;
        }
    }

    public static boolean isMobileElementsTextMatching(By locator, ArrayList<String> data, String logstep) {
        try {
            List<MobileElement> Elements = (List<MobileElement>) GlobalUtil.getMDriver().findElements(locator);
            for (int i = 0; i <= data.size() - 1; i++) {
                Assert.assertTrue(Elements.get(i).isDisplayed());
                Assert.assertEquals(Elements.get(i).getText(), data.get(i));
                LogUtil.infoLog(thisClass, logstep + " text matched ");
            }
            return true;
        } catch (Throwable t) {
            LogUtil.infoLog(thisClass, logstep + " text mismatched ");
            return false;
        }
    }

    public static boolean isMobileElementEnabled(By locator, String log) {
        WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), 20);
        MobileElement elm = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        try {
            Assert.assertTrue(elm.isEnabled());
            KeywordUtil.lastAction = log + " is enabled";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(KeywordUtil.lastAction));
            return true;
        } catch (Throwable t) {
            KeywordUtil.lastAction = log + " is disabled";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor(KeywordUtil.lastAction));
            return false;
        }
    }

    public static boolean isMobileElementDisabled(By locator, String log) {
        WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), 20);
        MobileElement elm = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        try {
            Assert.assertFalse(elm.isEnabled());
            KeywordUtil.lastAction = log + " is disabled";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(KeywordUtil.lastAction));
            return true;
        } catch (Throwable t) {
            KeywordUtil.lastAction = log + " is enabled";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor(KeywordUtil.lastAction));
            return false;
        }
    }

    public static boolean isMobileElementTextMatching(By locator, String data, String logstep) {
        WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), 20);
        MobileElement elm = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        try {
            Assert.assertEquals(elm.getText(), data);
            KeywordUtil.lastAction = logstep + " text matched";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(KeywordUtil.lastAction));
            return true;
        } catch (Throwable t) {
            KeywordUtil.lastAction = logstep + " text mismatched";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor(KeywordUtil.lastAction));
            return false;
        }
    }

    public static void scrollAndClick(String data) {
        try {
            GlobalUtil.getAndroidDriver().findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()" +
                    ".scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + data +
                    "\").instance(0))").click();
            KeywordUtil.lastAction = "Tapped on " + data;
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(KeywordUtil.lastAction));
        } catch (Throwable t) {
            KeywordUtil.lastAction = "Unable to tap on " + data;
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor(KeywordUtil.lastAction));
        }
    }

    public static void tap(String data) {
        try {
            WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), 3);
            MobileElement element = (MobileElement) wait.until(ExpectedConditions.
                    visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + data + "\")")));
            element.click();
            KeywordUtil.lastAction = "Tapped on " + data;
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(KeywordUtil.lastAction));
        } catch (Throwable t) {
            KeywordUtil.lastAction = "Unable to tap on " + data;
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor(KeywordUtil.lastAction));
        }
    }

    public static void searchAndTaps(By locator, String searchElement) {
        try {
            List<MobileElement> eles = (List<MobileElement>) GlobalUtil.getMDriver().findElements(locator);
            for (int i = 0; i <= eles.size() - 1; i++) {
                if (eles.get(i).getText().equals(searchElement)) {
                    eles.get(i).click();
                    KeywordUtil.lastAction = searchElement + " is tapped ";
                    LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
                    break;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            System.out.println(" Error while doing search and click ");
        }
    }

    public static void scrollAndFind(String data) {
        try {
            Assert.assertTrue(GlobalUtil.getAndroidDriver().findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()" +
                    ".scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + data +
                    "\").instance(0))").isDisplayed());
            KeywordUtil.lastAction = data + " is visible ";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(KeywordUtil.lastAction));
        } catch (Throwable t) {
            KeywordUtil.lastAction = " unable to find " + data;
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor(KeywordUtil.lastAction));
        }
    }

    public static void uiAutomatorFind(String data) {
        try {
            WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), 3);
            MobileElement element = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + data + "\")")));
            Assert.assertTrue(element.isDisplayed());
            KeywordUtil.lastAction = data + " is visible ";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(KeywordUtil.lastAction));
        } catch (Throwable t) {
            KeywordUtil.lastAction = "Unable to find " + data;
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor(KeywordUtil.lastAction));
        }
    }

    public static void scrollAndFind1(String data) {
        try {
            WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), 40);
            MobileElement element = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + data + "\")")));
            Assert.assertTrue(element.isDisplayed());
            KeywordUtil.lastAction = data + " is visible ";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(KeywordUtil.lastAction));
        } catch (Throwable t) {
            KeywordUtil.lastAction = " unable to find " + data;
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor(KeywordUtil.lastAction));
        }
    }

    public static void scrollAndVerify(String data) {
        try {
            Assert.assertEquals(GlobalUtil.getAndroidDriver().findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()" + ".scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + data + "\").instance(0))").getText(), data);
            KeywordUtil.lastAction = data + " text matched ";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(KeywordUtil.lastAction));
        } catch (Throwable t) {
            KeywordUtil.lastAction = " unable to find " + data;
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor(KeywordUtil.lastAction));
        }
    }

    public static boolean isMobileElementAttributeTextMatching(By locator, String data, String logstep) {
        WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), 30);
        MobileElement elm = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        try {
            //isMobileElementVisible(locator, logstep);
            Assert.assertEquals(elm.getAttribute("checked"), data);
            KeywordUtil.lastAction = logstep + data + " attribute text matched ";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            //RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));
            return true;
        } catch (Throwable t) {
            KeywordUtil.lastAction = logstep + data + " attribute text mismatched ";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            return false;
        }
    }

    public static boolean isMobileElementSelected(By locator, String data, String logstep) {
        WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), 30);
        MobileElement elm = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        try {
            Assert.assertEquals(elm.getAttribute("selected"), data);
            KeywordUtil.lastAction = logstep + data + " attribute text matched ";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            //RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));
            return true;
        } catch (Throwable t) {
            KeywordUtil.lastAction = logstep + data + " attribute text mismatched ";
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            return false;
        }
    }

    public static boolean writeInInput(By locator, String data, String logstep) {
        WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), 20);
        MobileElement elm = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        try {
            elm.sendKeys(data);
            LogUtil.infoLog(KeywordUtil.class, logstep + " passed Successfully");
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logstep + " passed Successfully"));
            return true;
        } catch (Throwable t) {
            LogUtil.infoLog(KeywordUtil.class, logstep + " failed to pass");
            RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor(logstep + " failed to pass"));
            return false;
        }
    }

    public static boolean writeInInput(By locator, BigDecimal data, String logstep) {
        WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), 20);
        MobileElement elm = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        try {
            //isMobileElementVisible(locator, logstep);
            elm.sendKeys(data.toString());
            LogUtil.infoLog(KeywordUtil.class, logstep + " passed Successfully ");
            //RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));
            return true;
        } catch (Throwable t) {
            LogUtil.infoLog(KeywordUtil.class, logstep + " failed to pass ");
            return false;
        }
    }

    public static boolean writeInInputList(By locator, String data, String logstep) {
        try {
            click(locator, " text field ");
            List<MobileElement> elements = (List<MobileElement>) GlobalUtil.getMDriver().findElements(locator);
            String[] value = data.split("");
            int i = 0;
            for (MobileElement element : elements) {
                element.sendKeys(value[i]);
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(value[i] + " entered successfully into field"));
                LogUtil.infoLog(thisClass, value[i] + " entered successfully into field");
                i++;
            }
            return true;
        } catch (Throwable t) {
            RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor(data + " unable to pass into field"));
            LogUtil.infoLog(thisClass, data + " couldn't be entered into field");
            return false;
        }
    }

    public static void findAndClickElement(By locator, int number, String logstep) {
        List<MobileElement> elements = (List<MobileElement>) GlobalUtil.getMDriver().findElements(locator);
        try {
            int i = 0;
            while (i <= elements.size()) {
                if (i == number) {
                    elements.get(number).click();
                    LogUtil.infoLog(thisClass, " Tapped on " + logstep);
                    RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(" Tapped on " + logstep));
                    break;
                } else {
                    i++;
                }
            }
        } catch (Throwable t) {
            LogUtil.infoLog(thisClass, logstep + " could not be located ");
            RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor(logstep + " could not be located "));
        }
    }

    public static boolean click(By locator, String logStep) {
        WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), 70);
        WebElement elm = wait.until(ExpectedConditions.elementToBeClickable(locator));
        KeywordUtil.lastAction = " Click on " + logStep;
        LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
        if (elm == null) {
            return false;
        } else {
            elm.click();
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(KeywordUtil.lastAction));
            return true;
        }
    }

    public static void backButtonOnDevice() {
        GlobalUtil.getMDriver().navigate().back();
        LogUtil.infoLog(KeywordUtil.class, " Back button on device is pressed ");
    }

    public static void isMobileKeypadVisible() {
        try {
            Assert.assertTrue(GlobalUtil.getAndroidDriver().isKeyboardShown());
            LogUtil.infoLog(thisClass, " Mobile Keypad is visible ");
        } catch (Throwable t) {
            LogUtil.infoLog(thisClass, " Mobile Keypad not visible ");
        }
    }

    public static double convertAndTranslateStringToDouble(String data) {
        String[] special = data.split("\\$");
        String[] breaker = special[1].split(",");

        StringBuilder builder = new StringBuilder();
        for (String s : breaker) {
            builder.append(s);
        }

        System.out.println("Data from builder : " + builder);
        return Double.parseDouble(builder.toString());
    }

    public static void notNull(By locator) {
        WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), 20);
        MobileElement elm = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        try {
            Assert.assertNull(elm);
            LogUtil.infoLog(thisClass, " contains text");
        } catch (Throwable t) {
            LogUtil.infoLog(thisClass, " Do not contains text ");
        }
    }

    public static void delay() {
        WebDriverWait wait = new WebDriverWait(GlobalUtil.getMDriver(), 5);
        MobileElement elm = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("abc123")));
        try {

        } catch (Exception e) {

        }
    }
}


