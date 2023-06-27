package pages.web;

import org.openqa.selenium.By;

public class Wwp {
    public static By veteranHelplineNumber = By.xpath("(//a[@title=\"988\"])[1]");
    public static By loginPageLogo = By.xpath("//img[@src='/WDX/resource/1680871917000/WWP_Portal_Assets/icon/wwp1_logo_black_1.png']");


    public static By loginLabel = By.xpath("//div[text()='Log in']");

    public static By emailInput = By.xpath("//input[@placeholder='Email/Username']");

    public static By passwordInput =By.xpath("//input[@placeholder='Password']");

    public static By loginButton = By.xpath("//button[@title='Log In']");

    public static By createAccountLink = By.xpath("//span[text()='Create Account']");

    public static By forgotPasswordLink = By.xpath("//a[@title='Forgot password?']");

    public static By invalidCredentialError=  By.xpath("//span[text()='Your login attempt has failed. Make sure the username and password are correct.']");

    public static By blankEmailError = By.xpath("//span[text()='Email/Username is required']");
    public static By blankPasswordError = By.xpath("//span[text()='Password is required']");

    public static By welcomeText = By.xpath("//div[text()='Welcome back! Please enter your email/username and password to log in.']");

    public static By registerTextOnLoginPage = By.xpath("//div[text()='Registered with Wounded Warrior Project®, but first time logging in?']");

    public static By createAccountPageHeading = By.xpath("//div[text()='Create Your Account']");

    public static By lastNameUnderCreateAccount = By.xpath("//input[@placeholder='Last name']");

    public static By emailUnderCreateAccount = By.xpath("//input[@placeholder='Email']");

    public static By firstNameUnderCreateAccount = By.xpath("//input[@placeholder='First name']");

    public static By continueButtonUnderCreateAccount = By.xpath("//button[@title='Continue']");

    public static By loginInputField(String fieldname){
        return By.xpath("//input[@placeholder='"+fieldname+"']");
    }
    public static By button(String buttonnname){
        return By.xpath("//button[text()=" + buttonnname + "]");
    }

    public static By createAccountPAge(String data) {
        return By.xpath("//input[@placeholder='" + data + "']");
    }

    public static By errorMessageFields(String data) {
        return By.xpath("//span[text()='"+ data + " is required']");
    }






    public static By passwordMasking = By.xpath("//input[@class='input password']");
    public  static  By closeEye = By.xpath("//span[@class='closeEye']");
    public  static  By profile = By.xpath("//a[@class='user-avatar-icon']//div[@class='image']");
    public  static  By logout = By.xpath("//span[text()='Logout']");
    public  static  By logintitle = By.xpath("//div[text()='Log in']");



    // People Locator
    public static  By peopleTitle = By.xpath("//div[@class='links-container']//a[@title='People']");

    public static  By peopleBannerTitle = By.xpath("//div[@class='banner-title']");

    public static  By PeopleBannerSubTitle = By.xpath("//div[@class='banner-subtitle']");
    public static  By peopleFind = By.xpath("//div[text()='Find']");
    public static  By connect = By.xpath("//div[text()='Connect']");
    public static  By chat = By.xpath("//div[text()='Chat']");

    public static  By findText = By.xpath("//div[text()='Search to find warriors and family support members with similar experience']");
    public static  By connectText = By.xpath("//div[text()='Reach out to others to create relationships and build your network']");
    public static  By chatText = By.xpath("//div[text()='Stay in touch with your connections with private messaging and more']");

    public static  By peopleSearch = By.xpath("//input[@placeholder='Search all warriors & FSMs']");
    public static  By peopleSearchSubmit = By.xpath("//button[@class='search-submit']");

    public static  By peopleMilitaryBranch = By.xpath("//div[text()='Military Branch']");
    public static  By peopleLocation = By.xpath("//div[text()='Location']");
    public static  By peopleSortBy = By.xpath("//div[text()='Sort By']");
    public static By peopleMyConnection = By.xpath("//c-wwp-people-my-connections//div[@class='title']");
    public static By peopleInvitation = By.xpath("//c-wwp-people-invitations//div[@class='title']");

    public  static  By peopleViewAll = By.xpath("//c-wwp-people-invitations//a[@class='view-all']");



    public static By suggestedPersonsImage= By.xpath("//div[contains(text(),'Suggested For You')]//parent::div//parent::div//div[@class='image']");

    public static By suggestedPersonsImageindex(int index) {
        return By.xpath("(//div[contains(text(),'Suggested For You')]//parent::div//parent::div//div[@class='image'])["+index+"]");
    }
    public  static  By showMoreButtonPeople = By.xpath("//button[@class='show-more-button']");
    public static By suggestedPersonsCard = By.xpath("//div[contains(text(),'Suggested For You')]//parent::div//parent::div//div[@class='wwp-theme ct-card person-card']");
    public static By personCategory = By.xpath("(//div[@class='user-name']/following-sibling::div[@class='info-text'])[1]");

    public static By MiltaryCategory = By.xpath("(//div[@class='user-name']/following-sibling::div[@class='info-text'])[2]");

    public static By usernameProfile = By.xpath("//div[@class='user-name']");

    public static By imageProfile = By.xpath("//div[@class='modal-container']//div[@class='image']");

    public static By LocationProfile = By.xpath("(//div[@class='modal-container']//div[@class='about-text'])[1]");
    public static By connectProfile = By.xpath("//div[@class='modal-container']//button[@title='Connect']");

    public static By aboutmeProfile = By.xpath("(//div[@class='modal-container']//div[@class='about-text'])[2]");


    public static By connectedClearFilters = By.xpath("//c-wwp-people-My-connections//a[text()='Clear Filters']");
    public static By suggestedClearFilters = By.xpath("//c-wwp-people-suggested//a[text()='Clear Filters']");

    public static By closeButton = By.xpath("//a[@class='close-button']");
    public static By connectedPersonName = By.xpath("//div[contains(text(),'My Connection')]//parent::div//parent::div//a[@class='full-name-header']");
    public static By suggestedPersonsName = By.xpath("//div[contains(text(),'Suggested For You')]//parent::div//parent::div//a[@class='full-name-header']");
    public static By connectedPersonsCard = By.xpath("//div[contains(text(),'My Connection')]//parent::div//parent::div//div[@class='wwp-theme ct-card person-card']");

    public static By connectedPersonsImage = By.xpath("//div[contains(text(),'My Connection')]//parent::div//parent::div//div[@class='wwp-theme ct-card person-card']//span[@class='letter']");

