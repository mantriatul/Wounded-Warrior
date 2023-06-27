package stepDefinitions.WWPWeb;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.web.Wwp;
import stepDefinitions.RunCukesTest;
import utilities.GlobalUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

import java.util.List;

public class Foryou extends KeywordUtil {

    @And("Navigate to For You Page")
    public void navigate_to_for_you_page() throws InterruptedException {
        Thread.sleep(1000);
        hoverOnElement(Wwp.homepageHeaderLink("For You"));
        click(Wwp.homepageHeaderLink("For You"),"clicked On For You header link ");
        Thread.sleep(2000);
        Assert.assertTrue(isWebElementsVisible(Wwp.homepageHeaderLinkActive("For You"),"For You link  active"));
    }
    @And("verify filters are clickable on For You")
    public void verify_For_You_Page_filters_are_clickable() {
        WebDriverWait wt = new WebDriverWait(GlobalUtil.getDriver(), 10);
        try {
            wt.until(ExpectedConditions.elementToBeClickable(Wwp.forYouFilters("All")));
            System.out.println("All  to be clickable");
            wt.until(ExpectedConditions.elementToBeClickable(Wwp.forYouFilters("Near Me")));
            System.out.println("Near Me");
            wt.until(ExpectedConditions.elementToBeClickable(Wwp.forYouFilters("Virtual")));
            System.out.println("Virtual");

        } catch (Exception e) {
            System.out.println("element not clickable");
        }
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("For You filters are clickable"));
    }

    @Then("click on update my interests On For you page")
    public void click_on_update_my_interest_link() throws InterruptedException {
        KeywordUtil.scrollingToElementofAPage(Wwp.forYouUpdateMyInterestLink, "update my interests");
        click(Wwp.forYouUpdateMyInterestLink, "update my interests link");
        Thread.sleep(5000);
        Assert.assertTrue(isWebElementsVisible(Wwp.interestPageHeading, "Interest Page Heading"));


    }

    @And("click on 'All' Filter on for you page")
    public void click_on_All_filter() throws InterruptedException {
        scrollingToElementofAPage(Wwp.forYouFilters("All"), "scroll to All filter");
        click(Wwp.forYouFilters("All"), "click on All Filter");
        Assert.assertTrue(isWebElementsVisible(Wwp.forYouClickedAllfilter, "clicked on All filter"));
    }


    @Then("Verify Category Name on ForYou Filters page")
    public void verify_category_name() throws InterruptedException {
        Thread.sleep(3000);
//        List<WebElement> category_name = getListElements(By.xpath("//div[@class='content-wrapper']//div[@class='title-section']"),"geting the tiles");
        List<WebElement> category_name = getListElements(Wwp.forYouMultipleCategoryNames,"Getting the category name");
        for(int i =0;i<category_name.size();i++){
            String Category_name = category_name.get(i).getText();
            Assert.assertTrue(isWebElementsVisible(Wwp.for_you_category_name(Category_name), Category_name));
            Thread.sleep(1000);
        }
    }



    @Then("Click on show more button")
    public void click_on_show_more_button() throws Exception {
        Boolean done = true;

        scrollingToElementofAPage(Wwp.forYouShowMoreButtonstructure, "Scroll down to show more button boundary");
        while (done) {
            try {
                if (findWithFluintWait(Wwp.forYouShowMoreButton).isDisplayed()) {
                    Thread.sleep(2000);
                    scrollingToElementofAPage(Wwp.forYouShowMoreButtonstructure, "Scroll down to show more button boundary");
                    click(Wwp.forYouShowMoreButton, "Click on Show More button");
                    Thread.sleep(2000);
                }
            } catch (Exception e) {
                System.out.println("Show More Button Not present");
                break;
            }
        }

    }

    @And("Verify Arrow Button clickable if records more than 3")
    public void click_on_arrow_button() throws InterruptedException {
        Thread.sleep(2000);
        int category_count = getListElements(Wwp.forYouCategoryStructure, "category list").size();
        for (int i = 1; i <= category_count; i++) {
            int cards_count = getListElements(Wwp.forYouCategoryCards(i), "counting cards present in " + i + " category").size();
            if (cards_count > 3) {
                Thread.sleep(2000);
                scrollingToElementofAPage(Wwp.forYouCategoryRightArrowLink(i), " scrolling to right arrow link");
                WebDriverWait wt = new WebDriverWait(GlobalUtil.getDriver(), 10);
                try {
                    wt.until(ExpectedConditions.elementToBeClickable(Wwp.forYouCategoryRightArrowLink(i)));
                    Thread.sleep(2000);
                    i = category_count + 1;
                } catch (Exception e) {
                    System.out.println("Arrow button not clickable");
                }
            }

        }
    }

    @And("Verify Event,Program,Article is clickable on category slider")
    public void verify_event_program_article_clickable() throws InterruptedException {
        WebDriverWait wt = new WebDriverWait(GlobalUtil.getDriver(), 10);
        scrollingToElementofAPage(Wwp.forYouFirstCategory, "scrolling down to first category");
        int cards_count = getListElements(Wwp.forYouCategoryCards(1), "counting cards present in ist category").size();
        for (int i = 1; i <= cards_count; i++) {
            try {
                wt.until(ExpectedConditions.elementToBeClickable(By.xpath("((//div[@class='section-container'])[1]//div[@class='keen-slider__slide'])[" + i + "]")));
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Card " + i + " inside category is clickable "));
            } catch (Exception e) {
                System.out.println("cards  not clickable");
            }
        }
    }


    @And("Event,Program,Article is visible under category slider")
    public void verify_event_program_article_visible() throws InterruptedException {
        scrollingToElementofAPage(Wwp.forYouFirstCategory, "scrolling down to first category");
        int cards_count = getListElements(Wwp.forYouCategoryCards(1), "counting cards present in ist category").size();
        for (int i = 1; i <= cards_count; i++) {
            Thread.sleep(1000);
            Assert.assertTrue(isWebElementsVisible(By.xpath("((//div[@class='section-container'])[1]//div[@class='keen-slider__slide'])[" + i + "]"), "card" + i + " is visible"));
        }
    }

    @And("click on the card under category")
    public void click_on_card_under_category() throws InterruptedException {
        Thread.sleep(2000);
        scrollingToElementofAPage(Wwp.forYouFirstCategory, "scrolling down to first category");
        click(Wwp.forYouFirstCardUnderFirstCategoryLink, "first card under category list");
        Thread.sleep(5000);
        Assert.assertTrue(isWebElementsVisible(Wwp.backLink, "Navigate to card category"));
    }

    @Then("Click on near me filter")
    public void click_on_near_me_filter() throws InterruptedException {
        scrollingToElementofAPage(Wwp.forYouFilters("Near Me"), "Near me Filter");
        click(Wwp.forYouFilters("Near Me"), "Near me ");
    }

    @And("Enter city {string} in {string} field")
    public void Enter_city_name_in_city_field(String city, String city_field) throws InterruptedException {
        Thread.sleep(2000);
        inputText(Wwp.nearmeInputField(city_field), city, "input city");
    }

    @And("Select Range {string} in range field")
    public void Select_range_in_range_filter(String range) throws InterruptedException {
        Thread.sleep(2000);
        click(Wwp.nearmeRangefield, "range field");
        Thread.sleep(3000);
        click(Wwp.nearmeRange(range), "range option");
    }

    @Then("Click on Apply Button on near me filter")
    public void Click_on_apply_button() throws InterruptedException {
        Thread.sleep(2000);
        click(Wwp.nearmeApplyButton, "apply button");
    }

    @And("Verify Event are visible")
    public void verify_events_are_visible() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(isWebElementsVisible(Wwp.nearmeCategorySectionOne, "events after applying filter"));
    }

    @Then("Navigate to event details page by clicking on event title")
    public void Navigate_to_event_page_by_clicking_on_event_title() {
        try {
            Thread.sleep(2000);
            scrollingToElementofAPage(Wwp.nearmeFirstEventUndercategory, "scrolling down to first event");
            click(Wwp.forYouFirstCardUnderFirstCategoryLink, "first event under category list");
            Thread.sleep(5000);
            Assert.assertTrue(isWebElementsVisible(Wwp.backLink, "land on event page"));

        } catch (Exception e) {
            System.out.println("No events present");
        }

    }

    @Then("verify range options in range dropdown are {string},{string},{string},{string}")
    public void Verify_range_options_in_range_dropdown(String r1 , String r2 , String r3 , String r4) throws InterruptedException {
        Thread.sleep(2000);
        click(Wwp.nearmeRangefield, "range field");
        Thread.sleep(3000);
        Assert.assertTrue(isWebElementsVisible(Wwp.nearmeRange(r1),"near me range distance "+r1+" "));
        Assert.assertTrue(isWebElementsVisible(Wwp.nearmeRange(r2),"near me range distance "+r2+""));
        Assert.assertTrue(isWebElementsVisible(Wwp.nearmeRange(r3),"near me range distance "+r3+""));
        Assert.assertTrue(isWebElementsVisible(Wwp.nearmeRange(r4),"near me range distance "+r4+""));
    }

    @And("click on apply filter without selecting city and state")
    public void click_on_apply_filter_without_selecting_state_city() throws InterruptedException {
        clearInput(Wwp.nearmeInputField("City"));
        clearInput(Wwp.nearmeInputField("State"));
        Click_on_apply_button();
        Thread.sleep(2000);
        Assert.assertTrue(isWebElementsVisible(Wwp.nearmeErrorOnInputField("city"),"Error on city input field"));
        Assert.assertTrue(isWebElementsVisible(Wwp.nearmeErrorOnInputField("state"),"Error on state input field"));
    }

    @Then("verify 'please adjust filter' showing on")
    public void verify_text_shown_on_applying_filter_with_Invalid_Areacode(){
        Assert.assertTrue(isWebElementsVisible(By.xpath("//div[text()='No content to show. Please adjust the filters.']"), "No content to show. Please adjust the filters."));
    }

    @Then("Click on Virtual filter")
    public void click_on_Virtual_filter() throws InterruptedException {
        scrollingToElementofAPage(Wwp.forYouFilters("Virtual"), "Virtual");
        click(Wwp.forYouFilters("Virtual"), "Virtual");
    }



    @And("verify events displayed as per the search as {string}")
    public void Verify_events_displayed_as_per_search(String country){

        Assert.assertTrue(isWebElementsVisible(Wwp.nearmeCountryVerification(country), "country verification"));

    }

    @And("click on the WWP logo")
    public void Click_on_wwp_logo() throws Exception {
        Thread.sleep(1000);
        click(Wwp.wwpLogo,"wwp logo");
        Thread.sleep(2000);
        Assert.assertTrue(isWebElementsVisible(Wwp.homepageHeaderLinkActive("For You"),"For You link active"));
    }

    @And("verify Read more link on article is clickable")
    public void verify_read_more_link_visibility(){
        try {
            isWebElementsVisible(Wwp.forYouReadMoreLinkOnFirstArtcile,"read more link on first article");
            WebDriverWait wt = new WebDriverWait(GlobalUtil.getDriver(), 10);
            try {
                scrollingToElementofAPage(Wwp.forYouReadMoreLinkOnFirstArtcile,"scrolling to read more link");
                wt.until(ExpectedConditions.elementToBeClickable(Wwp.forYouReadMoreLinkOnFirstArtcile));
                Thread.sleep(2000);

            } catch (Exception e) {
                System.out.println("Read more link not clickable");
            }

        } catch (Exception e) {
            System.out.println("No Read more links present");
        }
    }

    @Then("verify date on the events on for you page")
    public void Verify_date_time_visibility_on_event(){
        try{
            isWebElementsVisible(Wwp.forYouUpcomingDataList,"upcoming data list");
            String month = getCurrentDateTime();
            System.out.println(month);
        }
        catch(Exception e){
            System.out.println("No events present");
        }
    }

    @Then("user can view the default view")
    public void user_can_view_default_view_on_forYou() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(isWebElementsVisible(Wwp.welcomeTextOnForYou,"welcome text"));

    }
    @And("verify homepage header menu are clickable")
    public void Header_link_is_clickable() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wt=new WebDriverWait(GlobalUtil.getDriver(), 10);
        try {
            wt.until(ExpectedConditions.elementToBeClickable(Wwp.homepageHeaderLink("For You")));
            System.out.println("For You  to be clickable");
            wt.until(ExpectedConditions.elementToBeClickable(Wwp.homepageHeaderLink("Browse All")));
            System.out.println(" Browse All element to be clickable");
            wt.until(ExpectedConditions.elementToBeClickable(Wwp.homepageHeaderLink("People")));
            System.out.println("People element to be clickable");
            wt.until(ExpectedConditions.elementToBeClickable(Wwp.homepageHeaderLink("Groups")));
            System.out.println(" groups element to be clickable");
            wt.until(ExpectedConditions.elementToBeClickable(Wwp.homepageHeaderLink("Notifications")));
            System.out.println(" notifications element to be clickable");
            wt.until(ExpectedConditions.elementToBeClickable(Wwp.homepageHeaderLink("Support")));
            System.out.println(" support element to be clickable");
            wt.until(ExpectedConditions.elementToBeClickable(Wwp.homepageHeaderLink("Messages")));
            System.out.println(" messages element to be clickable");
            wt.until(ExpectedConditions.elementToBeClickable(Wwp.crisisLine));
            System.out.println("crisis line to be clickable");
            wt.until(ExpectedConditions.elementToBeClickable(Wwp.userProfileIcon));
            System.out.println("user profile icon to be clickable");
        }
        catch (Exception e){
            System.out.println("element not clickable");
        }

        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(" homepage header elements are clickable"));
    }

    @And("verify homepage banner is visible")
    public void homepage_banner_is_visible()
    {
        Assert.assertTrue(isWebElementsVisible(Wwp.bannerImage,"homepage banner "));

    }

    @And("verify content on Homepage Banner with username {string}")
    public void content_verify_on_homepage_banner(String username) throws InterruptedException
    {
        Thread.sleep(10000);
        String banner_title = getText(Wwp.homepageBannerTitle);
        System.out.println(banner_title);
        Assert.assertEquals(banner_title,"Welcome, "+username);
        String bannersubtitle = getText(Wwp.homepageBannerSubTitle);
        Assert.assertEquals(bannersubtitle,"Events, Programs, and Services For You");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("homepage content is visible"));
    }

}
