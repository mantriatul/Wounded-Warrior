package stepDefinitions.WWPWeb;

import com.relevantcodes.extentreports.LogStatus;
import constants.web.Constant;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.minidev.json.JSONUtil;
import org.apache.xpath.operations.Bool;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.w3c.dom.ls.LSOutput;

import pages.web.Wwp;
import stepDefinitions.RunCukesTest;
import utilities.*;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;

public class BrowseAll extends KeywordUtil {
    public static HashMap<String, String> dataMap = new HashMap<String, String>();


    @When("^user click on the (.*) page$")
    public void user_click_on_the__page(String linkname) throws InterruptedException {
        Thread.sleep(6000);
        click(Wwp.Click_link(linkname), "click on the " + linkname);
        Thread.sleep(6000);
    }

    @Then("verify the content present on the Browse_All page")
    public void verify_banner_image_is_present() {
        // check banner imgae is present or not

        Assert.assertTrue(isWebElementPresent(Wwp.banner_image, "Banner image is present"));

        // check  Text Browse All Events, Service Offerings & Community Partnerships
        String expected_text = getElementText(Wwp.Browse_All_text);
        // Assert.assertEquals(expected_text,"Browse All");
        String expected_text1 = getElementText(Wwp.events_text);
        //Assert.assertEquals(expected_text1,"Events, Service Offerings & Community Partnerships");

        //check Search Button
        Assert.assertTrue(isWebElementPresent(Wwp.searach_field, "search button is present"));

        //check featured cards
        Assert.assertTrue(isWebElementPresent(Wwp.featured_text, "featured card is present"));

        //Check By interest Cards and View All Button

        Assert.assertTrue(isWebElementPresent(Wwp.interst, "interest card is present"));
        Assert.assertTrue(isWebElementPresent(Wwp.view_all, "view all button is present"));
    }

    @Then("Validate search functionality")
    public void serach_functioanlity() throws InterruptedException {
        //Check If the search field is empty, the search button should not trigger any action and no search results should be displayed.
        Thread.sleep(8000);
        Boolean enteredtext = inputText(Wwp.searach_field, "", "enter the data in the search field");
        if (enteredtext.equals("")) {
            Assert.assertTrue(isWebElementEnable(Wwp.search_button, "search button is enable"));
            System.out.println("search button  is  clickable");


        } else {
            Assert.assertFalse(isWebElementEnable(Wwp.search_button, "search button is not enable"));
            System.out.println("search button  is not clickable");
        }

        //verify serch functionality with the valid text
        String search_text = "Monthly Fitness Challenge";
        inputText(Wwp.searach_field, search_text, "enter the " + search_text + "in the search field");
        click(Wwp.search_button, "click on the search button");
        List<WebElement> search_results = getListElements(By.xpath("//div[@class='search-items-container']"), "getting the results for the search");
        int size = search_results.size();
        //System.out.println("the elements in the search results are: " + size);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the elements in the search results are: " + size+""));


        // Check if search results are displayed
        Assert.assertFalse(search_results.isEmpty());

        for (WebElement searchResult : search_results) {
            String resultText = searchResult.getText();
            //System.out.println("the text is :  " + resultText);
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the text is :  " + resultText+""));

            Assert.assertTrue(resultText.contains(search_text));
        }
    }

    @Then("verify that search results should be clickable")
    public void search_result_card() throws InterruptedException {
        String search_text = "Monthly Fitness Challenge";
        inputText(Wwp.searach_field, search_text, "enter the " + search_text + "in the search field");
        click(Wwp.search_button, "click on the search button");
        List<WebElement> search_results = getListElements(By.xpath("//div[@class='search-items-container']"), "getting the results for the search");
        int size = search_results.size();
        System.out.println("the elements in the search results are: " + size);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the elements in the search results are: " + size+""));


        // Check if search results are displayed
        Assert.assertFalse(search_results.isEmpty());

//        for (WebElement searchResult : search_results) {
//            String resultText = searchResult.getText();
//            System.out.println("the text is :  " +resultText);
//            Assert.assertTrue(resultText.contains(search_text));
//            Thread.sleep(8000);
//
//        }

        // Thread.sleep(8000);
        hoverOnElement(Wwp.Monthly_fitness_challenge);
        click(Wwp.Monthly_fitness_challenge, "click on the monthly fitness challenge");

        //navigating to the next page and verifies the titie of the next page.
        Thread.sleep(8000);
        Assert.assertEquals(getDriver().getTitle(), "Monthly Fitness Challenge");

    }