    public static By connectedPersonsUsername = By.xpath("//div[contains(text(),'My Connection')]//ancestor::c-wwp-people-my-connections//div[@class='wwp-theme wrapper']//div[@class='cards-container']//a[@class='full-name-header']");

    public static By connectedPersonsMessage = By.xpath("//div[contains(text(),'My Connection')]//ancestor::div[@class='wwp-theme wrapper']//div[@class='cards-container']//a[@class='connection-section']");

    public static By connectedPersonsLocation = By.xpath("//div[contains(text(),'My Connection')]//ancestor::div[@class='wwp-theme wrapper']//div[@class='cards-container']//div[@class='person-info']//div[@class='location-text']");

    public static By connectedPersonsLocationindex(int index) {
        return By.xpath("(//div[contains(text(),'My Connection')]//ancestor::c-wwp-people-my-connections//div[@class='wwp-theme wrapper']//div[@class='cards-container']//div[@class='person-info'])["+index+"]//div");

    }

    public static By connectedPersonsCardindex(int index) {
        return By.xpath("(//div[contains(text(),'My Connection')]//parent::div//parent::div//div[@class='wwp-theme ct-card person-card'])[" + index + "]");
    }
    public static By connectedPersonsImageindex(int index) {
        return By.xpath("(//div[contains(text(),'My Connection')]//parent::div//parent::div//div[@class='wwp-theme ct-card person-card']//span[@class='letter'])["+index+"]");
    }
    public static By connectedPersonsUsernameindex(int index) {
      return   By.xpath("(//div[contains(text(),'My Connection')]//ancestor::c-wwp-people-my-connections//div[@class='wwp-theme wrapper']//div[@class='cards-container']//a[@class='full-name-header'])["+index+"]");

    }

    public static By suggestedPersonsUsernameindex(int index) {
        return   By.xpath("(//div[contains(text(),'Suggested')]//ancestor::c-wwp-people-suggested//div[@class='wwp-theme wrapper']//div[@class='cards-container']//a[@class='full-name-header'])["+index+"]");

    }

    public static By suggestedPersonsLocationindex(int index) {
        return By.xpath("(//div[contains(text(),'Suggested')]//ancestor::c-wwp-people-suggested//div[@class='wwp-theme wrapper']//div[@class='cards-container']//div[@class='person-info'])["+index+"]//div");

    }

    public static By connectedPersonsMessageindex(int index) {
        return By.xpath("(//div[contains(text(),'My Connection')]//ancestor::div[@class='wwp-theme wrapper']//div[@class='cards-container']//a[@class='connection-section'])["+index+"]");

    }

    public static By connecteduser(String name) {
      return By.xpath("//c-wwp-people-my-connections//div[@class='person-info']//a[contains(text(),'"+name+"')]");
    }

    public static By connectedSearchStates = By.xpath("//c-wwp-people-my-connections//input[@placeholder='Search states']");


    public static By suggestedSearchStates = By.xpath("//c-wwp-people-suggested//input[@placeholder='Search states']");
    public static By connectedSelectState(String states){
        return    By.xpath("//c-wwp-people-my-connections//input[@type='checkbox' and @name='"+states+"']");
    }

    public static By suggestedSelectState(String states){
        return    By.xpath("//c-wwp-people-suggested//input[@type='checkbox' and @name='"+states+"']");
    }

    public static By connectedSelectMiltaryBranch(String militaryBranch) {
        return By.xpath("//div[contains(text(),'My Connections')]//a[text()='Military Branch']//ancestor::div[@class='popup-content']//input[@type='checkbox' and @name='"+militaryBranch+"']");

    }
    public static By suggestedSelectMiltaryBranch(String militaryBranch) {
        return By.xpath("//div[contains(text(),'Suggested')]//a[text()='Military Branch']//ancestor::div[@class='popup-content']//input[@type='checkbox' and @name='"+militaryBranch+"']");

    }

    public static By peopleSearchItems = By.xpath("//div[@class='no-items']");
    public static By peopleSearchClear = By.xpath("//a[text()='Clear']");
    public static By searchResultPersonsCard = By.xpath("//div[contains(text(),'Results for')]//parent::div//parent::div//div[@class='wwp-theme ct-card person-card']");
    public static By searchClear = By.xpath("//a[@class='search-clear']");
    public static By recentSearch = By.xpath("//div[@class='search-dropdown']");
    public static By myConnectionMilitaryBranchFilter = By.xpath("(//div[contains(text(),'My Connections')]//a[@class='filter-box'])[1]");
    public static By myConnectionLocationFilter = By.xpath("(//div[contains(text(),'My Connections')]//a[@class='filter-box'])[2]");


    public static By myConnectionInsideLocationFilter = By.xpath("//div[contains(text(),'My Connections')]//a[text()='Location']");

    public static By myConnectionInsideMilitaryFilter = By.xpath("//div[contains(text(),'My Connections')]//a[text()='Military Branch']");

    public static By suggestedInsideLocationFilter = By.xpath("//div[contains(text(),'Suggested')]//a[text()='Location']");

    public static By suggestedInsideMilitaryFilter = By.xpath("//div[contains(text(),'Suggested')]//a[text()='Military Branch']");

    public static By suggestedMilitaryBranchFilter = By.xpath("(//div[contains(text(),'Suggested')]//a[@class='filter-box'])[1]");
    public static By suggestedLocationFilter = By.xpath("(//div[contains(text(),'Suggested')]//a[@class='filter-box'])[2]");
    public static By resultsMilitaryBranchFilter = By.xpath("(//div[contains(text(),'Results')]//a[@class='filter-box'])[1]");
    public static By resultsLocationFilter = By.xpath("(//div[contains(text(),'Results')]//a[@class='filter-box'])[2]");
    public static By usStateList = By.xpath("//div[@class='filter-popup popup-open']//div[@class='filter-checkbox-text']");
    public static By userImage = By.xpath("(//*[@class='user-avatar'])[3]");
    public static By userCardName = By.xpath("(//a[@class='full-name-header'])[1]");
    public static By popupUserName = By.xpath("//div[@class='user-name']");
    public static By category = By.xpath("//div[@class='info-text']");
    public static By connectedSince = By.xpath("//div[@class='connected-since']");
    public static By sendMessage = By.xpath("//a[@class='send-message']");
    public static By removeConnection = By.xpath("//a[@class='remove-connection']");
    public static By location = By.xpath("//div[@class='about-info-wrapper']");
    public static By goBackButton = By.xpath("//span[@class='go-back-text']");
    public static By statusInfo=By.xpath("//span[@class='status-info-text']");
    public static By popupUserImage = By.xpath("(//div[@class='image'])[4]");




