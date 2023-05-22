package stepDefinitions.WWPWeb;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import constants.web.Constant;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.web.WwpPages.Homepage;
import pages.web.WwpPages.LoginPages;
import stepDefinitions.RunCukesTest;
import utilities.*;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.HashMap;

public class Login extends KeywordUtil {

    public static HashMap<String, String> dataMap = new HashMap<String, String>();

    @Given("Read the testdata {string} from excel file")
    public void readTheTestdataFromExcelFile(String arg1) {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Nykaa", arg1);

    }

    @And("User navigates to the url")
    public void userNavigatesToTheUrl() {

        GlobalUtil.setDriver(DriverUtil.invokeLocalBrowserWeb(Constant.ENVIRONMENT, Constant.BROWSER));
        KeywordUtil.navigateToUrl(dataMap.get("URL"));
//        KeywordUtil.navigateToUrl("https://wwp--wdxuat.sandbox.my.site.com/WDX/s/login/?language=en_US");
    }

    @Then("Logo is visible")
    public void logo_is_visible() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(isWebElementsVisible(LoginPages.loginPageLogo,"Logo"));

    }

    @Then("Verify login page text, labels, links and buttons")
    public void loginpage_elements_displayed() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(isWebElementsVisible(LoginPages.loginPageLogo,"Homepage Logo"));
        Assert.assertTrue(isWebElementsVisible(LoginPages.loginLabel,"Login label"));
        Assert.assertTrue(isWebElementsVisible(LoginPages.welcomeText,"Welcome Text"));
        Assert.assertTrue(isWebElementsVisible(LoginPages.emailInput,"email input field"));
        Assert.assertTrue(isWebElementsVisible(LoginPages.passwordInput,"password input field"));
        Assert.assertTrue(isWebElementsVisible(LoginPages.loginButton,"Login button"));
        Assert.assertTrue(isWebElementsVisible(LoginPages.createAccountLink,"Create account link"));
        Assert.assertTrue(isWebElementsVisible(LoginPages.forgotPasswordLink,"Forgot password link"));
        Assert.assertTrue(isWebElementsVisible(LoginPages.registerTextOnLoginPage,"Register text"));
    }

    @And("user clicks on login button")
    public void user_clicks_on_login_button(){
        click(LoginPages.loginButton,"login button");
    }

    @Then("user unable to login with blank field")
    public void unable_to_login_with_blank_field() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(isWebElementsVisible(LoginPages.blankEmailError,"blank email error"));
        Assert.assertTrue(isWebElementsVisible(LoginPages.blankPasswordError,"blank password error"));

    }

    @And("user clicks on login button with invalid credentials as {string} and {string}")
    public void clicks_on_login_button_with_invalid_credentials(String email , String password) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(isWebElementsVisible(LoginPages.loginPageLogo,"Homepage Logo"));
        inputText(LoginPages.emailInput,email,"given invalid email address");
        inputText(LoginPages.passwordInput,password,"given invalid password");
        click(LoginPages.loginButton,"click on login button");
    }

    @Then("user unable to login with invalid credentials")
    public void unable_to_login_with_invalid_credentials() throws InterruptedException{
        Thread.sleep(3000);
        Assert.assertTrue(isWebElementsVisible(LoginPages.invalidCredentialError,"invalid credentials error"));
    }

    @When("User clicks on veterans crisis helpline number")
    public void clicks_on_helplineNumber() throws InterruptedException, AWTException {
        isWebElementsVisible(LoginPages.loginPageLogo,"page is open");

        click(LoginPages.veteranHelplineNumber,"click on veteran helpline number");
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
        click(LoginPages.createAccountLink,"click on create account");
        Thread.sleep(2000);
        isWebElementVisible(LoginPages.createAccountPageHeading,"create account page");
        String text= getElementText(LoginPages.createAccountPageHeading);
        System.out.print(text);
        Assert.assertEquals(text,"Create Your Account");
    }

    @When("user enter {string} as {string}")
    public void user_enter_as(String field, String data) {

        inputText(LoginPages.createAccountPAge(field), data, "Enters the " + data + " in the " + field);

    }

    @And("Verify create account fields")
    public void CreateAccountFields() throws InterruptedException,AWTException {

        isWebElementVisible(LoginPages.firstNameUnderCreateAccount,"First Name field");
        isWebElementVisible(LoginPages.lastNameUnderCreateAccount,"Last Name field");
        isWebElementVisible(LoginPages.emailUnderCreateAccount,"Email field");
        isWebElementVisible(LoginPages.continueButtonUnderCreateAccount,"Continue button");

    }

    @And("User clicks on continue button")
    public void click_on_continue_button() {

        click(LoginPages.continueButtonUnderCreateAccount,"click on continue button");
    }

    @Then("verify {string} is required")
    public void click_on_continue_button(String data) {

        String text = getText(LoginPages.errorMessageFields(data));
        Assert.assertEquals(text,data +" is required");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(data + " is required"));

    }

    @And("user enters {string} as {string}")
    public void enter_data_in_login_input_field(String fieldname,String data) throws InterruptedException {
        inputText(LoginPages.loginInputField(fieldname),data,data+"in "+fieldname);
        Thread.sleep(3000);
    }

    @Then("user can view the default view")
    public void user_can_view_default_view_on_forYou() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(isWebElementsVisible(Homepage.welcomeTextOnForYou,"welcome text"));

    }

    @And("verify homepage header menu are clickable")
    public void Header_link_is_clickable() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wt=new WebDriverWait(GlobalUtil.getDriver(), 10);
        try {
            wt.until(ExpectedConditions.elementToBeClickable(Homepage.homepageHeaderLink("For You")));
            System.out.println("For You  to be clickable");
            wt.until(ExpectedConditions.elementToBeClickable(Homepage.homepageHeaderLink("Browse All")));
            System.out.println(" Browse All element to be clickable");
            wt.until(ExpectedConditions.elementToBeClickable(Homepage.homepageHeaderLink("People")));
            System.out.println("People element to be clickable");
            wt.until(ExpectedConditions.elementToBeClickable(Homepage.homepageHeaderLink("Groups")));
            System.out.println(" groups element to be clickable");
            wt.until(ExpectedConditions.elementToBeClickable(Homepage.homepageHeaderLink("Notifications")));
            System.out.println(" notifications element to be clickable");
            wt.until(ExpectedConditions.elementToBeClickable(Homepage.homepageHeaderLink("Support")));
            System.out.println(" support element to be clickable");
            wt.until(ExpectedConditions.elementToBeClickable(Homepage.homepageHeaderLink("Messages")));
            System.out.println(" messages element to be clickable");
            wt.until(ExpectedConditions.elementToBeClickable(Homepage.crisisLine));
            System.out.println("crisis line to be clickable");
            wt.until(ExpectedConditions.elementToBeClickable(Homepage.userProfileIcon));
            System.out.println("user profile icon to be clickable");
        }
        catch (Exception e){
            System.out.println("element not clickable");
        }

        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(" homepage header elements are clickable"));
    }

    @And("verify homepage banner is visible")
    public void homepage_banner_is_visible()
    {
        Assert.assertTrue(isWebElementsVisible(Homepage.bannerImage,"homepage banner "));

    }

    @And("verify filters are clickable on For You")
    public void verify_For_You_Page_filters_are_clickable()
    {
        WebDriverWait wt=new WebDriverWait(GlobalUtil.getDriver(), 10);
        try {
            wt.until(ExpectedConditions.elementToBeClickable(Homepage.forYouFilters("All")));
            System.out.println("All  to be clickable");
            wt.until(ExpectedConditions.elementToBeClickable(Homepage.forYouFilters("Near Me")));
            System.out.println("Near Me");
            wt.until(ExpectedConditions.elementToBeClickable(Homepage.forYouFilters("Virtual")));
            System.out.println("Virtual");

        }
        catch (Exception e){
            System.out.println("element not clickable");
        }
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("For You filters are clickable"));
    }

    @And("verify content on Homepage Banner with username {string}")
    public void content_verify_on_homepage_banner(String username) throws InterruptedException
    {
        Thread.sleep(10000);
        String banner_title = getText(Homepage.homepageBannerTitle);
        System.out.println(banner_title);
        Assert.assertEquals(banner_title,"Welcome, "+username);
        String bannersubtitle = getText(Homepage.homepageBannerSubTitle);
        Assert.assertEquals(bannersubtitle,"Events, Service Offerings & Community Partnerships For You");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("homepage content is visible"));
    }

    @And("User login to the Wounded Warrior")
    public void  Login()
    {
        inputText(LoginPages.emailInput,dataMap.get("Username") ,"Enter Username /email");
        inputText(LoginPages.passwordInput,dataMap.get("Password") ,"Enter Password");
        click(LoginPages.loginButton,"Click login button");
        Assert.assertTrue(isWebElementVisible(Homepage.bannerImage,"Wounded Warrior Project page"));
    }
}
