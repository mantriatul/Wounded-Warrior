package stepDefinitions.WWPWeb;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import constants.web.Constant;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.web.WwpPages.LoginPages;
import utilities.DriverUtil;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;
import utilities.KeywordUtil;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.HashMap;

public class Login extends KeywordUtil {

    public static HashMap<String, String> dataMap = new HashMap<String, String>();

    @Given("Read the testdata {string} from excel file")
    public void readTheTestdataFromExcelFile(String arg1) {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("WelMart", arg1);

    }

    @And("User navigates to the url")
    public void userNavigatesToTheUrl() {

        GlobalUtil.setDriver(DriverUtil.invokeLocalBrowserWeb(Constant.ENVIRONMENT, Constant.BROWSER));
        KeywordUtil.navigateToUrl(dataMap.get("URL"));

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
}