    public static By requestCloseButton = By.xpath("//button[@class='action-cancel']");
    public static By requestApproveButton = By.xpath("//button[text()='Approve']");

    public  static  By requestButton(String connect , String name){
        return By.xpath("//a[contains(text(),'"+name+"')]//ancestor::div[@class='wwp-theme ct-card person-card']//button[contains(text(),'"+connect+"')]");
    }

    public  static  By invitationName(String name){
        return By.xpath("//c-wwp-people-invitations//a[contains(text(),'"+name+"')]");
    }

    public  static  By invitationImage(String name){
        return By.xpath("//c-wwp-people-invitations//a[contains(text(),'"+name+"')]//ancestor::c-wwp-person-card//c-wwp-user-avatar");
    }
    public  static  By connectionMsg(String name){
        return By.xpath("//c-wwp-people-my-connections//a[contains(text(),'"+name+"')]//ancestor::c-wwp-person-card//a[@class='connection-section']");
    }
    public static By requestDenyButton = By.xpath("//button[text()='Deny']");
    public static By connectButton = By.xpath("//button[text()='Connect']");
    public static By userImageOnTop = By.xpath("(//div[@class='image'])[1]");
    public static By logoutButton = By.xpath("(//a[@class='user-menu-line'])[2]");
    public static By MsgIcon = By.xpath("//a[@class='connection-section']");
    public static By removeConnectionOnPopup = By.xpath("//button[@title='Remove from my connections']");
    public static By yesButton = By.xpath("//button[@class='action action-yes']");
    public static By messageInputBox = By.xpath("//textarea[@class='new-message-input']");
    public static By submitButton = By.xpath("//button[@class='new-message-submit']");
    public  static  By sendMsgVerfication = By.xpath("(//div[@class='text'])[1]");
    public static By msgIconOnTop = By.xpath("//a[@class='icon icon-message']");
    public static By UserConversationOverview = By.xpath("//div[@class='conversation-overview']");
    public static By errorMessage = By.xpath("//div[@class='error-message']");

    public static By historicalConversation = By.xpath("//div[@class='threads-container']");

    public static By pendingStatus = By.xpath("//i[text()='Pending']");
    public static By notificationIcon = By.xpath("//a[@class='icon icon-notifications']");
    public static By sentMessageNotification = By.xpath("//div[text()=' sent you a new message.']");


    public static By suggestionList = By.xpath("//c-wwp-people-suggested//div[@class='wwp-theme ct-card person-card']");
// create account page

    public static By createAccountsuccessMessage = By.xpath("//div[@class='success-message']");
    public  static  By resetBtn = By.xpath("//input[@title='Reset Password']");
    public  static  By retypePwd = By.xpath("//input[@placeholder='Retype your password']");
    public  static  By createPassword = By.xpath("//button[text()='Create Password']");
    public  static  By resetPwdTitle = By.xpath("//h3[text()='Choose a password']");
    public  static  By privacyPolicy = By.xpath("//a[@title='Privacy Policy']");
    public  static  By termsAndConditions = By.xpath("//a[@title='Terms and Conditions']");
    public  static  By passwordChangedMsg = By.xpath("//h3[text()='Your password has been changed!']");
    public  static  By launchHomePage = By.xpath("//button[text()='Continue to Home Page']");
    public  static  By veteransHelpline = By.xpath("(//a[@title='988'])[1]");
    public  static  By termsAndConditionsPage = By.xpath("//h1[text()='WDX Terms and Conditions ']");
    public  static  By privacyPolicyPage = By.xpath("//h1[normalize-space()='General User Privacy Policy']");

    public  static  By pwdValidationMsg(int index) {
       return By.xpath("//div[@class='validation password-validation validation-visible']//div["+index+"]");
    }
    public  static  By retypePwdvalidationMsg =By.xpath("//div[@class='validation repeat-password-validation validation-visible']//div[1]");
    public  static By invalidCredErrorMsg = By.xpath("//span[text()='We could not find an account with that information.']");




    //Email Page

    public static By emailUsername =  By.xpath("//input[@type='email']");
    public static By emailPassword =  By.xpath("//input[@type='password']");
    public static By emailNext =  By.xpath("//input[@id='idSIButton9']");
    public static By emailSignupOption=  By.xpath("//input[@value='Yes']");

    public static By emailSubmit =  By.xpath("//input[@data-report-event='Signin_Submit']");

    public static By clickOutlook=  By.xpath("//img[@src='https://res-1.cdn.office.net/shellux/outlook_24x.59692ba8e1f344194426952916c16896.svg']");



    public static By emailMessage =  By.xpath("(//span[@title='resourcecenter@woundedwarriorproject.org'])[1]");

    public static By emailBodyText =  By.xpath("(//span[@style='font-size:12pt'])[1]");

    //ForgotPassword

    public static By forgotPwdLink =  By.xpath("//a[@title='Forgot password?']");
    public static By forgotPwdTitle =  By.xpath("//div[text()='Forgot your password?']");
    public static By resetPwdBtn =  By.xpath("//button[text()='Reset Password']");
    public static By successResetMsg =  By.xpath("//div[text()='We’ve sent you an email with a link to finish resetting your password.']");

    public static  By backBtn = By.xpath("//span[text()='Back']");
    public static  By blank = By.xpath("//span[text()='Back']");
    public static By successMessage = By.xpath("//div[@class='success-message']");

    //Browser all
    public static By login(String placeholder) {
        return By.xpath("//input[@placeholder=" + placeholder + "]");
    }

    public static By Click_link(String linkname) {
        return By.xpath("//div[@class='links-container']//a[@title=" + linkname + "]");
    }

    public static By click_link_view_all(String linkname){
        return By.xpath("//div[@title='"+linkname+"']");
    }

    public static By click_checkboxes(String checkboxname){
        return By.xpath("//input[@data-name='"+checkboxname+"']");
    }

    public static By click_apply_filter_or_reset_filter(String button){
        return By.xpath("//button[@title='"+button+"']");
    }

    public static By Enter_dates(String dates){
        return By.xpath("//input[@placeholder='"+dates+"']");
    }
    public static By sign_in_button = By.xpath("//button[text()='Log In']");

    public static By banner_image = By.xpath("//div[@class='banner-container']");

    public static By Browse_All_text = By.xpath("//div[@class='banner-title']");

    public static By events_text = By.xpath("//div[@class='banner-subtitle']");

