package com.naukri.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.naukri.utils.Constants;

public class LoginPageTest extends BaseTest{

    @Test
    public void loginPageTitleTest() {
        String title = loginPage.getLoginPageTitle();
        System.out.println("login page title is : " + title);
        Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
    }
    /*
    @Test
    public void forgotPwdLinkTest() {
        Assert.assertTrue(loginPage.isForgotPwdLinkExist());
    }
    */
    @Test
    public void loginTest() {
        homePage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
        Assert.assertEquals(homePage.getAccountPageTitle(), Constants.HOME_PAGE_TITLE);
    }



}
