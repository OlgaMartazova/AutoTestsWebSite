package com.example.fanfics.helpers;

import com.example.fanfics.ApplicationManager;
import com.example.fanfics.base.HelperBase;
import com.example.fanfics.settings.Settings;
import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {
    public void openHomePage() {
        driver.get(Settings.getBaseUrl());
    }

    private String baseUrl;

    public NavigationHelper(ApplicationManager applicationManager, String baseUrl) {
        super(applicationManager);
        this.baseUrl = baseUrl;
    }

    public void openProfilePage() {
        driver.findElement(By.xpath("//div[@id='site-content-right']/ul/li/a")).click();
        driver.get("https://fanfics.me/user801619");
    }

}
