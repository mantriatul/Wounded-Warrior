package stepDefinitions.WWPWeb;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.web.Wwp;
import stepDefinitions.RunCukesTest;
import utilities.ExcelDataUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

import java.util.HashMap;
import java.util.List;

public class People extends KeywordUtil {

    public static HashMap<String, String> dataMap = new HashMap<String, String>();

    @And("User click on People tab")
    public void clickOnPeopleTab() throws InterruptedException {
        scrollingToElementofAPage(Wwp.peopleTitle,"");
        click(Wwp.peopleTitle,"Click on People tab");
        Assert.assertEquals(getElementText(Wwp.peopleBannerTitle),"People");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.format("People Banner is visible  ")));
        Assert.assertEquals(getElementText(Wwp.PeopleBannerSubTitle),"Connect with other warriors, family members, and caregivers");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.format("Connect with other warriors, family members, and caregivers")));
    }

    @And("Verify contents on the people page")
    public void verifyPeopleContent(){
        Assert.assertTrue(isWebElementPresent(Wwp.peopleFind,"Find is present"));
        Assert.assertTrue(isWebElementPresent(Wwp.connect,"connect is present"));
        Assert.assertTrue(isWebElementPresent(Wwp.chat,"Chat is present"));
        Assert.assertTrue(isWebElementPresent(Wwp.findText,"Find Text is present"));
        Assert.assertTrue(isWebElementPresent(Wwp.connectText,"connect Text is present"));
        Assert.assertTrue(isWebElementPresent(Wwp.chatText,"Chat Text is present"));
        Assert.assertTrue(isWebElementPresent(Wwp.peopleMilitaryBranch,"Military Branch is present"));
        Assert.assertTrue(isWebElementPresent(Wwp.peopleLocation,"Location is present"));
        Assert.assertTrue(isWebElementPresent(Wwp.peopleSortBy,"SortBy is present"));
    }
    @And("Verify Informational text on People page")
    public void verifyInformationalText(){
        Assert.assertTrue(isWebElementPresent(Wwp.peopleFind,"Find is present"));
        Assert.assertTrue(isWebElementPresent(Wwp.connect,"connect is present "));
        Assert.assertTrue(isWebElementPresent(Wwp.chat,"Chat is present"));
        Assert.assertEquals(getElementText(Wwp.findText),"Search to find warriors and family support members with similar experience");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.format("Search to find warriors and family support members with similar experience is visible")));
        Assert.assertEquals(getElementText(Wwp.connectText),"Reach out to others to create relationships and build your network");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.format("Reach out to others to create relationships and build your network is visible")));
        Assert.assertEquals(getElementText(Wwp.chatText),"Stay in touch with your connections with private messaging and more");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.format("Stay in touch with your connections with private messaging and more is visible")));

    }
    @And("Verify instructions and suggested connections should visible")
    public void verify_1_2_3instructionsandsuggestedconnections(){
        int text = Integer.parseInt(getElementText(Wwp.peopleMyConnection).split("Connections ")[1].substring(1,2));

        if(text<=3){
            Assert.assertTrue(isWebElementVisible(Wwp.peopleFind,"Find"));
       Assert.assertTrue(isWebElementVisible(Wwp.connect,"connect"));
       Assert.assertTrue(isWebElementVisible(Wwp.chat,"Chat"));

        }
        else{
       Assert.assertFalse(isWebElementPresent(Wwp.peopleFind,"Find is not visible"));
       Assert.assertFalse(isWebElementPresent(Wwp.connect,"connect is not visible"));
       Assert.assertFalse(isWebElementPresent(Wwp.chat,"Chat is not visible"));
        }
        if(isWebElementPresent(Wwp.suggestionList,"")) {
            List<WebElement> List = getListElements(Wwp.suggestionList, "Getting suggestion list");
            if (List.size() > 0) {

                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Suggested Connection is present"));
            }
            else{
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Suggested Connection is not present"));
            }

            }

    }

    @Then("Verify People list includes Warriors and FSMs")
    public void verify_people_list_includes_warriors_and_fsms() throws InterruptedException {
        if(isWebElementVisible(Wwp.showMoreButtonPeople,"Show Button")){
            while(isWebElementPresent(Wwp.showMoreButtonPeople,"Show more button is present")) {
                scrollingToElementofAPage(Wwp.showMoreButtonPeople, "scroll to show more");
                Thread.sleep(1000);
                click(Wwp.showMoreButtonPeople,"click on show more");
            }
        }
        List<WebElement> suggestedPersonsImage = getListElements(Wwp.suggestedPersonsImage,"getting the list of suggested connection names");

        for(int i=1;i<=suggestedPersonsImage.size();i++){
            scrollingToElementofAPage(Wwp.suggestedPersonsImageindex(i),"Scroll to Profile");
            click(Wwp.suggestedPersonsImageindex(i),"click on profile");
            //suggestedPersonsImage.get(i).click();
            String personCategory=getElementText(Wwp.personCategory);
            if(personCategory.equalsIgnoreCase("fsm")||personCategory.equalsIgnoreCase("warrior")){

                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(personCategory+ " role is present in user profile"));

            }else{
                Assert.fail(personCategory+ "role is not present");
            }
            if(!personCategory.equalsIgnoreCase("Teammates")){
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor( " Teammates role is not present in user profile"));

            }else{
                Assert.fail(personCategory+ "role is  present in user profile");
            }

            click(Wwp.closeButton,"Clicking on close button");
        }

    }

    @Then("Verify user can able to view list of My Connections")
    public void verify_list_of_my_connections_who_have_accepted_connection_requests_from_the_user() {
        List<WebElement> connectedPersonsCard=getListElements(Wwp.connectedPersonsCard,"connected Persons Card list");
        for(int i=0;i<connectedPersonsCard.size();i++){
            Assert.assertTrue(connectedPersonsCard.get(i).isDisplayed(),"Connected Persons card is display");
        }
    }
    @Then("Verify user can view details in My Connections list")
    public void verify_informationlist() throws InterruptedException {
        List<WebElement> connectedPersonsCard=getListElements(Wwp.connectedPersonsCard,"connected Persons Card list");
        List<WebElement> connectedPersonsMessage=getListElements(Wwp.connectedPersonsMessage,"connected Persons Message list");

        System.out.println(connectedPersonsCard.size());
        for(int i=1;i<=connectedPersonsCard.size();i++){

            String image = getElementText(Wwp.connectedPersonsImageindex(i));
            isWebElementVisible(Wwp.connectedPersonsImageindex(i),image);
            String user = getElementText(Wwp.connectedPersonsUsernameindex(i));
            isWebElementVisible(Wwp.connectedPersonsUsernameindex(i),user);

            isWebElementVisible(Wwp.connectedPersonsMessageindex(i),"Message icon in "+user);

            if(isWebElementPresent(Wwp.connectedPersonsLocationindex(i),"")==true){
                String Location = getElementText(Wwp.connectedPersonsLocationindex(i));

                isWebElementsVisible(Wwp.connectedPersonsLocationindex(i),Location);


            }
            else {
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor( "Location is not present in "+ user));

            }

        }
        String user = getElementText(Wwp.connectedPersonsUsernameindex(1));
       click(Wwp.connectedPersonsMessageindex(1),"click on message icon");
       Assert.assertTrue(isWebElementsVisible(Wwp.message_box,user+ "inbox"));
    }

    @Then("Verify User should be able to search all other warriors and FSM")
    public void verify_user_should_be_able_to_search_all_other_warriors_and_fsm() throws InterruptedException {
        scrollingToElementofAPage(Wwp.peopleSearch,"people search is display");
        inputText(Wwp.peopleSearch,"Rohit","Searching worriers and FSMs");
        click(Wwp.peopleSearchSubmit,"clicking on search icon");
        verifyDisplayAndEnable(Wwp.searchResultPersonsCard,"search result person card");
        scrollingToElementofAPage(Wwp.searchClear,"search clear is display");
        click(Wwp.searchClear,"Clicking on search clear button");
    }
    @Then("Verify the recent searches will be recommended in the search dropdown after search of any text")
    public void verify_the_recent_searches_will_be_recommended_in_the_search_dropdown_after_search_of_any_text() {
        click(Wwp.peopleSearch,"Click on input search box");
        verifyDisplayAndEnable(Wwp.recentSearch,"Recent search dropdown is display");
    }
    @Then("Verify Search match should be work on all potential First name and Last name")
    public void verify_search_match_should_be_work_on_all_potential_first_name_and_last_name() throws InterruptedException {
        scrollingToElementofAPage(Wwp.peopleSearch,"people search is display");
        inputText(Wwp.peopleSearch,"Thakur","Searching worriers and FSMs");
        click(Wwp.peopleSearchSubmit,"clicking on search icon");
        verifyDisplayAndEnable(Wwp.searchResultPersonsCard,"search result person card");
        scrollingToElementofAPage(Wwp.searchClear,"search clear is display");
        click(Wwp.searchClear,"Clicking on search clear button");

    }

    @Then("Verify the visibility of filters  on the My Connections and Suggested For You sections, as well as Search Results")
    public void verify_the_user_can_filter_the_people_shown_on_the_my_connections_and_suggested_for_you_sections_as_well_as_search_results() throws InterruptedException {
        scrollingToElementofAPage(Wwp.myConnectionMilitaryBranchFilter,"My Connection is display");
        verifyDisplayAndEnable(Wwp.myConnectionMilitaryBranchFilter,"My connection military branch filter is displaying");
        verifyDisplayAndEnable(Wwp.myConnectionLocationFilter,"My connection location filter is displaying");
        scrollingToElementofAPage(Wwp.suggestedMilitaryBranchFilter,"Suggested List is display");
        verifyDisplayAndEnable(Wwp.suggestedMilitaryBranchFilter,"Suggested military branch filter is displaying");
        verifyDisplayAndEnable(Wwp.suggestedLocationFilter,"Suggested Location branch filter is displaying");
        scrollingToElementofAPage(Wwp.peopleSearch,"people search is display");
        inputText(Wwp.peopleSearch,"Rohit","Searching worriers and FSMs");
        click(Wwp.peopleSearchSubmit,"clicking on search icon");
        scrollingToElementofAPage(Wwp.resultsMilitaryBranchFilter,"Search results is display");
        verifyDisplayAndEnable(Wwp.resultsMilitaryBranchFilter,"Search Results military branch filter is displaying");
        verifyDisplayAndEnable(Wwp.resultsLocationFilter,"Search Results Location filter is displaying");
        scrollingToElementofAPage(Wwp.searchClear,"search clear is display");
        click(Wwp.searchClear,"Clicking on search clear button");

        }



    @Then("Verify user can apply Location filter in My connection")
    public void verify_locationFilter() throws InterruptedException {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("WWP", "Testdata1");
        scrollingToElementofAPage(Wwp.myConnectionLocationFilter,"scroll to location filter");
        click(Wwp.myConnectionLocationFilter,"Clicking on My connection location filter");
        inputText(Wwp.connectedSearchStates,dataMap.get("Location"),"Search for "+ dataMap.get("Location"));
        click(Wwp.connectedSelectState(dataMap.get("Location")),"select checkbox: " + dataMap.get("Location"));
        click(Wwp.myConnectionInsideLocationFilter,"Clicking on My connection location filter");
        List<WebElement> connectedPersonsCard=getListElements(Wwp.connectedPersonsCard,"connected Persons Card list");
        for(int i=1;i<=connectedPersonsCard.size();i++) {

            String user = getElementText(Wwp.connectedPersonsUsernameindex(i));
            if (isWebElementPresent(Wwp.connectedPersonsLocationindex(i), "") == true) {
                String Location = getElementText(Wwp.connectedPersonsLocationindex(i));
                isWebElementsVisible(Wwp.connectedPersonsLocationindex(i), Location);

            } else {
                RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor(dataMap.get("Location")+" is not present in " + user));

            }
        }
        click(Wwp.connectedClearFilters,"clear filter");

    }

    @Then("Verify user can apply Military Branch filter in suggested for you")
    public void verify_MilitaryFilter() throws InterruptedException {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("WWP", "Testdata1");
        scrollingToElementofAPage(Wwp.suggestedMilitaryBranchFilter,"scroll to Military filter is display");
        click(Wwp.suggestedMilitaryBranchFilter,"Clicking Military filter on suggested for you");
        scrollingToElementofAPage(Wwp.suggestedSelectMiltaryBranch(dataMap.get("Military Branch")),"scroll to "+ dataMap.get("Military Branch"));
        click(Wwp.suggestedSelectMiltaryBranch(dataMap.get("Military Branch")),"select checkbox: "+dataMap.get("Military Branch"));
        scrollingToElementofAPage(Wwp.suggestedInsideMilitaryFilter,"scroll to Military filter");
        click(Wwp.suggestedInsideMilitaryFilter,"Clicking on suggested Military branch filter");
        List<WebElement> suggestedPersonsImage = getListElements(Wwp.suggestedPersonsImage,"getting the list of suggested connection names");
        for(int i=1;i<=suggestedPersonsImage.size();i++){
            scrollingToElementofAPage(Wwp.suggestedPersonsImageindex(i),"Scroll to Profile");
            click(Wwp.suggestedPersonsImageindex(i),"click on profile");
                String MilitaryCategory=getElementText(Wwp.MiltaryCategory);
                if(MilitaryCategory.equalsIgnoreCase(dataMap.get("Military Branch"))){

                    RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(MilitaryCategory+ " is present in user profile"));

                }else{
                    Assert.fail(MilitaryCategory+ "role is not present");
                }
                click(Wwp.closeButton,"Clicking on close button");
        }
        click(Wwp.suggestedClearFilters,"clear filter");


    }
    @Then("Verify Location option includes a list of US states")
    public void verify_location_option_includes_a_list_of_us_states() throws InterruptedException {
        scrollingToElementofAPage(Wwp.myConnectionLocationFilter,"location filter is display");
        click(Wwp.myConnectionLocationFilter,"Clicking on My connection location filter");
        List<WebElement> usStateList=getListElements(Wwp.usStateList,"US State List");
        int usStateCount=usStateList.size();
        for(int i=0;i<usStateCount;i++){
            Assert.assertTrue(usStateList.get(i).isDisplayed(),"US State List is not display");
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor( usStateList.get(i).getText()));
        }
        click(Wwp.myConnectionInsideLocationFilter,"Clicking on My connection location filter");


    }

    @Then("Verify user can apply Location filter in Suggested for you")
    public void verify_locationFilterinSuggestedForyou() throws InterruptedException {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("WWP", "Testdata1");
        scrollingToElementofAPage(Wwp.suggestedLocationFilter,"scroll to location filter");
        click(Wwp.suggestedLocationFilter,"Clicking on My connection location filter");
        inputText(Wwp.suggestedSearchStates,dataMap.get("Location"),"Search for "+ dataMap.get("Location"));
        click(Wwp.suggestedSelectState(dataMap.get("Location")),"select checkbox: " + dataMap.get("Location"));
        click(Wwp.suggestedInsideLocationFilter,"Clicking on My connection location filter");
        List<WebElement> suggestedPersonsCard=getListElements(Wwp.suggestedPersonsCard,"connected Persons Card list");
        for(int i=1;i<=suggestedPersonsCard.size();i++) {

            String user = getElementText(Wwp.suggestedPersonsUsernameindex(i));
            if (isWebElementPresent(Wwp.suggestedPersonsLocationindex(i), "") == true) {
                String Location = getElementText(Wwp.suggestedPersonsLocationindex(i));
                isWebElementsVisible(Wwp.suggestedPersonsLocationindex(i), Location);

            } else {
                RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor(dataMap.get("Location")+" is not present in " + user));

            }
        }
        click(Wwp.suggestedClearFilters,"clear filter");

    }

    @Then("select profile picture in the list to view the Warrior Profile and verify profile details")
    public void verify_user_should_be_able_to_select_a_warrior_name_or_profile_picture_in_the_list_to_view_the_warrior_profile() throws InterruptedException {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("WWP", "Testdata1");
        scrollingToElementofAPage(Wwp.suggestedLocationFilter,"scroll to location filter");
        click(Wwp.suggestedLocationFilter,"Clicking on My connection location filter");
        inputText(Wwp.suggestedSearchStates,dataMap.get("Location"),"Search for "+ dataMap.get("Location"));
        click(Wwp.suggestedSelectState(dataMap.get("Location")),"select checkbox: " + dataMap.get("Location"));
        click(Wwp.suggestedInsideLocationFilter,"Clicking on My connection location filter");
        scrollingToElementofAPage(Wwp.suggestedMilitaryBranchFilter,"scroll to Military filter is display");
        click(Wwp.suggestedMilitaryBranchFilter,"Clicking Military filter on suggested for you");
        scrollingToElementofAPage(Wwp.suggestedSelectMiltaryBranch(dataMap.get("Military Branch")),"scroll to "+ dataMap.get("Military Branch"));
        click(Wwp.suggestedSelectMiltaryBranch(dataMap.get("Military Branch")),"select checkbox: "+dataMap.get("Military Branch"));
        scrollingToElementofAPage(Wwp.suggestedInsideMilitaryFilter,"scroll to Military filter");
        click(Wwp.suggestedInsideMilitaryFilter,"Clicking on suggested Military branch filter");

        List<WebElement> suggestedPersonsImage = getListElements(Wwp.suggestedPersonsImage,"getting the list of suggested connection names");

        for(int i=1;i<=suggestedPersonsImage.size();i++){
            scrollingToElementofAPage(Wwp.suggestedPersonsImageindex(i),"Scroll to Profile");
            click(Wwp.suggestedPersonsImageindex(i),"click on profile");
            String personCategory=getElementText(Wwp.personCategory);
            System.out.println(personCategory);
            if(personCategory.equalsIgnoreCase("warrior")){
                String militaryCategory=getElementText(Wwp.MiltaryCategory);
                String imageProfile= getElementText(Wwp.imageProfile);
                String aboutMeProfile=getElementText(Wwp.aboutmeProfile);
                String usernameProfile=getElementText(Wwp.usernameProfile);

                String locationProfile=getElementText(Wwp.LocationProfile);
                isWebElementVisible(Wwp.usernameProfile,usernameProfile);
                isWebElementVisible(Wwp.personCategory,personCategory);
                isWebElementVisible(Wwp.imageProfile,imageProfile+" image");
                isWebElementVisible(Wwp.connectProfile,"connect button");
                if(isWebElementPresent(Wwp.LocationProfile,"Location")==true){
                    isWebElementVisible(Wwp.LocationProfile,locationProfile);
                }
                if(isWebElementPresent(Wwp.MiltaryCategory,"Military")==true){
                    isWebElementVisible(Wwp.MiltaryCategory,militaryCategory);
                }
                if(isWebElementPresent(Wwp.aboutmeProfile,"Aboutme")==true){
                    isWebElementVisible(Wwp.aboutmeProfile,aboutMeProfile);
                }
            }

            click(Wwp.closeButton,"Clicking on close button");
        }
    }

    @Then("Verify Profile data includes user-input profile image, location, military branch, bio, user’s connections, and option to Connect")
    public void verify_profile_data_includes_user_input_profile_image_location_military_branch_bio_user_s_connections_and_option_to_connect() throws InterruptedException {
        scrollingToElementofAPage(Wwp.userCardName,"Name is display");
        click(Wwp.userCardName,"Name is clickable");
        verifyDisplayAndEnable(Wwp.popupUserName,"UserName is display");
        verifyDisplayAndEnable(Wwp.category,"category is display");
        verifyDisplayAndEnable(Wwp.connectedSince,"Connection since is display");
        verifyDisplayAndEnable(Wwp.sendMessage,"Send message is display");
        verifyDisplayAndEnable(Wwp.removeConnection,"Remove connection is display");
        verifyDisplayAndEnable(Wwp.location,"Location is display");
        click(Wwp.goBackButton,"Clicking on go back link");
    }

    @Then("Verify can able to connect with other user")
    public void verifyconnectotheOtherUser() throws InterruptedException {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("WWP", "Testdata1");
        scrollingToElementofAPage(Wwp.peopleSearch,"people search is display");
        inputText(Wwp.peopleSearch,dataMap.get("User"),"Searching"+dataMap.get("User"));
        click(Wwp.peopleSearchSubmit,"clicking on search icon");
        verifyDisplayAndEnable(Wwp.searchResultPersonsCard,"UserName is display");
        click(Wwp.searchResultPersonsCard,"Clicking on User card");
        if(isWebElementPresent(Wwp.connectButton,"")==true) {
            click(Wwp.connectButton, "clicking on connect");
            isWebElementVisible(Wwp.pendingStatus,"Pending status");

        }
        else{
            click(Wwp.removeConnectionOnPopup,"Remove the connection");
            click(Wwp.yesButton,"click on yes");
            click(Wwp.searchResultPersonsCard,"Clicking on User card");
            click(Wwp.connectButton, "clicking on connect");
            isWebElementVisible(Wwp.pendingStatus,"Pending status");
        }
    }

    @Then("{string} the {string} request")
    public void approveTheRequest(String button, String name) throws InterruptedException {
        scrollingToElementofAPage(Wwp.requestButton(button, name), "");
        click(Wwp.requestButton(button, name), button + " the " + name + " request");
        if (button.equalsIgnoreCase("Approve")) {
            isWebElementVisible(Wwp.connecteduser(name), name + " request is approved and displayed in My connection list");
        }
        else{
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(  name + " request is denied"));

        }
    }

    @Then("Verify connected individuals can then message each other from the My Connections list view or the Profile view")
    public void verify_connected_individuals_can_then_message_each_other_from_the_my_connections_list_view_or_the_profile_view() throws InterruptedException {
        verifyDisplayAndEnable(Wwp.MsgIcon,"Message icon is display");
        click(Wwp.MsgIcon,"");
        inputText(Wwp.messageInputBox,"Hello,How Are you?" ,"Enter Message");
        Thread.sleep(3000);
        click(Wwp.submitButton,"Clicking on Submit button");
       isWebElementVisible(Wwp.sendMsgVerfication,"Hello,How Are you?");
    }
    @Then("Verify user can able to remove the connection")
    public void verify_connected_individuals_have_the_option_to_remove_connection_from_user_profile_at_any_time() throws InterruptedException {
        scrollingToElementofAPage(Wwp.peopleSearch,"people search is display");
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("WWP", "Testdata1");
        inputText(Wwp.peopleSearch,dataMap.get("User"),"Searching "+dataMap.get("User"));
        click(Wwp.peopleSearchSubmit,"clicking on search icon");
        verifyDisplayAndEnable(Wwp.searchResultPersonsCard,"UserName is display");
        click(Wwp.searchResultPersonsCard,"Clicking on User card");
        if(isWebElementPresent(Wwp.removeConnectionOnPopup,"")==true) {
            click(Wwp.removeConnectionOnPopup,"Remove the connection");
            click(Wwp.yesButton,"click on yes");
        }
        else {
            click(Wwp.closeButton,"close the popup");
        }
    }
    @Then("Verify once a connection is removed, users can still see any historical messages from before the connection removal, but cannot draft a new message to the removed connection")
    public void verify_once_a_connection_is_removed_users_can_still_see_any_historical_messages_from_before_the_connection_removal_but_cannot_draft_a_new_message_to_the_removed_connection() throws InterruptedException {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("WWP", "Testdata1");
        click(Wwp.individualUser,"click on"+dataMap.get("User"));
        String errorMessage = getElementText(Wwp.errorMessage);
        isWebElementVisible(Wwp.errorMessage,errorMessage);
        isWebElementVisible(Wwp.historicalConversation,"older conversation");
    }


    @Then("verify the connection request notifications")
    public void unread_notifications() {
        List<WebElement> number_of_notifications=getListElements(Wwp.notificationlist,"getting the count of notifications");

        if (number_of_notifications.size() == 0) {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(  "you have no new notifications"));
        } else {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(  "the new notifications are: " +number_of_notifications.get(0).getText()));

            System.out.println(number_of_notifications.get(0).getText());

        }


    }

    @Then("Verify User first,last name and user profile picture")
    public void verify_user_first_and_last_name() throws InterruptedException {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("WWP", "Testdata1");
        scrollingToElementofAPage(Wwp.invitationName(dataMap.get("ConnectionUser")),"scroll to user:"+dataMap.get("ConnectionUser"));
        isWebElementVisible(Wwp.invitationName(dataMap.get("ConnectionUser")),dataMap.get("ConnectionUser"));
        isWebElementVisible(Wwp.invitationImage(dataMap.get("ConnectionUser")),dataMap.get("ConnectionUser")+" image");

    }

    @Then("Verify Call to actions for Approve and Deny")
    public void verify_call_to_actions_for_approve_and_deny() {
        isWebElementVisible(Wwp.requestApproveButton,"Approve button");
        isWebElementVisible(Wwp.requestDenyButton,"Deny Button");
    }

    @Then("Verify user can initiate the message from the My Connections list view or the Profile view")
    public void verifyUserInitiateMessagefrom_the_my_connections_list_view_or_the_profile_view() throws InterruptedException {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("WWP", "Testdata1");
        scrollingToElementofAPage(Wwp.connectionMsg(dataMap.get("ConnectionUser")),"scroll to user:"+dataMap.get("ConnectionUser"));
        isWebElementVisible(Wwp.connectionMsg(dataMap.get("ConnectionUser")),dataMap.get("ConnectionUser"));
        click(Wwp.connectionMsg(dataMap.get("ConnectionUser")),dataMap.get("ConnectionUser")+" inbox is opened");
        inputText(Wwp.messageInputBox,"Hello,How Are you?" ,"Enter Message");
        Thread.sleep(3000);
        click(Wwp.submitButton,"Clicking on Submit button");
        isWebElementVisible(Wwp.sendMsgVerfication,"Hello,How Are you?");
    }

    @And("Go to the Account")
    public void open_account() throws InterruptedException {
        Thread.sleep(2000);
        scrollingToElementofAPage(Wwp.userProfileIcon,"");
        hoverOnElement(Wwp.userProfileIcon);
        click(Wwp.userProfileIcon,"user icon");
        hoverOnElement(Wwp.account);
        click(Wwp.account,"account link");
        isWebElementVisible(Wwp.accountUsername,"Account page");
    }

    @And("User set privacy status as {string}")
        public void privacyStatus(String privacy) throws InterruptedException {
        click(Wwp.accountAboutme,"click on add button in about me");
        click(Wwp.aboutMePrivacySetting,"click on privacy setting");
        if(isRadioNotSelected(Wwp.aboutmePrivacy(privacy),privacy+" radio button")==true);
        try
        {
            click(Wwp.aboutmePrivacy(privacy), "click on " + privacy);
            isRadioSelected(Wwp.aboutmePrivacy(privacy), privacy + " radio button is selected");
            scrollingToElementofAPage(Wwp.savePrivacy, "scroll to save");
            click(Wwp.savePrivacy, "click on save");
        }
        catch (Exception e){
            isRadioSelected(Wwp.aboutmePrivacy(privacy), privacy + " radio button is already selected");
        }

        }

    @And("Private users will see a banner on the Groups page notifying them that their privacy settings reduce their ability to interact with Groups and discussions")
    public void PrivacyMsgNotify() throws InterruptedException {
       isWebElementVisible(Wwp.groupPrivacyBannerTitle,getElementText(Wwp.groupPrivacyBannerTitle));

    }

    @And("Private users will not show up in People searches")
    public void SearchNotshownForPrivateuser() throws InterruptedException {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("WWP", "Testdata1");
        scrollingToElementofAPage(Wwp.peopleSearch,"people search is display");
        inputText(Wwp.peopleSearch,dataMap.get("ConnectionUser"),"Searching user: "+dataMap.get("ConnectionUser"));
        click(Wwp.peopleSearchSubmit,"clicking on search icon");
        isWebElementVisible(Wwp.peopleSearchItems,getElementText(Wwp.peopleSearchItems));

    }

    @And("Private users will not able to send connection request")
    public void sendConnectionRequest() throws InterruptedException {
         click(Wwp.peopleSearchClear,"");
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("WWP", "Testdata1");
        scrollingToElementofAPage(Wwp.peopleSearch,"people search is display");
        inputText(Wwp.peopleSearch,dataMap.get("User"),"Searching"+dataMap.get("User"));
        click(Wwp.peopleSearchSubmit,"clicking on search icon");
        verifyDisplayAndEnable(Wwp.searchResultPersonsCard,"UserName is display");
        click(Wwp.searchResultPersonsCard,"Clicking on User card");
        if(!isWebElementPresent(Wwp.connectButton,"")==true) {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("connect button is not present"));
        }
        click(Wwp.closeButton, "close the popup");
    }




    @Then("Verify Show More Button functionality on People page")
    public void verify_ShowMoreFunctionality() throws InterruptedException {
        List<WebElement> intialSuggestedPersonsImage = getListElements(Wwp.suggestedPersonsImage,"getting the list of suggested connection before clicking on show more");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Total No of items before clicking on show more: "+intialSuggestedPersonsImage.size()));


        if(isWebElementVisible(Wwp.showMoreButtonPeople,"Show Button")){
            try {
                while (isWebElementPresent(Wwp.showMoreButtonPeople, "Show more button is present")) {
                    scrollingToElementofAPage(Wwp.showMoreButtonPeople, "scroll to show more");
                    Thread.sleep(1000);
                    click(Wwp.showMoreButtonPeople, "click on show more");
                    List<WebElement> SuggestedPersonsImage = getListElements(Wwp.suggestedPersonsImage,"getting the list of suggested connection after clicking on show more");
                    RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("No. of items after clicking on show more button: "+SuggestedPersonsImage.size()));


                }
            }
            catch (Exception e){

                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Show more button is present"));

            }


        }

        List<WebElement> SuggestedPersonsImage = getListElements(Wwp.suggestedPersonsImage,"getting the list of suggested connection after clicking on show more");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Total No of items: "+SuggestedPersonsImage.size()));


    }

    @And("Verify view all link is visible when more than 3 request pending")
    public void verifyViewAllLink_() throws InterruptedException {
        int text = Integer.parseInt(getElementText(Wwp.peopleInvitation).split("Invitations ")[1].substring(1,2));
        System.out.println(text);
        if(text>3){
            scrollingToElementofAPage(Wwp.peopleViewAll,"scroll to View all");
            isWebElementVisible(Wwp.peopleViewAll,"View all");
            click(Wwp.peopleViewAll,"click on View all link");
        }
        else{
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("View all is not present"));

        }



    }












}
