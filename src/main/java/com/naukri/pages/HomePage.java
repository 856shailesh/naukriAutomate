package com.naukri.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naukri.utils.Constants;
import com.naukri.utils.ElementUtil;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private ElementUtil elementUtil;

    private By logo = By.xpath("//a[@class='nI-gNb-header__logo nI-gNb-company-logo']//img[@alt='Naukri Logo']");
    private By header = By.xpath("//nav/ul/li/a/div");
    private By search = By.xpath("//div/div/span[@class='nI-gNb-sb__placeholder']");
    private By completeProfile = By.xpath("//a[normalize-space()='Complete profile']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(this.driver);
    }

    public String getAccountPageTitle() {
        return elementUtil.waitForTitleIs(Constants.HOME_PAGE_TITLE, 5);
    }

    public String getAccountsPageHeader() {
        return elementUtil.doGetText(header);
    }


    public List<String> getAccountSecList() {
        List<WebElement> accSecList = elementUtil.waitForElementsToBeVisible(header, 5);
        List<String> accSecValList = new ArrayList<String>();
        for (WebElement e : accSecList) {
            accSecValList.add(e.getText());
        }
        return accSecValList;
    }

    public boolean isSearchExist() {
        return elementUtil.doIsDisplayed(search);
    }

    public ProfilePage doCompleteProfile()  {
        elementUtil.waitForElementWithFluentWait(completeProfile,10,1);
        //elementUtil.doClick(completeProfile);
        //elementUtil.vefiyElementPresent(completeProfile);
        elementUtil.implicitWait(5);
        System.out.println("Element is present");
        elementUtil.doClick(completeProfile);
        System.out.println("Clicked on Complete Profile");
        return new ProfilePage(driver);
    }
}
