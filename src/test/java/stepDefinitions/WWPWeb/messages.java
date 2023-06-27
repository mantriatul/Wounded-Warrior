package stepDefinitions.WWPWeb;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en_old.Tha;
import org.apache.poi.ss.formula.functions.T;
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
import java.util.List;

public class messages extends KeywordUtil {

    public static HashMap<String, String> dataMap = new HashMap<String, String>();
    @Then("user is able to see the list of messages")
    public void verifies_list_messges() throws InterruptedException {
        List<WebElement> messages_content=getListElements(Wwp.all_messages_content_and_users,"getting all the messages and users");
        List<WebElement> users=getListElements(Wwp.users,"getting all the users ");
        List<WebElement> messages=getListElements(Wwp.messages,"getting the ist of all the messages");
        List<WebElement> timestamp=getListElements(Wwp.timestamp,"getting the timestamp");
    for(int i=0;i<messages_content.size();i++){
            //System.out.println(messages_content.get(i).getText());
//            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(messages_content.get(i).getText()));
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the users are : " +users.get(i).getText()));

        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the messages are : " +messages.get(i).getText()));

        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the timestamp are : " +timestamp.get(i).getText()));
        



    }





    }
    @Then("Verify on Click of message user should redirect to the respective page of user profile")
    public void user_redirects_to_profile() throws InterruptedException {
        List<WebElement> users=getListElements(Wwp.users,"getting all the users ");
        List<WebElement> message=getListElements(Wwp.messagesRC,"getting the list of messages of particular user");
        users.get(3).click();

        Thread.sleep(7000);
        String  expected_title=getDriver().getTitle();
        String[] arrSplit=expected_title.split(":");
        System.out.println("the expected user  is :" +arrSplit[1].trim());
        System.out.println("the actual user is :" +getElementText(Wwp.name(arrSplit[1].trim())));

        Assert.assertEquals(arrSplit[1].trim(),getElementText(Wwp.name(arrSplit[1].trim())));
        Thread.sleep(6000);
        Assert.assertTrue(isWebElementVisible(Wwp.message_box,"message box is visible"));


    }

    @Then("verify the search functionality of messages")
    public void verify_Serach_functionlaity() throws InterruptedException {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("WWP", "Testdata1");
        inputText(Wwp.search_message_box, dataMap.get("search_text"), "enter the " + dataMap.get("search_text") + "in the search field");
        Thread.sleep(7000);
        click(Wwp.search_butoton, "click on the search button");
        Thread.sleep(7000);
        List<WebElement> search_results = getListElements(Wwp.messages, "getting the results for the search");
        int size = search_results.size();
        System.out.println("the elements in the search results are: " + size);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the elements in the search results are: " + size));

        // Check if search results are displayed
        Assert.assertFalse(search_results.isEmpty());

        for (WebElement searchResult : search_results) {
            String resultText = searchResult.getText();
            System.out.println("the text is :  " + resultText);
           // Assert.assertTrue(resultText.equalsIgnoreCase(search_text));
            if(resultText.contains("message")){
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the search results are displayed sucessfully"));

            }else{
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the search results are not found"));

            }
        }


    }
    @Then("Verify Search does not include the body of messages to the resource center")
    public void resource_center_mesages() throws InterruptedException {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("WWP", "Testdata1");
        inputText(Wwp.search_message_box, dataMap.get("search_text"), "enter the " + dataMap.get("search_text") + "in the search field");
        Thread.sleep(3000);
        click(Wwp.search_butoton, "click on the search button");
        Thread.sleep(3000);
        Assert.assertFalse(isWebElementPresent(Wwp.messageBodyRC,"Resource centre message is not present"));
//        List<WebElement> search_results = getListElements(Wwp.messages, "getting the results for the search");
//        int size = search_results.size();
//        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(  "the elements in the search results are : " + size));
//
//
//        Thread.sleep(8000);
//
//        // Check if search results are displayed
//        Assert.assertTrue(search_results.isEmpty());

    }
    @And("user click on the new message button")
    public void click_new_message(){
        click(Wwp.new_message,"click on the new  message  button");
    }
    @Then("user is able to send the list of all the connections")
    public void list_of_Connections() throws InterruptedException {
        List<WebElement> users=getListElements(Wwp.user_list,"getting the list of all the users");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(  "the connections are: "));

