package stepDefinitions.WWPWeb;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.web.Wwp;
import stepDefinitions.RunCukesTest;
import utilities.ExcelDataUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;

public class Groups extends KeywordUtil {
    private static String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\Image\\travel.png";

    private static String filePath1 = System.getProperty("user.dir") + "\\src\\main\\resources\\Image\\Skype_Picture_2023_04_20T10_20_51_646Z.jpeg";

    public static HashMap<String, String> dataMap = new HashMap<String, String>();

    @And("User click on Groups tab")
    public void clickOnGroupTab() throws InterruptedException {
        scrollingToElementofAPage(Wwp.groupTitle, "");
        click(Wwp.groupTitle, "Click on Groups tab");
        Thread.sleep(5000);
        Assert.assertEquals(getElementText(Wwp.groupBannerTitle), "Groups");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.format("Groups Banner is visible  ")));
        Assert.assertEquals(getElementText(Wwp.groupBannerSubTitle), "Become a positive force in a community of warriors, family members, and caregivers");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.format("Become a positive force in a community of warriors, family members, and caregivers")));
    }

    @And("Verify contents on the Groups page")
    public void verifyGroupContent() {
        Assert.assertTrue(isWebElementPresent(Wwp.groupFind, "Find"));
        Assert.assertTrue(isWebElementPresent(Wwp.groupFollow, "Follow"));
        Assert.assertTrue(isWebElementPresent(Wwp.groupEngage, "Engage"));
        Assert.assertTrue(isWebElementPresent(Wwp.searchGroups, "Search group textbox"));
        Assert.assertTrue(isWebElementPresent(Wwp.showAllSuggested, "Show all suggested link"));
        List<WebElement> number_of_elements = getListElements(Wwp.grouplist(1), "Suggested group list");
        if (number_of_elements.size() > 0) {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Groups are present in Suggested list"));

        } else
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Groups are not present in Suggested list"));
        List<WebElement> categoryList = getListElements(Wwp.groupCategoryTitle, "Category group list");
        for (int i = 0; i < categoryList.size(); i++) {
            List<WebElement> categorygrouplist = getListElements(Wwp.groupslist, "Suggested group list");
            if (categorygrouplist.size() > 0) {
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Groups are present in " + categoryList.get(i).getText()) + "");
            } else
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Groups are not present in category list"));


        }

    }


    @And("Check My group exist or not")
    public void verifyMyGroupsExistOrNot() throws InterruptedException {
        Thread.sleep(2000);
        if (isWebElementPresent(Wwp.myGroups, "My Group")) {
            List<WebElement> groupCounts = getListElements(Wwp.groupCount, "Total Group count list");

            for (int i = 1; i <= groupCounts.size(); i++) {
                String text = getText(Wwp.followers);
                click(Wwp.followers, "click on " + text + " ");
                isWebElementsVisible(Wwp.unFollow, "Unfollow");
                click(Wwp.unFollow, "Click on unfollow");
                isWebElementsVisible(Wwp.leaveTheGroupMsg, "");
                click(Wwp.UnfollowTheGroup, "Group is unfollowed");
                isWebElementsVisible(Wwp.popupmsg, "Pop up is visible");
                click(Wwp.closeTheMsg, "close the popup msg");
                Thread.sleep(1000);
                click(Wwp.groupTitle, "Click on Groups tab");


            }
        } else {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("My Group is not visible"));

        }
    }

    @And("Verify able to view informational text")
    public void verifyInformationalText() {
        Assert.assertTrue(isWebElementsVisible(Wwp.groupFindText, "Browse our community groups to connect with others who share your interests"));
        Assert.assertTrue(isWebElementsVisible(Wwp.groupFollowText, "Stay informed by following the groups you enjoy to see recent posts and updates"));
        Assert.assertTrue(isWebElementsVisible(Wwp.groupEngageText, "Post, comment, and share with your fellow warriors and family service members"));

    }

    @And("Verify user able to view Suggested Group list below the Search Box")
    public void verifyshowallSuggestedlist() throws InterruptedException {
        isWebElementsVisible(Wwp.showAllSuggested, "Show all suggested link");
        List<WebElement> suggestedForYou = getListElements(Wwp.grouplist(1), "Getting Suggested for you group list");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Suggested group list before clicking on show all suggested link:" + suggestedForYou.size() + ""));

        scrollingToElementofAPage(Wwp.showAllSuggested, "scroll to show all suggested link");
        click(Wwp.showAllSuggested, "click on show all suggested for you link");
        List<WebElement> showAllSuggestedForYou = getListElements(Wwp.grouplist(1), "Getting Show all Suggested group list");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Groups are present in Suggested list:" + showAllSuggestedForYou.size() + ""));
        if (suggestedForYou.size() < showAllSuggestedForYou.size()) {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("All Groups are present in Suggested list"));

        } else
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("All Groups are not present in Suggested list"));
    }

    @And("click on any listed groups & verify details")
    public void openGroupInSuggestedlistAndVerify() {
        List<WebElement> suggestedForYou = getListElements(Wwp.grouplist(1), "Suggested group list");
        if (suggestedForYou.size() > 0) {
            click(Wwp.selectGroupUndercategory("Suggested For You"), "");
            String groupName = getElementText(Wwp.groupName);
            isWebElementVisible(Wwp.groupName, "Group Name: " + groupName);
            isButtonEnabled(Wwp.shareGroup, "Share Button");
            isButtonEnabled(Wwp.followGroup, "follow button");
            isButtonEnabled(Wwp.createPost, "Create post button");
            String followingMember = getElementText(Wwp.followingMemberGroup);
            isWebElementVisible(Wwp.followingMemberGroup, "Total Following members: " + followingMember);
            isWebElementVisible(Wwp.discussionGroup, "Discussion");
        }
    }

    @And("Verify groups on {string} category")
    public void verifyGroupDetailinDifferentCategories(String category) throws InterruptedException {
        if (isWebElementPresent(Wwp.showAllGroupList(category), "Show All " + category + " link")) {
            scrollingToElementofAPage(Wwp.showAllGroupList(category), "scroll to Show All " + category + " link");
            click(Wwp.showAllGroupList(category), "click on Show All " + category + " link");
        } else {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Show All " + category + " link is not present"));

        }
        List<WebElement> categoryName = getListElements(Wwp.categoryTitle(category), "Get " + category + " group list");
        System.out.println(categoryName.size());
        for (int i = 1; i <= categoryName.size(); i++) {
            //scrollingToElementofAPage(Wwp.categoryTitle(category),"scroll to Show All "+category+" link");

            String groupName = getElementText(Wwp.groupNameUnderCategory(category, i));
            isWebElementVisible(Wwp.selectGroupUndercategory(category), "Group Name: " + groupName);
            String followingmember = getElementText(Wwp.followingUndercategory(category, i));
            isWebElementVisible(Wwp.selectGroupUndercategory(category), "Following members: " + followingmember);
            if (isWebElementPresent(Wwp.imageUndercategory(category, i), "" + groupName + " image")) {
                isWebElementVisible(Wwp.imageUndercategory(category, i), "" + groupName + " image");
            } else {
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("" + groupName + " image is not present"));

            }
        }

    }


    @And("Search the {string} group")
    public void searchTheGroup(String data) throws InterruptedException {
            inputText(Wwp.searchGroups, data, "" + data + " is searched");
            scrollingToElementofAPage(Wwp.selectGroupUndercategory(data), data);
            isWebElementVisible(Wwp.selectGroupUndercategory("Search results for"), data);
            click(Wwp.selectGroupUndercategory(data), "click on " + data);

    }

    @And("Follow the group")
    public void followTheGroup() throws InterruptedException {
        isWebElementVisible(Wwp.followGroup, "follow button");
        String followingCounts = getElementText(Wwp.followingMemberGroup);
        isWebElementVisible(Wwp.followingMemberGroup, "Following counts: " + followingCounts);
        String groupName = getElementText(Wwp.groupName);
        isWebElementVisible(Wwp.groupName, "Group Name: " + groupName);
        click(Wwp.followGroup, "click on follow");
        Assert.assertTrue(isWebElementsVisible(Wwp.success_message, getElementText(Wwp.successMessageGroup)));
        isWebElementVisible(Wwp.unFollow, "Follow button changed to unfollow");
        click(Wwp.closeTheMsg, "close the popup msg");
        String updatedFollowingCounts = getElementText(Wwp.followingMemberGroup);
        isWebElementVisible(Wwp.followingMemberGroup, "Updated Following counts: " + updatedFollowingCounts);

    }

    @And("Verify {string} group updated in my group list")
    public void verifyUpdatedGroup(String groupName) throws InterruptedException {
        click(Wwp.peopleTitle,"");
        click(Wwp.groupTitle,"");
        isWebElementVisible(Wwp.myGroups, "My Group");
        isWebElementVisible(Wwp.choosegroup(groupName), groupName + " in my group list");

    }

    @And("Unfollow the group")
    public void unfollowTheGroup() throws InterruptedException {
        isWebElementVisible(Wwp.unFollow, "unfollow button");
        String followingCounts = getElementText(Wwp.followingMemberGroup);
        isWebElementVisible(Wwp.followingMemberGroup, "Following counts: " + followingCounts);
        String groupName = getElementText(Wwp.groupName);
        isWebElementVisible(Wwp.groupName, "Group Name: " + groupName);
        click(Wwp.unFollow, "click on follow");
        isWebElementsVisible(Wwp.leaveTheGroupMsg, "Continue to unfollow");
        click(Wwp.UnfollowTheGroup, "Group is unfollowed");
        Assert.assertTrue(isWebElementsVisible(Wwp.success_message, getElementText(Wwp.successMessageGroup)));
        isWebElementVisible(Wwp.followGroup, "unFollow button changed to follow");
        click(Wwp.closeTheMsg, "close the popup msg");
        String updatedFollowingCounts = getElementText(Wwp.followingMemberGroup);
        isWebElementVisible(Wwp.followingMemberGroup, "Updated Following counts: " + updatedFollowingCounts);

    }

    @And("select {string} group in my group list")
    public void selectGroup(String groupName) throws InterruptedException {
        click(Wwp.groupTitle, "Click on Groups");
        isWebElementVisible(Wwp.myGroups, "My Group");
        isWebElementVisible(Wwp.choosegroup(groupName), groupName + " in my group list");
        scrollingToElementofAPage(Wwp.choosegroup(groupName), "scroll to " + groupName);
        click(Wwp.choosegroup(groupName), groupName + " is clickable");

    }

    @And("Verify unfollow {string} group updated in my group list")
    public void verifyUnfollowUpdatedGroup(String groupName) throws InterruptedException {
        click(Wwp.backBtn, "Click on Groups");
        Thread.sleep(1000);
        if (isWebElementPresent(Wwp.myGroups, "My Group")) {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("" + groupName + " is not present"));

        } else {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("" + groupName + " is not present"));

        }

    }

    @And("User click on My Group tab")
    public void click_mygroup() throws InterruptedException {
        hoverOnElement(Wwp.myGroups);
        click(Wwp.myGroups, "click on the my groups section");

    }

    @Then("user is able to see the groups in the my groups tab")
    public void list_of_groups() throws InterruptedException {
        Thread.sleep(8000);
        hoverOnElement(Wwp.my_groups_groups_list);
        List<WebElement> list_of_groups = getListElements(Wwp.my_groups_groups_list, "getting all the groupes preseent in the my groups tab");
        for (int i = 0; i < list_of_groups.size(); i++) {

            System.out.println(list_of_groups.get(i).getText());
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(list_of_groups.get(i).getText()));

        }
    }

    @Then("user is able to see the activities in the recent tab")
    public void recent_Activity() throws InterruptedException {
        hoverOnElement(Wwp.recent_group_activity);
        List<WebElement> recent_Activity = getListElements(Wwp.recent_group_activity, "getting the recent group activity");
        for (int i = 0; i < recent_Activity.size(); i++) {
            System.out.println(recent_Activity.get(i).getText());
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(recent_Activity.get(i).getText()));
        }
    }

    @Then("click on the group present in the my groups tab")
    public void click_group() throws InterruptedException {
        waitForVisible(Wwp.my_groups_groups_list);
        hoverOnElement(Wwp.my_groups_groups_list);
        Thread.sleep(8000);
        List<WebElement> list_of_groups = getListElements(Wwp.my_groups_groups_list, "getting all the groups present in the my groups tab");
        for (int i = 0; i < list_of_groups.size(); i++) {
            list_of_groups.get(i).click();
            break;

        }
        Thread.sleep(7000);
        hoverOnElement(Wwp.create_post_icon);
        click(Wwp.create_post_icon, "click on the create post ");
        Assert.assertTrue(isWebElementsVisible(Wwp.group_title, getElementText(Wwp.group_title)));
        Assert.assertTrue(isWebElementsVisible(Wwp.following_count, getElementText(Wwp.following_count)));
        Assert.assertTrue(isWebElementsVisible(Wwp.textarea, "textarea field"));
        Assert.assertTrue(isWebElementsVisible(Wwp.image_icon, "image icon"));
        Assert.assertTrue(isWebElementsVisible(Wwp.community_guidelines, "community guidelines"));
        Assert.assertTrue(isWebElementsVisible(Wwp.submit_buttonGroup, "submit button"));
        inputText(Wwp.textarea, "nice comment", "enter the comment in the textarea");
        click(Wwp.submit_buttonGroup, "click on the submit button");
        Assert.assertTrue(isWebElementVisible(Wwp.success_message, getElementText(Wwp.successMessageGroup)));

    }


    @Then("Verify Post Shared by other User or loggedin user")
    public void verifies_post_by_other_user() throws InterruptedException {
//        if(isWebElementPresent(Wwp.showMoreDiscussionGroup,"Show Button")){
//            while (isWebElementPresent(Wwp.showMoreDiscussionGroup, "Show more discussion button is present") == true) {
//                    scrollingToElementofAPage(Wwp.showMoreDiscussionGroup, "scroll to show more discussion");
//                    Thread.sleep(1000);
//                    click(Wwp.showMoreDiscussionGroup, "click on show more discussion");
//                }
//
//        }
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("WWP", "Testdata1");
        List<WebElement> user_name = getListElements(Wwp.user_name, "getting all the user's name");
        List<WebElement> timestamp = getListElements(Wwp.timestampGroup, "getting the timestamp");
        List<WebElement> user_comment = getListElements(Wwp.user_comment, "getting the user_comment");
        List<WebElement> edit_icon = getListElements(Wwp.delete_icon, "getting the delete icon");
        for (int i = 0; i < user_name.size(); i++) {
            if (user_name.get(i).getText().equalsIgnoreCase(dataMap.get("ConnectionUser"))) {

                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("this post is created by loggedin user name"));
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(user_name.get(i).getText()));
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(timestamp.get(i).getText()));
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(user_comment.get(i).getText()));
                Assert.assertTrue(isWebElementsVisible(Wwp.like_butotn, "like button"));
                Assert.assertTrue(isWebElementsVisible(Wwp.comment, "comment button"));
                Assert.assertTrue(isWebElementsVisible(Wwp.flag, "flag icon"));
                Assert.assertTrue(isWebElementsVisible(Wwp.edit_icon, "edit icon"));
                Assert.assertTrue(isWebElementsVisible(Wwp.delete_icon, "delete icon"));

                System.out.println();
            } else {
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("this post is created by other user name"));
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(user_name.get(i).getText()));
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(timestamp.get(i).getText()));
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(user_comment.get(i).getText()));
                Assert.assertTrue(isWebElementsVisible(Wwp.like_butotn, "like button"));
                Assert.assertTrue(isWebElementsVisible(Wwp.comment, "comment button"));
                Assert.assertTrue(isWebElementsVisible(Wwp.flag, "flag icon"));
            }
        }


    }


    @Then("verify the comment action")
    public void verify_Action() throws InterruptedException {
        Thread.sleep(3000);
        scrollingToElementofAPage(Wwp.comment, "move to the comment");
        hoverOnElement(Wwp.comment);
        List<WebElement> comment = getListElements(Wwp.comment, "getting the user comment");
        for (int i = 0; i < comment.size(); i++) {
            Thread.sleep(3000);
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the number of comments " + comment.get(i).getText()));
            Thread.sleep(3000);
            comment.get(i).click();
            Thread.sleep(4000);
            inputText(Wwp.write_comment, "nice", "enter the comment in the comment box");
            Thread.sleep(6000);
            click(Wwp.post_comment, "click on the post comment");
            Assert.assertTrue(isWebElementVisible(Wwp.success_message, getElementText(Wwp.successMessageGroup)));
            Thread.sleep(5000);
            scrollingToElementofAPage(Wwp.comment, "move to comment button");

            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the number of comments " + comment.get(i).getText()));
            break;

        }

    }

    @Then("verify the flag action")
    public void verifies_flag_icon() throws InterruptedException {
        scrollingToElementofAPage(Wwp.flag, "move to the flag");
        List<WebElement> flag = getListElements(Wwp.flag, "getting the flag icon");
        for (int i = 0; i < flag.size(); i++) {
            System.out.println("the text is before clicking on flag : " + flag.get(i).getText());
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the text is before clicking on flag : " + flag.get(i).getText()));

            scrollingToElementofAPage(Wwp.flag, "move to the flag icon");
            Thread.sleep(5000);
            flag.get(i).click();

            Thread.sleep(7000);
            click(Wwp.submit_buttonGroup, "click on the submit button");
            Assert.assertTrue(isWebElementVisible(Wwp.success_message, getElementText(Wwp.successMessageGroup)));
            Thread.sleep(7000);


            Thread.sleep(6000);
            flag.get(i).click();
            Assert.assertTrue(isWebElementVisible(Wwp.success_message, getElementText(Wwp.successMessageGroup)));
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the text is before clicking on flag : " + flag.get(i).getText()));

            break;

        }

    }

    @Then("verify the like and unlike action")
    public void like_Action() throws InterruptedException {
        scrollingToElementofAPage(Wwp.like_butotn, "move to the like button");
        List<WebElement> like = getListElements(Wwp.like_butotn, "getting the like");
        for (int i = 0; i < like.size(); i++) {


            System.out.println("the text before clicking on the like button " + like.get(i).getText());
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the text before clicking on the like button " + like.get(i).getText()));

            hoverOnElement(Wwp.like_butotn);
            Thread.sleep(6000);
            //scrollingToElementofAPage(Wwp.like_butotn, "move to like button");
            Thread.sleep(6000);
            like.get(i).click();
            Thread.sleep(6000);

            System.out.println("the text before clicking on the like button " + like.get(i).getText());
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the text after clicking on the like button " + like.get(i).getText()));
            Thread.sleep(7000);
            like.get(i).click();
            Thread.sleep(6000);
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the text after clicking on the like button " + like.get(i).getText()));


            break;

        }
    }

    @Then("verify the edit and delete icon")
    public void edit_And_Delete_icon() throws InterruptedException {
        //create post

        Thread.sleep(7000);
        hoverOnElement(Wwp.create_post_icon);
        click(Wwp.create_post_icon, "click on the create post ");
        inputText(Wwp.textarea, "nice comment", "enter the comment in the textarea");
        click(Wwp.submit_buttonGroup, "click on the submit button");
        Thread.sleep(7000);
        //getting all the comments
        List<WebElement> edit_icon = getListElements(Wwp.edit_icon, "getting the edit icon");
        List<WebElement> delete = getListElements(Wwp.delete_icon, "getting all the delete icon");
        for (int i = 0; i < edit_icon.size(); i++) {

            Thread.sleep(7000);
            scrollingToElementofAPage(Wwp.edit_icon, "move to the edit icon");
            edit_icon.get(i).click();
            Thread.sleep(6000);
            inputText(Wwp.textarea, "change comment", "enter the edit  comment in the textarea");
            click(Wwp.submit_buttonGroup, "click on the submit button");
            Assert.assertTrue(isWebElementsVisible(Wwp.success_message, getElementText(Wwp.successMessageGroup)));
            Thread.sleep(7000);
            delete.get(i).click();
            Thread.sleep(7000);

            click(Wwp.delete, "click on the delete button");
            Assert.assertTrue(isWebElementsVisible(Wwp.success_message, getElementText(Wwp.successMessageGroup)));
            break;

        }

    }

    @Then("Delete the post")
    public void deletePost() throws InterruptedException {

        //getting all the comments
        List<WebElement> delete = getListElements(Wwp.delete_icon, "getting all the delete icon");
        for (int i = 0; i < delete.size(); i++) {
            scrollingToElementofAPage(Wwp.edit_icon, "scroll");
            delete.get(i).click();
            Thread.sleep(5000);

            click(Wwp.delete, "click on the delete button");
            Assert.assertTrue(isWebElementsVisible(Wwp.success_message, getElementText(Wwp.successMessageGroup)));
            break;

        }

    }

    @Then("Verify and Check User can select a discussion, which opens the group")
    public void select_a_discussion() throws InterruptedException {
        List<WebElement> user_name = getListElements(Wwp.user_name, "getting all the user_name");
        List<WebElement> group_name = getListElements(Wwp.group_name, "getting all the group name");
        for (int i = 0; i < user_name.size(); i++) {

            Thread.sleep(7000);

            String expected_group_name = group_name.get(i).getText();

            scrollingToElementofAPage(Wwp.group_name, "move to the group name");
            group_name.get(i).click();
            Thread.sleep(8000);
            Assert.assertEquals(expected_group_name, getElementText(Wwp.recent_Activity_group_name));
            scrollingToElementofAPage(Wwp.backBtn, "move to back button");
            click(Wwp.backBtn, "click on the back button");
            break;

        }
    }

    @Then("Verify and Check User can also select show more")
    public void show_more() throws InterruptedException {

        //validatingshow more functionality
        Thread.sleep(6000);
        scrollingToElementofAPage(Wwp.user_name, "move to user name");
        List<WebElement> user_name = getListElements(Wwp.user_name, "getting all the user_name before clicking show more");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the number of users before clicking on show more : " + user_name.size()));

        //move to the show more button
        scrollingToElementofAPage(Wwp.show_more, "move to show more");
        click(Wwp.show_more, "click on the show more button");
        Thread.sleep(7000);
        List<WebElement> user_name1 = getListElements(Wwp.user_name, "getting all the user_name after clicking show more");
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the number of users before clicking on show more : " + user_name1.size()));

    }

    @Then("verify the number of groups present in the Gropus tab")
    public void number_of_groups() {
        List<WebElement> number_of_groups_in_my_gropus = getListElements(Wwp.my_groups_groups_list, "getitng the groups list");
        System.out.println("the size is :" + number_of_groups_in_my_gropus.size());

        if (number_of_groups_in_my_gropus.size() < 3) {
            System.out.println("please select atleast 3 groups");
        } else {
            System.out.println("proceed further");
        }

    }

    @And("click on the Back button")
    public void click_back_button() throws InterruptedException {
        scrollingToElementofAPage(Wwp.backBtn, "move to back button");
        click(Wwp.backBtn, "click on the back button");


    }

    @And("click on the All groups")
    public void click_all_groups() throws InterruptedException {
        scrollingToElementofAPage(Wwp.all_group, "move to all group");
        click(Wwp.all_group, "click on the all group button");
    }

    @Then("verify the summary cards")
    public void verify_sumamry_Card_Details() {
        List<WebElement> user_name = getListElements(Wwp.user_name, "getting all the user's name");
        List<WebElement> timestamp = getListElements(Wwp.timestampGroup, "getting the timestamp");
        List<WebElement> user_comment = getListElements(Wwp.user_comment, "getting the user_comment");
        List<WebElement> edit_icon = getListElements(Wwp.delete_icon, "getting the delete icon");

        for (int i = 0; i < user_name.size(); i++) {

            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(user_name.get(i).getText()));
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(timestamp.get(i).getText()));
            Assert.assertTrue(isWebElementsVisible(Wwp.like_butotn, "like button"));
            Assert.assertTrue(isWebElementsVisible(Wwp.comment, "comment button"));
            Assert.assertTrue(isWebElementsVisible(Wwp.flag, "flag icon"));
        }
    }

    @And("click on the first group present in the All groups")
    public void click_group_in_the_all_group() throws InterruptedException {
        List<WebElement> groups = getListElements(Wwp.all_groups_groups, "getting all the groups present in the all groups");
        for (int i = 0; i < groups.size(); i++) {
            groups.get(i).click();
            Thread.sleep(7000);
            break;
        }
    }

    @Then("verify the edit and delete icon in the all groups")
    public void edit_delete() throws InterruptedException {
        scrollingToElementofAPage(Wwp.edit_icon_in_all_groups, "move to the edit button in the comments");
        Thread.sleep(5000);
        click(Wwp.edit_icon_in_all_groups, "click on the edit icon");
        Thread.sleep(5000);
        inputText(Wwp.updated_comment_textbox, "change comment", "enter the edit  comment in the textarea");
        click(Wwp.submit_icon, "click on the submit button");
        Assert.assertTrue(isWebElementsVisible(Wwp.success_message, getElementText(Wwp.successMessageGroup)));
        Thread.sleep(7000);
        scrollingToElementofAPage(Wwp.delete_icon_in_allgroups, "move to delete");
        Thread.sleep(7000);
        click(Wwp.delete_icon_in_allgroups, "click on the delete button in the comments");
        Thread.sleep(7000);
        click(Wwp.delete, "click on the delete button");
        Assert.assertTrue(isWebElementsVisible(Wwp.success_message, getElementText(Wwp.successMessageGroup)));


    }


    @Then("click on the flag action")
    public void click_flag() throws InterruptedException {
        Thread.sleep(6000);
        scrollingToElementofAPage(Wwp.flag, "move to the flag");
        List<WebElement> flag = getListElements(Wwp.flag, "getting the flag icon");
        for (int i = 0; i < flag.size(); i++) {
            System.out.println("the text is before clicking on flag : " + flag.get(i).getText());
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the text is before clicking on flag : " + flag.get(i).getText()));

            scrollingToElementofAPage(Wwp.flag, "move to the flag icon");
            Thread.sleep(5000);
            flag.get(i).click();
            break;

        }
    }

    @Then("click on the radio button")
    public void click_radio_button() throws InterruptedException {
        Thread.sleep(6000);
        scrollingToElementofAPage(Wwp.second_radio_button, "move to the radio button");
        Thread.sleep(5000);
        click(Wwp.second_radio_button, "click on the  radio button");
        Thread.sleep(5000);


    }

    @And("enter the {string} group name in searchbox and click on submit button")
    public void enter_group_name(String group_name) throws InterruptedException {
        inputText(Wwp.group_search, group_name, "enter the " + group_name + "in the search box");
        scrollingToElementofAPage(Wwp.group_submit, "move to submit button");
        click(Wwp.group_submit, "click on the submit option");

    }

    @Then("click on the create post")
    public void click_post() throws InterruptedException {
        scrollingToElementofAPage(Wwp.createPost, "move to create post icon");
        click(Wwp.createPost, "click on the create post icon");
    }

    @Then("click on add image icom")
    public void click_add_image() throws InterruptedException {
        scrollingToElementofAPage(Wwp.image_icon, "move to image icon ");
        click(Wwp.image_icon, "click on the image icon");
        Thread.sleep(5000);

    }

    @Then("enter the {string} in the textarea")
    public void enter_falg_comment(String comment) throws InterruptedException {


        inputText(Wwp.flag_textarea, comment, "enter the " + comment + " in the textarea");
        Thread.sleep(7000);
    }

    @Then("verifies the success message")
    public void success_message() throws InterruptedException {
        Assert.assertTrue(isWebElementsVisible(Wwp.success_message, getElementText(Wwp.successMessageGroup)));
        Thread.sleep(6000);
        click(Wwp.flaged_icon, "click on the flagged icon");

    }


    @Then("click on the share button")
    public void click_share_button() throws InterruptedException {
        scrollingToElementofAPage(Wwp.share_icon, "move to the share icom");
        click(Wwp.share_icon, "click on the share icon");


    }

    @Then("verifies the copy link")
    public void verifies_copy_link_And_Search() throws InterruptedException {
        Assert.assertTrue(isWebElementsVisible(Wwp.copy_link, "copy link is visible"));
        click(Wwp.copy_link, "click on the copy link");
        Assert.assertTrue(isWebElementsVisible(Wwp.success_message, getElementText(Wwp.successMessageGroup)));
        click(Wwp.closeTheMsg, "close the popup msg");

    }

    @Then("search {string} and view the suggested people list")
    public void serach_funcionality(String input_text) throws InterruptedException {
        Thread.sleep(7000);
        click(Wwp.share_icon, "click on the share icon");

        Assert.assertTrue(isWebElementsVisible(Wwp.group_search, "search button is present"));

        List<WebElement> user_list = getListElements(Wwp.user_list, "getting the users present in the suggestions");

        inputText(Wwp.group_search, input_text, "enter the input text: "+ input_text);
        click(Wwp.search_button_share, "click on the group submit");
        for (int i = 0; i < user_list.size(); i++) {
            if (user_list.get(i).getText().equalsIgnoreCase(input_text)) {
                System.out.println("search results are displayed");
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.format("the search results are : ")));

                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.format(user_list.get(i).getText())));

            } else {
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.format("the suggested people are : ")));

                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.format(user_list.get(i).getText())));
            }

        }
        Thread.sleep(5000);
        click(Wwp.closeButtonGroup, "click on the close button");
    }

    @Then("click on the Back and verifies the group page")
    public void click_back_button_verifies_group_title() throws InterruptedException {
        scrollingToElementofAPage(Wwp.backBtn, "move to the back button");
        click(Wwp.backBtn, "click on the back button");
        Thread.sleep(6000);
        String expected_title = "Groups";
        Assert.assertEquals(getDriver().getTitle(), expected_title);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.format("Groups Banner is visible")));


    }

    @Then("search {string} and and click on the person to share")
    public void share_item(String input_text) {
        List<WebElement> user_list = getListElements(Wwp.user_list, "getting the users present in the suggestions");


        inputText(Wwp.group_search, input_text, "enter the input text");
        click(Wwp.search_button_share, "click on the group submit");
        for (int i = 0; i < user_list.size(); i++) {
            if (user_list.get(i).getText().equalsIgnoreCase(input_text)) {
                System.out.println("search results are displayed");
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.format("the search results are : ")));

                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.format(user_list.get(i).getText())));
                click(Wwp.selectSearchinShare(input_text),"click on "+input_text);
                click(Wwp.yes_button, "click on yes button");

            }

        }
    }

    @Then("verifies the details")
    public void verifies_details() {
        waitForVisible(Wwp.messageInputBox);
        List<WebElement> messages = getListElements(Wwp.messagesGroup, "getting the messages");
        for (int i = 0; i < messages.size(); i++) {
            Assert.assertTrue(isWebElementsVisible(Wwp.messages_group_title, getElementText(Wwp.messages_group_title)));
            Assert.assertTrue(isWebElementsVisible(Wwp.messages_following_count, getElementText(Wwp.messages_following_count)));
            Assert.assertTrue(isWebElementsVisible(Wwp.datetimeLatestSharedArticleInbox, getElementText(Wwp.datetimeLatestSharedArticleInbox)));
            Assert.assertTrue(isWebElementsVisible(Wwp.messages_letter, getElementText(Wwp.messages_letter)));
            break;
        }
    }

    @And("Image should be uploaded in group")
    public void imageGroup() throws InterruptedException, AWTException {
        click(Wwp.uploadImage, "Upload image");
        Thread.sleep(5000);
        uploadImageRobot(filePath);
        scrollingToElementofAPage(Wwp.submit_buttonGroup, "scroll to Submit");
        click(Wwp.submit_buttonGroup, "Click on Submit");
        waitForVisible(Wwp.Grouppopupmsg);
        isWebElementsVisible(Wwp.Grouppopupmsg, getElementText(Wwp.successMessageGroup));
        scrollingToElementofAPage(Wwp.delete_icon_in_allgroups, "scroll to Delete image");
        click(Wwp.delete_icon_in_allgroups, "Delete image");
        click(Wwp.delete, "continue to Delete image");
        isWebElementsVisible(Wwp.Grouppopupmsg, getElementText(Wwp.successMessageGroup));

    }

    @And("Verify image should not be uploaded when image size exceed to 1MB")
    public void imageSizeGroup() throws InterruptedException, AWTException {
        click(Wwp.uploadImage, "Upload image");
        Thread.sleep(5000);
        uploadImageRobot(filePath1);
        waitForVisible(Wwp.imageExceedPopupMsg);
        isWebElementsVisible(Wwp.imageExceedPopupMsg, getElementText(Wwp.successMessageGroup));
        click(Wwp.closePost, "close the post page");
    }

    @And("click on user {string} to share Group card")
    public void click_on_desired_user_to_share_GroupCard(String user) throws InterruptedException {
        Thread.sleep(2000);
        click(Wwp.articleShareDesiredUser(user), "Click on "+user+" to share the Group card");
    }

    @And("Send the copied link to the other user")
    public void send_the_copied_link_to_user() throws Exception {
        getWebElement(Wwp.inputFieldSendMessage).sendKeys(Keys.CONTROL + "v");
        Thread.sleep(2000);

        hoverOnElement(Wwp.sendButtonOnSendMessage);
        click(Wwp.sendButtonOnSendMessage, "click on send button");
        Thread.sleep(2000);

        String Copied_text_url = getText(Wwp.copiedlinkonMessageInbox);

        Assert.assertTrue(isWebElementVisible(Wwp.copiedlinkonMessageInbox,Copied_text_url +" link sent to the user successfully"));
    }

    @Then("verify content of group card inside related item")
    public void verify() {
        List<WebElement> intersetedItems = getListElements(By.xpath("//div[@class='wwp-theme ct-card wrapper']"),"");
        if(intersetedItems.size()>0){
            for(int i=1;i<=intersetedItems.size();i++){
                Assert.assertTrue(isWebElementsVisible(Wwp.relatedGroupCardTitle(i), getElementText(Wwp.relatedGroupCardTitle(i))));
                Assert.assertTrue(isWebElementsVisible(Wwp.relatedGroupCardDescription(i), getElementText(Wwp.relatedGroupCardDescription(i))));
                if(isWebElementPresent(Wwp.relatedGroupCardImage(i),"image")==true){
                    Assert.assertTrue(isWebElementsVisible(Wwp.relatedGroupCardImage(i), "Image"));
                }
                else {
                    RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(String.format("Image is not present in this card")));

                }
            }
        }
    }


}