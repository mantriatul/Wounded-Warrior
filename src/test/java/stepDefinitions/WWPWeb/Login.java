package stepDefinitions.WWPWeb;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import constants.web.Constant;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.web.Wwp;
//import pages.web.WwpPages.Wwp;
//import pages.web.WwpPages.Wwp;
import stepDefinitions.RunCukesTest;
import utilities.*;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Login extends KeywordUtil {

    public static HashMap<String, String> dataMap = new HashMap<String, String>();

    @Given("Read the testdata {string} from excel file")
    public void readTheTestdataFromExcelFile(String arg1) {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("WWP", arg1);

    }

    @And("User navigates to the url")
    public void userNavigatesToTheUrl() {

      //  GlobalUtil.setDriver(DriverUtil.invokeLocalBrowserWeb(Constant.ENVIRONMENT, Constant.BROWSER));
       KeywordUtil.navigateToUrl(dataMap.get("URL"));
       // KeywordUtil.navigateToUrl("https://wwp--wdxuat.sandbox.my.site.com/WDX/s/login/?language=en_US");
    }

    @Then("Logo is visible")
    public void logo_is_visible() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(isWebElementsVisible(Wwp.loginPageLogo,"Logo"));

    }

    @Then("Verify login page text, labels, links and buttons")
    public void loginpage_elements_displayed() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(isWebElementsVisible(Wwp.loginPageLogo,"Wwp Logo"));
        Assert.assertTrue(isWebElementsVisible(Wwp.loginLabel,"Login label"));
        Assert.assertTrue(isWebElementsVisible(Wwp.welcomeText,"Welcome Text"));
        Assert.assertTrue(isWebElementsVisible(Wwp.emailInput,"email input field"));
        Assert.assertTrue(isWebElementsVisible(Wwp.passwordInput,"password input field"));
        Assert.assertTrue(isWebElementsVisible(Wwp.loginButton,"Login button"));
        Assert.assertTrue(isWebElementsVisible(Wwp.createAccountLink,"Create account link"));
        Assert.assertTrue(isWebElementsVisible(Wwp.forgotPasswordLink,"Forgot password link"));
        Assert.assertTrue(isWebElementsVisible(Wwp.registerTextOnLoginPage,"Register text"));
    }

    @And("user clicks on login button")
    public void user_clicks_on_login_button(){
        click(Wwp.loginButton,"login button");
    }

    @Then("user unable to login with blank field")
    public void unable_to_login_with_blank_field() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(isWebElementsVisible(Wwp.blankEmailError,"blank email error"));
        Assert.assertTrue(isWebElementsVisible(Wwp.blankPasswordError,"blank password error"));

    }

    @And("user clicks on login button with invalid credentials as {string} and {string}")
    public void clicks_on_login_button_with_invalid_credentials(String email , String password) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(isWebElementsVisible(Wwp.loginPageLogo,"Wwp Logo"));
        inputText(Wwp.emailInput,email,"given invalid email address");
        inputText(Wwp.passwordInput,password,"given invalid password");
        click(Wwp.loginButton,"click on login button");
    }

    @Then("user unable to login with invalid credentials")
    public void unable_to_login_with_invalid_credentials() throws InterruptedException{
        Thread.sleep(3000);
        Assert.assertTrue(isWebElementsVisible(Wwp.invalidCredentialError,"invalid credentials error"));
    }

    @When("User clicks on veterans crisis helpline number")
    public void clicks_on_helplineNumber() throws InterruptedException, AWTException {
        isWebElementsVisible(Wwp.loginPageLogo,"page is open");

        click(Wwp.veteranHelplineNumber,"click on veteran helpline number");
        Thread.sleep(4000);
//     acceptAlert();
        Robot robot = new Robot();
        robot.mouseMove((int) 757.5625,230); // Navigating through mouse hover. Note that the coordinates might differ, kindly check the coordinates of x and y axis and update it accordingly.
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(6000);


    }


    @And("User click on create account")
    public void CreateAccount() throws InterruptedException,AWTException {
        click(Wwp.createAccountLink,"click on create account");
        Thread.sleep(2000);
        isWebElementVisible(Wwp.createAccountPageHeading,"create account page");
        String text= getElementText(Wwp.createAccountPageHeading);
        System.out.print(text);
        Assert.assertEquals(text,"Create Your Account");
    }

    @When("user enter {string} as {string}")
    public void user_enter_as(String field, String data) {

        inputText(Wwp.createAccountPAge(field), data, "Enters the " + data + " in the " + field);

    }

    @And("Verify create account fields")
    public void CreateAccountFields() throws InterruptedException,AWTException {

        isWebElementVisible(Wwp.firstNameUnderCreateAccount,"First Name field");
        isWebElementVisible(Wwp.lastNameUnderCreateAccount,"Last Name field");
        isWebElementVisible(Wwp.emailUnderCreateAccount,"Email field");
        isWebElementVisible(Wwp.continueButtonUnderCreateAccount,"Continue button");

    }

    @And("User clicks on continue button")
    public void click_on_continue_button() {

        click(Wwp.continueButtonUnderCreateAccount, "click on continue button");
    }
    @And("User clicks on continue button and verify")
    public void ClickAndVerify_on_continue_button() {

        click(Wwp.continueButtonUnderCreateAccount, "click on continue button");

        String expected = "Great! The information you entered matches our records. One more step to create a password. Please check your email for a message from Wounded Warrior Project with a link to create your password.";
        if(getElementText(Wwp.createAccountsuccessMessage).equalsIgnoreCase(expected)){
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.format(expected)));
        }
        else{
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.format("Input is required")));


        }


    }

    @And("verify error msg when user is not registered in wwp")
    public void verifyErrorMsg() {

           isWebElementsVisible(Wwp.invalidCredentialError,"We could not find an account with that information.");
    }

    @Then("verify {string} is required")
    public void VerifyFieldIsEmpty(String data) {

        String text = getText(Wwp.errorMessageFields(data));
        Assert.assertEquals(text,data +" is required");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(data + " is required"));

    }

    @And("user enters {string} as {string}")
    public void enter_data_in_login_input_field(String fieldname,String data) throws InterruptedException {
        inputText(Wwp.loginInputField(fieldname),data,data+"in "+fieldname);
        Thread.sleep(3000);
    }




    @And("User login to the Wounded Warrior")
    public void  Login() throws InterruptedException {
        inputText(Wwp.emailInput,dataMap.get("Username") ,""+dataMap.get("Username")+" username is entered");

        inputText(Wwp.passwordInput,dataMap.get("Password") ,""+dataMap.get("Password")+"password is entered");

        click(Wwp.loginButton,"Click on login button");
        Thread.sleep(5000);
        if(isWebElementPresent(Wwp.bannerImage,"")==true){
       Assert.assertTrue(isWebElementVisible(Wwp.bannerImage,"Wounded Warrior Project page"));
        }
        else {
            Assert.assertTrue(isWebElementVisible(Wwp.logoQuiz,"Quiz get started"));
        }

    }

    @And("Secondary User login to the Wounded Warrior")
    public void  SecondUserLogin()
    {
        inputText(Wwp.emailInput,dataMap.get("Username2") ,""+dataMap.get("Username2")+" username is entered");

        inputText(Wwp.passwordInput,dataMap.get("Password2") ,""+dataMap.get("Password2")+"password is entered");

        click(Wwp.loginButton,"Click login button");
        Assert.assertTrue(isWebElementVisible(Wwp.bannerImage,"Wounded Warrior Project page"));
    }

    @And("Open to the outlook and Get URL to reset password")
    public void userNavigatesToEmailAndGetURL() throws InterruptedException {
        String outlookUrl = ConfigReader.getValue("outlookUrl");
        String username = ConfigReader.getValue("Username");
        String password = ConfigReader.getValue("Password");
        KeywordUtil.navigateToUrl(outlookUrl);
        Thread.sleep(10000);
        inputText(Wwp.emailUsername,username,"Email Username is entered");
        click(Wwp.emailNext,"");
        inputText(Wwp.emailPassword,password,"Email password is entered");
        click(Wwp.emailSubmit,"");
        Thread.sleep(5000);
        click(Wwp.emailSignupOption,"");
        Thread.sleep(5000);
        try{
            click(Wwp.emailRegisteredOne,"click on email logo");
        }
        catch (Exception e){

        }
        try {
            click(Wwp.clickOutlook, "click on outlook");
            Thread.sleep(10000);
            switchToMultipleWindow();
        }
        catch (Exception e){

        }
        Thread.sleep(8000);
        click(Wwp.emailMessage,"");
        Thread.sleep(8000);
        String text = getElementText(Wwp.emailBodyText).split("to: ")[1];
        System.out.println(text);
        KeywordUtil.navigateToUrl(text);
    }

    @And("Click on Reset the password & Verify the fields")
    public void resetThePassword(){
        click(Wwp.resetBtn,"");
        isWebElementVisible(Wwp.resetPwdTitle,"Choose your password page");
        isWebElementVisible(Wwp.passwordInput,"Password");
        isWebElementVisible(Wwp.retypePwd,"RetypePassword");
        isWebElementVisible(Wwp.createPassword,"Create password button");
        isWebElementVisible(Wwp.termsAndConditions,"Terms & conditions");
        isWebElementVisible(Wwp.privacyPolicy,"Private policy");
    }

    @And("Verify Privacy policy & term & conditions fields")
    public void verifyPolicyField() throws InterruptedException {
        click(Wwp.resetBtn,"");
        isWebElementVisible(Wwp.resetPwdTitle,"Choose your password page");
        click(Wwp.termsAndConditions,"Terms & conditions");
        switchToMultipleWindow();
        isWebElementsVisible(Wwp.termsAndConditionsPage,"Terms & conditions");
        Thread.sleep(2000);
        switchToWindow();
        click(Wwp.privacyPolicy,"Private policy");
        isWebElementsVisible(Wwp.privacyPolicyPage,"Private policy");

    }

    @And("Verify password created successfully")
    public void PasswordCreated(){
        String wwpPassword = ConfigReader.getValue("WWPPassword");
        click(Wwp.resetBtn,"");
        isWebElementVisible(Wwp.resetPwdTitle,"Choose your password page");
        inputText(Wwp.passwordInput,wwpPassword,"Password");
        inputText(Wwp.retypePwd,wwpPassword,"RetypePassword");
        String pwdVal1 = getElementText(Wwp.pwdValidationMsg(1));
        String pwdVal2 = getElementText(Wwp.pwdValidationMsg(2));
        String pwdVal3 = getElementText(Wwp.pwdValidationMsg(3));
        String retypePwdVal = getElementText(Wwp.retypePwdvalidationMsg);

        isWebElementVisible(Wwp.pwdValidationMsg(1),pwdVal1);
        isWebElementVisible(Wwp.pwdValidationMsg(2),pwdVal2);
        isWebElementVisible(Wwp.pwdValidationMsg(3),pwdVal3);
        isWebElementVisible(Wwp.retypePwdvalidationMsg,retypePwdVal);


        click(Wwp.createPassword,"Create password button");
        isWebElementVisible(Wwp.passwordChangedMsg,"Password has been changed");
        isWebElementVisible(Wwp.launchHomePage,"Continue to Home Page");
        isWebElementVisible(Wwp.veteransHelpline,"Veteran helpline number");
    }

    @And("Launch the Home page")
    public void homePageLaunched() throws InterruptedException {
        click(Wwp.launchHomePage,"Continue to Home Page");
        Thread.sleep(4000);
        Assert.assertTrue(isWebElementsVisible(Wwp.welcomeTextOnForYou,"welcome text"));

    }
    @And("Verify the password masking functionality")
    public void  passwordMaskingVerification()
    {
        inputText(Wwp.emailInput,dataMap.get("Username") ,"Enter Username /email");
        inputText(Wwp.passwordInput,dataMap.get("Password") ,"Enter Password");

        if (getAttributevalue(Wwp.passwordMasking,"type").equalsIgnoreCase("password")){
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor( "Password is masked"));

        }else {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Password is not masked"));

        }
        Assert.assertTrue(isWebElementVisible(Wwp.closeEye,"Password masking remain consistent"));
    }


    @And("Logout the user")
    public void logout() throws InterruptedException {
        isWebElementVisible(Wwp.profile,"User profile");
        click(Wwp.profile,"click user profile");
        click(Wwp.logout,"Click on logout button");
        isWebElementVisible(Wwp.logintitle,"Page is logout");

    }

    @And("User click on Forgot Password")
    public void ForgotPassword(){
        isWebElementVisible(Wwp.forgotPwdLink,"Forgot password");
        click(Wwp.forgotPwdLink,"click on forgot password link");
        Assert.assertTrue(isWebElementVisible(Wwp.backBtn,"Back button"));
        Assert.assertTrue(isWebElementVisible(Wwp.forgotPwdTitle,"Forgot password title"));
        Assert.assertTrue(isWebElementVisible(Wwp.emailInput,"Email input"));
        Assert.assertTrue(isWebElementVisible(Wwp.resetPwdBtn,"Reset Button"));

    }
    @And("User click on Reset Button")
    public void resetBtn(){
       click(Wwp.resetPwdBtn,"click on Reset Button");

    }

    @And("User click on Reset Button and verify")
    public void resetBtnAndVerifySuccessMsg(){
        click(Wwp.resetPwdBtn,"click on Reset Button");
        String text = "We've sent you an email with a link to finish resetting your password.\n" +
                "\n" +
                "Can't find the email? Try checking your spam folder.\n" +
                "\n" +
                "If you still can't log in, please call the WWP Resource Center at 888.997.2586, or email us at resourcecenter@woundedwarriorproject.org";
        Assert.assertEquals(getElementText(Wwp.successMessage),text);

    }

    @And("Logout from the Account")
    public void Logout_from_the_account() throws InterruptedException {
        Thread.sleep(2000);
        scrollingToElementofAPage(Wwp.userProfileIcon,"");
        hoverOnElement(Wwp.userProfileIcon);
        click(Wwp.userProfileIcon,"user icon");
        hoverOnElement(Wwp.logoutLink);
        click(Wwp.logoutLink,"logout link");
        Thread.sleep(5000);
    }

    @And("Verify password reset successfully")
    public void PasswordCreatedreset() throws InterruptedException {
        Thread.sleep(2000);
        String wwpPassword = ConfigReader.getValue("WWPPassword");
        isWebElementVisible(Wwp.resetPwdTitle,"Choose your password page");
        inputText(Wwp.passwordInput,wwpPassword,"Password");
        inputText(Wwp.retypePwd,wwpPassword,"RetypePassword");
        click(Wwp.createPassword,"Create password button");
        Thread.sleep(2000);
        isWebElementVisible(Wwp.launchHomePage,"Continue to Home Page");
        isWebElementVisible(Wwp.veteransHelpline,"Veteran helpline number");
    }

}