    public static By searach_field=By.xpath("//input[@placeholder='Search by name...']");

    public static By featured_text=By.xpath("//div[contains(text(),'Featured')]");

    public static By view_all= By.xpath("//button[text()='View All']");

    public static By interst=By.xpath("//div[@class='interest-header']");

    public static By search_button=By.xpath("//button[@class='search-submit']");

    public static By Monthly_fitness_challenge=By.xpath("//a[text()='Monthly Fitness Challenge']");

    public static By no_result_text=By.xpath("//div[@class='no-results-text']");

    public static By browse_All=By.xpath("//button[text()='Browse All']");

    public static By arrow_buttons=By.xpath("//div[@class='nav-buttons']");

    public static By featured_container=By.xpath("//div[@class='featured-container']");
    public static By featured_contianer_Events=By.xpath("//div[@class='featured-container']//a[@class='title']");

    public static By interst_container=By.xpath("//div[@class='interest-container']//a[@class='topic-link']");

    public static By Back_button=By.xpath("//a[@title='Back']");

    public static By View_all_topic_header=By.xpath("//div[@class='topic-header']");

    public static By filter_options=By.xpath("//div[@class='filter-box-container']");

    public static By event_view_all=By.xpath("//div[@class='show-items-container']");

    public static By all_events=By.xpath("//div[@class='show-items-container']");

    //   public static By dropdown_format_elements=By.xpath("//div[@class='input-container radio-container-margin']");
    public static By dropdown_format_elements =By.xpath("//div[@class='filter-dialog-content']");

    public static By options=By.xpath("//div[@class='show-items']//div[@class='show-item']");

    public static By location_search_text=By.xpath("//input[@class='address-input']");
    public static By End_Date=By.xpath("//input[@placeholder='End Date']");
    public static By Start_Date=By.xpath("//input[@placeholder='Start Date']");

    public static By click_link=By.xpath("//div[@class='show-item']//a[@class='title']");

    public static By Show_button=By.xpath("//button[@title='Show More']");
    public static By recent_Search=By.xpath("//div[@class='recent-search']");

    public static By elements=By.xpath("//div[@class='show-item']");



      //For you
      public static  By welcomeTextOnForYou = By.xpath("//div[contains(text(),'Welcome')]");

    public static By homepageHeaderLink(String title){
        return By.xpath("(//a[@title='"+title+"'])[1]");
    }

    public static  By crisisLine = By.xpath("//div[@title='Crisis Line']");

    public static  By userProfileIcon = By.xpath("//a[@class='user-avatar-icon']");

    public static  By bannerImage = By.xpath("//div[@class='banner']");

    public static By forYouFilters(String title){
        return By.xpath("//a[@title='"+title+"']");
    }

    public static  By homepageBannerTitle = By.xpath("//div[@class='banner-title']");

    public static  By homepageBannerSubTitle = By.xpath("//div[@class='banner-subtitle']");

    public static  By forYouUpdateMyInterestLink = By.xpath("//a[text()='Update My Interests']");

    public static  By interestPageHeading= By.xpath("//div[@class='page-title-text'  and text()='Interests']");

    public static By forYouClickedAllfilter = By.xpath("//a[@class='navigation-item navigation-item-active' and @title='All']");

    public static By forYouCategoryName(String name){
        return By.xpath("//div[text()='"+name+"']");
    }

    public static By forYouShowMoreButton = By.xpath("//button[text()='Show more']");

    public static By forYouShowMoreButtonstructure = By.xpath("//div[@class='actions']");

    public static By forYouCategoryStructure = By.xpath("//div[@class='section-container']");

    public static By forYouFirstCategory = By.xpath("(//div[@class='section-container'])[1]");

    public static By forYouCategoryCards(int index){
        return By.xpath("(//div[@class='section-container'])["+index+"]//div[@class='keen-slider__slide']");
    }

    public static By forYouCategoryRightArrowLink(int index){
        return By.xpath("(//div[@class='section-container'])["+index+"]//a[@class='nav-button nav-button-right']");
    }

    public static By forYouFirstCardUnderFirstCategoryLink = By.xpath("((//div[@class='section-container'])[1]//div[@class='keen-slider__slide'])[1]//a");


    public static By backLink = By.xpath("//span[text()='Back']");

    public static By nearmeInputField(String input){
        return By.xpath("//input[@placeholder='"+input+"']");
    }

    public static By nearmeRange(String value){
        return By.xpath("//div[@data-value='"+value+"']");
    }

    public static By nearmeRangefield = By.xpath("//div[@class='filter-box-placeholder']");

    public static By nearmeApplyButton = By.xpath("//button[@title='Apply']");

    public static By nearmeCategorySectionOne = By.xpath("(//div[@class='section-container'])[1]");

    public static By nearmeFirstEventUndercategory = By.xpath("((//div[@class='section-container'])[1]//div[@class='keen-slider__slide'])[1]//a");

    public static By nearmeErrorOnInputField(String input){
        return By.xpath("//input[@class='filter-input filter-input-"+input+" filter-input-error']");
    }

    public static By nearmeCountryVerification(String country) {
        return By.xpath("((//div[@class='section-container'])[1]//div[contains(text(),'"+country+"')])[1]");
    }
    public static By for_you_category_name(String text){
        return By.xpath("//div[text()='"+text+"']");
    }

    public static By forYouMultipleCategoryNames = By.xpath("//div[@class='content-wrapper']//div[@class='title-section']");

    public static By wwpLogo = By.xpath("//img[@class='logo-icon']");

    public static By homepageHeaderLinkActive(String text){
        return By.xpath("(//a[@class='link link-active' and @title='"+text+"'])[1]");
    }

    public static By forYouReadMoreLinkOnFirstArtcile = By.xpath("(//a[text()='Read More'])[1]");



    public static By forYouUpcomingDataList = By.xpath("(//div[@class='carousel-container'])[1]//div[@class='keen-slider slider']");

    public static By logoutLink = By.xpath("//span[text()='Logout']");

    //Article xpath

    public static By copiedlinkonMessageInbox = By.xpath("(//div[@class='message'])[1]//div[@class='text']");

    public static By sendAMessageLinkOnUserPage = By.xpath("//a[@class='send-message']");

    public static By firstUserInMyConnection = By.xpath("(//c-wwp-people-my-connections//div[@class='person-info'])[1]");

    public static By bannerTitle = By.xpath("//div[@class='banner-title']");


    public static By articleTitle = By.xpath("//div[@class='go-back']/following-sibling::div[@class='title']");

