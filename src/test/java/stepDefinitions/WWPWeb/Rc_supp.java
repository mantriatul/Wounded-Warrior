package stepDefinitions.WWPWeb;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.web.Wwp;
import stepDefinitions.RunCukesTest;
import utilities.ConfigReader;
import utilities.ExcelDataUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Rc_supp extends KeywordUtil {
    public static HashMap<String, String> dataMap = new HashMap<String, String>();

    @Given("Read the value {string} from excel file")
    public void readTheTestdataFromExcelFile(String arg1) {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("WWP", arg1);

    }

    @When("User navigates to the WWp website")
    public void navigates_to_application() {
        navigateToUrl(dataMap.get("URL"));
    }

    @When("user enters the emailaddress as {string}")
    public void enterEmail(String email) {
        inputText(Wwp.emailInput, email, "enter the email address");
    }

    @When("user enters the password as {string}")
    public void enter_password(String password) {
        inputText(Wwp.passwordInput, password, "enter the password");

    }


    @Then("user clicks on the signin button")
    public void click_sign_in() throws InterruptedException {
        Thread.sleep(7000);
        hoverOnElement(Wwp.sign_in_button);
        click(Wwp.sign_in_button, "click on the sign in button");
    }

    @Then("user navigate to the {string} page")
    public void click_link(String link_nmae) throws InterruptedException {
        Thread.sleep(7000);
        Assert.assertTrue(isWebElementsVisible(Wwp.click_link(link_nmae), link_nmae + "page"));
    }

    @And("user click on the {string} icon")
    public void click_icon(String icon_name) throws InterruptedException {
        Thread.sleep(6000);
        scrollingToElementofAPage(Wwp.clickicon(icon_name),"");
        hoverOnElement(Wwp.clickicon(icon_name));
        click(Wwp.clickicon(icon_name), "click on the " + icon_name);

    }

    @Then("Verify that {string} is present")
    public void verify_text(String text) throws InterruptedException {
        Thread.sleep(7000);
        hoverOnElement(Wwp.rc_text(text));
        Assert.assertEquals(getElementText(Wwp.rc_text(text)), text);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(getElementText(Wwp.rc_text(text)) + " is present"));


    }

    @Then("verify that telephone number is clickable")
    public void verify_telephone_number() throws InterruptedException {
        Thread.sleep(6000);
        waitforclickable(Wwp.telephone_number);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(" telephone_number is clckable"));

    }

    @And("user click on the {string} link")
    public void click_title(String title) throws InterruptedException {
        hoverOnElement(Wwp.click_title(title));
        click(Wwp.click_title(title), "clcik on the " + title);

    }

    @Then("verify that {string} is present")
    public void verify_field(String fieldname) throws InterruptedException {

        Thread.sleep(7000);
        switchToWindow();
        hoverOnElement(Wwp.form(fieldname));
        Assert.assertTrue(isWebElementPresent(Wwp.form(fieldname),fieldname+ " is present"));

        String expected_text=getValue(Wwp.form(fieldname));
        System.out.println("the expectetd text is : " +expected_text);
        String actual_name= ConfigReader.getValue(fieldname);
        System.out.println("the actual text is : " +actual_name);
        Assert.assertEquals(expected_text,actual_name);
        //Assert.assertEquals();
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(fieldname + " is : " +expected_text));



    }

    @Then("verify that {string} is clickable")
    public void verifyclickable(String button){
        waitforclickable(Wwp.button_clickable(button));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(button + " is clickable "));
    }

    @Then("verify that faq questions part")
    public void verifyfaq() throws InterruptedException {
      List<WebElement> faq_questions=getListElements(Wwp.faq_question,"getting the faq questions");
        List<WebElement> faq_answers=getListElements(Wwp.faq_answers,"getting the faq answers");
        List<WebElement> plus_sign=getListElements(Wwp.plus_button,"getting the plus button");
        System.out.println(plus_sign.size());

         for(int i =0;i<faq_questions.size();i++){

          scrollingToElementofAPage(Wwp.faq_question,"");
          RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(faq_questions.get(i).getText()));
          Thread.sleep(8000);
          hoverOnElement(Wwp.plus_button);
          Thread.sleep(7000);
          plus_sign.get(i).click();
          Thread.sleep(8000);
          RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(faq_answers.get(i).getText()));
          Thread.sleep(8000);


      }
    }

    @And("click on the plus icon")

    @Then("verify that faq answers part")
    public void verify_faq_answerpart(){
        List<WebElement> faq_answers=getListElements(Wwp.faq_answers,"getting the faq answers");
        System.out.println("the answers are :");
        for(int i =0;i<faq_answers.size();i++){

        }
    }

    @Then("user enter the message as {string}")
    public void entermessage(String message){
        inputText(Wwp.message_textarea,message,"enter the " +message+ "in the textbox");
    }

    @Then("click on the {string} button")
    public void click_send_messsage(String button){
        click(Wwp.button_clickable(button),"click on the " +button);
    }

    @Then("verified the message")
    public void verified_message() throws InterruptedException {
      List<WebElement> messages=getListElements(Wwp.messagesRC,"getting all the messages");
        System.out.println("the total no of messages are : " +messages.size());
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the total no of messages are : " +messages.size()));


        Thread.sleep(7000);
        String current_message=messages.get(0).getText();

        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the current message is : " +current_message));

        scrollingToElementofAPage(Wwp.back_button,"move to the  back button");
        click(Wwp.back_button,"click on back button");
        Thread.sleep(8000);
        click(Wwp.resource_centre,"click on the resource centre");
        Thread.sleep(6000);
        scrollingToElementofAPage(Wwp.messagesRC,"move to messages");
        Assert.assertTrue(isWebElementVisible(Wwp.messagesRC,"Message"));

    }


}
