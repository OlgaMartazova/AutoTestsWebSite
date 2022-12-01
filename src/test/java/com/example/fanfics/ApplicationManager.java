package com.example.fanfics;

import com.example.fanfics.helpers.LoginHelper;
import com.example.fanfics.helpers.NavigationHelper;
import com.example.fanfics.helpers.PostHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    private final JavascriptExecutor js;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    private NavigationHelper navigationHelper;
    private LoginHelper loginHelper;
    private PostHelper postHelper;

    private static final ThreadLocal<ApplicationManager> app = new ThreadLocal<>();

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public PostHelper getPostHelper() {
        return postHelper;
    }

    public void stop() {
        driver.quit();
    }

    private ApplicationManager() {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.setProperty("webdriver.chrome.driver", "/Users/olga/Documents/ChromeDriver/chromedriver");
        this.driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        this.baseUrl = "https://www.google.com/";
        this.verificationErrors = new StringBuffer();
        this.navigationHelper = new NavigationHelper(this, baseUrl);
        this.loginHelper = new LoginHelper(this);
        this.postHelper = new PostHelper(this);
    }

    public static ApplicationManager getInstance() {
        if (app.get() == null) {
            ApplicationManager newInstance = new ApplicationManager();
            app.set(newInstance);
        }
        return app.get();
    }
}