    public static  By articleContent = By.xpath("//div[@class='content-container']");

    public static By articleImage = By.xpath("//div[@class='image-container image-container-desktop']");

    public static By articleShareLink = By.xpath("//button[@title='Share']");

    public static By articleCopyLinkUnderSharePopup = By.xpath("//div[@class='action-copy-link-button']");

    public static By articleCopyLinkSuccessPopup = By.xpath("//p[@class='iziToast-message slideIn']");

    public static By articleSearchFieldInSharePopup = By.xpath("//input[@class='search-input']");

    public static By articleCloseButtonUnderSharePopup = By.xpath("//div[@title='Close']");

    public static By articleRelatedItem = By.xpath("//div[@class='related-items']");

    public static By articleProgramsInRelatedItem =  By.xpath("//div[@class='keen-slider__slide']");

    public static By forYouReadMoreLinkOnFirstStoryArtcile = By.xpath("(//c-wwp-card-story//a[text()='Read More'])[1]");

    public static By articleRightArrowButton = By.xpath("//a[@class='nav-button nav-button-right']");

    public static By relatedArticlefirstCardImage= By.xpath("(//div[@class='wwp-theme ct-card wrapper'])[1]//div[@class='image-wrapper']");

    public static By relatedArticlefirstCardTitle = By.xpath("(//div[@class='wwp-theme ct-card wrapper'])[1]//a[@class='title']");

    public static By relatedArticlefirstCardDescription = By.xpath("(//div[@class='wwp-theme ct-card wrapper'])[1]//div[@class='description']");


    public static By articleShareUserOne = By.xpath("(//div[@class='user'])[1]");

    public static By articleYesButtonOnSharePopup = By.xpath("//button[@class='action action-yes']");

    public static By articleCancelButtonOnSharePopup = By.xpath("//button[@class='action action-no']");

    public static By confirmationPopupOnSharepopup = By.xpath("//div[text()='Share this item']");

    public static By nameOnLatestSharedArticleInbox = By.xpath("(//div[@class='message'])[1]//div[@class='name']");

    public static By imageOnLatestSharedArticleInbox = By.xpath("(//div[@class='message'])[1]//div[@class='image']");
    public static By readmorelinkLatestSharedArticleInbox = By.xpath("(//div[@class='message'])[1]//a[@class='read-more']");

    public static By datetimeLatestSharedArticleInbox = By.xpath("((//div[@class='message'])[1]//div[@class='header'])[1]");

    public static By foryouLinkActive = By.xpath("//div[@class='links-container']//a[@title='For You' and @class='link link-active']");

    public static By sendMessageInputBox = By.xpath("//form[@class='new-message-container']");

    public static By inputFieldSendMessage = By.xpath("//textarea[@class='new-message-input']");

    public static By sendButtonOnSendMessage = By.xpath("//button[@class='new-message-submit']");

    //new message
    public static By newMessageAlertInMessagepage = By.xpath("//div[@class='unread-mark' and text()='new']");

    public static By messagePill = By.xpath("(//div[@class='messages-pill'])[1]");

    public static By userAvatarInMessagePage(String User){
        return By.xpath("//a[@class='user' and text()='"+User+"']");
    }

    public static By articleShareDesiredUser(String user){
        return By.xpath("//div[@class='user' and text()='"+user+"']");
    }

//group Locator
    public static  By groupTitle = By.xpath("//div[@class='links-container']//a[@title='Groups']");

    public static  By groupPrivacyBannerTitle = By.xpath("//div[@class='private-user-banner']");

    public static  By groupBannerTitle = By.xpath("//div[@class='banner-title']");

    public static  By groupBannerSubTitle = By.xpath("//div[@class='banner-subtitle']");
    public static  By groupFind = By.xpath("//div[text()='Find']");
    public static  By groupFollow = By.xpath("//div[text()='Follow']");
    public static  By groupEngage = By.xpath("//div[text()='Engage']");

    public static  By groupFindText = By.xpath("//div[text()='Browse our community groups to connect with others who share your interests']");
    public static  By groupFollowText = By.xpath("//div[text()='Stay informed by following the groups you enjoy to see recent posts and updates']");
    public static  By groupEngageText = By.xpath("//div[text()='Post, comment, and share with your fellow warriors and family service members']");
    public  static  By searchGroups =By.xpath("//input[@placeholder='Search Groups']");
    public  static  By showAllSuggested = By.xpath("//a[text()='Show All Suggested For You']");

    public static  By grouplist(int index){
        return By.xpath("(//div[@class='group-list'])["+index+"]//div[@class='group']");
    }
    public  static  By groupslist =By.xpath("//div[@class='category-title']//following-sibling::div");
    public  static  By groupCategoryTitle =By.xpath("//div[@class='category-title']");

    public  static  By myGroups =By.xpath("//a[text()='My Groups']");
    public  static  By followers= By.xpath("(//div[@class='card-container']//a[@class='title'])[1]");




    public  static  By groupCount = By.xpath("//div[@class='card-container']//a[@class='title']");


    public  static  By unFollow =By.xpath("//button[@title='Unfollow']");

    public  static  By leaveTheGroupMsg =By.xpath("//div[text()='Are you sure you want to leave this group?']");

    public  static  By UnfollowTheGroup =By.xpath("//button[@class='action action-yes']");

    public  static  By selectGroupUndercategory(String category){
        return By.xpath("//div[contains(text(),'"+category+"')]//ancestor::div[@class='category-container']//div[@class='group-list']//a");
    }

    public  static  By categoryTitle(String category){
        return By.xpath("//div[text()='"+category+"']//ancestor::div[@class='category-container']//div[@class='group']");
    }

    public  static  By groupNameUnderCategory(String category,int index){
        return By.xpath("(//div[text()='"+category+"']//ancestor::div[@class='category-container']//div[@class='group-list']//a)["+index+"]");
    }

    public  static  By imageUndercategory(String category,int index){
        return By.xpath("(//div[text()='"+category+"']//ancestor::div[@class='category-container']//div[@class='group-list']//c-wwp-user-avatar)["+index+"]");
    }
    public  static  By followingUndercategory(String category,int index){
        return By.xpath("(//div[text()='"+category+"']//ancestor::div[@class='category-container']//div[@class='group-list']//div[@class='sub-title'])["+index+"]");
    }

    public  static  By choosegroup(String group){
        return By.xpath("//a[text()='"+group+"']//ancestor::div[@class='card-container']//a");
    }



    public  static  By showAllGroupList(String category){
        return By.xpath("//a[text()='Show All "+category+"']");
    }

