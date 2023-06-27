package stepDefinitions.WWPWeb;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.web.Wwp;
import stepDefinitions.RunCukesTest;
import utilities.GlobalUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

import java.util.HashMap;
import java.util.List;

public class Event extends KeywordUtil {

    public static HashMap<String, String> dataMap = new HashMap<String, String>();
    @And("Verify event cards details")
    public void eventDetails() throws InterruptedException {
        List<WebElement> eventList = getListElements(Wwp.eventList,"getting the list of Events");
            for (int i = 1; i <= eventList.size(); i++) {
                isWebElementVisible(Wwp.eventTitle(i), getElementText(Wwp.eventTitle(i)));
                isWebElementVisible(Wwp.eventDescription(i), getElementText(Wwp.eventDescription(i)));
                isWebElementVisible(Wwp.eventTime(i), getElementText(Wwp.eventTime(i)));
                isWebElementVisible(Wwp.eventDate, getElementText(Wwp.eventDate));
                break;
            }
        }


    @And("Verify Event card title is clickable")
    public void EventTitleClickable() throws InterruptedException {
        List<WebElement> eventList = getListElements(Wwp.eventList,"getting the list of Events");
        if(eventList.size()>0) {
            String eventTitle = getElementText(Wwp.eventTitle(1));
            isWebElementVisible(Wwp.eventTitle(1),eventTitle);
            scrollingToElementofAPage(Wwp.eventTitle(1),"scroll to "+eventTitle);
            click(Wwp.eventTitle(1),eventTitle+" is clickable");
            Thread.sleep(4000);
            String title = GlobalUtil.getDriver().getTitle();
            Assert.assertEquals(title,eventTitle);
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor( title+" page is opened"));
        }
}


    @And("Verify Event Details page Contents such as Event Date, Time, Register Buttons and related Event")
    public void EventDetailsContent() throws InterruptedException {
        Thread.sleep(30000);
        Assert.assertTrue(isWebElementVisible(Wwp.backBtn,"Back Button"));
        Assert.assertTrue(isWebElementVisible(Wwp.shareBtn,"Share Button"));
        Assert.assertTrue(isWebElementPresent(Wwp.eventHeadline,getElementText(Wwp.eventHeadline)));
        Assert.assertTrue(isWebElementPresent(Wwp.eventDes,getElementText(Wwp.eventDes)));
        if(isWebElementPresent(Wwp.eventDateAndTime,"")==true) {
            Assert.assertTrue(isWebElementPresent(Wwp.eventDateAndTime, getElementText(Wwp.eventDateAndTime)));
        }
        else
        {
            Assert.assertTrue(isWebElementVisible(Wwp.eventStartDate, getElementText(Wwp.eventStartDate)));
            Assert.assertTrue(isWebElementVisible(Wwp.eventEndDate, getElementText(Wwp.eventEndDate)));

        }
        Assert.assertTrue(isWebElementVisible(Wwp.eventImage,"Event Image"));
    }

    @Then("click on the Back and verifies the foryou page")
    public void click_back_button_verifies_forYou_title() throws InterruptedException {
        scrollingToElementofAPage(Wwp.backBtn, "move to the back button");
        click(Wwp.backBtn, "click on the back button");
        Thread.sleep(6000);
        String expected_title = "For You";
        Assert.assertEquals(getDriver().getTitle(), expected_title);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(expected_title+ " page is launched"));
    }

    @And("click on user {string} to share Event card")
    public void click_on_desired_user_to_share_EventCard(String user) throws InterruptedException {
        Thread.sleep(2000);
        click(Wwp.articleShareDesiredUser(user), "Click on "+user+" to share the Group card");
    }

    @Then("verifies the Event details")
    public void verifies_EventDetails() {
        waitForVisible(Wwp.messageInputBox);
        List<WebElement> messages = getListElements(Wwp.messagesGroup, "getting the messages");
        for (int i = 0; i < messages.size(); i++) {
            Assert.assertTrue(isWebElementsVisible(Wwp.messages_group_title, getElementText(Wwp.messages_group_title)));
            Assert.assertTrue(isWebElementsVisible(Wwp.eventDescriptionMessage, getElementText(Wwp.eventDescriptionMessage)));
            Assert.assertTrue(isWebElementsVisible(Wwp.datetimeLatestSharedArticleInbox, getElementText(Wwp.datetimeLatestSharedArticleInbox)));
            Assert.assertTrue(isWebElementsVisible(Wwp.eventDateMessage, getElementText(Wwp.eventDateMessage)));
            Assert.assertTrue(isWebElementsVisible(Wwp.eventTimeMessage, getElementText(Wwp.eventTimeMessage)));
            break;
        }
    }

}
