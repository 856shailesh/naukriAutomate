package com.naukri.tests;

import com.naukri.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProfilePageTest extends BaseTest{
    @BeforeClass
    public void profilePageSetup() {
        homePage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
        profilePage = homePage.doCompleteProfile();
    }

    @Test
    public void profilePageTitleTest() {
        String title = profilePage.getProfilePageTitle();
        System.out.println("Profile page title is : " + title);
        Assert.assertEquals(title, Constants.PROFILE_PAGE_TITLE);
    }

    @Test
    public void profilePageEditTest(){
        profilePage.editResumeHeadline();
        System.out.println("Profile Page Resume Edited");
    }

    @Test
    public void profilePageLogout(){
        profilePage.doLogout();
        System.out.println("Logged Out");
    }

}
