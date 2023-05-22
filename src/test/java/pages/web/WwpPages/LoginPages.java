package pages.web.WwpPages;

import org.openqa.selenium.By;

public class LoginPages {

    public static By veteranHelplineNumber = By.xpath("(//a[@title=\"988\"])[1]");

    public static By loginPageLogo = By.xpath("//img[@src='/WDX/resource/1680871917000/WWP_Portal_Assets/icon/wwp1_logo_black_1.png']");

    public static By loginLabel = By.xpath("//div[text()='Log in']");

    public static By emailInput = By.xpath("//input[@placeholder='Email/Username']");

    public static By passwordInput =By.xpath("//input[@placeholder='Password']");

    public static By loginButton = By.xpath("//button[@title='Log In']");

    public static By createAccountLink = By.xpath("//span[text()='Create Account']");

    public static By forgotPasswordLink = By.xpath("//a[@title='Forgot password?']");

    public static By invalidCredentialError=  By.xpath("//span[text()='Your login attempt has failed. Make sure the username and password are correct.']");

    public static By blankEmailError = By.xpath("//span[text()='Email/Username is required']");
    public static By blankPasswordError = By.xpath("//span[text()='Password is required']");

    public static By welcomeText = By.xpath("//div[text()='Welcome back! Please enter your email/username and password to log in.']");

    public static By registerTextOnLoginPage = By.xpath("//div[text()='Registered with Wounded Warrior Project®, but first time logging in?']");

    public static By createAccountPageHeading = By.xpath("//div[text()='Create Your Account']");

    public static By lastNameUnderCreateAccount = By.xpath("//input[@placeholder='Last name']");

    public static By emailUnderCreateAccount = By.xpath("//input[@placeholder='Email']");

    public static By firstNameUnderCreateAccount = By.xpath("//input[@placeholder='First name']");

    public static By continueButtonUnderCreateAccount = By.xpath("//button[@title='Continue']");

    public static By loginInputField(String fieldname){
        return By.xpath("//input[@placeholder='"+fieldname+"']");
    }

}