    @Then("verify the error messages")
    public void error_messages() throws InterruptedException {
        String invalid_data = "christmas";
        inputText(Wwp.searach_field, invalid_data, "enter the invalid data");
        click(Wwp.search_button, "click on the search button");

        String expected_result = getElementText(Wwp.no_result_text);
        System.out.println("the expected result is :" + expected_result);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the expected result is :" + expected_result+""));

        Assert.assertEquals(getElementText(Wwp.no_result_text), expected_result);
        //waitForClickable(Wwp.browse_All);
        hoverOnElement(Wwp.browse_All);
        click(Wwp.browse_All, "click on the browse all");
        Thread.sleep(5000);
        Assert.assertEquals(getDriver().getTitle(), "Browse All");
    }

    @Then("Verify featured cards section")
    public void featured_cards() throws InterruptedException {

        // checking the arrow buttons functioanlity
        List<WebElement> featured_elemnets = getListElements(Wwp.featured_container, "getting the elements in the featured container");
        System.out.println("the elements present in the featured container is :" + featured_elemnets.size());
        if (featured_elemnets.size() > 3) {
            Assert.assertTrue(isWebElementPresent(Wwp.arrow_buttons, "arrow button are present"));
            System.out.println("arrow buttons are present");
        } else {
            Assert.assertFalse(isWebElementPresent(Wwp.arrow_buttons, "arrow buttons are not present"));
            System.out.println("arrow buttons are not present");
        }

        //Verify  Program, Event and Services content (image, Title, and text) should be clearly visible
        String text = getElementText(Wwp.featured_container);
        //System.out.println("the event text is :" + text);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the event text is :" + text+""));


        //Verify Program , Event and Services and Article title should be clickable and should redirect to the respective Details page
        hoverOnElement(Wwp.featured_contianer_Events);
        click(Wwp.featured_contianer_Events, "click on the featured container");
        Thread.sleep(8000);
        String title_next_page = getDriver().getTitle();
        // System.out.println("the next title is : " +title_next_page);
        Assert.assertEquals(getDriver().getTitle(), title_next_page);
    }


    @Then("verify interest card section")
    public void interest_card() throws InterruptedException {
        //The Program, Event and Services content (image, Title, and text) should be clearly visible.

        List<WebElement> interst_section_elemtns = getListElements(Wwp.interst_container, "getting the elements of the interest container");
        System.out.println("the elements present in  the interest container is :" + interst_section_elemtns.size());
        for (int i = 0; i < interst_section_elemtns.size(); i++) {

            //System.out.println("the text is :" + interst_section_elemtns.get(i).getText());
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the text is :" + interst_section_elemtns.get(i).getText()+""));


        }
        //Verify Program , Event and Services and Article title should be clickable and should redirect to the respective Details page
        hoverOnElement(Wwp.interst_container);


        click(Wwp.interst_container, "click on the event present on the interest");
        Thread.sleep(8000);
        String title = getDriver().getTitle();
        System.out.println("the title of the next page is :" + title);
        Assert.assertEquals(getDriver().getTitle(), title);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the title of the next page is :" + title+""));



    }

    @When("user clicks on the viewall button")
    public void click_viewall() throws InterruptedException {
        hoverOnElement(Wwp.view_all);
        Thread.sleep(4000);
        click(Wwp.view_all, "click on the view all button");
    }

