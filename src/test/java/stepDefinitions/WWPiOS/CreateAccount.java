package stepDefinitions.WWPiOS;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobileutil.MobileKeywords;
import pages.iOS.WwpPages.LoginPage;
import pages.web.Wwp;
import stepDefinitions.RunCukesTest;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

import static mobileutil.MobileKeywords.clickIos;
import static mobileutil.MobileKeywords.isMobileKeypadVisible;

public class CreateAccount extends KeywordUtil {

    @When("User click on create account on ios app")
    public void user_click_on_create_account_on_ios_app() throws InterruptedException {
        MobileKeywords.clickIos(LoginPage.getStartedLink,"Clicking on Get started link");
        Thread.sleep(2000);
        MobileKeywords.isIosMobileElementVisible(LoginPage.createYourAccountHeading,"Create your Account Heading is visible");
    }

    @When("Verify create account fields on ios app")
    public void verify_create_account_fields_on_ios_app() {
        MobileKeywords.isIosMobileElementVisible(LoginPage.firstName,"First Name field");
        MobileKeywords.isIosMobileElementVisible(LoginPage.lastName,"Last Name field");
        MobileKeywords.isIosMobileElementVisible(LoginPage.email,"Email field");
        MobileKeywords.isIosMobileElementVisible(LoginPage.continueButtonUnderCreateAccount,"Continue button");
    }
    @When("user enter {string} as {string} on ios app")
    public void user_enter_as_on_ios_app(String field, String data) {
        inputTextIos(LoginPage.createAccountPage(field),data,"Enters the " + data + " in the " + field);
    }
    @When("User clicks on continue button on ios app")
    public void user_clicks_on_continue_button_on_ios_app() {
        clickIos(LoginPage.returnButtonOnKeyBoard, "click on return button");
        MobileKeywords.clickIos(LoginPage.continueButtonUnderCreateAccount,"Click on Continue button");
    }
    @Then("verify email is required on ios app")
    public void verify_email_is_required_on_ios_app() {
        MobileKeywords.textAssertionOnIos(LoginPage.pleaseEnterValidEmailError,"Please enter a valid Email.");
    }

    @Then("verify last name is required on ios app")
    public void verify_last_name_is_required_on_ios_app() {
        MobileKeywords.textAssertionOnIos(LoginPage.lastNameRequiredError,"Last name is required.");
    }

    @Then("Verify Create Account functionality")
    public void verify_create_account_functionality() {
        String expected = "Great! The information you entered matches our records. One more step to create a password. Please check your email for a message from Wounded Warrior Project with a link to create your password.";
        if(MobileKeywords.textAssertionOnIos(LoginPage.successStatus,expected));
    }


}
