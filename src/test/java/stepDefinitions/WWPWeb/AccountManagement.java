package stepDefinitions.WWPWeb;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.web.Wwp;
import stepDefinitions.RunCukesTest;
import utilities.GlobalUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

import java.time.Instant;
import java.util.List;

public class AccountManagement extends KeywordUtil {

    public static int category_count;
    public static int[] history_of_checkbox = new int[5];

    @And("Navigate To account management page")
    public void Navigate_to_Account_management_page() throws InterruptedException {

        Thread.sleep(2000);
        hoverOnElement(Wwp.userProfileIcon);
        click(Wwp.userProfileIcon, "click on user icon");
        hoverOnElement(Wwp.accountManagementLink);
        click(Wwp.accountManagementLink, "click on account management link");
        Thread.sleep(5000);
    }

    @And("click on view link to Navigate to {string} page")
    public void click_on_view_link(String Category_name) throws InterruptedException {
        click(Wwp.viewLinkOnAccountManagement(Category_name), "click on view link in front of " + Category_name);
        Thread.sleep(4000);
        Assert.assertTrue(isWebElementsVisible(Wwp.myEventsPageHeadingUnderAccountManagement,Category_name));
    }

    @Then("Verify user can update my interest section")
    public void user_can_update_my_interest_secion() throws InterruptedException {
        hoverOnElement(Wwp.firstCheckboxOnMyInterestsPage);
        click(Wwp.firstCheckboxOnMyInterestsPage, "click on first checkbox on interest page");
        Thread.sleep(1000);
        hoverOnElement(Wwp.saveButtonOnMyInterestPage);
        click(Wwp.saveButtonOnMyInterestPage, "click on save button");
        Assert.assertTrue(isWebElementsVisible(Wwp.successPopupOnMyInterestPage, "success popup"));

    }

