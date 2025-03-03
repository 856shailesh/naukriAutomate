package com.naukri.factory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    public WebDriver driver;
    public Properties prop;
    public OptionsManager optionsManager;
    public static String highlight;

    public WebDriver init_driver(Properties prop) {

        String browserName = prop.getProperty("browser");
        System.out.println("browser name is : " + browserName);
        optionsManager = new OptionsManager(prop);
        highlight = prop.getProperty("highlight");

        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(optionsManager.getChromeOptions());
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
        }
        else if (browserName.equals("safari")) {
            driver = new SafariDriver();
        }
        else {
            System.out.println("Please pass the right brower: " + browserName);
        }

        driver.get(prop.getProperty("url"));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        return driver;

    }

    /**
     * this is used to initialize the prop from config file envName = qa/stage/dev
     *
     * @return
     */
    public Properties init_prop() {
        prop = new Properties();
        FileInputStream ip = null;
        String envName = System.getProperty("env");

        if (envName == null) {
            System.out.println("Running on PROD env");
            try {
                ip = new FileInputStream("./src/test/resources/configs/config.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Running on environment: " + envName);
            try {
                switch (envName) {
                    case "qa":
                        ip = new FileInputStream("./src/test/resources/configs/config.properties");
                        break;
                    case "stage":
                        ip = new FileInputStream("./src/test/resources/configs/stage.config.properties");
                        break;
                    case "dev":
                        ip = new FileInputStream("./src/test/resources/configs/dev.config.properties");
                        break;
                    default:
                        break;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        try {
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }
}
