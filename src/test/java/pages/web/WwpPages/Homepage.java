package pages.web.WwpPages;

import org.openqa.selenium.By;

public class Homepage {

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
}
