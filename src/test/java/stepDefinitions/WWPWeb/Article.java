package stepDefinitions.WWPWeb;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en_lol.AN;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.web.Wwp;
import stepDefinitions.RunCukesTest;
import utilities.GlobalUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;


public class Article extends KeywordUtil {

    public static String Article_url;
    public static String message_pill_Count;

    @Then("Navigate to Article page")
    public void Navigate_to_article_page() {
        try {
            isWebElementsVisible(Wwp.forYouReadMoreLinkOnFirstArtcile, "read more link on first article");
            scrollingToElementofAPage(Wwp.forYouReadMoreLinkOnFirstArtcile, "scrolling to read more link ");
            click(Wwp.forYouReadMoreLinkOnFirstArtcile, "click on read more");
            Thread.sleep(3000);
            Assert.assertTrue(isWebElementsVisible(Wwp.backLink, "back link "));

        } catch (Exception e) {
            System.out.println("No Article present on for you page");
        }
    }

    @And("verify article title,image or video")
    public void Verify_title_image_video_on_article_page() throws InterruptedException {
        scrollingToElementofAPage(Wwp.articleTitle, "Scroll to Article Title");
        isWebElementsVisible(Wwp.articleTitle, "Article Title");
        scrollingToElementofAPage(Wwp.articleContent, "Scroll to Article Content");
        isWebElementsVisible(Wwp.articleContent, "Article Content");


    }

    @And("verify share and back button on article page")
    public void verify_share_back_button_on_article_page() throws InterruptedException {
        scrollingToElementofAPage(Wwp.backLink, "scroll to Back link");
        isWebElementsVisible(Wwp.backLink, "Back link");
        scrollingToElementofAPage(Wwp.articleShareLink, "scroll to Share link");
        isWebElementsVisible(Wwp.articleShareLink, "Share link");
    }

    @And("click on share button")
    public void click_on_share_button() throws InterruptedException {
        scrollingToElementofAPage(Wwp.articleShareLink, "scroll to Share link");
        click(Wwp.articleShareLink, "click on Share link");
    }

    @Then("verify success message shown after clicking copy link")
    public void verify_success_message_shown() throws InterruptedException {
        Thread.sleep(2000);
        click(Wwp.articleCopyLinkUnderSharePopup, "click on copy link");
        Assert.assertTrue(isWebElementsVisible(Wwp.success_message, getElementText(Wwp.successMessageGroup)));
        click(Wwp.closeTheMsg, "close the popup msg");
        //Assert.assertTrue(isWebElementsVisible(Wwp.articleCopyLinkSuccessPopup, "copy link success popup"));
    }

    @And("verify search field visible inside share popup")
    public void verify_search_field_visible() throws InterruptedException {

        Thread.sleep(3000);
        Assert.assertTrue(isWebElementsVisible(Wwp.articleSearchFieldInSharePopup, "search field"));
        click(Wwp.articleCloseButtonUnderSharePopup, "click on close popup");
    }

    @And("click On back button")
    public void click_on_back_button() throws InterruptedException {
        scrollingToElementofAPage(Wwp.backLink, "Back Link");
        click(Wwp.backLink, "Back Link");
        Thread.sleep(2000);
        Assert.assertTrue(isWebElementsVisible(Wwp.foryouLinkActive, "For You header link"));
    }

    @And("Scroll down to Related events")
    public void Scroll_down_to_related_event_section() throws InterruptedException {
        Thread.sleep(2000);
        scrollingToElementofAPage(Wwp.articleRelatedItem, "scroll to Related item");

    }

    @Then("verify arrow button clickable for related items")
    public void verify_arrow_button_clickable() {
        try {
            isWebElementsVisible(Wwp.articleRightArrowButton, "Right arrow button");
            WebDriverWait wt = new WebDriverWait(GlobalUtil.getDriver(), 10);
            try {
                wt.until(ExpectedConditions.elementToBeClickable(Wwp.articleRightArrowButton));
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Arrow button clickable"));
            } catch (Exception e) {
                System.out.println("Arrow button not clickable");
            }

        } catch (Exception e) {
            System.out.println("Arrow button not present");
        }
    }