    public  static  By groupName =By.xpath("//div[@class='header-container']//div[@class='title']");
    public  static  By shareGroup =By.xpath("//button[@title='Share']");
    public  static  By followGroup =By.xpath("//button[@title='Follow']");
    public  static  By followingMemberGroup = By.xpath("//div[@class='members-label']");
    public  static  By createPost =By.xpath("//div[text()='Create Post']");

    public  static  By discussionGroup =By.xpath("//div[text()='Discussions']");



    public  static  By closeTheMsg =By.xpath("//button[@class='iziToast-close']");
    public static  By popupmsg =By.xpath("//strong[text()='Goodbye!']");
    public static  By Followpopupmsg =By.xpath("//strong[text()='Success!']");
    public static  By imageExceedPopupMsg =By.xpath("//strong[text()='Image too large']");
    public static  By uploadImage =By.xpath("//a[@class='image-action']");
    public static By successMessageGroup=By.xpath("//div[@class='iziToast-texts']//div//div[2]");
    public static  By Grouppopupmsg =By.xpath("//strong[text()='Success']");

    public static  By closePost =By.xpath("//button[@title='Close']");

    public static By my_groups_groups_list=By.xpath("//div[@class='groups-section']//a[@class='title']");
    public static By recent_group_activity=By.xpath("//div[@class='recent-activity-card']");

    public static By create_post_icon=By.xpath("//button[@class='group-action create-post']");

    public static By group_title=By.xpath("//div[@class='group-title']");
    public static By following_count=By.xpath("(//div[@class='members-label'])[2]");

    public static By textarea=By.xpath("//textarea[@placeholder='Share your thoughts...']");

    public static By image_icon=By.xpath("//a[@class='image-action']");

    public static By community_guidelines=By.xpath("//a[@class='community-rule-link']");

    public static By submit_buttonGroup=By.xpath("//button[@class='action action-submit']");

    public static By cncel_butotn=By.xpath("//button[@class='action action-cancel']");

    public static By user_name=By.xpath("//a[@class='discussion-user-name']");

    public static By timestampGroup =By.xpath("//div[@class='discussion--user-datestamp']");

    public static By user_comment=By.xpath("//div[@class='discussion-text']");

    public static By like_butotn=By.xpath("//a[@class='action-like']");

    public static By comment=By.xpath("//a[@class='action-comment']");

    public static By flag=By.xpath("//a[@class='action-flag']");


    public static By edit_icon=By.xpath("//a[@class='action-edit']");
    public static By editiconIndex(int index) {
        return By.xpath("(//a[@class='action-edit'])["+index+"]");
    }

    public static By deleteiconIndex(int index) {
        return By.xpath("(//a[@class='action-delete'])["+index+"]");
    }

    public static By delete_icon=By.xpath("//a[@class='action-delete']");

    public static By image=By.xpath("//div[@class='post-image-container']");

    public static By edit_actions=By.xpath("//div[@class='edit-actions']");

    public static By write_comment=By.xpath("//textarea[@placeholder='Write a comment...']");

    public static By post_comment=By.xpath("//button[text()='Post']");

    public static By delete=By.xpath("//button[text()='Delete']");

    public static By group_name=By.xpath("//a[@class='group-name']");

    public static By recent_Activity_group_name=By.xpath("(//div[@class='title'])[1]");

    public static By show_more=By.xpath("//a[@title='Show More']");
    public  static  By showMoreDiscussionGroup = By.xpath("//a[@class='show-more-button']");


    public static By all_group=By.xpath("//a[text()='All Groups']");

    public static By all_groups_groups=By.xpath("//div[@class='group-list']//div[@class='group']//a[@class='title']");

    public static By delete_icon_in_allgroups=By.xpath("(//div[@class='edit-actions']//a[text()='Delete'])[1]");
    public static By edit_icon_in_all_groups=By.xpath("(//div[@class='edit-actions']//a[text()='Edit'])[1]");

    public static By submit_icon=By.xpath("//button[text()='Submit']");

    public static By updated_comment_textbox=By.xpath("(//textarea[@placeholder='Write a comment...'])[2]");

    public static By flag_textarea=By.xpath("//textarea[@class='field-item field-input']");

    public static By click_button_using_text(String buttonname){
        return By.xpath("//button[text()='" + buttonname+"']");
    }

    public static By second_radio_button=By.xpath("(//span[@class='slds-radio_faux']) [2]");

    public static By first_radio_button=By.xpath("(//span[@class='slds-radio_faux']) [1]");

    public static By group_search=By.xpath("//input[@class='search-input']");

    public static By group_submit=By.xpath("//button[@class='search-submit']");

    public static By flaged_icon=By.xpath("//a[@class='action-flag discussion-flagged']");

    public static By share_icon=By.xpath("//button[@title='Share']");

    public static By copy_link=By.xpath("//div[@title='Copy Link']");

    public static By closeButtonGroup =By.xpath("//div[@class='close-button']");
    public static By search_button_share=By.xpath("//button[@class='search-button']");

    public static By yes_button=By.xpath("//button[@title='Yes']");

    public static By messagesGroup=By.xpath("//div[@class='message']");

    public static By messages_group_title=By.xpath("(//a[@class='title'])[1]");

    public static By messages_following_count=By.xpath("(//div[@class='sub-title'])[1]");

    public static By messages_letter=By.xpath("(//c-wwp-user-avatar//span[@class='letter'])[1]");

    public static By selectSearchinShare(String name) {
        return By.xpath("(//div[@class='user'][normalize-space()='" + name + "'])[1]");

    }

    public static By receiverName(String name) {
        return By.xpath("//div[text()='"+name+"']");

    }

    public static By relatedGroupCardImage(int index) {
        return By.xpath("(//div[@class='wwp-theme ct-card wrapper'])["+index+"]//div[@class='image-wrapper']");
    }
    public static By relatedGroupCardTitle(int index) {
      return  By.xpath("(//div[@class='wwp-theme ct-card wrapper'])["+index+"]//a[@class='title']");
    }
    public static By relatedGroupCardDescription(int index) {
        return By.xpath("(//div[@class='wwp-theme ct-card wrapper'])[" + index + "]//div[@class='description']");
    }








    // message locator
    public static By all_messages_content_and_users= By.xpath("//div[@class='conversation-overview']//div[@class='content']");
    public static By users=By.xpath("//div[@class='conversation-overview']//div[@class='content']//a[@class='user']");
    public  static By messages=By.xpath("//div[@class='conversation-overview']//div[@class='content']//div[@class='message']");
    public static By timestamp=By.xpath("//div[@class='conversation-overview']//div[@class='info']//div[@class='timestamp']");

