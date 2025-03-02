package com.naukri.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naukri.utils.Constants;
import com.naukri.utils.ElementUtil;

public class LoginPage {
    private WebDriver driver;
    private ElementUtil elementUtil;

    // 1. By locator:
    private By LoginBtn = By.id("login_Layer");
    private By emailId = By.xpath("//div[@class='form-row']/input[@type='text']");
    private By password = By.xpath("//input[@type='password']");
    private By ClickloginBtn = By.xpath("//button[@type='submit']");
    private By forgotPwdLink = By.linkText("Forgotten Password");

    // 2. constructor:
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(this.driver);
    }

    // 3. page actions:
    public String getLoginPageTitle() {
        return elementUtil.waitForTitleIs(Constants.LOGIN_PAGE_TITLE, 5);
    }

    public boolean isForgotPwdLinkExist() {
        return elementUtil.doIsDisplayed(forgotPwdLink);
    }

    public HomePage doLogin(String un, String pwd)  {
        elementUtil.doPresenceOfElementLocated(LoginBtn,5).click();
        System.out.println("login with : " + un + " : " + pwd);
        elementUtil.isElementVisible(emailId,10);
        elementUtil.doSendKeys(emailId, un);
        elementUtil.doSendKeys(password, pwd);
        elementUtil.doClick(ClickloginBtn);
        return new HomePage(driver);
    }

}
