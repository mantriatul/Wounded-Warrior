package stepDefinitions.WWPWeb;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.web.Wwp;
import stepDefinitions.RunCukesTest;
import utilities.GlobalUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

public class service extends KeywordUtil {
    public static String Service_url;

    @And("Navigate to Service Page")
    public void Navigate_to_Service_Page() throws InterruptedException {
        isWebElementsVisible(Wwp.serviceFirstLink, "Service Link");
        scrollingToElementofAPage(Wwp.serviceFirstLink, "scrolling to Service Link ");
        click(Wwp.serviceFirstLink, "click on service link");
        Thread.sleep(3000);
        Assert.assertTrue(isWebElementsVisible(Wwp.backLink, "Service Page"));
        Service_url = getCurrentUrl();
    }

    @Then("Verify Service title is visible")
    public void Verify_service_title_Visible() throws InterruptedException {
        scrollingToElementofAPage(Wwp.servicePageTitle, "scrolling to Service page title");
        Assert.assertTrue(isWebElementsVisible(Wwp.servicePageTitle, "service page title"));
    }

    @Then("verify share and back button on Service page")
    public void verify_share_back_button() throws InterruptedException {
        hoverOnElement(Wwp.backLink);
        Assert.assertTrue(isWebElementsVisible(Wwp.backLink, "Back link"));
        hoverOnElement(Wwp.articleShareLink);
        Assert.assertTrue(isWebElementsVisible(Wwp.articleShareLink, "Share link"));
    }

    @And("Verify Request Info button visible if present")
    public void Verify_request_info_button_visible_if_present() {
        try {
//            hoverOnElement(Wwp.requestInfoButton);

            Assert.assertTrue(isWebElementsVisible(Wwp.requestInfoButton, "Request info button"));
        } catch (Exception e) {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Request info button not present on the service page"));
        }
    }

    @And("verify service name ,date and image visibility")
    public void verify_name_date_and_image() {
        Assert.assertTrue(isWebElementsVisible(Wwp.imageOnLatestSharedServiceInbox, "Image of service"));
        Assert.assertTrue(isWebElementsVisible(Wwp.nameOnLatestSharedServiceInbox, "Name of service"));
        Assert.assertTrue(isWebElementsVisible(Wwp.datetimeLatestSharedArticleInbox, "Date time of shared message"));
    }

    @Then("Verify Description link on latest message is clickable")
    public void verify_Description_link_clickable() {
        WebDriverWait wt = new WebDriverWait(GlobalUtil.getDriver(), 10);
        try {
            wt.until(ExpectedConditions.elementToBeClickable(Wwp.DescriptionlinkLatestSharedServiceInbox));
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Description link clickable"));
        } catch (Exception e) {
            System.out.println("Description link not clickable");
        }
    }

    @And("Send the  Service copied link to the user")
    public void send_the_copied_link_to_user() throws Exception {
        getWebElement(Wwp.inputFieldSendMessage).sendKeys(Keys.CONTROL + "v");
        Thread.sleep(2000);

        hoverOnElement(Wwp.sendButtonOnSendMessage);
        click(Wwp.sendButtonOnSendMessage, "click on send button");
        Thread.sleep(4000);

        String Copied_text_url = getText(Wwp.copiedlinkonMessageInbox);

        Assert.assertEquals(Service_url, Copied_text_url);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Copied link sent to the user successfully"));
    }

    @And("Scroll down to You May Be Interested Section")
    public void scroll_down_to_you_may_be_Interested_section() throws InterruptedException {
        Thread.sleep(2000);
        scrollingToElementofAPage(Wwp.youMayBeInterestedSection, "You may Be interested Section");
    }

    @And("verify content of Card inside Service related item")
    public void verify_first_card_content() {
        Assert.assertTrue(isWebElementsVisible(Wwp.relatedArticlefirstCardImage, "Article Image"));
        Assert.assertTrue(isWebElementsVisible(Wwp.relatedArticlefirstCardTitle, "Article title"));
        Assert.assertTrue(isWebElementsVisible(Wwp.relatedArticlefirstCardDescription, "Article Description"));
    }

    @And("Navigate to Service page by clicking on its title")
    public void Navigate_to_Article_page_by_clicking_on_its_title() throws InterruptedException {
        Thread.sleep(2000);
        String titleOfCard = getText(Wwp.relatedArticlefirstCardTitle);
        System.out.println(titleOfCard);
        click(Wwp.relatedArticlefirstCardTitle, "article title");
        Thread.sleep(10000);
        String articleTitle = getDriver().getTitle();
        System.out.println(articleTitle);
        Assert.assertEquals(articleTitle, titleOfCard);

    }
}
