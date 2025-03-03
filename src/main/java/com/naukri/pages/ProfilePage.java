package com.naukri.pages;

import com.naukri.utils.Constants;
import com.naukri.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    private WebDriver driver;
    private ElementUtil elementUtil;

    //Private By locators
    private By editResumeHeadline = By.xpath("//span[text()='Resume headline']/parent::div/span[@class='edit icon']");
    private By fillHeadline = By.xpath("//textarea[@id='resumeHeadlineTxt']");
    private By savefillHeadlineBtn = By.xpath("//button[@type='submit']");
    private By profileDropdown = By.xpath("//div[@class='nI-gNb-drawer__bars']");
    private By logoutBtn = By.xpath("//a[@title='Logout']");

    //Constructor
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    //Action Class
    public String getProfilePageTitle() {
        return elementUtil.waitForTitleIs(Constants.PROFILE_PAGE_TITLE, 5);
    }

    public void editResumeHeadline(){
        elementUtil.isElementVisible(editResumeHeadline,5);
        elementUtil.implicitWait(10);
        elementUtil.doClick(editResumeHeadline);
        elementUtil.doClear(fillHeadline);
        elementUtil.doSendKeys(fillHeadline,"Test lookin in Banglore & Noida");
        elementUtil.doClick(savefillHeadlineBtn);
    }

    public void doLogout(){
        elementUtil.implicitWait(5);
        elementUtil.doClick(profileDropdown);
        elementUtil.doClick(logoutBtn);
    }

}
