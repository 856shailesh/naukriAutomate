package com.naukri.tests;

import java.util.Properties;
import com.naukri.pages.HomePage;
import com.naukri.pages.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.naukri.factory.DriverFactory;
import com.naukri.pages.LoginPage;

public class BaseTest {
    public WebDriver driver;
    public DriverFactory driverFactory;
    public Properties prop;
    public LoginPage loginPage;
    public HomePage homePage;
    public ProfilePage profilePage;

    @BeforeTest
    public void setUp() {
        driverFactory = new DriverFactory();
        prop = driverFactory.init_prop();
        driver = driverFactory.init_driver(prop);
        loginPage = new LoginPage(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