        for(int i =0;i<users.size();i++){
            Thread.sleep(7000);
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(users.get(i).getText()));



        }
    }
    @Then("user is able to send the message to multiple connections")
    public void send_mesagae() throws InterruptedException {
        List<WebElement> users=getListElements(Wwp.user_list,"getting the list of all the users");
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("WWP", "Testdata1");
        users.get(2).click();
        Thread.sleep(8000);
        inputText(Wwp.message_box,dataMap.get("search_text"),dataMap.get("search_text")+" is entered");
        Thread.sleep(7000);
        click(Wwp.send_button,"click on the send button");
        Thread.sleep(8000);
        scrollingToElementofAPage(Wwp.back_buttonRC,"move to back button");
        click(Wwp.back_buttonRC,"click on the back button");
        Thread.sleep(6000);
        click(Wwp.new_message,"click on the new message icon");
        Thread.sleep(6000);
        List<WebElement> users1=getListElements(Wwp.user_list,"getting the list of all the users");
        users1.get(1).click();
        Thread.sleep(8000);
        inputText(Wwp.message_box,dataMap.get("search_text"),dataMap.get("search_text") +"entered the message again to the different connections");
        Thread.sleep(7000);
        click(Wwp.send_button,"click on the send button");
        Thread.sleep(8000);
        scrollingToElementofAPage(Wwp.back_buttonRC,"move to back button");
        click(Wwp.back_buttonRC,"click on the back button");





    }
    @Then("verifies the flag functionality")
    public void flag_functionalty() throws InterruptedException {
        click(Wwp.new_message,"click on the new  message  button");
        List<WebElement> users=getListElements(Wwp.user_list,"getting the list of all the users");
        users.get(0).click();
        Thread.sleep(8000);
        Assert.assertTrue(isWebElementPresent(Wwp.flag_icon,"flag icon is visible"));
        Thread.sleep(8000);
        scrollingToElementofAPage(Wwp.flag_icon,"move to the flag icon");
        Thread.sleep(8000);
        click(Wwp.flag_icon,"click on the flag icon");
        Thread.sleep(9000);
        Assert.assertTrue(isWebElementVisible(Wwp.radio_button("This message is not appropriate"),"This message is not appropriate radio button is present"));
        Assert.assertTrue(isWebElementVisible(Wwp.radio_button("Report message as spam"),"Report message as spam radio button is present"));
        Assert.assertTrue(isWebElementVisible(Wwp.textarea_flag_icon,"textarea field is present"));
        Assert.assertTrue(isWebElementVisible(Wwp.close_button,"close button is present"));
        Assert.assertTrue(isWebElementVisible(Wwp.submit_button,"submit button is present"));

        click(Wwp.radio_button("Report message as spam"),"click on the radio button");
        click(Wwp.submit_button,"click on the submit button");
        Assert.assertTrue(isWebElementVisible(Wwp.success_message,"success message is present"));
        Thread.sleep(7000);


    }
    @Then("verify that message count is visible on the message icon")
    public void message_count() throws InterruptedException {
        Thread.sleep(8000);
     List<WebElement> number_of_messages=getListElements(Wwp.message_Count,"getting the count of messages in the message icon");
       if(number_of_messages.size()==0){
           System.out.println("no new messages found");
           RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(  "no new messages are found "));




       }
       else{
//
           System.out.println("the number of messages are : " +number_of_messages.size());
           RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(  "the number of messages are:  " +number_of_messages.size()));

       }
    }

    @Then("verify the unread messages is present and click on the unread messages")
    public void verify_unread_messages() throws InterruptedException {
        Thread.sleep(7000);
        List<WebElement> unread_messages=getListElements(Wwp.unread_messgaes,"getting the count of unread messages");
        if(unread_messages.isEmpty()){
            System.out.println("no new messages are present");
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(  "you have no new messages"));

        }
        else{
            System.out.println("the number of unread  messages are : " +unread_messages.size());
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(  "the number of unread mesages are :  " +unread_messages.size()));

            Thread.sleep(7000);
            click(Wwp.unread_messgaes,"click on the unread messages");
            Thread.sleep(8000);
            scrollingToElementofAPage(Wwp.back_button,"move to back button");
            click(Wwp.back_button,"click on the back button");
            Thread.sleep(7000);
            Assert.assertTrue(isWebElementsVisible(Wwp.unread_messgaes,"the unread message icon is not visible"));

        }
    }
    @Then("verify that notification  count is visible on the notification icon")
    public void verify_notifcatin(){
       List<WebElement> number_of_notifications=getListElements(Wwp.notification_icon,"getting the count of the notification icon");

        if(number_of_notifications.size()==0){
            System.out.println("you have no new notifications");
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(  "you have no new notifications"));

        }
        else{
            System.out.println("the number of notifications is : " +number_of_notifications.size());
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(  "the number of notifications is : " +number_of_notifications.size()));

        }
    }

    @Then("verify the unread notifications")
    public void unread_notifications() {
        List<WebElement> number_of_notifications=getListElements(Wwp.notification_icon,"getting the count og notifications");

        if (number_of_notifications.size() == 0) {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(  "you have no new notifications"));
        } else {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(  "the number of new  notifications are: " +number_of_notifications.size()));
            List<WebElement> notification_content=getListElements(Wwp.notification_content,"getting the notifications");
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(  "the new notifications are: " +notification_content.get(0).getText()));

            System.out.println(notification_content.get(0).getText());

        }
    }

    @And("user can able to send a message to different user")
    public void sendMsgToAnotherUser() throws InterruptedException {
        inputText(Wwp.search_message_box, ConfigReader.getValue("firstName"), "enter the " + ConfigReader.getValue("firstName") + "in the search field");
        Thread.sleep(3000);
        click(Wwp.search_butoton, "click on the search button");
        Thread.sleep(3000);
        isWebElementsVisible(Wwp.searchUserName(ConfigReader.getValue("firstName")),  ConfigReader.getValue("firstName"));
        click(Wwp.searchUserName(ConfigReader.getValue("firstName")),  "click on "+ConfigReader.getValue("firstName"));
        Thread.sleep(3000);
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("WWP", "Testdata1");
        inputText(Wwp.message_box,dataMap.get("Messageinput"),dataMap.get("Messageinput")+"is entered");
        Thread.sleep(3000);
        click(Wwp.send_button,"click on the send button");
    }

    @Then("Search the user")
    public void Searchuser() throws InterruptedException {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("WWP", "Testdata1");
        Thread.sleep(2000);
        inputText(Wwp.search_message_box, dataMap.get("User"), "enter the " + dataMap.get("User") + "in the search field");
        Thread.sleep(2000);
        click(Wwp.search_butoton, "click on the search button");
        Thread.sleep(2000);


    }

    @Then("verify the unread messages is present")
    public void verifyunread_messages() throws InterruptedException {
        Thread.sleep(7000);
        List<WebElement> unread_messages=getListElements(Wwp.unread_messgaes,"getting the count of unread messages");
        if(unread_messages.isEmpty()){
            System.out.println("no new messages are present");
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(  "you have no new messages"));

        }
        else{
            System.out.println("the number of unread  messages are : " +unread_messages.size());
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(  "the number of unread mesages are :  " +unread_messages.size()));

            Thread.sleep(7000);

        }
    }


}