    @Then("unselect all the checkboxes under benefit and services")
    public void Unselect_all_checkboxes_under_benefit_services() throws InterruptedException {
        try {
           hoverOnElement(Wwp.benefitServiceAccount);
           click(Wwp.benefitServiceAccount,"click on Plus button to open benefit services");

            }
        catch (Exception e) {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Benefit services already opened"));
        }

        List<WebElement> checkboxes = getListElements(Wwp.checkboxesUnderBenefit_Services, "getting list of checkboxes under benefit and services");
//       public static int[] history_of_checkbox = new int[checkboxes.size() + 1];
        for (int i = 1; i <= checkboxes.size(); i++) {


//            if(checkboxes.get(i).isSelected()){
//
//            }
            Thread.sleep(1000);
            if (isCheckBoxSelected(Wwp.getCheckboxesUnderBenefit_Services_with_index(i), "checkbox " + i + "")) {
                history_of_checkbox[i] = 0;
                hoverOnElement(Wwp.getCheckboxesUnderBenefit_Services_with_index(i));
                click(Wwp.getCheckboxesUnderBenefit_Services_with_index(i), "clicked on checkbox " + i);
            } else {
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("check box " + i + " not selected"));
                history_of_checkbox[i] = 1;
            }

        }
        Thread.sleep(1000);
        hoverOnElement(Wwp.saveButtonOnMyInterestPage);
        click(Wwp.saveButtonOnMyInterestPage, "click on save button");
        Assert.assertTrue(isWebElementsVisible(Wwp.successPopupOnMyInterestPage, "success popup"));

    }

    @And("count the categories present on for you page")
    public void count_the_categories_present() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> category_name = getListElements(Wwp.forYouMultipleCategoryNames,"fetching the Number of categories");
        category_count  = category_name.size();
        System.out.println(category_count);
    }

    @Then("Verify category count got updated after changing my interest page")
    public void verify_category_count_updation() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> category_name = getListElements(Wwp.forYouMultipleCategoryNames,"fetching the Number of categories");
        int category_count_new = category_name.size();
        Assert.assertTrue(category_count_new<category_count);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("new category count is "+category_count_new+" is less than old count "+category_count));

    }

    @And("setting the checkboxes under benefits services to default")
    public void Setting_the_checkboxes_to_default() throws InterruptedException {
        Navigate_to_Account_management_page();
        click_on_view_link("My Interests");
        try {
            hoverOnElement(Wwp.benefitServiceAccount);
            click(Wwp.benefitServiceAccount,"click on Plus button to open benefit services");

        }
        catch (Exception e) {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Benefit services already opened"));
        }
        for(int i = 1 ; i <=4 ; i++){
            if(history_of_checkbox[i] == 0){
                hoverOnElement(Wwp.getCheckboxesUnderBenefit_Services_with_index(i));
                click(Wwp.getCheckboxesUnderBenefit_Services_with_index(i), "clicked on checkbox " + i);
            }
        }
        user_can_update_my_interest_secion();
    }

    @Then("verify field validation for {string}")
    public void Field_validation(String category) throws InterruptedException {
        hoverOnElement(Wwp.updateLinkUnderContactInfo(category));
        click(Wwp.updateLinkUnderContactInfo(category),"click on update link of "+category);
        Thread.sleep(1000);
        Assert.assertTrue(isWebElementsVisible(Wwp.inputFieldUnderContact, category+" field " ));
    }

    @And("click on back link")
    public void Click_on_go_Back_link() throws InterruptedException {
        hoverOnElement(Wwp.gobackLink);
        click(Wwp.gobackLink,"Click on go back link");
        Thread.sleep(1000);
    }

    @And("Verify state names {string} , {string} , {string}")
    public void verify_state_names(String state1,String state2,String state3) throws InterruptedException {
        hoverOnElement(Wwp.updateLinkUnderContactInfo("Address"));
        click(Wwp.updateLinkUnderContactInfo("Address"),"clicked on update link");
        hoverOnElement(Wwp.countryInputField);
        click(Wwp.countryInputField,"clicked on country input field");
        inputText(Wwp.searchCountryField,"United states","input text in country search field");
        click(Wwp.searchedCountryResult,"clicked on searched result");
        hoverOnElement(Wwp.stateInputField);
        click(Wwp.stateInputField,"clicked on state drop-down");
        inputText(Wwp.searchStateInputField,"armed forces","input text armed forces state search field");
        Assert.assertTrue(isWebElementsVisible(Wwp.searchStateResult(state1), state1+" "));
        Assert.assertTrue(isWebElementsVisible(Wwp.searchStateResult(state2), state2+" "));
        Assert.assertTrue(isWebElementsVisible(Wwp.searchStateResult(state3), state3+" "));
        click(Wwp.searchStateResult(state1),"clicked on "+state1);
        Thread.sleep(1000);
        hoverOnElement(Wwp.gobackLink);
        click(Wwp.gobackLink,"click on go back link");
    }

    @Then("verify email can be updated to {string}")
    public void verify_email_can_be_updated(String new_email) throws InterruptedException {
        hoverOnElement(Wwp.updateLinkUnderContactInfo("Email"));
        click(Wwp.updateLinkUnderContactInfo("Email"),"click on update link ");
        hoverOnElement(Wwp.inputFieldUnderContact);
        clearInput(Wwp.inputFieldUnderContact);
        inputText(Wwp.inputFieldUnderContact,new_email,"input "+new_email+" under input field");
        click(Wwp.save_button_underContactUpdate,"click on save button");
        Thread.sleep(3000);
        Assert.assertTrue(isWebElementsVisible(Wwp.successToastPopup, "email successfully got updated"));
    }

    @And("resetting email to default {string}")
    public void resetting_email_to_default(String old_email) throws InterruptedException {
        hoverOnElement(Wwp.updateLinkUnderContactInfo("Email"));
        click(Wwp.updateLinkUnderContactInfo("Email"),"click on update link ");
        hoverOnElement(Wwp.inputFieldUnderContact);
        clearInput(Wwp.inputFieldUnderContact);
        inputText(Wwp.inputFieldUnderContact,old_email,"input "+old_email+" under input field");
        click(Wwp.save_button_underContactUpdate,"click on save button");
        Thread.sleep(3000);
    }

    @Then("verify mobile number is {string} can be updated")
    public void verify_phone_number_can_be_updated(String number) throws Exception {
        Thread.sleep(2000);
        hoverOnElement(Wwp.updateLinkUnderContactInfo("Mobile Phone"));
        click(Wwp.updateLinkUnderContactInfo("Mobile Phone"),"click on update link ");
        Thread.sleep(1000);
        click(Wwp.countryDropdownArrowUnderPhoneUpdate,"click on country selecting dropdown arrow");
        hoverOnElement(Wwp.unitedStatesInCountryDropdown);
        click(Wwp.unitedStatesInCountryDropdown, "clicked on Us country code");
        Thread.sleep(2000);

        WebElement element = GlobalUtil.getDriver().findElement(Wwp.phoneNumber);
        ((JavascriptExecutor) GlobalUtil.getDriver()).executeScript("arguments[0].value='"+number+"'", element);
        hoverOnElement(Wwp.countryDropdownArrowUnderPhoneUpdate);
        click(Wwp.countryDropdownArrowUnderPhoneUpdate,"click on country selecting dropdown arrow");
        hoverOnElement(Wwp.unitedKingdomInCountryDropdown);
        click(Wwp.unitedKingdomInCountryDropdown, "clicked on Us country code");
        Thread.sleep(2000);
        click(Wwp.save_button_underContactUpdate,"click on save button");
        Thread.sleep(3000);
        Thread.sleep(3000);
        Assert.assertTrue(isWebElementsVisible(Wwp.successToastPopup, "email successfully got updated"));
    }

    @Then("Verify Address can be updated By changing street to {string}")
    public void Verify_address_can_be_updated(String street) throws InterruptedException {
        Thread.sleep(2000);
        hoverOnElement(Wwp.updateLinkUnderContactInfo("Address"));
        click(Wwp.updateLinkUnderContactInfo("Address"),"click on update link ");
        hoverOnElement(Wwp.streetInputField);
        clearInput(Wwp.streetInputField);
        inputText(Wwp.streetInputField,street,"input "+street+" into street input field");
        Thread.sleep(1000);
        hoverOnElement(Wwp.save_button_underContactUpdate);
        click(Wwp.save_button_underContactUpdate,"click on save button");
        Thread.sleep(3000);
        Assert.assertTrue(isWebElementsVisible(Wwp.successToastPopup, "Address successfully got updated"));
    }

    @And("Navigate to About Me page")
    public void Navigate_to_about_me_page() throws InterruptedException {
        hoverOnElement(Wwp.addLinkOnAccountManagement);
        click(Wwp.addLinkOnAccountManagement,"click on Add link");
        Thread.sleep(2000);
        Assert.assertTrue(isWebElementsVisible(Wwp.aboutMePageHeading,"About Me Page Heading"));
    }

    @Then("Verify User can type free text for About Me section")
    public void Verify_user_can_type_free_text() throws InterruptedException {
        hoverOnElement(Wwp.TellusBitAboutYouInputField);
        clearInput(Wwp.TellusBitAboutYouInputField);
        inputText(Wwp.TellusBitAboutYouInputField,"Helllo ","input text inside about me input field");
        hoverOnElement(Wwp.save_button_underContactUpdate);
        click(Wwp.save_button_underContactUpdate,"clicked on save button");
        Thread.sleep(3000);
        Assert.assertTrue(isWebElementsVisible(Wwp.successToastPopup, "Address successfully got updated"));
    }

    @Then("Verify 'View Privacy Link' functionality on about me page")
    public void Verify_view_privacy_link_functionality() throws InterruptedException {
        hoverOnElement(Wwp.viewPrivacySettingLink);
        click(Wwp.viewPrivacySettingLink,"Clicked ob view privacy settings Link");
        Thread.sleep(2000);
        Assert.assertTrue(isWebElementsVisible(Wwp.PrivacySettingspageHeading, "Privacy settings heading "));
    }

    @And("click on update link to Navigate to Notifications page")
    public void click_on_update_link_of_notification() throws InterruptedException {

        hoverOnElement(Wwp.updateAccount);
        click(Wwp.updateAccount, "click on update link in front of Notifications" );
        Thread.sleep(2000);
        Assert.assertTrue(isWebElementsVisible(Wwp.notificationPageHeading,"notification page heading"));
    }

    @And("click on update link to Navigate to {string} page")
    public void click_on_update_link(String Category) throws InterruptedException {
        hoverOnElement(Wwp.updateLinkOnAccountManagement(Category));
        click(Wwp.updateLinkOnAccountManagement(Category), "click on update link in front of " + Category);
        Thread.sleep(2000);
        Assert.assertTrue(isWebElementsVisible(Wwp.pagesHeadingOfAccountManagementCategories(Category),Category + " heading "));
    }

    @Then("Verify Email notification settings")
    public void Verify_email_notification_settings() throws InterruptedException {
       hoverOnElement(Wwp.notificationsettings("Connection Requests"));
       Assert.assertTrue(isWebElementsVisible(Wwp.notificationsettings("Connection Requests"),"Connection Requests settings"));
        hoverOnElement(Wwp.notificationsettings("Direct messages"));
        Assert.assertTrue(isWebElementsVisible(Wwp.notificationsettings("Direct messages"),"Direct messages settings"));
        hoverOnElement(Wwp.notificationsettings("Account Updates"));
        Assert.assertTrue(isWebElementsVisible(Wwp.notificationsettings("Account Updates"),"Account Updates settings"));

    }

    @Then("Verify categories available on events page")
    public void Verify_Categories_available_on_events_page() throws InterruptedException {
        Assert.assertTrue(isWebElementsVisible(Wwp.categoryNameOnEventsAccountManagement("Accepted"),"Accepted category"));
        hoverOnElement(Wwp.categoryNameOnEventsAccountManagement("Waitlisted"));
        Assert.assertTrue(isWebElementsVisible(Wwp.categoryNameOnEventsAccountManagement("Waitlisted"),"Waitlisted category"));
        hoverOnElement(Wwp.categoryNameOnEventsAccountManagement("Pending"));
        Assert.assertTrue(isWebElementsVisible(Wwp.categoryNameOnEventsAccountManagement("Pending"),"Pending category"));
        hoverOnElement(Wwp.categoryNameOnEventsAccountManagement("Event History"));
        Assert.assertTrue(isWebElementsVisible(Wwp.categoryNameOnEventsAccountManagement("Event History"),"Event History category"));

    }

    @Then("verify functionality of Stay Visible Radio Button")
    public void verify_stay_visible_radio_button_functionality() throws InterruptedException {

        if(isRadioSelected(Wwp.stayVisibleRadioButton,"Stay Visible Radio button")){
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Stay Visible Radio Button already Selected"));
        }
        else {
            click(Wwp.stayVisibleRadioButton,"click on Stay Visible Radio Button");
            hoverOnElement(Wwp.save_button_underContactUpdate);
            click(Wwp.save_button_underContactUpdate,"click on Save Button");
            Thread.sleep(10000);
        }
        hoverOnElement(Wwp.homepageHeaderLink("Groups"));
        click(Wwp.homepageHeaderLink("Groups"),"clicked on Groups link");
        Thread.sleep(3000);
        hoverOnElement(Wwp.firstLikeLinkUnderGroupsPosts);
        Assert.assertTrue(isWebElementsVisible(Wwp.firstLikeLinkUnderGroupsPosts,"like link visible "));

   }

   @Then("verify functionality of Go Private Radio Button")
    public void verify_functionality_of_go_private_radio_button() throws InterruptedException {
       if(isRadioSelected(Wwp.goPrivateRadioButton,"Stay Visible Radio button")){
           RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Go Private Radio Button already Selected"));
       }
       else {
           click(Wwp.goPrivateRadioButton,"click on Go Private Radio Button");
           hoverOnElement(Wwp.save_button_underContactUpdate);
           click(Wwp.save_button_underContactUpdate,"click on Save Button");
           Thread.sleep(10000);
       }
       hoverOnElement(Wwp.homepageHeaderLink("Groups"));
       click(Wwp.homepageHeaderLink("Groups"),"clicked on Groups link");
       Thread.sleep(3000);
      // hoverOnElement(Wwp.privateNoteAlertOnGroupsPAge);
      // Thread.sleep(3000);
       Assert.assertTrue(isWebElementsVisible(Wwp.privateNoteAlertOnGroupsPAge,"Private Note  "));

   }

   @And("click on Lean More link")
    public void click_on_learn_more_link() throws InterruptedException {
        hoverOnElement(Wwp.learnMoreLink);
        click(Wwp.learnMoreLink,"click on learn more link");

   }

   @Then("verify popup is visible")
    public void verify_popup_is_visible() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(isWebElementsVisible(Wwp.privacySettingsPopupHeading,"privacy setting heading on popup"));
        hoverOnElement(Wwp.closeAccount);
        click(Wwp.closeAccount,"clicked on close button");

   }

   @And("click on update password link")
    public void click_on_update_password_link() throws InterruptedException {
        hoverOnElement(Wwp.updateLinkForPasswordUpdate);
        click(Wwp.updateLinkForPasswordUpdate,"click on update password link");
        hoverOnElement(Wwp.yesButtonOnUpdatePasswordPopup);
        click(Wwp.yesButtonOnUpdatePasswordPopup,"click on yes button ");
   }

}
