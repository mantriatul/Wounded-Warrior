package stepDefinitions.WWPWeb;

import com.gargoylesoftware.htmlunit.Page;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.web.Wwp;
import stepDefinitions.RunCukesTest;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.List;

public class Quiz extends KeywordUtil {

    @And("Verify contents on the Quiz page")
    public void verifyQuizContent() throws InterruptedException {
        if(isWebElementPresent(Wwp.bannerImage,"")==true) {
            KeywordUtil.navigateToUrl("https://wwp--wdxuat.sandbox.my.site.com/WDX/s/quiz");
        }
        Thread.sleep(6000);
        if (isWebElementPresent(Wwp.questionTextQuiz, "") == true) {
            isWebElementPresent(Wwp.logoQuiz, "Wounded Warrior Logo is present");
            isWebElementVisible(Wwp.welcomeTitleQuiz, getElementText(Wwp.welcomeTitleQuiz));
            isWebElementVisible(Wwp.welcomeTextQuiz, getElementText(Wwp.welcomeTextQuiz));
            isWebElementVisible(Wwp.questionTextQuiz, getElementText(Wwp.questionTextQuiz));
            isButtonEnabled(Wwp.getStartedButton, "Get Started button");
            verifyDisplayAndEnable(Wwp.skipQuestionQuiz, getElementText(Wwp.skipQuestionQuiz));
            isWebElementVisible(Wwp.supportCallQuiz, getElementText(Wwp.supportCallQuiz));
        } else {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.format("Quiz page is not visible as user already applied for quiz")));

        }
    }

    @When("User clicks on veterans crisis helpline number on Quiz page")
    public void clicks_on_VetranhelplineNumber() throws InterruptedException, AWTException {
        isWebElementsVisible(Wwp.welcomeTitleQuiz, getElementText(Wwp.welcomeTitleQuiz));

        click(Wwp.veteranCrisisQuiz, "click on veteran helpline number");
        Thread.sleep(4000);
        Robot robot = new Robot();
        robot.mouseMove((int) 757.5625, 230); // Navigating through mouse hover. Note that the coordinates might differ, kindly check the coordinates of x and y axis and update it accordingly.
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(6000);


    }

    @And("Verify On Click of Get Started Button A first Quiz should appears")
    public void clickStartButtonContent() throws InterruptedException {
        if(isWebElementPresent(Wwp.bannerImage,"")==true) {
            KeywordUtil.navigateToUrl("https://wwp--wdxuat.sandbox.my.site.com/WDX/s/quiz");
        }
       Thread.sleep(6000);
        if (isWebElementPresent(Wwp.getStartedButton, "") == true) {
            isButtonEnabled(Wwp.getStartedButton, "Get Started button");
            click(Wwp.getStartedButton, "click on get started button");
        } else {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.format("Quiz page is not visible as user already applied for quiz")));
        }

    }

    @And("Verify Quiz Title,back button & page counting")
    public void VerifyOptionInQuiz() {
        isWebElementVisible(Wwp.screenTitleQuiz,getElementText(Wwp.screenTitleQuiz));
        isButtonEnabled(Wwp.backBtnQuiz,"Back Button");
        isWebElementPresent(Wwp.pageQuiz,getElementText(Wwp.pageQuiz));
    }

    @And("Select {string} from {string} page")
    public void selectMultipleOption(String interest, String activity) throws InterruptedException {
       if(isWebElementPresent(Wwp.interestNotSelected(interest),"")==true){
           scrollingToElementofAPage(Wwp.selectInterest(interest),"Scroll to "+ interest);
           click(Wwp.selectInterest(interest),interest+" is selected from "+activity);
       }
       else
       {
           RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.format(interest+" is already selected from "+activity)));

       }
    }

    @And("Verify Skip this Questions Button is Clickable and hiding Questions")
    public void VerifySkipthisquestionQuiz() {
        isWebElementPresent(Wwp.skipThisQuestionQuiz,"Skip this question is present");
        click(Wwp.skipThisQuestionQuiz,"Skip this question is clickable");
        if(isWebElementPresent(Wwp.pageQuiz,"")==true) {
            isWebElementVisible(Wwp.screenTitleQuiz, getElementText(Wwp.screenTitleQuiz));
            isWebElementPresent(Wwp.pageQuiz, getElementText(Wwp.pageQuiz));
        }
        else {
            isWebElementVisible(Wwp.screenTitleQuiz, getElementText(Wwp.screenTitleQuiz));
        }

    }

    @And("Skip {string} activites")
    public void skipthisquestionQuiz(String quiz)  {
        isWebElementPresent(Wwp.skipThisQuestionQuiz,"Skip this question is present");
        click(Wwp.skipThisQuestionQuiz,quiz+" is skipped");
        isWebElementVisible(Wwp.screenTitleQuiz,getElementText(Wwp.screenTitleQuiz));
        isWebElementPresent(Wwp.pageQuiz,getElementText(Wwp.pageQuiz));

    }
    @And("User click on back button")
    public void backbutton() {
        isButtonEnabled(Wwp.backBtnQuiz,"Back Button");
        click(Wwp.backBtnQuiz,"click on Back button");

    }

    @And("Verify Continue Button Clickable on Click of it open next Quiz")
    public void VerifyContinueButton(){
        click(Wwp.continueButtonQuiz,"click on continue button");
        if(isWebElementPresent(Wwp.pageQuiz,"")==true) {
            isWebElementVisible(Wwp.screenTitleQuiz, getElementText(Wwp.screenTitleQuiz));
            isWebElementPresent(Wwp.pageQuiz, getElementText(Wwp.pageQuiz));
        }
        else {
            isWebElementVisible(Wwp.screenTitleQuiz, getElementText(Wwp.screenTitleQuiz));
        }

    }

    @And("set Privacy setting as {string}")
    public void selectPrivacySetting(String privacy) throws InterruptedException {
        if(isWebElementPresent(Wwp.selectprivacy(privacy),"")==true){
            scrollingToElementofAPage(Wwp.selectInterest(privacy),"Scroll to "+ privacy);
            click(Wwp.selectInterest(privacy),privacy+" is selected");
        }
        else
        {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.format(privacy+" is already selected")));

        }
    }


    @And("click on continue button after updating privacy setting")
    public void clickContinueButton() {
        click(Wwp.continueButtonQuiz, "click on continue button");
        isWebElementPresent(Wwp.successTitleQuiz, getElementText(Wwp.successTitleQuiz) + " is present");
        isWebElementVisible(Wwp.homePageButtonQuiz,"Homepage");
    }

    @And("click on Homepage")
    public void clickHomepage() {
        isWebElementVisible(Wwp.homePageButtonQuiz, "Homepage");
        click(Wwp.homePageButtonQuiz, "click on homepage");

    }

    @And("Verify Privacy setting content")
    public void privacySettingContent(){
        isWebElementVisible(Wwp.privacyDesc,getElementText(Wwp.privacyDesc));
        isWebElementVisible(Wwp.learnMore,"Learn More");
        click(Wwp.learnMore,"Learn more detail page is opened");
        click(Wwp.closeLearnMore,"Close learn more page");

    }

    @And("click on skip all the question")
    public void skipAllTheQuestion(){
        verifyDisplayAndEnable(Wwp.skipQuestionQuiz, getElementText(Wwp.skipQuestionQuiz));
        click(Wwp.skipQuestionQuiz,"click on Skip all the question");
        waitForVisible(Wwp.screenTitleQuiz);
        isWebElementVisible(Wwp.screenTitleQuiz, getElementText(Wwp.screenTitleQuiz));
    }


    @And("Check the categories present on for you page")
    public void count_the_categories_present() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> category_name = getListElements(Wwp.forYouMultipleCategoryNames,"fetching the Number of categories");

        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.format("Total No. of categories:"+category_name.size())));
        for(int i=0; i<category_name.size();i++){
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.format("Categories Name: "+category_name.get(i).getText())));

        }


    }




}