    public static By message_box=By.xpath("//textarea[@placeholder='Write a message...']");
    public static By search_message_box=By.xpath("//input[@placeholder='Search messages']");
    public static By search_butoton=By.xpath("//button[@title='Search']");


    public static By individualUser=By.xpath("//a[@class='user']");


    public static By user_list=By.xpath("//div[@class='user']");



    public static By new_message=By.xpath("//a[@title='New Message']");

    public static By flag_icon=By.xpath("//a[@title='Flag this message']");
    public static By submit_button=By.xpath("//button[text()='Submit']");
    public static By send_button=By.xpath("//button[text()='Send']");

    public static By textarea_flag_icon=By.xpath("//div[@class='field-title']");

    public static By close_button=By.xpath("//button[text()='Close']");
    public static By message_Count=By.xpath("(//div[@class='messages-pill'])[1]");

    public static By unread_messgaes=By.xpath("//div[@class='unread-mark']");
    public static By back_button=By.xpath("//a[@title='Go Back']");

    public static By notification_icon=By.xpath("(//div[@class='notifications-pill'])[1]");

    public static By notificationlist=By.xpath("//div[text()='New']//ancestor::div[@class='container']//div[@class='notification']");

    public static By new_text=By.xpath("//div[text()='New']");


    public static By notification_content=By.xpath("//div[@class='notification-content']");

    public static By notification_count_Again=By.xpath("//div[text()='New']/..//div[@class=\"notification\"]/..//div[@class='divider']");

    public static By radio_button(String radionuttonname){
        return  By.xpath("//span[text()='"+radionuttonname+"']");
    }

    public static By success_message=By.xpath("//div[@class='iziToast-texts']//div//div[1]");
    public static By name(String name){
        return By.xpath("//div[text()='"+name+"']");
    }

    public  static  By messageBodyRC = By.xpath("//a[text()='Resource Center']");

    public static By searchUserName(String name){
        return By.xpath("//a[contains(text(),'"+name+"')]");
    }


    //RC support Locator

    public static By telephone_number=By.xpath("//div[@class='rc-item-right-container']//a[@href='tel:+18889972586']");

    public static By faq_question=By.xpath("//div[@class='faq-question']");
    public static By faq_answers=By.xpath("//div[@class='faq-answer']");

    public static By plus_button=By.xpath("//a[@class='plus-sign']");

    public static By message_textarea=By.xpath("//textarea[@data-target-id='message']");

    public static By messagesRC=By.xpath("//div[@class='message']");

    public static By back_buttonRC=By.xpath("//a[@title='Go Back']");

    public static By resource_centre=By.xpath("//a[text()='Resource Center']");



    public static By click_link(String linkname){
        return By.xpath("//div[@class='links-container']//a[@title='"+linkname+"']");
    }

    public static By clickicon(String iconname){
        return  By.xpath("//div[@class='icons-container']//a[@title='"+iconname+"']");
    }
    public static By rc_text(String text){
        return  By.xpath("//div[@class='rc-item-text']//div[text()='"+text+"']");
    }

    public static By form(String field){
        return By.xpath("//input[@id='"+field+"']");
    }

    public static By click_title(String linkname){
        return By.xpath("//div[@class='rc-item-right-container']//a[@title='"+linkname+"']");
    }

    public static By  button_clickable(String buttonname){
        return By.xpath("//button[text()='"+buttonname+"']");
    }


    //Veteran Crisiline xpath

    public  static  By veteranClose = By.xpath("//div[@class='crisis-line']//a[@title='Close']");

    public  static  By veteranCall = By.xpath("//div[@class='crisis-line']//div[@class='crisis-line-number']//a[@title='988']");


    public  static  By veteranText = By.xpath("//div[@class='crisis-line']//div[@class='crisis-line-number']");

//Account

    public static By account = By.xpath("//span[text()='Account']");

    public static By accountUsername = By.xpath("//div[@class='user-info name']");
    public static By accountAboutme = By.xpath("//div[text()='About Me']//following-sibling::a");

    public static By aboutMePrivacySetting = By.xpath("//a[@title='View Privacy Settings ']");
    public static By aboutmePrivacy(String privacy) {
        return By.xpath("//input[@value='"+privacy+"']");
    }
    public static By savePrivacy = By.xpath("//button[text()='Save']");
    public static  By updateAccount = By.xpath("(//a[@title='Update'])[1]");
    public static  By benefitServiceAccount =By.xpath("(//div[text()='Benefits Services ']//following::a)[1]");

    public static  By closeAccount =By.xpath("//div[@class='close-button']");

    public static By countryDropdownArrowUnderPhoneUpdate = By.xpath("//div[@class='iti__arrow']");

    public static By unitedKingdomInCountryDropdown= By.xpath("(//span[@class='iti__country-name' and text()='United Kingdom'])[1]");

    public static  By accountManagementLink = By.xpath("//span[text()='Account']");
    public static By viewLinkOnAccountManagement(String category){
        return By.xpath("(//div[text()='"+category+"']//following::a)[1]");
    }

    public static By firstCheckboxOnMyInterestsPage = By.xpath("(//input[@type='checkbox'])[1]");

    public static By saveButtonOnMyInterestPage = By.xpath("//button[@title='Save']");

    public static By successPopupOnMyInterestPage = By.xpath("//p[@class='iziToast-message slideIn']");

    public static By checkboxesUnderBenefit_Services = By.xpath("//div[text()='Benefits Services ']//parent::div//parent::div[@class='carousel']//input[@type='checkbox']");

    public static By getCheckboxesUnderBenefit_Services_with_index(int i){
        return By.xpath("(//div[text()='Benefits Services ']//parent::div//parent::div[@class='carousel']//input[@type='checkbox'])["+i+"]");
    }

    public static By updateLinkUnderContactInfo(String category){
        return By.xpath("(//div[text()='"+category+"']//following::a)[1]");
    }

    public static By inputFieldUnderContact = By.xpath("//input");

    public static By gobackLink = By.xpath("//a[@title='Go Back']");

    public static By countryInputField = By.xpath("//div[@data-id='countryForm']//a[@class='text-box-select']");

    public static By searchCountryField = By.xpath("//input[@placeholder='Search Country']");

    public static By searchedCountryResult = By.xpath("//a[@data-value='US']");

    public static By stateInputField = By.xpath("//div[@data-id='stateForm']//a[@class='text-box-select']");

