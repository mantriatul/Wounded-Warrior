package stepDefinitions.WWPiOS;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.java.Log;
import org.testng.Assert;
import pages.iOS.WwpPages.LoginPage;
import pages.web.Wwp;
import stepDefinitions.RunCukesTest;
import utilities.DriverUtil;
import utilities.ExcelDataUtil;
import utilities.HTMLReportUtil;

import java.util.HashMap;

import static mobileutil.MobileKeywords.*;
import static utilities.KeywordUtil.*;

public class Login {
    public static HashMap<String ,String> dataMap = new HashMap<>();

    @When("User launches the application on iOS {string}")
    public void userLaunchesTheApplicationOniOS(String deviceName) {
        DriverUtil.browserStackIOSApp(deviceName);
    }

    @When("Enter Username and Password into the input box as {string} and {string}")
    public void enter_username_and_password_into_the_input_box_as_and(String email, String password) {
        inputTextIos(LoginPage.emailBox,email,"given invalid email address");
        inputTextIos(LoginPage.passwordBox,password,"given invalid password");

    }
    @When("Click on signIn Button")
    public void click_on_sign_in_button() {
        try {
            clickIos(LoginPage.returnButtonOnKeyBoard, "click on return button");
        }catch (Exception e){
            System.out.println("Keyboard is not displaying");
        }
        clickIos(LoginPage.signInButton, "click on login button");
    }
    @Then("User should navigate to home page")
    public void user_should_navigate_to_home_page() {
        clickIos(LoginPage.donNotAllow,"Click on notification popup");
        waitForVisibleIosMobile(LoginPage.myProfile);
    }

    @When("User clicks on veterans crisis helpline number on ios")
    public void user_clicks_on_veterans_crisis_helpline_number_on_ios() {
        waitForVisibleIosMobile(LoginPage.veteranCrisisLine);
    }

    @Then("Logo is visible on ios")
    public void logo_is_visible_on_ios() {
        waitForVisibleIosMobile(LoginPage.homePageLogo);
    }

    @Then("Verify login page text, labels, links and buttons on ios")
    public void verify_login_page_text_labels_links_and_buttons_on_ios() {
        waitForVisibleIosMobile(LoginPage.homePageLogo);
        waitForVisibleIosMobile(LoginPage.emailBox);
        waitForVisibleIosMobile(LoginPage.passwordBox);
        waitForVisibleIosMobile(LoginPage.bioMetrics);
        waitForVisibleIosMobile(LoginPage.forgotPassword);
        waitForVisibleIosMobile(LoginPage.getStartedLink);
        waitForVisibleIosMobile(LoginPage.needHelp);
    }

    @Then("user unable to login with blank field on ios")
    public void user_unable_to_login_with_blank_field_on_ios() {
        waitForVisibleIosMobile(LoginPage.emailError);
    }

    @Then("Verify the password masking functionality on ios")
    public void verify_the_password_masking_functionality_on_ios() {
        {
            inputTextIos(LoginPage.emailBox,"atul.mantri@testingxperts.com" ,"Enter Username /email");
            inputTextIos(LoginPage.passwordBox,"Test@1234" ,"Enter Password");

            if (getAttributevalue(LoginPage.passwordMasking,"type").equalsIgnoreCase("secure")){
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor( "Password is masked"));

            }else {
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Password is not masked"));

            }
            Assert.assertTrue(isIosMobileElementVisible(LoginPage.closeEye,"Password masking remain consistent"));
        }
    }

    @When("user clicks on login button with invalid credentials as {string} and {string} on ios")
    public void user_clicks_on_login_button_with_invalid_credentials_as_and_on_ios(String email, String password) {
        waitForVisibleIosMobile(LoginPage.homePageLogo);
        inputTextIos(LoginPage.emailBox,email,"given invalid email address");
        inputTextIos(LoginPage.passwordBox,password,"given invalid password");
        clickIos(LoginPage.signInButton,"click on login button");
    }
    @Then("user unable to login with invalid credentials on ios")
    public void user_unable_to_login_with_invalid_credentials_on_ios() {
        waitForVisibleIosMobile(LoginPage.invalidCredentialError);
    }
}