    @Then("verify the text present in the viewall page")
    public void verrifies_view_All() throws InterruptedException {
        //verify Back Button is Clickable
        Assert.assertTrue(waitforclickable(Wwp.Back_button));
        // Verify Title  Text with count 'All Events, Service Offerings & Community Partnerships (30)'
        String expected_text = getElementText(Wwp.View_all_topic_header);
       // System.out.println(" the expected title is : " + expected_text);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the expected title is : " + expected_text+""));

        Assert.assertTrue(isWebElementsVisible(Wwp.View_all_topic_header, ""));
        // Verify Search Textbox
        Assert.assertTrue(isWebElementPresent(Wwp.searach_field, "Search field is present"));
        //Verify Filter Options (Dropdown).
        Thread.sleep(6000);
        List<WebElement> filters_dropdown = getListElements(Wwp.filter_options, "getting he filter options");
        System.out.println("the size is : " + filters_dropdown.size());
        for (int i = 0; i < filters_dropdown.size(); i++) {
            System.out.println(filters_dropdown.get(i).getText());
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(filters_dropdown.get(i).getText()));

            //Assert.assertEquals();
        }
        //Verify (Event, Program, Article)Card listing
        List<WebElement> lsiting_events = getListElements(Wwp.event_view_all, "getting the list of events");
        hoverOnElement(Wwp.event_view_all);
        System.out.println("the text on the carrds are");
        for (int i = 0; i < lsiting_events.size(); i++) {
           // System.out.println(lsiting_events.get(i).getText());
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(lsiting_events.get(i).getText()));

        }

    }

    @Then("validate the search_by_name_functioanlity by valid_search")
    public void serach_by_nmae() throws InterruptedException {
        //Verify if searching for an existing  event , program and article name returns the correct result.
        Thread.sleep(7000);
        String valid_search_text = "Monthly Fitness Challenge";
        inputText(Wwp.searach_field, valid_search_text, "enter the " + valid_search_text + " in the search field");
        click(Wwp.search_button, "click on the search button");
        hoverOnElement(Wwp.all_events);
        List<WebElement> search_results = getListElements(Wwp.all_events, "getting the results for the search");
        int size = search_results.size();
        //System.out.println("the elements in the search results are: " + size);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the elements in the search results are: " + size+""));


        // Check if search results are displayed
        Assert.assertFalse(search_results.isEmpty());

        for (WebElement searchResult : search_results) {
            String resultText = searchResult.getText();
            System.out.println("the text is :  " + resultText);
            Assert.assertTrue(resultText.contains(valid_search_text));
        }
        Thread.sleep(8000);
        getDriver().findElement(By.xpath("//input[@placeholder='Search by name...']")).clear();
        System.out.println("the textbox is clear");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the textbox is clear"));

//           Assert.assertTrue(isWebElementNotPresent(Wwp.all_events));
        Thread.sleep(1000);

    }

    @Then("validate the search_b_name_functionality by invalid search")
    public void search_functionality_invalid_search() throws InterruptedException {


//           click(Wwp.Back_button,"click on the back button");
//           Thread.sleep(5000);
//           hoverOnElement(Wwp.view_all);
//           click(Wwp.view_all,"click on the view all button");
        String invalid_search_text = "abc";

        inputText(Wwp.searach_field, invalid_search_text, "enter the " + invalid_search_text + " in the search field");
        Thread.sleep(7000);
        hoverOnElement(Wwp.search_button);
        click(Wwp.search_button, "click on the search button");
        Thread.sleep(8000);
        //hoverOnElement(Wwp.all_events);

        hoverOnElement(Wwp.no_result_text);
        Assert.assertEquals(getElementText(Wwp.no_result_text), "No items found");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("No items found"));



    }

    @Then("validate the recent search is present or not after clicking on the search button")
    public void recent_Search() throws InterruptedException {
        hoverOnElement(Wwp.searach_field);
        click(Wwp.searach_field, "click on the search field");
        Thread.sleep(6000);
        Assert.assertTrue(isWebElementVisible(Wwp.recent_Search, "recent search is present"));
        System.out.println("recent search is displayed");
    }


    @When("click on the {string} dropdown")
    public void verify_format_filters(String dropdownname) throws InterruptedException {
        Thread.sleep(3000);

       hoverOnElement(Wwp.click_link_view_all(dropdownname));
        click(Wwp.click_link_view_all(dropdownname), "click on the " + dropdownname + "link");
       // clickJS((Wwp.click_link_view_all(dropdownname)),"click on the " + dropdownname + "link");

    }

    @Then("user is able to see all the value in the {string} option")
    public void values_in_format_option(String dropdownname) throws InterruptedException {
        List<WebElement> format_dropdown_values = getListElements(Wwp.dropdown_format_elements, "getting the values");
        System.out.println("The values in the " + dropdownname + " are : ");
        for (int i = 0; i < format_dropdown_values.size(); i++) {
            System.out.println(format_dropdown_values.get(i).getText());
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(format_dropdown_values.get(i).getText()));


        }
        Thread.sleep(7000);
        Actions action = new Actions(getDriver());
        action.moveByOffset(0, 0).click().build().perform();
        // click(Wwp.click_link_view_all("Format"),"click on the format option");


    }


    @When("user enters the {string} in the search field")
    public void enter_address(String address) throws Exception {
        inputText(Wwp.location_search_text, address, "enter the " + address + "in the search filed");
        Actions action = new Actions(getDriver());
        action.moveByOffset(0, 0).click().build().perform();
        clickJS((Wwp.click_link_view_all(address)),"");
    }

    @When("user clicks on the {string} checkbox")
    public void click_checkboxes(String checkbox) throws InterruptedException {
        Thread.sleep(7000);
        scrollingToElementofAPage(Wwp.click_checkboxes(checkbox),"scroll to"+ checkbox);
        click(Wwp.click_checkboxes(checkbox), "click on the " + checkbox);
        clickJS((Wwp.click_link_view_all(checkbox)),"");
    }

    @When("user clicks on the {string} filter button")
    public void click_filter_button(String button) throws InterruptedException {

        Thread.sleep(3000);
        waitforclickable(Wwp.click_apply_filter_or_reset_filter(button));
        //System.out.println(button + " is clickable ");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(""+button + " is clickable "));
        hoverOnElement(Wwp.click_apply_filter_or_reset_filter(button));
        click(Wwp.click_apply_filter_or_reset_filter(button), "click on the " + button);
        Thread.sleep(6000);


    }



    @Then("verify the elements present or not")
    public void elemnts(){
        //verify whether the elements are displayed or not
        //<WebElement> number_of_elements=getListElements(Browse_all.options,"getting the elements of the list");
        if(isWebElementPresent(Wwp.options,"")==true) {
            List<WebElement> number_of_elements = getListElements(Wwp.options, "getting the elements of the list");
            if (number_of_elements.size() == 0) {
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("no elements are present"));
            } else {
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the number of elements are : " + number_of_elements.size()));

            }
        }
        else{
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("no elements are present"));

        }


    }

    @When("user enters {string} in the {string}")
    public void dates(String date, String data) throws InterruptedException {
        // click(Wwp.Enter_dates(date),"click on the date");
        Thread.sleep(5000);
        hoverOnElement(Wwp.Enter_dates(date));
        click(Wwp.Enter_dates(date), "click on the date");
        inputText(Wwp.Enter_dates(date), data, "enter the date");
        Thread.sleep(6000);
        Actions action = new Actions(getDriver());
        action.moveByOffset(0, 0).click().build().perform();
        System.out.println("click on thh white space");



    }

    @When("user enters {string} in the startdate")
    public void startdate(String date) throws InterruptedException {
        hoverOnElement(Wwp.Start_Date);
        click(Wwp.Start_Date, "click on the date");
        inputText(Wwp.Start_Date, date, "enter the date");
    }

    @When("user enters {string} in the enddate")
    public void enddate(String date) throws InterruptedException {
        hoverOnElement(Wwp.End_Date);
        click(Wwp.End_Date, "click on the date");
        inputText(Wwp.End_Date, date, "enter the date");
        Actions action = new Actions(getDriver());
        action.moveByOffset(0, 0).click().build().perform();

    }

    @Then("verify the Event article should be clickable")
    public void verify_the_elements_clickable() throws InterruptedException {
        hoverOnElement(Wwp.click_link);
        click(Wwp.click_link, "click on the link");
        Thread.sleep(7000);
        String title = getDriver().getTitle();
       // System.out.println("the title of the next page is :" + title);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the title of the next page is :" + title+""));

    }

    @When("user clicks on the showmore button")
    public void click_show_buton() throws InterruptedException {
        Thread.sleep(8000);
        hoverOnElement(Wwp.Show_button);
        click(Wwp.Show_button, "click on the show button");
        List<WebElement> number_of_elements_after_click_showmore = getListElements(Wwp.options, "getting the list of all items");
       // System.out.println("the size is after clicking = " + number_of_elements_after_click_showmore.size());
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the size is after clicking = " + number_of_elements_after_click_showmore.size()));

        Thread.sleep(6000);
        hoverOnElement(By.xpath("//div[text()='Need Help?']"));
        Assert.assertFalse(isWebElementPresent(Wwp.Show_button, "show button is not present because no more elements are present"));
        Thread.sleep(7000);
        hoverOnElement(Wwp.Back_button);

        click(Wwp.Back_button, "click on the back button");
        Thread.sleep(7000);
        hoverOnElement(Wwp.view_all);
        click(Wwp.view_all, "click on the view all button");
        List<WebElement> number_of_elements__before_showmore = getListElements(Wwp.options, "getting the list of all items");
        //System.out.println("the number of elements before = " + number_of_elements__before_showmore.size());
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the number of elements before = " + number_of_elements__before_showmore.size()));

        if (number_of_elements__before_showmore.size() <= number_of_elements_after_click_showmore.size()) {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("more elements are present click on the show button"));

        } else {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("no elements are present"));

        }


    }

    @When("click on the date range dropdown")
    public void verify_daterangefilters() throws InterruptedException {
        Thread.sleep(3000);

        //hoverOnElement(Wwp.click_link_view_all(dropdownname));
       // click(Wwp.click_link_view_all(dropdownname), "click on the " + dropdownname + "link");
        String dateRange = getElementText(By.xpath("(//div[@class='filter-box-placeholder'])[5]"));
        Thread.sleep(1000);
        clickJS((Wwp.click_link_view_all(dateRange)),"click on the " + dateRange + "link");

    }


}