    @Then("Navigate to Story Article page")
    public void Navigate_to_story_article_page() {
        try {
            isWebElementsVisible(Wwp.forYouReadMoreLinkOnFirstStoryArtcile, "read more link on first article");
            scrollingToElementofAPage(Wwp.forYouReadMoreLinkOnFirstStoryArtcile, "scrolling to read more link ");
            click(Wwp.forYouReadMoreLinkOnFirstStoryArtcile, "click on read more");
            Thread.sleep(3000);
            Assert.assertTrue(isWebElementsVisible(Wwp.backLink, "back link "));
            Article_url = getCurrentUrl();

        } catch (Exception e) {
            System.out.println("No Story Article present on for you page");
        }
    }


    @Then("verify content of card article inside related item")
    public void verify_first_card_content() {
        Assert.assertTrue(isWebElementsVisible(Wwp.relatedArticlefirstCardImage, "Article Image"));
        Assert.assertTrue(isWebElementsVisible(Wwp.relatedArticlefirstCardTitle, "Article title"));
        Assert.assertTrue(isWebElementsVisible(Wwp.relatedArticlefirstCardDescription, "Article Description"));
    }

    @And("Navigate to article page by clicking on its title")
    public void Navigate_to_article_page_by_clicking_on_its_title() throws InterruptedException {
        Thread.sleep(2000);
        String titleOfCard = getText(Wwp.relatedArticlefirstCardTitle);
        System.out.println(titleOfCard);
        click(Wwp.relatedArticlefirstCardTitle, "click on " +titleOfCard);
        Thread.sleep(10000);
        String articleTitle = getDriver().getTitle();
        System.out.println(articleTitle);
        Assert.assertEquals(articleTitle, titleOfCard);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.format(articleTitle+ " page is opened")));


    }

    @Then("Share the article to first user")
    public void Share_the_article_to_first_user() throws InterruptedException {
        String title = getText(Wwp.articleTitle);
        System.out.println(title);
        Thread.sleep(2000);
        click(Wwp.articleShareUserOne, "share article to user");
        Thread.sleep(1000);
        click(Wwp.articleYesButtonOnSharePopup, "Yes button");
        Thread.sleep(4000);
        String title_inbox = getText(Wwp.nameOnLatestSharedArticleInbox);
        Assert.assertEquals(title_inbox, title);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Article succesfully shared "));
    }

    @And("click on first user to share the article")
    public void click_on_first_user_to_share() throws InterruptedException {
        Thread.sleep(2000);
        click(Wwp.articleShareUserOne, "Article shared to another user");
    }

    @Then("Click on cancel button")
    public void click_on_cancel_button() throws InterruptedException {
        Thread.sleep(4000);
        click(Wwp.articleCancelButtonOnSharePopup, "click on cancel button");
        Assert.assertTrue(isWebElementsVisible(Wwp.articleCopyLinkUnderSharePopup,"article get cancelled"));
    }

    @And("click on yes button on confirmation popup")
    public void click_on_yes_button_under_confirmation() throws InterruptedException {
        Thread.sleep(1000);
        click(Wwp.articleYesButtonOnSharePopup, "click on Yes button");
    }

    @Then("verify User navigated to message listing page")
    public void verify_user_redirectd_to_message_listing_page() throws InterruptedException {
        Thread.sleep(4000);
        Assert.assertTrue(isWebElementsVisible(Wwp.sendMessageInputBox,"Article sent to user"));
    }

    @And("verify article name ,date and image visibility")
    public void verify_name_date_and_image(){
        Assert.assertTrue(isWebElementsVisible(Wwp.imageOnLatestSharedArticleInbox,"Image of Article"));
        Assert.assertTrue(isWebElementsVisible(Wwp.nameOnLatestSharedArticleInbox,"Name of Article"));
        Assert.assertTrue(isWebElementsVisible(Wwp.datetimeLatestSharedArticleInbox,"Date time of Article"));
    }

    @And("Verify Read more link on latest message is clickable")
    public void verify_read_more_link_clickable(){
        WebDriverWait wt = new WebDriverWait(GlobalUtil.getDriver(), 10);
        try {
            wt.until(ExpectedConditions.elementToBeClickable(Wwp.readmorelinkLatestSharedArticleInbox));
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Read more link clickable"));
        } catch (Exception e) {
            System.out.println("Read more link not clickable");
        }
    }

    @Then("send a {string} in inbox input field")
    public void send_text_in_inbox_field(String text) throws InterruptedException {
        Thread.sleep(2000);
        inputText(Wwp.inputFieldSendMessage,text,""+text+" is sent");
        click(Wwp.sendButtonOnSendMessage,"send button is clickable");

    }

    @And("Navigate on messages page")
    public void Navigate_to_messages_page() throws InterruptedException {
     hoverOnElement(Wwp.homepageHeaderLink("Messages"));
     click(Wwp.homepageHeaderLink("Messages"),"click on messages link");
     Thread.sleep(3000);
         }

     @And("click on new message received")
    public void click_on_new_message_recieved() throws InterruptedException {
        hoverOnElement(Wwp.newMessageAlertInMessagepage);
        click(Wwp.newMessageAlertInMessagepage,"new message");
        Thread.sleep(2000);
     }


    @And("clear the new message from message notification field")
    public void clear_new_messages() {
        Boolean done = true;
        while (done) {
            try {
                Thread.sleep(2000);
//                isWebElementsVisible(Wwp.messagePill, "new message count");
                hoverOnElement(Wwp.homepageHeaderLink("Messages"));
                click(Wwp.homepageHeaderLink("Messages"), "click on messages link");
                hoverOnElement(Wwp.newMessageAlertInMessagepage);
                click(Wwp.newMessageAlertInMessagepage, "click on new message");
                Thread.sleep(2000);
                hoverOnElement(Wwp.wwpLogo);
                click(Wwp.wwpLogo,"clicked on logo to navigate to homepage ");
            } catch (Exception e) {
                System.out.println("No new more messages left to be opened");
                done = false;
            }
        }

    }
     @Then("Verify message pill got an increment")
    public void verify_message_pill_got_increment() throws InterruptedException {
        Thread.sleep(2000);
        isWebElementsVisible(Wwp.messagePill,"Message counter increased");
     }

    @And("Navigate on people page")
    public void navigate_to_people_page() throws InterruptedException {
        Thread.sleep(2000);
        hoverOnElement(Wwp.homepageHeaderLink("People"));
        click(Wwp.homepageHeaderLink("People"), "click on people link");
        Thread.sleep(2000);
        String banner_title = getText(Wwp.bannerTitle);
        waitForVisible(Wwp.bannerTitle);
        Assert.assertEquals(banner_title, "People");
    }

    @And("Navigate to profile section of first connection")
    public void Navigate_to_user_profile() throws InterruptedException {
        scrollingToElementofAPage(Wwp.firstUserInMyConnection,"");
        hoverOnElement(Wwp.firstUserInMyConnection);
        click(Wwp.firstUserInMyConnection, "click on first user under my connection");
        Thread.sleep(2000);
        Assert.assertTrue(isWebElementsVisible(Wwp.sendAMessageLinkOnUserPage, "Send a message link "));
    }

    @Then("Navigate to Message Input page")
    public void Navigate_to_message_input_page() throws InterruptedException {
        click(Wwp.sendAMessageLinkOnUserPage, "click on send a message link ");
        Thread.sleep(3000);
        Assert.assertTrue(isWebElementsVisible(Wwp.sendMessageInputBox, "message input field"));
    }
    @And("Send the copied link to the user")
    public void send_the_copied_link_to_user() throws Exception {
        getWebElement(Wwp.inputFieldSendMessage).sendKeys(Keys.CONTROL + "v");
        Thread.sleep(2000);

        hoverOnElement(Wwp.sendButtonOnSendMessage);
        click(Wwp.sendButtonOnSendMessage, "click on send button");
        Thread.sleep(2000);

        String Copied_text_url = getText(Wwp.copiedlinkonMessageInbox);

        Assert.assertEquals(Article_url, Copied_text_url);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Copied link sent to the user successfully"));
    }

    @And("click on user {string} to share article")
    public void click_on_desired_user_to_share_article(String user) throws InterruptedException {
        Thread.sleep(2000);
        click(Wwp.articleShareDesiredUser(user), "Click on "+user+" to share the article");
    }

    @And("click on new message received from the sender id {string}")
    public void click_on_new_message_from_sender_side(String user) throws InterruptedException {
        hoverOnElement(Wwp.userAvatarInMessagePage(user));
        click(Wwp.userAvatarInMessagePage(user), "clicked on Message of "+ user);
        Thread.sleep(2000);
    }
}
