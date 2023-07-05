package pages.iOS.WwpPages;

import org.openqa.selenium.By;

public class LoginPage {

    public static By emailBox = By.xpath("//XCUIElementTypeTextField[@name=\"Email/Username\"]");

    public static By passwordBox = By.xpath("//XCUIElementTypeOther[@name=\"Password\"]/XCUIElementTypeSecureTextField");

    public static By signInButton = By.xpath("//XCUIElementTypeButton[@name=\"Sign In\"]");
    public static By returnButtonOnKeyBoard = By.xpath("//XCUIElementTypeButton[@name=\"Return\"]");
    public static By donNotAllow = By.xpath("//XCUIElementTypeButton[@name=\"Don’t Allow\"]");
    public static By myProfile = By.xpath("//XCUIElementTypeOther[@name=\"My Profile.\"]");
    public static By getStartedLink = By.xpath("(//XCUIElementTypeOther[@name=\"Get started button.\"])[2]");
    public static By createYourAccountHeading = By.xpath("//XCUIElementTypeStaticText[@name=\"Create your account\"]");
    public static By firstName =By.xpath("//XCUIElementTypeTextField[@name='First name.']");
    public static By lastName =By.xpath("//XCUIElementTypeTextField[@name='Last name.']");
    public static By email =By.xpath("//XCUIElementTypeTextField[@name=\"Email\"]");
    public static By continueButtonUnderCreateAccount = By.xpath("//XCUIElementTypeButton[@name=\"Continue\"]");
    public static By createAccountPage(String data) {
        return By.xpath("//XCUIElementTypeTextField[@name='" + data + "']");
    }

    public static By pleaseEnterValidEmailError = By.xpath("//XCUIElementTypeStaticText[@name=\"Please enter a valid Email.\"]");
    public static By lastNameRequiredError = By.xpath("//XCUIElementTypeStaticText[@name=\"Last name is required.\"]");
    public static By successStatus= By.xpath("//XCUIElementTypeStaticText[contains(@name,\"Great!\")]");
    public static By veteranCrisisLine =By.xpath("(//XCUIElementTypeOther[@name=\"Veteran Crisis Line - Dial 988 & Press 1. Double tap to dial.\"])[2]");
    public static By homePageLogo = By.xpath("(//XCUIElementTypeOther[contains(@name,\"Button Sign In\")]//XCUIElementTypeImage)[1]");
    public static By bioMetrics = By.xpath("//XCUIElementTypeOther[@name=\"Use Biometrics. Button\"]");
    public static By forgotPassword = By.xpath("//XCUIElementTypeOther[@name=\"Forgot Password?. Button\"]");
    public static By needHelp = By.xpath("//XCUIElementTypeOther[@name=\"Need Help?. Button\"]");

    public static By emailError = By.xpath("(//XCUIElementTypeOther[@name=\"Error Username is required.\"])[1]");
    public static By passwordError = By.xpath("(//XCUIElementTypeOther[@name=\"Error Password is required.\"])[1]");

    public static By closeEye = By.xpath("(//XCUIElementTypeOther[@name=\"Hide or Show Password Field. Button\"])[2]");
    public static By passwordMasking = By.xpath("(//XCUIElementTypeOther[@name=\"Hide or Show Password Field. Button\"])[1]/XCUIElementTypeOther[1]/XCUIElementTypeSecureTextField");
    public static By invalidCredentialError = By.xpath("(//XCUIElementTypeOther[@name=\"Error The email or password is incorrect\"])[1]");
}