    public static By searchStateInputField = By.xpath("//input[@placeholder='Search State']");

    public static By searchStateResult(String state_name){
        return By.xpath("//a[text()='"+state_name+"']");
    }

    public static  By save_button_underContactUpdate = By.xpath("//button[@title='Save']");

    public static By successToastPopup = By.xpath("//div[@class='iziToast-wrapper iziToast-wrapper-topCenter']");

    public static By streetInputField = By.xpath("//input[@placeholder='Your Street...']");

    public static By addLinkOnAccountManagement = By.xpath("//a[text()='Add']");

    public static By aboutMePageHeading = By.xpath("//div[@class='page-title-section']//div[text()='About Me']");

    public static By TellusBitAboutYouInputField = By.xpath("//textarea[@class='text-box']");

    public static By viewPrivacySettingLink = By.xpath("//a[text()='View Privacy Settings ']");
    public static By PrivacySettingspageHeading = By.xpath("//div[@class='page-title-section']//div[text()='Privacy Settings']");

    public static By updateLinkOnAccountManagement(String category){
        return By.xpath("(//div[text()='"+category+"']//following::a)[1]");
    }
    public static By notificationPageHeading = By.xpath("//div[@class='page-title-section']//div[text()='Notifications']");

    public static By notificationsettings(String categories){
        return By.xpath("//div[@class='setting-text-title'  and  text()='"+categories+"']");
    }

    public static By categoryNameOnEventsAccountManagement(String category){
        return By.xpath("//div[@class='category-name' and text()='"+category+"']");
    }


    public static By myEventsPageHeadingUnderAccountManagement = By.xpath("//div[@class='page-title-text' and text()='My Events']");

    public static By pagesHeadingOfAccountManagementCategories(String category){
        return By.xpath("//div[@class='page-title-text' and text()='"+category+"']");
    }

    public static By stayVisibleRadioButton = By.xpath("//div[text()='Stay Visible']//preceding::input");

    public static By goPrivateRadioButton = By.xpath("//div[text()='Stay Visible']//following::input");

    public static By firstLikeLinkUnderGroupsPosts = By.xpath("(//a[@title='Like'])[1]");

    public static By privateNoteAlertOnGroupsPAge = By.xpath("//div[@class='private-user-banner']");

    public static By learnMoreLink = By.xpath("//a[@title='Learn More']");
    public static By privacySettingsPopupHeading = By.xpath("//div[@class='modal-container']//div[text()='Privacy Settings']");

    public static By updateLinkForPasswordUpdate = By.xpath("//a[@title='Update']");
    public static By yesButtonOnUpdatePasswordPopup = By.xpath("//button[@class='action action-yes']");

    public static By continueToHomePage = By.xpath("//button[text()='Continue to Home Page']");

    public static By emailRegisteredOne = By.xpath("(//div[@class='table-cell tile-img'])[1])");

    public static By unitedStatesInCountryDropdown= By.xpath("(//span[@class='iti__country-name' and text()='United States'])[1]");
    public static By phoneNumber= By.xpath("//input[@type='phone']");

    //Event Locator
    public static By bannerText = By.xpath("//div[text()='Events, Service Offerings & Community Partnerships For You']");


    public static By eventName(String eventName){
        return By.xpath("//a[@title='"+eventName+"']");
    }

    public static By eventList = By.xpath("//div[@class='navigation']//parent::div//c-wwp-card-event");

    public static By eventTitle(int index){
        return By.xpath("(//div[@class='navigation']//parent::div//c-wwp-card-event//a[@class='title'])["+index+"]");
    }

    public static By eventDescription(int index){
        return By.xpath("(//div[@class='navigation']//parent::div//c-wwp-card-event//div[@class='description'])["+index+"]");
    }
//    public static By eventDate(int index){
//        return By.xpath("(//div[@class='navigation']//parent::div//c-wwp-card-event//div[@class='date-wrapper'])["+index+"]");
//    }

    public static By eventDate = By.xpath("//div[@class='navigation']//parent::div//c-wwp-card-event//div[@class='date-wrapper']");

    public static By eventTime(int index){
        return By.xpath("(//div[@class='navigation']//parent::div//c-wwp-card-event//div[@class='time'])["+index+"]");
    }




    public static By eventImage = By.xpath("//img[@class='ImgResponsive cover hideAltText']");


    public static By category(String category){
        return By.xpath("//div[text()='"+category+"']");
    }
    public  static  By showMore = By.xpath("//button[text()='Show more']");



    public  static  By shareBtn = By.xpath("//span[text()='Share']");

    public  static  By eventHeadline = By.xpath("//h1//div[@class='content']");

    public  static  By eventDes = By.xpath("(//div[@class='content'])[2]");

    public  static  By eventDateAndTime = By.xpath("//div[@class='event-date ng-star-inserted']");

    public  static  By eventStartDate= By.xpath("//div[@class='start-date showIcon ng-star-inserted']/span");

    public  static  By eventEndDate= By.xpath("//div[@class='end-date showIcon ng-star-inserted']/span");

    public  static  By eventDescriptionMessage = By.xpath("(//div[@class='description'])[1]");


    public  static  By eventTimeMessage = By.xpath("(//div[@class='time'])[1]");


    public  static  By eventDateMessage = By.xpath("(//div[@class='date-wrapper'])[1]");
    public static  By registerBtn = By.xpath("(//span[text()='Register'])[1]");

    public static By description = By.xpath("//bt-rich-text[@class='bt-rich-text']/div/p");



    public static  By copyLinkUnderShare = By.xpath("//div[@title='Copy Link']");
    public static  By textUnderShare = By.xpath("//input[@placeholder='Search']");
    public static  By searchUnderShare = By.xpath("//button[@type='submit']");

// Service Locator

    public static By youMayBeInterestedSection= By.xpath("//div[@class='related-service-offerings']");
    public static By serviceFirstLink = By.xpath("(//c-wwp-card-service-offering//a[@class='title'])[1]");

    public static By servicePageTitle = By.xpath("//div[@class='title']");

    public static By requestInfoButton = By.xpath("//button[@class='action action-req']");

    public static By imageOnLatestSharedServiceInbox = By.xpath("(//div[@class='message'])[1]//div[@class='image-wrapper']");

    public static By nameOnLatestSharedServiceInbox = By.xpath("(//div[@class='message'])[1]//a[@class='title']");

    public static By  DescriptionlinkLatestSharedServiceInbox = By.xpath("(//div[@class='message'])[1]//a[@class='title']");

}
