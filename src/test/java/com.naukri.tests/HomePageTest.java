package com.naukri.tests;
import java.util.List;

import com.naukri.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.naukri.utils.Constants;


public class HomePageTest extends BaseTest{
    @BeforeClass
    public void accPageSetup() {
        homePage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
    }

    @Test
    public void accPageTitleTest() {
        String title = homePage.getAccountPageTitle();
        System.out.println("acc page title is : " + title);
        Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
    }

    @Test
    public void accPageSectionsListTest() {
        List<String> actualSecList = homePage.getAccountSecList();
        System.out.println("Acc secs : " + actualSecList);
        Assert.assertEquals(actualSecList, Constants.getExpectedAccSecList());
    }

    @Test
    public void searchExistTest() {
        Assert.assertTrue(homePage.isSearchExist());
        System.out.println("Search Exist");
    }

    @Test
    public ProfilePage homePageTest() {
        profilePage = homePage.doCompleteProfile();
        Assert.assertEquals(homePage.getAccountPageTitle(), Constants.HOME_PAGE_TITLE);
        return new ProfilePage(driver);
    }

}