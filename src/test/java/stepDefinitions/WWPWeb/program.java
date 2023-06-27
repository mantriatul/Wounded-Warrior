package stepDefinitions.WWPWeb;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import pages.web.Wwp;
import stepDefinitions.RunCukesTest;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

public class program extends KeywordUtil {
    public static String Program_url;

    @And("Navigate to Program Page")
    public void Navigate_to_Program_Page() throws InterruptedException {
        isWebElementsVisible(Wwp.serviceFirstLink, "Program link");
        scrollingToElementofAPage(Wwp.serviceFirstLink, "scrolling to Program Link ");
        click(Wwp.serviceFirstLink, "click on Program link");
        Thread.sleep(3000);
        Assert.assertTrue(isWebElementsVisible(Wwp.backLink, "Program Page"));
        Program_url = getCurrentUrl();
    }

    @Then("Verify Program title is visible")
    public void Verify_Program_title_Visible() throws InterruptedException {
        scrollingToElementofAPage(Wwp.servicePageTitle, "scrolling to Program page title");
        Assert.assertTrue(isWebElementsVisible(Wwp.servicePageTitle, "Program page title"));
    }

    @Then("verify share and back button on Program page")
    public void verify_share_back_button() throws InterruptedException {
        hoverOnElement(Wwp.backLink);
        Assert.assertTrue(isWebElementsVisible(Wwp.backLink, "Back link"));
        hoverOnElement(Wwp.articleShareLink);
        Assert.assertTrue(isWebElementsVisible(Wwp.articleShareLink, "Share link"));
    }

    @And("verify Program name ,date and image visibility")
    public void verify_name_date_and_image() {
        Assert.assertTrue(isWebElementsVisible(Wwp.imageOnLatestSharedServiceInbox, "Image of program"));
        Assert.assertTrue(isWebElementsVisible(Wwp.nameOnLatestSharedServiceInbox, "Name of program"));
        Assert.assertTrue(isWebElementsVisible(Wwp.datetimeLatestSharedArticleInbox, "Date time of shared message"));
    }

    @And("verify content of Card inside program related item")
    public void verify_first_card_content() {
        Assert.assertTrue(isWebElementsVisible(Wwp.relatedArticlefirstCardImage, "Article Image"));
        Assert.assertTrue(isWebElementsVisible(Wwp.relatedArticlefirstCardTitle, "Article title"));
        Assert.assertTrue(isWebElementsVisible(Wwp.relatedArticlefirstCardDescription, "Article Description"));
    }

    @And("Navigate to Program page by clicking on its title")
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

    @And("Send the  program copied link to the user")
    public void send_the_copied_link_to_user() throws Exception {
        getWebElement(Wwp.inputFieldSendMessage).sendKeys(Keys.CONTROL + "v");
        Thread.sleep(2000);

        hoverOnElement(Wwp.sendButtonOnSendMessage);
        click(Wwp.sendButtonOnSendMessage, "click on send button");
        Thread.sleep(4000);

        String Copied_text_url = getText(Wwp.copiedlinkonMessageInbox);

        Assert.assertEquals(Program_url, Copied_text_url);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Copied link sent to the user successfully"));
    }
}
